package de.spiel.magazin;

import java.util.Vector;


public class Standort {
	private final static String standort1 = "München";
	private final static double preis1 = 500000.0;
	private final static double magazinkosten1 = 5000.0;
	private final static int maxMitarbeiter1 = 2000;
	private final static int startMitarbeiter1 = 500;
	private final static double startGehaltMitarbeiter1 = 3100.0;
	private final static double startKostenMitarbeiter1 = 1550000.0;
	private final static int maxAuflage1 = 500000;
	private final static int gedruckteMagazine1 = 500000;
	private final static int abgesetzteMagazine1 = 325000;
	private final static double kostenDruck1 = 65000.0;
	private final static int fwInSeitenProHeft1 = 30;
	private final static int maxSeitenFW1 = 150;
	private final static int ewInAktionen1 = 7;
	private final static double kostenEW1 = 70000;
	private final static int maxEWAktionen1 = 20;
	private final static double preisProHeft1 = 4.0;
	private final static double maxPreisProHeft1 = 8.0;
	private final static double kostenGesamt1 = 1685000.0;
	private final static double erloesVerkauf1 = 1300000.0;
	private final static double erloesFW1 = 150000.0;
	private final static double erloesGesamt1 = 1450000.0;
	private final static double umsatz1 = -235000.0;
	private final static double kapital1 = 7300000.0;
	
	private final static String standort2 = "Berlin";
	private final static double preis2 = 200000.0;
	private final static double magazinkosten2 = 2000.0;
	private final static int maxMitarbeiter2 = 2000;
	private final static int startMitarbeiter2 = 400;
	private final static double startGehaltMitarbeiter2 = 3100.0;
	private final static double startKostenMitarbeiter2 = 1240000.0;
	private final static int maxAuflage2 = 400000;
	private final static int gedruckteMagazine2 = 400000;
	private final static int abgesetzteMagazine2 = 256666;
	private final static double kostenDruck2 = 51333.2;
	private final static int fwInSeitenProHeft2 = 100;
	private final static int maxSeitenFW2 = 150;
	private final static int ewInAktionen2 = 5;
	private final static double kostenEW2 = 50000.0;
	private final static int maxEWAktionen2 = 20;
	private final static double preisProHeft2 = 4.0;
	private final static double maxPreisProHeft2 = 8.0;
	private final static double kostenGesamt2 = 1341333.2;
	private final static double erloesVerkauf2 = 1026664.0;
	private final static double erloesFW2 = 500000.0;
	private final static double erloesGesamt2 = 1526664.0;
	private final static double umsatz2 = 185330.8;
	private final static double kapital2 = 3200000.0;
	
	private final static String standort3 = "Walldorf";
	private final static double preis3 = 50000.0;
	private final static double magazinkosten3 = 500.0;
	private final static int maxMitarbeiter3 = 2000;
	private final static int startMitarbeiter3 = 600;
	private final static double startGehaltMitarbeiter3 = 3100.0;
	private final static double startKostenMitarbeiter3 = 1860000.0;
	private final static int maxAuflage3 = 600000;
	private final static int gedruckteMagazine3 = 600000;
	private final static int abgesetzteMagazine3 = 430000;
	private final static double kostenDruck3 = 86000.0;
	private final static int fwInSeitenProHeft3 = 50;
	private final static int maxSeitenFW3 = 150;
	private final static int ewInAktionen3 = 6;
	private final static double kostenEW3 = 60000.0;
	private final static int maxEWAktionen3 = 20;
	private final static double preisProHeft3 = 4.0;
	private final static double maxPreisProHeft3 = 8.0;
	private final static double kostenGesamt3 = 2006000.0;
	private final static double erloesVerkauf3 = 1720000.0;
	private final static double erloesFW3 = 250000.0;
	private final static double erloesGesamt3 = 1970000.0;
	private final static double umsatz3 = -36000.0;
	private final static double kapital3 = 53600000.0;
	
	private final static String standort4 = "Bonn";
	private final static double preis4 = 50000.0;
	private final static double magazinkosten4 = 500.0;
	private final static int maxMitarbeiter4 = 2000;
	private final static int startMitarbeiter4 = 500;
	private final static double startGehaltMitarbeiter4 = 3100.0;
	private final static double startKostenMitarbeiter4 = 1550000.0;
	private final static int maxAuflage4 = 500000;
	private final static int gedruckteMagazine4 = 500000;
	private final static int abgesetzteMagazine4 = 387500;
	private final static double kostenDruck4 = 77500.0;
	private final static int fwInSeitenProHeft4 = 60;
	private final static int maxSeitenFW4 = 150;
	private final static int ewInAktionen4 = 8;
	private final static double kostenEW4 = 80000.0;
	private final static int maxEWAktionen4 = 20;
	private final static double preisProHeft4 = 4.0;
	private final static double maxPreisProHeft4 = 8.0;
	private final static double kostenGesamt4 = 1707500.0;
	private final static double erloesVerkauf4 = 1550000.0;
	private final static double erloesFW4 = 300000.0;
	private final static double erloesGesamt4 = 1850000.0;
	private final static double umsatz4 = 142500.0;
	private final static double kapital4 = 3600000.0;
	
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
		//Angestellte noch richtig initilisieren --> Gehalt und Qualität ggf. schon in Standortpkt mit einbauen
		angestellte = new Angestellte(mitarbeiter, 3000.0, 50.0);
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
		} else if(i == 4){
			o[0] = standort4;
			o[1] = preis4;
			o[2] = magazinkosten4;
			o[3] = maxMitarbeiter4;
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
