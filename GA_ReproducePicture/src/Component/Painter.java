package Component;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Painter extends Canvas{
	@Override
	public void paint(Graphics graphic) {
		int size = 5;
		int  r, g, b, x1, x2, x3, y1, y2, y3, a;
		for (int i = 0; i < size; i++) {
			Random nmb = new Random();

			r = nmb.nextInt(255);
			g = nmb.nextInt(255);
			b = nmb.nextInt(255);

			x1 = nmb.nextInt(184);
			x2 = nmb.nextInt(184);
			x3 = nmb.nextInt(184);

			y1 = nmb.nextInt(274);
			y2 = nmb.nextInt(274);
			y3 = nmb.nextInt(274);

			a = nmb.nextInt(255);
			graphic.setColor(new Color(r, g, b, a));
			graphic.fillPolygon(new int[] { x1, x2, x3 }, new int[] { y1, y2, y3 }, 3);
		}
	}
}
