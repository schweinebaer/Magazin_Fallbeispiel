package de.spiel.magazin;

import java.io.PrintWriter;


/*
 * Organisation des Magazins
 */

public class Magazin {
	private Standort standort;
	private Werbung eigenwerbung;
	private Werbung fremdwerbung;
	private Marktanteil marktanteil;
	private int auflage;
	private Erloes erloes;
	private Kosten kosten;
	private Umsatz umsatzMagazin;
	private double qualitaet;
	private PrintWriter writer;
	
	private double prozentsatzFW;
	private double prozentsatzEW;
	private double prozentsatzAngestellte;
	private double prozentsatzPreis;
	
	private double magazinkosten;
	private final int maxMitarbeiter;
	private int mitarbeiter;
	private double gehalt;
	private double kostenMitarbeiter;
	private Angestellte angestellte;
	private final int maxAuflage;
	private int gedruckteMagazine;
	private int abgesetzteMenge;
	private double kostenDruck;
	private int fwInSeitenProHeft;
	private final int maxSeitenFW;
	private int ewInAktionen;
	private double kostenEW;
	private final int maxEWAktionen;
	private double preisProHeft;
	private final double maxPreisProHeft;
	private double kapital;
	private double kostenFix;

	public Magazin(Standort standort, Object[] standortDaten, Marktanteil marktanteil, PrintWriter writer) {
		Object[] o = standortDaten;
		
		this.standort = standort;
		this.marktanteil = marktanteil;
		this.writer = writer;
		
		/*
		magazinkosten = (double) o[2];
		*/
		maxMitarbeiter = (int) o[3];
		/*
		mitarbeiter = (int) o[4];
		gehalt = (double) o[5];
		kostenMitarbeiter = (double) o[6];
		*/
		maxAuflage = (int) o[7];
		gedruckteMagazine = (int) o[8];
		abgesetzteMenge = (int) o[9];
		kostenDruck = (double) o[10];
		fwInSeitenProHeft = (int) o[11];
		maxSeitenFW = (int) o[12];
		ewInAktionen = (int) o[13];
		kostenEW = (double) o[14];
		maxEWAktionen = (int) o[15];
		preisProHeft = (double) o[16];
		maxPreisProHeft = (double) o[17];
		kapital = (double) o[23];
		
		qualitaetInit();
		
		angestellte = new Angestellte((int) o[3], (int) o[4], (double) o[5], qualitaet);
		
		erloes = new Erloes((int) o[9], (double) o[16], (double) o[19], (double) o[20], (double) o[21]);
		kosten = new Kosten((int) o[8], (int) o[9], (double) o[10], (double) o[6], (double) o[14], (double) o[24],(double) o[18]);
		umsatzMagazin = new Umsatz(erloes.getGesamtErloes(), kosten.getGesamtKosten());
		
		eigenwerbung = new Werbung(0, (int) o[13], (int) o[15], 0);
		fremdwerbung = new Werbung(1, (int) o[11], (int) o[12], (int) o[8]);
	}

	public Standort getStandort(){
		return standort;
	}
	
	private void qualitaetInit(){
		if(ewInAktionen == 10){
			prozentsatzEW = 100.0;
		} else if(ewInAktionen < 10 && ewInAktionen > 0){
			prozentsatzEW = ewInAktionen / 10;
		} else if(ewInAktionen > 10){
			prozentsatzEW = (10 - (ewInAktionen - 10)) / 10;
		}
		
		if(fwInSeitenProHeft == 30){
			prozentsatzFW = 100.0;
		} else if(fwInSeitenProHeft < 30 && fwInSeitenProHeft > 0){
			prozentsatzFW = fwInSeitenProHeft / 30;
		} else if(fwInSeitenProHeft > 30){
			prozentsatzFW = (30 - (fwInSeitenProHeft - 30)) / 30;
		}
		
		if(mitarbeiter == 1000){
			prozentsatzAngestellte = 100.0;
		} else if(mitarbeiter < 1000 && mitarbeiter > 0){
			prozentsatzAngestellte = mitarbeiter / 1000;
		} else if(mitarbeiter > 1000){
			prozentsatzAngestellte = (1000 - (mitarbeiter - 1000)) / 1000;
		}
		
		if(preisProHeft >= 3.8 && preisProHeft <= 4.2){
			prozentsatzPreis = 100.0;
		} else if(preisProHeft < 3.8 && preisProHeft > 0){
			prozentsatzPreis = preisProHeft / 3.8;
		} else if(preisProHeft > 4.2){
			prozentsatzPreis = (4.2 - (preisProHeft - 4.2)) / 4.2;
		}
		
		qualitaet = (prozentsatzEW + prozentsatzFW + prozentsatzAngestellte + prozentsatzPreis) / 4;
	}
	
