package de.spiel.magazin;

import java.util.Vector;


public class Standort {
	private String name;
	private double preis;
	private double magazinkosten;
	private int maxMitarbeiter;
	private int mitarbeiter;
	private double gehalt;
	private double kostenMitarbeiter;
	private Angestellte angestellte;
	private int maxAuflage;
	private int gedruckteMagazine;
	private int abgesetzteMenge;
	private double kostenDruck;
	private int fwInSeitenProHeft;
	private int maxSeitenFW;
	private int ewInAktionen;
	private double kostenEW;
	private int maxEWAktionen;
	private double preisProHeft;
	private final double maxPreisProHeft;
	private double kostenGesamt;
	private double erloesVerkauf;
	private double erloesFW;
	private double erloesGesamt;
	private double umsatz;
	private double kapital;
	private static StandortDaten anfangswerteStandorte;
	
	public Standort(String name, double preis, double kosten, int maxMitarbeiter, int mitarbeiter) {
		anfangswerteStandorte = new StandortDaten();
		maxPreisProHeft = 8.0;
		
		this.name = name;
		this.preis = preis;
		this.magazinkosten = kosten;
		this.maxMitarbeiter = 2000;
		this.mitarbeiter = mitarbeiter;
		//Angestellte noch richtig initilisieren --> Gehalt und Qualität ggf. schon in Standortpkt mit einbauen
		angestellte = new Angestellte(mitarbeiter, 3000.0, 50.0);
	}
	
	public static Object[] getStandort(int i){
		return anfangswerteStandorte.getStandorte(i);
	}
	
	public static double getPreis(String name){
		Object[] o;
		if(name.equals("München")){
			o = anfangswerteStandorte.getStandorte(1);
			return (double) o[2];
		} else if(name.equals("Berlin")){
			o = anfangswerteStandorte.getStandorte(2);
			return (double) o[2];
		} else if(name.equals("Walldorf")){
			o = anfangswerteStandorte.getStandorte(3);
			return (double) o[2];
		} else if(name.equals("Bonn")){
			o = anfangswerteStandorte.getStandorte(4);
			return (double) o[2];
		}
		
		return 0;
	}
	
	public String getOrt(){
		return name;
	}
	
	public void simulieren(String art, double betrag){
		//einstellen, entlassen, schulen etc.
		if(art.equals("MITARBEITER_EINSTELLEN")){
			angestellte.einstellen((int) betrag);
		} else if(art.equals("MITARBEITER_ENTLASSEN")){
			angestellte.entlassen((int) betrag); 
		} else {
			//ignore
		}
	}

	public int getMaxMitarbeiter(int maxMitabeiter) {
		return maxMitarbeiter;
	}
	
	public int[] getMitarbeiter(){
		return angestellte.getBereichsZahlen();
	}
}
