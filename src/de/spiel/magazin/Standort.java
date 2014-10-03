package de.spiel.magazin;

import java.util.Vector;


public class Standort {
	private Standorttyp name;
	private double magazinkosten;
	private int maxMitarbeiter;

	
public Standort(Standorttyp name) {
	this.name = name;
	setMagazinkosten(name.getMagazinkosten());
	setMaxMitarbeiter(name.getMaxMitarbeiter());
	}


private void setMagazinkosten(double magazinkosten) {
	this.magazinkosten = magazinkosten;
	
}

private void setMaxMitarbeiter(int maxMitarbeiten) {
	this.maxMitarbeiter = maxMitarbeiten;
	
}	

public int getMaxMitarbeiter(int maxMitabeiter) {
	return maxMitarbeiter;
}

}
