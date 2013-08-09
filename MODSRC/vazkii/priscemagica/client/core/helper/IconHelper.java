/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the PrisceMagica Mod.
 *
 * PrisceMagica is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 *
 * File Created @ [7 Aug 2013, 21:25:03 (GMT)]
 */
package vazkii.priscemagica.client.core.helper;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import vazkii.priscemagica.lib.LibMisc;

public final class IconHelper {

	public static Icon forName(IconRegister ir, String name) {
		return ir.registerIcon(LibMisc.MOD_ID + ":" + name);
	}

	public static Icon forBlock(IconRegister ir, Block block) {
		return forName(ir, block.getUnlocalizedName().replaceAll("tile.", ""));
	}

	public static Icon forBlock(IconRegister ir, Block block, int i) {
		return forName(ir, block.getUnlocalizedName().replaceAll("tile.", "") + i);
	}

	public static Icon forItem(IconRegister ir, Item item) {
		return forName(ir, item.getUnlocalizedName().replaceAll("item.", ""));
	}

	public static Icon forItem(IconRegister ir, Item item, int i) {
		return forName(ir, item.getUnlocalizedName().replaceAll("item.", "") + i);
	}

}
