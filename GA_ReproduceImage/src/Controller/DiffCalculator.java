package Controller;

// Calculation Method
public interface DiffCalculator<T,Ti> {
	// retrieve info from an individual, then, convert it to the target type (get the image)
	public T convertIndividual(Ti individual);
	// diff algorithm, compare pixels
	public double  calcFitness(T environment, T individual);
}
