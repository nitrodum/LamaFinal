	package Generator;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import GameWindow.Vector2F;
import main.Assets;

public class Block extends Rectangle{
	
	Vector2F pos = new Vector2F();
	private int BlockSize = 32;
	private BlockType blocktype;
	private BufferedImage block;
	private boolean isSolid;
	
	public Block(Vector2F pos, BlockType blocktype){
		setBounds((int)pos.x, (int)pos.y, BlockSize, BlockSize);
		this.pos = pos;
		this.blocktype = blocktype;
		init();
	}
	
	public Block isSolid(boolean isSolid){
		this.isSolid = isSolid;
		return this;
	}
	
	public void init(){
		switch(blocktype){
		case STONE_1:
			block = Assets.getStone_1();
			break;
		case WALL_1:
			block = Assets.getWall_1();
			break;
		}
	}
	
	public void tick(double deltaTime){
		
	}

	public void render(Graphics2D g){
	//	g.drawRect((int)pos.getWorldLocation().x, (int)pos.getWorldLocation().y, BlockSize, BlockSize);
		g.drawImage(block,(int)pos.getWorldLocation().x, (int)pos.getWorldLocation().y, BlockSize, BlockSize, null);
		
		if(isSolid){
			g.drawRect((int)pos.getWorldLocation().x, (int)pos.getWorldLocation().y, BlockSize, BlockSize);
		}
	}
	
	public enum BlockType{
		STONE_1,
		WALL_1
	}

	public boolean isSolid() {
		return isSolid	;
	}
	
}
