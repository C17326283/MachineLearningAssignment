//TODO make the file path changeable in app
//Make open and close file
package com.assignment.machinelearning;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileProcessor 
{
//ATTRIBUTES///////////////
	String fileName;//the string thats taken in for the filepath
	Scanner myScanner;//the thing that actually opens the file
	File fileData;
	ArrayList<Patient> trainingCaseList = new ArrayList<Patient>();
	
	
//CONSTRUCTOR////////////
	public FileProcessor(String fileName)//Makes the object using the passed in values.
	{
		this.fileName = fileName;//Just saves filename to be used with readfile();
	}
	
//METHODS//////////////
	//open the file so data can be read from it.
	void openFile()
	{
		fileData = new File(fileName);
	}

	//Reads through file and returns an arraylist of patient objects containing symptoms
    ArrayList<Patient> readFile()
    {
	    try
		{
	    	myScanner = new Scanner(fileData); //Scanner reads the actuall content of the file.
	    	
	    	while (myScanner.hasNextLine())//for every line in file
		    {
	    		String line = (myScanner.nextLine());//line = current line, then move to next line.
	    		String[] word = line.split(",");//make an array of 4 words and fill it with the words in each column of file.
	    		
	    		trainingCaseList.add(new Patient(word[0], word[1], word[2], word[3]));//add all of the words to a patient object that sets them as attributes and then adds all those object to an arraylist
		    }
		}
		catch (FileNotFoundException e)
		{
			System.out.println("FileProcessor Error: " + e.getMessage());
		}
	    return trainingCaseList;
    }
    
    void closeFile()
    {
    	//Close the file so it cant be read from anymore
		 myScanner.close();
    }
}