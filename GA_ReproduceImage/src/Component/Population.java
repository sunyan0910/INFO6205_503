package Component;
import java.util.Arrays;
import java.util.Random;

public class Population {



	private Individual[] population;
	private double populationFitness;

	private int size;
	
	// constructor
	public Population(int size) {
		this.population = new Individual[size];
		this.size = size;
		for(int i = 0; i <size; i++) {
			population[i] = new Individual();
		}
	}


	
	/*
	 * public Population(int populationSize,int chromosomeLen) { this.population=new
	 * Individual[populationSize]; for(int i=0;i<populationSize;i++) { Individual
	 * individule=new Individual(); this.population[i]=individule; } }
	 */

	
	// population getter
	public Individual[] getPopulation() {
		return this.population;
	}

	// get the fittest individual 
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
	
	// getter and setter population fitness
	public void setPopulationFitness(double fitness) {
		this.populationFitness = fitness;
	}

	public double getPopulationFitness() {
		return this.populationFitness;
	}
	
	
	// get size
	public int getSize() {
		return this.population.length;
	}
	
	//individual getter and setter
	public Individual setIndividual(int index, Individual individual) {
		return this.population[index] = individual;
	}

	public Individual getIndividule(int i) {
		return this.population[i];
	}
	
	
	public boolean checkEquality(Population population) {
		if(this.getSize()!=population.getSize())
			return false;
		else {
			for(int i =0;i<this.getSize();i++) {
				if(this.getIndividule(i).checkEquality(population.getIndividule(i)) == false) {
					return false;
				}
			}
		}
		return true;
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
	
	
	
}
