/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.core;

import java.io.File;

import micdoodle8.mods.galacticraft.api.GalacticraftRegistry;
import micdoodle8.mods.galacticraft.api.galaxies.Moon;
import micdoodle8.mods.galacticraft.api.galaxies.Planet;
import micdoodle8.mods.galacticraft.api.galaxies.Satellite;
import micdoodle8.mods.galacticraft.api.galaxies.SolarSystem;
import micdoodle8.mods.galacticraft.api.galaxies.Star;
import micdoodle8.mods.galacticraft.api.recipe.SchematicRegistry;
import micdoodle8.mods.galacticraft.api.recipe.SpaceStationRecipe;
import micdoodle8.mods.galacticraft.api.world.SpaceStationType;
import net.minecraft.block.Block.SoundType;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import stevekung.mods.moreplanets.common.achievement.AchievementsMP;
import stevekung.mods.moreplanets.common.config.ConfigManagerMP;
import stevekung.mods.moreplanets.common.eventhandler.GuiEventHandler;
import stevekung.mods.moreplanets.common.eventhandler.MainMenuHandlerMP;
import stevekung.mods.moreplanets.common.eventhandler.MorePlanetsEvents;
import stevekung.mods.moreplanets.common.eventhandler.PlanetFogHandler;
import stevekung.mods.moreplanets.common.eventhandler.SkyProviderHandler;
import stevekung.mods.moreplanets.common.integration.DispenserRegistryMP;
import stevekung.mods.moreplanets.common.integration.TreeCapitatorIntegrationMP;
import stevekung.mods.moreplanets.common.network.meteor.MeteorClientHandler;
import stevekung.mods.moreplanets.common.network.meteor.MeteorClientMessage;
import stevekung.mods.moreplanets.common.network.meteor.MeteorServerHandler;
import stevekung.mods.moreplanets.common.network.meteor.MeteorServerMessage;
import stevekung.mods.moreplanets.common.recipe.CraftingManagerMP;
import stevekung.mods.moreplanets.common.util.FurnaceFuelMP;
import stevekung.mods.moreplanets.common.util.MPLog;
import stevekung.mods.moreplanets.core.init.MPArmors;
import stevekung.mods.moreplanets.core.init.MPBiomes;
import stevekung.mods.moreplanets.core.init.MPBlocks;
import stevekung.mods.moreplanets.core.init.MPEntities;
import stevekung.mods.moreplanets.core.init.MPItems;
import stevekung.mods.moreplanets.core.init.MPPlanets;
import stevekung.mods.moreplanets.core.init.MPPotions;
import stevekung.mods.moreplanets.core.init.MPTileEntities;
import stevekung.mods.moreplanets.core.init.MPTools;
import stevekung.mods.moreplanets.core.proxy.CommonProxyMP;
import stevekung.mods.moreplanets.planets.diona.items.DionaItems;
import stevekung.mods.moreplanets.planets.diona.schematic.SchematicTier4Rocket;
import stevekung.mods.moreplanets.planets.fronos.items.FronosItems;
import stevekung.mods.moreplanets.planets.fronos.items.armor.FronosArmorItems;
import stevekung.mods.moreplanets.planets.fronos.schematics.SchematicTier7Rocket;
import stevekung.mods.moreplanets.planets.kapteynb.items.tools.KapteynBToolsItems;
import stevekung.mods.moreplanets.planets.kapteynb.schematics.SchematicTier8Rocket;
import stevekung.mods.moreplanets.planets.mercury.blocks.MercuryBlocks;
import stevekung.mods.moreplanets.planets.nibiru.items.NibiruItems;
import stevekung.mods.moreplanets.planets.nibiru.schematics.SchematicTier6Rocket;
import stevekung.mods.moreplanets.planets.polongnius.items.PolongniusItems;
import stevekung.mods.moreplanets.planets.polongnius.schematics.SchematicTier5Rocket;
import stevekung.mods.stevecore.CreativeTabsHelper;

@Mod(modid = MorePlanetsCore.MOD_ID, name = MorePlanetsCore.NAME, version = MorePlanetsCore.VERSION, dependencies = /*"required-after:GalacticraftCore; required-after:GalacticraftMars;*/" after:Forge@[11.14.3.1480,);")//TODO required-after:Micdoodlecore;
public class MorePlanetsCore
{
	public static final String NAME = "More Planets";
	public static final String MOD_ID = "MorePlanets";
	public static final String VERSION = MorePlanetsCore.major_version + "." + MorePlanetsCore.minor_version + "." + MorePlanetsCore.build_version;

	public static final int major_version = 2;
	public static final int minor_version = 0;
	public static final int build_version = 0;

	@SidedProxy(clientSide = "stevekung.mods.moreplanets.core.proxy.ClientProxyMP", serverSide = "stevekung.mods.moreplanets.core.proxy.CommonProxyMP")
	public static CommonProxyMP proxy;

	@Instance(MorePlanetsCore.MOD_ID)
	public static MorePlanetsCore instance;

