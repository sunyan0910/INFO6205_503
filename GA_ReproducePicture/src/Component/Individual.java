/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Component;



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
    
    public Individual()
    {
        Triangle t=new Triangle();
        chromosome=t.getChromosome();
    }
    
    private void swap(int[]a,int i,int j)
    {
     int temp=a[i];
     a[i]=a[j];
     a[j]=temp;
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
