/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.diona.world.gen;

import java.util.ArrayList;
import java.util.List;

import micdoodle8.mods.galacticraft.core.world.gen.dungeon.MapGenDungeon;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import stevekung.mods.moreplanets.common.world.gen.ChunkProviderBaseMP;
import stevekung.mods.moreplanets.common.world.gen.MapGenCavesMP;
import stevekung.mods.moreplanets.common.world.gen.dungeon.RoomEmptyMP;
import stevekung.mods.moreplanets.common.world.gen.dungeon.RoomSpawnerMP;
import stevekung.mods.moreplanets.moons.koentus.world.gen.BiomeGenBaseKoentus;
import stevekung.mods.moreplanets.planets.diona.blocks.DionaBlocks;
import stevekung.mods.moreplanets.planets.diona.entities.EntityDionaCreeperMinion;
import stevekung.mods.moreplanets.planets.diona.entities.EntitySpaceWolf;
import stevekung.mods.moreplanets.planets.diona.world.gen.dungeon.RoomBossDiona;
import stevekung.mods.moreplanets.planets.diona.world.gen.dungeon.RoomChestsDiona;
import stevekung.mods.moreplanets.planets.diona.world.gen.dungeon.RoomTreasureDiona;

public class ChunkProviderDiona extends ChunkProviderBaseMP
{
	private BiomeDecoratorDiona biomeDecorator = new BiomeDecoratorDiona();
	private BiomeGenBase[] biomesForGeneration = { BiomeGenBaseDiona.diona };
	private MapGenCavesMP caveGenerator = new MapGenCavesMP(DionaBlocks.diona_block, this.getBlockMetadata());

	private MapGenDungeon dungeonGenerator = new MapGenDungeon(DionaBlocks.diona_block, 15, 8, 16, 4);
	{
		this.dungeonGenerator.otherRooms.add(new RoomEmptyMP(null, 0, 0, 0, null));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
		this.dungeonGenerator.otherRooms.add(new RoomSpawnerMP(null, 0, 0, 0, null));
		this.dungeonGenerator.otherRooms.add(new RoomChestsDiona(null, 0, 0, 0, null));
		this.dungeonGenerator.otherRooms.add(new RoomChestsDiona(null, 0, 0, 0, null));
		this.dungeonGenerator.bossRooms.add(new RoomBossDiona(null, 0, 0, 0, null));
		this.dungeonGenerator.treasureRooms.add(new RoomTreasureDiona(null, 0, 0, 0, null));
	}

	public ChunkProviderDiona(World world, long seed, boolean genFeature)
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
		this.func_180517_a(chunkX, chunkZ, primer, this.biomesForGeneration);
		this.caveGenerator.func_175792_a(this, this.worldObj, chunkX, chunkZ, primer);
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
		this.biomeDecorator.decorate(this.worldObj, this.rand, BiomeGenBaseKoentus.koentus, pos);
		BlockFalling.fallInstantly = false;
	}

	@Override
	public List func_177458_a(EnumCreatureType type, BlockPos pos)
	{
		if (type == EnumCreatureType.MONSTER)
		{
			List monsters = new ArrayList();
			monsters.add(new SpawnListEntry(EntityDionaCreeperMinion.class, 100, 4, 4));
			return monsters;
		}
		else if (type == EnumCreatureType.CREATURE)
		{
			List creatures = new ArrayList();
			creatures.add(new SpawnListEntry(EntitySpaceWolf.class, 8, 4, 4));
			return creatures;
		}
		return super.func_177458_a(type, pos);
	}

	@Override
	protected String getName()
	{
		return "Diona";
	}

	@Override
	protected Block getBaseBlock()
	{
		return DionaBlocks.diona_block;
	}

	@Override
	protected int[] getBlockMetadata()
	{
		return new int[] { 0, 1, 2 };
	}
}