	public void updateQualitaet(){
		if(ewInAktionen == 10){
			prozentsatzEW = 100.0;
		} else if(ewInAktionen < 10 && ewInAktionen > 0){
			prozentsatzEW = ewInAktionen / 10;
		} else if(ewInAktionen > 10){
			prozentsatzEW = (10 - (ewInAktionen - 10)) / 10;
		}
		
		if(fwInSeitenProHeft == 30){
			prozentsatzFW = 100.0;
		} else if(fwInSeitenProHeft < 30 && fwInSeitenProHeft > 0){
			prozentsatzFW = fwInSeitenProHeft / 30;
		} else if(fwInSeitenProHeft > 30){
			prozentsatzFW = (30 - (fwInSeitenProHeft - 30)) / 30;
		}
		
		if(angestellte.getAnzahlAngestellte() == 1000){
			prozentsatzAngestellte = 100.0;
		} else if(angestellte.getAnzahlAngestellte() < 1000 && angestellte.getAnzahlAngestellte() > 0){
			prozentsatzAngestellte = angestellte.getAnzahlAngestellte() / 1000;
		} else if(angestellte.getAnzahlAngestellte() > 1000){
			prozentsatzAngestellte = (1000 - (angestellte.getAnzahlAngestellte() - 1000)) / 1000;
		}
		
		prozentsatzAngestellte += angestellte.getQualitaet();
		
		if(preisProHeft >= 3.8 && preisProHeft <= 4.2){
			prozentsatzPreis = 100.0;
		} else if(preisProHeft < 3.8 && preisProHeft > 0){
			prozentsatzPreis = preisProHeft / 3.8;
		} else if(preisProHeft > 4.2){
			prozentsatzPreis = (4.2 - (preisProHeft - 4.2)) / 4.2;
		}
		
		qualitaet = (prozentsatzEW + prozentsatzFW + prozentsatzAngestellte + prozentsatzPreis) / 4;
	}
	
	public void updateMarktanteil(){
		marktanteil.updateAbgesetzteMengeSpieler(abgesetzteMenge);
		marktanteil.berechneAnteilNeu();
	}
	
	public Marktanteil getMarktanteil(){
		return marktanteil;
	}
	
	public void berechnungAbgesetzteMenge(){
		abgesetzteMenge = (int) (gedruckteMagazine * qualitaet);
	}
	
	public void updateEW(int ewAktionen){
		eigenwerbung.updateEW(writer, ewAktionen);
		kosten.updateEWKosten(eigenwerbung.getKosten());
		updateQualitaet();
	}
	
	public Werbung getEW(){
		return eigenwerbung;
	}
	
	public void updateFW(int fwInSeiten){
		fremdwerbung.updateFW(writer, fwInSeiten, auflage);
		erloes.updateFWErloes(fremdwerbung.getEinnahmen());
		updateQualitaet();
	}
	
	public Werbung getFW(){
		return fremdwerbung;
	}
	
	public void updateAuflage(int auflage){
		this.auflage = auflage;
		//Erlös, Gewinn und Kosten und weitere notwenidge Daten updaten
		abgesetzteMenge = (int) (auflage * qualitaet);
		erloes.updateAbgesetzteMagazine(abgesetzteMenge);
		kosten.updateAbgesetzteMag(abgesetzteMenge);
		kosten.updateGedruckteMag(auflage);
		umsatzMagazin.updateErloes(erloes.getGesamtErloes());
		umsatzMagazin.updateKosten(kosten.getGesamtKosten());
		kapital += umsatzMagazin.getUmsatz();
	}
	
	public int getAbgesetzteMagazine(){
		return abgesetzteMenge;
	}
	
	public void updateKostenDruck(int kostenDruck){
		this.kosten.updateDruckKosten(kostenDruck);
		umsatzMagazin.updateKosten(kosten.getGesamtKosten());
		kapital += umsatzMagazin.getUmsatz();
	}
	
