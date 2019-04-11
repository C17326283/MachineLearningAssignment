package com.assignment.machinelearning;

import java.util.ArrayList;

public class FindProbability 
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
	
	float yesTotal;
	float noTotal;
	float yesAndNoSum;
	float probabilityOfHavingTS;
	float probabilityOfNotHavingTS;
	
	//Constructor//////////
	public FindProbability(String temp, String aches, String sore)//Catches and currently renames
	{
		this.temp = temp;
		this.aches = aches;
		this.sore = sore;
		System.out.print("\n\ntemp is"+this.temp+"     aches is"+aches+"    sore is"+sore);
		countFile();
		calculate();
	}
	
	public void countFile()//Goes through file and counts up all the values needed based on user input
	{
		FileProcessor f1 = new FileProcessor();//Make instance//This makes an arraylist of patient objects to call from
		patientsCount = f1.getTestCaseList().size();//How many lines in file is amount of patients made
		
		
		for(int i=0; i <  f1.getTestCaseList().size(); i++)//count all the values in every object
		{
			//amount of people with tonsillitis
			if(f1.getTestCase(i).getTonsillitis().contentEquals("Yes"))//if tonsillitis column has yes
			{
//works				
				yesTonsillitisCount++;
			}
			else if(f1.getTestCase(i).getTonsillitis().contentEquals("No"))
			{
				noTonsillitisCount++;
			}	
			
			//TEMPS
			//Checks input so it can run the right code without using non relevant variables
			System.out.print("\n\ntemp be: "+temp);
			System.out.print("\ncase i get temp be: "+f1.getTestCase(i).getTemperature());
			
			if(temp.equals("Cool"))
			{
				System.out.print("\n\ndoes find cool\n\n");
				//If temp is cool and they have tonsillitis
				if(f1.getTestCase(i).getTemperature().contentEquals("Cool") && f1.getTestCase(i).getTonsillitis().contentEquals("Yes"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
				{
					tempWithTS++;
				}
				else if(f1.getTestCase(i).getTemperature().contentEquals("Cool") && f1.getTestCase(i).getTonsillitis().contentEquals("No"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
				{
					tempWithoutTS++;
				}
			}
			else if(temp.equals("Normal"))
			{
				System.out.print("\n\ndoes find normal\n\n");
				if(f1.getTestCase(i).getTemperature().contentEquals("Normal") && f1.getTestCase(i).getTonsillitis().contentEquals("Yes"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
				{
					tempWithTS++;
				}
				else if(f1.getTestCase(i).getTemperature().contentEquals("Normal") && f1.getTestCase(i).getTonsillitis().contentEquals("No"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
				{
					tempWithoutTS++;
				}
			}
			else if(temp.equals("Hot"))
			{
				System.out.print("\n\ndoes find hot\n\n");
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
			if(aches.equals("Yes"))
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
			else if(aches.equals("No"))
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
			if(sore.equals("Yes"))
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
			else if(sore.equals("No"))
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
	}
	public void calculate()
	{
		yesTotal = (tempWithTS/yesTonsillitisCount)*(achesWithTS/yesTonsillitisCount)*(soreWithTS/yesTonsillitisCount)*(yesTonsillitisCount/patientsCount);
		noTotal = (tempWithoutTS/noTonsillitisCount)*(achesWithoutTS/noTonsillitisCount)*(soreWithoutTS/noTonsillitisCount)*(noTonsillitisCount/patientsCount);
		yesAndNoSum = yesTotal + noTotal;
		probabilityOfHavingTS = yesTotal / yesAndNoSum;
		probabilityOfNotHavingTS = noTotal / yesAndNoSum;
		
		//Prints for testing
		System.out.println("yesTonsillitisCount: "+yesTonsillitisCount+"\n");
		
		System.out.println("TempWithTSProb: "+tempWithTS+"/"+yesTonsillitisCount+" = "+tempWithTS/yesTonsillitisCount);
		System.out.println("AchesWithTSProb: "+achesWithTS+"/"+yesTonsillitisCount+" = "+achesWithTS/yesTonsillitisCount);
		System.out.println("SoreWithTSProb: "+soreWithTS+"/"+yesTonsillitisCount+" = "+soreWithTS/yesTonsillitisCount+"\n");
		
		System.out.println("TempWithoutTSProb: "+tempWithoutTS+"/"+noTonsillitisCount+" = "+tempWithoutTS/noTonsillitisCount);
		System.out.println("AchesWithoutTSProb: "+achesWithoutTS+"/"+noTonsillitisCount+" = "+achesWithoutTS/noTonsillitisCount);
		System.out.println("SoreWithoutTSProb: "+soreWithoutTS+"/"+noTonsillitisCount+" = "+soreWithoutTS/noTonsillitisCount+"\n");
		
		System.out.println("yesTotal: "+yesTotal);
		System.out.println("noTotal: "+noTotal);
		
		System.out.println("yesAndNoSum: "+yesAndNoSum+"\n");
		
		System.out.println("probabilityOfHavingTS: "+probabilityOfHavingTS);
		System.out.println("probabilityOfNotHavingTS: "+probabilityOfNotHavingTS);
	}

	
	public String toString()
	{
		String result = ("Probability of having Tonsillitis: " + Math.round(probabilityOfHavingTS*100)+"%" +"\nProbability of not having Tonsillitis: "+Math.round(probabilityOfNotHavingTS*100)+"%");
		return result;
	}

	
	
//GETTERS AND SETTERS////////
	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getAches() {
		return aches;
	}

	public void setAches(String aches) {
		this.aches = aches;
	}

	public String getSore() {
		return sore;
	}

	public void setSore(String sore) {
		this.sore = sore;
	}

	public float getProbabilityOfHavingTS() {
		return probabilityOfHavingTS;
	}

	public void setProbabilityOfHavingTS(float probabilityOfHavingTS) {
		this.probabilityOfHavingTS = probabilityOfHavingTS;
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