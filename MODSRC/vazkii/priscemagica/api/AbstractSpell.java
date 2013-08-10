/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the PrisceMagica Mod.
 * 
 * PrisceMagica is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * 
 * File Created @ [10 Aug 2013, 14:27:13 (GMT)]
 */
package vazkii.priscemagica.api;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.StatCollector;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Abstract implementation of ISpell.
 */
public abstract class AbstractSpell implements ISpell {

	private String unlocalizedName;
	protected Icon icon;
	
	/**
	 * Main constructor for AbstractSpell, unlocalizedName is
	 * the name of the spell. The localized name is spell.unlocalizedName.name
	 */
	public AbstractSpell(String unlocalizedName) {
		this.unlocalizedName = unlocalizedName;
	}
	
	@Override
	public String getLocalizedName() {
		return StatCollector.translateToLocal("spell." + getUnlocalizedName() + ".name");
	}

	@Override
	public String getDescription() {
		return StatCollector.translateToLocal("spell." + getUnlocalizedName() + ".desc");
	}
	
	@Override
	public String getUnlocalizedName() {
		return unlocalizedName;
	}

	@Override
	public boolean isAvailable(PlayerData researchData) {
		return true;
	}

	@Override
	public int getCooldown(EntityPlayer player, ItemStack wand) {
		return 0;
	}

	@Override
	public boolean castOnWorld(EntityPlayer player, ItemStack wand) {
		return false;
	}

	@Override
	public boolean castOnBlock(EntityPlayer player, ItemStack wand, int x, int y, int z) {
		return false;
	}

	@Override
	public boolean castOnEntity(EntityPlayer player, ItemStack wand, EntityLivingBase target) {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getRequiredRenderPasses() {
		return 1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int renderPass) {
		return icon;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getColorForRenderPass(int renderPass) {
		return 0xFFFFFF;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public abstract void registerIcons(IconRegister registry);
}
