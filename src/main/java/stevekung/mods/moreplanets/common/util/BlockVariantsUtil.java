/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.util;

import stevekung.mods.moreplanets.core.init.MPBlocks;
import stevekung.mods.moreplanets.moons.deimos.blocks.DeimosBlocks;
import stevekung.mods.moreplanets.moons.europa.blocks.EuropaBlocks;
import stevekung.mods.moreplanets.moons.io.blocks.IoBlocks;
import stevekung.mods.moreplanets.moons.koentus.blocks.KoentusBlocks;
import stevekung.mods.moreplanets.moons.phobos.blocks.PhobosBlocks;
import stevekung.mods.moreplanets.planets.diona.blocks.DionaBlocks;
import stevekung.mods.moreplanets.planets.fronos.blocks.FronosBlocks;
import stevekung.mods.moreplanets.planets.kapteynb.blocks.KapteynBBlocks;
import stevekung.mods.moreplanets.planets.mercury.blocks.MercuryBlocks;
import stevekung.mods.moreplanets.planets.nibiru.blocks.NibiruBlocks;
import stevekung.mods.moreplanets.planets.pluto.blocks.PlutoBlocks;
import stevekung.mods.moreplanets.planets.polongnius.blocks.PolongniusBlocks;
import stevekung.mods.moreplanets.planets.siriusb.blocks.SiriusBBlocks;
import stevekung.mods.moreplanets.planets.venus.blocks.VenusBlocks;
import stevekung.mods.stevecore.ClientRegisterHelper;

