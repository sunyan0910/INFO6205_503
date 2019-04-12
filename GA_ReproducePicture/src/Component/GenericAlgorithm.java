package Component;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sunyan
 */
public class GenericAlgorithm {
    private int populationSize;
    private double mutationRate;
    private double crossoverRate;

    public GenericAlgorithm(int populationSize, double mutationRate, double crossoverRate) {
        this.populationSize = populationSize;
        this.mutationRate = mutationRate;
        this.crossoverRate = crossoverRate;
    }
    
    public Population initPopulation(int chromosomeLen)
    {
    Population population=new Population(this.populationSize,chromosomeLen);
    return population;
    }
    
    public double calculateFitness(Individual in)
    {
    //TODO:calculate fitness
    return 0;
    }
    
    public void evalPopulation(Population population)
    {
    double populationFitness=0;
    for(Individual in:population.getPopulation())
    {
    populationFitness+=calculateFitness(in);
    }
    population.setPopulationFitness(populationFitness);
    }
    
    public boolean isTerminalConditionMet(Population population)
    {
    for(Individual in:population.getPopulation())
    {
        if(in.getFitness()==1)
            return true;
    }
    return false;
    }
    
    public Individual selectParents(Population population)
    {
    Individual individuals[]=population.getPopulation();
    double populationFitness=population.getPopulationFitness();
    double rouletteWheelPosition=Math.random()*populationFitness;
    double spinWheel=0;
    for(Individual in:individuals)
    {
    spinWheel+=in.getFitness();
    if(spinWheel>=rouletteWheelPosition)
    {
    return in;
    }
    }
    return individuals[population.getPopulationSize()-1];
    }
}
