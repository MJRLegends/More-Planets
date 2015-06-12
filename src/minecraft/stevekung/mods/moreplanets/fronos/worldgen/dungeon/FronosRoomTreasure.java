/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.fronos.worldgen.dungeon;

import java.util.ArrayList;
import java.util.Random;

import micdoodle8.mods.galacticraft.core.world.gen.dungeon.GCCoreDungeonBoundingBox;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.GCCoreDungeonRoom;
import micdoodle8.mods.galacticraft.core.world.gen.dungeon.GCCoreMapGenDungeon;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.ForgeDirection;
import stevekung.mods.moreplanets.fronos.blocks.FronosBlocks;
import stevekung.mods.moreplanets.fronos.items.FronosItems;
import stevekung.mods.moreplanets.fronos.tileentities.FronosTileEntityTreasureChest;

public class FronosRoomTreasure extends GCCoreDungeonRoom
{
	int sizeX;
	int sizeY;
	int sizeZ;

	private final ArrayList<ChunkCoordinates> chests = new ArrayList<ChunkCoordinates>();

	public FronosRoomTreasure(GCCoreMapGenDungeon dungeon, int posX, int posY, int posZ, ForgeDirection entranceDir)
	{
		super(dungeon, posX, posY, posZ, entranceDir);
		if (this.worldObj != null)
		{
			final Random rand = new Random(this.worldObj.getSeed() * posX * posY * 57 * posZ);
			this.sizeX = rand.nextInt(6) + 7;
			this.sizeY = rand.nextInt(2) + 5;
			this.sizeZ = rand.nextInt(6) + 7;
		}
	}

	@Override
	public void generate(short[] chunk, byte[] meta, int cx, int cz)
	{
		for (int i = this.posX - 1; i <= this.posX + this.sizeX; i++)
		{
			for (int k = this.posZ - 1; k <= this.posZ + this.sizeZ; k++)
			{
				for (int j = this.posY - 1; j <= this.posY + this.sizeY; j++)
				{
					if (i == this.posX - 1 || i == this.posX + this.sizeX || j == this.posY - 1 || j == this.posY + this.sizeY || k == this.posZ - 1 || k == this.posZ + this.sizeZ)
					{
						this.placeBlock(chunk, meta, i, j, k, cx, cz, this.dungeonInstance.DUNGEON_WALL_ID, this.dungeonInstance.DUNGEON_WALL_META);
					}
					else
					{
						if ((i == this.posX || i == this.posX + this.sizeX - 1) && (k == this.posZ || k == this.posZ + this.sizeZ - 1))
						{
							this.placeBlock(chunk, meta, i, j, k, cx, cz, Block.glowStone.blockID, 0);
						}
						else
						{
							this.placeBlock(chunk, meta, i, j, k, cx, cz, 0, 0);
						}
					}
				}
			}
		}
		final int hx = (this.posX + this.posX + this.sizeX) / 2;
		final int hz = (this.posZ + this.posZ + this.sizeZ) / 2;
		if (this.placeBlock(chunk, meta, hx, this.posY, hz, cx, cz, FronosBlocks.fronosTreasureChest.blockID, 0))
		{
			this.chests.add(new ChunkCoordinates(hx, this.posY, hz));
		}
	}

	@Override
	public GCCoreDungeonBoundingBox getBoundingBox()
	{
		return new GCCoreDungeonBoundingBox(this.posX, this.posZ, this.posX + this.sizeX, this.posZ + this.sizeZ);
	}

	public ItemStack getGuaranteedLoot(Random rand)
	{
		switch (rand.nextInt(1))
		{
		case 0:
			return new ItemStack(FronosBlocks.candyExtractorIdle, 1, 0);
		case 1:
			return new ItemStack(FronosItems.cup, 1, 1);
		case 2:
			return new ItemStack(FronosItems.cup, 1, 2);
		case 3:
			return new ItemStack(FronosItems.greenTopazBucket, 1, 1);
		case 4:
			return new ItemStack(FronosItems.greenTopazBucket, 1, 3);
		}
		return null;
	}

	@Override
	protected void handleTileEntities(Random rand)
	{
		for (final ChunkCoordinates chestCoords : this.chests)
		{
			final TileEntity chest = this.worldObj.getBlockTileEntity(chestCoords.posX, chestCoords.posY, chestCoords.posZ);

			if (chest != null && chest instanceof FronosTileEntityTreasureChest)
			{
				ChestGenHooks info = ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST);

				WeightedRandomChestContent.generateChestContents(rand, info.getItems(rand), (FronosTileEntityTreasureChest) chest, info.getCount(rand));

				((FronosTileEntityTreasureChest) chest).setInventorySlotContents(rand.nextInt(((FronosTileEntityTreasureChest) chest).getSizeInventory()), this.getGuaranteedLoot(rand));
			}
		}
	}

	@Override
	protected GCCoreDungeonRoom makeRoom(GCCoreMapGenDungeon dungeon, int x, int y, int z, ForgeDirection dir)
	{
		return new FronosRoomTreasure(dungeon, x, y, z, dir);
	}
}