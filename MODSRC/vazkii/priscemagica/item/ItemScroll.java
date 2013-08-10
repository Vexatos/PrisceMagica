/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the PrisceMagica Mod.
 *
 * PrisceMagica is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 *
 * File Created @ [9 Aug 2013, 16:23:37 (GMT)]
 */
package vazkii.priscemagica.item;

import vazkii.priscemagica.PrisceMagica;
import vazkii.priscemagica.api.PrisceMagicaAPI;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemScroll extends ItemMod {

	public ItemScroll(int par1) {
		super(par1);
		setMaxStackSize(1);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		super.registerIcons(par1IconRegister);
		
		for(String spell : PrisceMagicaAPI.getRegisteredSpells())
			PrisceMagicaAPI.getSpell(spell).registerIcons(par1IconRegister);
	}

}
