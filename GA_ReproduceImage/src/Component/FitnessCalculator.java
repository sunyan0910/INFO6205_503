package Component;

import Controller.DiffCalculator;
import javafx.scene.image.WritableImage;

public class FitnessCalculator {
	
	public FitnessCalculator(WritableImage image, DiffCalculator<WritableImage,Individual> method) {
		this.environment = image;
		this.diff_calculator = method;
	}
	
	public double getFitness(Individual in) {
		WritableImage individual = diff_calculator.convertIndividual(in);
		return diff_calculator.calcFitness(environment, individual);
	}
	
	private DiffCalculator<WritableImage,Individual> diff_calculator;
	private WritableImage environment;
}
