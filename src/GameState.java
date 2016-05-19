import GameWindow.GameWindow;
import GameWindow.SpriteSheet;

public class GameState {
	
	static SpriteSheet blocks = new SpriteSheet();

	public GameState() {
	}

	public static void main(String[] args) {
		GameWindow frame = new GameWindow("Ninja Run", 1080, 720);
		frame.setFullscreen(1);
		frame.setVisible(true);
	}

}
