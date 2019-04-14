package com.assignment.machinelearning;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;

public class GuiHome extends JFrame implements ActionListener
{
	JFrame frame;//These are the attributes that will need to be called
	JButton guiSymptomsButton;
	JButton page2Button;
	{
    
		System.out.println(Control.getChosenFile());
	//Make 
	    //frame
	    frame = new JFrame("BoxLayout Test");
	    frame.setLayout(new GridLayout(5,1));//grid layout of rows, columns //5 tall,1 wide
	    
	    //layouts
	    JPanel menuPanel = new JPanel();//The panels that go onto the main frame in the grid spaces
	    JPanel fillerPanel1 = new JPanel();//For empty spaces at top and bottom of page
	    JPanel fillerPanel2 = new JPanel();
	    
	    JPanel buttonPanel1 = new JPanel();//Button panels so the buttons dont fill a full grid space
	    JPanel buttonPanel2 = new JPanel();
	    
	    guiSymptomsButton = new JButton("Enter Symptoms");//Go to respective guis
	    guiSymptomsButton.addActionListener(this);
	    page2Button = new JButton("Other page");
	    page2Button.addActionListener(this);
	    
	    JLabel programName = new JLabel("Tonsillitis Checker");//The big name thats displayed
	    ImageIcon logoImage = new ImageIcon("images\\logo.png"); //Get image from file
	    JLabel logo = new JLabel(logoImage); //Make image into label so it can be placed
	    
	//Add
	    frame.add(fillerPanel1);//add all the components to the main page in each of the grid spaces top to bottom
	    frame.add(logo);
	    frame.add(programName);
	    frame.add(menuPanel);
	    frame.add(fillerPanel2);
	    
	    buttonPanel1.add(guiSymptomsButton);//Need to add to Panels to size correctly
	    buttonPanel2.add(page2Button);
	    
	    menuPanel.setLayout(new GridLayout(2,1));//grid layout of rows, columns //5 tall,1 wide
	    menuPanel.add(buttonPanel1);//add each panel that contains a button to the menu panel thats has buttons to go to the next pages
	    menuPanel.add(buttonPanel2);
	    
	//Edit
	    ////layouts
	    frame.setVisible(true);
	    frame.setSize(1000,1000); 
	    frame.setExtendedState(frame.MAXIMIZED_BOTH);//Open in fullscreen
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Close properly
	    frame.setLayout(new GridLayout(5,1));//grid layout of rows, columns //5 tall,1 wide
	    frame.setMinimumSize(new Dimension(600, 1100));//Min size because gui breaks and lower
	    
	    menuPanel.setLayout(new GridLayout(2,1));//grid layout of rows, columns //2 tall,1 wide

	    //Make fonts to use
	    Font largeFont = new Font("Helvetica", Font.BOLD,60);
	    Font smallFont = new Font("Helvetica", Font.PLAIN,36);
	    //Set styles
	    programName.setFont(largeFont);
	    programName.setPreferredSize(new Dimension(150, 100));
	    programName.setHorizontalAlignment(JLabel.CENTER);
	    
	    guiSymptomsButton.setFont(smallFont);
	    guiSymptomsButton.setPreferredSize(new Dimension(350, 70));//row,col//Set the size of the button within the panel thats the full grid size
	    guiSymptomsButton.setBackground(new Color(220,220,220));//Change color of box background to light grey//the named one wasnt light enough
	    guiSymptomsButton.setFocusable(false);//remove blue square for selecting
	    
	    page2Button.setFont(smallFont);
	    page2Button.setPreferredSize(new Dimension(350, 70));//row,col//Set the size of the button within the panel thats the full grid size
	    page2Button.setBackground(new Color(220,220,220));
	    page2Button.setFocusable(false);//remove blue square for selecting
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
			GuiFile gui2 = new GuiFile();
			frame.dispose();
		}
		
	}
}