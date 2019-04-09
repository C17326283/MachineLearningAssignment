package com.assignment.machinelearning;

import java.util.ArrayList;

public class Calculations 
{
	//Make variables//////////
	int patientsCount = 0;
	
	int coolTempCount = 0;
	int normTempCount = 0;
	int hotTempCount = 0;
	
	int yesAchesCount = 0;
	int noAchesCount = 0;
	
	int yesSoreCount = 0;
	int noSoreCount = 0;
	
	
	//Constructor//////////
	public Calculations()
	{
		FileProcessor f1 = new FileProcessor();//Make instance//This makes an arraylist of patient objects to call from
		
		patientsCount = f1.getTestCaseList().size();//
		
		for(int i=0; i <  f1.getTestCaseList().size(); i++)
		{
			//Temps
			if(f1.getTestCase(i).getTemperature().contentEquals("Cool"))
			{
				coolTempCount++;
			}
			else if(f1.getTestCase(i).getTemperature().contentEquals("Normal"))
			{
				normTempCount++;
			}
			else if(f1.getTestCase(i).getTemperature().contentEquals("Hot"))
			{
				hotTempCount++;
			}
			
			//Aches
			if(f1.getTestCase(i).getAches().contentEquals("Yes"))
			{
				yesAchesCount++;
			}
			else if(f1.getTestCase(i).getAches().contentEquals("No"))
			{
				noAchesCount++;
			}
			
			//SoreThroats
			if(f1.getTestCase(i).getSoreThroat().contentEquals("Yes"))
			{
				yesSoreCount++;
			}
			else if(f1.getTestCase(i).getAches().contentEquals("No"))
			{
				noSoreCount++;
			}	
		}
		
		System.out.println("Patients: "+patientsCount);
		System.out.println("coolTempCount: "+coolTempCount);
		System.out.println("normTempCount: "+normTempCount);
		System.out.println("hotTempCount: "+hotTempCount);
		System.out.println("yesAchesCount: "+yesAchesCount);
		System.out.println("noAchesCount: "+noAchesCount);
		System.out.println("yesSoreCount: "+yesSoreCount);
		System.out.println("noSoreCount: "+noSoreCount);
		
	}

}

/*
Naive bayes considers each feature independently(naive) to find a probability
uses the maximum likelihood

P(A|B) probability A occurs given that b is true
P(A) and  P(B) seperate probabilities of each

first get the probability of all yes's and no's 

In sample data: 18 patient
P(cool temp) = 5/18
P(hot temp) =5/18
P(normal temp =8/18

P(have aches) = 11 / 18
P(no aches) = 7/18

P(sore throat) = 10/18
P(no sore)= 8/18


*/