package com.assignment.machinelearning;

import java.util.ArrayList;

public class Calculations 
{
	//Make variables//////////
	int patientsCount = 0;
	
	int yesTonsillitisCount = 0;
	int noTonsillitisCount = 0;
	
	int CoolAndTS;
	int NormalAndTS;
	int HotAndTS;
	int AchesAndTS;
	int NoAchesAndTS;
	int SoreAndTS;
	int NoSoreAndTS;
	
	int CoolNoTS;
	int NormalNoTS;
	int HotNoTS;
	int AchesNoTS;
	int NoAchesNoTS;
	int SoreNoTS;
	int NoSoreNoTS;
	
	//Sample patient for testing
	String Temp = "Hot";
	String Aches = "Yes";
	String Sore = "Yes";
	
	//Constructor//////////
	public Calculations()
	{
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
			if(Temp == "Cool")
			{
				if(f1.getTestCase(i).getTemperature().contentEquals("Cool") && f1.getTestCase(i).getTonsillitis().contentEquals("Yes"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
				{
					CoolAndTS++;
				}
				else if(f1.getTestCase(i).getTemperature().contentEquals("Cool") && f1.getTestCase(i).getTonsillitis().contentEquals("No"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
				{
					CoolNoTS++;
				}
			}
			else if(Temp == "Normal")
			{
				if(f1.getTestCase(i).getTemperature().contentEquals("Normal") && f1.getTestCase(i).getTonsillitis().contentEquals("Yes"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
				{
					NormalAndTS++;
				}
				else if(f1.getTestCase(i).getTemperature().contentEquals("Normal") && f1.getTestCase(i).getTonsillitis().contentEquals("No"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
				{
					NormalNoTS++;
				}
			}
			else if(Temp == "Hot")
			{
				if(f1.getTestCase(i).getTemperature().contentEquals("Hot") && f1.getTestCase(i).getTonsillitis().contentEquals("Yes"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
				{
					HotAndTS++;
				}
				else if(f1.getTestCase(i).getTemperature().contentEquals("Hot") && f1.getTestCase(i).getTonsillitis().contentEquals("No"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
				{
					HotNoTS++;
				}
			}
			
			//ACHES
			if(Aches == "Yes")
			{
				if(f1.getTestCase(i).getAches().contentEquals("Yes") && f1.getTestCase(i).getTonsillitis().contentEquals("Yes"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
				{
					AchesAndTS++;
				}
				else if(f1.getTestCase(i).getAches().contentEquals("Yes") && f1.getTestCase(i).getTonsillitis().contentEquals("No"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
				{
					AchesNoTS++;
				}
			}
			else if(Aches == "No")
			{
				if(f1.getTestCase(i).getAches().contentEquals("No") && f1.getTestCase(i).getTonsillitis().contentEquals("Yes"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
				{
					NoAchesAndTS++;
				}
				else if(f1.getTestCase(i).getAches().contentEquals("No") && f1.getTestCase(i).getTonsillitis().contentEquals("No"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
				{
					NoAchesNoTS++;
				}
			}
			
			//SORE THROAT
			if(Sore == "Yes")
			{
				if(f1.getTestCase(i).getSoreThroat().contentEquals("Yes") && f1.getTestCase(i).getTonsillitis().contentEquals("Yes"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
				{
					SoreAndTS++;
				}
				else if(f1.getTestCase(i).getSoreThroat().contentEquals("Yes") && f1.getTestCase(i).getTonsillitis().contentEquals("No"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
				{
					SoreNoTS++;
				}
			}
			else if(Sore == "No")
			{
				if(f1.getTestCase(i).getSoreThroat().contentEquals("No") && f1.getTestCase(i).getTonsillitis().contentEquals("Yes"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
				{
					NoSoreAndTS++;
				}
				else if(f1.getTestCase(i).getSoreThroat().contentEquals("No") && f1.getTestCase(i).getTonsillitis().contentEquals("No"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
				{
					NoSoreNoTS++;
				}
			}
		}//end for
			
		System.out.println("cool: "+CoolAndTS+"/"+yesTonsillitisCount);
		System.out.println("norm: "+NormalAndTS+"/"+yesTonsillitisCount);
		System.out.println("hot: "+HotAndTS+"/"+yesTonsillitisCount);
		System.out.println("aches: "+AchesAndTS+"/"+yesTonsillitisCount);
		System.out.println("no aches: "+NoAchesAndTS+"/"+yesTonsillitisCount);
		System.out.println("sore: "+SoreAndTS+"/"+yesTonsillitisCount);
		System.out.println("no sore: "+NoSoreAndTS+"/"+yesTonsillitisCount);
		
		System.out.println("cool no ts: "+CoolNoTS+"/"+noTonsillitisCount);
		System.out.println("norm no ts: "+NormalNoTS+"/"+noTonsillitisCount);
		System.out.println("hot no ts: "+HotNoTS+"/"+noTonsillitisCount);
		System.out.println("aches no ts: "+AchesNoTS+"/"+noTonsillitisCount);
		System.out.println("no aches no ts: "+NoAchesNoTS+"/"+noTonsillitisCount);
		System.out.println("sore no ts: "+SoreNoTS+"/"+noTonsillitisCount);
		System.out.println("no sore no ts: "+NoSoreNoTS+"/"+noTonsillitisCount);

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