package Controller;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import Component.*;

import application.Main;
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
    
    @FXML
    void click(ActionEvent event) {
    	  // Create the Triangle
    	File file = new File("C:/Users/Winter Pu/Desktop/test.jpg");
    	Image image = new Image(file.toURI().toString());
    	viewImage.setImage(image);
    	WritableImage writeable_image = viewImage.snapshot(null, null);
    	
    	
    	BasePosition.setBoundaryMaxX(image.getWidth());
    	BasePosition.setBoundaryMaxY(image.getHeight());
    	
    	GenericAlgorithm ga=new GenericAlgorithm(20,0.1,0.95);
    	Population population=ga.initPopulation();
//    	ga.crossoverPopulation(population);
//    	ga.mutatePopulation(population);
//    	System.out.print(population.toString());
    	
    	Individual[] sample = population.getPopulation();
    	for(int i =0;i<population.getSize();i++) {
    		WritableImage sample_image = convertIndividual(sample[i]);
    		viewCanvas.setImage(sample_image);
    	}
    	
    	
//        GraphicsContext gc =  canvas.getGraphicsContext2D();
//        gc.setFill(Color.RED);
//        
//
//        
//        gc.fillPolygon(new double[]{Math.random()*1000, Math.random()*100, Math.random()*1000, Math.random()*1000},
//                new double[]{Math.random()*1000, Math.random()*100, Math.random()*1000, Math.random()*1000}, 4);
//   
//       
//        WritableImage wr = gc.getCanvas().snapshot(null, null);
//        PixelWriter pw = wr.getPixelWriter();
//        
//        Polygon polygon = new Polygon();
//
//        
//        viewImage.setImage(wr);
//        
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
		
		for(int x = 0 ;x <WIDTH;x++) {
			for(int y = 0;y <HEIGHT;y++) {
				int pixel_environment = pr_environment.getArgb(x, y);
				int pixel_individual = pr_individual.getArgb(x, y);
				
				 int diff_alpha =Math.abs((pixel_environment >> 24) & 0xff  -(pixel_individual >> 24) & 0xff) ;
				 int diff_red =Math.abs((pixel_environment >> 16) & 0xff  -(pixel_individual >> 16) & 0xff) ;
				 int diff_green = Math.abs((pixel_environment >> 8) & 0xff  -(pixel_individual >> 8) & 0xff) ;
				 int diff_blue =Math.abs((pixel_environment) & 0xff  - (pixel_individual) & 0xff);
				 fitness += (double)(diff_alpha + diff_red + diff_green + diff_blue);
			}
		}
		
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

}



