/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.eventhandler;

import java.util.Random;

import micdoodle8.mods.galacticraft.api.world.IGalacticraftWorldProvider;
import micdoodle8.mods.galacticraft.core.util.ConfigManagerCore;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.fml.client.FMLClientHandler;

import org.lwjgl.opengl.GL11;

public class SkyProviderMarsMP extends IRenderHandler
{
	private ResourceLocation overworldTexture = new ResourceLocation("galacticraftcore:textures/gui/celestialbodies/earth.png");
	private ResourceLocation sunTexture = new ResourceLocation("textures/environment/sun.png");
	private ResourceLocation phobosTexture = new ResourceLocation("moreplanets:textures/gui/celestialbodies/phobos.png");
	private ResourceLocation deimosTexture = new ResourceLocation("moreplanets:textures/gui/celestialbodies/deimos.png");

	public int starList;
	public int glSkyList;
	public int glSkyList2;
	private float sunSize;

	public SkyProviderMarsMP(IGalacticraftWorldProvider marsProvider)
	{
		this.sunSize = 17.5F * marsProvider.getSolarSize();

		int displayLists = GLAllocation.generateDisplayLists(3);
		this.starList = displayLists;
		this.glSkyList = displayLists + 1;
		this.glSkyList2 = displayLists + 2;

		// Bind stars to display list
		GlStateManager.pushMatrix();
		GL11.glNewList(this.starList, GL11.GL_COMPILE);
		this.renderStars();
		GL11.glEndList();
		GlStateManager.popMatrix();

		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldRender = tessellator.getWorldRenderer();
		GL11.glNewList(this.glSkyList, GL11.GL_COMPILE);
		byte byte2 = 64;
		int i = 256 / byte2 + 2;
		float f = 16F;

		for (int j = -byte2 * i; j <= byte2 * i; j += byte2)
		{
			for (int l = -byte2 * i; l <= byte2 * i; l += byte2)
			{
				worldRender.startDrawingQuads();
				worldRender.addVertex(j + 0, f, l + 0);
				worldRender.addVertex(j + byte2, f, l + 0);
				worldRender.addVertex(j + byte2, f, l + byte2);
				worldRender.addVertex(j + 0, f, l + byte2);
				tessellator.draw();
			}
		}

		GL11.glEndList();
		GL11.glNewList(this.glSkyList2, GL11.GL_COMPILE);
		f = -16F;
		worldRender.startDrawingQuads();

		for (int k = -byte2 * i; k <= byte2 * i; k += byte2)
		{
			for (int i1 = -byte2 * i; i1 <= byte2 * i; i1 += byte2)
			{
				worldRender.addVertex(k + byte2, f, i1 + 0);
				worldRender.addVertex(k + 0, f, i1 + 0);
				worldRender.addVertex(k + 0, f, i1 + byte2);
				worldRender.addVertex(k + byte2, f, i1 + byte2);
			}
		}
		tessellator.draw();
		GL11.glEndList();
	}

