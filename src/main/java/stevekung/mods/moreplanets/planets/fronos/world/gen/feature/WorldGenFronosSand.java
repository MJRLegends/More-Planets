/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.fronos.world.gen.feature;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import stevekung.mods.moreplanets.common.blocks.ICustomBlockProperty;
import stevekung.mods.moreplanets.planets.fronos.blocks.FronosBlocks;

public class WorldGenFronosSand extends WorldGenerator
{
    private IBlockState block;
    private int radius;

    public WorldGenFronosSand(IBlockState block, int radius)
    {
        this.block = block;
        this.radius = radius;
    }

    @Override
    public boolean generate(World world, Random rand, BlockPos pos)
    {
        if (world.getBlockState(pos).getBlock().getMaterial() != Material.water)
        {
            return false;
        }
        else
        {
            int i = rand.nextInt(this.radius - 2) + 2;
            byte b0 = 2;

            for (int j = pos.getX() - i; j <= pos.getX() + i; ++j)
            {
                for (int k = pos.getZ() - i; k <= pos.getZ() + i; ++k)
                {
                    int l = j - pos.getX();
                    int i1 = k - pos.getZ();

                    if (l * l + i1 * i1 <= i * i)
                    {
                        for (int j1 = pos.getY() - b0; j1 <= pos.getY() + b0; ++j1)
                        {
                            BlockPos blockpos1 = new BlockPos(j, j1, k);
                            Block block = world.getBlockState(blockpos1).getBlock();

                            if (block == FronosBlocks.fronos_dirt || block instanceof ICustomBlockProperty && ((ICustomBlockProperty)block).getProperty() == 0)
                            {
                                world.setBlockState(blockpos1, this.block, 2);
                            }
                        }
                    }
                }
            }
            return true;
        }
    }
}