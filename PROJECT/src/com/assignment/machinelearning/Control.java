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
		ArrayList<Patient> patientList = new ArrayList<Patient>();//Have array for patient details
		patientList.add(new Patient("hot","Yes","No","Yes"));//Temp,Aches,SoreThroat,Tonsillitis //test data
		patientList.add(new Patient("hot","Yes","Yes","No"));
		patientList.add(new Patient("hot","No","No","No"));
		
		Gui screen1 = new Gui();
	}
}
