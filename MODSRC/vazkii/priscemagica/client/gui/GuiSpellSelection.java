/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the PrisceMagica Mod.
 *
 * PrisceMagica is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 *
 * File Created @ [9 Aug 2013, 19:58:46 (GMT)]
 */
package vazkii.priscemagica.client.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import vazkii.priscemagica.client.core.helper.RenderHelper;
import vazkii.priscemagica.lib.LibResources;

public class GuiSpellSelection extends GuiScreen {

	public static final ResourceLocation guiTex = new ResourceLocation(LibResources.PREFIX_GUI);
    private static final ResourceLocation resourceMap = new ResourceLocation("textures/map/map_background.png");

	final int xSize = 176, ySize = 166;

	GuiButton up, down;
	GuiTextField textField;

	static List<String> defValues = new ArrayList();
	static {
		for(int i = 0; i < 219; i++)
			defValues.add("" + i);
	}

	List<String> values = new ArrayList(); // Currently testing
	int location = 0;

	@Override
	public void initGui() {
		super.initGui();

		int k = (width - xSize) / 2;
		int l = (height - ySize) / 2;

		buttonList.clear();
		up = new GuiSelectionButton(0, k + 58, l + 17, false);
		down = new GuiSelectionButton(0, k + 58, l + 137, true);

		buttonList.add(up);
		buttonList.add(down);

		updateValues("");
		textField = new GuiTextField(fontRenderer, k + 57, l + 148, 110, 13);
		textField.setFocused(true);
		textField.setCanLoseFocus(false);
		textField.setMaxStringLength(25);
		textField.setVisible(true);
	}

	@Override
	public void updateScreen() {
		if(isHovering && isShiftKeyDown())
			size = Math.min(1F, Math.max(0.01F, size) + size);
		else size = 0;
	}

	public void updateValues(String search) {
		values.clear();
		for(String s : defValues)
			if(search.isEmpty() || s.toUpperCase().contains(search.toUpperCase()))
				values.add(s);
	}

	@Override
	protected void keyTyped(char par1, int par2) {
		super.keyTyped(par1, par2);
		textField.textboxKeyTyped(par1, par2);

		updateValues(textField.getText());
		location = 0;
	}

	@Override
	protected void mouseClicked(int par1, int par2, int par3) {
		super.mouseClicked(par1, par2, par3);
		textField.mouseClicked(par1, par2, par3);
	}

	@Override
	protected void actionPerformed(GuiButton par1GuiButton) {
		if(par1GuiButton == down) {
			if(location + 6 <= values.size() / 6)
				location++;
		} else if(location > 0)
			location--;
	}

	@Override
	public void drawScreen(int par1, int par2, float par3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.func_110434_K().func_110577_a(guiTex);
		int k = (width - xSize) / 2;
		int l = (height - ySize) / 2;
		drawTexturedModalRect(k, l, 0, 0, xSize, ySize);

		for(int i = 0; i < 6; i++)
			for(int j = 0; j < 6; j++)
				drawEntry(k, l, i, j, location * 6 + i + j * 6, par1, par2);

		if(!textField.getText().isEmpty())
			textField.drawTextBox();

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		super.drawScreen(par1, par2, par3);

		if(!text.isEmpty())
			RenderHelper.renderTooltip(par1, par2, Arrays.asList(text)); // TODO!
		else isHovering = false;

		if(size > 0) {
			GL11.glPushMatrix();
			GL11.glTranslatef(par1 + 10, par2 + 4, 0F);
			GL11.glScalef(size / 3, size / 3, 1F);
			mc.func_110434_K().func_110577_a(resourceMap);
			drawTexturedModalRect(0, 0, 0, 0, 256, 256);
			//boolean unicode = fontRenderer.getUnicodeFlag();
			GL11.glScalef(1.5F, 1.5F, 2F);
			//fontRenderer.setUnicodeFlag(true); // TODO placeholder
			String s = "the quick brown fox jumped over the lazy dog because he had nothing better to do and then a bad wolf came and ate some pigs, so the fox was sad because he liked the pigs so the lazy dog started shouting and the bad wolf ran away and the quick fox ran behind him trying to catch him to avenge the pigs but he got tired and fell in the way. the end";
			fontRenderer.drawSplitString(s, 8, 8, 164, 0);
			//fontRenderer.setUnicodeFlag(unicode);
			GL11.glPopMatrix();
		}

		text = "";
	}

	boolean isHovering = false;
	float size = 0F;
	String text = "";

	public void drawEntry(int xs, int ys, int x, int y, int loc, int mx, int yx) {
		if(loc >= values.size())
			return;

		int xd = xs + 58 + x * 18;
		int yd = ys + 24 + y * 19;
		if(mx >= xd && mx < xd + 18 && yx >= yd && yx < yd + 18) {
			text = values.get(loc);
			isHovering = true;
		}

		mc.func_110434_K().func_110577_a(guiTex);
		drawTexturedModalRect(xd, yd, 176, 0, 18, 18);
	}
}
