package de.spiel.magazin;

import java.util.Vector;


public class Standort {
	private final static String standort1 = "München";
	private final static double preis1 = 500000.0;
	private final static double magazinkosten1 = 5000.0;
	private final static int maxMitarbeiter1 = 50;
	
	private final static String standort2 = "Berlin";
	private final static double preis2 = 200000.0;
	private final static double magazinkosten2 = 2000.0;
	private final static int maxMitarbeiter2 = 40;
	
	private final static String standort3 = "Walldorf";
	private final static double preis3 = 50000.0;
	private final static double magazinkosten3 = 500.0;
	private final static int maxMitarbeiter3 = 20;
	
	private String name;
	private double preis;
	private double magazinkosten;
	private int maxMitarbeiter;
	private int mitarbeiter;
	private Angestellte angestellte;

	public Standort(String name, double preis, double kosten, int maxMitarbeiter, int mitarbeiter) {
		this.name = name;
		this.preis = preis;
		this.magazinkosten = kosten;
		this.maxMitarbeiter = maxMitarbeiter;
		this.mitarbeiter = mitarbeiter;
		//Angestellte noch initilisieren
	}
	
	public static Object[] getStandort(int i){
		Object[] o = new Object[4];
		
		if(i == 1){
			o[0] = standort1;
			o[1] = preis1;
			o[2] = magazinkosten1;
			o[3] = maxMitarbeiter1;
		} else if(i == 2){
			o[0] = standort2;
			o[1] = preis2;
			o[2] = magazinkosten2;
			o[3] = maxMitarbeiter2;			
		} else if(i == 3){
			o[0] = standort3;
			o[1] = preis3;
			o[2] = magazinkosten3;
			o[3] = maxMitarbeiter3;
		} else {
			//falscher Standort
			return null;
		}
		
		return o;
	}
	
	public static double getPreis(String name){
		if(name.equals("München")){
			return preis1;
		} else if(name.equals("Berlin")){
			return preis2;
		} else if(name.equals("Walldorf")){
			return preis3;
		}
		
		return 0;
	}
	
	public String getOrt(){
		return name;
	}
	
	public void simulieren(String art, double betrag){
		//einstellen, entlassen, schulen etc.
	}

	public int getMaxMitarbeiter(int maxMitabeiter) {
		return maxMitarbeiter;
	}
	
	public int[] getMitarbeiter(){
		return angestellte.getBereichsZahlen();
	}
}
