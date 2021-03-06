/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.nibiru.blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.common.blocks.BlockTreasureChestMP;
import stevekung.mods.moreplanets.planets.nibiru.tileentities.TileEntityNibiruTreasureChest;

public class BlockNibiruTreasureChest extends BlockTreasureChestMP
{
    public BlockNibiruTreasureChest(String name)
    {
        super();
        this.setUnlocalizedName(name);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
            IInventory inv = this.getContainer(world, pos);

            if (inv != null)
            {
                player.displayGUIChest(inv);
            }
            return true;
        }
    }

    public IInventory getContainer(World world, BlockPos pos)
    {
        TileEntity tileentity = world.getTileEntity(pos);

        if (!(tileentity instanceof TileEntityNibiruTreasureChest))
        {
            return null;
        }
        else
        {
            Object object = tileentity;

            if (this.cannotOpenChest(world, pos))
            {
                return null;
            }
            else
            {
                return (IInventory)object;
            }
        }
    }

    @Override
    public int getComparatorInputOverride(World world, BlockPos pos)
    {
        return Container.calcRedstoneFromInventory(this.getContainer(world, pos));
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileEntityNibiruTreasureChest();
    }
}