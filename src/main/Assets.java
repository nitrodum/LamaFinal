package main;

import java.awt.image.BufferedImage;

import GameWindow.SpriteSheet;
import GameWindow.loadImageFrom;

public class Assets {
	
	SpriteSheet blocks = new SpriteSheet(); 
	public static SpriteSheet player = new SpriteSheet();
	
	public static BufferedImage stone_1;
	public static BufferedImage wall_1;
	public static BufferedImage fence_1;
	
	public void init() {
		 blocks.setSpriteSheet(loadImageFrom.LoadImageFrom(Main.class, "SpriteSheet.png"));
		 player.setSpriteSheet(loadImageFrom.LoadImageFrom(Main.class, "PlayerSheet.png"));
		 
		 stone_1 = blocks.getTile(0,0,16,16);
		 wall_1 = blocks.getTile(16,0,16,16);
		 fence_1 = blocks.getTile(32,0,16,16);
		 
	}
	
	public static BufferedImage getStone_1() {
		return stone_1;
	}
	public static BufferedImage getWall_1() {
		return wall_1;
	}
	public static BufferedImage getFence_1(){
		return fence_1;
	}
	

}
