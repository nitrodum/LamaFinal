package GameState;
import java.awt.Graphics2D;

public abstract class GameState {

	GameStateManager gsm;
	
	public GameState(GameStateManager gsm) {
		this.gsm = gsm;
	}
	
	public abstract void init();
	public abstract void tick(double detlaTime);
	public abstract void render(Graphics2D g);
	

}
