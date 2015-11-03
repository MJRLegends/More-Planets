/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.kapteynb.blocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.oredict.OreDictionary;
import stevekung.mods.moreplanets.common.blocks.BlockStairsMP;
import stevekung.mods.moreplanets.common.blocks.fluid.FluidMP;
import stevekung.mods.moreplanets.planets.kapteynb.fluids.BlockFluidFrozenWater;
import stevekung.mods.moreplanets.planets.kapteynb.itemblocks.ItemBlockIcyPoisonCrystal;
import stevekung.mods.moreplanets.planets.kapteynb.itemblocks.ItemBlockKapteynB;
import stevekung.mods.moreplanets.planets.kapteynb.itemblocks.ItemBlockKapteynBIce;
import stevekung.mods.moreplanets.planets.kapteynb.itemblocks.ItemBlockUraniumWaste;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class KapteynBBlocks
{
	public static Block kapteyn_b_block;
	public static Block kapteyn_b_redstone_ore;
	public static Block kapteyn_b_redstone_ore_active;
	public static Block kapteyn_b_ice;
	public static Block kapteyn_b_treasure_chest;
	public static Block kapteyn_b_cracked_ice_stairs;
	public static Block kapteyn_b_dungeon_brick_stairs;
	public static Block frozen_water;
	public static Block rocky_solid_water;
	public static Block uranium_waste;
	public static Block kapteyn_b_ancient_chest;
	public static Block uranium_bomb;
	public static Block fallen_ice_crystal_meteor;
	public static Block frozen_water_geyser;
	public static Block icy_poison_crystal;

	public static Fluid frozen_water_fluid;

	public static void init()
	{
		// Init
		KapteynBBlocks.kapteyn_b_block = new BlockKapteynB("kapteyn_b_block");
		KapteynBBlocks.kapteyn_b_redstone_ore = new BlockKapteynBRedstoneOre("kapteyn_b_redstone_ore", false);
		KapteynBBlocks.kapteyn_b_redstone_ore_active = new BlockKapteynBRedstoneOre("kapteyn_b_redstone_ore_active", true);
		KapteynBBlocks.kapteyn_b_ice = new BlockKapteynBIce("kapteyn_b_ice");
		KapteynBBlocks.kapteyn_b_treasure_chest = new BlockKapteynBTreasureChest("kapteyn_b_treasure_chest");
		KapteynBBlocks.kapteyn_b_cracked_ice_stairs = new BlockStairsMP(Blocks.stone.getDefaultState(), "kapteyn_b_cracked_ice_stairs", "glass", null, 3.25F);
		KapteynBBlocks.kapteyn_b_dungeon_brick_stairs = new BlockStairsMP(Blocks.stone.getDefaultState(), "kapteyn_b_dungeon_brick_stairs", 4.0F);
		KapteynBBlocks.rocky_solid_water = new BlockRockySolidWater("rocky_solid_water");
		KapteynBBlocks.kapteyn_b_ancient_chest = new BlockKapteynBAncientChest("kapteyn_b_ancient_chest");
		KapteynBBlocks.uranium_waste = new BlockUraniumWaste("uranium_waste");
		KapteynBBlocks.uranium_bomb = new BlockUraniumBomb("uranium_bomb");
		KapteynBBlocks.fallen_ice_crystal_meteor = new BlockFallenIceCrystalMeteor("fallen_ice_crystal_meteor");
		KapteynBBlocks.frozen_water_geyser = new BlockFrozenWaterGeyser("frozen_water_geyser");
		KapteynBBlocks.icy_poison_crystal = new BlockIcyPoisonCrystal("icy_poison_crystal");

		KapteynBBlocks.frozen_water_fluid = new FluidMP("frozen_water_fluid").setBlock(KapteynBBlocks.frozen_water);
		FluidRegistry.registerFluid(KapteynBBlocks.frozen_water_fluid);
		KapteynBBlocks.frozen_water = new BlockFluidFrozenWater("frozen_water_fluid");

		// Register
		CommonRegisterHelper.registerBlock(KapteynBBlocks.kapteyn_b_block, ItemBlockKapteynB.class);
		CommonRegisterHelper.registerBlock(KapteynBBlocks.kapteyn_b_redstone_ore);
		CommonRegisterHelper.registerBlock(KapteynBBlocks.kapteyn_b_redstone_ore_active);
		CommonRegisterHelper.registerBlock(KapteynBBlocks.rocky_solid_water);
		CommonRegisterHelper.registerBlock(KapteynBBlocks.frozen_water_geyser);
		CommonRegisterHelper.registerBlock(KapteynBBlocks.kapteyn_b_ice, ItemBlockKapteynBIce.class);
		CommonRegisterHelper.registerBlock(KapteynBBlocks.uranium_bomb);
		CommonRegisterHelper.registerBlock(KapteynBBlocks.kapteyn_b_treasure_chest);
		CommonRegisterHelper.registerBlock(KapteynBBlocks.kapteyn_b_ancient_chest);
		CommonRegisterHelper.registerBlock(KapteynBBlocks.kapteyn_b_cracked_ice_stairs);
		CommonRegisterHelper.registerBlock(KapteynBBlocks.kapteyn_b_dungeon_brick_stairs);
		CommonRegisterHelper.registerBlock(KapteynBBlocks.fallen_ice_crystal_meteor);
		CommonRegisterHelper.registerBlock(KapteynBBlocks.uranium_waste, ItemBlockUraniumWaste.class);
		CommonRegisterHelper.registerBlock(KapteynBBlocks.icy_poison_crystal, ItemBlockIcyPoisonCrystal.class);
		CommonRegisterHelper.registerBlock(KapteynBBlocks.frozen_water);

		// Set harvest level
		((BlockKapteynB)KapteynBBlocks.kapteyn_b_block).setHarvestLevel("shovel", 0, 0);
		((BlockKapteynB)KapteynBBlocks.kapteyn_b_block).setHarvestLevel("shovel", 0, 1);
		((BlockKapteynB)KapteynBBlocks.kapteyn_b_block).setHarvestLevel("pickaxe", 0, 2);
		((BlockKapteynB)KapteynBBlocks.kapteyn_b_block).setHarvestLevel("pickaxe", 0, 3);
		((BlockKapteynB)KapteynBBlocks.kapteyn_b_block).setHarvestLevel("pickaxe", 0, 4);
		((BlockKapteynB)KapteynBBlocks.kapteyn_b_block).setHarvestLevel("pickaxe", 0, 5);
		((BlockKapteynB)KapteynBBlocks.kapteyn_b_block).setHarvestLevel("pickaxe", 0, 6);
		((BlockKapteynB)KapteynBBlocks.kapteyn_b_block).setHarvestLevel("pickaxe", 0, 7);
		((BlockKapteynB)KapteynBBlocks.kapteyn_b_block).setHarvestLevel("pickaxe", 0, 8);
		((BlockKapteynB)KapteynBBlocks.kapteyn_b_block).setHarvestLevel("pickaxe", 0, 9);
		((BlockKapteynB)KapteynBBlocks.kapteyn_b_block).setHarvestLevel("pickaxe", 0, 10);
		((BlockKapteynB)KapteynBBlocks.kapteyn_b_block).setHarvestLevel("pickaxe", 0, 11);
		((BlockKapteynB)KapteynBBlocks.kapteyn_b_block).setHarvestLevel("pickaxe", 0, 12);
		KapteynBBlocks.frozen_water_geyser.setHarvestLevel("pickaxe", 0);
		KapteynBBlocks.kapteyn_b_redstone_ore.setHarvestLevel("pickaxe", 2);
		KapteynBBlocks.kapteyn_b_redstone_ore_active.setHarvestLevel("pickaxe", 2);
		KapteynBBlocks.kapteyn_b_cracked_ice_stairs.setHarvestLevel("pickaxe", 0);
		KapteynBBlocks.kapteyn_b_dungeon_brick_stairs.setHarvestLevel("pickaxe", 0);
		KapteynBBlocks.rocky_solid_water.setHarvestLevel("shovel", 0);
		KapteynBBlocks.kapteyn_b_ancient_chest.setHarvestLevel("axe", 0);

		// Register ore dictionary
		OreDictionary.registerOre("oreNamerium", new ItemStack(KapteynBBlocks.kapteyn_b_block, 1, 4));
		OreDictionary.registerOre("oreFrozenIron", new ItemStack(KapteynBBlocks.kapteyn_b_block, 1, 5));
		OreDictionary.registerOre("oreUranium", new ItemStack(KapteynBBlocks.kapteyn_b_block, 1, 6));
		OreDictionary.registerOre("oreTin", new ItemStack(KapteynBBlocks.kapteyn_b_block, 1, 7));
		OreDictionary.registerOre("oreCopper", new ItemStack(KapteynBBlocks.kapteyn_b_block, 1, 8));
		OreDictionary.registerOre("oreRedstone", new ItemStack(KapteynBBlocks.kapteyn_b_redstone_ore));

		OreDictionary.registerOre("blockNamerium", new ItemStack(KapteynBBlocks.kapteyn_b_block, 1, 9));
		OreDictionary.registerOre("blockFrozenIron", new ItemStack(KapteynBBlocks.kapteyn_b_block, 1, 10));
		OreDictionary.registerOre("blockUranium", new ItemStack(KapteynBBlocks.kapteyn_b_block, 1, 11));
	}
}