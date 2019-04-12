/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Component;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 *
 * @author sunyan
 */
public class Population {
    private Individual population[];
    private double populationFitness;
    
    public Population(int size)
    {
    this.population=new Individual[size];
    }
    
    public Population(int populationSize,int chromosomeLen)
    {
    this.population=new Individual[populationSize];
    for(int i=0;i<populationSize;i++)
    {
        Individual individule=new Individual();
        this.population[i]=individule;
    }
    }
    
    public Individual[] getPopulation()
    {
    return this.population;
    }
    
    public Individual getFittest(int i)
    {
    Arrays.sort(this.population, (Individual o1, Individual o2) -> {
        if(o1.getFitness()>o2.getFitness())
        {
            return -1;
        }
        else if(o1.getFitness()<o2.getFitness())
        {
            return 1;
        }
        return 0;
    });
    return this.population[i];
    }
    
    public void setPopulationFitness(double fitness)
    {
    this.populationFitness=fitness;
    }
    
    public double getPopulationFitness()
    {
    return this.populationFitness;
    }
    
    public int getPopulationSize()
    {
    return this.population.length;
    }
    
    public Individual setIndividule(int index,Individual individule)
    {
    return this.population[index]=individule;
    }
    
    public Individual getIndividule(int i)
    {
    return this.population[i];
    }
    
    public void Shuffle()
    {
    Random ran=new Random();
    for(int i=this.population.length-1;i>0;i--)
    {
    int index=ran.nextInt(i+1);
    Individual in=this.population[index];
    this.population[index]=this.population[i];
    this.population[i]=in;
    }
    }
}