	@Override
	public void render(float partialTicks, WorldClient world, Minecraft mc)
	{
		GlStateManager.disableTexture2D();
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

		GlStateManager.color(f1, f2, f3);
		Tessellator tessellator1 = Tessellator.getInstance();
		WorldRenderer worldRender = tessellator1.getWorldRenderer();
		GlStateManager.depthMask(false);
		GlStateManager.enableFog();
		GlStateManager.color(f1, f2, f3);
		GlStateManager.callList(this.glSkyList);
		GlStateManager.disableFog();
		GlStateManager.disableAlpha();
		GlStateManager.enableBlend();
		OpenGlHelper.glBlendFunc(770, 771, 1, 0);
		RenderHelper.disableStandardItemLighting();
		float f7;
		float f8;
		float f9;
		float f10;
		float f18 = world.getStarBrightness(partialTicks);

		if (f18 > 0.0F)
		{
			GlStateManager.color(f18, f18, f18, f18);
			GlStateManager.callList(this.starList);
		}

		float[] afloat = new float[4];
		GlStateManager.disableTexture2D();
		GlStateManager.shadeModel(GL11.GL_SMOOTH);
		GlStateManager.pushMatrix();
		GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(world.getCelestialAngle(partialTicks) * 360.0F, 1.0F, 0.0F, 0.0F);
		afloat[0] = 255 / 255.0F;
		afloat[1] = 194 / 255.0F;
		afloat[2] = 180 / 255.0F;
		afloat[3] = 0.3F;
		f6 = afloat[0];
		f7 = afloat[1];
		f8 = afloat[2];
		float f11;

		if (mc.gameSettings.anaglyph)
		{
			f9 = (f6 * 30.0F + f7 * 59.0F + f8 * 11.0F) / 100.0F;
			f10 = (f6 * 30.0F + f7 * 70.0F) / 100.0F;
			f11 = (f6 * 30.0F + f8 * 70.0F) / 100.0F;
			f6 = f9;
			f7 = f10;
			f8 = f11;
		}

		f18 = 1.0F - f18;

		worldRender.startDrawing(GL11.GL_TRIANGLE_FAN);
		worldRender.setColorRGBA_F(f6 * f18, f7 * f18, f8 * f18, afloat[3] * 2 / f18);
		worldRender.addVertex(0.0D, 100.0D, 0.0D);
		worldRender.setColorRGBA_F(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F);

		// Render sun aura
		f10 = 20.0F;
		worldRender.addVertex(-f10, 100.0D, -f10);
		worldRender.addVertex(0, 100.0D, (double) -f10 * 1.5F);
		worldRender.addVertex(f10, 100.0D, -f10);
		worldRender.addVertex((double) f10 * 1.5F, 100.0D, 0);
		worldRender.addVertex(f10, 100.0D, f10);
		worldRender.addVertex(0, 100.0D, (double) f10 * 1.5F);
		worldRender.addVertex(-f10, 100.0D, f10);
		worldRender.addVertex((double) -f10 * 1.5F, 100.0D, 0);
		worldRender.addVertex(-f10, 100.0D, -f10);

		tessellator1.draw();
		worldRender.startDrawing(GL11.GL_TRIANGLE_FAN);
		worldRender.setColorRGBA_F(f6 * f18, f7 * f18, f8 * f18, afloat[3] * f18);
		worldRender.addVertex(0.0D, 100.0D, 0.0D);
		worldRender.setColorRGBA_F(afloat[0] * f18, afloat[1] * f18, afloat[2] * f18, 0.0F);

		// Render larger sun aura
		f10 = 40.0F;
		worldRender.addVertex(-f10, 100.0D, -f10);
		worldRender.addVertex(0, 100.0D, (double) -f10 * 1.5F);
		worldRender.addVertex(f10, 100.0D, -f10);
		worldRender.addVertex((double) f10 * 1.5F, 100.0D, 0);
		worldRender.addVertex(f10, 100.0D, f10);
		worldRender.addVertex(0, 100.0D, (double) f10 * 1.5F);
		worldRender.addVertex(-f10, 100.0D, f10);
		worldRender.addVertex((double) -f10 * 1.5F, 100.0D, 0);
		worldRender.addVertex(-f10, 100.0D, -f10);

		tessellator1.draw();
		GlStateManager.popMatrix();
		GlStateManager.shadeModel(GL11.GL_FLAT);

		GlStateManager.enableTexture2D();
		OpenGlHelper.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE, GL11.GL_ONE, GL11.GL_ZERO);
		GlStateManager.pushMatrix();
		f7 = 0.0F;
		f8 = 0.0F;
		f9 = 0.0F;
		GlStateManager.translate(f7, f8, f9);
		GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
		GlStateManager.rotate(world.getCelestialAngle(partialTicks) * 360.0F, 1.0F, 0.0F, 0.0F);

		// Render sun
		GlStateManager.disableTexture2D();
		GlStateManager.color(0.0F, 0.0F, 0.0F, 1.0F);
		//Some blanking to conceal the stars
		f10 = this.sunSize / 3.5F;
		worldRender.startDrawingQuads();
		worldRender.addVertex(-f10, 99.9D, -f10);
		worldRender.addVertex(f10, 99.9D, -f10);
		worldRender.addVertex(f10, 99.9D, f10);
		worldRender.addVertex(-f10, 99.9D, f10);
		tessellator1.draw();
		GlStateManager.enableTexture2D();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		f10 = this.sunSize;
		mc.renderEngine.bindTexture(this.sunTexture);
		worldRender.startDrawingQuads();
		worldRender.addVertexWithUV(-f10, 100.0D, -f10, 0.0D, 0.0D);
		worldRender.addVertexWithUV(f10, 100.0D, -f10, 1.0D, 0.0D);
		worldRender.addVertexWithUV(f10, 100.0D, f10, 1.0D, 1.0D);
		worldRender.addVertexWithUV(-f10, 100.0D, f10, 0.0D, 1.0D);
		tessellator1.draw();

