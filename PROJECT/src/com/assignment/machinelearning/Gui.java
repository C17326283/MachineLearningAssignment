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

	JButton submitB;
	JRadioButton b1;
	JRadioButton b2;
	JRadioButton b3;
	JRadioButton b4;
	JRadioButton b5;
	JRadioButton b6;
	JRadioButton b7;
	
//Constructor////////////////////
	public Gui()//Construct
	{ 
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
	    
	    //The buttons for selecting symptoms
	    b1 = new JRadioButton("Cold");  
	    b2 = new JRadioButton("Normal");
	    b3 = new JRadioButton("Hot");
	    b4 = new JRadioButton("Yes");  
	    b5 = new JRadioButton("No"); 
	    b6 = new JRadioButton("Yes");  
	    b7 = new JRadioButton("No"); 
	    submitB = new JButton("Submit");
	    submitB.addActionListener(this);
	    
	    //The text next to input
	    JLabel l1 = new JLabel("Temperature:  ");
	    JLabel l2 = new JLabel("Aches:  ");
	    JLabel l3 = new JLabel("Sore Throat:  ");
	    
	    //Button Group to make only one selectable
	    ButtonGroup tempGroup = new ButtonGroup();
	    ButtonGroup acheGroup = new ButtonGroup();
	    ButtonGroup throatGroup = new ButtonGroup();
	    
	//Add/////
	    frame.add(panel1);//add panel1 to frame
		frame.add(panel2);
		frame.add(panel3);
		frame.add(panel4);
		
		panel2.add(gridPanel);
		panel3.add(submitB);
		
		//Grid for inputs
		gridPanel.add(l1); gridPanel.add(b1); gridPanel.add(b2); gridPanel.add(b3);
		gridPanel.add(l2); gridPanel.add(b4); gridPanel.add(b5); gridPanel.add(fillerPanel1);
		gridPanel.add(l3); gridPanel.add(b6); gridPanel.add(b7); gridPanel.add(fillerPanel2);
		
		//Put radio buttons in group
		tempGroup.add(b1);
	    tempGroup.add(b2);
	    tempGroup.add(b3);
	    acheGroup.add(b4);
	    acheGroup.add(b5);
	    throatGroup.add(b6);
	    throatGroup.add(b7);
	    
	//Edit/////
	    //Frame
	    frame.setSize(1000,1000);  
	    frame.setVisible(true); 
	    frame.setLayout(new GridLayout(4,1));//grid layout of rows, columns 
	    
	    //Input grid settings
	    gridPanel.setLayout(new GridLayout(3,4));
	  
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
	    submitB.setFont(fontB);// apply the font style to all
	    l1.setFont(fontB);
	    l2.setFont(fontB);
	    l3.setFont(fontB);
	    b1.setFont(font);
	    b2.setFont(font);
	    b3.setFont(font);
	    b4.setFont(font);
	    b5.setFont(font);
	    b6.setFont(font);
	    b7.setFont(font);
	}  

//Methods///////////
	public void actionPerformed(ActionEvent EV)
	{
		
		if(EV.getSource() == submitB)//get source shows what functionality triggered it
		{
			String inputTemp = null;
			String inputAches = null;
			String inputSore = null;
			boolean incorrectInput = false;
			
			//Temp
			if(b1.isSelected())
			{
				inputTemp = "Cool";
			}
			else if (b2.isSelected())
			{
				inputTemp = "Normal";
			}
			else if(b3.isSelected())
			{
				inputTemp = "Hot";
			}
			else
			{
				incorrectInput = true;//If they didnt enter any value then dont run Probability check
			}
			
			//Aches
			if(b4.isSelected())
			{
				inputAches = "Yes";
			}
			else if (b5.isSelected())
			{
				inputAches = "No";
			}
			else			
			{
				incorrectInput = true;
			} 
			
			//Sore throat
			if(b6.isSelected())
			{
				inputSore = "Yes";
			}
			else if (b7.isSelected())
			{
				inputSore = "No";
			}
			else			
			{
				incorrectInput = true;
			}
			
			if(incorrectInput == false)
			{
				FindProbability c1 = new FindProbability(inputTemp, inputAches, inputSore);
				JOptionPane.showMessageDialog(this, c1);
			}
			else if(incorrectInput == true)
			{
				JOptionPane.showMessageDialog(this,"There was incorrect input, please try again.");
			}
		}
	}
}
