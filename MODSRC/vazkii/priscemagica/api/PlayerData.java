/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the PrisceMagica Mod.
 *
 * PrisceMagica is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 *
 * File Created @ [9 Aug 2013, 22:58:58 (GMT)]
 */
package vazkii.priscemagica.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;

public final class PlayerData implements Serializable {
	
	public static List<String> knownSpells = new ArrayList();
	public static String[] usingSpells = new String[6];
	
	protected void readFromNBT(EntityPlayer player) {
		// TODO
	}
	
	protected void writeToNBT(EntityPlayer player) {
		// TODO
	}	
}
