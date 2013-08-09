/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the PrisceMagica Mod.
 *
 * PrisceMagica is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 *
 * File Created @ [7 Aug 2013, 21:01:38 (GMT)]
 */
package vazkii.priscemagica.core.proxy;

import net.minecraftforge.common.MinecraftForge;
import vazkii.priscemagica.client.code.handler.SoundHandler;
import vazkii.priscemagica.client.render.tile.RenderTileDesk;
import vazkii.priscemagica.item.TileEntityDesk;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerClientHandlers() {
		MinecraftForge.EVENT_BUS.register(new SoundHandler());
	}

	@Override
	public void registerTileEntities() {
		super.registerTileEntities();

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDesk.class, new RenderTileDesk());
	}

}
