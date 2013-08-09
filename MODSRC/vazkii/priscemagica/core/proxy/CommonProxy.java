/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the PrisceMagica Mod.
 * 
 * PrisceMagica is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * 
 * File Created @ [7 Aug 2013, 21:01:28 (GMT)]
 */
package vazkii.priscemagica.core.proxy;

import vazkii.priscemagica.item.TileEntityDesk;
import vazkii.priscemagica.lib.LibMisc;
import vazkii.priscemagica.lib.LibNames;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {

	public void registerClientHandlers() { }
	
	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityDesk.class, tileName(LibNames.BLOCK_SPELL_DESK));
	}
	
	private String tileName(String name) {
		return LibMisc.MOD_ID + "_" + name;
	}
}
