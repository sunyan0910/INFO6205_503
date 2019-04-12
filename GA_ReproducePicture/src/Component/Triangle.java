/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Component;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author sunyan
 */
public class Triangle extends Canvas{

    private int[] chromosome;
    
    @Override
    public void paint(Graphics g)
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
    g.setColor(new Color(x1, x2, x3,alpha));
    //TODO:put attribute into chromosome
    g.fillPolygon(new int[]{x4, x5, x6}, new int[]{x7, x8, x9}, 3);
    }

    public int[] getChromosome() {
        return chromosome;
    }
    
}
