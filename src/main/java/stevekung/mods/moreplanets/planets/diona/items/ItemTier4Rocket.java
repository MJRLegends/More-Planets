/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.diona.items;

import java.util.List;

import micdoodle8.mods.galacticraft.api.entity.IRocketType;
import micdoodle8.mods.galacticraft.api.entity.IRocketType.EnumRocketType;
import micdoodle8.mods.galacticraft.api.item.IHoldableItem;
import micdoodle8.mods.galacticraft.api.prefab.entity.EntityAutoRocket;
import micdoodle8.mods.galacticraft.core.GalacticraftCore;
import micdoodle8.mods.galacticraft.core.blocks.GCBlocks;
import micdoodle8.mods.galacticraft.core.tile.TileEntityLandingPad;
import micdoodle8.mods.galacticraft.core.util.GCCoreUtil;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.common.items.ItemMorePlanets;
import stevekung.mods.moreplanets.planets.diona.entities.EntityTier4Rocket;

public class ItemTier4Rocket extends ItemMorePlanets implements IHoldableItem
{
    public ItemTier4Rocket(String name)
    {
        super();
        this.setHasSubtypes(true);
        this.setMaxStackSize(1);
        this.setUnlocalizedName(name);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float par8, float par9, float par10)
    {
        boolean padFound = false;
        TileEntity tile = null;

        if (world.isRemote)
        {
            return false;
        }
        else
        {
            float centerX = -1;
            float centerY = -1;
            float centerZ = -1;

            for (int i = -1; i < 2; i++)
            {
                for (int j = -1; j < 2; j++)
                {
                    IBlockState state = world.getBlockState(new BlockPos(pos.getX() + i, pos.getY(), pos.getZ() + j));

                    if (state == GCBlocks.landingPadFull.getDefaultState())
                    {
                        padFound = true;
                        tile = world.getTileEntity(new BlockPos(pos.getX() + i, pos.getY(), pos.getZ() + j));
                        centerX = pos.getX() + i + 0.5F;
                        centerY = pos.getY() + 0.4F;
                        centerZ = pos.getZ() + j + 0.5F;
                        break;
                    }
                }
                if (padFound)
                {
                    break;
                }
            }

            if (padFound)
            {
                if (tile instanceof TileEntityLandingPad)
                {
                    if (((TileEntityLandingPad)tile).getDockedEntity() != null)
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }

                EntityAutoRocket rocket = new EntityTier4Rocket(world, centerX, centerY, centerZ, EnumRocketType.values()[itemStack.getItemDamage()]);
                rocket.setPosition(rocket.posX, rocket.posY + rocket.getOnPadYOffset(), rocket.posZ);
                world.spawnEntityInWorld(rocket);

                if (itemStack.hasTagCompound() && itemStack.getTagCompound().hasKey("RocketFuel"))
                {
                    rocket.fuelTank.fill(new FluidStack(GalacticraftCore.fluidFuel, itemStack.getTagCompound().getInteger("RocketFuel")), true);
                }
                if (!player.capabilities.isCreativeMode)
                {
                    itemStack.stackSize--;

                    if (itemStack.stackSize <= 0)
                    {
                        itemStack = null;
                    }
                }
                if (((IRocketType)rocket).getType().getPreFueled())
                {
                    if (rocket instanceof EntityTier4Rocket)
                    {
                        ((EntityTier4Rocket) rocket).fuelTank.fill(new FluidStack(GalacticraftCore.fluidFuel, rocket.getMaxFuel()), true);
                    }
                }
            }
            else
            {
                return false;
            }
        }
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs creativeTabs, List list)
    {
        for (int i = 0; i < EnumRocketType.values().length; i++)
        {
            list.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4)
    {
        EnumRocketType type = EnumRocketType.values()[itemStack.getItemDamage()];

        if (!type.getTooltip().isEmpty())
        {
            list.add(type.getTooltip());
        }
        if (type.getPreFueled())
        {
            list.add(EnumChatFormatting.RED + "" + EnumChatFormatting.ITALIC + GCCoreUtil.translate("gui.creativeOnly.desc"));
        }
        if (itemStack.hasTagCompound() && itemStack.getTagCompound().hasKey("RocketFuel"))
        {
            EntityAutoRocket rocket = new EntityTier4Rocket(FMLClientHandler.instance().getWorldClient(), 0, 0, 0, EnumRocketType.values()[itemStack.getItemDamage()]);
            list.add(GCCoreUtil.translate("gui.message.fuel.name") + ": " + itemStack.getTagCompound().getInteger("RocketFuel") + " / " + rocket.fuelTank.getCapacity());
        }
    }

    @Override
    public boolean shouldHoldLeftHandUp(EntityPlayer player)
    {
        return true;
    }

    @Override
    public boolean shouldHoldRightHandUp(EntityPlayer player)
    {
        return true;
    }

    @Override
    public boolean shouldCrouch(EntityPlayer player)
    {
        return true;
    }
}