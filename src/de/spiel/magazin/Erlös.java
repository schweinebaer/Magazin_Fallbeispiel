package de.spiel.magazin;

public class Erlös {
	private double einnahmenAuflage;
	
	public Erlös(){
		
	}
	
	public void updateErlös(double betrag){
		einnahmenAuflage = betrag;
	}
	
	public double getEinnahmen(){
		return einnahmenAuflage;
	}
}