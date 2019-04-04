package com.assignment.machinelearning;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProcessor 
{
	
	public FileProcessor()
	{
		CheckFile();
	}
	
	public void CheckFile()
	{
			//System.out.println(System.getProperty("user.dir"));//Used to find current directory
		File myFile = new File("src\\com\\assignment\\machinelearning\\TestCases.txt");//Makes a fiel from existing file//not sure why file isnt in current directory but used this instead of full path
		try {
			Scanner myScanner = new Scanner(myFile);//Makes scanner instance with stuff from file
			while(myScanner.hasNextLine())//Scans file to see if has next line
			{
				System.out.println(myScanner.nextLine());//Display contents of line
			}
		}
		catch (FileNotFoundException e) //If file problem
		{
			System.out.println("ERROR with file");
		}
		
		
	}

}
