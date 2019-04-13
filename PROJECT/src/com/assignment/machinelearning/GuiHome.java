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
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sun.prism.Image;

import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;

public class GuiHome extends JFrame implements ActionListener
{
	JFrame frame;//These are the attributes that will need to be called
	JButton guiSymptomsButton;
	JButton page2Button;
	{
    
	//Make 
	    //frame
	    frame = new JFrame("BoxLayout Test");
	    frame.setLayout(new GridLayout(5,1));//grid layout of rows, columns //5 tall,1 wide
	    
	    //layouts
	    JPanel menuPanel = new JPanel();
	    JPanel fillerPanel1 = new JPanel();//For empty spaces at top and bottom of page
	    JPanel fillerPanel2 = new JPanel();
	    
	    JPanel buttonPanel1 = new JPanel();
	    JPanel buttonPanel2 = new JPanel();
	    
	    guiSymptomsButton = new JButton("Enter Symptoms");
	    guiSymptomsButton.addActionListener(this);
	    page2Button = new JButton("Other page");
	    page2Button.addActionListener(this);
	    
	    JLabel programName = new JLabel("Symptom Checker");
	    ImageIcon logoImage = new ImageIcon("images\\logo.png"); //Get image from file
	    JLabel logo = new JLabel(logoImage); //Make image into label so it can be placed
	    
	    
	//Add
	    frame.add(fillerPanel1);
	    frame.add(logo);
	    frame.add(programName);
	    frame.add(menuPanel);
	    frame.add(fillerPanel2);
	    
	    buttonPanel1.add(guiSymptomsButton);//Need to add to Panels to size correctly
	    buttonPanel2.add(page2Button);
	    
	    menuPanel.setLayout(new GridLayout(2,1));//grid layout of rows, columns //5 tall,1 wide
	    menuPanel.add(buttonPanel1);
	    menuPanel.add(buttonPanel2);
	    
	    
	//Edit
	    ////layouts
	    frame.setVisible(true);
	    frame.setSize(1000,1000); 
	    frame.setExtendedState(frame.MAXIMIZED_BOTH);//Open in fullscreen
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Close properly
	    frame.setLayout(new GridLayout(5,1));//grid layout of rows, columns //5 tall,1 wide
	    
	    menuPanel.setLayout(new GridLayout(2,1));//grid layout of rows, columns //2 tall,1 wide
	    

	    //Make fonts to use
	    Font largeFont = new Font("Helvetica", Font.BOLD,60);
	    Font smallFont = new Font("Helvetica", Font.PLAIN,30);
	    //Set styles
	    programName.setFont(largeFont);
	    programName.setPreferredSize(new Dimension(150, 100));
	    programName.setHorizontalAlignment(JLabel.CENTER);
	    
	    
	    guiSymptomsButton.setFont(smallFont);
	    guiSymptomsButton.setPreferredSize(new Dimension(300, 80));//row,col//Set the size of the button within the panel thats the full grid size
	    
	    page2Button.setFont(smallFont);
	    page2Button.setPreferredSize(new Dimension(300, 80));//row,col//Set the size of the button within the panel thats the full grid size
		
	}

	public void actionPerformed(ActionEvent EV)
	{
		if(EV.getSource() == guiSymptomsButton)//get source shows what functionality triggered it
		{
			GuiSymptoms gui2 = new GuiSymptoms();
			frame.dispose();
		}
		if(EV.getSource() == page2Button)//get source shows what functionality triggered it
		{
			GuiPage2 gui2 = new GuiPage2();
			frame.dispose();
		}
		
	}
}