package Component;
import java.util.Arrays;
import java.util.Random;

public class Population {



	private Individual[] population;
	private double populationFitness;

	private int size;

	public Population(int size) {
		this.population = new Individual[size];
		for(int i =0;i<size;i++)
			population[i] = new Individual();
		this.size = size;
	}



	/*
	 * public Population(int populationSize,int chromosomeLen) { this.population=new
	 * Individual[populationSize]; for(int i=0;i<populationSize;i++) { Individual
	 * individule=new Individual(); this.population[i]=individule; } }
	 */



	public Individual[] getPopulation() {
		return this.population;
	}


	public Individual getFittest(int i) {
		Arrays.sort(this.population,(Individual o1, Individual o2) -> {
					if (o1.getFitness() > o2.getFitness()) {
						return -1;
					} else if (o1.getFitness() < o2.getFitness()) {
						return 1;
					}
					return 0;
		});
		return this.population[i];
	}

	public void setPopulationFitness(double fitness) {
		this.populationFitness = fitness;
	}

	public double getPopulationFitness() {
		return this.populationFitness;
	}

	public int getSize() {
		return this.population.length;
	}

	public Individual setIndividual(int index, Individual individual) {
		return this.population[index] = individual;
	}

	public Individual getIndividule(int i) {
		return this.population[i];
	}

	public void Shuffle() {
		Random ran = new Random();
		for (int i = this.population.length - 1; i > 0; i--) {
			int index = ran.nextInt(i + 1);
			Individual in = this.population[index];
			this.population[index] = this.population[i];
			this.population[i] = in;
		}
	}

	@Override
	public String toString() {
		String str="***** Population *****";
		str +="Population Size:" + population.length + "\n";
		for(int i =0;i<population.length;i++)
			str+= (population[i].toString() + "\n");
		str+="***** End *****";
		return str;

	}

}
