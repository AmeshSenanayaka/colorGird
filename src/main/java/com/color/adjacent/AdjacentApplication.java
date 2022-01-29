package com.color.adjacent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.awt.*;

@SpringBootApplication
public class AdjacentApplication  extends javax.swing.JFrame {

	public static void main(String[] args) {
		SpringApplication.run(AdjacentApplication.class, args);

		MyComponent myComponent = new MyComponent();
		JFrame frame = new JFrame("Hello World");


		frame.add(myComponent,BorderLayout.CENTER);
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		Color[][] gridColors  = myComponent.gridColors;

		ColorFinder colorFinder = new ColorFinder();
		colorFinder.findMaxAdjacentSameColor(gridColors);



	}


}
