/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.util;

import stevekung.mods.moreplanets.core.init.MPItems;
import stevekung.mods.moreplanets.moons.europa.items.EuropaItems;
import stevekung.mods.moreplanets.moons.koentus.items.KoentusItems;
import stevekung.mods.moreplanets.planets.diona.items.DionaItems;
import stevekung.mods.moreplanets.planets.fronos.items.FronosItems;
import stevekung.mods.moreplanets.planets.kapteynb.items.KapteynBItems;
import stevekung.mods.moreplanets.planets.mercury.items.MercuryItems;
import stevekung.mods.moreplanets.planets.nibiru.items.NibiruItems;
import stevekung.mods.moreplanets.planets.pluto.items.PlutoItems;
import stevekung.mods.moreplanets.planets.polongnius.items.PolongniusItems;
import stevekung.mods.moreplanets.planets.siriusb.items.SiriusBItems;
import stevekung.mods.moreplanets.planets.venus.items.VenusItems;
import stevekung.mods.stevecore.ClientRegisterHelper;

public class ItemVariantsUtil
{
    public static void registerItemVariants()
    {
        ClientRegisterHelper.registerVariantsName(DionaItems.diona_item, "moreplanets:quontonium_ingot", "moreplanets:fronisium_ingot", "moreplanets:compressed_quontonium", "moreplanets:compressed_fronisium", "moreplanets:tier_5_heavy_duty_plate", "moreplanets:quontonium_stick", "moreplanets:fronisium_stick");
        ClientRegisterHelper.registerVariantsName(DionaItems.tier_4_rocket_module, "moreplanets:tier_4_nose_cone", "moreplanets:tier_4_heavy_duty_plate", "moreplanets:tier_4_rocket_engine", "moreplanets:tier_4_booster", "moreplanets:tier_5_rocket_engine", "moreplanets:tier_5_booster");
        ClientRegisterHelper.registerVariantsName(DionaItems.laser_ammo, "moreplanets:normal_laser_ammo", "moreplanets:hyper_laser_ammo", "moreplanets:emp_laser_ammo", "moreplanets:uranium_laser_ammo", "moreplanets:icy_poison_laser_ammo");
        ClientRegisterHelper.registerVariantsName(FronosItems.fronos_food, "moreplanets:strawberry", "moreplanets:berry", "moreplanets:marshmallow", "moreplanets:cooked_marshmallow", "moreplanets:vanilla_ice_cream", "moreplanets:chocolate_ice_cream", "moreplanets:strawberry_ice_cream", "moreplanets:strawberry_cloud_ice_cream", "moreplanets:orange_ice_cream", "moreplanets:golden_bread", "moreplanets:little_sun_flower_seeds", "moreplanets:tea_ice_cream", "moreplanets:berry_salad", "moreplanets:sky_mushroom_stew", "moreplanets:rainbow_cloud_ice_cream", "moreplanets:lemon_ice_cream");
        ClientRegisterHelper.registerVariantsName(FronosItems.candy_food, "moreplanets:ovaltine_powder", "moreplanets:chocolate_bars", "moreplanets:caramel");
        ClientRegisterHelper.registerVariantsName(FronosItems.candy_cane, "moreplanets:pink_candy_cane_item", "moreplanets:orange_candy_cane_item", "moreplanets:green_candy_cane_item", "moreplanets:yellow_candy_cane_item", "moreplanets:light_blue_candy_cane_item", "moreplanets:blue_candy_cane_item", "moreplanets:red_candy_cane_item", "moreplanets:purple_candy_cane_item");
        ClientRegisterHelper.registerVariantsName(FronosItems.fronos_fruits, "moreplanets:kiwi", "moreplanets:lemon");
        ClientRegisterHelper.registerVariantsName(FronosItems.jelly, "moreplanets:grape_jelly", "moreplanets:raspberry_jelly", "moreplanets:strawberry_jelly", "moreplanets:berry_jelly", "moreplanets:lime_jelly", "moreplanets:orange_jelly", "moreplanets:green_jelly", "moreplanets:lemon_jelly");
        ClientRegisterHelper.registerVariantsName(FronosItems.fruits_juice, "moreplanets:strawberry_juice", "moreplanets:berry_juice", "moreplanets:kiwi_juice", "moreplanets:lemon_juice");
        ClientRegisterHelper.registerVariantsName(FronosItems.cream_ball, "moreplanets:vanilla_cream_ball", "moreplanets:chocolate_cream_ball", "moreplanets:strawberry_cream_ball", "moreplanets:orange_cream_ball", "moreplanets:tea_cream_ball", "moreplanets:lemon_cream_ball");
        ClientRegisterHelper.registerVariantsName(FronosItems.pearl, "moreplanets:cream_pearl", "moreplanets:cavern_pearl");
        ClientRegisterHelper.registerVariantsName(FronosItems.cream_golem, "moreplanets:vanilla_cream_golem", "moreplanets:chocolate_cream_golem", "moreplanets:strawberry_cream_golem", "moreplanets:orange_cream_golem", "moreplanets:tea_cream_golem", "moreplanets:lemon_cream_golem");
        ClientRegisterHelper.registerVariantsName(FronosItems.fronos_item, "moreplanets:mineral_crystal", "moreplanets:mineral_pieces", "moreplanets:black_diamond", "moreplanets:iridium_ingot", "moreplanets:compressed_black_diamond", "moreplanets:compressed_iridium", "moreplanets:golden_wheat", "moreplanets:fronos_rock_item", "moreplanets:strawberry_feather", "moreplanets:cheese_string");
        ClientRegisterHelper.registerVariantsName(FronosItems.tier_8_rocket_module, "moreplanets:tier_8_rocket_engine", "moreplanets:tier_8_booster", "moreplanets:tier_8_heavy_duty_plate");
        ClientRegisterHelper.registerVariantsName(FronosItems.candy_bow, "moreplanets:candy_bow", "moreplanets:candy_bow_pulling_0", "moreplanets:candy_bow_pulling_1", "moreplanets:candy_bow_pulling_2");
        ClientRegisterHelper.registerVariantsName(FronosItems.cup, "moreplanets:empty_cup", "moreplanets:mineral_water_cup", "moreplanets:ovaltine_cup", "moreplanets:coconut_milk_cup", "moreplanets:cheese_of_milk_cup", "moreplanets:tea_cup", "moreplanets:caramel_cup");
        ClientRegisterHelper.registerVariantsName(KoentusItems.koentus_item, "moreplanets:white_crystal", "moreplanets:emp_shard", "moreplanets:becterial_fossil", "moreplanets:raw_koentus_meteoric_iron", "moreplanets:koentus_meteoric_iron_ingot", "moreplanets:compressed_white_crystal", "moreplanets:compressed_koentus_meteoric_iron");
        ClientRegisterHelper.registerVariantsName(NibiruItems.nibiru_item, "moreplanets:red_gem", "moreplanets:norium_ingot", "moreplanets:compressed_red_gem", "moreplanets:compressed_norium", "moreplanets:red_gem_stick", "moreplanets:norium_stick");
        ClientRegisterHelper.registerVariantsName(NibiruItems.space_fruits, "moreplanets:space_apple", "moreplanets:space_orange", "moreplanets:orange_juice");
        ClientRegisterHelper.registerVariantsName(NibiruItems.tier_7_rocket_module, "moreplanets:tier_7_rocket_engine", "moreplanets:tier_7_booster", "moreplanets:tier_7_heavy_duty_plate", "moreplanets:tier_7_rocket_fin", "moreplanets:tier_7_nose_cone");
        ClientRegisterHelper.registerVariantsName(PolongniusItems.polongnius_item, "moreplanets:flonium", "moreplanets:purple_crystal", "moreplanets:raw_polongnius_meteoric_iron", "moreplanets:raw_palladium", "moreplanets:polongnius_meteoric_iron_ingot", "moreplanets:palladium_ingot", "moreplanets:compressed_polongnius_meteoric_iron", "moreplanets:compressed_palladium", "moreplanets:polongnius_meteoric_iron_stick", "moreplanets:palladium_stick", "moreplanets:cheese_leather", "moreplanets:cheese_spore");
        ClientRegisterHelper.registerVariantsName(PolongniusItems.purple_crystal_solar_module, "moreplanets:purple_crystal_wafer", "moreplanets:purple_crystal_solar_wafer", "moreplanets:purple_crystal_solar_single", "moreplanets:purple_crystal_solar_panel");
        ClientRegisterHelper.registerVariantsName(PolongniusItems.tier_6_rocket_module, "moreplanets:tier_6_rocket_engine", "moreplanets:tier_6_booster", "moreplanets:tier_6_heavy_duty_plate");
        ClientRegisterHelper.registerVariantsName(PolongniusItems.cheese_food, "moreplanets:cheese_of_milk_curd", "moreplanets:raw_cheese_beef", "moreplanets:cooked_cheese_beef");
        ClientRegisterHelper.registerVariantsName(KapteynBItems.kapteyn_b_item, "moreplanets:frozen_iron_ingot", "moreplanets:uranium_gem", "moreplanets:compressed_frozen_iron", "moreplanets:uranium_stick", "moreplanets:frozen_iron_stick", "moreplanets:ice_crystal_shard");
        ClientRegisterHelper.registerVariantsName(SiriusBItems.sirius_b_item, "moreplanets:small_diamond_pieces", "moreplanets:large_diamond_pieces", "moreplanets:sulfur_dust", "moreplanets:sulfur_ingot", "moreplanets:compressed_sulfur", "moreplanets:sulfur_stick");
        ClientRegisterHelper.registerVariantsName(MercuryItems.mercury_item, "moreplanets:metallic_shard", "moreplanets:raw_metal_meteoric_iron", "moreplanets:metallic_ingot", "moreplanets:metal_meteoric_iron_ingot", "moreplanets:compressed_metallic", "moreplanets:compressed_metal_meteoric_iron", "moreplanets:gravity_core", "moreplanets:gravity_controller");
        ClientRegisterHelper.registerVariantsName(VenusItems.venus_item, "moreplanets:lead_ingot");
        ClientRegisterHelper.registerVariantsName(PlutoItems.pluto_item, "moreplanets:xeonium_gem");
        ClientRegisterHelper.registerVariantsName(PlutoItems.space_potato, "moreplanets:space_potato", "moreplanets:baked_space_potato");
        ClientRegisterHelper.registerVariantsName(EuropaItems.europa_prismarine, "moreplanets:europa_prismarine_shard", "moreplanets:europa_prismarine_crystals");
        ClientRegisterHelper.registerVariantsName(EuropaItems.europa_food, "moreplanets:raw_europa_eel_meat", "moreplanets:cooked_europa_eel_meat");
        ClientRegisterHelper.registerVariantsName(MPItems.achievement_temp, "moreplanets:diona_planet");
        ClientRegisterHelper.registerVariantsName(MPItems.tier_2_thermal_padding, "moreplanets:tier_2_thermal_helmet", "moreplanets:tier_2_thermal_chestplate", "moreplanets:tier_2_thermal_leggings", "moreplanets:tier_2_thermal_boots");
        ClientRegisterHelper.registerVariantsName(MPItems.tier_3_thermal_padding, "moreplanets:tier_3_thermal_helmet", "moreplanets:tier_3_thermal_chestplate", "moreplanets:tier_3_thermal_leggings", "moreplanets:tier_3_thermal_boots");
    }
}