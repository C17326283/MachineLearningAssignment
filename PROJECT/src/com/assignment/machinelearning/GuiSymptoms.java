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

	JButton submitB;//Need to declare buttons so they can eb access when making gui
	JRadioButton tempCoolB;
	JRadioButton tempNormalB;
	JRadioButton tempHotB;
	JRadioButton achesYesB;
	JRadioButton achesNoB;
	JRadioButton soreYesB;
	JRadioButton soreNoB;
	JProgressBar pb;
	
	JLabel accuracyLabel;
	String accuracyString;
	JPanel accuracyBarPanel;
	
	JPanel panel1;//Main frame panels
	JPanel panel2;                   
	JPanel panel3;                   
	JPanel panel4;//Need to declare because i want to hide before its needed
	JPanel panel5;
//Constructor////////////////////
	public GuiSymptoms()//Construct
	{ 
	//Make/////
		//Make dirrectly instead of 
	    JFrame frame = new JFrame("Ryan Byrne Assignment");//The main window 
	    
	    //All the panels to go into the window
	    panel1 = new JPanel();//Main frame panels
	    panel2 = new JPanel();
	    panel3 = new JPanel();
	    panel4 = new JPanel();
	    panel5 = new JPanel();
	    
	    
	    
	    JPanel optionsSection  = new JPanel();
	    
	    JPanel gridTextPanel = new JPanel();
	    JPanel gridInfoPanel = new JPanel();
	    JPanel gridInputPanel = new JPanel();//For grid of inputs
	    
	    JPanel fillerPanel1 = new JPanel();//to fill the spaces to make the input grid look right
	    JPanel fillerPanel2 = new JPanel();
	    JPanel fillerPanel3 = new JPanel();//This one is for putting space between submit and accuracy checker
	    
	    JPanel submitPanel = new JPanel();//Panel to put submit button on so it doesnt fill the whole gridslot
	    JPanel accuracyBarPanel = new JPanel();//Panel to put submit button on so it doesnt fill the whole gridslot
	    
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
	    
	    pb = new JProgressBar(0,100);
	    pb.setVisible(false);
	    
	    accuracyString = ("The accuracy of this program is: ");
	    accuracyLabel = new JLabel(accuracyString);
	    accuracyLabel.setVisible(true);
	    
	    //The text next to input
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
	    
	    String tempTipText = "Normal body temperature is around ranges from 36.1°C (97°F) to 37.2°C (99°F). If you are above this range then select hot and if you are below select cool.";
	    String achesTipText = "A continuous or dull pain, such as backache, throbbing, headache & toothache.";
	    String soreTipText = "Pain, scratchiness or irritation in the throat.";
	    
	    
	    
	//Add/////
	    //
	    frame.add(panel1);//add panel1 to frame
		frame.add(panel2);
		frame.add(panel3);
		frame.add(panel4);
		frame.add(panel5);
		
		panel3.add(optionsSection);
		
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
		
		//for places to put submit button and accuracy check
		panel4.add(submitPanel);
		panel4.add(fillerPanel3);
		panel4.add(accuracyLabel);
		panel4.add(accuracyBarPanel);
		submitPanel.add(submitB);
		accuracyBarPanel.add(pb);
		
		//Put radio buttons in group so you can only select one
		tempGroup.add(tempCoolB);
	    tempGroup.add(tempNormalB);
	    tempGroup.add(tempHotB);
	    acheGroup.add(achesYesB);
	    acheGroup.add(achesNoB);
	    throatGroup.add(soreYesB);
	    throatGroup.add(soreNoB);
	    
	//Edit & set/////
	    //Set layout details
	    //Frame
	    frame.setExtendedState(frame.MAXIMIZED_BOTH);//Open in fullscreen
	    frame.setSize(600,800); //default size if you exit fullscreen//1500,1200//width,height
	    frame.setMinimumSize(new Dimension(600, 700));//Min size because gui breaks and lower
	    frame.setVisible(true); 
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Close properly
	    frame.setLayout(new GridLayout(5,1));//grid layout of rows, columns for the entire window
	    
	    //For the main grid of inputs to show, 
	    optionsSection.setLayout(new FlowLayout());
	    gridInfoPanel.setLayout(new GridLayout(3,1 ,0,18));//The middle grid for info icon//rows,cols,horizontalgap,vertical gap//hat to use gaps to line up with buttons
	    gridTextPanel.setLayout(new GridLayout(3,1 ,00,8));//The left grid for symptom name
	    gridInputPanel.setLayout(new GridLayout(3,3 ,0,0));//The right grid for options
	    
	    panel4.setLayout(new GridLayout(4,1));//The right grid for options
	    
	    //For testing
	    panel1.setBackground(Color.green);
	    panel2.setBackground(Color.blue);
	    panel3.setBackground(Color.yellow);
	    panel4.setBackground(Color.red);
	    
	    accuracyLabel = new JLabel(accuracyString);
	    //TODO align accuracy to center
	    //set object details
	    //Set fonts for everything//Only set once so didnt use method
	    Font fontB = new Font("Helvetica", Font.BOLD,26);//Make a font style
	    Font font = new Font("Helvetica", Font.PLAIN,26);
	    
	    //labels fro symtomnames
	    l1.setFont(fontB);
	    l2.setFont(fontB);
	    l3.setFont(fontB);
	    
	 // apply the font style to all
	    submitB.setFont(fontB);     submitB.setFocusable(false);//not focused, to remove annoying blue box, for cursor selection
	    tempCoolB.setFont(font);	tempCoolB.setFocusable(false);  
	    tempNormalB.setFont(font);  tempNormalB.setFocusable(false);
	    tempHotB.setFont(font);     tempHotB.setFocusable(false);   
	    achesYesB.setFont(font);    achesYesB.setFocusable(false);  
	    achesNoB.setFont(font);     achesNoB.setFocusable(false);   
	    soreYesB.setFont(font);     soreYesB.setFocusable(false);   
	    soreNoB.setFont(font);      soreNoB.setFocusable(false);    
	   
	    tempInfo.setToolTipText(tempTipText);//Tooptips for the i icons beside that display info on symptom.
	    achesInfo.setToolTipText(achesTipText);
	    soreInfo.setToolTipText(soreTipText);
	    ToolTipManager.sharedInstance().setDismissDelay(Integer.MAX_VALUE);//For keeping tooltips visible aslong as user hovers.//gotten from https://www.rgagnon.com/javadetails/java-0528.html
	
	    
	    
	    gridInputPanel.setVisible(true);
	    
	    /*
	    JPanel boxPanel = new JPanel();

	    JLabel label = new JLabel("This should be centered");
	    label.setHorizontalAlignment(SwingConstants.CENTER);
	    centerPanel.add(label, BorderLayout.CENTER);

	    contentPane.add(centerPanel, BorderLayout.CENTER);
	    contentPane.pack();
	    contentPane.setVisible(true);*/
	}  

//Methods///////////
	public void actionPerformed(ActionEvent EV)
	{
		
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
			
			if(correctInput == true)//TODO switch incorrect to correct
			{
				FindProbability p1 = new FindProbability(inputTemp, inputAches, inputSore);
				JOptionPane.showMessageDialog(this, p1);
				
				System.out.print(accuracyString);
				accuracyString = accuracyString+p1.FindAccuracy();//Says how accurate the system is in panel4
				accuracyLabel = new JLabel(accuracyString);
				System.out.print(accuracyString);
				accuracyLabel.setVisible(true);//Make visible once they have values.
				pb.setValue((int)p1.FindAccuracy());
				pb.setVisible(true);
			}
			else if(correctInput == false)
			{
				JOptionPane.showMessageDialog(this,"There was incorrect input, please try again.");
			}
		}
	}
}
