package com.color.adjacent;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/* ==============================================================
 *  Author :Amesh Senanayaka
 *  Date   : 29/01/2022 - 16:01 PM
 *  Description :Random Color Generator
 * ==============================================================
 **/
public class MyComponent extends JPanel {

    private final  Node[][] gridNodes = new Node[AdjacentApplication.getRow()][AdjacentApplication.getCol()];

    public MyComponent() {

    	for(int y =0;y<AdjacentApplication.getRow() ;y++){

            for(int x=0;x<AdjacentApplication.getCol();x++){
            	Color color = randomColor();
                gridNodes[y][x]=new Node(x,y,color);
           }
    	}
    }

    public Node[][] getGridNodes() {
		return gridNodes;
	}


	/*
     * Create Random Color
     */
    private Color randomColor() {

        int[] intArray = {255, 0 , 100};

        int idx = new Random().nextInt(intArray.length);
        
        
        return new Color(intArray[idx], intArray[idx], intArray[idx]);
    }

    /*
     * Create Gird View
     */
    @Override
    protected void paintComponent(Graphics g) {
          super.paintComponent(g);
           for(int y =0;y<AdjacentApplication.getRow();y++){
                for(int x=0;x<AdjacentApplication.getCol();x++){
                	Color color = gridNodes[y][x].getColor();
                    g.setColor(color);
                    g.fillRect(50*x, 50*y, 50, 50);
                }

        }


    }



}
