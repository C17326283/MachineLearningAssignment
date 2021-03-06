/*This class takes  in 3 symptom values and get an estimate of their probability to have tonsillitis, it also contains the method to find the accuracy of the system
 * The constructor uses the 3 entered symptoms, makes a list of testcases form the file then counts all the needed variables and uses them in the maths
 *findAccuracy breaks the list into 2 lists of 70% and 30% then uses the object in that 30% to check the against the 70% and see if the system guessed right
 *
 */
package com.assignment.machinelearning;

import java.util.ArrayList;

public class FindProbability 
{
	//Make variables//////////
	private float patientsCount = 0;//the amount of training patients//These vars are only used in this class so i dont use getters and setters.
	
	private float yesTonsillitisCount = 0;//People with tonsillitis
	private float noTonsillitisCount = 0;//People without tonsillitis
	
	private float tempWithTS;//Have temperature and Tonsillitis
	private float achesWithTS;//Have aches and Tonsillitis
	private float soreWithTS;//Have sore throat and Tonsillitis
	private float tempWithoutTS;//Have temperature and don't have Tonsillitis
	private float achesWithoutTS;//Have aches and don't have Tonsillitis
	private float soreWithoutTS;//Have sore throat and don't have Tonsillitis

	private String temp;//The inputed symptoms
	private String aches;
	private String sore;
	
	private float yesTotal;//The multiplication of each entered symptoms likeliness to cause tonsillitis by how many people have it out of everyone
	private float noTotal;//The multiplication of each entered symptoms likeliness not to cause tonsillitis by how many people dont have it out of everyone
	private float yesAndNoSum;//Adding the two likliness's of having and not having, used to multiply
	private float probabilityOfHavingTS;//Multiplication of yesTotal by yesAndNoSum. gives percent chance of having
	private float probabilityOfNotHavingTS;//Multiplication of noTotal by yesAndNoSum.  gives percent chance of nop having
	
	private ArrayList<Patient> trainingCaseList = new ArrayList<Patient>();//Make arraylist to store all the patient objects
	
	//Constructor//////////
	public FindProbability(String temp, String aches, String sore)//Catches and currently renames
	{
		this.temp = temp;
		this.aches = aches;
		this.sore = sore;
		
		FileProcessor fp = new FileProcessor(Control.getChosenFile());//Constructs a file processor object which just assigns the filename
		fp.openFile();
		trainingCaseList = fp.readFile();//fills array list from file. make new one here instead of calling across classes
		fp.closeFile();
		
		countList();//Fills all the neccesary variables with the number of times it showed up in the file//In gui because always do
		calculate();//Uses the counts to calculate the chances of having and not having Tonsillitis
	}
	
