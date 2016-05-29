package MoveableObject;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import GameLoop.GameLoop;
import GameWindow.Vector2F;
import main.Animator;
import main.Assets;
import main.Check;
import main.Main;

public class Player implements KeyListener {

	Vector2F pos;
	private int width = 32;
	private int height = 32;
	private int scale = 2;
	private static boolean up, down, left, right;
	private float maxSpeed = 3 * 32F;
	// TODO

	private float speedUp = 0;
	private float speedDown = 0;
	private float speedLeft = 0;
	private float speedRight = 0;

	private float slowDown = 32 * 0.1F;

	private float fixDT = 1f / 60F;
	private int renderDistanceWidth = 60;
	private int renderDistanceHeight = 24;
	public static Rectangle render;
	

	private int animationState = 1;
	
	/*
	 * 0 = up
	 * 1 = down
	 * 2 = left
	 * 3 = right
	 * 
	 */
	
	private	ArrayList<BufferedImage> listUp;
	Animator ani_up;
	private	ArrayList<BufferedImage> listDown;
	Animator ani_down;
	private	ArrayList<BufferedImage> listLeft;
	Animator ani_left;
	private	ArrayList<BufferedImage> listRight;
	Animator ani_right;

	public Player() {
		pos = new Vector2F(Main.width / 2 - width / 2, Main.height / 2 - height / 2);
	}

	public void init() {
		
		render = new Rectangle(
				(int)(pos.x - pos.getWorldLocation().x + pos.x - renderDistanceWidth*32 / 2 + width/2),
				(int)(pos.y - pos.getWorldLocation().y + pos.y - renderDistanceHeight*32 /2 + height/2),
				renderDistanceWidth*32,
				renderDistanceHeight*32);
		
		listUp = new ArrayList<BufferedImage>();
		listDown = new ArrayList<BufferedImage>();
		listLeft = new ArrayList<BufferedImage>();
		listRight = new ArrayList<BufferedImage>();
		
		listUp.add(Assets.player.getTile(0, 16, 16, 16));
		listUp.add(Assets.player.getTile(16, 16, 16, 16));
		
		listDown.add(Assets.player.getTile(0, 0, 16, 16));
		listDown.add(Assets.player.getTile(16, 0, 16, 16));
		
		listLeft.add(Assets.player.getTile(0, 32, 16, 16));
		listLeft.add(Assets.player.getTile(16, 32, 16, 16));
		
		listRight.add(Assets.player.getTile(0, 48, 16, 16));
		listRight.add(Assets.player.getTile(16, 48, 16, 16));
		
		
		//UP
		ani_up = new Animator(listUp);
		ani_up.setSpeed(180);
		ani_up.play();
		
		//Down
		ani_down = new Animator(listDown);
		ani_down.setSpeed(180);
		ani_down.play();
		
		//LEFT
		ani_left = new Animator(listLeft);
		ani_left.setSpeed(180);
		ani_left.play();
		
		//RIGHT
		ani_right = new Animator(listRight);
		ani_right.setSpeed(180);
		ani_right.play();
		
	}

