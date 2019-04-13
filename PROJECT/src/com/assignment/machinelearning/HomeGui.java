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

import com.sun.glass.events.WindowEvent;

import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;

public class HomeGui extends JFrame implements ActionListener
{
//Make all attributes//////////////////////////////////////////////////////////////
	JFrame frame;
	JButton submitB;
//Constructor////////////////////
	public HomeGui()//Construct
	{ 
	//Make/////
		//Make dirrectly instead of 
	    frame = new JFrame("Ryan Byrne Assignment");//The main window 
	    
	    //All the panels to go into the window
	    JPanel panel1 = new JPanel();
	    JPanel panel2 = new JPanel();
	    JPanel panel3 = new JPanel();
	    JPanel panel4 = new JPanel();
	    
	    //The buttons for selecting symptoms
	    submitB = new JButton("Submit");
	    submitB.addActionListener(this);
	    
	    
	//Add/////
	    frame.add(panel1);//add panel1 to frame
		frame.add(panel2);
		frame.add(panel3);
		frame.add(panel4);
		
		panel3.add(submitB);
	    
	//Edit/////
	    //Frame
	    frame.setSize(1000,1000);  
	    frame.setVisible(true); 
	    frame.setLayout(new GridLayout(4,1));//grid layout of rows, columns 
	    frame.setLocation(200, 200);
	    
	    //Set fonts for everything//Only set once so didnt use method
	    Font fontB = new Font("Open Sans", Font.BOLD,24);//Make a font style
	    Font font = new Font("Open Sans", Font.PLAIN,24);
	    submitB.setFont(fontB);// apply the font style to all
	}  

//Methods///////////
	public void actionPerformed(ActionEvent EV)
	{
		if(EV.getSource() == submitB)//get source shows what functionality triggered it
		{
			Gui gui = new Gui();
			
				try //Eclipse told me i needed a try
				{
					Thread.sleep(200);//Just make it wait so one window doesnt close before other opens//https://stackoverflow.com/questions/31904792/java-how-to-wait-1-second-in-a-gui
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			frame.dispose();
		}
	}
}
