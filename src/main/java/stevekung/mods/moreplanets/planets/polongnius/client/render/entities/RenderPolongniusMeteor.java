/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

//package stevekung.mods.moreplanets.planets.polongnius.client.render.entities;
//
//import net.minecraft.client.renderer.entity.Render;
//import net.minecraft.client.renderer.entity.RenderManager;
//import net.minecraft.entity.Entity;
//import net.minecraft.util.ResourceLocation;
//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;
//
//import org.lwjgl.opengl.GL11;
//
//import stevekung.mods.moreplanets.planets.polongnius.entities.EntityPolongniusMeteor;
//
//@SideOnly(Side.CLIENT)
//public class RenderPolongniusMeteor extends Render
//{
//	private ResourceLocation meteorTexture = new ResourceLocation("polongnius:textures/model/polongnius_meteor.png");
//
//	private ModelMeteor modelMeteor;
//
//	public RenderPolongniusMeteor(RenderManager render)
//	{
//		super(render);
//		this.shadowSize = 1F;
//		this.modelMeteor = new ModelMeteor();
//	}
//
//	protected ResourceLocation func_110779_a(EntityPolongniusMeteor entity)
//	{
//		return this.meteorTexture;
//	}
//
//	@Override
//	protected ResourceLocation getEntityTexture(Entity par1Entity)
//	{
//		return this.func_110779_a((EntityPolongniusMeteor) par1Entity);
//	}
//
//	public void doRenderMeteor(EntityPolongniusMeteor entity, double par2, double par4, double par6, float par8, float par9)
//	{
//		GL11.glPushMatrix();
//		GL11.glTranslatef((float) par2, (float) par4, (float) par6);
//		GL11.glRotatef(par8, 0.0F, 1.0F, 0.0F);
//		GL11.glRotatef(par8, 1.0F, 0.0F, 0.0F);
//		float f = entity.getSize();
//		GL11.glScalef(f / 2, f / 2, f / 2);
//		this.bindEntityTexture(entity);
//		this.modelMeteor.render(entity, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.1F);
//		GL11.glPopMatrix();
//	}
//
//	@Override
//	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
//	{
//		this.doRenderMeteor((EntityPolongniusMeteor) par1Entity, par2, par4, par6, par8, par9);
//	}
//}