/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.koentus.world.gen;

import micdoodle8.mods.galacticraft.core.world.gen.dungeon.MapGenDungeon;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.util.BlockPos;
import net.minecraft.world.ChunkCoordIntPair;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import stevekung.mods.moreplanets.common.world.gen.ChunkProviderBaseMP;
import stevekung.mods.moreplanets.common.world.gen.MapGenCavesMP;
import stevekung.mods.moreplanets.common.world.gen.dungeon.RoomEmptyMP;
import stevekung.mods.moreplanets.common.world.gen.dungeon.RoomSpawnerMP;
import stevekung.mods.moreplanets.common.world.gen.dungeon.RoomTreasureEmptyMP;
import stevekung.mods.moreplanets.moons.koentus.blocks.KoentusBlocks;
import stevekung.mods.moreplanets.moons.koentus.world.gen.dungeon.RoomBossKoentus;
import stevekung.mods.moreplanets.moons.koentus.world.gen.dungeon.RoomChestsKoentus;

public class ChunkProviderKoentus extends ChunkProviderBaseMP
{
    private BiomeGenBase[] biomesForGeneration = { BiomeGenBaseKoentus.baseMoonBiome };
    private BiomeDecoratorKoentus biomeDecorator = new BiomeDecoratorKoentus();
    private MapGenCavesMP caveGenerator = new MapGenCavesMP(KoentusBlocks.koentus_block, this.getBlockMetadata());
    private MapGenKoentusVillage villageGenerator = new MapGenKoentusVillage();

    private MapGenDungeon dungeonGenerator = new MapGenDungeon(KoentusBlocks.koentus_block, 11, 8, 24, 4);
    {
        this.dungeonGenerator.otherRooms.add(new RoomEmptyMP(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomChestsKoentus(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomChestsKoentus(null, 0, 0, 0, null));
        this.dungeonGenerator.otherRooms.add(new RoomChestsKoentus(null, 0, 0, 0, null));
        this.dungeonGenerator.bossRooms.add(new RoomBossKoentus(null, 0, 0, 0, null));
        this.dungeonGenerator.treasureRooms.add(new RoomTreasureEmptyMP(null, 0, 0, 0, null));
    }

    public ChunkProviderKoentus(World world, long seed, boolean genFeature)
    {
        super(world, seed, genFeature);
    }

    @Override
    public Chunk provideChunk(int chunkX, int chunkZ)
    {
        ChunkPrimer primer = new ChunkPrimer();
        this.rand.setSeed(chunkX * 341873128712L + chunkZ * 132897987541L);
        this.generateTerrain(chunkX, chunkZ, primer);
        this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, chunkX * 16, chunkZ * 16, 16, 16);
        this.createCraters(chunkX, chunkZ, primer);
        this.replaceBlocksForBiome(chunkX, chunkZ, primer, this.biomesForGeneration);
        this.caveGenerator.generate(this, this.worldObj, chunkX, chunkZ, primer);
        this.villageGenerator.generateStructure(worldObj, rand, new ChunkCoordIntPair(chunkX, chunkZ));
        this.dungeonGenerator.generateUsingArrays(this.worldObj, this.worldObj.getSeed(), chunkX * 16, 25, chunkZ * 16, chunkX, chunkZ, primer);
        Chunk chunk = new Chunk(this.worldObj, primer, chunkX, chunkZ);
        chunk.generateSkylightMap();
        return chunk;
    }

    @Override
    public void populate(IChunkProvider chunk, int chunkX, int chunkZ)
    {
        BlockFalling.fallInstantly = true;
        int x = chunkX * 16;
        int z = chunkZ * 16;
        BlockPos pos = new BlockPos(x, 0, z);
        this.worldObj.getBiomeGenForCoords(pos.add(16, 0, 16));
        this.rand.setSeed(this.worldObj.getSeed());
        long var7 = this.rand.nextLong() / 2L * 2L + 1L;
        long var9 = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed(chunkX * var7 + chunkZ * var9 ^ this.worldObj.getSeed());
        this.dungeonGenerator.handleTileEntities(this.rand);
        this.biomeDecorator.decorate(this.worldObj, this.rand, BiomeGenBaseKoentus.baseMoonBiome, pos);
        BlockFalling.fallInstantly = false;
    }

    @Override
    public void recreateStructures(Chunk chunk, int chunkX, int chunkZ)
    {
        this.villageGenerator.generate(this, this.worldObj, chunkX, chunkZ, (ChunkPrimer) null);
    }

    @Override
    protected String getName()
    {
        return "Koentus";
    }

    @Override
    protected Block getBaseBlock()
    {
        return KoentusBlocks.koentus_block;
    }

    @Override
    protected int[] getBlockMetadata()
    {
        return new int[] { 0, 1, 2 };
    }

    @Override
    protected int getCraterChance()
    {
        return 100;
    }
}