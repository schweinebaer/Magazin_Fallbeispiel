package de.spiel.magazin;

public class Gewinn {
	private double gewinnAuflage;
	
	public Gewinn(){
		
	}
	
	public void updateGewinn(double betrag){
		gewinnAuflage = betrag;
	}
	
	public double getGewinn(){
		return gewinnAuflage;
	}
}