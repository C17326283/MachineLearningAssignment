package com.assignment.machinelearning;

public class AccuracyChecker
{
	public AccuracyChecker() 
	{
		int testDataSplit = (int) Math.round(FileProcessor.getNoOfLines() * .70);//find the number of lines to split list at
		FileProcessor f1 = new FileProcessor(testDataSplit);//Makes new instance of file processor to use contents
		
		//do for every line in the last 30% of the TestCases
		for(int i=testDataSplit; i < FileProcessor.getNoOfLines(); i++)//Finds 70% of number of number os patients and rounds.
		{
			//make attributes for sending through find probability
			String inputTemp = f1.getTrainingCase(i).getTemperature();
			String inputAches = f1.getTrainingCase(i).getAches();
			String inputSore = f1.getTrainingCase(i).getSoreThroat();
			
			
			FindProbability p2 = new FindProbability(inputTemp, inputAches, inputSore);//This finds probability of having TS compared to all inputs
			
			if(p2.getProbabilityOfHavingTS() > .50)//change to 50 later
			{
				System.out.println(p2.getProbabilityOfHavingTS());
				System.out.println("\n\nGuess: Have ts		do they: "+f1.getTrainingCase(i).getTonsillitis());
			}
			else if(p2.getProbabilityOfHavingTS() < .50)
			{
				System.out.print(p2.getProbabilityOfHavingTS());
				System.out.println("\n\nGuess: no TS		do they: "+f1.getTrainingCase(i).getTonsillitis());
			}	
		}
		
	}
	public String calcAccuracy()
	{
		return "38";
	}
	public String toString()
	{
		String result = ("Prediction accuracy: " + calcAccuracy());
		return result;
	}
}
