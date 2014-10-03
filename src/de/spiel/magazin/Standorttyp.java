package de.spiel.magazin;

/*
 * Standorttypen
 * 
 * Benedikt Breitschopf
 */

public enum Standorttyp {

	München(5000, 50),
	Berlin(2000, 40), 
	Walldorf(500, 20);

	

	private double magazinkosten; //Kosten pro Runde
	private int maxMitarbeiter;
	
	private Standorttyp(double Magazinkosten,  int maxMitarbeiter){ 

		this.magazinkosten = magazinkosten;;
		this.maxMitarbeiter = maxMitarbeiter;
	}
	
	public double getMagazinkosten() {
		return magazinkosten;
	}
	
	public int getMaxMitarbeiter() {
		return maxMitarbeiter;
	}
	
	
}
