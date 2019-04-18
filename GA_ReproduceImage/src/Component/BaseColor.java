package Component;

public class BaseColor {

	private double r;
	private double g;
	private double b;
	private double a;
	
	public BaseColor() {
		this.r =Math.random();
		this.g =Math.random();
		this.b =Math.random();
		this.a =Math.random();
	}
	
	public BaseColor(double val_r,double val_g,double val_b,double val_a) {
		this.r = val_r;
		this.g = val_g;
		this.b = val_b;
		this.a = val_a;
	}
	
	public void setColor(double val_r,double val_g,double val_b) {
		this.r = val_r;
		this.g = val_g;
		this.b = val_b;
	}
	public void setColor(double val_r,double val_g,double val_b,double val_a) {
		this.r = val_r;
		this.g = val_g;
		this.b = val_b;
		this.a = val_a;
	}
	
	public boolean equal(BaseColor color) {
		return this.r == color.r && this.g== color.g && this.b == color.b && this.a == color.a;
	}
	
	public double getR() {
		return r;
	}
	public void setR(double r) {
		this.r = r;
	}
	public double getG() {
		return g;
	}
	public void setG(double g) {
		this.g = g;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	public double getA() {
		return a;
	}
	public void setA(double a) {
		this.a = a;
	}
	
	
	
	public int getRi() {
		return (int)r*255;
	}
	
	public int getGi() {
		return (int)g*255;
	}
	
	public int getBi() {
		return (int)b*255;
	}
}
