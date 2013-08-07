/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the PrisceMagica Mod.
 * 
 * PrisceMagica is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * 
 * File Created @ [7 Aug 2013, 21:26:42 (GMT)]
 */
package vazkii.priscemagica.item;

import net.minecraft.item.Item;
import vazkii.priscemagica.lib.LibItemIDs;
import vazkii.priscemagica.lib.LibNames;

public final class ModItems {

	public static Item magicGem;
	
	public static void initItems() {
		magicGem = new ItemMod(LibItemIDs.idItemMagicGem).setUnlocalizedName(LibNames.ITEM_MAGIC_GEM);
	}
	
}
