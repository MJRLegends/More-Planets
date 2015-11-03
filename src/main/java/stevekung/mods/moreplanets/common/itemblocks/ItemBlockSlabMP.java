package stevekung.mods.moreplanets.common.itemblocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockSlab.EnumBlockHalf;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class ItemBlockSlabMP extends ItemBlockBaseMP
{
	private BlockSlab singleSlab;
	private BlockSlab doubleSlab;

	public ItemBlockSlabMP(Block block, BlockSlab singleSlab, BlockSlab doubleSlab)
	{
		super(block);
		this.singleSlab = singleSlab;
		this.doubleSlab = doubleSlab;
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (itemStack.stackSize == 0)
		{
			return false;
		}
		else if (!player.canPlayerEdit(pos.offset(side), side, itemStack))
		{
			return false;
		}
		else
		{
			Object object = this.singleSlab.getVariant(itemStack);
			IBlockState state = world.getBlockState(pos);

			if (state.getBlock() == this.singleSlab)
			{
				IProperty iproperty = this.singleSlab.getVariantProperty();
				Comparable comparable = state.getValue(iproperty);
				EnumBlockHalf enumblockhalf = (EnumBlockHalf)state.getValue(BlockSlab.HALF);

				if ((side == EnumFacing.UP && enumblockhalf == EnumBlockHalf.BOTTOM || side == EnumFacing.DOWN && enumblockhalf == BlockSlab.EnumBlockHalf.TOP) && comparable == object)
				{
					IBlockState state1 = this.doubleSlab.getDefaultState().withProperty(iproperty, comparable);

					if (world.checkNoEntityCollision(this.doubleSlab.getCollisionBoundingBox(world, pos, state1)) && world.setBlockState(pos, state1, 3))
					{
						world.playSoundEffect(pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F, this.doubleSlab.stepSound.getPlaceSound(), (this.doubleSlab.stepSound.getVolume() + 1.0F) / 2.0F, this.doubleSlab.stepSound.getFrequency() * 0.8F);
						--itemStack.stackSize;
					}
					return true;
				}
			}
			return this.tryPlace(itemStack, world, pos.offset(side), object) ? true : super.onItemUse(itemStack, player, world, pos, side, hitX, hitY, hitZ);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean canPlaceBlockOnSide(World world, BlockPos pos, EnumFacing side, EntityPlayer player, ItemStack itemStack)
	{
		BlockPos blockpos1 = pos;
		IProperty iproperty = this.singleSlab.getVariantProperty();
		Object object = this.singleSlab.getVariant(itemStack);
		IBlockState state = world.getBlockState(pos);

		if (state.getBlock() == this.singleSlab)
		{
			boolean flag = state.getValue(BlockSlab.HALF) == BlockSlab.EnumBlockHalf.TOP;

			if ((side == EnumFacing.UP && !flag || side == EnumFacing.DOWN && flag) && object == state.getValue(iproperty))
			{
				return true;
			}
		}
		pos = pos.offset(side);
		IBlockState state1 = world.getBlockState(pos);
		return state1.getBlock() == this.singleSlab && object == state1.getValue(iproperty) ? true : super.canPlaceBlockOnSide(world, blockpos1, side, player, itemStack);
	}

	private boolean tryPlace(ItemStack itemStack, World world, BlockPos pos, Object variantInStack)
	{
		IBlockState state = world.getBlockState(pos);

		if (state.getBlock() == this.singleSlab)
		{
			Comparable comparable = state.getValue(this.singleSlab.getVariantProperty());

			if (comparable == variantInStack)
			{
				IBlockState state1 = this.doubleSlab.getDefaultState().withProperty(this.singleSlab.getVariantProperty(), comparable);

				if (world.checkNoEntityCollision(this.doubleSlab.getCollisionBoundingBox(world, pos, state1)) && world.setBlockState(pos, state1, 3))
				{
					world.playSoundEffect(pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F, this.doubleSlab.stepSound.getPlaceSound(), (this.doubleSlab.stepSound.getVolume() + 1.0F) / 2.0F, this.doubleSlab.stepSound.getFrequency() * 0.8F);
					--itemStack.stackSize;
				}
				return true;
			}
		}
		return false;
	}
}