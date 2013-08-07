/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the PrisceMagica Mod.
 * 
 * PrisceMagica is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * 
 * File Created @ [7 Aug 2013, 21:54:53 (GMT)]
 */
package vazkii.priscemagica.core.handler;

import cpw.mods.fml.common.registry.LanguageRegistry;
import vazkii.priscemagica.lib.LibResources;

public final class LocalizationHandler {

	public static void loadLocalizations() {
		for(String locale : LibResources.LANGS)
			LanguageRegistry.instance().loadLocalization(LibResources.PREFIX_LANG + locale, locale.replaceAll(".lang", ""), false);
	}
	
}
