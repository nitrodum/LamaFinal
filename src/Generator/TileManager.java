package Generator;

import java.awt.Graphics2D;
import java.util.ArrayList;

import GameWindow.Vector2F;

public class TileManager {
	
	public static ArrayList<Block> blocks = new ArrayList<Block>();

	public TileManager() {
		
	}
	
	public void tick(double deltaTime){
		for(Block block : blocks){
			block.tick(deltaTime);
		}
	}
	
	public void render(Graphics2D g){
		for(Block block : blocks){
			block.render(g);
		}
	}

}