	public void tick(double deltaTime) {
		
		render = new Rectangle(
				(int)(pos.x - pos.getWorldLocation().x + pos.x - renderDistanceWidth*32 / 2 + width/2),
				(int)(pos.y - pos.getWorldLocation().y + pos.y - renderDistanceHeight*32 /2 + height/2),
				renderDistanceWidth*32,
				renderDistanceHeight*32);

		float moveAmountUp = (float) (speedUp * fixDT);
		float moveAmountDown = (float) (speedDown * fixDT);
		float moveAmountLeft = (float) (speedLeft * fixDT);
		float moveAmountRight = (float) (speedRight * fixDT);

		{

			if (up) {
				animationState = 0;
				if (!Check.CollisionPlayerBlock(
						new Point((int) (pos.x + GameLoop.map.x), (int) (pos.y + GameLoop.map.y - moveAmountUp)),
						new Point((int) (pos.x + GameLoop.map.x + width),
								(int) (pos.y + GameLoop.map.y - moveAmountUp)))) {
					if (speedUp < maxSpeed) {
						speedUp += slowDown;
					} else {
						speedUp = maxSpeed;
					}
					GameLoop.map.y -= moveAmountUp;
				}
			} else {

				if (!Check.CollisionPlayerBlock(
						new Point((int) (pos.x + GameLoop.map.x), (int) (pos.y + GameLoop.map.y - moveAmountUp)),
						new Point((int) (pos.x + GameLoop.map.x + width),
								(int) (pos.y + GameLoop.map.y - moveAmountUp)))) {
					if (speedUp != 0) {
						speedUp -= slowDown;

						if (speedUp < 0) {
							speedUp = 0;
						}
					}
					GameLoop.map.y -= moveAmountUp;
				}
			}

			if (down) {
				animationState = 1;
				if(!Check.CollisionPlayerBlock(
				 		new Point((int)(pos.x + GameLoop.map.x), (int)(pos.y + GameLoop.map.y + height + moveAmountDown)),
						new Point((int)(pos.x + GameLoop.map.x + width), (int)(pos.y + GameLoop.map.y + height+ moveAmountDown)) )){
				if (speedDown < maxSpeed) {
					speedDown += slowDown;
				} else {
					speedDown = maxSpeed;
				}
				GameLoop.map.y += moveAmountDown;
				}else{
					speedDown = 0;
				}
			} else {
				
				if(!Check.CollisionPlayerBlock(
				 		new Point((int)(pos.x + GameLoop.map.x), (int)(pos.y + GameLoop.map.y + height + moveAmountDown)),
						new Point((int)(pos.x + GameLoop.map.x + width), (int)(pos.y + GameLoop.map.y + height+ moveAmountDown)) )){
				if (speedDown != 0) {
					speedDown -= slowDown;

					if (speedDown < 0) {
						speedDown = 0;
					}
				}
				GameLoop.map.y += moveAmountDown;
				}else{
					speedDown = 0;
				}
			}

			if (left) {
				animationState = 2;
				if(!Check.CollisionPlayerBlock(
				 		new Point((int)(pos.x + GameLoop.map.x - moveAmountLeft), (int)(pos.y + GameLoop.map.y + height)),
						new Point((int)(pos.x + GameLoop.map.x - moveAmountLeft), (int)(pos.y + GameLoop.map.y)) )){
				if (speedLeft < maxSpeed) {
					speedLeft += slowDown;
				} else {
					speedLeft = maxSpeed;
				}
				GameLoop.map.x -= moveAmountLeft;
				}else{
					speedLeft = 0;
				}
			} else {
				if(!Check.CollisionPlayerBlock(
				 		new Point((int)(pos.x + GameLoop.map.x - moveAmountLeft), (int)(pos.y + GameLoop.map.y + height)),
						new Point((int)(pos.x + GameLoop.map.x - moveAmountLeft), (int)(pos.y + GameLoop.map.y)) )){
				if (speedLeft != 0) {
					speedLeft -= slowDown;

					if (speedLeft < 0) {
						speedLeft = 0;
					}
				}
				GameLoop.map.x -= moveAmountLeft;
				}else{
					speedLeft = 0;
				}
			}

			if (right) {
				animationState = 3;
				if(!Check.CollisionPlayerBlock(
				 		new Point((int)(pos.x + GameLoop.map.x + width + moveAmountRight), (int)(pos.y + GameLoop.map.y)),
						new Point((int)(pos.x + GameLoop.map.x + width + moveAmountRight), (int)(pos.y + GameLoop.map.y + height)) )){
				if (speedRight < maxSpeed) {
					speedRight += slowDown;
				} else {
					speedRight = maxSpeed;
				}
				GameLoop.map.x += moveAmountRight;
				}else{
					speedRight = 0;
				}
			} else {
				if(!Check.CollisionPlayerBlock(
				 		new Point((int)(pos.x + GameLoop.map.x + width + moveAmountRight), (int)(pos.y + GameLoop.map.y)),
						new Point((int)(pos.x + GameLoop.map.x + width + moveAmountRight), (int)(pos.y + GameLoop.map.y + height)) )){
				if (speedRight != 0) {
					speedRight -= slowDown;

					if (speedRight < 0) {
						speedRight = 0;
					}
				}
				GameLoop.map.x += moveAmountRight;
				}else{
					speedRight = 0;
				}
			}
		}
	}
	

	public void render(Graphics2D g) {
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Main.width, Main.height/6);
		g.fillRect(0, 900, Main.width, Main.height/6);
		g.setColor(Color.WHITE);
		g.clipRect(0, 0, Main.width, Main.height);
		
		if(animationState == 0){
			g.drawImage(ani_up.sprite, (int) pos.x - width/2, (int) pos.y - height, width*scale, height*scale, null);
			if(up){
			ani_up.update(System.currentTimeMillis());
			}
		}
		
		if(animationState == 1){
			g.drawImage(ani_down.sprite, (int) pos.x - width/2, (int) pos.y - height, width*scale, height*scale, null);
			if(down){
				ani_down.update(System.currentTimeMillis());
				}
		}
		
		if(animationState == 2){
			g.drawImage(ani_left.sprite, (int) pos.x - width/2, (int) pos.y - height, width*scale, height*scale, null);
			if(left){
				ani_left.update(System.currentTimeMillis());
				}
		}
		
		if(animationState == 3){
			g.drawImage(ani_right.sprite, (int) pos.x - width/2, (int) pos.y - height , width*scale, height*scale, null);
			if(right){
				ani_right.update(System.currentTimeMillis());
				}
		}
		
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
