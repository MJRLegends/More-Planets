/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.venus.world.gen.village;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockTorch;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import stevekung.mods.moreplanets.planets.venus.blocks.BlockVenus;
import stevekung.mods.moreplanets.planets.venus.blocks.VenusBlocks;

public class ComponentVenusVillageHut extends ComponentVenusVillage
{
    private int averageGroundLevel = -1;

    public ComponentVenusVillageHut() {}

    public ComponentVenusVillageHut(ComponentVenusVillageStartPiece component, int type, StructureBoundingBox box, EnumFacing facing)
    {
        super(component, type);
        this.coordBaseMode = facing;
        this.boundingBox = box;
    }

    @Override
    protected void writeStructureToNBT(NBTTagCompound nbt)
    {
        super.writeStructureToNBT(nbt);
        nbt.setInteger("AvgGroundLevel", this.averageGroundLevel);
    }

    @Override
    protected void readStructureFromNBT(NBTTagCompound nbt)
    {
        super.readStructureFromNBT(nbt);
        this.averageGroundLevel = nbt.getInteger("AvgGroundLevel");
    }

    public static ComponentVenusVillageHut func_74908_a(ComponentVenusVillageStartPiece component, List<StructureComponent> list, int x, int y, int z, EnumFacing facing, int type)
    {
        StructureBoundingBox var8 = StructureBoundingBox.func_175897_a(x, y, z, 0, 0, 0, 17, 9, 17, facing);
        return StructureComponent.findIntersecting(list, var8) == null ? new ComponentVenusVillageHut(component, type, var8, facing) : null;
    }