	public void countList()//Goes through file and counts up all the values needed based on user input
	{
		//Need to reset all variable 
		patientsCount = 0;
		yesTonsillitisCount = 0;
		noTonsillitisCount = 0;
		tempWithTS = 0;
		achesWithTS = 0;
		soreWithTS = 0;
		tempWithoutTS = 0;
		achesWithoutTS = 0;
		soreWithoutTS = 0;
		//Don't need to reset maths variables since they are assigned a new number anyways
		
		patientsCount = trainingCaseList.size();//How many lines in file is amount of patients made
		
		for(int i=0; i <  trainingCaseList.size(); i++)//count all the values in every object//TCL.size just returns the amount of lines in arraylist
		{
			//amount of people with tonsillitis
			if(trainingCaseList.get(i).getTonsillitis().contentEquals("Yes"))//if tonsillitis column has yes
			{
				yesTonsillitisCount++;
			}
			else if(trainingCaseList.get(i).getTonsillitis().contentEquals("No"))
			{
				noTonsillitisCount++;
			}	
			
			//TEMPS
			//If input matches column in table and they have tonsillitis//only trying to get the inputed temps where they have tonsillitis out of all people with tonsillitis
			if(trainingCaseList.get(i).getTemperature().contentEquals(temp) && trainingCaseList.get(i).getTonsillitis().contentEquals("Yes"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
			{
				tempWithTS++;
			}
			else if(trainingCaseList.get(i).getTemperature().contentEquals(temp) && trainingCaseList.get(i).getTonsillitis().contentEquals("No"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
			{
				tempWithoutTS++;
			}
			
			//ACHES
			if(trainingCaseList.get(i).getAches().contentEquals(aches) && trainingCaseList.get(i).getTonsillitis().contentEquals("Yes"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
			{
				achesWithTS++;//aches is not yes aches its just the inputed result for aches
			}
			else if(trainingCaseList.get(i).getAches().contentEquals(aches) && trainingCaseList.get(i).getTonsillitis().contentEquals("No"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
			{
				achesWithoutTS++;
			}
			
			//SORE THROAT
			if(trainingCaseList.get(i).getSoreThroat().contentEquals(sore) && trainingCaseList.get(i).getTonsillitis().contentEquals("Yes"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
			{
				soreWithTS++;
			}
			else if(trainingCaseList.get(i).getSoreThroat().contentEquals(sore) && trainingCaseList.get(i).getTonsillitis().contentEquals("No"))//get single object(f1.getTestCase(i)) of testcase  then get temp and check if it says the word
			{
				soreWithoutTS++;
			}
		}//end for
	}
	public void calculate()
	{
		yesTotal = (tempWithTS/yesTonsillitisCount)*(achesWithTS/yesTonsillitisCount)*(soreWithTS/yesTonsillitisCount)*(yesTonsillitisCount/patientsCount);
		noTotal = (tempWithoutTS/noTonsillitisCount)*(achesWithoutTS/noTonsillitisCount)*(soreWithoutTS/noTonsillitisCount)*(noTonsillitisCount/patientsCount);
		yesAndNoSum = yesTotal + noTotal;
		probabilityOfHavingTS = Math.round((yesTotal / yesAndNoSum)*100);//multiply by 100 then round to get actual percent
		probabilityOfNotHavingTS = Math.round((noTotal / yesAndNoSum)*100);//multiply by 100 then round to get actual percent
		
		//Prints for testing
/*		System.out.println("----------------------------------------------");
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
*/	}
	
	public float FindAccuracy()//Catches and currently renames
	{
		ArrayList<Patient> testingCaseList = new ArrayList<Patient>();//Make new arraylist for values to later test
		int testDataSplit;//these are only used in the method
		float correctGuesses = 0;
		float Accuracy = 0;
		
		FileProcessor fp = new FileProcessor(Control.getChosenFile());//Constructs a fileprocessor object which just assigns the filename
		fp.openFile();//open just to get array from file
		trainingCaseList = fp.readFile();//fills array list from file. make new one here instead of calling across classes//Makes with 100% of values.
		fp.closeFile();
		
		testDataSplit = (int) Math.round(trainingCaseList.size() * .70);//Gives a number to split the file at//Need to do 
		
		//Stay at the split and for every object after that it moves into the same position of split, add it to the other list and remove it from this one.
		int i = testDataSplit;
		//Look at the place after the 70% split, move that object into other list and remove from this, repeat until no more
		while(testDataSplit != trainingCaseList.size())//done it this way because i didn't want test data to go in backward
		{
			testingCaseList.add(trainingCaseList.get(i));//Adds last 30% of old training list to new testing list
			trainingCaseList.remove(i);//removes last 30% of objects from array
		}
		
		//Uses all of the new test cases and test against the 70% of traingCaseList.
		for(i = 0; i<testingCaseList.size(); i++)
		{
			temp = testingCaseList.get(i).getTemperature();//Need to assign the symptoms of the test patients to check
			aches = testingCaseList.get(i).getAches();
			sore = testingCaseList.get(i).getSoreThroat();
			
			countList();//Fills all the neccesary variables with the number of times it showed up in the training list//In gui because always do
			calculate();//Uses the counts to calculate the chances of having and not having Tonsillitis based on 
			
			if(getProbabilityOfHavingTS() >= 50)//If the chance is over 50 then the machine thinks they have it
			{
				if(testingCaseList.get(i).getTonsillitis().equals("Yes"))//Checks if the machine guess matches up to the answer
				{
					correctGuesses++;//only increment correct, don't need incorrect
				}
			}
			else if(getProbabilityOfHavingTS() < 50)
			{
				if(testingCaseList.get(i).getTonsillitis().equals("No"))
				{
					correctGuesses++;
				}
			}
		}
		//Find accuracy and return
		Accuracy = ((correctGuesses/testingCaseList.size())*100);//amount of correct guesses over total guesses * 100 = the accuracy
		return Accuracy;
	}
	
	public String toString()
	{
		String result = ("Probability of having Tonsillitis: " +(int)probabilityOfHavingTS+"%"+"\nProbability of not having Tonsillitis: "+(int)probabilityOfNotHavingTS+"%");
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

	public float getProbabilityOfNotHavingTS() {
		return probabilityOfNotHavingTS;
	}

	public void setProbabilityOfNotHavingTS(float probabilityOfNotHavingTS) {
		this.probabilityOfNotHavingTS = probabilityOfNotHavingTS;
	}
}

/*
Naive bayes considers each feature independently(naive) to find a probability
uses the maximum likelihood
P(A|B) probability A occurs given that b is true
P(A) and  P(B) separate probabilities of each
first get the probability of all yes's and no's whiel they have tonsillitis or and then not
In sample data: 18 patient

So the formula for probability of having TS:
all(probability of symptom given TS)(has TS/all patients) = x
all(probability of symptom given no TS)(not have TS/all patients) = y
x + y = z
x/z = probability of having
*/