package de.spiel.magazin;

import java.io.PrintWriter;

public class Angestellte {
	/*
	 * @author Pascal Pronobis
	 * @description Generelle Koordination der Angestellten eines Magazins 
	 */
	
	//Allgemeine Daten, die zu den Angestellten gespeichert werden m�ssen
	private int maxAnzahlGesamt;
	private int anzahlGesamt;
	private int anzahlHR;
	private int anzahlJournalisten;
	private double gehalt;
	private int durchgefuehrteSchulungen;
	private double qualitaet;
	private PrintWriter writer;
	
	public Angestellte(PrintWriter writer, int maxAnzahlGesamt, int anzahlGesamt, double gehalt, double qualitaet){
		//f�r die Ausgabe f�r den Erfolg oder Misserfolg von Aktionen, die Mitarbeiter betreffen
		this.writer = writer;
		
		//Rahmenbedingungen f�r Angestelltenanzahl
		this.maxAnzahlGesamt = maxAnzahlGesamt;
		this.anzahlGesamt = anzahlGesamt;
		
		//Angestellte auf Bereiche verteilen
		anzahlHR = (int) Math.round(anzahlGesamt * 1/6);
		anzahlJournalisten = anzahlGesamt - anzahlHR;
		
		//weitere Rahmenbedinungen setzen
		this.gehalt = gehalt;
		durchgefuehrteSchulungen = 0;
		this.qualitaet = qualitaet;
	}
	
	public void einstellen(int anzahl){
		//anzahl Mitarbeiter einstellen
		if((anzahl + anzahlGesamt) <= maxAnzahlGesamt){
			//wenn man es durchf�hren darf
			//Mitarbeiterzahl erh�hen
			anzahlGesamt += anzahl;
			
			//auf Bereiche aufteilen
			anzahlHR += (int) anzahl * 1/6;
			anzahlJournalisten += (int) anzahl * 5/6;
			
			//Erfolgsmeldung ausgeben 
			writer.println("Sie haben " + anzahl + " Mitarbeiter eingestellt.");
		} else {
			//wenn man es nicht duchf�hren darf
			//Fehlermeldung
			writer.println("Es konnten keine Mitarbeiter eingestellt werden. �berpr�fen Sie Ihre Eingabe.");
		}
	}
	
	public void entlassen(int anzahl){
		//anzahl Mitarbeiter entlassen
		if((anzahlGesamt - anzahl) <= 0){
			//wenn man es durchf�hren darf und die Zahl der zu entlassenden Mitarbeiter gr��er als die angestellten Miatrbeiter ist
			//Gesamtanzahl auf 0 setzen
			anzahlGesamt = 0;
			
			//Bereiche auf 0 setzen und Anzahl der entlassenen Personen angeben
			anzahlHR = 0;
			anzahlJournalisten = 0;
			writer.println("Sie haben " + (anzahl - (anzahlGesamt - anzahl)) + " Mitarbeiter entlassen.");
		} else {
			//wenn man es durchf�hren darf und die Zahl der zu entlassenden Mitarbeiter kleiner als die angestellten Mitarbeiter ist
			//Gesamtanzahl um anzahl vermindern
			anzahlGesamt -= anzahl;
			
			//Bereiche aktualisieren
			anzahlHR = (int) ((double) anzahlGesamt * 1/6);
			anzahlJournalisten = anzahlGesamt  - anzahlHR;
			
			//Erfolgsnachricht ausgeben
			writer.println("Sie haben " + anzahl + " Mitarbeiter entlassen.");
		}
	}
	
	public void schulen(){
		//Schulungen durchf�hren
		if(durchgefuehrteSchulungen >= 0 && durchgefuehrteSchulungen < 5){
			//wenn die bisher durchgef�hren Schulungen zwischen (inkl.) 0 bis (exkl.) 5 liegt
			//dann Schulung durchf�hren, Qualit�t updaten und Erfolgsnachricht ausgeben
			durchgefuehrteSchulungen++;
			qualitaet = durchgefuehrteSchulungen * 0.03;
			writer.println("Sie haben Ihre Mitarbeiter um eine Aktion geschult.");
		} else {
			//Fehlermeldung ausgeben
			System.out.println("Sie haben bereits maximal geschult.");
		}
	}
	
	public int getAnzahlSchulungen(){
		//durchgef�hrte Schulungen zur�ckgeben
		return durchgefuehrteSchulungen;
	}
	
	public void aktualisiereGehalt(double betrag){
		//Gehalt aktualisieren
		gehalt *= betrag;
	}
	
	public double getGehalt(){
		//Gehalt zur�ckliefern
		return gehalt;
	}
	
	public int[] getBereichsZahlen(){
		//Bereichszahlen zur�ckgeben
		int[] tmp = new int[2];
		tmp[0] = anzahlHR;
		tmp[1] = anzahlJournalisten;
		return tmp;
	}
	
	public int getAnzahlAngestellte(){
		//Gesamtanzahl Mitarbeiter zur�ckliefern
		return anzahlGesamt;
	}

	public double getQualitaet(){
		//Qualit�t zur�ckliefern
		return qualitaet;
	}
	
	public void simulieren(String art, double betrag){
		//Simulation bearbeiten und durchf�hren
		
		if(art.equals("MITARBEITER_EINSTELLEN")){
			einstellen((int) betrag);
		} else if(art.equals("MITARBEITER_ENTLASSEN")){
			entlassen((int) betrag);
		} else if(art.equals("MITARBEITER_SCHULEN")){
			schulen();
		} else {
			//ignore
		}
	}
}
