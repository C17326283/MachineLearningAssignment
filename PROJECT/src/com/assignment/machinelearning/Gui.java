package com.assignment.machinelearning;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;

public class Gui extends JFrame implements ActionListener
{
//Make all attributes//////////////////////////////////////////////////////////////
	JFrame frame; 
	
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private static JTextField text1;
	private static JTextField text2;
	private static JTextField text3;
	
	//Constructor////////////////////
	public Gui()//Construct
	{ 
		//Make/////
	    JFrame frame = new JFrame();  
	    
	    JPanel panel1 = new JPanel();
	    JPanel panel2 = new JPanel();
	    JPanel panel3 = new JPanel();
	    JPanel panel4 = new JPanel();
	      
	    JButton b1=new JButton("1");  
	    JButton b2=new JButton("2");  
	    JButton b3=new JButton("3");  
	    JButton b4=new JButton("4"); 
	    
	    //Add/////
	    frame.add(panel1);
		frame.add(panel2);
		frame.add(panel3);
		frame.add(panel4);
	          
	    panel1.add(b1);
	    panel1.add(b2);
	    panel1.add(b3);
	    panel1.add(b4);
	  
	    //Edit/////
	    //Frame
	    frame.setSize(1000,1000);  
	    frame.setVisible(true); 
	    frame.setLayout(new GridLayout(4,1));//grid layout of rows, columns  
	  
	    //Panels
	    panel1.setBackground(Color.green);
	    panel1.setLayout(new GridLayout(3,3));
	    
		b1.setPreferredSize(new Dimension(100,100));
		
		
	    panel2.setBackground(Color.blue);
	    panel3.setBackground(Color.yellow);
	    panel4.setBackground(Color.red);
	    
	    //Other
	    frame.setSize(1000,1000);  
	    frame.setVisible(true);  
	}  

	//Methods///////////
	public void actionPerformed(ActionEvent EV)
	{
		
	}
///////////////////////////////////////////////////////////////////////////////////////
}
