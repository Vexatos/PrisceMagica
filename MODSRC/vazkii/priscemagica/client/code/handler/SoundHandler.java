/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the PrisceMagica Mod.
 * 
 * PrisceMagica is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * 
 * File Created @ [9 Aug 2013, 13:42:02 (GMT)]
 */
package vazkii.priscemagica.client.code.handler;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import vazkii.priscemagica.lib.LibResources;

public final class SoundHandler {
	
	@ForgeSubscribe
	public void registerSounds(SoundLoadEvent event) {
		for(String s : LibResources.SOUNDS)
			event.manager.addSound(LibResources.PREFIX_MOD + s + ".ogg");
	}
	
}
