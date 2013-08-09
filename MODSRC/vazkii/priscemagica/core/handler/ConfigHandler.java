/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the PrisceMagica Mod.
 * 
 * PrisceMagica is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * 
 * File Created @ [7 Aug 2013, 21:09:18 (GMT)]
 */
package vazkii.priscemagica.core.handler;

import java.io.File;

import vazkii.priscemagica.lib.LibItemIDs;
import vazkii.priscemagica.lib.LibNames;

import net.minecraftforge.common.Configuration;

public final class ConfigHandler {

	private static Configuration config;
	
	public static void loadConfig(File configFile) {
		config = new Configuration(configFile);

		config.load();
		
		LibItemIDs.idBlockSpellDesk = loadBlock(LibNames.BLOCK_SPELL_DESK, LibItemIDs.idBlockSpellDesk);
		
		LibItemIDs.idItemMagicGem = loadItem(LibNames.ITEM_MAGIC_GEM, LibItemIDs.idItemMagicGem);
		LibItemIDs.idItemWand = loadItem(LibNames.ITEM_WAND, LibItemIDs.idItemWand);
		LibItemIDs.idItemScroll = loadItem(LibNames.ITEM_SCROLL, LibItemIDs.idItemScroll);
		
		config.save();
	}

	private static int loadItem(String label, int defaultID) {
		return config.getItem(label, defaultID).getInt(defaultID);
	}

	private static int loadBlock(String label, int defaultID) {
		return config.getBlock(label, defaultID).getInt(defaultID);
	}

	/*private static int loadPotion(String label, int deafultID) {
		return config.get(CATEGORY_POTIONS, label, deafultID).getInt(deafultID);
	}*/
}
