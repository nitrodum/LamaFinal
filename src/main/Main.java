package main;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JOptionPane;

import GameLoop.GameLoop;
import GameWindow.GameWindow;
import GameWindow.SpriteSheet;
import MoveableObject.Player;



public class Main {
	
	static SpriteSheet blocks = new SpriteSheet();
	
	public static GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
	public static int width = gd.getDisplayMode().getWidth();
	public static int height = gd.getDisplayMode().getHeight();

	public static void main(String[] args) {
		GameWindow frame = new GameWindow("Ninja Run", width, height);
		frame.setFullscreen(1);
		frame.addKeyListener(new Player());
		frame.add(new GameLoop(width, height));
		frame.setVisible(true);	
		}

}
