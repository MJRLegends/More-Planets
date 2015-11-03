/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.oredict.OreDictionary;
import stevekung.mods.moreplanets.common.blocks.BlockAncientChestMP;
import stevekung.mods.moreplanets.common.blocks.BlockBaseMP;
import stevekung.mods.moreplanets.common.blocks.BlockBushMP;
import stevekung.mods.moreplanets.common.blocks.BlockDoorMP;
import stevekung.mods.moreplanets.common.blocks.BlockDoorMP.DoorType;
import stevekung.mods.moreplanets.common.blocks.BlockFenceGateMP;
import stevekung.mods.moreplanets.common.blocks.BlockStairsMP;
import stevekung.mods.moreplanets.common.blocks.fluid.FluidMP;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockDirtMP;
import stevekung.mods.moreplanets.planets.fronos.fluids.BlockFluidCaramel;
import stevekung.mods.moreplanets.planets.fronos.fluids.BlockFluidCoconutMilk;
import stevekung.mods.moreplanets.planets.fronos.fluids.BlockFluidMineralWater;
import stevekung.mods.moreplanets.planets.fronos.fluids.BlockFluidOvaltine;
import stevekung.mods.moreplanets.planets.fronos.fluids.BlockFluidTea;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockCandyCane1;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockCandyCane2;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockCandyFlower;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockChocolateCreamLayer;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockCream;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockDandelion;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockFronosCloud;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockFronosColorizedLeaves;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockFronosCoral;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockFronosDoubleTallgrass;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockFronosFlower;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockFronosLeaves;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockFronosLog;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockFronosSand;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockFronosSandstone;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockFronosSandstoneSlab;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockFronosSapling;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockFronosStone;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockFronosTallGrass;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockFronosWoodenPlanks;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockFrostedCake;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockGolemCreamHead;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockJelly;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockLemonCreamLayer;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockOrangeCreamLayer;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockOreFronos;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockPoppy;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockSpaceShell;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockStrawberryCreamLayer;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockTeaCreamLayer;
import stevekung.mods.moreplanets.planets.fronos.itemblocks.ItemBlockVanillaCreamLayer;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class FronosBlocks
{
	public static Block fronos_grass;
	public static Block plains_grass;
	public static Block pink_grass;
	public static Block purple_grass;
	public static Block golden_grass;
	public static Block fronos_dirt;
	public static Block fronos_block;
	public static Block mossy_fronos_cobblestone;
	public static Block jelly_ore;
	public static Block ore_block;
	public static Block frosted_cake;
	public static Block jelly_block;
	public static Block cookie_block;
	public static Block ovaltine_block;
	public static Block chocolate_block;
	public static Block caramel_block;
	public static Block cloud_block;
	public static Block candy_cane1;
	public static Block candy_cane2;
	public static Block cream_block;
	public static Block vanilla_cream_layer;
	public static Block chocolate_cream_layer;
	public static Block strawberry_cream_layer;
	public static Block orange_cream_layer;
	public static Block tea_cream_layer;
	public static Block lemon_cream_layer;
	public static Block fronos_sand;
	public static Block cheese_glass;
	public static Block cheese_glass_pane;
	public static Block fronos_log;
	public static Block fronos_planks;
	public static Block fronos_colorized_leaves;
	public static Block fronos_leaves;
	public static Block fronos_cobblestone_stairs;
	public static Block fronos_stone_brick_stairs;
	public static Block cracked_fronos_stone_brick_stairs;
	public static Block fronos_dungeon_brick_stairs;
	public static Block coconut_wood_stairs;
	public static Block maple_wood_stairs;
	public static Block fronos_fence;
	public static Block coconut_fence_gate;
	public static Block maple_fence_gate;
	public static Block fronos_treasure_chest;
	public static BlockAncientChestMP fronos_ancient_chest;
	public static Block candy_extractor_idle;
	public static Block mineral_water_generator;
	public static Block candy_extractor_active;
	public static Block fronos_farmland;
	public static Block strawberry_bush;
	public static Block golden_crops;
	public static Block coconut_block;
	public static Block golem_cream_head;
	public static Block cake_bread;
	public static Block white_cake_bread;
	public static Block chocolate_cake_bread;
	public static Block pink_cake;
	public static Block white_cake;
	public static Block chocolate_cake;
	public static Block space_shell;
	public static Block space_oyster;
	public static Block cavern_oyster;
	public static Block jelly_slime_egg;
	public static BlockBushMP fronos_sapling;
	public static BlockBushMP fronos_tall_grass;
	public static BlockBushMP fronos_flower;
	public static BlockBushMP fronos_dandelion;
	public static BlockBushMP fronos_poppy;
	public static BlockBushMP candy_flower;
	public static BlockBushMP fronos_coral;
	public static Block cheese_web;
	public static Block glass_gem_corn;
	public static Block maple_ivy;
	public static Block pink_candy_torch;
	public static Block orange_candy_torch;
	public static Block green_candy_torch;
	public static Block yellow_candy_torch;
	public static Block light_blue_candy_torch;
	public static Block blue_candy_torch;
	public static Block red_candy_torch;
	public static Block purple_candy_torch;
	public static Block cup;
	public static Block mineral_water_cup;
	public static Block ovaltine_cup;
	public static Block coconut_milk_cup;
	public static Block cheese_of_milk_cup;
	public static Block tea_cup;
	public static Block caramel_cup;
	public static Block coconut_door_block;
	public static Block maple_door_block;
	public static Block coconut_milk;
	public static Block mineral_water;
	public static Block ovaltine;
	public static Block tea;
	public static Block caramel;
	public static Block fronos_sandstone;
	public static Block half_fronos_sandstone_slab;
	public static Block double_fronos_sandstone_slab;
	public static Block fronos_sandstone_stairs;
	public static Block white_sandstone_stairs;
	public static Block cheese_sandstone_stairs;
	public static Block fronos_double_tallgrass;
	public static Block sky_mushroom_block;

	public static Fluid coconut_milk_fluid;
	public static Fluid mineral_water_fluid;
	public static Fluid ovaltine_fluid;
	public static Fluid tea_fluid;
	public static Fluid caramel_fluid;

	public static void init()
	{
		// Init
		FronosBlocks.fronos_grass = new BlockFronosGrass("fronos_grass");
		FronosBlocks.plains_grass = new BlockPlainsGrass("plains_grass");
		FronosBlocks.pink_grass = new BlockPinkGrass("pink_grass");
		FronosBlocks.purple_grass = new BlockPurpleGrass("purple_grass");
		FronosBlocks.golden_grass = new BlockGoldenGrass("golden_grass");
		FronosBlocks.fronos_dirt = new BlockFronosDirt("fronos_dirt");
		FronosBlocks.fronos_block = new BlockFronos("fronos_block");
		FronosBlocks.mossy_fronos_cobblestone = new BlockBaseMP("mossy_fronos_cobblestone", Material.rock).setHardness(2.0F).setResistance(5.0F);
		FronosBlocks.jelly_ore = new BlockJellyOre("jelly_ore");
		FronosBlocks.ore_block = new BlockOreFronos("fronos_ore_block");
		FronosBlocks.frosted_cake = new BlockFrostedCake("frosted_cake_block");
		FronosBlocks.jelly_block = new BlockJelly("jelly_block");
		FronosBlocks.cookie_block = new BlockCookie("cookie_block");
		FronosBlocks.ovaltine_block = new BlockOvaltine("ovaltine_block");
		FronosBlocks.chocolate_block = new BlockBaseMP("chocolate_block", Material.clay).setStepSound(Block.soundTypeSnow).setHardness(0.55F);
		FronosBlocks.caramel_block = new BlockCaramel("caramel_block");
		FronosBlocks.cloud_block = new BlockFronosCloud("fronos_cloud");
		FronosBlocks.candy_cane1 = new BlockCandyCane1("candy_cane1");
		FronosBlocks.candy_cane2 = new BlockCandyCane2("candy_cane2");
		FronosBlocks.cream_block = new BlockCream("cream_block");
		FronosBlocks.vanilla_cream_layer = new BlockVanillaCreamLayer("vanilla_cream_layer");
		FronosBlocks.chocolate_cream_layer = new BlockChocolateCreamLayer("chocolate_cream_layer");
		FronosBlocks.strawberry_cream_layer = new BlockStrawberryCreamLayer("strawberry_cream_layer");
		FronosBlocks.orange_cream_layer = new BlockOrangeCreamLayer("orange_cream_layer");
		FronosBlocks.tea_cream_layer = new BlockTeaCreamLayer("tea_cream_layer");
		FronosBlocks.lemon_cream_layer = new BlockTeaCreamLayer("lemon_cream_layer");
		FronosBlocks.fronos_sand = new BlockFronosSand("fronos_sand");
		FronosBlocks.cheese_glass = new BlockCheeseGlass("cheese_glass");
		FronosBlocks.cheese_glass_pane = new BlockCheeseGlassPane("cheese_glass_pane");
		FronosBlocks.fronos_log = new BlockFronosLog("fronos_log");
		FronosBlocks.fronos_planks = new BlockFronosWoodenPlanks("fronos_planks");
		FronosBlocks.fronos_colorized_leaves = new BlockFronosColorizedLeaves("fronos_leaves");
		FronosBlocks.fronos_leaves = new BlockFronosLeaves("fronos_leaves2");
		FronosBlocks.fronos_cobblestone_stairs = new BlockStairsMP(Blocks.stone.getDefaultState(), "fronos_cobblestone_stairs", 1.75F);
		FronosBlocks.fronos_stone_brick_stairs = new BlockStairsMP(Blocks.stone.getDefaultState(), "fronos_stone_brick_stairs", 2.25F);
		FronosBlocks.cracked_fronos_stone_brick_stairs = new BlockStairsMP(Blocks.stone.getDefaultState(), "cracked_fronos_stone_brick_stairs", 2.25F);
		FronosBlocks.fronos_dungeon_brick_stairs = new BlockStairsMP(Blocks.stone.getDefaultState(), "fronos_dungeon_brick_stairs", 4.0F);
		FronosBlocks.coconut_wood_stairs = new BlockStairsMP(Blocks.planks.getDefaultState(), "coconut_wood_stairs", "wood", null, 2.0F);
		FronosBlocks.maple_wood_stairs = new BlockStairsMP(Blocks.planks.getDefaultState(), "maple_wood_stairs", "wood", null, 2.0F);
		FronosBlocks.fronos_fence = new BlockFronosFence("fronos_fence");
		FronosBlocks.coconut_fence_gate = new BlockFenceGateMP("coconut_fence_gate");
		FronosBlocks.maple_fence_gate = new BlockFenceGateMP("maple_fence_gate");
		FronosBlocks.fronos_treasure_chest = new BlockFronosTreasureChest("fronos_treasure_chest");
		FronosBlocks.fronos_ancient_chest = new BlockFronosAncientChest("fronos_ancient_chest");
		FronosBlocks.candy_extractor_idle = new BlockCandyExtractor("candy_extractor_idle", false);
		FronosBlocks.mineral_water_generator = new BlockMineralWaterGenerator("mineral_water_generator");
		FronosBlocks.candy_extractor_active = new BlockCandyExtractor("candy_extractor_active", true);
		FronosBlocks.fronos_farmland = new BlockFronosFarmland("fronos_farmland");
		FronosBlocks.strawberry_bush = new BlockStrawberryBush("strawberry_bush");
		FronosBlocks.golden_crops = new BlockGoldenCrops("golden_crops");
		FronosBlocks.coconut_block = new BlockCoconut("coconut_block");
		FronosBlocks.golem_cream_head = new BlockGolemCreamHead("golem_cream_head");
		FronosBlocks.cake_bread = new BlockCakeBread("cake_bread");
		FronosBlocks.white_cake_bread = new BlockWhiteCakeBread("white_cake_bread");
		FronosBlocks.chocolate_cake_bread = new BlockChocolateCakeBread("chocolate_cake_bread");
		FronosBlocks.pink_cake = new BlockPinkCake("pink_cake");
		FronosBlocks.white_cake = new BlockWhiteCake("white_cake");
		FronosBlocks.chocolate_cake = new BlockChocolateCake("chocolate_cake");
		FronosBlocks.space_shell = new BlockSpaceShell("space_shell");
		FronosBlocks.space_oyster = new BlockSpaceOyster("space_oyster");
		FronosBlocks.cavern_oyster = new BlockCavernOyster("cavern_oyster");
		FronosBlocks.jelly_slime_egg = new BlockJellySlimeEgg("jelly_slime_egg");
		FronosBlocks.fronos_sapling = new BlockFronosSapling("fronos_sapling");
		FronosBlocks.fronos_tall_grass = new BlockFronosTallGrass("fronos_tall_grass");
		FronosBlocks.fronos_flower = new BlockFronosFlower("fronos_flower");
		FronosBlocks.fronos_dandelion = new BlockDandelion("fronos_dandelion");
		FronosBlocks.fronos_poppy = new BlockPoppy("fronos_poppy");
		FronosBlocks.candy_flower = new BlockCandyFlower("candy_flower");
		FronosBlocks.fronos_coral = new BlockFronosCoral("fronos_coral");
		FronosBlocks.cheese_web = new BlockCheeseWeb("cheese_web");
		FronosBlocks.glass_gem_corn = new BlockGlassGemCorn("glass_gem_corn");
		FronosBlocks.maple_ivy = new BlockMapleIvy("maple_ivy");
		FronosBlocks.pink_candy_torch = new BlockCandyTorch("pink_candy_torch");
		FronosBlocks.orange_candy_torch = new BlockCandyTorch("orange_candy_torch");
		FronosBlocks.green_candy_torch = new BlockCandyTorch("green_candy_torch");
		FronosBlocks.yellow_candy_torch = new BlockCandyTorch("yellow_candy_torch");
		FronosBlocks.light_blue_candy_torch = new BlockCandyTorch("light_blue_candy_torch");
		FronosBlocks.blue_candy_torch = new BlockCandyTorch("blue_candy_torch");
		FronosBlocks.red_candy_torch = new BlockCandyTorch("red_candy_torch");
		FronosBlocks.purple_candy_torch = new BlockCandyTorch("purple_candy_torch");
		FronosBlocks.cup = new BlockCup("cup_block");
		FronosBlocks.mineral_water_cup = new BlockMineralWaterCup("mineral_water_cup");
		FronosBlocks.ovaltine_cup = new BlockOvaltineCup("ovaltine_cup");
		FronosBlocks.coconut_milk_cup = new BlockCoconutMilkCup("coconut_milk_cup");
		FronosBlocks.cheese_of_milk_cup = new BlockCheeseOfMilkCup("cheese_of_milk_cup");
		FronosBlocks.tea_cup = new BlockTeaCup("tea_cup");
		FronosBlocks.caramel_cup = new BlockCaramelCup("caramel_cup");
		FronosBlocks.coconut_door_block = new BlockDoorMP("coconut_door_block", DoorType.COCONUT);
		FronosBlocks.maple_door_block = new BlockDoorMP("maple_door_block", DoorType.MAPLE);
		FronosBlocks.fronos_sandstone = new BlockFronosSandstone("fronos_sandstone");
		FronosBlocks.half_fronos_sandstone_slab = new BlockFronosSandstoneSlab("half_fronos_sandstone_slab", Material.rock);
		FronosBlocks.double_fronos_sandstone_slab = new BlockDoubleFronosSandstoneSlab("double_fronos_sandstone_slab", Material.rock);
		FronosBlocks.fronos_sandstone_stairs = new BlockStairsMP(Blocks.stone.getDefaultState(), "fronos_sandstone_stairs", 0.8F);
		FronosBlocks.white_sandstone_stairs = new BlockStairsMP(Blocks.stone.getDefaultState(), "white_sandstone_stairs", 0.8F);
		FronosBlocks.cheese_sandstone_stairs = new BlockStairsMP(Blocks.stone.getDefaultState(), "cheese_sandstone_stairs", 0.8F);
		FronosBlocks.fronos_double_tallgrass = new BlockFronosDoubleTallgrass("fronos_double_tallgrass");
		FronosBlocks.sky_mushroom_block = new BlockHugeSkyMushroom("sky_mushroom_block");

		FronosBlocks.coconut_milk_fluid = new FluidMP("coconut_milk_fluid").setBlock(FronosBlocks.coconut_milk).setViscosity(2000);
		FronosBlocks.mineral_water_fluid = new FluidMP("mineral_water_fluid").setBlock(FronosBlocks.mineral_water);
		FronosBlocks.ovaltine_fluid = new FluidMP("ovaltine_fluid").setBlock(FronosBlocks.ovaltine).setViscosity(2000);
		FronosBlocks.tea_fluid = new FluidMP("tea_fluid").setBlock(FronosBlocks.tea).setViscosity(2000);
		FronosBlocks.caramel_fluid = new FluidMP("caramel_fluid").setBlock(FronosBlocks.caramel).setViscosity(3000);
		CommonRegisterHelper.registerFluid(FronosBlocks.coconut_milk_fluid);
		CommonRegisterHelper.registerFluid(FronosBlocks.mineral_water_fluid);
		CommonRegisterHelper.registerFluid(FronosBlocks.ovaltine_fluid);
		CommonRegisterHelper.registerFluid(FronosBlocks.tea_fluid);
		CommonRegisterHelper.registerFluid(FronosBlocks.caramel_fluid);
		FronosBlocks.coconut_milk = new BlockFluidCoconutMilk("coconut_milk_fluid");
		FronosBlocks.mineral_water = new BlockFluidMineralWater("mineral_water_fluid");
		FronosBlocks.ovaltine = new BlockFluidOvaltine("ovaltine_fluid");
		FronosBlocks.tea = new BlockFluidTea("tea_fluid");
		FronosBlocks.caramel = new BlockFluidCaramel("caramel_fluid");

		// Register
		CommonRegisterHelper.registerBlock(FronosBlocks.fronos_grass);
		CommonRegisterHelper.registerBlock(FronosBlocks.pink_grass);
		CommonRegisterHelper.registerBlock(FronosBlocks.purple_grass);
		CommonRegisterHelper.registerBlock(FronosBlocks.plains_grass);
		CommonRegisterHelper.registerBlock(FronosBlocks.golden_grass);
		CommonRegisterHelper.registerBlock(FronosBlocks.fronos_dirt, ItemBlockDirtMP.class);
		CommonRegisterHelper.registerBlock(FronosBlocks.fronos_block, ItemBlockFronosStone.class);
		CommonRegisterHelper.registerBlock(FronosBlocks.mossy_fronos_cobblestone);
		CommonRegisterHelper.registerBlock(FronosBlocks.jelly_ore, ItemBlockJelly.class);
		CommonRegisterHelper.registerBlock(FronosBlocks.ore_block, ItemBlockOreFronos.class);
		CommonRegisterHelper.registerBlock(FronosBlocks.frosted_cake, ItemBlockFrostedCake.class);
		CommonRegisterHelper.registerBlock(FronosBlocks.jelly_block, ItemBlockJelly.class);
		CommonRegisterHelper.registerBlock(FronosBlocks.cookie_block);
		CommonRegisterHelper.registerBlock(FronosBlocks.ovaltine_block);
		CommonRegisterHelper.registerBlock(FronosBlocks.chocolate_block);
		CommonRegisterHelper.registerBlock(FronosBlocks.caramel_block);
		CommonRegisterHelper.registerBlock(FronosBlocks.cloud_block, ItemBlockFronosCloud.class);
		CommonRegisterHelper.registerBlock(FronosBlocks.candy_cane1, ItemBlockCandyCane1.class);
		CommonRegisterHelper.registerBlock(FronosBlocks.candy_cane2, ItemBlockCandyCane2.class);
		CommonRegisterHelper.registerBlock(FronosBlocks.cream_block, ItemBlockCream.class);
		CommonRegisterHelper.registerBlock(FronosBlocks.vanilla_cream_layer, ItemBlockVanillaCreamLayer.class);
		CommonRegisterHelper.registerBlock(FronosBlocks.chocolate_cream_layer, ItemBlockChocolateCreamLayer.class);
		CommonRegisterHelper.registerBlock(FronosBlocks.strawberry_cream_layer, ItemBlockStrawberryCreamLayer.class);
		CommonRegisterHelper.registerBlock(FronosBlocks.orange_cream_layer, ItemBlockOrangeCreamLayer.class);
		CommonRegisterHelper.registerBlock(FronosBlocks.tea_cream_layer, ItemBlockTeaCreamLayer.class);
		CommonRegisterHelper.registerBlock(FronosBlocks.lemon_cream_layer, ItemBlockLemonCreamLayer.class);
		CommonRegisterHelper.registerBlock(FronosBlocks.fronos_sand, ItemBlockFronosSand.class);
		CommonRegisterHelper.registerBlock(FronosBlocks.fronos_sandstone, ItemBlockFronosSandstone.class);
		CommonRegisterHelper.registerBlock(FronosBlocks.half_fronos_sandstone_slab, ItemBlockFronosSandstoneSlab.class, FronosBlocks.half_fronos_sandstone_slab, FronosBlocks.double_fronos_sandstone_slab);
		CommonRegisterHelper.registerBlock(FronosBlocks.double_fronos_sandstone_slab, ItemBlockFronosSandstoneSlab.class, FronosBlocks.half_fronos_sandstone_slab, FronosBlocks.double_fronos_sandstone_slab);
		CommonRegisterHelper.registerBlock(FronosBlocks.cheese_glass);
		CommonRegisterHelper.registerBlock(FronosBlocks.cheese_glass_pane);
		CommonRegisterHelper.registerBlock(FronosBlocks.fronos_log, ItemBlockFronosLog.class);
		CommonRegisterHelper.registerBlock(FronosBlocks.fronos_planks, ItemBlockFronosWoodenPlanks.class);
		CommonRegisterHelper.registerBlock(FronosBlocks.fronos_colorized_leaves, ItemBlockFronosColorizedLeaves.class);
		CommonRegisterHelper.registerBlock(FronosBlocks.fronos_leaves, ItemBlockFronosLeaves.class);
		CommonRegisterHelper.registerBlock(FronosBlocks.fronos_cobblestone_stairs);
		CommonRegisterHelper.registerBlock(FronosBlocks.fronos_stone_brick_stairs);
		CommonRegisterHelper.registerBlock(FronosBlocks.cracked_fronos_stone_brick_stairs);
		CommonRegisterHelper.registerBlock(FronosBlocks.fronos_dungeon_brick_stairs);
		CommonRegisterHelper.registerBlock(FronosBlocks.fronos_sandstone_stairs);
		CommonRegisterHelper.registerBlock(FronosBlocks.white_sandstone_stairs);
		CommonRegisterHelper.registerBlock(FronosBlocks.cheese_sandstone_stairs);
		CommonRegisterHelper.registerBlock(FronosBlocks.coconut_wood_stairs);
		CommonRegisterHelper.registerBlock(FronosBlocks.maple_wood_stairs);
		CommonRegisterHelper.registerBlock(FronosBlocks.fronos_fence, ItemBlockFronosWoodenPlanks.class);
		CommonRegisterHelper.registerBlock(FronosBlocks.coconut_fence_gate);
		CommonRegisterHelper.registerBlock(FronosBlocks.maple_fence_gate);
		CommonRegisterHelper.registerBlock(FronosBlocks.fronos_treasure_chest);
		CommonRegisterHelper.registerBlock(FronosBlocks.fronos_ancient_chest);
		CommonRegisterHelper.registerBlock(FronosBlocks.candy_extractor_idle);
		CommonRegisterHelper.registerBlock(FronosBlocks.mineral_water_generator);
		CommonRegisterHelper.registerBlock(FronosBlocks.candy_extractor_active);
		CommonRegisterHelper.registerBlock(FronosBlocks.fronos_farmland);
		CommonRegisterHelper.registerBlock(FronosBlocks.strawberry_bush);
		CommonRegisterHelper.registerBlock(FronosBlocks.golden_crops);
		CommonRegisterHelper.registerBlock(FronosBlocks.coconut_block);
		CommonRegisterHelper.registerBlock(FronosBlocks.golem_cream_head, ItemBlockGolemCreamHead.class);
		CommonRegisterHelper.registerBlock(FronosBlocks.cake_bread);
		CommonRegisterHelper.registerBlock(FronosBlocks.white_cake_bread);
		CommonRegisterHelper.registerBlock(FronosBlocks.chocolate_cake_bread);
		CommonRegisterHelper.registerBlock(FronosBlocks.pink_cake);
		CommonRegisterHelper.registerBlock(FronosBlocks.white_cake);
		CommonRegisterHelper.registerBlock(FronosBlocks.chocolate_cake);
		CommonRegisterHelper.registerBlock(FronosBlocks.space_shell, ItemBlockSpaceShell.class);
		CommonRegisterHelper.registerBlock(FronosBlocks.space_oyster);
		CommonRegisterHelper.registerBlock(FronosBlocks.cavern_oyster);
		CommonRegisterHelper.registerBlock(FronosBlocks.jelly_slime_egg, ItemBlockJelly.class);
		CommonRegisterHelper.registerBlock(FronosBlocks.fronos_sapling, ItemBlockFronosSapling.class);
		CommonRegisterHelper.registerBlock(FronosBlocks.fronos_tall_grass, ItemBlockFronosTallGrass.class);
		CommonRegisterHelper.registerBlock(FronosBlocks.fronos_flower, ItemBlockFronosFlower.class);
		CommonRegisterHelper.registerBlock(FronosBlocks.fronos_dandelion, ItemBlockDandelion.class);
		CommonRegisterHelper.registerBlock(FronosBlocks.fronos_poppy, ItemBlockPoppy.class);
		CommonRegisterHelper.registerBlock(FronosBlocks.candy_flower, ItemBlockCandyFlower.class);
		CommonRegisterHelper.registerBlock(FronosBlocks.fronos_coral, ItemBlockFronosCoral.class);
		CommonRegisterHelper.registerBlock(FronosBlocks.fronos_double_tallgrass, ItemBlockFronosDoubleTallgrass.class);
		CommonRegisterHelper.registerBlock(FronosBlocks.cheese_web);
		CommonRegisterHelper.registerBlock(FronosBlocks.glass_gem_corn);
		CommonRegisterHelper.registerBlock(FronosBlocks.maple_ivy);
		CommonRegisterHelper.registerBlock(FronosBlocks.pink_candy_torch);
		CommonRegisterHelper.registerBlock(FronosBlocks.orange_candy_torch);
		CommonRegisterHelper.registerBlock(FronosBlocks.green_candy_torch);
		CommonRegisterHelper.registerBlock(FronosBlocks.yellow_candy_torch);
		CommonRegisterHelper.registerBlock(FronosBlocks.light_blue_candy_torch);
		CommonRegisterHelper.registerBlock(FronosBlocks.blue_candy_torch);
		CommonRegisterHelper.registerBlock(FronosBlocks.red_candy_torch);
		CommonRegisterHelper.registerBlock(FronosBlocks.purple_candy_torch);
		CommonRegisterHelper.registerBlock(FronosBlocks.cup);
		CommonRegisterHelper.registerBlock(FronosBlocks.mineral_water_cup);
		CommonRegisterHelper.registerBlock(FronosBlocks.ovaltine_cup);
		CommonRegisterHelper.registerBlock(FronosBlocks.coconut_milk_cup);
		CommonRegisterHelper.registerBlock(FronosBlocks.cheese_of_milk_cup);
		CommonRegisterHelper.registerBlock(FronosBlocks.tea_cup);
		CommonRegisterHelper.registerBlock(FronosBlocks.caramel_cup);
		CommonRegisterHelper.registerBlock(FronosBlocks.coconut_door_block);
		CommonRegisterHelper.registerBlock(FronosBlocks.maple_door_block);
		CommonRegisterHelper.registerBlock(FronosBlocks.sky_mushroom_block);
		CommonRegisterHelper.registerBlock(FronosBlocks.coconut_milk);
		CommonRegisterHelper.registerBlock(FronosBlocks.mineral_water);
		CommonRegisterHelper.registerBlock(FronosBlocks.ovaltine);
		CommonRegisterHelper.registerBlock(FronosBlocks.tea);
		CommonRegisterHelper.registerBlock(FronosBlocks.caramel);

		// Set harvest level
		FronosBlocks.fronos_grass.setHarvestLevel("shovel", 0);
		FronosBlocks.fronos_dirt.setHarvestLevel("shovel", 0);
		FronosBlocks.fronos_farmland.setHarvestLevel("shovel", 0);
		FronosBlocks.pink_grass.setHarvestLevel("shovel", 0);
		FronosBlocks.purple_grass.setHarvestLevel("shovel", 0);
		FronosBlocks.plains_grass.setHarvestLevel("shovel", 0);
		FronosBlocks.golden_grass.setHarvestLevel("shovel", 0);
		FronosBlocks.fronos_sand.setHarvestLevel("shovel", 0);
		FronosBlocks.cream_block.setHarvestLevel("shovel", 0);
		FronosBlocks.vanilla_cream_layer.setHarvestLevel("shovel", 0);
		FronosBlocks.chocolate_cream_layer.setHarvestLevel("shovel", 0);
		FronosBlocks.strawberry_cream_layer.setHarvestLevel("shovel", 0);
		FronosBlocks.orange_cream_layer.setHarvestLevel("shovel", 0);
		FronosBlocks.tea_cream_layer.setHarvestLevel("shovel", 0);
		FronosBlocks.lemon_cream_layer.setHarvestLevel("shovel", 0);
		FronosBlocks.ovaltine_block.setHarvestLevel("shovel", 0);
		FronosBlocks.chocolate_block.setHarvestLevel("shovel", 0);
		FronosBlocks.cookie_block.setHarvestLevel("shovel", 0);
		FronosBlocks.frosted_cake.setHarvestLevel("shovel", 0);
		FronosBlocks.golem_cream_head.setHarvestLevel("shovel", 0);
		FronosBlocks.fronos_sandstone.setHarvestLevel("pickaxe", 0);
		FronosBlocks.fronos_block.setHarvestLevel("pickaxe", 0);
		FronosBlocks.jelly_ore.setHarvestLevel("pickaxe", 0);
		FronosBlocks.fronos_cobblestone_stairs.setHarvestLevel("pickaxe", 0);
		FronosBlocks.fronos_stone_brick_stairs.setHarvestLevel("pickaxe", 0);
		FronosBlocks.cracked_fronos_stone_brick_stairs.setHarvestLevel("pickaxe", 0);
		FronosBlocks.fronos_dungeon_brick_stairs.setHarvestLevel("pickaxe", 0);
		FronosBlocks.candy_extractor_idle.setHarvestLevel("pickaxe", 0);
		FronosBlocks.candy_extractor_active.setHarvestLevel("pickaxe", 0);
		FronosBlocks.mineral_water_generator.setHarvestLevel("pickaxe", 2);
		FronosBlocks.ore_block.setHarvestLevel("pickaxe", 0);
		FronosBlocks.mossy_fronos_cobblestone.setHarvestLevel("pickaxe", 0);
		FronosBlocks.space_oyster.setHarvestLevel("pickaxe", 0);
		FronosBlocks.cavern_oyster.setHarvestLevel("pickaxe", 0);
		FronosBlocks.half_fronos_sandstone_slab.setHarvestLevel("pickaxe", 0);
		FronosBlocks.double_fronos_sandstone_slab.setHarvestLevel("pickaxe", 0);
		FronosBlocks.fronos_sandstone_stairs.setHarvestLevel("pickaxe", 0);
		FronosBlocks.white_sandstone_stairs.setHarvestLevel("pickaxe", 0);
		FronosBlocks.cheese_sandstone_stairs.setHarvestLevel("pickaxe", 0);
		FronosBlocks.fronos_log.setHarvestLevel("axe", 0);
		FronosBlocks.coconut_block.setHarvestLevel("axe", 0);
		FronosBlocks.fronos_planks.setHarvestLevel("axe", 0);
		FronosBlocks.coconut_wood_stairs.setHarvestLevel("axe", 0);
		FronosBlocks.maple_wood_stairs.setHarvestLevel("axe", 0);
		FronosBlocks.fronos_fence.setHarvestLevel("axe", 0);
		FronosBlocks.coconut_fence_gate.setHarvestLevel("axe", 0);
		FronosBlocks.maple_fence_gate.setHarvestLevel("axe", 0);
		FronosBlocks.fronos_ancient_chest.setHarvestLevel("axe", 0);
		FronosBlocks.sky_mushroom_block.setHarvestLevel("axe", 0);

		// Set fire burn
		CommonRegisterHelper.setFireBurn(FronosBlocks.fronos_planks, 5, 20);
		CommonRegisterHelper.setFireBurn(FronosBlocks.fronos_leaves, 30, 60);
		CommonRegisterHelper.setFireBurn(FronosBlocks.fronos_colorized_leaves, 30, 60);
		CommonRegisterHelper.setFireBurn(FronosBlocks.candy_cane1, 5, 20);
		CommonRegisterHelper.setFireBurn(FronosBlocks.candy_cane2, 5, 20);
		CommonRegisterHelper.setFireBurn(FronosBlocks.coconut_wood_stairs, 5, 20);
		CommonRegisterHelper.setFireBurn(FronosBlocks.fronos_fence, 5, 20);
		CommonRegisterHelper.setFireBurn(FronosBlocks.coconut_fence_gate, 5, 20);
		CommonRegisterHelper.setFireBurn(FronosBlocks.maple_wood_stairs, 5, 20);
		CommonRegisterHelper.setFireBurn(FronosBlocks.maple_fence_gate, 5, 20);
		CommonRegisterHelper.setFireBurn(FronosBlocks.coconut_block, 5, 20);
		CommonRegisterHelper.setFireBurn(FronosBlocks.fronos_tall_grass, 60, 100);
		CommonRegisterHelper.setFireBurn(FronosBlocks.fronos_sapling, 60, 100);
		CommonRegisterHelper.setFireBurn(FronosBlocks.fronos_flower, 60, 100);
		CommonRegisterHelper.setFireBurn(FronosBlocks.fronos_dandelion, 60, 100);
		CommonRegisterHelper.setFireBurn(FronosBlocks.candy_flower, 60, 100);
		CommonRegisterHelper.setFireBurn(FronosBlocks.fronos_poppy, 60, 100);
		CommonRegisterHelper.setFireBurn(FronosBlocks.fronos_double_tallgrass, 60, 100);
		CommonRegisterHelper.setFireBurn(FronosBlocks.maple_ivy, 15, 100);
		CommonRegisterHelper.setFireBurn(FronosBlocks.fronos_log, 5, 5);

		// Register ore dictionary
		OreDictionary.registerOre("oreIron", new ItemStack(FronosBlocks.fronos_block, 1, 2));
		OreDictionary.registerOre("oreCoal", new ItemStack(FronosBlocks.fronos_block, 1, 3));
		OreDictionary.registerOre("oreAluminum", new ItemStack(FronosBlocks.fronos_block, 1, 4));
		OreDictionary.registerOre("oreAluminium", new ItemStack(FronosBlocks.fronos_block, 1, 4));
		OreDictionary.registerOre("oreTin", new ItemStack(FronosBlocks.fronos_block, 1, 5));
		OreDictionary.registerOre("oreCopper", new ItemStack(FronosBlocks.fronos_block, 1, 6));
		OreDictionary.registerOre("oreLapis", new ItemStack(FronosBlocks.fronos_block, 1, 7));
		OreDictionary.registerOre("oreMineral", new ItemStack(FronosBlocks.fronos_block, 1, 8));
		OreDictionary.registerOre("oreBlackDiamond", new ItemStack(FronosBlocks.fronos_block, 1, 9));
		OreDictionary.registerOre("oreIridium", new ItemStack(FronosBlocks.fronos_block, 1, 10));
		OreDictionary.registerOre("oreJelly", FronosBlocks.jelly_ore);
		OreDictionary.registerOre("sand", FronosBlocks.fronos_sand);

		OreDictionary.registerOre("plankWood", new ItemStack(FronosBlocks.fronos_planks, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("stairWood", new ItemStack(FronosBlocks.coconut_wood_stairs));
		OreDictionary.registerOre("stairWood", new ItemStack(FronosBlocks.maple_wood_stairs));
		OreDictionary.registerOre("treeSapling", new ItemStack(FronosBlocks.fronos_sapling, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("treeLeaves", new ItemStack(FronosBlocks.fronos_colorized_leaves, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("treeLeaves", new ItemStack(FronosBlocks.fronos_leaves, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("logWood", new ItemStack(FronosBlocks.fronos_log, 1, OreDictionary.WILDCARD_VALUE));

		OreDictionary.registerOre("candyCane", new ItemStack(FronosBlocks.candy_cane1, 1, 0));
		OreDictionary.registerOre("candyCane", new ItemStack(FronosBlocks.candy_cane1, 1, 1));
		OreDictionary.registerOre("candyCane", new ItemStack(FronosBlocks.candy_cane1, 1, 2));
		OreDictionary.registerOre("candyCane", new ItemStack(FronosBlocks.candy_cane1, 1, 3));
		OreDictionary.registerOre("candyCane", new ItemStack(FronosBlocks.candy_cane2, 1, 0));
		OreDictionary.registerOre("candyCane", new ItemStack(FronosBlocks.candy_cane2, 1, 1));
		OreDictionary.registerOre("candyCane", new ItemStack(FronosBlocks.candy_cane2, 1, 2));
		OreDictionary.registerOre("candyCane", new ItemStack(FronosBlocks.candy_cane2, 1, 3));
		OreDictionary.registerOre("fronosSandstone", new ItemStack(FronosBlocks.fronos_sandstone, 1, 0));
		OreDictionary.registerOre("fronosSandstone", new ItemStack(FronosBlocks.fronos_sandstone, 1, 1));
		OreDictionary.registerOre("fronosSandstone", new ItemStack(FronosBlocks.fronos_sandstone, 1, 2));
		OreDictionary.registerOre("whiteSandstone", new ItemStack(FronosBlocks.fronos_sandstone, 1, 3));
		OreDictionary.registerOre("whiteSandstone", new ItemStack(FronosBlocks.fronos_sandstone, 1, 4));
		OreDictionary.registerOre("whiteSandstone", new ItemStack(FronosBlocks.fronos_sandstone, 1, 5));
		OreDictionary.registerOre("cheeseSandstone", new ItemStack(FronosBlocks.fronos_sandstone, 1, 6));
		OreDictionary.registerOre("cheeseSandstone", new ItemStack(FronosBlocks.fronos_sandstone, 1, 7));
		OreDictionary.registerOre("cheeseSandstone", new ItemStack(FronosBlocks.fronos_sandstone, 1, 8));

		OreDictionary.registerOre("blockIridium", new ItemStack(FronosBlocks.ore_block, 1, 0));
		OreDictionary.registerOre("blockBlackDiamond", new ItemStack(FronosBlocks.ore_block, 1, 1));
	}
}