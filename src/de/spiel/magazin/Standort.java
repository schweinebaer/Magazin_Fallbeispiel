package de.spiel.magazin;

import java.util.Vector;


public abstract class Standort {
	private final static String standort1 = "München";
	private final static double magazinkosten1 = 5000.0;
	private final static int maxMitarbeiter1 = 50;
	
	private final static String standort2 = "Berlin";
	private final static double magazinkosten2 = 2000;
	private final static int maxMitarbeiter2 = 40;
	
	private final static String standort3 = "Walldorf";
	private final static double magazinkosten3 = 500;
	private final static int maxMitarbeiter3 = 20;
	
	private Standorttyp name;
	private double magazinkosten;
	private int maxMitarbeiter;

	
	public Standort(Standorttyp name) {
		this.name = name;
		setMagazinkosten(name.getMagazinkosten());
		setMaxMitarbeiter(name.getMaxMitarbeiter());
	}
	
	public static Object[] getStandort(int i){
		Object[] o = new Object[3];
		
		if(i == 1){
			o[0] = standort1;
			o[1] = magazinkosten1;
			o[2] = maxMitarbeiter1;
		} else if(i == 2){
			o[0] = standort2;
			o[1] = magazinkosten2;
			o[2] = maxMitarbeiter2;			
		} else if(i == 3){
			o[0] = standort3;
			o[1] = magazinkosten3;
			o[2] = maxMitarbeiter3;
		} else {
			//falscher Standort
			return null;
		}
		
		return o;
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
