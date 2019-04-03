package com.assignment.machinelearning;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;

public class Gui extends JFrame implements ActionListener
{
//Make all attributes//////////////////////////////////////////////////////////////

	
	//Constructor////////////////////
	public Gui()//Construct
	{ 
		JButton subB;
	//Make/////
		//Make dirrectly instead of 
	    JFrame frame = new JFrame("Ryan Byrne Assignment");//The main window 
	    
	    //All the panels to go into the window
	    JPanel panel1 = new JPanel();
	    JPanel panel2 = new JPanel();
	    JPanel panel3 = new JPanel();
	    JPanel panel4 = new JPanel();
	    JPanel gridPanel = new JPanel();//For grid of inputs
	    JPanel fillerPanel1 = new JPanel();
	    JPanel fillerPanel2 = new JPanel();
	    JPanel fillerPanel3 = new JPanel();
	    
	    //The buttons for selecting symptoms
	    JRadioButton b1 = new JRadioButton("Cold");  
	    JRadioButton b2 = new JRadioButton("Normal");
	    JRadioButton b3 = new JRadioButton("Hot");
	    JRadioButton b4 = new JRadioButton("Yes");  
	    JRadioButton b5 = new JRadioButton("No"); 
	    JRadioButton b6 = new JRadioButton("Yes");  
	    JRadioButton b7 = new JRadioButton("No");  
	    JRadioButton b8 = new JRadioButton("Yes");  
	    JRadioButton b9 = new JRadioButton("No");
	    subB = new JButton("Submit");
	    subB.addActionListener(this);
	    
	    //The text next to input
	    JLabel l1 = new JLabel("Temperature:  ");
	    JLabel l2 = new JLabel("Aches:  ");
	    JLabel l3 = new JLabel("Sore Throat:  ");
	    JLabel l4 = new JLabel("Tonsillitis:  ");
	    
	    //Button Group to make only one selectable
	    ButtonGroup Group1 = new ButtonGroup();
	    ButtonGroup Group2 = new ButtonGroup();
	    ButtonGroup Group3 = new ButtonGroup();
	    ButtonGroup Group4 = new ButtonGroup();
	    
	//Add/////
	    frame.add(panel1);//add panel1 to frame
		frame.add(panel2);
		frame.add(panel3);
		frame.add(panel4);
		
		panel2.add(gridPanel);
		panel3.add(subB);
		
		//Grid for inputs
		gridPanel.add(l1); gridPanel.add(b1); gridPanel.add(b2); gridPanel.add(b3);
		gridPanel.add(l2); gridPanel.add(b4); gridPanel.add(b5); gridPanel.add(fillerPanel1);
		gridPanel.add(l3); gridPanel.add(b6); gridPanel.add(b7); gridPanel.add(fillerPanel2);
		gridPanel.add(l4); gridPanel.add(b8); gridPanel.add(b9); gridPanel.add(fillerPanel3);
		
		//Put radio buttons in group
		Group1.add(b1);
	    Group1.add(b2);
	    Group1.add(b3);
	    Group2.add(b4);
	    Group2.add(b5);
	    Group3.add(b6);
	    Group3.add(b7);
	    Group4.add(b8);
	    Group4.add(b9);
	    
	//Edit/////
	    //Frame
	    frame.setSize(1000,1000);  
	    frame.setVisible(true); 
	    frame.setLayout(new GridLayout(4,1));//grid layout of rows, columns 
	    
	  //Input grid settings
	    gridPanel.setLayout(new GridLayout(4,4));
	  
	    //Panels 
	    /*
	    panel1.setBackground(Color.green);
	    panel2.setBackground(Color.blue);
	    panel3.setBackground(Color.yellow);
	    panel4.setBackground(Color.red);
	    */
	    
	    //Set fonts for everything//Only set once so didnt use method
	    Font fontB = new Font("Open Sans", Font.BOLD,24);//Make a font style
	    Font font = new Font("Open Sans", Font.PLAIN,24);
	    subB.setFont(fontB);// apply the font style to all
	    l1.setFont(fontB);
	    l2.setFont(fontB);
	    l3.setFont(fontB);
	    l4.setFont(fontB);
	    b1.setFont(font);
	    b2.setFont(font);
	    b3.setFont(font);
	    b4.setFont(font);
	    b5.setFont(font);
	    b6.setFont(font);
	    b7.setFont(font);
	    b8.setFont(font);
	    b9.setFont(font);
	}  

	//Methods///////////
	public void actionPerformed(ActionEvent anything)
	{
		if(anything.getSource() == subB)//get source shows what functionality triggered it
		{
			
			
		}
	}
}
