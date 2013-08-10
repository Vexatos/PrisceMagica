/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the PrisceMagica Mod.
 * 
 * PrisceMagica is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * 
 * File Created @ [10 Aug 2013, 15:08:57 (GMT)]
 */
package vazkii.priscemagica.spell;

import vazkii.priscemagica.api.ISpell;
import vazkii.priscemagica.lib.LibNames;
import vazkii.priscemagica.spell.offensive.SpellFireball;
import vazkii.priscemagica.spell.offensive.SpellIcebolt;

public final class ModSpells {

	public static ISpell fireball;
	public static ISpell icebolt;
	
	public static void registerSpells() {
		fireball = new SpellFireball(LibNames.SPELL_FIREBALL);
		icebolt = new SpellIcebolt(LibNames.SPELL_ICEBOLT);
	}
	
}
