/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.moons.io.client.sky;

import java.util.Random;

import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.fml.client.FMLClientHandler;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class SkyProviderIo extends IRenderHandler
{
    private ResourceLocation jupiterTexture = new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/jupiter.png");
    private ResourceLocation sunTexture = new ResourceLocation("textures/environment/sun.png");

    public int starList;
    public int glSkyList;
    public int glSkyList2;

    public SkyProviderIo(IGalacticraftWorldProvider provider)
    {
        int displayLists = GLAllocation.generateDisplayLists(3);
        this.starList = displayLists;
        this.glSkyList = displayLists + 1;
        this.glSkyList2 = displayLists + 2;

        // Bind stars to display list
        GL11.glPushMatrix();
        GL11.glNewList(this.starList, GL11.GL_COMPILE);
        this.renderStars();
        GL11.glEndList();
        GL11.glPopMatrix();

        Tessellator tessellator = Tessellator.getInstance();
        GL11.glNewList(this.glSkyList, GL11.GL_COMPILE);
        byte byte2 = 64;
        int i = 256 / byte2 + 2;
        float f = 16F;

        for (int j = -byte2 * i; j <= byte2 * i; j += byte2)
        {
            for (int l = -byte2 * i; l <= byte2 * i; l += byte2)
            {
                tessellator.getWorldRenderer().startDrawingQuads();
                tessellator.getWorldRenderer().addVertex(j + 0, f, l + 0);
                tessellator.getWorldRenderer().addVertex(j + byte2, f, l + 0);
                tessellator.getWorldRenderer().addVertex(j + byte2, f, l + byte2);
                tessellator.getWorldRenderer().addVertex(j + 0, f, l + byte2);
                tessellator.draw();
            }
        }

        GL11.glEndList();
        GL11.glNewList(this.glSkyList2, GL11.GL_COMPILE);
        f = -16F;
        tessellator.getWorldRenderer().startDrawingQuads();

        for (int k = -byte2 * i; k <= byte2 * i; k += byte2)
        {
            for (int i1 = -byte2 * i; i1 <= byte2 * i; i1 += byte2)
            {
                tessellator.getWorldRenderer().addVertex(k + byte2, f, i1 + 0);
                tessellator.getWorldRenderer().addVertex(k + 0, f, i1 + 0);
                tessellator.getWorldRenderer().addVertex(k + 0, f, i1 + byte2);
                tessellator.getWorldRenderer().addVertex(k + byte2, f, i1 + byte2);
            }
        }
        tessellator.draw();
        GL11.glEndList();
    }

    public float getSkyBrightness(float par1)
    {
        float var2 = FMLClientHandler.instance().getClient().theWorld.getCelestialAngle(par1);
        float var3 = 1.0F - (MathHelper.sin(var2 * (float) Math.PI * 2.0F) * 2.0F + 0.25F);

        if (var3 < 0.0F)
        {
            var3 = 0.0F;
        }
        if (var3 > 1.0F)
        {
            var3 = 1.0F;
        }
        return var3 * var3 * 1F;
    }

    @Override
    public void render(float partialTicks, WorldClient world, Minecraft mc)
    {
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        RenderHelper.enableStandardItemLighting();
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        Vec3 vec3 = world.getSkyColor(mc.getRenderViewEntity(), partialTicks);
        float f1 = (float) vec3.xCoord;
        float f2 = (float) vec3.yCoord;
        float f3 = (float) vec3.zCoord;
        float f6;

        if (mc.gameSettings.anaglyph)
        {
            float f4 = (f1 * 30.0F + f2 * 59.0F + f3 * 11.0F) / 100.0F;
            float f5 = (f1 * 30.0F + f2 * 70.0F) / 100.0F;
            f6 = (f1 * 30.0F + f3 * 70.0F) / 100.0F;
            f1 = f4;
            f2 = f5;
            f3 = f6;
        }

        GL11.glColor3f(f1, f2, f3);
        Tessellator tessellator1 = Tessellator.getInstance();
        GL11.glDepthMask(false);
        GL11.glEnable(GL11.GL_FOG);
        GL11.glColor3f(f1, f2, f3);
        GL11.glCallList(this.glSkyList);
        GL11.glDisable(GL11.GL_FOG);
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        GL11.glEnable(GL11.GL_BLEND);
        // OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        RenderHelper.disableStandardItemLighting();
        float[] afloat = world.provider.calcSunriseSunsetColors(world.getCelestialAngle(partialTicks), partialTicks);
        float f7;
        float f8;
        float f9;
        float f10;

        float f18 = world.getStarBrightness(partialTicks);

        if (f18 > 0.0F)
        {
            GL11.glColor4f(f18, f18, f18, f18);
            GL11.glCallList(this.starList);
        }

        afloat = new float[4];
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glShadeModel(GL11.GL_SMOOTH);
        GL11.glPushMatrix();
        GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(world.getCelestialAngle(partialTicks) * 360.0F, 1.0F, 0.0F, 0.0F);
        afloat[0] = 255 / 255.0F;
        afloat[1] = 194 / 255.0F;
        afloat[2] = 180 / 255.0F;
        afloat[3] = 0.3F;
        f6 = afloat[0];
        f7 = afloat[1];
        f8 = afloat[2];
        float f11;
        float var12;

        if (mc.gameSettings.anaglyph)
        {
            f9 = (f6 * 30.0F + f7 * 59.0F + f8 * 11.0F) / 100.0F;
            f10 = (f6 * 30.0F + f7 * 70.0F) / 100.0F;
            f11 = (f6 * 30.0F + f8 * 70.0F) / 100.0F;
            f6 = f9;
            f7 = f10;
            f8 = f11;
        }

        Tessellator var23 = Tessellator.getInstance();
        tessellator1.getWorldRenderer().startDrawing(GL11.GL_TRIANGLE_FAN);
        tessellator1.getWorldRenderer().setColorRGBA_F(f6, f7, f8, afloat[3] * 2);
        tessellator1.getWorldRenderer().addVertex(0.0D, 100.0D, 0.0D);
        tessellator1.getWorldRenderer().setColorRGBA_F(afloat[0], afloat[1], afloat[2], 0.0F);

        // Render sun aura
        f10 = 25.0F;
        tessellator1.getWorldRenderer().addVertex(-f10, 100.0D, -f10);
        tessellator1.getWorldRenderer().addVertex(0, 100.0D, (double) -f10 * 1.5F);
        tessellator1.getWorldRenderer().addVertex(f10, 100.0D, -f10);
        tessellator1.getWorldRenderer().addVertex((double) f10 * 1.5F, 100.0D, 0);
        tessellator1.getWorldRenderer().addVertex(f10, 100.0D, f10);
        tessellator1.getWorldRenderer().addVertex(0, 100.0D, (double) f10 * 1.5F);
        tessellator1.getWorldRenderer().addVertex(-f10, 100.0D, f10);
        tessellator1.getWorldRenderer().addVertex((double) -f10 * 1.5F, 100.0D, 0);
        tessellator1.getWorldRenderer().addVertex(-f10, 100.0D, -f10);

        tessellator1.draw();
        tessellator1.getWorldRenderer().startDrawing(GL11.GL_TRIANGLE_FAN);
        tessellator1.getWorldRenderer().setColorRGBA_F(f6 * f18, f7 * f18, f8 * f18, afloat[3] * f18);
        tessellator1.getWorldRenderer().addVertex(0.0D, 100.0D, 0.0D);
        tessellator1.getWorldRenderer().setColorRGBA_F(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F);

        // Render larger sun aura
        f10 = 45.0F;
        tessellator1.getWorldRenderer().addVertex(-f10, 100.0D, -f10);
        tessellator1.getWorldRenderer().addVertex(0, 100.0D, (double) -f10 * 1.5F);
        tessellator1.getWorldRenderer().addVertex(f10, 100.0D, -f10);
        tessellator1.getWorldRenderer().addVertex((double) f10 * 1.5F, 100.0D, 0);
        tessellator1.getWorldRenderer().addVertex(f10, 100.0D, f10);
        tessellator1.getWorldRenderer().addVertex(0, 100.0D, (double) f10 * 1.5F);
        tessellator1.getWorldRenderer().addVertex(-f10, 100.0D, f10);
        tessellator1.getWorldRenderer().addVertex((double) -f10 * 1.5F, 100.0D, 0);
        tessellator1.getWorldRenderer().addVertex(-f10, 100.0D, -f10);

        tessellator1.draw();
        GL11.glPopMatrix();
        GL11.glShadeModel(GL11.GL_FLAT);

        GL11.glEnable(GL11.GL_TEXTURE_2D);
        OpenGlHelper.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE, GL11.GL_ONE, GL11.GL_ZERO);
        GL11.glPushMatrix();
        f7 = 0.0F;
        f8 = 0.0F;
        f9 = 0.0F;
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslatef(f7, f8, f9);
        GL11.glRotatef(-90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(world.getCelestialAngle(partialTicks) * 360.0F, 1.0F, 0.0F, 0.0F);

        // Render sun
        f10 = 19.0F;
        mc.renderEngine.bindTexture(this.sunTexture);
        tessellator1.getWorldRenderer().startDrawingQuads();
        tessellator1.getWorldRenderer().addVertexWithUV(-f10, 100.0D, -f10, 0.0D, 0.0D);
        tessellator1.getWorldRenderer().addVertexWithUV(f10, 100.0D, -f10, 1.0D, 0.0D);
        tessellator1.getWorldRenderer().addVertexWithUV(f10, 100.0D, f10, 1.0D, 1.0D);
        tessellator1.getWorldRenderer().addVertexWithUV(-f10, 100.0D, f10, 0.0D, 1.0D);
        tessellator1.draw();

        // JUPITER:
        var12 = 10.0F;
        float jupiterRotation = (float) (world.getSpawnPoint().getZ() - mc.thePlayer.posZ) * 0.01F;
        GL11.glScalef(0.6F, 0.6F, 0.6F);
        GL11.glRotatef(jupiterRotation, 1.0F, 0.0F, 0.0F);
        GL11.glRotatef(1.0F, 1.0F, 0.0F, 0.0F);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1F);
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(this.jupiterTexture);
        world.getMoonPhase();
        var23.getWorldRenderer().startDrawingQuads();
        var23.getWorldRenderer().addVertexWithUV(-var12, -75.0D, var12, 0, 1);
        var23.getWorldRenderer().addVertexWithUV(var12, -75.0D, var12, 1, 1);
        var23.getWorldRenderer().addVertexWithUV(var12, -75.0D, -var12, 1, 0);
        var23.getWorldRenderer().addVertexWithUV(-var12, -75.0D, -var12, 0, 0);
        var23.draw();

        GL11.glDisable(GL11.GL_TEXTURE_2D);

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glEnable(GL11.GL_FOG);
        GL11.glPopMatrix();
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glColor3f(0.0F, 0.0F, 0.0F);
        double d0 = mc.thePlayer.getPositionEyes(partialTicks).yCoord - world.getHorizon();

        if (d0 < 0.0D)
        {
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 12.0F, 0.0F);
            GL11.glCallList(this.glSkyList2);
            GL11.glPopMatrix();
            f8 = 1.0F;
            f9 = -((float) (d0 + 65.0D));
            f10 = -f8;
            tessellator1.getWorldRenderer().startDrawingQuads();
            tessellator1.getWorldRenderer().setColorRGBA_I(0, 255);
            tessellator1.getWorldRenderer().addVertex(-f8, f9, f8);
            tessellator1.getWorldRenderer().addVertex(f8, f9, f8);
            tessellator1.getWorldRenderer().addVertex(f8, f10, f8);
            tessellator1.getWorldRenderer().addVertex(-f8, f10, f8);
            tessellator1.getWorldRenderer().addVertex(-f8, f10, -f8);
            tessellator1.getWorldRenderer().addVertex(f8, f10, -f8);
            tessellator1.getWorldRenderer().addVertex(f8, f9, -f8);
            tessellator1.getWorldRenderer().addVertex(-f8, f9, -f8);
            tessellator1.getWorldRenderer().addVertex(f8, f10, -f8);
            tessellator1.getWorldRenderer().addVertex(f8, f10, f8);
            tessellator1.getWorldRenderer().addVertex(f8, f9, f8);
            tessellator1.getWorldRenderer().addVertex(f8, f9, -f8);
            tessellator1.getWorldRenderer().addVertex(-f8, f9, -f8);
            tessellator1.getWorldRenderer().addVertex(-f8, f9, f8);
            tessellator1.getWorldRenderer().addVertex(-f8, f10, f8);
            tessellator1.getWorldRenderer().addVertex(-f8, f10, -f8);
            tessellator1.getWorldRenderer().addVertex(-f8, f10, -f8);
            tessellator1.getWorldRenderer().addVertex(-f8, f10, f8);
            tessellator1.getWorldRenderer().addVertex(f8, f10, f8);
            tessellator1.getWorldRenderer().addVertex(f8, f10, -f8);
            tessellator1.draw();
        }

        if (world.provider.isSkyColored())
        {
            GL11.glColor3f(f1 * 0.2F + 0.04F, f2 * 0.2F + 0.04F, f3 * 0.6F + 0.1F);
        }
        else
        {
            GL11.glColor3f(f1, f2, f3);
        }

        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, -((float) (d0 - 16.0D)), 0.0F);
        GL11.glCallList(this.glSkyList2);
        GL11.glPopMatrix();
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDepthMask(true);
    }

    private void renderStars()
    {
        Random rand = new Random(10842L);
        Tessellator var2 = Tessellator.getInstance();
        var2.getWorldRenderer().startDrawingQuads();

        for (int starIndex = 0; starIndex < (ConfigManagerCore.moreStars ? 40000 : 6000); ++starIndex)
        {
            double var4 = rand.nextFloat() * 2.0F - 1.0F;
            double var6 = rand.nextFloat() * 2.0F - 1.0F;
            double var8 = rand.nextFloat() * 2.0F - 1.0F;
            double var10 = 0.15F + rand.nextFloat() * 0.1F;
            double var12 = var4 * var4 + var6 * var6 + var8 * var8;

            if (var12 < 1.0D && var12 > 0.01D)
            {
                var12 = 1.0D / Math.sqrt(var12);
                var4 *= var12;
                var6 *= var12;
                var8 *= var12;
                double var14 = var4 * (ConfigManagerCore.moreStars ? rand.nextDouble() * 150D + 130D : 100.0D);
                double var16 = var6 * (ConfigManagerCore.moreStars ? rand.nextDouble() * 150D + 130D : 100.0D);
                double var18 = var8 * (ConfigManagerCore.moreStars ? rand.nextDouble() * 150D + 130D : 100.0D);
                double var20 = Math.atan2(var4, var8);
                double var22 = Math.sin(var20);
                double var24 = Math.cos(var20);
                double var26 = Math.atan2(Math.sqrt(var4 * var4 + var8 * var8), var6);
                double var28 = Math.sin(var26);
                double var30 = Math.cos(var26);
                double var32 = rand.nextDouble() * Math.PI * 2.0D;
                double var34 = Math.sin(var32);
                double var36 = Math.cos(var32);

                for (int var38 = 0; var38 < 4; ++var38)
                {
                    double var39 = 0.0D;
                    double var41 = ((var38 & 2) - 1) * var10;
                    double var43 = ((var38 + 1 & 2) - 1) * var10;
                    double var47 = var41 * var36 - var43 * var34;
                    double var49 = var43 * var36 + var41 * var34;
                    double var53 = var47 * var28 + var39 * var30;
                    double var55 = var39 * var28 - var47 * var30;
                    double var57 = var55 * var22 - var49 * var24;
                    double var61 = var49 * var22 + var55 * var24;
                    var2.getWorldRenderer().addVertex(var14 + var57, var16 + var53, var18 + var61);
                }
            }
        }
        var2.draw();
    }
}