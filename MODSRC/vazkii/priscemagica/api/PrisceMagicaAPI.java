/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the PrisceMagica Mod.
 *
 * PrisceMagica is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 *
 * File Created @ [9 Aug 2013, 23:02:11 (GMT)]
 */
package vazkii.priscemagica.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * The main API for the PrisceMagica mod. Registry functions
 * are to be called from here.
 */
public final class PrisceMagicaAPI {

	private static Map<String, ISpell> spells = new HashMap();
	protected static Map<ISpell, SpellAvailability> availability = new HashMap();
	
	private static WeakHashMap<String, PlayerData> playerData = new WeakHashMap();
	
	@SideOnly(Side.CLIENT)
	private static PlayerData clientSidedData;
	
	/**
	 * Registers a spell, along with the name of the spell to map with.<br>
	 * Call this during PreInit or bad stuff will happen.
	 */
	public static void registerSpell(ISpell spell, String name) {
		if(spells.containsKey(name))
			throw new IllegalArgumentException("Name \"" + name + "\" is already taken by " + spells.get(name) + " when adding " + spell + "!");
		
		spells.put(name, spell);
	}
	
	/**
	 * Gets a spell from mappings, given the name passed in. If no spell is found mapped
	 * to this name, it returns null.
	 */
	public static ISpell getSpell(String name) {
		return spells.get(name);
	}
	
	/**
	 * Gets the mapped availability from this spell name. If it fails
	 * to find a spell with this name, or the spell mapped to this name
	 * does not have an availability mapping, it returns DISABLED.
	 * @see SpellAvailability
	 */
	public static SpellAvailability getAvailability(String name) {
		return getAvailability(getSpell(name));
	}
	
	/**
	 * Gets the mapped availability for the spell passed in. If the
	 * spell isn't mapped to an availability, it returns DISABLED.
	 * @see SpellAvailability
	 */
	public static SpellAvailability getAvailability(ISpell spell) {
		return spell != null && availability.containsKey(spell) ? availability.get(spell) : SpellAvailability.DISABLED;
	}
	
	/**
	 * Returns a Set with the names of all registered spells.
	 */
	public static Set<String> getRegisteredSpells() {
		return spells.keySet();
	}
	
	/**
	 * Gets the PlayerData instance for the player username passed in.
	 */
	public static PlayerData getDataForPlayer(String player) {
		return playerData.get(player);
	}
	
	@SideOnly(Side.CLIENT)
	public static PlayerData getClientData() {
		return clientSidedData;
	}
	
	// INTERNAL METHODS: ========================================================
	
	public static void mapAvailability(String spell, SpellAvailability avail) {
		availability.put(getSpell(spell), avail);
	}
	
	public static void setDataForPlayer(EntityPlayer player, PlayerData data) {
		playerData.put(player.username, data);
		data.readFromNBT(player);
	}
	
	@SideOnly(Side.CLIENT)
	public static void setClientData(PlayerData data) {
		clientSidedData = data;
	}
}
