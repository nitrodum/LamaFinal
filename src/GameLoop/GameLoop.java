package GameLoop;

import java.awt.Component;

import GameState.GameStateManager;
import GameWindow.NLGameLoop;
import GameWindow.Vector2F;
import main.Assets;

public class GameLoop extends NLGameLoop {
	
	GameStateManager gsm;
	public static Assets assets = new Assets();
	public static float xOffset;
	public static float yOffset;

	public GameLoop(int width, int height) {
		super(width, height);
	}
	
	@Override
	public void init() {
		assets.init();
		Vector2F.setWorldVaribles(xOffset, yOffset);
		gsm = new GameStateManager();
		gsm.init();
		super.init();
	}
	
	@Override
	public void tick(double deltaTime) {
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
