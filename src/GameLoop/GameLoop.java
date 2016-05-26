package GameLoop;

import java.awt.Component;

import GameState.GameStateManager;
import GameWindow.NLGameLoop;
import GameWindow.Vector2F;
import main.Assets;

public class GameLoop extends NLGameLoop {
	
	GameStateManager gsm;
	public static Assets assets = new Assets();
	public static Vector2F map = new Vector2F();

	public GameLoop(int width, int height) {
		super(width, height);
	}
	
	@Override
	public void init() {
		assets.init();
		
		gsm = new GameStateManager();
		gsm.init();
		super.init();
	}
	
	@Override
	public void tick(double deltaTime) {
		Vector2F.setWorldVaribles(map.x, map.y);	
		gsm.tick(deltaTime);
	}
	
	@Override
	public void render() {
		super.render();
		gsm.render(graphics2D);
		clear();
	}
	
	@Override
	public void clear() {
		super.clear();
	}

}
