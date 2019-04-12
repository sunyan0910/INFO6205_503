/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReproducePicture;

import Component.GenericAlgorithm;
import Component.Individual;
import Component.Population;
import java.util.Scanner;

/**
 *
 * @author sunyan
 */
public class ReproducePitureAlgorithm {
    
    static int num=10;
    static void printBoard(int[][] board)
    {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board.length;j++)
            {
                if(board[i][j]==1)
                {
                    System.out.print("Q\t");
                }
                else
                {
                    System.out.print("_\t");
                }
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args)
    {
    GenericAlgorithm ga=new GenericAlgorithm(100,0.1,0.95);
    Population population=ga.initPopulation(4);
    //for(Individual indi:population.getPopulation())
    //{
    //indi.printChromosome();
    //}
    ga.evalPopulation(population);
    int generation=1;
    
    while(!ga.isTerminalConditionMet(population))
    {
    //System.out.println("Best solution:");
    //population.getFittest(0).printChromosome();
    //TODO:crossover
    
    //TODO:mutation
    
    ga.evalPopulation(population);
    generation++;
    }
    //System.out.println("Found solution in "+generation+" generation");
    //System.out.println("Best solution:");
    population.getFittest(0).printChromosome();
    }
}
