import javax.swing.JOptionPane;

import GameLoop.GameLoop;
import GameWindow.GameWindow;
import GameWindow.SpriteSheet;



public class Main {
	
	static SpriteSheet blocks = new SpriteSheet();

	public Main() {
	}

	public static void main(String[] args) {
		GameWindow frame = new GameWindow("Ninja Run", 1080, 720);
		frame.setFullscreen(1);
		frame.add(new GameLoop(1280, 720));
		frame.setVisible(true);	
	}

}
