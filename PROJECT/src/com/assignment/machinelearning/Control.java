/*
To: Take sample data and use machine learning to test and see if a user has tonsillitis
By: Ryan Byrne, C17326283, 02/04/19


Todo: make getters and setters, make it so it can read cases from a file, do naive bayes calculations
output if tonsillitis or not
be able to add more instances
be able to self evaluate by using 

*/
package com.assignment.machinelearning;

import java.util.ArrayList;

public class Control
{
	public static void main(String[] args)
	{
		ArrayList<Patient> patientList = new ArrayList<Patient>();//Have array for patient details
		patientList.add(new Patient("hot","Yes","No","Yes"));//Temp,Aches,SoreThroat,Tonsillitis //test data
		patientList.add(new Patient("hot","Yes","Yes","No"));
		patientList.add(new Patient("hot","No","No","No"));
		
		for(int i = 0; i < patientList.size(); i++)//System.out.println(peopleList);//Prints all
		{
			System.out.println(patientList.get(i));
		}
		
	//	Gui screen1 = new Gui();//Make an instance of the gui to use it
		FileProcessor f1 = new FileProcessor();
	}
}
