/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Component;

import java.util.Random;

public class Individual {
	private static int max_num_gene = 1500;
	private GenePolygon[] chromosome;
	private double fitness = -1;

	
	//constructor
	public Individual(int size) {
		this.chromosome = new GenePolygon[size];
		for(int i =0;i<size;i++) {
			chromosome[i] = new GenePolygon();
		}
	}
	
	public Individual(GenePolygon[] chromosome) {
		this.chromosome = chromosome;
	}

	public Individual() {
		Random random = new Random();
		int num_gene = random.nextInt(max_num_gene)+5;
		this.chromosome = new GenePolygon[num_gene];
		for(int i =0;i<num_gene;i++) {
			chromosome[i] = new GenePolygon();
		}
	}
	
	public  static void setMaxGeneNum(int value) {
		max_num_gene = value;
	}
	public boolean checkEquality(Individual other) {
		if(this.getChromosomeLength() != other.getChromosomeLength())
			return false;
		else {
			for(int i =0 ;i<this.getChromosomeLength(); i++) {
				if (this.getGene(i).checkEquality(other.getGene(i)) == false)
					return false;
			}
		}
		
		return true;
	}
	
	//getter and setter chromosome
	public void setChromosome(GenePolygon[] chromosome) {
		this.chromosome = chromosome;
	}

	public GenePolygon[] getChromosome() {
		return this.chromosome;
	}

	public int getChromosomeLength() {
		return this.chromosome.length;
	}
	
	
	// getter and setter gene
	public GenePolygon getGene(int i) {
		return this.chromosome[i];
	}

	
	public void setGene(int index, GenePolygon gene) {
		this.chromosome[index] = gene;
	}
	
	
	// getter and setter fitness
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

	public double getFitness() {
		return this.fitness;
	}

	public void printChromosome() {
		for (int i = 0; i < this.chromosome.length; i++) {
			System.out.print("--" + this.chromosome[i]);
		}
		System.out.print("--");
		System.out.print("\n");
	}
	

}
