package Component;

import java.util.Random;

public class BasePosition {
	static private double max_random_x = 600.0;
	static private double max_random_y = 500.0;
	
	private double x;
	private double y;
	
	
	public BasePosition() {
		Random random = new Random();
		this.x =random.nextDouble()* max_random_x;
		this.y = random.nextDouble()* max_random_y;
	}
	
	public BasePosition(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void setPosition(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean equal(BasePosition position) {
		return position.x == this.x && this.y == position.y;
	}
	

	public double getX() {
		return x;
	}


	public void setX(double x) {
		this.x = x;
	}


	public double getY() {
		return y;
	}


	public void setY(double y) {
		this.y = y;
	}
	
	
	
	// set position boundary
	public static void setBoundaryMaxX(double value) {
		max_random_x = value;
	}
	public static void setBoundaryMaxY(double value) {
		max_random_y = value;
	}
	public static double getBoundaryMaxX() {
		return max_random_x;
	}

	public static double getBoundaryMaxY() {
		return max_random_y;
	}

}
