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
import javax.swing.SwingConstants;
import javax.swing.ToolTipManager;
import javax.swing.border.EmptyBorder;

import com.sun.xml.internal.ws.api.Component;

import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;

public class GuiSymptoms extends JFrame implements ActionListener
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
	JRadioButton tempCoolB;
	JRadioButton tempNormalB;
	JRadioButton tempHotB;
	JRadioButton achesYesB;
	JRadioButton achesNoB;
	JRadioButton soreYesB;
	JRadioButton soreNoB;
	
	String resultsString;
	JLabel resultsLabel;
	
	JPanel accuracyPanel;//will contain accuracy label and accuracy BarPanel
	String accuracyString;//string containing accuracy
	JLabel accuracyLabel;//label containing string
	JPanel accuracyBarPanel;//contains pb
	JProgressBar pb;//filled later
	
	Font fontBig;
	Font fontBold;
	Font font;
//Constructor////////////////////
	public GuiSymptoms()//Construct
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
	    
	    JPanel optionsSection  = new JPanel();
	    //all in options section in panel 3
	    JPanel gridTextPanel = new JPanel();
	    JPanel gridInfoPanel = new JPanel();
	    JPanel gridInputPanel = new JPanel();//For grid of inputs
	    
	    JPanel fillerPanel1 = new JPanel();//to fill the spaces to make the input grid look right
	    JPanel fillerPanel2 = new JPanel();
	    
	    //The buttons for selecting symptoms
	    tempCoolB = new JRadioButton("Cool ");  
	    tempNormalB = new JRadioButton("Normal  ");
	    tempHotB = new JRadioButton("Hot ");
	    achesYesB = new JRadioButton("Yes ");  
	    achesNoB = new JRadioButton("No "); 
	    soreYesB = new JRadioButton("Yes ");  
	    soreNoB = new JRadioButton("No "); 
	    
	    //in panel 4//this triggers event causing other stuff to be made
	    JPanel submitPanel = new JPanel();//Panel to put submit button on so it doesnt fill the whole gridslot
	    submitB = new JButton("Submit");//Button for running findprobabilty class
	    submitB.addActionListener(this);
	    
	    //in panel 5//Thses will all be used after action event
	    accuracyPanel = new JPanel();//initialise panel
	    accuracyLabel = new JLabel();//initialise panel
	    accuracyBarPanel = new JPanel();//for holding the accuracy bar
	    pb = new JProgressBar(0,100);//make a progress bar from 0 to 100//dont add to anything untill submit//filled later
	    
	    
	    //The buttons for selecting symptoms
	    tempCoolB = new JRadioButton("Cool ");  
	    tempNormalB = new JRadioButton("Normal  ");
	    tempHotB = new JRadioButton("Hot ");
	    achesYesB = new JRadioButton("Yes ");  
	    achesNoB = new JRadioButton("No "); 
	    soreYesB = new JRadioButton("Yes ");  
	    soreNoB = new JRadioButton("No "); 
	    
	    submitB = new JButton("Submit");//Button for running findprobabilty class
	    submitB.addActionListener(this);
	    
	    
	    //The text beside input
	    JLabel l1 = new JLabel("Temperature: ");
	    JLabel l2 = new JLabel("Aches: ");
	    JLabel l3 = new JLabel("Sore Throat: ");
	    
	    //Button Group to make only one selectable
	    ButtonGroup tempGroup = new ButtonGroup();
	    ButtonGroup acheGroup = new ButtonGroup();
	    ButtonGroup throatGroup = new ButtonGroup();
	    
	    //for adding tooltip icons
	    ImageIcon infoIcon = new ImageIcon("images\\infoIcon.png"); //Get image from file
	    JLabel tempInfo = new JLabel(infoIcon);
	    JLabel achesInfo = new JLabel(infoIcon);
	    JLabel soreInfo = new JLabel(infoIcon);
	    
	    String tempTipText = "Normal body temperature is around ranges from 36.1°C (97°F) to 37.2°C (99°F).\n If you are above this range then select hot and if you are below select cool.";
	    String achesTipText = "A continuous or dull pain, such as backache, throbbing, headache & toothache.";
	    String soreTipText = "Pain, scratchiness or irritation in the throat.";
	    
	    resultsLabel = new JLabel("", SwingConstants.CENTER);//got swing constants from http://www.java2s.com/Code/Java/Swing-JFC/AsimpledemonstrationoftextalignmentinJLabels.htm
	    
	//ADD//////////
	    //
	    frame.add(panel1);//add empty panel
		frame.add(panel2);//panel with instructions
		frame.add(panel3);//panel with input grid
		frame.add(panel4);//panel with submit button, result and accuracy check
		frame.add(panel5);//empty panel
		
		homeBPanel.add(homeB);//add home button to panel so can align to top left
		panel1.add(homeBPanel);
		
		panel2.add(instructionsLabel);
		
		panel3.add(optionsSection);//for the input grids
		
		//options section
		optionsSection.add(gridInfoPanel);//All text icon that when you hover over them give you info
		optionsSection.add(gridTextPanel);//All the names for the symptoms
		optionsSection.add(gridInputPanel);//All the input options
		//Text panel
		gridTextPanel.add(l1); 
		gridTextPanel.add(l2); 
		gridTextPanel.add(l3); 
		//Text panel
		gridInfoPanel.add(tempInfo); 
		gridInfoPanel.add(achesInfo); 
		gridInfoPanel.add(soreInfo); 
		//Grid for inputs
		gridInputPanel.add(tempCoolB); gridInputPanel.add(tempNormalB); gridInputPanel.add(tempHotB);
		gridInputPanel.add(achesYesB); gridInputPanel.add(achesNoB); gridInputPanel.add(fillerPanel1);
		gridInputPanel.add(soreYesB); gridInputPanel.add(soreNoB); gridInputPanel.add(fillerPanel2);
		
		//Put radio buttons in group so you can only select one
		tempGroup.add(tempCoolB);
	    tempGroup.add(tempNormalB);
	    tempGroup.add(tempHotB);
	    acheGroup.add(achesYesB);
	    acheGroup.add(achesNoB);
	    throatGroup.add(soreYesB);
	    throatGroup.add(soreNoB);
		
		
		//for places to put submit button and accuracy check
	    submitPanel.add(submitB);
		panel4.add(submitPanel);//panel that holds submit button
		//results panel will be added after action
		
		//add accuracy panel to panel 5 later 
		
	//EDIT AND SET//////////
	    //Set layout details
	    //Frame
	    frame.setExtendedState(frame.MAXIMIZED_BOTH);//Open in fullscreen
	    frame.setSize(600,800); //default size if you exit fullscreen//1500,1200//width,height
	    frame.setMinimumSize(new Dimension(800, 900));//Min size because gui breaks and lower
	    frame.setVisible(true); 
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Close properly
	    frame.setLayout(new GridLayout(5,1));//grid layout of rows, columns for the entire window
	    
	    panel1.setLayout(new GridLayout(1,1));
	    panel2.setLayout(new GridLayout(1,1));//Needed to make a grid so can align text to centre instead of top
	    
	    //For the main grid of inputs to show, //in grid 3
	    optionsSection.setLayout(new FlowLayout());
	    gridInfoPanel.setLayout(new GridLayout(3,1 ,0,18));//The middle grid for info icon//rows,cols,horizontalgap,vertical gap//hat to use gaps to line up with buttons
	    gridTextPanel.setLayout(new GridLayout(3,1 ,00,8));//The left grid for symptom name
	    gridInputPanel.setLayout(new GridLayout(3,3 ,0,0));//The right grid for options
	   
	    panel4.setLayout(new GridLayout(3,1));//grid for submit, empty, results
	    
	    //accuracy panel is in panel5
	    accuracyPanel.setLayout(new GridLayout(2,1 ,0,0));//The right grid for options
	    
	    //For testing
