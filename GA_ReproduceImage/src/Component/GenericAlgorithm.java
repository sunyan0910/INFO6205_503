package Component;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class GenericAlgorithm {
	private int populationSize;
	private double mutationRate;
	private double crossoverRate;
	private int elitismCount;
	
	public GenericAlgorithm(int populationSize, double mutationRate, double crossoverRate, int chromosomeLength) {
		this.populationSize = populationSize;
		this.mutationRate = mutationRate;
		this.crossoverRate = crossoverRate;
		this.elitismCount =(int)((double)populationSize*3.0/10.0);
		Individual.setMaxGeneNum(chromosomeLength);
	}

	public Population initPopulation() {
		Population population = new Population(this.populationSize);
		return population;
	}

	public double calculateFitness(Individual in,FitnessCalculator calc) {
		// TODO:calculate fitness
		double value = calc.getFitness(in);
		in.setFitness(value);
		// need to load pixel
		return value;
	}

	public void evalPopulation(Population population,FitnessCalculator calc) {
		double populationFitness = 0;
		for (Individual in : population.getPopulation()) {
			populationFitness += calculateFitness(in,calc);
		}
		population.setPopulationFitness(populationFitness);
	}

	
	public boolean isTerminalConditionMet(Population population) {
		for (Individual in : population.getPopulation()) {
			if (in.getFitness() == 1)
				return true;
		}
		return false;
	}
	
	 
	public Population crossoverPopulation(Population population) {
		
		// Create new population
		Population newPopulation = new Population(population.getSize());
		
		// Loop over current population by fitness
		for (int populationIndex = 0; populationIndex< population.getSize();populationIndex++) {
		Individual parent1 = population.getFittest(0);
		// Apply crossover to this individual?
		if (this.crossoverRate > Math.random() && populationIndex > this.elitismCount) {
		
		// Initialize offspring
		Individual offspring = new Individual(parent1.getChromosomeLength());
		
		// Find second parent
		Individual parent2 = selectParent(population);

		System.out.println(populationIndex + "crossover" + population.getIndividule(populationIndex).getFitness());
		// gene length 
		int crossover_length = Math.min( parent1.getChromosomeLength(),  parent2.getChromosomeLength());
		
		// Loop over genome
		for (int geneIndex = 0; geneIndex <crossover_length; geneIndex++) {
			// Use 70% of parent1's genes and 30% of parent2's genes
			
			if (0.7 > Math.random()) {
				offspring.setGene(geneIndex, parent1.getGene(geneIndex));
			} else {
				offspring.setGene(geneIndex, parent2.getGene(geneIndex));
			}
		}
		// Add offspring to new population
				newPopulation.setIndividual(populationIndex, offspring);
		} else {
				// Add individual to new population without applying crossover
				newPopulation.setIndividual(populationIndex, parent1);
			}
		}
		
		return newPopulation;
	}
	
	
	
	public Population mutatePopulation(Population population) {
		// Initialize new population
		Population newPopulation = new Population(population.getSize());
		// Loop over current population by fitness
		for (int populationIndex = 0; populationIndex < population.getSize(); populationIndex++) {
			Individual individual = population.getFittest(populationIndex);
			// Loop over individual's genes
			for (int geneIndex = 0; geneIndex < individual.getChromosomeLength(); geneIndex++) {
				// Skip mutation if this is an elite individual
				if (populationIndex >= this.elitismCount) {

					// Does this gene need mutation?
					if (this.mutationRate > Math.random()) {
						GenePolygon newGene = new GenePolygon();
						GenePolygon currentGene = individual.getGene(geneIndex);
						while(newGene.checkEquality(currentGene)) {
							newGene = new GenePolygon();
						}
						individual.setGene(geneIndex, newGene);
					}
				}
			}
			// Add individual to population
			newPopulation.setIndividual(populationIndex, individual);
		}
		// Return mutated population
		return newPopulation;
	}

	
	public Individual selectParent(Population population) {
		Individual individuals[] = population.getPopulation();
		double populationFitness = population.getPopulationFitness();
		double rouletteWheelPosition = Math.random() * populationFitness;
		double spinWheel = 0;
		for (Individual in : individuals) {
			spinWheel += in.getFitness();
			if (spinWheel >= rouletteWheelPosition) {
				return in;
			}
		}
		return individuals[population.getSize() - 1];
	}
}
