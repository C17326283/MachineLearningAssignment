package com.assignment.machinelearning;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileProcessor 
{
	private ArrayList<Patient> testCaseList = new ArrayList<Patient>();//Make a smart arraylist that contains Objects of patients

//CONSTRUCTOR////////////////////
	public FileProcessor()
	{
		FillList();
	}
	
	public ArrayList<Patient> FillList()
	{
		//System.out.println(System.getProperty("user.dir"));//Used to find current directory
		File myFile = new File("src\\com\\assignment\\machinelearning\\TestCases.csv");//Makes a file from existing csv file//not sure why file isnt in current directory but used this instead of full path
		
		try//Needed incase file not found
		{
			Scanner myScanner = new Scanner(myFile);//Makes scanner for looking through file
			
			while(myScanner.hasNextLine())//while more lines in the file
			{
				String line = (myScanner.nextLine());//Get the contents of the first line in the file
				String[] word = line.split(",");
				
				testCaseList.add(new Patient(word[0], word[1], word[2], word[3]));//Make a new object of Patient with the contents of a line and add it the array list
			}
		}
		catch (FileNotFoundException e) //If file problem
		{
			System.out.println("ERROR finding file.");
		}
		
		return testCaseList;
	}

//METHODS////////////////////
	//For calling specific person//needed because i want to use up to x cases are for probability and x to full list is test cases.
	public Patient getTestCase(int i) 
	{
		return testCaseList.get(i);
	}
	
	public void addTestCase()
	{
		//Will add another test case if the user chooses
	}
	
//GETTERS AND SETTERS////////////////////
	public ArrayList<Patient> getTestCaseList() {
		return testCaseList;
	}

	public void setTestCaseList(ArrayList<Patient> testCaseList) {
		this.testCaseList = testCaseList;
	}
	
	
	
}
