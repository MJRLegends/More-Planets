/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.diona.blocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import stevekung.mods.moreplanets.common.blocks.BlockStairsMP;
import stevekung.mods.moreplanets.common.itemblocks.ItemBlockMultiVariant;
import stevekung.mods.moreplanets.common.util.VariantsName;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class DionaBlocks
{
    public static Block diona_block;
    public static Block diona_treasure_chest;
    public static Block fronisium_tnt;
    public static Block creeper_minion_egg;
    public static Block diona_cobblestone_stairs;
    public static Block chiseled_quontonium_stairs;
    public static Block quontonium_brick_stairs;
    public static Block diona_dungeon_brick_stairs;
    public static Block diona_ancient_chest;
    public static Block green_redstone_torch;
    public static Block green_redstone_torch_off;

    public static void init()
    {
        // Init
        DionaBlocks.diona_block = new BlockDiona("diona_block");
        DionaBlocks.diona_treasure_chest = new BlockDionaTreasureChest("diona_treasure_chest");
        DionaBlocks.fronisium_tnt = new BlockFronisiumTNT("fronisium_tnt");
        DionaBlocks.creeper_minion_egg = new BlockCreeperMinionEgg("creeper_minion_egg");
        DionaBlocks.diona_cobblestone_stairs = new BlockStairsMP(Blocks.stone, "diona_cobblestone_stairs", 2.0F);
        DionaBlocks.chiseled_quontonium_stairs = new BlockStairsMP(Blocks.stone, "chiseled_quontonium_stairs", 2.5F);
        DionaBlocks.quontonium_brick_stairs = new BlockStairsMP(Blocks.stone, "quontonium_brick_stairs", 2.5F);
        DionaBlocks.diona_dungeon_brick_stairs = new BlockStairsMP(Blocks.stone, "diona_dungeon_brick_stairs", 4.0F);
        DionaBlocks.diona_ancient_chest = new BlockDionaAncientChest("diona_ancient_chest");
        DionaBlocks.green_redstone_torch = new BlockGreenRedstoneTorch("green_redstone_torch", true).setLightLevel(0.5F);
        DionaBlocks.green_redstone_torch_off = new BlockGreenRedstoneTorch("green_redstone_torch_off", false);

        // Register
        CommonRegisterHelper.registerBlock(DionaBlocks.diona_block, ItemBlockMultiVariant.class, new VariantsName("surface_rock", "sub_surface", "rock", "cobblestone", "quontonium_ore", "fronisium_ore", "tin_ore", "copper_ore", "silicon_ore", "aluminum_ore", "quontonium_block", "fronisium_block", "smooth_quontonium", "quontonium_brick", "chiseled_quontonium", "dungeon_brick"));
        CommonRegisterHelper.registerBlock(DionaBlocks.diona_cobblestone_stairs);
        CommonRegisterHelper.registerBlock(DionaBlocks.quontonium_brick_stairs);
        CommonRegisterHelper.registerBlock(DionaBlocks.chiseled_quontonium_stairs);
        CommonRegisterHelper.registerBlock(DionaBlocks.diona_dungeon_brick_stairs);
        CommonRegisterHelper.registerBlock(DionaBlocks.fronisium_tnt);
        CommonRegisterHelper.registerBlock(DionaBlocks.creeper_minion_egg);
        CommonRegisterHelper.registerBlock(DionaBlocks.diona_treasure_chest);
        CommonRegisterHelper.registerBlock(DionaBlocks.diona_ancient_chest);
        CommonRegisterHelper.registerBlock(DionaBlocks.green_redstone_torch);
        CommonRegisterHelper.registerBlock(DionaBlocks.green_redstone_torch_off);

        // Set harvest level
        CommonRegisterHelper.setBlockHarvestLevel(DionaBlocks.diona_cobblestone_stairs, "pickaxe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(DionaBlocks.chiseled_quontonium_stairs, "pickaxe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(DionaBlocks.quontonium_brick_stairs, "pickaxe", 0);
        CommonRegisterHelper.setBlockHarvestLevel(DionaBlocks.diona_dungeon_brick_stairs, "pickaxe", 1);
        CommonRegisterHelper.setBlockHarvestLevel(DionaBlocks.diona_ancient_chest, "axe", 0);

        // Register ore dictionary
        OreDictionary.registerOre("oreQuontonium", new ItemStack(DionaBlocks.diona_block, 1, 4));
        OreDictionary.registerOre("oreFronisium", new ItemStack(DionaBlocks.diona_block, 1, 5));
        OreDictionary.registerOre("oreTin", new ItemStack(DionaBlocks.diona_block, 1, 6));
        OreDictionary.registerOre("oreCopper", new ItemStack(DionaBlocks.diona_block, 1, 7));
        OreDictionary.registerOre("oreSilicon", new ItemStack(DionaBlocks.diona_block, 1, 8));
        OreDictionary.registerOre("oreAluminum", new ItemStack(DionaBlocks.diona_block, 1, 9));
        OreDictionary.registerOre("oreAluminium", new ItemStack(DionaBlocks.diona_block, 1, 9));
        OreDictionary.registerOre("blockQuontonium", new ItemStack(DionaBlocks.diona_block, 1, 10));
        OreDictionary.registerOre("blockFronisium", new ItemStack(DionaBlocks.diona_block, 1, 11));
    }
}