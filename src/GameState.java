import GameWindow.GameWindow;

public class GameState {

	public GameState() {
	}

	public static void main(String[] args) {
		GameWindow frame = new GameWindow("Ninja Run", 1080, 720);
		frame.setFullscreen(1);
		frame.setVisible(true);
	}

}
