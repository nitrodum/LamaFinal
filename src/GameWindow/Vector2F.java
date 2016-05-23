package GameWindow;

public class Vector2F {
	
	public float x;
	public float y;
	
	public static float worldXPos;
	public static float worldYPos;


	public Vector2F() {
		this.x = 0.0f;
		this.y = 0.0f;
	}
	
	public Vector2F(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2F zero(){
		return new Vector2F(0,0);		
	}
	
	public void normalize(){
		double length = Math.sqrt((x*x) + (y*y));
		if(length != 0.0){
			float s = 1.0f / (float) length;
			x = x*s;
			y = y*s;
		}		
	}
	
	public boolean equals(Vector2F vec){
		return (this.x == vec.x && this.y == vec.y);
	}

	public Vector2F copy(Vector2F vec){
		x = vec.x;
		y = vec.y;
		return new Vector2F(x, y);
	}
	
	public Vector2F add(Vector2F vec){
		x = x + vec.x;
		y = y + vec.y;
		return new Vector2F(x,y);
	}
	
	public static void setWorldVaribles(Float wx, Float wy){
		worldXPos = wx;
		worldYPos = wy;
	}
	
	public static double getDistanceOnScreen(Vector2F vec1, Vector2F vec2){
		float v1 = vec1.x - vec2.x;
		float v2 = vec1.y - vec2.y;
		return Math.sqrt((v1*v1) + (v2*v2));	
	}
	
	public Vector2F getScreenLocation(){
		return new Vector2F(x, y);
	}
	
	public Vector2F getWorldLocation(){
		return new Vector2F(x - worldXPos, y - worldYPos);
	}
	
	public double getDistanceBetweenWorldVectors(Vector2F vec){
		float dx = Math.abs(getWorldLocation().x - vec.getWorldLocation().x);
		float dy = Math.abs(getWorldLocation().y - vec.getWorldLocation().y);
		return Math.abs((dx * dx) + (dy * dy));
	}
}
