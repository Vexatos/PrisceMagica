/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the PrisceMagica Mod.
 * 
 * PrisceMagica is Open Source and distributed under a
 * Creative Commons Attribution-NonCommercial-ShareAlike 3.0 License
 * (http://creativecommons.org/licenses/by-nc-sa/3.0/deed.en_GB)
 * 
 * File Created @ [9 Aug 2013, 14:23:52 (GMT)]
 */
package vazkii.priscemagica.client.render.tile;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBook;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import vazkii.priscemagica.item.TileEntityDesk;

public class RenderTileDesk extends TileEntitySpecialRenderer {

    private static final ResourceLocation resourceBook = new ResourceLocation("textures/entity/enchanting_table_book.png");
    private static final ResourceLocation resourceMap = new ResourceLocation("textures/map/map_background.png");
    private static final ModelBook book = new ModelBook();
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double d0, double d1, double d2, float f) {
		TileEntityDesk desk = (TileEntityDesk) tileentity;
		GL11.glPushMatrix();
		GL11.glTranslated(d0, d1, d2);
		GL11.glTranslatef(0F, 0.815F, 0F);		
		GL11.glRotated(90F, 1F, 0F, 0F);
		GL11.glTranslatef(0.12F, 0.25F, 0F);
		GL11.glRotatef(34F, 0F, 0F, 1F);
		GL11.glScalef(0.75F, 0.75F, 0.75F);
		Minecraft.getMinecraft().renderEngine.func_110577_a(resourceBook);
		GL11.glEnable(GL11.GL_CULL_FACE);
		book.render(null, 0F, 0F, 0F, 0F, 0F, 0.0625F);
		GL11.glDisable(GL11.GL_CULL_FACE);
		Minecraft.getMinecraft().renderEngine.func_110577_a(resourceMap);
		
		GL11.glRotatef(90F, 0F, 1F, 0F);
		GL11.glRotatef(20F, 1F, 0F, 0F);
		GL11.glTranslatef(-0.08F, 0F, 0.4F);
		GL11.glDisable(GL11.GL_LIGHTING);
		Tessellator tess = Tessellator.instance;
		tess.startDrawingQuads();
		tess.addVertexWithUV(0F, 0F, 0.75F, 0, 1);
		tess.addVertexWithUV(0F, 0.75F, 0.75F, 1, 1);
		tess.addVertexWithUV(0F, 0.75F, 0F, 1, 0);
		tess.addVertexWithUV(0F, 0F, 0F, 0, 0);
		tess.draw();
		
		float scale = 1 / 128F;
		GL11.glScalef(scale, scale, scale);
		GL11.glRotatef(-90F, 0F, 1F, 0F);
		GL11.glTranslatef(5F, 5F, -1F);
		FontRenderer font = Minecraft.getMinecraft().standardGalacticFontRenderer;
		
		String[] text = {
				"this is going to be a",
				"spell here, but as",
				"of now it's just",
				"writing some data",
				"please wait a bit",
				"for your spell.",
				"if you decided to",
				"read this then you",
				"just wasted a",
				"bunch of time, woo"
		};

		for(int i = 0; i < text.length; i++) {
			font.drawString(text[i], 0, 0, 0x555555);
			GL11.glTranslatef(0F, 9F, 0F);
		}
		
		GL11.glPopMatrix();
	}

}
