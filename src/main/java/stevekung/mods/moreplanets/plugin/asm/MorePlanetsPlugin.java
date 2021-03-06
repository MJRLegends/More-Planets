/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets ASM
 * 
 * Credit to : micdoodle8
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.plugin.asm;

import java.util.Map;

import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin.MCVersion;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin.TransformerExclusions;
import stevekung.mods.moreplanets.plugin.asm.MorePlanetsTransformer.Logger;

@TransformerExclusions("stevekung.mods.moreplanets.plugin.asm")
@MCVersion(value = "1.8")
public class MorePlanetsPlugin implements IFMLLoadingPlugin
{
    @Override
    public String[] getASMTransformerClass()
    {
        Logger.info("Calling tweak class " + MorePlanetsPlugin.class.getName());
        return new String[] { MorePlanetsTransformer.class.getName() };
    }

    @Override
    public String getModContainerClass()
    {
        return null;
    }

    @Override
    public String getSetupClass()
    {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {}

    @Override
    public String getAccessTransformerClass()
    {
        Logger.info("Calling access transformer class " + MorePlanetsAccessTransformer.class.getName());
        return MorePlanetsAccessTransformer.class.getName();
    }
}