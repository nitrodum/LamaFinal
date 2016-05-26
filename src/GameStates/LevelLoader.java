package GameStates;

import java.awt.Graphics2D;

import GameState.GameState;
import GameState.GameStateManager;
import GameWindow.SpriteSheet;
import GameWindow.loadImageFrom;
import Generator.Map;
import sun.applet.Main;

public class LevelLoader extends GameState {
	
	Map map;

	public LevelLoader(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		map = new Map();
		map.init();
	}

	@Override
	public void tick(double deltaTime) {
		map.tick(deltaTime);
	}

	@Override
	public void render(Graphics2D g) {
		map.render(g);
		
	}

}
