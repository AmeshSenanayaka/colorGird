package com.color.adjacent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.Map.Entry;

@SpringBootApplication
public class AdjacentApplication  extends javax.swing.JFrame {


	private static int  row = 5;
	private static int col = 5;

	public static void main(String[] args) {
		SpringApplication.run(AdjacentApplication.class, args);

		MyComponent myComponent = new MyComponent();
		JFrame frame = new JFrame("Hello Grid");


		frame.add(myComponent,BorderLayout.CENTER);
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		Node[][] gridColors  = myComponent.getGridNodes();

		ColorFinder colorFinder = new ColorFinder();
		Map<String,Integer> results = colorFinder.findBlockColors(gridColors);

		int maxBlockCount = 0;
		String maxBlock = "";
		for (Entry<String, Integer> entry : results.entrySet()) {
			
			if(maxBlockCount < entry.getValue()) {
				maxBlockCount = entry.getValue();
				maxBlock = entry.getKey();
			}
		}

		System.out.println("maxBlockCount : " + maxBlockCount + "  ::::: maxBlock : " + maxBlock);

	}

	public static int getRow() {
		return row;
	}

	public static void setRow(int row) {
		AdjacentApplication.row = row;
	}

	public static int getCol() {
		return col;
	}

	public static void setCol(int col) {
		AdjacentApplication.col = col;
	}
}
