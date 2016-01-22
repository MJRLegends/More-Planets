/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.kapteynb.tileentities;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ITickable;
import net.minecraft.world.World;

public class TileEntityFrozenWaterGeyser extends TileEntity implements ITickable
{
    @Override
    public void update()
    {
        if (!World.doesBlockHaveSolidTopSurface(this.worldObj, this.pos.up()))
        {
            if (!this.worldObj.isRemote)
            {
                List<EntityLivingBase> living = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, AxisAlignedBB.fromBounds(this.pos.getX(), this.pos.getY(), this.pos.getZ(), this.pos.getX() + 1, this.pos.getY() + 8, this.pos.getZ() + 1));

                for (EntityLivingBase e : living)
                {
                    e.motionY = 1.5D;
                    e.fallDistance = 0.0F;
                    e.extinguish();
                    e.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 120, 1));
                }
            }
            else
            {
                List<EntityPlayer> player = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.fromBounds(this.pos.getX(), this.pos.getY(), this.pos.getZ(), this.pos.getX() + 1, this.pos.getY() + 8, this.pos.getZ() + 1));

                for (EntityPlayer e : player)
                {
                    if (!e.capabilities.isFlying)
                    {
                        e.motionY = 1.5D;
                        e.fallDistance = 0.0F;
                        e.extinguish();
                        e.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 120, 1));
                    }
                }
            }
        }
    }
}