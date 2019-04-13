package com.assignment.machinelearning;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
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
import java.awt.Component;

public class GuiPage2 extends JFrame implements ActionListener
{
//Make all attributes//////////////////////////////////////////////////////////////
	JFrame frame;
	JButton page1Button;
	JButton page2Button;
//Constructor////////////////////
	public GuiPage2()//Construct
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
	    page1Button = new JButton("Page 1");
	    page1Button.addActionListener(this);
	    page2Button = new JButton("Page 1");
	    page2Button.addActionListener(this);
	    
	    
	    ImageIcon logoImage = new ImageIcon("images\\testimg.PNG"); 
	    JLabel logo = new JLabel(logoImage); 

	    panel2.add(logo);
	    
	//Add/////
	    frame.add(panel1);//add panel1 to frame
		frame.add(panel2);
		frame.add(panel3);
		frame.add(panel4);
		
		panel3.add(page1Button);
		panel3.add(page2Button);
		
		JButton testb1 = new JButton("Button 1");
	    JButton testb2 = new JButton("2");
	    JButton testb3 = new JButton("This is button three");
	    testb1.setAlignmentX(Component.CENTER_ALIGNMENT);
	    
		panel4.setLayout(new BoxLayout(panel4, BoxLayout.Y_AXIS));
		panel4.add(testb1);
		panel4.add(testb2);
		panel4.add(testb3);
		
	    
	//Edit/////
	    //Frame
	    frame.setSize(1000,1000);  
	    frame.setVisible(true); 
	    frame.setLayout(new GridLayout(4,1));//grid layout of rows, columns 
	    frame.setExtendedState(frame.MAXIMIZED_BOTH);//Open in fullscreen
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Close properly
	    
	    //Set fonts for everything//Only set once so didnt use method
	    Font fontB = new Font("Open Sans", Font.BOLD,24);//Make a font style
	    Font font = new Font("Open Sans", Font.PLAIN,24);
	    page1Button.setFont(fontB);// apply the font style to all
	}  

//Methods///////////
	public void actionPerformed(ActionEvent EV)
	{
		if(EV.getSource() == page1Button)//get source shows what functionality triggered it
		{
			GuiSymptoms gui = new GuiSymptoms();
			
			frame.dispose();
		}
		if(EV.getSource() == page2Button)//get source shows what functionality triggered it
		{
			GuiHome gui2 = new GuiHome();
			frame.dispose();
		}
	}
}