		// Render earth
		f10 = 0.5F;
		GlStateManager.scale(0.6F, 0.6F, 0.6F);
		GlStateManager.rotate(40.0F, 0.0F, 0.0F, 1.0F);
		GlStateManager.rotate(200F, 1.0F, 0.0F, 0.0F);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1F);
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(this.overworldTexture);
		worldRender.startDrawingQuads();
		worldRender.addVertexWithUV(-f10, -100.0D, f10, 0, 1);
		worldRender.addVertexWithUV(f10, -100.0D, f10, 1, 1);
		worldRender.addVertexWithUV(f10, -100.0D, -f10, 1, 0);
		worldRender.addVertexWithUV(-f10, -100.0D, -f10, 0, 0);
		tessellator1.draw();

		// Phobos
		f10 = 3.8F;
		GlStateManager.scale(0.6F, 0.6F, 0.6F);
		GlStateManager.rotate(40.0F, 0.0F, 0.0F, 1.0F);
		GlStateManager.rotate(200F, 1.0F, 0.0F, 0.0F);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1F);
		GlStateManager.rotate(world.getCelestialAngle(partialTicks) * 360.0F, 10.0F, 0.0F, 0.0F);
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(this.phobosTexture);
		worldRender.startDrawingQuads();
		worldRender.addVertexWithUV(-f10, -100.0D, f10, 0, 1);
		worldRender.addVertexWithUV(f10, -100.0D, f10, 1, 1);
		worldRender.addVertexWithUV(f10, -100.0D, -f10, 1, 0);
		worldRender.addVertexWithUV(-f10, -100.0D, -f10, 0, 0);
		tessellator1.draw();

		// Deimos
		f10 = 1.2F;
		GlStateManager.scale(0.6F, 0.6F, 0.6F);
		GlStateManager.rotate(40.0F, 0.0F, 0.0F, 1.0F);
		GlStateManager.rotate(200F, 1.0F, 0.0F, 0.0F);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1F);
		GlStateManager.rotate(world.getCelestialAngle(partialTicks) * 360.0F, 10.0F, 0.0F, 0.0F);
		FMLClientHandler.instance().getClient().renderEngine.bindTexture(this.deimosTexture);
		worldRender.startDrawingQuads();
		worldRender.addVertexWithUV(-f10, -100.0D, f10, 0, 1);
		worldRender.addVertexWithUV(f10, -100.0D, f10, 1, 1);
		worldRender.addVertexWithUV(f10, -100.0D, -f10, 1, 0);
		worldRender.addVertexWithUV(-f10, -100.0D, -f10, 0, 0);
		tessellator1.draw();

		GlStateManager.disableTexture2D();

		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.disableBlend();
		GlStateManager.enableAlpha();
		GlStateManager.enableFog();
		GlStateManager.popMatrix();
		GlStateManager.disableTexture2D();
		GlStateManager.color(0.0F, 0.0F, 0.0F);
		double d0 = mc.thePlayer.getPositionEyes(partialTicks).yCoord - world.getHorizon();

		if (d0 < 0.0D)
		{
			GlStateManager.pushMatrix();
			GlStateManager.translate(0.0F, 12.0F, 0.0F);
			GlStateManager.callList(this.glSkyList2);
			GlStateManager.popMatrix();
			f8 = 1.0F;
			f9 = -((float) (d0 + 65.0D));
			f10 = -f8;
			worldRender.startDrawingQuads();
			worldRender.setColorRGBA_I(0, 255);
			worldRender.addVertex(-f8, f9, f8);
			worldRender.addVertex(f8, f9, f8);
			worldRender.addVertex(f8, f10, f8);
			worldRender.addVertex(-f8, f10, f8);
			worldRender.addVertex(-f8, f10, -f8);
			worldRender.addVertex(f8, f10, -f8);
			worldRender.addVertex(f8, f9, -f8);
			worldRender.addVertex(-f8, f9, -f8);
			worldRender.addVertex(f8, f10, -f8);
			worldRender.addVertex(f8, f10, f8);
			worldRender.addVertex(f8, f9, f8);
			worldRender.addVertex(f8, f9, -f8);
			worldRender.addVertex(-f8, f9, -f8);
			worldRender.addVertex(-f8, f9, f8);
			worldRender.addVertex(-f8, f10, f8);
			worldRender.addVertex(-f8, f10, -f8);
			worldRender.addVertex(-f8, f10, -f8);
			worldRender.addVertex(-f8, f10, f8);
			worldRender.addVertex(f8, f10, f8);
			worldRender.addVertex(f8, f10, -f8);
			tessellator1.draw();
		}

		if (world.provider.isSkyColored())
		{
			GlStateManager.color(f1 * 0.2F + 0.04F, f2 * 0.2F + 0.04F, f3 * 0.6F + 0.1F);
		}
		else
		{
			GlStateManager.color(f1, f2, f3);
		}
		GlStateManager.pushMatrix();
		GlStateManager.translate(0.0F, -((float) (d0 - 16.0D)), 0.0F);
		GlStateManager.callList(this.glSkyList2);
		GlStateManager.popMatrix();
		GlStateManager.enableTexture2D();
		GlStateManager.depthMask(true);
	}

	private void renderStars()
	{
		Random rand = new Random(10842L);
		Tessellator tessellator = Tessellator.getInstance();
		WorldRenderer worldRender = tessellator.getWorldRenderer();
		worldRender.startDrawingQuads();

		for (int starIndex = 0; starIndex < (ConfigManagerCore.moreStars ? 35000 : 6000); ++starIndex)
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
					worldRender.addVertex(var14 + var57, var16 + var53, var18 + var61);
				}
			}
		}
		tessellator.draw();
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
}