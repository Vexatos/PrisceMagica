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
import net.minecraft.item.ItemStack;
import vazkii.priscemagica.lib.LibItemIDs;
import vazkii.priscemagica.lib.LibNames;
import cpw.mods.fml.common.registry.GameRegistry;

public final class ModItems {

	public static Item magicGem;
	public static Item wand;
	
	public static void initItems() {
		magicGem = new ItemMod(LibItemIDs.idItemMagicGem).setUnlocalizedName(LibNames.ITEM_MAGIC_GEM);
		wand = new ItemWand(LibItemIDs.idItemWand).setUnlocalizedName(LibNames.ITEM_WAND);
		
		addRecipes();
	}
	
	private static void addRecipes() {
		GameRegistry.addShapelessRecipe(new ItemStack(magicGem), Item.diamond, Item.netherQuartz, new ItemStack(Item.dyePowder, 1, 4), Item.redstone, Item.glowstone);
		
		GameRegistry.addRecipe(new ItemStack(wand),
			" GM", " SG", "G  ",
			'G', Item.goldNugget,
			'M', magicGem,
			'S', Item.stick
		);
	}
	
}
