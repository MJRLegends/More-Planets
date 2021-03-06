/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.client.objmodel;

import net.minecraft.util.ResourceLocation;

public class ObjModelLoader implements IModelCustomLoader
{
    @Override
    public String[] getSuffixes()
    {
        return new String[] { "obj" };
    }

    @Override
    public IModelCustom loadInstance(ResourceLocation resource)
    {
        return new WavefrontObject(resource);
    }
}