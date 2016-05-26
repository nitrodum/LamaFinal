package main;

import java.awt.image.BufferedImage;

import GameWindow.SpriteSheet;
import GameWindow.loadImageFrom;

public class Assets {
	
	SpriteSheet blocks = new SpriteSheet(); 
	
	public static BufferedImage stone_1;
	
	public void init() {
		 blocks.setSpriteSheet(loadImageFrom.LoadImageFrom(Main.class, "SpriteSheet.png"));
		 
		 stone_1 = blocks.getTile(0,0,16,16);
	}
	
	public static BufferedImage getStone_1() {
		return stone_1;
	}
	

}
