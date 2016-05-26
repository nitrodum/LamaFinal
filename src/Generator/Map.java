package Generator;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import GameWindow.Vector2F;
import GameWindow.loadImageFrom;
import Generator.Block.BlockType;
import MoveableObject.Player;
import main.Main;

public class Map {
	
	TileManager tiles = new TileManager();
	Player player = new Player();
	

	public Map(){
		
	}
	
	public void init(){
		player.init();
		
		BufferedImage map = null;
		
		try{		
			map = loadImageFrom.LoadImageFrom(Main.class, "map.png");
		}catch(Exception e){
			
		}
		
		for(int x = 0; x < 100; x++){
			for(int y = 0; y < 100; y++){
				
				int col = map.getRGB(x, y);
				 
				switch(col & 0xFFFFFF){
				case 0x808080:
					tiles.blocks.add(new Block(new Vector2F(x*32, y*32), BlockType.STONE_1 ));
					break;
				}
				
				}
			}
		

	}
	
	public void tick(double deltaTime){
		tiles.tick(deltaTime);
		player.tick(deltaTime);
	}
	
	public void render(Graphics2D g){
		tiles.render(g);
		player.render(g);
	}

}
