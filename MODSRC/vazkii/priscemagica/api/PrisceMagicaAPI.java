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

public final class PrisceMagicaAPI {

	private static Map<String, ISpell> spells = new HashMap();
	protected static Map<ISpell, SpellAvailability> availability = new HashMap();
	
	public void registerSpell(ISpell spell, String name) {
		if(spells.containsKey(name))
			throw new IllegalArgumentException("Name \"" + name + "\" is already taken by " + spells.get(name) + " when adding " + spell + "!");
		
		spells.put(name, spell);
	}
	
	public ISpell getSpell(String name) {
		return spells.get(name);
	}
	
	public SpellAvailability getAvailability(String name) {
		return getAvailability(getSpell(name));
	}
	
	public SpellAvailability getAvailability(ISpell spell) {
		return spell != null && availability.containsKey(spell) ? availability.get(spell) : SpellAvailability.DISABLED;
	}
	
}
