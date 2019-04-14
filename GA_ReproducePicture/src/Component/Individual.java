/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Component;

import java.util.Random;



/**
 *
 * @author sunyan
 */
public class Individual {
    private int[] chromosome;
    private double fitness=-1;
    
    public Individual(int[] chromosome)
    {
    this.chromosome=chromosome;
    }

    public Individual() {
        this.chromosome=new int[10];
    }
    
    /*public Individual()
    {
        Random nmb=new Random();
        int x1 = nmb.nextInt(200) + 1;
        int x2 = nmb.nextInt(200) + 1;
        int x3 = nmb.nextInt(200) + 1;

        int x4 = nmb.nextInt(500) + 1;
        int x5 = nmb.nextInt(500) + 1;
        int x6 = nmb.nextInt(500) + 1;

        int x7 = nmb.nextInt(500) + 1;
        int x8 = nmb.nextInt(500) + 1;
        int x9 = nmb.nextInt(500) + 1;

        int alpha=nmb.nextInt(254);
        Triangle t=new Triangle();
        chromosome=new int[]{};
        chromosome=t.getChromosome();
    }*/

    public void setChromosome(int[] chromosome) {
        this.chromosome = chromosome;
    }
    
    public int[] getChromosome()
    {
        return this.chromosome;
    }
    
    public int getChromosomeLength()
    {
    return this.chromosome.length;
    }
    
    public int getGene(int i)
    {
    return this.chromosome[i];
    }
    
    public void setFitness(double fitness)
    {
    this.fitness=fitness;
    }
    
    public double getFitness()
    {
    return this.fitness;
    }
    
    public void printChromosome()
    {
    for(int i=0;i<this.chromosome.length;i++)
    {
    System.out.print("--"+this.chromosome[i]);
    }
    System.out.print("--");
    System.out.print("\n");
    }
}
