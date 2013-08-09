/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the PrisceMagica Mod.
 * 
 * PrisceMagica is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * 
 * File Created @ [9 Aug 2013, 20:50:23 (GMT)]
 */
package vazkii.priscemagica.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

public class GuiSelectionButton extends GuiButton {

	boolean down;
	
	public GuiSelectionButton(int par1, int par2, int par3, boolean down) {
		super(par1, par2, par3, 108, 7, "");
		this.down = down;
	}
	
	@Override
	public void drawButton(Minecraft par1Minecraft, int par2, int par3) {
		if(!enabled)
			return;
		
		par1Minecraft.renderEngine.func_110577_a(GuiSpellSelection.guiTex);
		int hover = getHoverState(par2 >= xPosition && par3 >= yPosition && par2 < xPosition + width && par3 < yPosition + height);
		int y = 166 + (down ? 14 : 0) + (hover == 2 ? 7 : 0);
		drawTexturedModalRect(xPosition, yPosition, 0, y, 108, 7);
	}

}
