/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.client;

import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;

public class SkyProviderMarsMP extends SkyProviderBaseMP
{
    private ResourceLocation overworldTexture = new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/earth.png");
    private ResourceLocation sunTexture = new ResourceLocation("textures/environment/sun.png");
    private ResourceLocation phobosTexture = new ResourceLocation("moreplanets:textures/gui/celestialbodies/phobos.png");
    private ResourceLocation deimosTexture = new ResourceLocation("moreplanets:textures/gui/celestialbodies/deimos.png");

    public SkyProviderMarsMP(IGalacticraftWorldProvider provider)
    {
        super();
        this.sunSize = 17.5F * provider.getSolarSize();
    }

    @Override
    protected void renderPlanetInSky(float partialTicks, WorldClient world, Minecraft mc)
    {
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        float f6;
        float f7;
        float f8;
        float f10;
        float f18 = world.getStarBrightness(partialTicks);

        float[] afloat = new float[4];
        GlStateManager.disableTexture2D();
        GlStateManager.shadeModel(7425);
        GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(world.getCelestialAngle(partialTicks) * 360.0F, 1.0F, 0.0F, 0.0F);
        afloat[0] = 255 / 255.0F;
        afloat[1] = 194 / 255.0F;
        afloat[2] = 180 / 255.0F;
        afloat[3] = 0.3F;
        f6 = afloat[0];
        f7 = afloat[1];
        f8 = afloat[2];
        f18 = 1.0F - f18;

        worldrenderer.func_181668_a(6, DefaultVertexFormats.field_181706_f);
        worldrenderer.func_181662_b(0.0D, 100.0D, 0.0D).func_181666_a(f6 * f18, f7 * f18, f8 * f18, afloat[3] * 2 / f18).func_181675_d();

        // Render sun aura
        f10 = 20.0F;
        worldrenderer.func_181662_b(-f10, 100.0D, -f10).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();
        worldrenderer.func_181662_b(0, 100.0D, (double) -f10 * 1.5F).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();
        worldrenderer.func_181662_b(f10, 100.0D, -f10).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();
        worldrenderer.func_181662_b((double) f10 * 1.5F, 100.0D, 0).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();
        worldrenderer.func_181662_b(f10, 100.0D, f10).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();
        worldrenderer.func_181662_b(0, 100.0D, (double) f10 * 1.5F).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();
        worldrenderer.func_181662_b(-f10, 100.0D, f10).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();
        worldrenderer.func_181662_b((double) -f10 * 1.5F, 100.0D, 0).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();
        worldrenderer.func_181662_b(-f10, 100.0D, -f10).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();

        tessellator.draw();
        worldrenderer.func_181668_a(6, DefaultVertexFormats.field_181706_f);
        worldrenderer.func_181662_b(0.0D, 100.0D, 0.0D).func_181666_a(f6 * f18, f7 * f18, f8 * f18, afloat[3] * f18).func_181675_d();

        // Render larger sun aura
        f10 = 40.0F;
        worldrenderer.func_181662_b(-f10, 100.0D, -f10).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();
        worldrenderer.func_181662_b(0, 100.0D, (double) -f10 * 1.5F).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();
        worldrenderer.func_181662_b(f10, 100.0D, -f10).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();
        worldrenderer.func_181662_b((double) f10 * 1.5F, 100.0D, 0).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();
        worldrenderer.func_181662_b(f10, 100.0D, f10).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();
        worldrenderer.func_181662_b(0, 100.0D, (double) f10 * 1.5F).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();
        worldrenderer.func_181662_b(-f10, 100.0D, f10).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();
        worldrenderer.func_181662_b((double) -f10 * 1.5F, 100.0D, 0).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();
        worldrenderer.func_181662_b(-f10, 100.0D, -f10).func_181666_a(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F).func_181675_d();
        tessellator.draw();
        GlStateManager.popMatrix();
        GlStateManager.shadeModel(7424);
        GlStateManager.disableTexture2D();
        GlStateManager.tryBlendFuncSeparate(770, 1, 1, 0);

        GlStateManager.pushMatrix();
        GlStateManager.translate(0.0F, 0.0F, 0.0F);
        GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(world.getCelestialAngle(partialTicks) * 360.0F, 1.0F, 0.0F, 0.0F);

        // Render sun
        GlStateManager.disableTexture2D();
        GlStateManager.blendFunc(770, 1);
        GlStateManager.color(0.0F, 0.0F, 0.0F, 1.0F);

        //Some blanking to conceal the stars
        f10 = this.sunSize / 3.5F;
        worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181705_e);
        worldrenderer.func_181662_b(-f10, 99.9D, -f10).func_181675_d();
        worldrenderer.func_181662_b(f10, 99.9D, -f10).func_181675_d();
        worldrenderer.func_181662_b(f10, 99.9D, f10).func_181675_d();
        worldrenderer.func_181662_b(-f10, 99.9D, f10).func_181675_d();
        tessellator.draw();
        GlStateManager.enableTexture2D();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        f10 = this.sunSize;
        mc.renderEngine.bindTexture(this.sunTexture);
        worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181705_e);
        worldrenderer.func_181662_b(-f10, 99.9D, -f10).func_181675_d();
        worldrenderer.func_181662_b(f10, 99.9D, -f10).func_181675_d();
        worldrenderer.func_181662_b(f10, 99.9D, f10).func_181675_d();
        worldrenderer.func_181662_b(-f10, 99.9D, f10).func_181675_d();
        tessellator.draw();

        // Render earth
        f10 = 0.5F;
        GlStateManager.scale(0.6F, 0.6F, 0.6F);
        GlStateManager.rotate(40.0F, 0.0F, 0.0F, 1.0F);
        GlStateManager.rotate(200F, 1.0F, 0.0F, 0.0F);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1F);
        mc.renderEngine.bindTexture(this.overworldTexture);
        worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181707_g);
        worldrenderer.func_181662_b(-f10, 100.0D, -f10).func_181673_a(0.0D, 0.0D).func_181675_d();
        worldrenderer.func_181662_b(f10, 100.0D, -f10).func_181673_a(1.0D, 0.0D).func_181675_d();
        worldrenderer.func_181662_b(f10, 100.0D, f10).func_181673_a(1.0D, 1.0D).func_181675_d();
        worldrenderer.func_181662_b(-f10, 100.0D, f10).func_181673_a(0.0D, 1.0D).func_181675_d();
        tessellator.draw();

        // Phobos
        f10 = 3.8F;
        GlStateManager.scale(0.6F, 0.6F, 0.6F);
        GlStateManager.rotate(40.0F, 0.0F, 0.0F, 1.0F);
        GlStateManager.rotate(200F, 1.0F, 0.0F, 0.0F);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1F);
        GlStateManager.rotate(world.getCelestialAngle(partialTicks) * 360.0F, 10.0F, 0.0F, 0.0F);
        mc.renderEngine.bindTexture(this.phobosTexture);
        worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181707_g);
        worldrenderer.func_181662_b(-f10, 100.0D, -f10).func_181673_a(0.0D, 0.0D).func_181675_d();
        worldrenderer.func_181662_b(f10, 100.0D, -f10).func_181673_a(1.0D, 0.0D).func_181675_d();
        worldrenderer.func_181662_b(f10, 100.0D, f10).func_181673_a(1.0D, 1.0D).func_181675_d();
        worldrenderer.func_181662_b(-f10, 100.0D, f10).func_181673_a(0.0D, 1.0D).func_181675_d();
        tessellator.draw();

        // Deimos
        f10 = 1.2F;
        GlStateManager.scale(0.6F, 0.6F, 0.6F);
        GlStateManager.rotate(40.0F, 0.0F, 0.0F, 1.0F);
        GlStateManager.rotate(200F, 1.0F, 0.0F, 0.0F);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1F);
        GlStateManager.rotate(world.getCelestialAngle(partialTicks) * 360.0F, 10.0F, 0.0F, 0.0F);
        mc.renderEngine.bindTexture(this.deimosTexture);
        worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181707_g);
        worldrenderer.func_181662_b(-f10, 100.0D, -f10).func_181673_a(0.0D, 0.0D).func_181675_d();
        worldrenderer.func_181662_b(f10, 100.0D, -f10).func_181673_a(1.0D, 0.0D).func_181675_d();
        worldrenderer.func_181662_b(f10, 100.0D, f10).func_181673_a(1.0D, 1.0D).func_181675_d();
        worldrenderer.func_181662_b(-f10, 100.0D, f10).func_181673_a(0.0D, 1.0D).func_181675_d();
        tessellator.draw();
    }

    @Override
    protected double[] getMaxStarCount()
    {
        return new double[] { 35000D, 150D, 130D };
    }

    @Override
    protected float[] getStarBrightness()
    {
        return null;
    }

    @Override
    protected boolean useDefaultStarBrightness()
    {
        return true;
    }
}