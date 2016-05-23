package GameWindow;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

public class GameWindow extends JFrame {

	boolean fullscreen = false;
	int mode = 0;
	GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];

	public GameWindow(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}

	private void setFullscreen(){
		switch(mode){
		case 0:
			System.out.println("No Fullscreen");
			setUndecorated(false);
			break;
		case 1:
			setExtendedState(JFrame.MAXIMIZED_BOTH);
			setUndecorated(true);
			break;
		case 2:
			device.setFullScreenWindow(this);
			setUndecorated(true);
			break;
		}
	}
	
	public void setFullscreen(int newMode){
		fullscreen = true;
		if(mode <= 2){
			this.mode = newMode;
			setFullscreen();
		}else{
			System.err.println("Error " + newMode + " is not supported");
		 
		}
	}

}