public class BlockVariantsUtil
{
	public static void registerBlockVariants()
	{
		ClientRegisterHelper.registerVariantsName(MPBlocks.half_stone_slab_1, new String[] { "moreplanets:diona_cobblestone_slab", "moreplanets:quontonium_brick_slab", "moreplanets:chiseled_quontonium_slab", "moreplanets:polongnius_cobblestone_slab", "moreplanets:nibiru_cobblestone_slab", "moreplanets:koentus_cobblestone_slab", "moreplanets:koentus_ancient_stone_slab", "moreplanets:koentus_ancient_stone_brick_slab" });
		ClientRegisterHelper.registerVariantsName(MPBlocks.half_stone_slab_2, new String[] { "moreplanets:fronos_cobblestone_slab", "moreplanets:fronos_stone_brick_slab", "moreplanets:cracked_fronos_stone_brick_slab", "moreplanets:kapteyn_b_cracked_ice_slab", "moreplanets:sirius_b_carbon_cobblestone_slab", "moreplanets:mercury_cobblestone_slab" });
		ClientRegisterHelper.registerVariantsName(MPBlocks.half_wooden_slab_1, new String[] { "moreplanets:ancient_dark_wood_slab", "moreplanets:orange_wood_slab", "moreplanets:crystal_wood_slab", "moreplanets:coconut_wood_slab", "moreplanets:maple_wood_slab", "moreplanets:europa_wood_slab" });
		ClientRegisterHelper.registerVariantsName(MPBlocks.half_dungeon_brick_slab_1, new String[] { "moreplanets:diona_dungeon_brick_slab", "moreplanets:polongnius_dungeon_brick_slab", "moreplanets:nibiru_dungeon_brick_slab", "moreplanets:koentus_dungeon_brick_slab", "moreplanets:fronos_dungeon_brick_slab", "moreplanets:kapteyn_b_dungeon_brick_slab", "moreplanets:sirius_b_dungeon_brick_slab", "moreplanets:mercury_dungeon_brick_slab" });
		ClientRegisterHelper.registerVariantsName(MPBlocks.stone_wall, new String[] { "moreplanets:diona_cobblestone_wall", "moreplanets:quontonium_brick_wall", "moreplanets:chiseled_quontonium_wall", "moreplanets:polongnius_cobblestone_wall", "moreplanets:nibiru_cobblestone_wall", "moreplanets:koentus_cobblestone_wall", "moreplanets:koentus_ancient_stone_wall", "moreplanets:koentus_ancient_stone_brick_wall", "moreplanets:fronos_cobblestone_wall", "moreplanets:fronos_stone_brick_wall", "moreplanets:cracked_fronos_stone_brick_wall", "moreplanets:kapteyn_b_cracked_ice_wall", "moreplanets:sirius_b_carbon_cobblestone_wall", "moreplanets:mercury_cobblestone_wall" });
		ClientRegisterHelper.registerVariantsName(MPBlocks.dungeon_brick_wall, new String[] { "moreplanets:diona_dungeon_brick_wall", "moreplanets:polongnius_dungeon_brick_wall", "moreplanets:nibiru_dungeon_brick_wall", "moreplanets:koentus_dungeon_brick_wall", "moreplanets:fronos_dungeon_brick_wall", "moreplanets:kapteyn_b_dungeon_brick_wall", "moreplanets:sirius_b_dungeon_brick_wall", "moreplanets:mercury_dungeon_brick_wall" });
		ClientRegisterHelper.registerVariantsName(MPBlocks.chondrite_rock, new String[] { "moreplanets:chondrite_rock", "moreplanets:polished_chondrite", "moreplanets:chondrite_stone_brick" });
		ClientRegisterHelper.registerVariantsName(DionaBlocks.diona_block, new String[] { "moreplanets:diona_surface_rock", "moreplanets:diona_sub_surface_rock", "moreplanets:diona_rock", "moreplanets:diona_cobblestone", "moreplanets:quontonium_ore", "moreplanets:fronisium_ore", "moreplanets:diona_tin_ore", "moreplanets:diona_copper_ore", "moreplanets:diona_silicon_ore", "moreplanets:diona_aluminum_ore", "moreplanets:quontonium_block", "moreplanets:fronisium_block", "moreplanets:smooth_quontonium", "moreplanets:quontonium_brick", "moreplanets:chiseled_quontonium", "moreplanets:diona_dungeon_brick" });
		ClientRegisterHelper.registerVariantsName(PolongniusBlocks.polongnius_block, new String[] { "moreplanets:cheese_gas", "moreplanets:solid_cheese_gas", "moreplanets:polongnius_stone", "moreplanets:polongnius_cobblestone", "moreplanets:polongnius_copper_ore", "moreplanets:polongnius_tin_ore", "moreplanets:polongnius_iron_ore", "moreplanets:palladium_ore", "moreplanets:flonium_ore", "moreplanets:purple_crystal_ore", "moreplanets:cheese_of_milk_ore", "moreplanets:solid_polongnius_meteoric_iron", "moreplanets:purple_crystal_block", "moreplanets:palladium_block", "moreplanets:polongnius_slime_dungeon_brick", "moreplanets:polongnius_dungeon_brick" });
		ClientRegisterHelper.registerVariantsName(NibiruBlocks.nibiru_block, new String[] { "moreplanets:nibiru_surface_rock", "moreplanets:nibiru_sub_surface_rock", "moreplanets:nibiru_rock", "moreplanets:nibiru_cobblestone", "moreplanets:ichorius_ore", "moreplanets:norium_ore", "moreplanets:nibiru_diamond_ore", "moreplanets:nibiru_coal_ore", "moreplanets:red_gem_ore", "moreplanets:ichorius_block", "moreplanets:norium_block", "moreplanets:red_gem_block", "moreplanets:nibiru_dungeon_brick" });
		ClientRegisterHelper.registerVariantsName(NibiruBlocks.infected_dirt, new String[] { "moreplanets:infected_dirt", "moreplanets:coarse_infected_dirt" });
		ClientRegisterHelper.registerVariantsName(NibiruBlocks.oil_rock, new String[] { "moreplanets:oil_rock", "moreplanets:oil_ore" });
		ClientRegisterHelper.registerVariantsName(NibiruBlocks.nibiru_planks, new String[] { "moreplanets:ancient_dark_wood_planks", "moreplanets:orange_wood_planks" });
		ClientRegisterHelper.registerVariantsName(NibiruBlocks.nibiru_fence, new String[] { "moreplanets:ancient_dark_fence", "moreplanets:orange_fence" });
		ClientRegisterHelper.registerVariantsName(NibiruBlocks.nibiru_log, new String[] { "moreplanets:ancient_dark_wood_log", "moreplanets:orange_wood_log" });
		ClientRegisterHelper.registerVariantsName(NibiruBlocks.ancient_dark_leaves, new String[] { "moreplanets:ancient_dark_leaves1", "moreplanets:ancient_dark_leaves2", "moreplanets:ancient_dark_leaves3", "moreplanets:ancient_dark_leaves4" });
		ClientRegisterHelper.registerVariantsName(NibiruBlocks.orange_leaves, new String[] { "moreplanets:orange_leaves1", "moreplanets:orange_leaves2", "moreplanets:orange_leaves3", "moreplanets:orange_leaves4" });
		ClientRegisterHelper.registerVariantsName(NibiruBlocks.nibiru_sapling, new String[] { "moreplanets:ancient_dark_sapling", "moreplanets:orange_sapling" });
		ClientRegisterHelper.registerVariantsName(NibiruBlocks.infected_orange_rose_bush, new String[] { "moreplanets:orange_rose_bush_bottom", "moreplanets:orange_rose_bush_top" });
		ClientRegisterHelper.registerVariantsName(KoentusBlocks.koentus_block, new String[] { "moreplanets:koentus_surface_rock", "moreplanets:koentus_sub_surface_rock", "moreplanets:koentus_rock", "moreplanets:koentus_cobblestone", "moreplanets:koentus_tin_ore", "moreplanets:koentus_copper_ore", "moreplanets:white_crystal_ore", "moreplanets:emp_crystal_ore", "moreplanets:becterial_fossil_ore", "moreplanets:white_crystal_block", "moreplanets:emp_crystal_block", "moreplanets:solid_koentus_meteoric_iron", "moreplanets:koentus_ancient_stone", "moreplanets:koentus_ancient_stone_brick", "moreplanets:koentus_dungeon_brick" });
		ClientRegisterHelper.registerVariantsName(KoentusBlocks.crystal_dirt, new String[] { "moreplanets:crystal_dirt", "moreplanets:coarse_crystal_dirt" });
		ClientRegisterHelper.registerVariantsName(KoentusBlocks.eledos_egg, new String[] { "moreplanets:eledos_egg", "moreplanets:eledos_egg_crack" });
		ClientRegisterHelper.registerVariantsName(KoentusBlocks.koentus_ice, new String[] { "moreplanets:koentus_ice", "moreplanets:glowing_koentus_ice" });
		ClientRegisterHelper.registerVariantsName(MercuryBlocks.mercury_block, new String[] { "moreplanets:mercury_surface_rock", "moreplanets:mercury_sub_surface_rock", "moreplanets:mercury_rock", "moreplanets:mercury_cobblestone", "moreplanets:mercury_tin_ore", "moreplanets:mercury_copper_ore", "moreplanets:mercury_aluminum_ore", "moreplanets:mercury_iron_ore", "moreplanets:metal_meteoric_iron_ore", "moreplanets:mercury_silicate_rock", "moreplanets:solid_metal_meteoric_iron", "moreplanets:mercury_dungeon_brick" });
		ClientRegisterHelper.registerVariantsName(FronosBlocks.fronos_block, new String[] { "moreplanets:fronos_rock", "moreplanets:fronos_cobblestone", "moreplanets:fronos_iron_ore", "moreplanets:fronos_coal_ore", "moreplanets:fronos_aluminum_ore", "moreplanets:fronos_tin_ore", "moreplanets:fronos_copper_ore", "moreplanets:fronos_lapis_ore", "moreplanets:mineral_crystal_ore", "moreplanets:black_diamond_ore", "moreplanets:iridium_ore", "moreplanets:fronos_stone_brick", "moreplanets:cracked_fronos_stone_brick", "moreplanets:chiseled_fronos_stone_brick", "moreplanets:fronos_dungeon_brick" });
		ClientRegisterHelper.registerVariantsName(FronosBlocks.fronos_dirt, new String[] { "moreplanets:fronos_dirt", "moreplanets:coarse_fronos_dirt" });
		ClientRegisterHelper.registerVariantsName(FronosBlocks.jelly_ore, new String[] { "moreplanets:grape_jelly_ore", "moreplanets:raspberry_jelly_ore", "moreplanets:strawberry_jelly_ore", "moreplanets:berry_jelly_ore", "moreplanets:lime_jelly_ore", "moreplanets:orange_jelly_ore", "moreplanets:green_jelly_ore", "moreplanets:lemon_jelly_ore" });
		ClientRegisterHelper.registerVariantsName(FronosBlocks.ore_block, new String[] { "moreplanets:iridium_block", "moreplanets:black_diamond_block" });
		ClientRegisterHelper.registerVariantsName(FronosBlocks.jelly_block, new String[] { "moreplanets:grape_jelly_block", "moreplanets:raspberry_jelly_block", "moreplanets:strawberry_jelly_block", "moreplanets:berry_jelly_block", "moreplanets:lime_jelly_block", "moreplanets:orange_jelly_block", "moreplanets:green_jelly_block", "moreplanets:lemon_jelly_block" });
		ClientRegisterHelper.registerVariantsName(FronosBlocks.jelly_slime_egg, new String[] { "moreplanets:grape_jelly_slime_egg", "moreplanets:raspberry_jelly_slime_egg", "moreplanets:strawberry_jelly_slime_egg", "moreplanets:berry_jelly_slime_egg", "moreplanets:lime_jelly_slime_egg", "moreplanets:orange_jelly_slime_egg", "moreplanets:green_jelly_slime_egg", "moreplanets:lemon_jelly_slime_egg" });
		ClientRegisterHelper.registerVariantsName(FronosBlocks.candy_cane1, new String[] { "moreplanets:pink_candy_cane", "moreplanets:orange_candy_cane", "moreplanets:green_candy_cane", "moreplanets:yellow_candy_cane" });
		ClientRegisterHelper.registerVariantsName(FronosBlocks.candy_cane2, new String[] { "moreplanets:light_blue_candy_cane", "moreplanets:blue_candy_cane", "moreplanets:red_candy_cane", "moreplanets:purple_candy_cane" });
		ClientRegisterHelper.registerVariantsName(FronosBlocks.frosted_cake, new String[] { "moreplanets:cake_bread_block", "moreplanets:white_cake_bread_block", "moreplanets:chocolate_cake_bread_block", "moreplanets:frosted_white_cake_block", "moreplanets:frosted_pink_cake_block", "moreplanets:frosted_white_cake_block2", "moreplanets:frosted_chocolate_cake_block" });
		ClientRegisterHelper.registerVariantsName(FronosBlocks.cloud_block, new String[] { "moreplanets:strawberry_cloud", "moreplanets:rainbow_cloud" });
		ClientRegisterHelper.registerVariantsName(FronosBlocks.cream_block, new String[] { "moreplanets:vanilla_cream", "moreplanets:chocolate_cream", "moreplanets:strawberry_cream", "moreplanets:orange_cream", "moreplanets:tea_cream", "moreplanets:lemon_cream" });
		ClientRegisterHelper.registerVariantsName(FronosBlocks.golem_cream_head, new String[] { "moreplanets:vanilla_cream_head", "moreplanets:chocolate_cream_head", "moreplanets:strawberry_cream_head", "moreplanets:orange_cream_head", "moreplanets:tea_cream_head", "moreplanets:lemon_cream_head" });
		ClientRegisterHelper.registerVariantsName(FronosBlocks.fronos_sand, new String[] { "moreplanets:fronos_sand", "moreplanets:white_sand", "moreplanets:cheese_sand" });
		ClientRegisterHelper.registerVariantsName(FronosBlocks.fronos_log, new String[] { "moreplanets:coconut_wood_log", "moreplanets:maple_wood_log" });
		ClientRegisterHelper.registerVariantsName(FronosBlocks.fronos_planks, new String[] { "moreplanets:coconut_wood_planks", "moreplanets:maple_wood_planks" });
		ClientRegisterHelper.registerVariantsName(FronosBlocks.fronos_leaves, new String[] { "moreplanets:red_maple_leaves", "moreplanets:yellow_maple_leaves", "moreplanets:purple_maple_leaves" });
		ClientRegisterHelper.registerVariantsName(FronosBlocks.fronos_fence, new String[] { "moreplanets:coconut_fence", "moreplanets:maple_fence" });
		ClientRegisterHelper.registerVariantsName(FronosBlocks.fronos_sapling, new String[] { "moreplanets:coconut_sapling", "moreplanets:red_maple_sapling", "moreplanets:yellow_maple_sapling", "moreplanets:purple_maple_sapling" });
		ClientRegisterHelper.registerVariantsName(FronosBlocks.fronos_tall_grass, new String[] { "moreplanets:short_fronos_grass", "moreplanets:medium_fronos_grass", "moreplanets:tall_fronos_grass", "moreplanets:short_pink_grass", "moreplanets:medium_pink_grass", "moreplanets:tall_pink_grass", "moreplanets:short_purple_grass", "moreplanets:medium_purple_grass", "moreplanets:tall_purple_grass", "moreplanets:short_plains_grass", "moreplanets:medium_plains_grass", "moreplanets:tall_plains_grass", "moreplanets:short_golden_grass", "moreplanets:medium_golden_grass", "moreplanets:tall_golden_grass" });
		ClientRegisterHelper.registerVariantsName(FronosBlocks.fronos_flower, new String[] { "moreplanets:pink_butter_cup", "moreplanets:orange_butterfly_flower", "moreplanets:yellow_milk_cap", "moreplanets:little_sun_flower", "moreplanets:sky_mushroom", "moreplanets:purple_spike_flower", "moreplanets:jungle_iris", "moreplanets:blue_poison_mushroom", "moreplanets:white_moss" });
		ClientRegisterHelper.registerVariantsName(FronosBlocks.fronos_dandelion, new String[] { "moreplanets:young_orange_dandelion", "moreplanets:young_pink_dandelion", "moreplanets:young_purple_dandelion", "moreplanets:orange_dandelion", "moreplanets:pink_dandelion", "moreplanets:purple_dandelion" });
		ClientRegisterHelper.registerVariantsName(FronosBlocks.fronos_poppy, new String[] { "moreplanets:white_poppy", "moreplanets:orange_poppy", "moreplanets:purple_poppy" });
		ClientRegisterHelper.registerVariantsName(FronosBlocks.fronos_coral, new String[] { "moreplanets:glowing_pink_coral", "moreplanets:colunus_coral" });
		ClientRegisterHelper.registerVariantsName(FronosBlocks.candy_flower, new String[] { "moreplanets:pink_candy_flower", "moreplanets:orange_candy_flower", "moreplanets:green_candy_flower", "moreplanets:yellow_candy_flower", "moreplanets:light_blue_candy_flower", "moreplanets:blue_candy_flower", "moreplanets:red_candy_flower", "moreplanets:purple_candy_flower" });
		ClientRegisterHelper.registerVariantsName(FronosBlocks.glass_gem_corn, new String[] { "moreplanets:state_bottom1", "moreplanets:state_bottom2", "moreplanets:state_middle1", "moreplanets:state_middle2", "moreplanets:state_middle3", "moreplanets:state_top1" });
		ClientRegisterHelper.registerVariantsName(KapteynBBlocks.kapteyn_b_block, new String[] { "moreplanets:kapteyn_b_surface_ice", "moreplanets:kapteyn_b_sub_surface_ice", "moreplanets:kapteyn_b_hardened_ice", "moreplanets:kapteyn_b_cracked_ice", "moreplanets:namerium_ore", "moreplanets:frozen_iron_ore", "moreplanets:uranium_ore", "moreplanets:kapteyn_b_tin_ore", "moreplanets:kapteyn_b_copper_ore", "moreplanets:namerium_block", "moreplanets:frozen_iron_block", "moreplanets:uranium_block", "moreplanets:kapteyn_b_dungeon_brick" });
		ClientRegisterHelper.registerVariantsName(KapteynBBlocks.kapteyn_b_ice, new String[] { "moreplanets:kapteyn_b_ice", "moreplanets:dirty_kapteyn_b_ice" });
		ClientRegisterHelper.registerVariantsName(KapteynBBlocks.uranium_waste, new String[] { "moreplanets:uranium_waste", "moreplanets:inactive_uranium_waste" });
		ClientRegisterHelper.registerVariantsName(SiriusBBlocks.sirius_b_block, new String[] { "moreplanets:sirius_b_surface_carbon_stone", "moreplanets:sirius_b_sub_surface_carbon_stone", "moreplanets:sirius_b_carbon_stone", "moreplanets:sirius_b_carbon_cobblestone", "moreplanets:sirius_b_sulfur_ore", "moreplanets:sirius_b_diamond_ore", "moreplanets:sirius_b_glowstone_ore", "moreplanets:sirius_spot", "moreplanets:sulfur_block", "moreplanets:sirius_b_dungeon_brick" });
		ClientRegisterHelper.registerVariantsName(VenusBlocks.venus_block, new String[] { "moreplanets:venus_surface_rock", "moreplanets:venus_sub_surface_rock", "moreplanets:venus_rock", "moreplanets:venus_cobblestone", "moreplanets:venus_sulfur_ore", "moreplanets:venus_lead_ore", "moreplanets:venus_tin_ore", "moreplanets:venus_copper_ore", "moreplanets:venus_coal_ore", "moreplanets:venus_iron_ore", "moreplanets:venus_gold_ore", "moreplanets:lead_block", "moreplanets:venus_stone_brick", "moreplanets:cracked_venus_stone_brick", "moreplanets:venus_dungeon_brick" });
		ClientRegisterHelper.registerVariantsName(PhobosBlocks.phobos_block, new String[] { "moreplanets:phobos_surface_rock", "moreplanets:phobos_sub_surface_rock", "moreplanets:phobos_rock", "moreplanets:phobos_cobblestone", "moreplanets:phobos_tin_ore", "moreplanets:phobos_copper_ore", "moreplanets:phobos_iron_ore", "moreplanets:phobos_desh_ore" });
		ClientRegisterHelper.registerVariantsName(DeimosBlocks.deimos_block, new String[] { "moreplanets:deimos_surface_rock", "moreplanets:deimos_sub_surface_rock", "moreplanets:deimos_rock", "moreplanets:deimos_cobblestone", "moreplanets:deimos_tin_ore", "moreplanets:deimos_copper_ore", "moreplanets:deimos_iron_ore", "moreplanets:deimos_desh_ore" });
		ClientRegisterHelper.registerVariantsName(IoBlocks.io_block, new String[] { "moreplanets:io_surface_rock", "moreplanets:io_sub_surface_rock", "moreplanets:io_rock", "moreplanets:io_cobblestone", "moreplanets:io_sulfur_ore", "moreplanets:ash_stone", "moreplanets:ash_cobblestone", "moreplanets:io_silicate_rock", "moreplanets:io_dungeon_brick" });
		ClientRegisterHelper.registerVariantsName(IoBlocks.io_magma_rock, new String[] { "moreplanets:io_magma_rock", "moreplanets:io_sulfur_rock" });
		ClientRegisterHelper.registerVariantsName(FronosBlocks.fronos_colorized_leaves, new String[] { "moreplanets:coconut_leaves" });
		ClientRegisterHelper.registerVariantsName(KoentusBlocks.crystal_log, new String[] { "moreplanets:crystal_wood_log" });
		ClientRegisterHelper.registerVariantsName(PlutoBlocks.pluto_block, new String[] { "moreplanets:pluto_surface_rock", "moreplanets:pluto_sub_surface_rock", "moreplanets:pluto_rock", "moreplanets:pluto_cobblestone", "moreplanets:pluto_meteoric_iron_ore", "moreplanets:pluto_frozen_iron_ore", "moreplanets:pluto_iron_ore", "moreplanets:xeonium_gem_ore", "moreplanets:pluto_dungeon_brick", "moreplanets:pluto_surface_rock_brown", "moreplanets:pluto_surface_rock_light_brown" });
		ClientRegisterHelper.registerVariantsName(EuropaBlocks.europa_prismarine, new String[] { "moreplanets:europa_prismarine", "moreplanets:europa_prismarine_bricks", "moreplanets:dark_europa_prismarine" });
		ClientRegisterHelper.registerVariantsName(FronosBlocks.fronos_sandstone, new String[] { "moreplanets:fronos_sandstone", "moreplanets:chiseled_fronos_sandstone", "moreplanets:smooth_fronos_sandstone", "moreplanets:white_sandstone", "moreplanets:chiseled_white_sandstone", "moreplanets:smooth_white_sandstone", "moreplanets:cheese_sandstone", "moreplanets:chiseled_cheese_sandstone", "moreplanets:smooth_cheese_sandstone" });
		ClientRegisterHelper.registerVariantsName(FronosBlocks.half_fronos_sandstone_slab, new String[] { "moreplanets:fronos_sandstone_slab", "moreplanets:white_sandstone_slab", "moreplanets:cheese_sandstone_slab" });
		ClientRegisterHelper.registerVariantsName(EuropaBlocks.europa_ice, new String[] { "moreplanets:europa_ice", "moreplanets:dirty_europa_ice", "moreplanets:dense_europa_ice" });
		ClientRegisterHelper.registerVariantsName(VenusBlocks.venus_sandstone, new String[] { "moreplanets:venus_sandstone", "moreplanets:chiseled_venus_sandstone", "moreplanets:smooth_venus_sandstone" });
		ClientRegisterHelper.registerVariantsName(VenusBlocks.half_venus_sandstone_slab, new String[] { "moreplanets:venus_sandstone_slab" });
		ClientRegisterHelper.registerVariantsName(EuropaBlocks.europa_underwater_geyser, new String[] { "moreplanets:europa_underwater_geyser", "moreplanets:europa_underwater_smoke_geyser" });
		ClientRegisterHelper.registerVariantsName(EuropaBlocks.europa_log, new String[] { "moreplanets:europa_wood_log" });
		ClientRegisterHelper.registerVariantsName(EuropaBlocks.europa_sandstone, new String[] { "moreplanets:europa_sandstone", "moreplanets:chiseled_europa_sandstone", "moreplanets:smooth_europa_sandstone" });
		ClientRegisterHelper.registerVariantsName(EuropaBlocks.half_europa_sandstone_slab, new String[] { "moreplanets:europa_sandstone_slab" });
		ClientRegisterHelper.registerVariantsName(FronosBlocks.fronos_double_tallgrass, new String[] { "moreplanets:fronos_double_tallgrass", "moreplanets:pink_double_tallgrass", "moreplanets:purple_double_tallgrass", "moreplanets:plains_double_tallgrass", "moreplanets:golden_double_tallgrass" });
		ClientRegisterHelper.registerVariantsName(EuropaBlocks.half_europa_prismarine_slab, new String[] { "moreplanets:europa_prismarine_slab", "moreplanets:europa_prismarine_brick_slab", "moreplanets:dark_europa_prismarine_slab" });
		ClientRegisterHelper.registerVariantsName(EuropaBlocks.europa_sponge, new String[] { "moreplanets:europa_sponge", "moreplanets:europa_sponge_wet" });

		ClientRegisterHelper.registerVariantNameWithDyeColor(MPBlocks.tinted_glass, "moreplanets");
		ClientRegisterHelper.registerVariantNameWithDyeColor(MPBlocks.tinted_glass_pane, "moreplanets");
		ClientRegisterHelper.registerVariantNameWithDyeColor(KoentusBlocks.glowing_ice_stone, "moreplanets");
		ClientRegisterHelper.registerVariantNameWithDyeColor(FronosBlocks.space_shell, "moreplanets");
	}
}