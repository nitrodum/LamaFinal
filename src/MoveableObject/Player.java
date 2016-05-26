package MoveableObject;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import GameLoop.GameLoop;
import GameWindow.Vector2F;
import main.Main;

public class Player implements KeyListener {

	Vector2F pos;
	private int width = 42;
	private int height = 42;
	private static boolean up, down, left, right;
	private float maxSpeed = 3F;
	// TODO

	private float speedUp = 0;
	private float speedDown = 0;
	private float speedLeft = 0;
	private float speedRight = 0;

	private float slowDown = 0.1F;

	private float fixDT = 40f / 60F;

	private boolean mapMove = true;

	public Player() {
		pos = new Vector2F(Main.width / 2 - width / 2, Main.height / 2 - height / 2);
	}

	public void init() {

	}

	public void tick(double deltaTime) {

		float moveAmountUp = (float) (speedUp * fixDT);
		float moveAmountDown = (float) (speedDown * fixDT);
		float moveAmountLeft = (float) (speedLeft * fixDT);
		float moveAmountRight = (float) (speedRight * fixDT);

		if (!mapMove) {

			if (up) {

				if (speedUp < maxSpeed) {
					speedUp += slowDown;
				} else {
					speedUp = maxSpeed;
				}
				pos.y -= moveAmountUp;
			} else {
				if (speedUp != 0) {
					speedUp -= slowDown;

					if (speedUp < 0) {
						speedUp = 0;
					}
				}
				pos.y -= moveAmountUp;
			}

			if (down) {
				if (speedDown < maxSpeed) {
					speedDown += slowDown;
				} else {
					speedDown = maxSpeed;
				}
				pos.y += moveAmountDown;
			} else {
				if (speedDown != 0) {
					speedDown -= slowDown;

					if (speedDown < 0) {
						speedDown = 0;
					}
				}
				pos.y += moveAmountDown;
			}

			if (left) {
				if (speedLeft < maxSpeed) {
					speedLeft += slowDown;
				} else {
					speedLeft = maxSpeed;
				}
				pos.x -= moveAmountLeft;
			} else {
				if (speedLeft != 0) {
					speedLeft -= slowDown;

					if (speedLeft < 0) {
						speedLeft = 0;
					}
				}
				pos.x -= moveAmountLeft;
			}

			if (right) {
				if (speedRight < maxSpeed) {
					speedRight += slowDown;
				} else {
					speedRight = maxSpeed;
				}
				pos.x += moveAmountRight;
			} else {
				if (speedRight != 0) {
					speedRight -= slowDown;

					if (speedRight < 0) {
						speedRight = 0;
					}
				}
				pos.x += moveAmountRight;
			}
			
			
		}else{

			if(up){
				
				if(speedUp < maxSpeed){
					speedUp += slowDown;
				}else{
					speedUp = maxSpeed;
				}
				GameLoop.map.y -= moveAmountUp;
			}else{
				if(speedUp != 0){
					speedUp -= slowDown;
					
					if(speedUp < 0){
						speedUp = 0;
					}
				}
				GameLoop.map.y -= moveAmountUp;
			}
			
			if(down){
				if(speedDown < maxSpeed){
					speedDown += slowDown;
				}else{
					speedDown = maxSpeed;
				}
				GameLoop.map.y += moveAmountDown;
			}else{
				if(speedDown != 0){
					speedDown -= slowDown;
					
					if(speedDown < 0){
						speedDown = 0;
					}
				}
				GameLoop.map.y += moveAmountDown;
			}
			
			if(left){
				if(speedLeft < maxSpeed){
					speedLeft += slowDown;
				}else{
					speedLeft = maxSpeed;
				}
				GameLoop.map.x -= moveAmountLeft;
			}else{
				if(speedLeft != 0){
					speedLeft -= slowDown;
					
					if(speedLeft < 0){
						speedLeft = 0;
					}
				}
				GameLoop.map.x -= moveAmountLeft;
			}
			
			if(right){
				if(speedRight < maxSpeed){
					speedRight += slowDown;
				}else{
					speedRight = maxSpeed;
				}
				GameLoop.map.x += moveAmountRight;
			}else{
				if(speedRight != 0){
					speedRight -= slowDown;
					
					if(speedRight < 0){
						speedRight = 0;
					}
				}
				GameLoop.map.x += moveAmountRight	;
			}
		}
	}

	public void render(Graphics2D g) {
		g.fillRect((int) pos.x, (int) pos.y, width, height);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_W) {
			up = true;
		}
		if (key == KeyEvent.VK_S) {
			down = true;
		}
		if (key == KeyEvent.VK_A) {
			left = true;
		}
		if (key == KeyEvent.VK_D) {
			right = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

		int key = e.getKeyCode();

		if (key == KeyEvent.VK_W) {
			up = false;
		}
		if (key == KeyEvent.VK_S) {
			down = false;
		}
		if (key == KeyEvent.VK_A) {
			left = false;
		}
		if (key == KeyEvent.VK_D) {
			right = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
