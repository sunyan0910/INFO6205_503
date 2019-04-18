package Component;

import java.util.Random;

public class GenePolygon {
	static int max_verticles = 6;
	private BaseColor color;
	private BasePosition[] position;
	
	public static void setVerticles(int num) {
		max_verticles = num;
	}
	
	
	public GenePolygon() {
		this.color = new BaseColor();
		Random random = new Random();
		int verticles = random.nextInt(max_verticles-3+1)+3;
		this.position = new BasePosition[verticles];
		
		for(int i =0;i<verticles;i++) {
			this.position[i] = new BasePosition();
		}
	}
	
	public void randomGene() {
		this.color = new BaseColor();
		Random random = new Random();
		int verticles = random.nextInt(max_verticles-3+1)+3;
		this.position = new BasePosition[verticles];
	}
	
	public boolean checkEquality(GenePolygon gene) {
		
		if(gene.position.length != this.position.length)
			return false;
		
	
		if(!this.color.equal(gene.color))
			return false;
		for(int i =0;i<position.length;i++) {
			if(!position[i].equal(gene.position[i])) {
				return false;
			}
			
		}
		
		
		return true;
		
	}
	public BaseColor getColor() {
		return color;
	}
	public void setColor(BaseColor color) {
		this.color = color;
	}
	public void setColor(double val_r,double val_g,double val_b) {
		this.color.setColor(val_r, val_g, val_b);
	}
	public void setColor(double val_r,double val_g,double val_b,double val_a) {
		this.color.setColor(val_r, val_g, val_b,val_a);
	}
	
	public BasePosition[] getPosition() {
		return position;
	}
	public void setPosition(BasePosition[] position) {
		this.position = position;
	}
	
	@Override
	public String toString() {
		String str = "";
		str += color.toString();
		for(int i =0;i<position.length; i++) {
			str+=position[i].toString();
		}
		return str;
	}
}
