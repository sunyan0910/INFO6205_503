package Controller;

public interface DiffCalculator<T,Ti> {
	public T convertIndividual(Ti individual);
	public double  calcFitness(T environment, T individual);
}