/*	    panel1.setBackground(Color.green);
	    panel2.setBackground(Color.blue);
	    panel3.setBackground(Color.yellow);
	    panel4.setBackground(Color.red);
	    panel5.setBackground(Color.magenta);
*/	    
	  //Style changes
	    //make fonts for everything//Only set once so didnt use method
	    fontBig = new Font("Helvetica", Font.BOLD,36);//Make a font style
	    fontBold = new Font("Helvetica", Font.BOLD,26);//Make a font style
	    font = new Font("Helvetica", Font.PLAIN,26);
	    
	    //labels for symptom names
	    l1.setFont(fontBold);
	    l2.setFont(fontBold);
	    l3.setFont(fontBold);
	    
	    // apply the font style to all
	    instructionsLabel.setFont(fontBold);
	    
	    tempCoolB.setFont(font);	tempCoolB.setFocusable(false);  
	    tempNormalB.setFont(font);  tempNormalB.setFocusable(false);
	    tempHotB.setFont(font);     tempHotB.setFocusable(false);   
	    achesYesB.setFont(font);    achesYesB.setFocusable(false);  
	    achesNoB.setFont(font);     achesNoB.setFocusable(false);   
	    soreYesB.setFont(font);     soreYesB.setFocusable(false);   
	    soreNoB.setFont(font);      soreNoB.setFocusable(false);    
	    
	    //Set values and details of the tooltip icons
	    tempInfo.setToolTipText(tempTipText);//Tooptips for the i icons beside that display info on symptom.
	    achesInfo.setToolTipText(achesTipText);
	    soreInfo.setToolTipText(soreTipText);
	    ToolTipManager.sharedInstance().setDismissDelay(Integer.MAX_VALUE);//For keeping tooltips visible aslong as user hovers.//gotten from https://www.rgagnon.com/javadetails/java-0528.html
	
	    
	    homeB.setFont(font);
	    homeB.setFocusable(false);
	    homeB.setPreferredSize(new Dimension(120, 50));//width,height//Set the size of the button within the panel thats the full grid size
	    homeB.setBackground(new Color(220,220,220));
	    //For submit button
	    submitB.setFont(fontBold);
	    submitB.setFocusable(false);
	    submitB.setPreferredSize(new Dimension(250, 50));//row,col//Set the size of the button within the panel thats the full grid size
	    submitB.setBackground(new Color(220,220,220));
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
			String inputTemp = null;//Values that will be used to pass to array
			String inputAches = null;
			String inputSore = null;
			boolean correctInput = true;//for checking all boxes are entered to pass values to probability checker
			
			//Temp
			if(tempCoolB.isSelected())
			{
				inputTemp = "Cool";
			}
			else if (tempNormalB.isSelected())
			{
				inputTemp = "Normal";
			}
			else if(tempHotB.isSelected())
			{
				inputTemp = "Hot";
			}
			else
			{
				correctInput = false;//If they didnt enter any value then dont run Probability check
			}
			
			//Aches
			if(achesYesB.isSelected())
			{
				inputAches = "Yes";
			}
			else if (achesNoB.isSelected())
			{
				inputAches = "No";
			}
			else			
			{
				correctInput = false;
			} 
			
			//Sore throat
			if(soreYesB.isSelected())
			{
				inputSore = "Yes";
			}
			else if (soreNoB.isSelected())
			{
				inputSore = "No";
			}
			else			
			{
				correctInput = false;
			}
			
			if(correctInput == true)
			{
				FindProbability p1 = new FindProbability(inputTemp, inputAches, inputSore);
				//for displaying result
				resultsString = ("Theres is a "+(int)p1.getProbabilityOfHavingTS()+"% chance you have tonsillitis.");
				resultsLabel.setText(resultsString);//got swing constants from http://www.java2s.com/Code/Java/Swing-JFC/AsimpledemonstrationoftextalignmentinJLabels.htm
				resultsLabel.setFont(fontBold);//have matching font
				panel4.add(resultsLabel);//show in gui
				
				//for now displaying accuracy
				pb.setValue((int)p1.FindAccuracy());//get number % of accuracy
				pb.setPreferredSize( new Dimension (320, 20));//set size of accuracy bar out of 100
				accuracyBarPanel.add(pb);//add the panel containing the bar to the accuracy panel
				
				accuracyString = ("Predicted with "+(int)p1.FindAccuracy()+"% accuracy");//put sentence in string
			    accuracyLabel.setText(accuracyString);//label was alreayd created, just set the text
			    accuracyLabel.setFont(font);//ste fotn to the fontstyle made earlier
			    accuracyPanel.add(accuracyLabel);//Add compontents to panel that will be displayed
			    accuracyPanel.add(accuracyBarPanel);
			    panel5.add(accuracyPanel);//All all to panel 5 so that it shows to user
			    frame.revalidate();//refresh the page to show results
			}
			else if(correctInput == false)
			{
				JOptionPane.showMessageDialog(this,"There was incorrect input, please try again.");
			}
		}
	}
}
