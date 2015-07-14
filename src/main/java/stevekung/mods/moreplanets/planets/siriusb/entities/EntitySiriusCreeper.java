/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.siriusb.entities;

import micdoodle8.mods.galacticraft.api.entity.IEntityBreathable;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import stevekung.mods.moreplanets.common.config.ConfigManagerMP;
import stevekung.mods.moreplanets.common.entities.IEntityLivingPlanet;
import stevekung.mods.moreplanets.core.init.MPItems;

public class EntitySiriusCreeper extends EntityCreeper implements IEntityBreathable, IEntityLivingPlanet
{
	public EntitySiriusCreeper(World world)
	{
		super(world);
		this.isImmuneToFire = true;
	}

	@Override
	protected void updateAITasks()
	{
		if (this.isWet())
		{
			this.attackEntityFrom(DamageSource.drown, 1.0F);
		}
	}

	@Override
	public boolean canBreath()
	{
		return true;
	}

	@Override
	public ItemStack getPickedResult(MovingObjectPosition target)
	{
		return new ItemStack(MPItems.spawn_egg_mp, 1, 1030);
	}

	@Override
	public int canLivingInDimension()
	{
		return ConfigManagerMP.idDimensionSiriusB;
	}

	@Override
	public boolean getCanSpawnHere()
	{
		BlockPos pos = this.getPosition();

		if (this.worldObj.getDifficulty() != EnumDifficulty.PEACEFUL && this.worldObj.checkNoEntityCollision(this.getBoundingBox()) && this.worldObj.getCollidingBoundingBoxes(this, this.getBoundingBox()).isEmpty() && !this.worldObj.isAnyLiquid(this.getBoundingBox()) && this.worldObj.getLightBrightness(pos) >= 0.0F)
		{
			return true;
		}
		return false;
	}
}