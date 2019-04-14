package com.assignment.machinelearning;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.util.ArrayList;
import java.awt.Color;

public class GuiFile extends JFrame implements ActionListener
{
//Make all attributes//////////////////////////////////////////////////////////////
	private JFrame frame;
	
	private JPanel panel1;//Main frame panels
	private JPanel panel2;                   
	private JPanel panel3;                   
	private JPanel panel4;//Need to declare because i want to hide before its needed

	
	private JButton homeB;//Needs declaration for action event
	private JButton submitB;//Need to declare buttons so they can be accessed when making gui
	private JButton fileB;
	
	private Font fontBold;
	private Font font;
	
	private String resultsString;
	private JTextArea resultTextArea;
	
	private JScrollPane scroll;//https://stackoverflow.com/questions/7766844/java-jscrollpane
	
	static String chosenFile;
	
	ArrayList<Patient> patientList = new ArrayList<Patient>();
//Constructor////////////////////
	public GuiFile()//Construct
	{ 
	//MAKE and instantiate//////////
		//Make dirrectly instead of 
	    frame = new JFrame("File selector");//The main window 
	    
	    //All the panels to go into the window
	    panel1 = new JPanel();//Main frame panels
	    panel2 = new JPanel();
	    panel3 = new JPanel();
	    panel4 = new JPanel();
	    
	    JPanel homeBPanel = new JPanel();//Need to make a panel for home button so it doesnt fill the grid and i can still align it
	    homeB = new JButton("Home");
	    homeB.addActionListener(this);
	    
	    JPanel filePathPanel = new JPanel();
	    JLabel filePathLabel  = new JLabel("Current selected file is: "+Control.getChosenFile());//got swing constants from http://www.java2s.com/Code/Java/Swing-JFC/AsimpledemonstrationoftextalignmentinJLabels.htm
	    
	    JPanel fillerPanel1 = new JPanel();//to fill the spaces
	    JPanel fillerPanel2 = new JPanel();
	    JPanel fillerPanel3 = new JPanel();//to fill the spaces
	    JPanel fillerPanel4 = new JPanel();
	    
	    //in panel 2//this triggers event causing other stuff to be made
	    JPanel filePanel = new JPanel();//Panel to put file button on so it doesnt fill the whole gridslot
	    fileB = new JButton("Change file");//Button for choosing new file
	    fileB.addActionListener(this);
	    
	    JPanel submitPanel = new JPanel();//Panel to put submit button on so it doesnt fill the whole gridslot
	    submitB = new JButton("Show list of patients");//Button for running findprobabilty class
	    submitB.addActionListener(this);
	    
	    resultTextArea = new JTextArea();//got swing constants from http://www.java2s.com/Code/Java/Swing-JFC/AsimpledemonstrationoftextalignmentinJLabels.htm
		scroll = new JScrollPane(resultTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);//add scrollbar to textarea
	    
	//ADD//////////
	    //
	    frame.add(panel1);//add empty panel
		frame.add(panel2);//panel with instructions
		frame.add(panel3);//panel with input grid
		frame.add(panel4);//panel with submit button, result and accuracy check
		
		homeBPanel.add(homeB);//add home button to panel so can align to top left
		panel1.add(homeBPanel);
		
		panel2.add(fillerPanel1);
		filePanel.add(fileB);//Make panel so button doesn fill entire area
		panel2.add(filePanel);
		filePathPanel.add(filePathLabel);
		panel2.add(filePathPanel);
		submitPanel.add(submitB);//Make panel so button doesn fill entire area
		panel2.add(submitPanel);
		
		panel3.add(scroll);//add the scroll box of results
		
	//EDIT AND SET//////////
	    //Set layout details
	    //Frame
	    frame.setExtendedState(frame.MAXIMIZED_BOTH);//Open in fullscreen
	    frame.setSize(600,800); //default size if you exit fullscreen//1500,1200//width,height
	    frame.setMinimumSize(new Dimension(850, 1000));//Min size because gui breaks and lower
	    frame.setVisible(true); 
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Close properly
	    frame.setLayout(new GridLayout(4,1));//grid layout of rows, columns for the entire window
	    
	    panel2.setLayout(new GridLayout(4,1));
	    
	  //Style changes
	    //make fonts for everything//Only set once so didnt use method
	    fontBold = new Font("Helvetica", Font.BOLD,26);//Make a font style
	    font = new Font("Helvetica", Font.PLAIN,26);
	    
	    
	    homeB.setFont(font);
	    homeB.setFocusable(false);
	    homeB.setPreferredSize(new Dimension(120, 50));//width,height//Set the size of the button within the panel thats the full grid size
	    homeB.setBackground(new Color(220,220,220));
	    
	    filePathLabel.setFont(font);
	    //For file button style
	    fileB.setFont(fontBold);
	    fileB.setFocusable(false);
	    fileB.setPreferredSize(new Dimension(300, 50));//row,col//Set the size of the button within the panel thats the full grid size
	    fileB.setBackground(new Color(220,220,220));
	    //For submit button
	    submitB.setFont(fontBold);
	    submitB.setFocusable(false);
	    submitB.setPreferredSize(new Dimension(300, 50));//row,col//Set the size of the button within the panel thats the full grid size
	    submitB.setBackground(new Color(220,220,220));
	    
		
		resultTextArea.setFont(font);//have matching font
		resultTextArea.setEditable(false);
		
		scroll.setVisible(false);
		scroll.setPreferredSize(new Dimension(900,240));
		
		resultTextArea.setFont(font);//have matching font
		resultTextArea.setEditable(false);
		
		panel3.add(scroll);//show in gui
	}  

//Methods///////////
	
	//allow user to change the file of testcases
	public String chooseFile()//got from https://docs.oracle.com/javase/7/docs/api/javax/swing/JFileChooser.html
	{
		JFileChooser theFile = new JFileChooser("src\\..");//the string is the path to open in, ..means go back one
		String filePath = "src\\com\\assignment\\machinelearning\\TestCases.csv";
		theFile.setFileSelectionMode(JFileChooser.FILES_ONLY);//files only means no folders
		theFile.setFileFilter(new FileNameExtensionFilter("text", "csv", "CSV"));//only allow these types of files
		
		theFile.showOpenDialog(GuiFile.this);//to make the popup show
		theFile.setVisible(true);//make gui show
		
		filePath = theFile.getSelectedFile().toString();//where the chosen file string is stored
		Control.setChosenFile(filePath);
		frame.revalidate();//refresh frame
		return filePath;
	}
	
	public void actionPerformed(ActionEvent EV)
	{
		//Home button
		if(EV.getSource() == homeB)//get source shows what functionality triggered it
		{
			GuiHome guiHome = new GuiHome();
			frame.dispose();
		}
		if(EV.getSource() == fileB)//get source shows what functionality triggered it
		{
			System.out.println("Returned string: "+chooseFile());
		}
		if(EV.getSource() == submitB)//get source shows what functionality triggered it
		{
			//Open file to get a list from to display to user
			FileProcessor fp1 = new FileProcessor(Control.getChosenFile());
			fp1.openFile();//open just to get array from file
			patientList = fp1.readFile();//fills array list from file. make new one here instead of calling across classes//Makes with 100% of values.
			fp1.closeFile();
			
			resultsString = ("");//Empty string so only new values go in
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
