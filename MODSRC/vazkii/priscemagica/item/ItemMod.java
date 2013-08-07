/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the PrisceMagica Mod.
 * 
 * PrisceMagica is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * 
 * File Created @ [7 Aug 2013, 21:26:58 (GMT)]
 */
package vazkii.priscemagica.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import vazkii.priscemagica.client.core.helper.IconHelper;
import vazkii.priscemagica.core.misc.ModCreativeTab;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemMod extends Item {

	public ItemMod(int par1) {
		super(par1);
		
		setCreativeTab(ModCreativeTab.INSTANCE);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		itemIcon = IconHelper.forItem(par1IconRegister, this);
	}

}