    @Override
    public boolean addComponentParts(World world, Random rand, StructureBoundingBox box)
    {
        if (this.averageGroundLevel < 0)
        {
            this.averageGroundLevel = this.getAverageGroundLevel(world, box);

            if (this.averageGroundLevel < 0)
            {
                return true;
            }
            this.boundingBox.offset(0, this.averageGroundLevel - this.boundingBox.maxY + 9 - 1, 0);
        }

        this.fillWithAir(world, box, 3, 0, 3, 13, 9, 13);
        this.fillWithAir(world, box, 5, 0, 2, 11, 9, 14);
        this.fillWithAir(world, box, 2, 0, 5, 14, 9, 11);

        for (int i = 3; i <= 13; i++)
        {
            for (int j = 3; j <= 13; j++)
            {
                this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), i, 0, j, box);
            }
        }

        for (int i = 5; i <= 11; i++)
        {
            for (int j = 2; j <= 14; j++)
            {
                this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), i, 0, j, box);
            }
        }

        for (int i = 2; i <= 14; i++)
        {
            for (int j = 5; j <= 11; j++)
            {
                this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), i, 0, j, box);
            }
        }

        int yLevel = 0;

        for (yLevel = -8; yLevel < 4; yLevel++)
        {
            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 4, yLevel, 2, box);
            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 3, yLevel, 2, box);
            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 2, yLevel, 3, box);
            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 2, yLevel, 4, box);

            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 1, yLevel, 5, box);
            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 1, yLevel, 6, box);
            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 1, yLevel, 7, box);
            this.func_175811_a(world, yLevel <= 1 ? VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick) : Blocks.air.getDefaultState(), 1, yLevel, 8, box);
            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 1, yLevel, 9, box);
            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 1, yLevel, 10, box);
            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 1, yLevel, 11, box);

            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 2, yLevel, 12, box);
            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 2, yLevel, 13, box);
            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 3, yLevel, 14, box);
            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 4, yLevel, 14, box);

            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 5, yLevel, 15, box);
            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 6, yLevel, 15, box);
            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 7, yLevel, 15, box);
            this.func_175811_a(world, yLevel <= 1 ? VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick) : Blocks.air.getDefaultState(), 8, yLevel, 15, box);
            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 9, yLevel, 15, box);
            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 10, yLevel, 15, box);
            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 11, yLevel, 15, box);

            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 12, yLevel, 14, box);
            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 13, yLevel, 14, box);
            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 14, yLevel, 13, box);
            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 14, yLevel, 12, box);

            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 15, yLevel, 11, box);
            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 15, yLevel, 10, box);
            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 15, yLevel, 9, box);
            this.func_175811_a(world, yLevel <= 1 ? VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick) : Blocks.air.getDefaultState(), 15, yLevel, 8, box);
            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 15, yLevel, 7, box);
            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 15, yLevel, 6, box);
            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 15, yLevel, 5, box);

            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 14, yLevel, 4, box);
            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 14, yLevel, 3, box);
            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 13, yLevel, 2, box);
            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 12, yLevel, 2, box);

            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 11, yLevel, 1, box);
            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 10, yLevel, 1, box);
            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 9, yLevel, 1, box);
            this.func_175811_a(world, yLevel <= 1 ? VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick) : Blocks.air.getDefaultState(), 8, yLevel, 1, box);
            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 7, yLevel, 1, box);
            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 6, yLevel, 1, box);
            this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 5, yLevel, 1, box);
        }

        yLevel = 4;

        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 4, yLevel, 2, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 3, yLevel, 3, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 2, yLevel, 4, box);

        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 1, yLevel, 5, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 1, yLevel, 6, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 1, yLevel, 7, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 1, yLevel, 8, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 1, yLevel, 9, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 1, yLevel, 10, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 1, yLevel, 11, box);

        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 2, yLevel, 12, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 3, yLevel, 13, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 4, yLevel, 14, box);

        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 5, yLevel, 15, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 6, yLevel, 15, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 7, yLevel, 15, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 8, yLevel, 15, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 9, yLevel, 15, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 10, yLevel, 15, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 11, yLevel, 15, box);

        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 12, yLevel, 14, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 13, yLevel, 13, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 14, yLevel, 12, box);

        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 15, yLevel, 11, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 15, yLevel, 10, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 15, yLevel, 9, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 15, yLevel, 8, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 15, yLevel, 7, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 15, yLevel, 6, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 15, yLevel, 5, box);

        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 14, yLevel, 4, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 13, yLevel, 3, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 12, yLevel, 2, box);

        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 11, yLevel, 1, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 10, yLevel, 1, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 9, yLevel, 1, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 8, yLevel, 1, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 7, yLevel, 1, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 6, yLevel, 1, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 5, yLevel, 1, box);

        this.func_175811_a(world, VenusBlocks.sulfur_torch.getDefaultState().withProperty(BlockTorch.FACING, this.coordBaseMode.getOpposite()), 8, yLevel, 2, box);
        this.func_175811_a(world, VenusBlocks.sulfur_torch.getDefaultState().withProperty(BlockTorch.FACING, this.coordBaseMode.rotateY()), 14, yLevel, 8, box);
        this.func_175811_a(world, VenusBlocks.sulfur_torch.getDefaultState().withProperty(BlockTorch.FACING, this.coordBaseMode.rotateYCCW()), 8, yLevel, 14, box);
        this.func_175811_a(world, VenusBlocks.sulfur_torch.getDefaultState().withProperty(BlockTorch.FACING, this.coordBaseMode), 2, yLevel, 8, box);

        yLevel = 5;

        // corner 1
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 5, yLevel, 2, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 4, yLevel, 2, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 3, yLevel, 3, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 2, yLevel, 4, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 2, yLevel, 5, box);

        // side 1
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 1, yLevel, 6, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 1, yLevel, 7, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 1, yLevel, 8, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 1, yLevel, 9, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 1, yLevel, 10, box);

        // corner 2
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 2, yLevel, 11, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 2, yLevel, 12, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 3, yLevel, 13, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 4, yLevel, 14, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 5, yLevel, 14, box);

        // side 2
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 6, yLevel, 15, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 7, yLevel, 15, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 8, yLevel, 15, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 9, yLevel, 15, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 10, yLevel, 15, box);

        // corner 3
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 11, yLevel, 14, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 12, yLevel, 14, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 13, yLevel, 13, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 14, yLevel, 12, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 14, yLevel, 11, box);

        // side 3
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 15, yLevel, 10, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 15, yLevel, 9, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 15, yLevel, 8, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 15, yLevel, 7, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 15, yLevel, 6, box);

        // corner 4
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 14, yLevel, 5, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 14, yLevel, 4, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 13, yLevel, 3, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 12, yLevel, 2, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 11, yLevel, 2, box);

        // side 4
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 10, yLevel, 1, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 9, yLevel, 1, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 8, yLevel, 1, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 7, yLevel, 1, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 6, yLevel, 1, box);

        yLevel = 6;

        // corner 1
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 4, yLevel, 3, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 3, yLevel, 4, box);

        // side 1
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 2, yLevel, 5, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 2, yLevel, 6, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 2, yLevel, 7, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 2, yLevel, 8, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 2, yLevel, 9, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 2, yLevel, 10, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 2, yLevel, 11, box);

        // corner 2
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 3, yLevel, 12, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 4, yLevel, 13, box);

        // side 2
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 5, yLevel, 14, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 6, yLevel, 14, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 7, yLevel, 14, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 8, yLevel, 14, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 9, yLevel, 14, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 10, yLevel, 14, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 11, yLevel, 14, box);

        // corner 3
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 12, yLevel, 13, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 13, yLevel, 12, box);

        // side 3
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 14, yLevel, 11, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 14, yLevel, 10, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 14, yLevel, 9, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 14, yLevel, 8, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 14, yLevel, 7, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 14, yLevel, 6, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 14, yLevel, 5, box);

        // corner 4
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 13, yLevel, 4, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 12, yLevel, 3, box);

        // side 4
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 11, yLevel, 2, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 10, yLevel, 2, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 9, yLevel, 2, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 8, yLevel, 2, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 7, yLevel, 2, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 6, yLevel, 2, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 5, yLevel, 2, box);

        yLevel = 7;

        // corner 1
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 6, yLevel, 3, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 5, yLevel, 3, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 4, yLevel, 4, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 3, yLevel, 5, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 3, yLevel, 6, box);

        // side 1
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 2, yLevel, 7, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 2, yLevel, 8, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 2, yLevel, 9, box);

        // corner 2
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 3, yLevel, 10, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 3, yLevel, 11, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 4, yLevel, 12, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 5, yLevel, 13, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 6, yLevel, 13, box);

        // side 2
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 7, yLevel, 14, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 8, yLevel, 14, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 9, yLevel, 14, box);

        // corner 3
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 10, yLevel, 13, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 11, yLevel, 13, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 12, yLevel, 12, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 13, yLevel, 11, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 13, yLevel, 10, box);

        // side 3
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 14, yLevel, 9, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 14, yLevel, 8, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 14, yLevel, 7, box);

        // corner 4
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 13, yLevel, 6, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 13, yLevel, 5, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 12, yLevel, 4, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 11, yLevel, 3, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 10, yLevel, 3, box);

        // side 4
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 9, yLevel, 2, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 8, yLevel, 2, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 7, yLevel, 2, box);

        yLevel = 8;

        // corner 1
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 6, yLevel, 4, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 5, yLevel, 4, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 4, yLevel, 5, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 4, yLevel, 6, box);

        // side 1
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 3, yLevel, 7, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 3, yLevel, 8, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 3, yLevel, 9, box);

        // corner 2
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 4, yLevel, 10, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 4, yLevel, 11, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 5, yLevel, 12, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 6, yLevel, 12, box);

        // side 2
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 7, yLevel, 13, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 8, yLevel, 13, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 9, yLevel, 13, box);

        // corner 3
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 10, yLevel, 12, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 11, yLevel, 12, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 12, yLevel, 11, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 12, yLevel, 10, box);

        // side 3
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 13, yLevel, 9, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 13, yLevel, 8, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 13, yLevel, 7, box);

        // corner 4
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 12, yLevel, 6, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 12, yLevel, 5, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 11, yLevel, 4, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 10, yLevel, 4, box);

        // side 4
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 9, yLevel, 3, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 8, yLevel, 3, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 7, yLevel, 3, box);

        // extras
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 5, yLevel, 5, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 5, yLevel, 11, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 11, yLevel, 11, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 11, yLevel, 5, box);

        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 4, yLevel, 7, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 4, yLevel, 8, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 4, yLevel, 9, box);

        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 7, yLevel, 12, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 8, yLevel, 12, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 9, yLevel, 12, box);

        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 9, yLevel, 4, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 8, yLevel, 4, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 7, yLevel, 4, box);

        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 12, yLevel, 7, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 12, yLevel, 8, box);
        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), 12, yLevel, 9, box);

        yLevel = 9;

        for (int i = 5; i <= 11; i++)
        {
            for (int j = 5; j <= 11; j++)
            {
                if (!(j == 5 && i == 5 || j == 5 && i == 11 || j == 11 && i == 5 || j == 11 && i == 11))
                {
                    if (i >= 7 && i <= 9 && j >= 7 && j <= 9)
                    {
                        this.func_175811_a(world, Blocks.glass.getDefaultState(), i, yLevel, j, box);
                    }
                    else
                    {
                        this.func_175811_a(world, VenusBlocks.venus_block.getDefaultState().withProperty(BlockVenus.VARIANT, BlockVenus.BlockType.cracked_venus_stone_brick), i, yLevel, j, box);
                    }
                }
            }
        }
        this.spawnVillagers(world, box, 6, 5, 6, 4);
        return true;
    }
}