/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the PrisceMagica Mod.
 * 
 * PrisceMagica is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * 
 * File Created @ [8 Aug 2013, 20:53:41 (GMT)]
 */
package vazkii.priscemagica.item;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;
import vazkii.priscemagica.client.core.helper.IconHelper;
import vazkii.priscemagica.lib.LibNames;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDesk extends BlockMod {

	private Icon down, side, top;
	
	public BlockDesk(int par1) {
		super(par1, Material.rock);
        setBlockBounds(0F, 0F, 0F, 1F, 0.75F, 1F);
        setLightOpacity(0);
        setResistance(2000.0F);
        
        GameRegistry.registerBlock(this, LibNames.BLOCK_SPELL_DESK);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1IconRegister) {
		down = IconHelper.forName(par1IconRegister, "spellDeskDown");
		side = IconHelper.forName(par1IconRegister, "spellDeskSide");
		top = IconHelper.forName(par1IconRegister, "spellDeskTop");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2) {
		return par1 == ForgeDirection.DOWN.ordinal() ? down : par1 == ForgeDirection.UP.ordinal() ? top : side;
	}

}