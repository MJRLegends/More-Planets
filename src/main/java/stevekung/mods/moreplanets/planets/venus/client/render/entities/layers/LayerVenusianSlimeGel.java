/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.planets.venus.client.render.entities.layers;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelSlime;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import stevekung.mods.moreplanets.planets.venus.client.render.entities.RenderVenusianSlime;
import stevekung.mods.moreplanets.planets.venus.entities.EntityVenusianSlime;

@SideOnly(Side.CLIENT)
public class LayerVenusianSlimeGel implements LayerRenderer<EntityVenusianSlime>
{
    private RenderVenusianSlime slimeRenderer;
    private ModelBase slimeModel = new ModelSlime(0);

    public LayerVenusianSlimeGel(RenderVenusianSlime render)
    {
        this.slimeRenderer = render;
    }

    @Override
    public boolean shouldCombineTextures()
    {
        return true;
    }

    @Override
    public void doRenderLayer(EntityVenusianSlime living, float par2, float par3, float partialTicks, float par5, float par6, float par7, float scale)
    {
        if (!living.isInvisible())
        {
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.enableNormalize();
            GlStateManager.enableBlend();
            this.slimeModel.setModelAttributes(this.slimeRenderer.getMainModel());
            this.slimeModel.render(living, par2, par3, partialTicks, par6, par7, scale);
            GlStateManager.disableBlend();
            GlStateManager.disableNormalize();
        }
    }
}