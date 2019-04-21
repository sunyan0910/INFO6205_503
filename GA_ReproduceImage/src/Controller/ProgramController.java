package Controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import Component.*;

import application.Main;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;

public class ProgramController implements DiffCalculator<WritableImage,Individual>{

    @FXML
    private ImageView viewImage;

    @FXML
    private Button button;

    @FXML
    private ImageView viewCanvas;

    private Main app;
    
    private WritableImage viewIndividual;
    private double currentFitnees;
    @FXML
    void click(ActionEvent event) {
    	  // Create the Triangle
//    	File file = new File("C:/Users/XXX/Desktop/test.jpg");
    	Image image = new Image("file:assets/test.jpg");

    	viewImage.setImage(image);
    	WritableImage writeable_image = viewImage.snapshot(null, null);
    	
    	
    	BasePosition.setBoundaryMaxX(image.getWidth());
    	BasePosition.setBoundaryMaxY(image.getHeight());
    	
    	// ProgramController  is  a  Diff_Calculator;
    	FitnessCalculator calc = new FitnessCalculator(writeable_image,this);
    	
    	
    	//int generation = 0;
    	List<Population> population_list= new ArrayList<Population>();
    	
    	GenericAlgorithm ga=new GenericAlgorithm(20,0.7,0.3,100);
    	Population population=ga.initPopulation();
    	
    	population_list.add(population);
    	ga.evalPopulation(population_list.get(0), calc);
    	
    	System.out.println("OK");
    	
    	
    	ScheduledExecutorService scheduledExecutorService;
    	scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            // Update the chart
            Platform.runLater(() -> {
//            	while(ga.isTerminalConditionMet(population_list.get(population_list.size()-1)) == false) {
            		int generation = population_list.size()-1;
	            	System.out.println((generation) + "generation");
					Population next_population = population_list.get(generation);
					next_population = ga.crossoverPopulation(next_population);
					next_population = ga.mutatePopulation(next_population);
			    	ga.evalPopulation(next_population, calc);
			    	population_list.add(next_population);
			    	
			    	Individual fittest_individual = next_population.getFittest(0);
			    
			    	// test check info
			    	System.out.println(fittest_individual.getFitness());
			    	Individual check = population.getFittest(0);
			    	System.out.println(check.checkEquality(fittest_individual));
			    	
			    	
			    	System.out.println("===========");
		 	    	WritableImage sample_image = convertIndividual(fittest_individual);
		 	    	this.setImage(sample_image);
		 	    	viewCanvas.setImage(this.viewIndividual);
//            	}
            });
        }, 0, 1, TimeUnit.SECONDS);
  
    	

       
    }

    
    public void setMainApp(Main app) {
    	this.app = app;
    }


	@Override
	public double calcFitness(WritableImage environment, WritableImage individual) {
		// TODO Auto-generated method stub
		//check boundary
		PixelReader pr_environment = environment.getPixelReader();
		PixelReader pr_individual = individual.getPixelReader();
		final double HEIGHT = environment.getHeight();
		final double WIDTH = environment.getWidth();
		
		double fitness = 0;
		double fitness_rgb = 0;
		double fitness_alpha = 0;
		
		for(int x = 0 ;x <WIDTH;x++) {
			for(int y = 0;y <HEIGHT;y++) {
				int pixel_environment = pr_environment.getArgb(x, y);
				int pixel_individual = pr_individual.getArgb(x, y);
				
				 int diff_alpha =Math.abs((pixel_environment >> 24) & 0xff  -(pixel_individual >> 24) & 0xff) ;
				 int diff_red =Math.abs((pixel_environment >> 16) & 0xff  -(pixel_individual >> 16) & 0xff) ;
				 int diff_green = Math.abs((pixel_environment >> 8) & 0xff  -(pixel_individual >> 8) & 0xff) ;
				 int diff_blue =Math.abs((pixel_environment) & 0xff  - (pixel_individual) & 0xff);
				 fitness_rgb += (double)(diff_red+ diff_green + diff_blue);
				 fitness_alpha +=(double) diff_alpha;
				 
			}
		}
		
//		fitness = 2 - fitness_rgb/(255.0*3*HEIGHT*WIDTH) - fitness_alpha/(255.0*HEIGHT*WIDTH);
		fitness  = 1 - fitness_rgb/(255.0*3*HEIGHT*WIDTH);
		return fitness;
	}


	@Override
	public WritableImage convertIndividual(Individual individual) {
		// TODO Auto-generated method stub
		GenePolygon[] gene_list = individual.getChromosome();
		//get position
		Canvas canvas = new Canvas(BasePosition.getBoundaryMaxX(),BasePosition.getBoundaryMaxY());
		GraphicsContext gc = canvas.getGraphicsContext2D();
		//draw on the canvas
		for(int i = 0; i <gene_list.length;i++) {
			BaseColor base_color = gene_list[i].getColor();
			Color color =new Color(base_color.getR(),base_color.getG(),base_color.getB(),base_color.getA());
			gc.setFill(color);
			
			BasePosition[] position = gene_list[i].getPosition();
			
			double[] position_x = new double[position.length];
			double[] position_y = new double[position.length];
			for(int j = 0;j< position.length;j++) {
				position_x[j] = position[j].getX();
				position_y[j] = position[j].getY();
			}
	
			gc.fillPolygon(position_x,position_y,position.length);
			
		}
		// return image 
		return canvas.snapshot(null, null);
	}

	
	public void setImage(WritableImage img) {
		 this.viewIndividual = img;
	}
	public void setFitness(double value) {
		this.currentFitnees = value;
	}
}