	public void updatePreis(int preis){
		if(preis <= maxPreisProHeft && preis >= 0){
			erloes.updatePreisMagazin(preis);
		} else {
			writer.println("Der Preis kann weder negativ noch über dem maximalen Preis von " + maxPreisProHeft + " verkauft werden.");
		}
	}
	
	public void aktualisiereWerte(){
		erloes.aktualisieren();
		kosten.aktualisieren();

		umsatzMagazin.updateErloes(erloes.getGesamtErloes());
		umsatzMagazin.updateKosten(kosten.getGesamtKosten());
	}
	
	public int getMaxMitarbeiter(int maxMitabeiter) {
		return maxMitarbeiter;
	}
	
	public int[] getMitarbeiter(){
		return angestellte.getBereichsZahlen();
	}
	
	public Object[] getAktuelleDaten(){
		umsatzMagazin.updateErloes(erloes.getGesamtErloes());
		umsatzMagazin.updateKosten(kosten.getGesamtKosten());
		
		Object[] o = new Object[8];
		o[0] = standort;
		o[1] = angestellte;
		o[2] = eigenwerbung;
		o[3] = fremdwerbung;
		o[4] = erloes;
		o[5] = kosten;
		o[6] = umsatzMagazin;
		o[7] = qualitaet;
		
		return o;
	}
	
	public void simulieren(String art, double betrag, double betrag2){
		//Zufallsereignisse
		if(art.equals("ABSATZPLUS_EINMALIG") 
			|| art.equals("ABSATZMINUS_EINMALIG")
			|| art.equals("SPENDE_BEKOMMEN")){
			erloes.speziellesErloeseUpdate(art, betrag);
		} else if(art.equals("ROHSTOFFPREISE_ERHOEHEN") || art.equals("ROHSTOFFPREISE_SENKEN")){
			kosten.speziellesKostenUpdate(art, betrag);
		} else if(art.equals("RECHTSSTREIT")){
			kosten.speziellesKostenUpdate(art, betrag);
			erloes.speziellesErloeseUpdate(art, betrag2);
		} else if(art.equals("TARIFVERHANDLUNG")){
			angestellte.aktualisiereGehalt(betrag);
			kosten.speziellesKostenUpdate(art, angestellte.getGehalt() * angestellte.getAnzahlAngestellte());
		} else if(art.equals("QUALITAETSEINBRUCH") || art.equals("JOURNALISTENPREIS")){
			qualitaet *= betrag;
			berechnungAbgesetzteMenge();
			erloes.updateAbgesetzteMagazine(abgesetzteMenge);
		} else if(art.equals("WERBEEINNAHMEN_MINDERUNG")){
			fremdwerbung.updateFW(betrag);
			erloes.updateFWErloes(fremdwerbung.getEinnahmen());
		}	
		
		//Spielereingaben
		if(art.equals("WERBUNG_SCHALTEN")){
			eigenwerbung.updateEW(writer, (int) betrag);
		} else if(art.equals("WERBUNG_MAGAZIN")){
			fremdwerbung.updateFW(writer, (int) betrag, auflage);
		} else if(art.equals("MITARBEITER_EINSTELLEN") || 
				  art.equals("MITARBEITER_ENTLASSEN") ||
				  art.equals("MITARBEITER_SCHULEN")){
			angestellte.simulieren(art, betrag);
			updateQualitaet();
			double kostenAngestellte = angestellte.getAnzahlAngestellte() * angestellte.getGehalt() + angestellte.getAnzahlSchulungen() * angestellte.getAnzahlAngestellte() * 39.99;
			kosten.updatePersonalKosten(kostenAngestellte);
			//genauer nachschauen, wie genau mit Angestellten in Qualität handeln!
		} else if(art.equals("VERKAUFSPREIS_SETZEN")){
			//noch genauer schauen, was genau gemacht werden muss!!!
			if(betrag <= maxPreisProHeft){
				preisProHeft = betrag;
				updateQualitaet();
				berechnungAbgesetzteMenge();
				erloes.updateAbgesetzteMagazine(abgesetzteMenge);
				erloes.updatePreisMagazin(betrag);
			}
		} else if(art.equals("AUFLAGE_SETZEN")){
			updateAuflage((int) betrag);
		} else {
			//ignore
		}
	}
}
