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
	
	int yesTonsillitisCount = 0;
	int noTonsillitisCount = 0;
	//////////////////////////////////////////
	String Temp = "Hot";
	String Aches = "Yes";
	String Sore = "Yes";
	
	int CoolAndTS;
	int NormAndTS;
	int HotAndTS;
	int AchesAndTS;
	int SoreAndTS;
	
	int CoolNoTS;
	int NormNoTS;
	int HotNoTS;
	int AchesNoTS;
	int SoreNoTS;
	
	
	//Constructor//////////
	public Calculations()
	{
		FileProcessor f1 = new FileProcessor();//Make instance//This makes an arraylist of patient objects to call from
		
		patientsCount = f1.getTestCaseList().size();//
		
		for(int i=0; i <  f1.getTestCaseList().size(); i++)//count all the values in every object
		{
			
			//Temps
			if(f1.getTestCase(i).getTemperature().contentEquals("Cool"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
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
			
			if(f1.getTestCase(i).getTonsillitis().contentEquals("Yes"))
			{
				yesTonsillitisCount++;
			}
			else if(f1.getTestCase(i).getTonsillitis().contentEquals("No"))
			{
				noTonsillitisCount++;
			}	
			
			//------------------
			
			
			//Find prob of aches when have tonsillitis
			if(f1.getTestCase(i).getTemperature().contentEquals("Cool") && f1.getTestCase(i).getTonsillitis().contentEquals("Yes"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
			{
				CoolAndTS++;
			}
			else if(f1.getTestCase(i).getTemperature().contentEquals("Normal") && f1.getTestCase(i).getTonsillitis().contentEquals("Yes"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
			{
				NormAndTS++;
			}
			else if(f1.getTestCase(i).getTemperature().contentEquals("Hot") && f1.getTestCase(i).getTonsillitis().contentEquals("Yes"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
			{
				HotAndTS++;
			}
			
			if(f1.getTestCase(i).getAches().contentEquals("Yes") && f1.getTestCase(i).getTonsillitis().contentEquals("Yes"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
			{
				AchesAndTS++;
			}
			
			if(f1.getTestCase(i).getSoreThroat().contentEquals("Yes") && f1.getTestCase(i).getTonsillitis().contentEquals("Yes"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
			{
				SoreAndTS++;
			}
		}
		System.out.println("cool: "+CoolAndTS);
		System.out.println("norm: "+NormAndTS);
		System.out.println("hot: "+HotAndTS);
		System.out.println("aches: "+AchesAndTS);
		System.out.println("sore: "+SoreAndTS);
/*		
		System.out.println("Patients: "+patientsCount);
		System.out.println("coolTempCount: "+coolTempCount);
		System.out.println("normTempCount: "+normTempCount);
		System.out.println("hotTempCount: "+hotTempCount);
		System.out.println("yesAchesCount: "+yesAchesCount);
		System.out.println("noAchesCount: "+noAchesCount);
		System.out.println("yesSoreCount: "+yesSoreCount);
		System.out.println("noSoreCount: "+noSoreCount);
*/	
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