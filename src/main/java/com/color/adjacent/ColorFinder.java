package com.color.adjacent;

import java.awt.*;
import java.util.*;


/* ==============================================================
 *  Author :Amesh Senanayaka
 *  Date   : 29/01/2022 - 19:01 PM
 *  Description :Color Counter
 * ==============================================================
 **/
public class ColorFinder {

    public Map<Color,Integer>  findMaxAdjacentSameColor(Color[][] gridColors){

        Map<Color,Integer> colorCountMap = new HashMap<>();



        for(int row=0;row<5;row++){

            int adjacentColor =0;
            Color thisColor =null;
            Color preCellColor =null;
            for(int col =0;col<5;col++){
                thisColor = gridColors[row][col];
                if(preCellColor.equals(thisColor)) {
                    adjacentColor = adjacentColor + 1;
                }else{
                    adjacentColor =0;
                }

                //up to
                for(int nextRow=row+1;nextRow<5;row++){
                    Color downColor = gridColors[nextRow][col];
                    if(!downColor.equals(thisColor))
                        break;


                    adjacentColor =adjacentColor+1;

                    for(int preCol =col-1;preCol>0;preCol--){
                        Color preColor = gridColors[nextRow][preCol];
                        if(!preColor.equals(thisColor))
                            break;

                        adjacentColor =adjacentColor+1;
                    }

                    for(int nextCol =col+1;nextCol<5;nextCol++){
                        Color nextColor = gridColors[nextRow][nextCol];
                        if(!nextColor.equals(thisColor))
                            break;

                        adjacentColor =adjacentColor+1;
                    }


                }

                preCellColor = thisColor;




        }

            int  count = colorCountMap.get(thisColor)!=null?colorCountMap.get(thisColor):0;
            if(count<adjacentColor)
                colorCountMap.put(thisColor,adjacentColor);

    }



      return colorCountMap;

    }

}
