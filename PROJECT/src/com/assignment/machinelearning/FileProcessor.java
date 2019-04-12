//Filllist() goes through sample data file and for every line it makes an object with the temp, aches, sore, tonsillitis.
//this is used to test if the patient has tonsillitis
//for filllist(int i) it goes through and does the same but only up to the line specified so the rest can be used as test data for this practice data



//TODO make the file path changeable in app
//Make open and close file
package com.assignment.machinelearning;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileProcessor 
{
	private static String filePath = "src\\com\\assignment\\machinelearning\\TestCases.csv";
	private ArrayList<Patient> trainingCaseList = new ArrayList<Patient>();//Make a smart arraylist that contains Objects of patients
	private ArrayList<Patient> testingCaseList = new ArrayList<Patient>();
	private int splitPercent;

//CONSTRUCTORs////////////////////
	public FileProcessor()//If no input then just made a list using all testcases
	{
		//Make openfile
		//System.out.println(System.getProperty("user.dir"));//Used to find current directory
		File myFile = new File("src\\com\\assignment\\machinelearning\\TestCases.csv");//Makes a file from existing csv file//not sure why file isnt in current directory but used this instead of full path
		
		try//Needed incase file not found
		{
			Scanner myScanner = new Scanner(myFile);//Makes scanner for looking through file
			
			trainingCaseList.removeAll(trainingCaseList);
			
			while(myScanner.hasNextLine())//while more lines in the file
			{
				String line = (myScanner.nextLine());//Get the contents of the first line in the file
				String[] word = line.split(",");
				
				trainingCaseList.add(new Patient(word[0], word[1], word[2], word[3]));//Make a new object of Patient with the contents of a line and add it the array list
			}
			System.out.println("made 100% training list: "+trainingCaseList);
			myScanner.close();
		}
		catch (FileNotFoundException e) //If file problem
		{
			System.out.println("ERROR finding file.");
		}
		
//add to list
}

public FileProcessor(int splitPercent)//override//use the input to choose midpoint between making trainingdata and testdata
{
	this.splitPercent = splitPercent;
	//Make openfile
//System.out.println(System.getProperty("user.dir"));//Used to find current directory
	File myFile = new File("src\\com\\assignment\\machinelearning\\TestCases.csv");//Makes a file from existing csv file//not sure why file isnt in current directory but used this instead of full path
	
	try//Needed incase file not found
	{
		int i = 0;
		Scanner myScanner = new Scanner(myFile);//Makes scanner for looking through file
		
		trainingCaseList.removeAll(trainingCaseList);
		
		while(myScanner.hasNextLine())//while more lines in the file
		{
			String line = (myScanner.nextLine());//Get the contents of the first line in the file
			String[] word = line.split(",");
			
			if(i < splitPercent)
			{	
				trainingCaseList.add(new Patient(word[0], word[1], word[2], word[3]));//Make a new object of Patient with the contents of a line and add it the array list
				System.out.println("training i is: "+i);
			}
			else if(i >= splitPercent)
			{	
				testingCaseList.add(new Patient(word[0], word[1], word[2], word[3]));//Make a new object of Patient with the contents of a line and add it the array list
				System.out.println("testing i is: "+i);
			}
			//System.out.println(testingCaseList.get(i));
			i++;
		}
		System.out.println("made 70% training list: "+trainingCaseList);
		System.out.println("made 30% training list: "+testingCaseList);
		myScanner.close();
	}
	catch (FileNotFoundException e) //If file problem
	{
		System.out.println("ERROR finding file.");
	}
}


	
//METHODS////////////////////
	//For calling specific person//needed because i want to use up to x cases are for probability and x to full list is test cases.
	public Patient getTrainingCase(int i) 
	{
		return trainingCaseList.get(i);
	}
	
	public void addTestCase()
	{
		//Will add another test case if the user chooses
	}
	
	//need this because ill be reusign the testdata arraylist with different sizes so need to keep the full size
	public static int getNoOfLines()
	{
		int noOfLines = 0;
		File myFile = new File("src\\com\\assignment\\machinelearning\\TestCases.csv");
		try 
		{
			Scanner myScanner = new Scanner(myFile);
			
			while(myScanner.hasNextLine())
			{
				noOfLines++;
				myScanner.nextLine();
			}
		}
		catch (FileNotFoundException e) //If file problem
		{
			System.out.println("ERROR finding file.");
		}
		return noOfLines-1;
	}
	
//GETTERS AND SETTERS////////////////////
	public ArrayList<Patient> getTrainingCaseList()
	{
		return trainingCaseList;
	}

	public void setTrainingCaseList(ArrayList<Patient> testCaseList) {
		this.trainingCaseList = testCaseList;
	}

	public static String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
	
	
	
}
