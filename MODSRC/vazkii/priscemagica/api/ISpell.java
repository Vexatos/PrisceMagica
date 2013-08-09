/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the PrisceMagica Mod.
 *
 * PrisceMagica is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 *
 * File Created @ [9 Aug 2013, 22:58:06 (GMT)]
 */
package vazkii.priscemagica.api;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public interface ISpell {

	public String getLocalizedName();

	public String getUnlocalizedName();

	public boolean isAvailable(PlayerResearchData researchData);

	public int getCooldown(ItemStack wand);

	public boolean castOnWorld(EntityPlayer player, ItemStack wand);

	public boolean castOnBlock(EntityPlayer player, ItemStack wand, int x, int y, int z);

	public boolean castOnEntity(EntityPlayer player, ItemStack wand, EntityLivingBase target);
}
