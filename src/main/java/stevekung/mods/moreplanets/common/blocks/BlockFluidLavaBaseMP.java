/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import stevekung.mods.moreplanets.client.EnumParticleTypesMP;
import stevekung.mods.moreplanets.core.MorePlanetsCore;

public abstract class BlockFluidLavaBaseMP extends BlockFluidBaseMP
{
    public BlockFluidLavaBaseMP(Fluid fluid)
    {
        super(fluid, Material.lava);
        this.setQuantaPerBlock(4);
        this.setHardness(100.0F);
        this.setResistance(100.0F);
        this.setTickRandomly(true);
    }

    @Override
    public int getLightValue(IBlockAccess world, BlockPos pos)
    {
        return 15;
    }

    @Override
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.SOLID;
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
    {
        super.updateTick(world, pos, state, rand);
        this.checkForMixing(world, pos, state);

        if (this.canFlowingInto(world, pos.down(), world.getBlockState(pos.down())))
        {
            if (this.blockMaterial == Material.lava && world.getBlockState(pos.down()).getBlock().getMaterial() == Material.water)
            {
                world.setBlockState(pos.down(), this.getBlockFromWaterTo());
                this.triggerMixEffects(world, pos.down());
                return;
            }
        }

        if (world.getGameRules().getGameRuleBooleanValue("doFireTick"))
        {
            int i = rand.nextInt(3);

            if (i > 0)
            {
                BlockPos blockpos1 = pos;

                for (int j = 0; j < i; ++j)
                {
                    blockpos1 = blockpos1.add(rand.nextInt(3) - 1, 1, rand.nextInt(3) - 1);
                    Block block = world.getBlockState(blockpos1).getBlock();

                    if (block.getMaterial() == Material.air)
                    {
                        if (this.isSurroundingBlockFlammable(world, blockpos1))
                        {
                            world.setBlockState(blockpos1, this.getFireBlock());
                            return;
                        }
                    }
                    else if (block.getMaterial().blocksMovement())
                    {
                        return;
                    }
                }
            }
            else
            {
                for (int k = 0; k < 3; ++k)
                {
                    BlockPos blockpos2 = pos.add(rand.nextInt(3) - 1, 0, rand.nextInt(3) - 1);

                    if (world.isAirBlock(blockpos2.up()) && this.getCanBlockBurn(world, blockpos2))
                    {
                        world.setBlockState(blockpos2.up(), this.getFireBlock());
                    }
                }
            }
        }
    }

    protected void triggerMixEffects(World world, BlockPos pos)
    {
        world.playSoundEffect(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, "random.fizz", 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);

        for (int i = 0; i < 8; ++i)
        {
            MorePlanetsCore.proxy.spawnParticle(EnumParticleTypesMP.MC_LARGE_SMOKE, pos.getX() + Math.random(), pos.getY() + 1.2D, pos.getZ() + Math.random(), 0.0D, 0.0D, 0.0D);
        }
    }

    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity)
    {
        entity.setFire(10);
    }

    @Override
    public void onNeighborBlockChange(World world, BlockPos pos, IBlockState state, Block block)
    {
        this.checkForMixing(world, pos, state);

        if (block.getMaterial() != Material.lava)
        {
            world.playSoundEffect(pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F, "random.fizz", 0.15F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
        }
        super.onNeighborBlockChange(world, pos, state, block);
    }

    public boolean checkForMixing(World world, BlockPos pos, IBlockState state)
    {
        boolean flag = false;
        EnumFacing[] aenumfacing = EnumFacing.values();
        int i = aenumfacing.length;

        for (int j = 0; j < i; ++j)
        {
            EnumFacing enumfacing = aenumfacing[j];

            if (enumfacing != EnumFacing.DOWN && world.getBlockState(pos.offset(enumfacing)).getBlock().getMaterial() == Material.water)
            {
                flag = true;
                break;
            }
        }

        if (flag)
        {
            Integer integer = (Integer)state.getValue(LEVEL);

            if (integer.intValue() == 0)
            {
                world.setBlockState(pos, this.getObsidianBlock());
                this.triggerMixEffects(world, pos);
                return true;
            }
            if (integer.intValue() <= 4)
            {
                world.setBlockState(pos, this.getCobblestoneBlock());
                this.triggerMixEffects(world, pos);
                return true;
            }
        }
        return false;
    }

    private boolean canFlowingInto(World world, BlockPos pos, IBlockState state)
    {
        Material material = state.getBlock().getMaterial();
        return material != this.blockMaterial && material != Material.lava && !this.isBlocked(world, pos, state);
    }

    private boolean isBlocked(World world, BlockPos pos, IBlockState state)
    {
        Block block = world.getBlockState(pos).getBlock();
        return !(block instanceof BlockDoor) && block != Blocks.standing_sign && block != Blocks.ladder && block != Blocks.reeds ? block.getMaterial() == Material.portal ? true : block.getMaterial().blocksMovement() : true;
    }

    protected boolean isSurroundingBlockFlammable(World world, BlockPos pos)
    {
        EnumFacing[] aenumfacing = EnumFacing.values();
        int i = aenumfacing.length;

        for (int j = 0; j < i; ++j)
        {
            EnumFacing enumfacing = aenumfacing[j];

            if (this.getCanBlockBurn(world, pos.offset(enumfacing)))
            {
                return true;
            }
        }
        return false;
    }

    private boolean getCanBlockBurn(World world, BlockPos pos)
    {
        return world.getBlockState(pos).getBlock().getMaterial().getCanBurn();
    }

    @Override
    protected boolean isInfinite()
    {
        return false;
    }

    protected abstract IBlockState getBlockFromWaterTo();
    protected abstract IBlockState getObsidianBlock();
    protected abstract IBlockState getCobblestoneBlock();
    protected abstract IBlockState getFireBlock();
}