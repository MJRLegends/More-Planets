/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.common.util;

import java.util.HashMap;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody;
import micdoodle8.mods.galacticraft.api.galaxies.CelestialBody.ScalableDistance;
import micdoodle8.mods.galacticraft.api.galaxies.Moon;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import micdoodle8.mods.galacticraft.api.galaxies.Satellite;
import micdoodle8.mods.galacticraft.api.galaxies.SolarSystem;
import micdoodle8.mods.galacticraft.api.galaxies.Star;
import micdoodle8.mods.galacticraft.api.recipe.ISchematicPage;
import micdoodle8.mods.galacticraft.api.recipe.SchematicRegistry;
import micdoodle8.mods.galacticraft.api.recipe.SpaceStationRecipe;
import micdoodle8.mods.galacticraft.api.world.SpaceStationType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameData;
import net.minecraftforge.fml.relauncher.Side;
import stevekung.mods.moreplanets.core.MorePlanetsCore;

public class MorePlanetsRegistry
{
    public static SimpleNetworkWrapper simpleNetworkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel(MorePlanetsCore.MOD_ID);

    public static Planet createPlanet(String name, SolarSystem solar, float phaseShift, float distance, float orbitTime, float size, int tier, ResourceLocation resource)
    {
        Planet planet = new Planet(name).setParentSolarSystem(solar);
        planet.setPhaseShift(phaseShift);
        planet.setRelativeDistanceFromCenter(new ScalableDistance(distance, distance));
        planet.setRelativeOrbitTime(orbitTime);
        planet.setRelativeSize(size);
        planet.setTierRequired(tier);
        planet.setBodyIcon(resource);
        MPLog.debug("Register Planet : %s", planet.getName());
        return planet;
    }

    public static Moon createMoon(String name, Planet planet, float phaseShift, float distance, float orbitTime, float size, int tier, ResourceLocation resource)
    {
        Moon moon = new Moon(name).setParentPlanet(planet);
        moon.setPhaseShift(phaseShift);
        moon.setRelativeDistanceFromCenter(new ScalableDistance(distance, distance));
        moon.setRelativeOrbitTime(orbitTime);
        moon.setRelativeSize(size);
        moon.setTierRequired(tier);
        moon.setBodyIcon(resource);
        MPLog.debug("Register Moon : %s", moon.getName());
        return moon;
    }

    public static Satellite createSatellite(String name, Planet planet, float phaseShift, float distance, float orbitTime, float size, int tier, ResourceLocation resource)
    {
        Satellite satellite = new Satellite(name).setParentBody(planet);
        satellite.setPhaseShift(phaseShift);
        satellite.setRelativeDistanceFromCenter(new ScalableDistance(distance, distance));
        satellite.setRelativeOrbitTime(orbitTime);
        satellite.setRelativeSize(size);
        satellite.setTierRequired(tier);
        satellite.setBodyIcon(resource);
        MPLog.debug("Register Satellite : %s", satellite.getName());
        return satellite;
    }

    public static Star createStar(String name, SolarSystem solar, ResourceLocation resource)
    {
        Star star = new Star(name).setParentSolarSystem(solar);
        star.setTierRequired(-1);
        star.setBodyIcon(resource);
        MPLog.debug("Register Star : %s", star.getName());
        return star;
    }

    public static void registerSchematic(ISchematicPage schematic)
    {
        SchematicRegistry.registerSchematicRecipe(schematic);
        MPLog.debug("Register Schematic : %s, %s", schematic.getClass().getSimpleName(), GameData.getItemRegistry().getNameForObject(schematic.getRequiredItem().getItem()).toString());
    }

    public static void registerDungeonLoot(CelestialBody celestial, ItemStack itemStack)
    {
        GalacticraftRegistry.addDungeonLoot(celestial.getTierRequirement(), itemStack);
        MPLog.debug("Register Dungeon Loot : %s, %s, %s", celestial.getTierRequirement(), GameData.getItemRegistry().getNameForObject(itemStack.getItem()).toString(), itemStack.getItemDamage());
    }

    public static void registerSpaceStation(Satellite satellite, Planet planet, HashMap<Object, Integer> recipe)
    {
        GalacticraftRegistry.registerSpaceStation(new SpaceStationType(satellite.getDimensionID(), planet.getDimensionID(), new SpaceStationRecipe(recipe)));
        MPLog.debug("Register Satellite [%s : %s] at planet [%s : %s]", satellite.getName(), satellite.getDimensionID(), planet.getName(), planet.getDimensionID());
        MPLog.debug("Using recipes %s", recipe.toString());
    }

    public static void registerSpaceStationProvider(int id, int staticId, Class<? extends WorldProvider> provider)
    {
        GalacticraftRegistry.registerProvider(id, provider, false, 0);
        GalacticraftRegistry.registerProvider(staticId, provider, true, 0);
        MPLog.debug("Register Space Station Provider ID: %s, Static ID: %s, Provider: %s", id, staticId, provider.getSimpleName());
    }

    public static <REQ extends IMessage, REPLY extends IMessage> void registerMessageHandler(Class<? extends IMessageHandler<REQ, REPLY>> messageHandler, Class<REQ> requestMessageType, int discriminator, Side side)
    {
        MorePlanetsRegistry.simpleNetworkWrapper.registerMessage(messageHandler, requestMessageType, discriminator, side);
        MPLog.debug("Register Message Handler : %s, %s", messageHandler.getSimpleName(), requestMessageType.getSimpleName());
    }
}