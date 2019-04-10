package com.assignment.machinelearning;

import java.util.ArrayList;

public class Calculations 
{
	//Make variables//////////
	float patientsCount = 0;
	
	float yesTonsillitisCount = 0;
	float noTonsillitisCount = 0;
	
	float tempWithTS;
	float tempWithoutTS;
	float achesWithTS;
	float achesWithoutTS;
	float soreWithTS;
	float soreWithoutTS;
	//Sample patient for testing
	String temp;
	String aches;
	String sore;
	
	float ProbOfTS;
	float ProbOfNotTS;
	float z;
	float ProbabilityOfTS;
	float ProbabilityOfNotTS;
	
	//Constructor//////////
	public Calculations(String temp, String aches, String sore)//Catches and currently renames
	{
		this.temp = temp;
		this.aches = aches;
		this.sore = sore;
		
		FileProcessor f1 = new FileProcessor();//Make instance//This makes an arraylist of patient objects to call from
		
		patientsCount = f1.getTestCaseList().size();//
		
		for(int i=0; i <  f1.getTestCaseList().size(); i++)//count all the values in every object
		{
			//amount of people with tonsillitis
			if(f1.getTestCase(i).getTonsillitis().contentEquals("Yes"))
			{
				yesTonsillitisCount++;
			}
			else if(f1.getTestCase(i).getTonsillitis().contentEquals("No"))
			{
				noTonsillitisCount++;
			}	
			
			//TEMPS
			//Checks input so it can run the right code without using non relevant variables
			if(temp == "Cool")
			{
				if(f1.getTestCase(i).getTemperature().contentEquals("Cool") && f1.getTestCase(i).getTonsillitis().contentEquals("Yes"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
				{
					tempWithTS++;
				}
				else if(f1.getTestCase(i).getTemperature().contentEquals("Cool") && f1.getTestCase(i).getTonsillitis().contentEquals("No"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
				{
					tempWithoutTS++;
				}
			}
			else if(temp == "Normal")
			{
				if(f1.getTestCase(i).getTemperature().contentEquals("Normal") && f1.getTestCase(i).getTonsillitis().contentEquals("Yes"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
				{
					tempWithTS++;
				}
				else if(f1.getTestCase(i).getTemperature().contentEquals("Normal") && f1.getTestCase(i).getTonsillitis().contentEquals("No"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
				{
					tempWithoutTS++;
				}
			}
			else if(temp == "Hot")
			{
				if(f1.getTestCase(i).getTemperature().contentEquals("Hot") && f1.getTestCase(i).getTonsillitis().contentEquals("Yes"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
				{
					tempWithTS++;
				}
				else if(f1.getTestCase(i).getTemperature().contentEquals("Hot") && f1.getTestCase(i).getTonsillitis().contentEquals("No"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
				{
					tempWithoutTS++;
				}
			}
			
			//ACHES
			if(aches == "Yes")
			{
				if(f1.getTestCase(i).getAches().contentEquals("Yes") && f1.getTestCase(i).getTonsillitis().contentEquals("Yes"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
				{
					achesWithTS++;
				}
				else if(f1.getTestCase(i).getAches().contentEquals("Yes") && f1.getTestCase(i).getTonsillitis().contentEquals("No"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
				{
					achesWithoutTS++;
				}
			}
			else if(aches == "No")
			{
				if(f1.getTestCase(i).getAches().contentEquals("No") && f1.getTestCase(i).getTonsillitis().contentEquals("Yes"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
				{
					achesWithTS++;
				}
				else if(f1.getTestCase(i).getAches().contentEquals("No") && f1.getTestCase(i).getTonsillitis().contentEquals("No"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
				{
					achesWithoutTS++;
				}
			}
			
			//SORE THROAT
			if(sore == "Yes")
			{
				if(f1.getTestCase(i).getSoreThroat().contentEquals("Yes") && f1.getTestCase(i).getTonsillitis().contentEquals("Yes"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
				{
					soreWithTS++;
				}
				else if(f1.getTestCase(i).getSoreThroat().contentEquals("Yes") && f1.getTestCase(i).getTonsillitis().contentEquals("No"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
				{
					soreWithoutTS++;
				}
			}
			else if(sore == "No")
			{
				if(f1.getTestCase(i).getSoreThroat().contentEquals("No") && f1.getTestCase(i).getTonsillitis().contentEquals("Yes"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
				{
					soreWithTS++;
				}
				else if(f1.getTestCase(i).getSoreThroat().contentEquals("No") && f1.getTestCase(i).getTonsillitis().contentEquals("No"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
				{
					soreWithoutTS++;
				}
			}
		}//end for
		
		
		ProbOfTS = (tempWithTS/yesTonsillitisCount)*(achesWithTS/yesTonsillitisCount)*(soreWithTS/yesTonsillitisCount)*(yesTonsillitisCount/patientsCount);
		ProbOfNotTS = (tempWithoutTS/noTonsillitisCount)*(achesWithoutTS/noTonsillitisCount)*(soreWithoutTS/noTonsillitisCount)*(noTonsillitisCount/patientsCount);
		z = ProbOfTS + ProbOfNotTS;
		ProbabilityOfTS = ProbOfTS / z;
		ProbabilityOfNotTS = ProbOfNotTS / z;
		
		System.out.println("yesTonsillitisCount: "+yesTonsillitisCount+"\n");
		
		System.out.println("TempWithTS: "+tempWithTS+"/"+yesTonsillitisCount+"="+tempWithTS/yesTonsillitisCount);
		System.out.println("AchesWithTS: "+achesWithTS+"/"+yesTonsillitisCount+"="+achesWithTS/yesTonsillitisCount);
		System.out.println("SoreWithTS: "+soreWithTS+"/"+yesTonsillitisCount+"="+soreWithTS/yesTonsillitisCount+"\n");
		
		System.out.println("TempWithoutTS: "+tempWithoutTS+"/"+noTonsillitisCount+"="+tempWithoutTS/noTonsillitisCount);
		System.out.println("AchesWithoutTS: "+achesWithoutTS+"/"+noTonsillitisCount+"="+achesWithoutTS/noTonsillitisCount);
		System.out.println("SoreWithoutTS: "+soreWithoutTS+"/"+noTonsillitisCount+"="+soreWithoutTS/noTonsillitisCount+"\n");
		
		System.out.println("ProbOfTS: "+ProbOfTS);
		System.out.println("ProbOfNotTS: "+ProbOfNotTS);
		
		System.out.println("Probs added together: "+z+"\n");
		
		System.out.println("Probability of TS: "+ProbabilityOfTS);
		System.out.println("Probability of not TS: "+ProbabilityOfNotTS);
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


So the formula for probability of having TS:
all(probability of sympton given TS)(has TS/all patients) = x
all(probability of sympton given no TS)(not have TS/all patients) = y
x + y = z
x/z = probability of having

*/