 package com.assignment.machinelearning;


public class Patient 
{
	//Attributes/////////
	private String temperature;
	private String aches;
	private String soreThroat;
	private String tonsillitis;
	
	//Constructor/////////
	public Patient(String temperature, String aches, String soreThroat, String tonsillitis)
	{//use getters and setters
		this.setTemperature(temperature);
		this.setAches(aches);
		this.setSoreThroat(soreThroat);
		this.setTonsillitis(tonsillitis);
	}
	
	//Methods//////////
	public String toString()
	{
		return("Temp:" +getTemperature()+" Aches:"+getAches()+" SoreThroat:"+getSoreThroat()+" Tonsilitis: "+getTonsillitis());
	}

	
	//Getters and Setters/////////////////
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getAches() {
		return aches;
	}
	public void setAches(String aches) {
		this.aches = aches;
	}
	public String getSoreThroat() {
		return soreThroat;
	}
	public void setSoreThroat(String soreThroat) {
		this.soreThroat = soreThroat;
	}
	public String getTonsillitis() {
		return tonsillitis;
	}
	public void setTonsillitis(String tonsillitis) {
		this.tonsillitis = tonsillitis;
	}
}

