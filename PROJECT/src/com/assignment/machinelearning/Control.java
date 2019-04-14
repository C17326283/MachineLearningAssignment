/*
To: This program uses test case file to predict the liklihood that a user has tonsillitis based on the the symptoms they enter.
There are 3 guis.
Home: which leads to the other 2,
Symptoms: which allows user to enter symptoms and get their result as well as the accuracy of the program
File selector: which allows the user to select a new file path for their test cases file as well as show the contents of the current file.
Their are 3 other classes:
Patient which just makes an object with the entered symptoms
Find probability which allows the user to pass in 3 symptom values and get an estimate of their probability to have tonsillitis, it also contains the method to find the accuracy of the system
FileProcessor which opens, reads and closes a file for making lists.

By: Ryan Byrne, C17326283, 01/04/19 to 14/04/19 
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
