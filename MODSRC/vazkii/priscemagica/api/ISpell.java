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

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Interface for a spell.
 * @see AbstractSpell
 */
public interface ISpell {

	/**
	 * Gets the localized (display) name for the spell.
	 */
	public String getLocalizedName();

	/**
	 * Gets the unlocalized (mapping) name for the spell.
	 */
	public String getUnlocalizedName();
	
	/**
	 * Gets the description of thi spell. Used in the spell selection
	 * interface to tell the player what the spell does.
	 */
	public String getDescription();
	
	/**
	 * Should return true if the research data passed in should
	 * take this spell in consideration when creating a list
	 * of possible spells to get.
	 */
	public boolean isAvailable(PlayerData researchData);

	/**
	 * Gets the cooldown for the spell, given the wand and the player passed in.
	 */
	public int getCooldown(EntityPlayer player, ItemStack wand);

	/**
	 * Method called when the spell is just cast with a regular right click.
	 * Return true to indicate the spell was cast. Otherwise, false.
	 */
	public boolean castOnWorld(EntityPlayer player, ItemStack wand);

	/**
	 * Method called when the spell is cast on a block.
	 * Return true to indicate the spell was cast. Otherwise, false.
	 */
	public boolean castOnBlock(EntityPlayer player, ItemStack wand, int x, int y, int z);

	/**
	 * Method called when the spell is cast on an entity.
	 * Return true to indicate the spell was cast. Otherwise, false.
	 */
	public boolean castOnEntity(EntityPlayer player, ItemStack wand, EntityLivingBase target);
	
	/**
	 * Gets the amount of required render passes for this spell.
	 */
	@SideOnly(Side.CLIENT)
	public int getRequiredRenderPasses();
	
	/**
	 * Gets the icon to render for the specific render pass.
	 */
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int renderPass);
	
	/**
	 * Gets the color for the specific render pass. Return
	 * 0xFFFFFF for no overlayed color.
	 */
	@SideOnly(Side.CLIENT)
	public int getColorForRenderPass(int renderPass);
	
	/**
	 * Passed when icons should be registered. The instance of IconRegister
	 * passed in is the register for items.
	 */
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister registry);
}
