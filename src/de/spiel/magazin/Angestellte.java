package de.spiel.magazin;

import java.io.PrintWriter;

public class Angestellte {
	/*
	 * @author Pascal Pronobis
	 * @description Generelle Koordination der Angestellten eines Magazins 
	 */
	
	//Allgemeine Daten, die zu den Angestellten gespeichert werden müssen
	private int maxAnzahlGesamt;
	private int anzahlGesamt;
	private int anzahlHR;
	private int anzahlJournalisten;
	private double gehalt;
	private int durchgefuehrteSchulungen;
	private double qualitaet;
	private PrintWriter writer;
	
	public Angestellte(PrintWriter writer, int maxAnzahlGesamt, int anzahlGesamt, double gehalt, double qualitaet){
		//für die Ausgabe für den Erfolg oder Misserfolg von Aktionen, die Mitarbeiter betreffen
		this.writer = writer;
		
		//Rahmenbedingungen für Angestelltenanzahl
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
			//wenn man es durchführen darf
			//Mitarbeiterzahl erhöhen
			anzahlGesamt += anzahl;
			
			//auf Bereiche aufteilen
			anzahlHR += (int) anzahl * 1/6;
			anzahlJournalisten += (int) anzahl * 5/6;
			
			//Erfolgsmeldung ausgeben 
			writer.println("Sie haben " + anzahl + " Mitarbeiter eingestellt.");
		} else {
			//wenn man es nicht duchführen darf
			//Fehlermeldung
			writer.println("Es konnten keine Mitarbeiter eingestellt werden. Überprüfen Sie Ihre Eingabe.");
		}
	}
	
	public void entlassen(int anzahl){
		//anzahl Mitarbeiter entlassen
		if((anzahlGesamt - anzahl) <= 0){
			//wenn man es durchführen darf und die Zahl der zu entlassenden Mitarbeiter größer als die angestellten Miatrbeiter ist
			//Gesamtanzahl auf 0 setzen
			anzahlGesamt = 0;
			
			//Bereiche auf 0 setzen und Anzahl der entlassenen Personen angeben
			anzahlHR = 0;
			anzahlJournalisten = 0;
			writer.println("Sie haben " + (anzahl - (anzahlGesamt - anzahl)) + " Mitarbeiter entlassen.");
		} else {
			//wenn man es durchführen darf und die Zahl der zu entlassenden Mitarbeiter kleiner als die angestellten Mitarbeiter ist
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
		//Schulungen durchführen
		if(durchgefuehrteSchulungen >= 0 && durchgefuehrteSchulungen < 5){
			//wenn die bisher durchgeführen Schulungen zwischen (inkl.) 0 bis (exkl.) 5 liegt
			//dann Schulung durchführen, Qualität updaten und Erfolgsnachricht ausgeben
			durchgefuehrteSchulungen++;
			qualitaet = durchgefuehrteSchulungen * 0.03;
			writer.println("Sie haben Ihre Mitarbeiter um eine Aktion geschult.");
		} else {
			//Fehlermeldung ausgeben
			System.out.println("Sie haben bereits maximal geschult.");
		}
	}
	
	public int getAnzahlSchulungen(){
		//durchgeführte Schulungen zurückgeben
		return durchgefuehrteSchulungen;
	}
	
	public void aktualisiereGehalt(double betrag){
		//Gehalt aktualisieren
		gehalt *= betrag;
	}
	
	public double getGehalt(){
		//Gehalt zurückliefern
		return gehalt;
	}
	
	public int[] getBereichsZahlen(){
		//Bereichszahlen zurückgeben
		int[] tmp = new int[2];
		tmp[0] = anzahlHR;
		tmp[1] = anzahlJournalisten;
		return tmp;
	}
	
	public int getAnzahlAngestellte(){
		//Gesamtanzahl Mitarbeiter zurückliefern
		return anzahlGesamt;
	}

	public double getQualitaet(){
		//Qualität zurückliefern
		return qualitaet;
	}
	
	public void simulieren(String art, double betrag){
		//Simulation bearbeiten und durchführen
		
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
