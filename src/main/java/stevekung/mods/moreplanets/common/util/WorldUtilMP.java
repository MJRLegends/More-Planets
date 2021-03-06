/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.play.server.S07PacketRespawn;
import net.minecraft.network.play.server.S1DPacketEntityEffect;
import net.minecraft.network.play.server.S1FPacketSetExperience;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class WorldUtilMP
{
    public static boolean isSpaceWorld(World world, WorldProvider provider)
    {
        return world.provider.getClass() == provider.getClass();
    }

    public static Entity setHomePlanetDimension(Entity entity, int dimID, WorldServer world)
    {
        if (!world.isRemote)
        {
            MinecraftServer mcServer = FMLCommonHandler.instance().getMinecraftServerInstance();

            if (mcServer != null)
            {
                WorldServer worldServer = mcServer.worldServerForDimension(dimID);

                if (worldServer == null)
                {
                    MPLog.error("Cannot Transfer Entity to Dimension: Could not get World for Dimension " + dimID);
                    return null;
                }
                return WorldUtilMP.teleportEntity(worldServer, entity, dimID);
            }
        }
        return null;
    }

    private static Entity teleportEntity(World worldNew, Entity entity, int dimID)
    {
        BlockPos blockpos = ((WorldServer) worldNew).getTopSolidOrLiquidBlock(((WorldServer) worldNew).getSpawnPoint());
        boolean dimChange = entity.worldObj != worldNew;
        entity.worldObj.updateEntityWithOptionalForce(entity, false);
        EntityPlayerMP player = null;
        int oldDimID = entity.worldObj.provider.getDimensionId();

        if (dimChange)
        {
            if (entity instanceof EntityPlayerMP)
            {
                player = (EntityPlayerMP) entity;
                World worldOld = player.worldObj;

                player.dimension = dimID;
                player.playerNetServerHandler.sendPacket(new S07PacketRespawn(dimID, player.worldObj.getDifficulty(), player.worldObj.getWorldInfo().getTerrainType(), player.theItemInWorldManager.getGameType()));
                worldOld.playerEntities.remove(player);
                worldOld.updateAllPlayersSleepingFlag();

                if (player.addedToChunk && worldOld.getChunkProvider().chunkExists(player.chunkCoordX, player.chunkCoordZ))
                {
                    Chunk chunkOld = worldOld.getChunkFromChunkCoords(player.chunkCoordX, player.chunkCoordZ);
                    chunkOld.removeEntity(player);
                    chunkOld.setModified(true);
                }

                worldOld.loadedEntityList.remove(player);
                worldOld.onEntityRemoved(player);
                worldNew.spawnEntityInWorld(entity);
                entity.setWorld(worldNew);

                ChunkCoordIntPair pair = worldNew.getChunkFromChunkCoords(blockpos.getX(), blockpos.getZ()).getChunkCoordIntPair();
                ((WorldServer) worldNew).theChunkProviderServer.loadChunk(pair.chunkXPos, pair.chunkZPos);
                worldNew.updateEntityWithOptionalForce(entity, false);
                entity.moveToBlockPosAndAngles(blockpos, entity.rotationYaw, entity.rotationPitch);

                player.mcServer.getConfigurationManager().func_72375_a(player, (WorldServer) worldNew);
                player.playerNetServerHandler.setPlayerLocation(blockpos.getX(), blockpos.getY(), blockpos.getZ(), entity.rotationYaw, entity.rotationPitch);

                MPLog.info("Server attempting to transfer player " + player.getGameProfile().getName() + " to dimension " + worldNew.provider.getDimensionId());

                player.theItemInWorldManager.setWorld((WorldServer) worldNew);
                player.mcServer.getConfigurationManager().updateTimeAndWeatherForPlayer(player, (WorldServer) worldNew);
                player.mcServer.getConfigurationManager().syncPlayerInventory(player);

                for (Object o : player.getActivePotionEffects())
                {
                    PotionEffect potion = (PotionEffect) o;
                    player.playerNetServerHandler.sendPacket(new S1DPacketEntityEffect(player.getEntityId(), potion));
                }
                player.playerNetServerHandler.sendPacket(new S1FPacketSetExperience(player.experience, player.experienceTotal, player.experienceLevel));
            }
        }
        else
        {
            if (entity instanceof EntityPlayerMP)
            {
                player = (EntityPlayerMP) entity;
                worldNew.updateEntityWithOptionalForce(entity, false);
                player.playerNetServerHandler.setPlayerLocation(blockpos.getX(), blockpos.getY(), blockpos.getZ(), entity.rotationYaw, entity.rotationPitch);
                entity.moveToBlockPosAndAngles(blockpos, entity.rotationYaw, entity.rotationPitch);
                worldNew.updateEntityWithOptionalForce(entity, false);
                MPLog.info("Server attempting to transfer player " + player.getGameProfile().getName() + " within same dimension " + worldNew.provider.getDimensionId());
            }
        }

        if (blockpos != null)
        {
            entity.moveToBlockPosAndAngles(blockpos, entity.rotationYaw, entity.rotationPitch);
        }
        if (entity instanceof EntityPlayerMP)
        {
            FMLCommonHandler.instance().firePlayerChangedDimensionEvent((EntityPlayerMP) entity, oldDimID, dimID);
        }
        return entity;
    }
}