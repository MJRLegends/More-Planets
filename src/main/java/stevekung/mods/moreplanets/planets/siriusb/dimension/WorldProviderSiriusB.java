/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.siriusb.dimension;

import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.vector.Vector3;
import net.minecraft.util.MathHelper;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.common.dimension.WorldProviderMP;
import stevekung.mods.moreplanets.common.world.gen.WorldChunkManagerPlanetBase;
import stevekung.mods.moreplanets.core.init.MPPlanets;
import stevekung.mods.moreplanets.planets.siriusb.world.gen.ChunkProviderSiriusB;

public class WorldProviderSiriusB extends WorldProviderMP
{
    @Override
    public Vector3 getFogColor()
    {
        return new Vector3(0, 0, 0);
    }

    @Override
    public Vector3 getSkyColor()
    {
        return new Vector3(0, 0, 0);
    }

    @Override
    public long getDayLength()
    {
        return 66000L;
    }

    @Override
    public Class<? extends IChunkProvider> getChunkProviderClass()
    {
        return ChunkProviderSiriusB.class;
    }

    @Override
    public Class<? extends WorldChunkManager> getWorldChunkManagerClass()
    {
        return WorldChunkManagerPlanetBase.class;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public float getStarBrightness(float bright)
    {
        float f1 = this.worldObj.getCelestialAngle(bright);
        float f2 = 1.0F - (MathHelper.cos(f1 * (float) Math.PI * 2.0F) * 2.0F + 0.25F);

        if (f2 < 0.0F)
        {
            f2 = 0.0F;
        }
        if (f2 > 1.0F)
        {
            f2 = 1.0F;
        }
        return f2 * f2 * 0.75F;
    }

    @Override
    public double getSolarEnergyMultiplier()
    {
        return 25.0D;
    }

    @Override
    public float getGravity()
    {
        return -0.015F;
    }

    @Override
    public double getMeteorFrequency()
    {
        return 0.0D;
    }

    @Override
    public boolean canSpaceshipTierPass(int tier)
    {
        return tier >= 8;
    }

    @Override
    public float getFallDamageModifier()
    {
        return 1.25F;
    }

    @Override
    public float getSoundVolReductionAmount()
    {
        return 20.0F;
    }

    @Override
    public CelestialBody getCelestialBody()
    {
        return MPPlanets.siriusB;
    }

    @Override
    public boolean hasBreathableAtmosphere()
    {
        return false;
    }

    @Override
    public float getThermalLevelModifier()
    {
        return 10.0F;
    }

    @Override
    public float getWindLevel()
    {
        return 0.01F;
    }

    @Override
    public double getUltraVioletEnergyMultiplie()
    {
        return 75.0D;
    }

    @Override
    public String getInternalNameSuffix()
    {
        return "_siriusb";
    }
}