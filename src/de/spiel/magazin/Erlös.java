package de.spiel.magazin;

public class Erl�s {
	private double einnahmenAuflage;
	
	public Erl�s(){
		
	}
	
	public void updateErl�s(double betrag){
		einnahmenAuflage = betrag;
	}
	
	public double getEinnahmen(){
		return einnahmenAuflage;
	}
}