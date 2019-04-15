/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ReproducePicture;

import Component.*;

import java.awt.Canvas;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author sunyan
 */
public class ReproducePitureAlgorithm {
    
    
   

    public static void main(String[] args)
    {
//	    GenericAlgorithm ga=new GenericAlgorithm(200,0.1,0.95);
//	    Population population=ga.initPopulation();
//	    JFrame win = new JFrame("Picture");
//	        win.setSize(600,800);
//	        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	        JLabel label=new JLabel();
//	        label.setSize(184, 274);
//	        label.setLocation(250, 0);
//	        Icon icon=new ImageIcon("/Users/sunyan/Desktop/pic.png");
//	        label.setIcon(icon);
//	        win.add(label);
//	        win.add(population);
//	        
//	        win.setVisible(true);
    	
//    	Canvas cnvs = new Canvas();
//        cnvs.setSize(400, 400);
//        Graphics g = cnvs.getGraphics();
//        
//    	Painter painter = new Painter();
//    	painter.paint(g);


    	
    	GenericAlgorithm ga=new GenericAlgorithm(20,0.1,0.95);
    	Population population=ga.initPopulation();
    	ga.crossoverPopulation(population);
    	ga.mutatePopulation(population);
    
    	System.out.print(population.toString());
    	
    //for(Individual indi:population.getPopulation())
    //{
    //indi.printChromosome();
    //}
    //ga.evalPopulation(population);
    //int generation=1;
    
    /*while(!ga.isTerminalConditionMet(population))
    {
    //System.out.println("Best solution:");
    //population.getFittest(0).printChromosome();
    //TODO:crossover
    
    //TODO:mutation
    
    ga.evalPopulation(population);
    generation++;
    }*/
    //System.out.println("Found solution in "+generation+" generation");
    //System.out.println("Best solution:");
    //population.getFittest(0).printChromosome();
    }
}
