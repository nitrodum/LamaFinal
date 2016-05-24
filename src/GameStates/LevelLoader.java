package GameStates;

import java.awt.Graphics2D;

import GameState.GameState;
import GameState.GameStateManager;
import GameWindow.SpriteSheet;
import GameWindow.loadImageFrom;
import sun.applet.Main;

public class LevelLoader extends GameState {
	
	SpriteSheet test = new SpriteSheet();

	public LevelLoader(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		test.setSpriteSheet(loadImageFrom.LoadImageFrom(Main.class, "SpriteSheet.png"));
	}

	@Override
	public void tick(double detlaTime) {
		
	}

	@Override
	public void render(Graphics2D g) {
		g.drawString("HELLO", 200, 200);
		g.drawImage(test.getTile(0, 0, 16, 16), 0, 0, 64, 64, null);
	}

}
