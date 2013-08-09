/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the PrisceMagica Mod.
 * 
 * PrisceMagica is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * 
 * File Created @ [7 Aug 2013, 22:23:05 (GMT)]
 */
package vazkii.priscemagica.item;

import java.util.Random;

import vazkii.priscemagica.lib.LibResources;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWand extends ItemMod {

	public ItemWand(int par1) {
		super(par1);

		setMaxStackSize(1);
	}
	
	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		int id = par3World.getBlockId(par4, par5, par6);
		if(id == Block.enchantmentTable.blockID) {
			par3World.setBlock(par4, par5, par6, ModItems.desk.blockID);
			par3World.playSoundEffect(par4, par5, par6, LibResources.PSOUND_TABLE_TRANSFORM, 1F, 1F);
			for(int i = 0; i < 360; i++) {
				Random par5Random = par3World.rand;
				double xo = Math.random() - 0.5;
				double zo = Math.random() - 0.5;
				
	            double x = par4 + 0.5 + xo;
	            double y = par5 + 0.5;
	            double z = par6 + 0.5 + zo;
	            
	            double xm = -(Math.random() - 0.5) / 0.25 - xo;
	            double ym = -(Math.random()) * 0.5; 
	            double zm = -(Math.random() - 0.5) / 0.25 - zo;

	            par3World.spawnParticle("portal", x, y, z, xm, ym, zm);
			}
			
			return true;
		} else return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldRotateAroundWhenRendering() {
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.epic;
	}

}
