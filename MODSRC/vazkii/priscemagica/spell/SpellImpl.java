/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the PrisceMagica Mod.
 * 
 * PrisceMagica is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * 
 * File Created @ [10 Aug 2013, 15:06:04 (GMT)]
 */
package vazkii.priscemagica.spell;

import net.minecraft.client.renderer.texture.IconRegister;
import vazkii.priscemagica.api.AbstractSpell;
import vazkii.priscemagica.client.core.helper.IconHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class SpellImpl extends AbstractSpell {

	public SpellImpl(String unlocalizedName) {
		super(unlocalizedName);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister registry) {
		icon = IconHelper.forSpell(registry, this);
	}

}
