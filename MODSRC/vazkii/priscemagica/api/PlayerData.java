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
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;

/**
 * Internal class. Data for a specific player, you can access
 * the components of this by using the API.
 */
public final class PlayerData implements Serializable {
	
	private List<String> knownSpells = new ArrayList();
	private String[] usingSpells = new String[9];
	
	private int selectedSpell = 0;
	
	public void readFromNBT(EntityPlayer player) {
		NBTTagCompound cmp = player.getEntityData();
		if(!cmp.hasKey("PrisceMagica"))
			return;
		
		NBTTagCompound modcmp = cmp.getCompoundTag("PrisceMagica");
		NBTTagList spellList = cmp.getTagList("KnownSpells");
		
		knownSpells.clear();
		
		for(int i = 0; i < spellList.tagCount(); i++)
			knownSpells.add(((NBTTagString) spellList.tagAt(i)).data);
		
		for(int i = 0; i < usingSpells.length; i++) {
			String s = modcmp.getString("Spell" + i);
			usingSpells[i] = s;
		}
		
		selectedSpell = modcmp.getInteger("Selected");
	}
	
	public void writeToNBT(EntityPlayer player) {
		NBTTagCompound cmp = player.getEntityData();
		NBTTagCompound modcmp = new NBTTagCompound();
		
		NBTTagList list = new NBTTagList();
		for(String s : knownSpells)
			list.appendTag(new NBTTagString("", s));
		modcmp.setTag("KnownSpells", list);
		
		for(int i = 0; i < usingSpells.length; i++) {
			String s = usingSpells[i];
			modcmp.setString("Spell" + i, s);
		}
		
		modcmp.setInteger("Selected", selectedSpell);
		
		cmp.setCompoundTag("PrisceMagica", modcmp);
	}	
}