	public static CreativeTabs mpBlocksTab;
	public static CreativeTabs mpItemsTab;
	public static CreativeTabs mpToolsTab;
	public static CreativeTabs mpArmorTab;

	public static SimpleNetworkWrapper simpleNetworkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel("MorePlanets");

	public static Planet siriusB;
	public static Planet diona;
	public static Planet polongnius;
	public static Planet nibiru;
	public static Planet fronos;
	public static Planet kapteynB;

	public static Planet mercury;
	public static Planet venus;
	public static Planet pluto;
	public static Planet jupiter;

	public static Planet koentus;//TODO Again -.-
	public static Moon phobos;
	public static Moon deimos;
	public static Moon io;

	public static Star sirius;
	public static Star kapteyn;

	public static SolarSystem siriusSolarSystem;
	public static SolarSystem kapteynBSolarSystem;

	public static Satellite marsSpaceStation;
	public static Satellite jupiterSpaceStation;
	public static Satellite kapteynBSpaceStation;

	public static SoundType soundTypeSmallSlime = new SoundType("slime", 1.0F, 1.0F)
	{
		@Override
		public String getBreakSound()
		{
			return "mob.slime.small";
		}

		@Override
		public String getStepSound()
		{
			return "mob.slime.small";
		}
	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		new ConfigManagerMP(new File(event.getModConfigurationDirectory(), "MorePlanets.cfg"));
		MPLog.debug("Enable Debug Logging");

		MPPotions.init();
		MPBlocks.init();
		MPItems.init();
		MPArmors.init();
		MPTools.init();
		MPBiomes.init();

		FMLCommonHandler.instance().bus().register(new SkyProviderHandler());
		FMLCommonHandler.instance().bus().register(new MorePlanetsEvents());

		MinecraftForge.EVENT_BUS.register(new MorePlanetsEvents());
		MinecraftForge.EVENT_BUS.register(new PlanetFogHandler());

		if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
		{
			MinecraftForge.EVENT_BUS.register(new MainMenuHandlerMP());
		}
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		MPPlanets.init();
		MPEntities.init();
		TreeCapitatorIntegrationMP.init();
		AchievementsMP.init();
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiEventHandler());

		MorePlanetsCore.mpBlocksTab = new CreativeTabsHelper("MorePlanetsBlocks", new ItemStack(MercuryBlocks.mercury_block, 1, 11));
		MorePlanetsCore.mpItemsTab = new CreativeTabsHelper("MorePlanetsItems", new ItemStack(DionaItems.laser_gun));
		MorePlanetsCore.mpToolsTab = new CreativeTabsHelper("MorePlanetsTools", new ItemStack(KapteynBToolsItems.uranium_pickaxe));
		MorePlanetsCore.mpArmorTab = new CreativeTabsHelper("MorePlanetsArmor", new ItemStack(FronosArmorItems.iridium_helmet));

		SchematicRegistry.registerSchematicRecipe(new SchematicTier4Rocket());
		SchematicRegistry.registerSchematicRecipe(new SchematicTier5Rocket());
		SchematicRegistry.registerSchematicRecipe(new SchematicTier6Rocket());
		SchematicRegistry.registerSchematicRecipe(new SchematicTier7Rocket());
		SchematicRegistry.registerSchematicRecipe(new SchematicTier8Rocket());

		GalacticraftRegistry.addDungeonLoot(1, new ItemStack(DionaItems.tier_4_rocket_schematic, 1, 1));
		GalacticraftRegistry.addDungeonLoot(3, new ItemStack(PolongniusItems.tier_5_rocket_schematic, 1, 1));
		GalacticraftRegistry.addDungeonLoot(4, new ItemStack(NibiruItems.tier_6_rocket_schematic, 1, 1));
		GalacticraftRegistry.addDungeonLoot(5, new ItemStack(FronosItems.tier_7_rocket_schematic, 1, 0));
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		MPTileEntities.init();
		MorePlanetsCore.proxy.registerRenderer();
		GameRegistry.registerFuelHandler(new FurnaceFuelMP());

		CraftingManagerMP.init();
		DispenserRegistryMP.init();

		MorePlanetsCore.simpleNetworkWrapper.registerMessage(MeteorServerHandler.class, MeteorServerMessage.class, 0, Side.SERVER);
		MorePlanetsCore.simpleNetworkWrapper.registerMessage(MeteorClientHandler.class, MeteorClientMessage.class, 1, Side.CLIENT);

		GalacticraftRegistry.registerSpaceStation(new SpaceStationType(ConfigManagerMP.idDimensionJupiterSpaceStation, ConfigManagerMP.idDimensionJupiter, new SpaceStationRecipe(CraftingManagerMP.getJupiterSpaceStationRecipe())));
	}

	@EventHandler
	public void serverInit(FMLServerStartedEvent event)
	{
		new Thread(ThreadVersionCheckMP.INSTANCE).start();
	}
}