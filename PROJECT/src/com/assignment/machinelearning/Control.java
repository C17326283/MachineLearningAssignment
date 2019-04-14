/*
To: Take sample data and use machine learning to test and see if a user has tonsillitis
By: Ryan Byrne, C17326283, 02/04/19

*/
package com.assignment.machinelearning;

public class Control
{
	//For file path that can change in guiFile//This line sets default, its only changed if the user choses
	static String chosenFile = ("src\\com\\assignment\\machinelearning\\TestCases.csv");//Have default file set for all classes to access unless changed in gui page 2
	
	public static void main(String[] args)
	{	
		GuiHome GuiHome = new GuiHome();//Make an instance of the gui to use it
		
		
	}

	//GETTER AND SETTERS 
	public static String getChosenFile()//static so can call without instantiating
	{
		return chosenFile;
	}
	public static void setChosenFile(String chosenFile)
	{
		Control.chosenFile = chosenFile;
	}
	
	
}
