/*
To: Take sample data and use machine learning to test and see if a user has tonsillitis
By: Ryan Byrne, C17326283, 02/04/19

*/
package com.assignment.machinelearning;

import java.util.ArrayList;

public class Control
{
	public static void main(String[] args)
	{	
		Gui screen1 = new Gui();//Make an instance of the gui to use it
		
		FindProbability p1 = new FindProbability("Hot", "Yes", "Yes");
		System.out.print(p1);
		//Make object add name, open, read list and get back arraylist of patients, close
/*		FileProcessor fp = new FileProcessor("src\\com\\assignment\\machinelearning\\TestCases.csv");//Constructs a fileprocessor object which just assigns the filename
		fp.openFile();
		System.out.print(fp.readFile());
		fp.closeFile();
*/
	}
}
