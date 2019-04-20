package Controller;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
class FitnessCalculatorTest {

	@Test
	public void test() {
		ProgramController pc=  new ProgramController();
		
		WritableImage image1 = new WritableImage(100,100);
		WritableImage image2 = new WritableImage(100,100);
		PixelWriter pw1 = image1.getPixelWriter();
		PixelWriter pw2 = image2.getPixelWriter();

		for(int i =0;i<100;i++) {
			for(int j = 0;j<100;j++) {
				pw1.setColor(i, j, Color.WHITE);
				pw2.setColor(i, j, Color.BLACK);
			}
		}
		PixelReader pr1 = image1.getPixelReader();
		PixelReader pr2 = image1.getPixelReader();
//		assertEquals(Color.RED, pr1.getColor(0, 0));
//		assertEquals(Color.RED, pr2.getColor(0, 0));
		
		//assertEquals(true, pr1.getColor(0, 0));
		//assertEquals(true, pr2.getColor(0, 0));
		
		assertEquals(0,pc.calcFitness(image1,image2),0.1);

	}

}
