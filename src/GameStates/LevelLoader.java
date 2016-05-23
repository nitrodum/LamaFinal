package GameStates;

import java.awt.Graphics2D;

import GameState.GameState;
import GameState.GameStateManager;

public class LevelLoader extends GameState {

	public LevelLoader(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		
	}

	@Override
	public void tick(double detlaTime) {
		
	}

	@Override
	public void render(Graphics2D g) {
		g.drawString("HELLO", 200, 200);
	}

}
