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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ToolTipManager;
import javax.swing.border.EmptyBorder;

import com.sun.xml.internal.ws.api.Component;

import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;

public class GuiPage2 extends JFrame implements ActionListener
{
//Make all attributes//////////////////////////////////////////////////////////////
	JFrame frame;
	
	JPanel panel1;//Main frame panels
	JPanel panel2;                   
	JPanel panel3;                   
	JPanel panel4;//Need to declare because i want to hide before its needed
	JPanel panel5;
	
	JButton homeB;//Needs declaration for action event
	JButton submitB;//Need to declare buttons so they can be accessed when making gui
	
	Font fontBig;
	Font fontBold;
	Font font;
	
	String resultsString;
	JTextArea resultTextArea;
	
	JScrollPane scroll;//https://stackoverflow.com/questions/7766844/java-jscrollpane
	 
	
	ArrayList<Patient> patientList = new ArrayList<Patient>();
//Constructor////////////////////
	public GuiPage2()//Construct
	{ 
	//MAKE and instantiate//////////
		//Make dirrectly instead of 
	    frame = new JFrame("Ryan Byrne Assignment");//The main window 
	    
	    //All the panels to go into the window
	    panel1 = new JPanel();//Main frame panels
	    panel2 = new JPanel();
	    panel3 = new JPanel();
	    panel4 = new JPanel();
	    panel5 = new JPanel();
	    
	    JPanel homeBPanel = new JPanel();//Need to make a panel for home button so it doesnt fill the grid and i can still align it
	    homeB = new JButton("Home");
	    homeB.addActionListener(this);
	    
	    String instructions = new String("Click the buttons that match your symptoms and submit:");
	    JLabel instructionsLabel  = new JLabel(instructions, SwingConstants.CENTER);//got swing constants from http://www.java2s.com/Code/Java/Swing-JFC/AsimpledemonstrationoftextalignmentinJLabels.htm
	    
	    //in panel 4//this triggers event causing other stuff to be made
	    JPanel submitPanel = new JPanel();//Panel to put submit button on so it doesnt fill the whole gridslot
	    submitB = new JButton("Submit");//Button for running findprobabilty class
	    submitB.addActionListener(this);
	    
	    resultTextArea = new JTextArea("");//got swing constants from http://www.java2s.com/Code/Java/Swing-JFC/AsimpledemonstrationoftextalignmentinJLabels.htm
		scroll = new JScrollPane(resultTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//add scrollbar to textarea
	    
	//ADD//////////
	    //
	    frame.add(panel1);//add empty panel
		frame.add(panel2);//panel with instructions
		frame.add(panel3);//panel with input grid
		frame.add(panel4);//panel with submit button, result and accuracy check
		
		homeBPanel.add(homeB);//add home button to panel so can align to top left
		panel1.add(homeBPanel);
		
		panel2.add(instructionsLabel);
		
		panel3.add(scroll);//show in gui
		//for places to put submit button
	    submitPanel.add(submitB);
		panel2.add(submitPanel);//panel that holds submit button
		
	//EDIT AND SET//////////
	    //Set layout details
	    //Frame
	    frame.setExtendedState(frame.MAXIMIZED_BOTH);//Open in fullscreen
	    frame.setSize(600,800); //default size if you exit fullscreen//1500,1200//width,height
	    frame.setMinimumSize(new Dimension(850, 1000));//Min size because gui breaks and lower
	    frame.setVisible(true); 
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Close properly
	    frame.setLayout(new GridLayout(4,1));//grid layout of rows, columns for the entire window
	    
	    //For testing
	    panel1.setBackground(Color.green);
	    panel2.setBackground(Color.blue);
	    panel3.setBackground(Color.yellow);
	    panel4.setBackground(Color.red);
	    
	  //Style changes
	    //make fonts for everything//Only set once so didnt use method
	    fontBig = new Font("Helvetica", Font.BOLD,36);//Make a font style
	    fontBold = new Font("Helvetica", Font.BOLD,26);//Make a font style
	    font = new Font("Helvetica", Font.PLAIN,26);
	    
	    // apply the font style to all
	    instructionsLabel.setFont(fontBold);
	    
	    homeB.setFont(font);
	    homeB.setFocusable(false);
	    homeB.setPreferredSize(new Dimension(120, 50));//width,height//Set the size of the button within the panel thats the full grid size
	    homeB.setBackground(new Color(220,220,220));
	    //For submit button
	    submitB.setFont(fontBold);
	    submitB.setFocusable(false);
	    submitB.setPreferredSize(new Dimension(250, 50));//row,col//Set the size of the button within the panel thats the full grid size
	    submitB.setBackground(new Color(220,220,220));
	    
		
		resultTextArea.setFont(font);//have matching font
		resultTextArea.setEditable(false);
		
		scroll.setVisible(false);
		scroll.setPreferredSize(new Dimension(800,240));
		
		resultTextArea.setFont(font);//have matching font
		resultTextArea.setEditable(false);
//        add(scroll, BorderLayout.CENTER);
        //resultTextArea.add(scroll);
		
		panel3.add(scroll);//show in gui
	}  

//Methods///////////
	public void actionPerformed(ActionEvent EV)
	{
		//Home button
		if(EV.getSource() == homeB)//get source shows what functionality triggered it
		{
			GuiHome guiHome = new GuiHome();
			frame.dispose();
		}
		if(EV.getSource() == submitB)//get source shows what functionality triggered it
		{
			//Open file to get a list from to display to user
			FileProcessor fp1 = new FileProcessor("src\\com\\assignment\\machinelearning\\TestCases.csv");
			fp1.openFile();//open just to get array from file
			patientList = fp1.readFile();//fills array list from file. make new one here instead of calling across classes//Makes with 100% of values.
			fp1.closeFile();
			
			resultsString = resultsString+("");//Empty string so only new values go in
			for(int i = 0; i < patientList.size(); i++)//add everything from list that is made form file
			{
				//MAke everything in here so it only shows once the user submits
				resultsString = resultsString+(i+1 +": "+ patientList.get(i)+"\n");//add every element to new line
				resultTextArea.setText(resultsString);//update resultTextArea which is the thing that is contained in scroll
			}
			scroll.setVisible(true);//unhide so now its visible in gui
			frame.revalidate();//update window with new information
		}
	}
	
	
}
