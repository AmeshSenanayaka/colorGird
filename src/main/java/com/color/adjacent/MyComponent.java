package com.color.adjacent;

import javax.swing.*;
import java.awt.*;

/* ==============================================================
 *  Author :Amesh Senanayaka
 *  Date   : 29/01/2022 - 16:01 PM
 *  Description :Random Color Generator
 * ==============================================================
 **/
public class MyComponent extends JPanel {

    private int row = 5;
    private int col = 5;
    public final Color[][] gridColors = randomGridColors(row, col);

    /*
     * Create 2d Color Array
     */
    private Color[][] randomGridColors(int rows, int columns) {
        Color[][] gridColors = new Color[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                gridColors [i][j] = randomColor();
            }
        }
        return gridColors;
    }

    /*
     * Create Random Color
     */
    private Color randomColor() {
        int rgbValue = (int) (Math.random() * 256);
        return new Color(rgbValue, rgbValue, rgbValue);
    }

    /*
     * Create Gird View
     */
    @Override
    protected void paintComponent(Graphics g) {
          super.paintComponent(g);

           for(int x =0;x<5;x++){
                for(int y=0;y<5;y++){
                    g.setColor(gridColors[y][x]);
                    g.fillRect(50*x, 50*y, 50, 50);

                }

        }


    }



}
