/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.siriusb.client.render.entities.layers;

import net.minecraft.client.model.ModelCreeper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.planets.siriusb.client.render.entities.RenderSiriusCreeper;
import stevekung.mods.moreplanets.planets.siriusb.entities.EntitySiriusCreeper;

@SideOnly(Side.CLIENT)
public class LayerSiriusCreeperCharge implements LayerRenderer<EntitySiriusCreeper>
{
    private ResourceLocation lightningTexture = new ResourceLocation("textures/entity/creeper/creeper_armor.png");
    private RenderSiriusCreeper creeperRenderer;
    private ModelCreeper creeperModel = new ModelCreeper(2.0F);

    public LayerSiriusCreeperCharge(RenderSiriusCreeper render)
    {
        this.creeperRenderer = render;
    }

    @Override
    public boolean shouldCombineTextures()
    {
        return false;
    }

    @Override
    public void doRenderLayer(EntitySiriusCreeper entity, float par2, float par3, float partialTicks, float par5, float par6, float par7, float scale)
    {
        if (entity.getPowered())
        {
            GlStateManager.depthMask(!entity.isInvisible());
            this.creeperRenderer.bindTexture(this.lightningTexture);
            GlStateManager.matrixMode(5890);
            GlStateManager.loadIdentity();
            float f7 = entity.ticksExisted + partialTicks;
            GlStateManager.translate(f7 * 0.01F, f7 * 0.01F, 0.0F);
            GlStateManager.matrixMode(5888);
            GlStateManager.enableBlend();
            float f8 = 0.5F;
            GlStateManager.color(f8, f8, f8, 1.0F);
            GlStateManager.disableLighting();
            GlStateManager.blendFunc(1, 1);
            this.creeperModel.setModelAttributes(this.creeperRenderer.getMainModel());
            this.creeperModel.render(entity, par2, par3, par5, par6, par7, scale);
            GlStateManager.matrixMode(5890);
            GlStateManager.loadIdentity();
            GlStateManager.matrixMode(5888);
            GlStateManager.enableLighting();
            GlStateManager.disableBlend();
        }
    }
}