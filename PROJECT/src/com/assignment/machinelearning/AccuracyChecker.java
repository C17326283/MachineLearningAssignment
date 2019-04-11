package com.assignment.machinelearning;

public class AccuracyChecker
{
	int patientsCount;
	
	public AccuracyChecker() 
	{
		FileProcessor f1 = new FileProcessor();
		int testDataSplit = (int) Math.round(f1.getTestCaseList().size() * .70);
		
		for(int i=testDataSplit; i < f1.getTestCaseList().size(); i++)//Finds 70% of number of number os patients and rounds.
		{
			String inputTemp = f1.getTestCase(i).getTemperature();
			String inputAches = f1.getTestCase(i).getAches();
			String inputSore = f1.getTestCase(i).getSoreThroat();
			FindProbability p2 = new FindProbability(inputTemp, inputAches, inputSore);
			
			if(p2.getProbabilityOfHavingTS() >= .50)//change to 50 later
			{
				System.out.println(p2.getProbabilityOfHavingTS());
				System.out.println("\n		has");
			}
			else if(p2.getProbabilityOfHavingTS() < .50)
			{
				System.out.print(p2.getProbabilityOfHavingTS());
				System.out.println("\n		dont has");
				
			}
		
		}
	}
}
