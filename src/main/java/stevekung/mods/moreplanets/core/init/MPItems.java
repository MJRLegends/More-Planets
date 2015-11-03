/*******************************************************************************
 * Copyright 2015 SteveKunG - More Planets Mod
 * 
 * This work is licensed under a Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International Public License.
 * To view a copy of this license, visit http://creativecommons.org/licenses/by-nc-nd/4.0/.
 ******************************************************************************/

package stevekung.mods.moreplanets.core.init;

import java.util.ArrayList;

import net.minecraft.item.Item;
import stevekung.mods.moreplanets.common.items.ItemFeces;
import stevekung.mods.moreplanets.common.items.ItemMeteorShower;
import stevekung.mods.moreplanets.common.items.ItemMonsterPlacerMP;
import stevekung.mods.moreplanets.common.items.ItemMorePlanetsNull;
import stevekung.mods.moreplanets.common.util.MPLog;
import stevekung.mods.moreplanets.moons.europa.items.EuropaItems;
import stevekung.mods.moreplanets.moons.io.items.IoItems;
import stevekung.mods.moreplanets.moons.koentus.items.KoentusItems;
import stevekung.mods.moreplanets.planets.diona.items.DionaItems;
import stevekung.mods.moreplanets.planets.fronos.items.FronosItems;
import stevekung.mods.moreplanets.planets.kapteynb.items.KapteynBItems;
import stevekung.mods.moreplanets.planets.mercury.items.MercuryItems;
import stevekung.mods.moreplanets.planets.nibiru.items.NibiruItems;
import stevekung.mods.moreplanets.planets.pluto.items.PlutoItems;
import stevekung.mods.moreplanets.planets.polongnius.items.PolongniusItems;
import stevekung.mods.moreplanets.planets.siriusb.items.SiriusBItems;
import stevekung.mods.moreplanets.planets.venus.items.VenusItems;
import stevekung.mods.stevecore.CommonRegisterHelper;

public class MPItems
{
	public static Item meteor_shower;
	public static Item spawn_egg_mp;
	public static Item feces;
	public static Item achievement_temp;

	public static ArrayList<Item> hideItemList = new ArrayList();

	public static void init()
	{
		DionaItems.init();
		PolongniusItems.init();
		NibiruItems.init();
		KoentusItems.init();
		FronosItems.init();
		KapteynBItems.init();
		SiriusBItems.init();

		MercuryItems.init();
		VenusItems.init();
		PlutoItems.init();
		IoItems.init();
		EuropaItems.init();

		// Init
		MPItems.meteor_shower = new ItemMeteorShower("meteor_shower");
		MPItems.spawn_egg_mp = new ItemMonsterPlacerMP("spawn_egg_mp");
		MPItems.feces = new ItemFeces("feces");
		MPItems.achievement_temp = new ItemMorePlanetsNull("achievement_temp");

		// Register
		CommonRegisterHelper.registerItem(MPItems.meteor_shower);
		CommonRegisterHelper.registerItem(MPItems.feces);
		CommonRegisterHelper.registerItem(MPItems.spawn_egg_mp);
		CommonRegisterHelper.registerItem(MPItems.achievement_temp);

		hideItemList.add(MPItems.achievement_temp);

		MPLog.debug("Register Items");
	}
}