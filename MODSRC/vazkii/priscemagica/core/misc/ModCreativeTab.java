/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the PrisceMagica Mod.
 * 
 * PrisceMagica is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * 
 * File Created @ [7 Aug 2013, 21:27:20 (GMT)]
 */
package vazkii.priscemagica.core.misc;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import vazkii.priscemagica.lib.LibMisc;

public final class ModCreativeTab extends CreativeTabs {

	public static final ModCreativeTab INSTANCE = new ModCreativeTab();
	
	public ModCreativeTab() {
		super(LibMisc.MOD_ID);
	}
	
	@Override
	public ItemStack getIconItemStack() {
		return super.getIconItemStack(); // TODO
	}

}
