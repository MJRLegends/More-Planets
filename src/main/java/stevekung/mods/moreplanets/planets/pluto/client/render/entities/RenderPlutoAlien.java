/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.pluto.client.render.entities;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.planets.pluto.client.models.ModelPlutoAlien;
import stevekung.mods.moreplanets.planets.pluto.entities.EntityPlutoAlien;

@SideOnly(Side.CLIENT)
public class RenderPlutoAlien extends RenderLiving
{
    private ResourceLocation texture = new ResourceLocation("moreplanets:textures/entity/pluto_alien.png");

    public RenderPlutoAlien(RenderManager render)
    {
        super(render, new ModelPlutoAlien(), 0.5F);
    }

    protected void preRenderCallback(EntityPlutoAlien entity, float partialTicks)
    {
        float f1 = entity.getCreeperFlashIntensity(partialTicks);
        float f2 = 1.0F + MathHelper.sin(f1 * 100.0F) * f1 * 0.01F;
        f1 = MathHelper.clamp_float(f1, 0.0F, 1.0F);
        f1 *= f1;
        f1 *= f1;
        float f3 = (1.0F + f1 * 0.4F) * f2;
        float f4 = (1.0F + f1 * 0.1F) / f2;
        GlStateManager.scale(f3, f4, f3);
    }

    protected int getColorMultiplier(EntityPlutoAlien entity, float partialTicks)
    {
        float f2 = entity.getCreeperFlashIntensity(partialTicks);

        if ((int)(f2 * 10.0F) % 2 == 0)
        {
            return 0;
        }
        else
        {
            int i = (int)(f2 * 0.2F * 255.0F);
            i = MathHelper.clamp_int(i, 0, 255);
            return i << 24 | 16777215;
        }
    }

    @Override
    protected void preRenderCallback(EntityLivingBase entity, float partialTicks)
    {
        this.preRenderCallback((EntityPlutoAlien)entity, partialTicks);
    }

    @Override
    protected int getColorMultiplier(EntityLivingBase entity, float p_77030_2_, float partialTicks)
    {
        return this.getColorMultiplier((EntityPlutoAlien)entity, partialTicks);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return this.texture;
    }
}