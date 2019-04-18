/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Component;

import java.util.Random;

public class Individual {
	private GenePolygon[] chromosome;
	private double fitness = -1;

	public Individual(int size) {
		this.chromosome = new GenePolygon[size];
	}


	public Individual(GenePolygon[] chromosome) {
		this.chromosome = chromosome;
	}

	public Individual() {
		this.chromosome = new GenePolygon[10];
		for(int i =0;i<10;i++) {
			this.chromosome[i] = new GenePolygon();
		}
	}



	public void setChromosome(GenePolygon[] chromosome) {
		this.chromosome = chromosome;
	}

	public GenePolygon[] getChromosome() {
		return this.chromosome;
	}

	public int getChromosomeLength() {
		return this.chromosome.length;
	}

	public GenePolygon getGene(int i) {
		return this.chromosome[i];
	}


	public void setGene(int index, GenePolygon gene) {
		this.chromosome[index] = gene;
	}


	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

	public double getFitness() {
		return this.fitness;
	}

	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < this.chromosome.length; i++) {
			str += this.chromosome[i].toString() + "\n";
		}
		return str;
	}


}
