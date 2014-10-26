package de.spiel.magazin;

import java.io.PrintWriter;

public class Angestellte {
	/*
	 * @author Pascal Pronobis
	 * @description Generelle Koordination der Angestellten eines Magazins 
	 */
	
	private int maxAnzahlGesamt;
	private double anzahlGesamt;
	private int anzahlHR;
	private int anzahlJournalisten;
	private double gehalt;
	private int durchgefuehrteSchulungen;
	private double qualitaet;
	private PrintWriter writer;
	
	public Angestellte(PrintWriter writer, int maxAnzahlGesamt, int anzahlGesamt, double gehalt, double qualitaet){
		this.writer = writer;
		
		this.maxAnzahlGesamt = maxAnzahlGesamt;
		this.anzahlGesamt = anzahlGesamt;
		
		anzahlHR = (int) Math.round(this.anzahlGesamt * 1/6);
		anzahlJournalisten = (int) Math.round(this.anzahlGesamt * 5/6);

		this.gehalt = gehalt;
		durchgefuehrteSchulungen = 0;
		this.qualitaet = qualitaet;
	}
	
	public boolean einstellen(int anzahl){
		if((anzahl + anzahlGesamt) <= maxAnzahlGesamt){
			anzahlGesamt += anzahl;
			
			anzahlHR += (int) anzahl * 1/6;
			anzahlJournalisten += (int) anzahl * 5/6;
			
			writer.println("Sie haben " + anzahl + " Mitarbeiter eingestellt.");
			return true;
		} else {
			writer.println("Es konnten keine Mitarbeiter eingestellt werden. Überprüfen Sie Ihre Eingabe.");
			return false;
		}
	}
	
	public void entlassen(int anzahl){
		if((anzahlGesamt - anzahl) <= 0){
			anzahlGesamt = 0;
			
			anzahlHR = 0;
			anzahlJournalisten = 0;
			writer.println("Sie haben " + (anzahl - (anzahlGesamt - anzahl)) + " Mitarbeiter entlassen.");
		} else {
			anzahlGesamt -= anzahl;
			
			anzahlHR -= (int) anzahl * 1/6;
			anzahlJournalisten -= (int) anzahl * 5/6;
			
			writer.println("Sie haben " + anzahl + " Mitarbeiter entlassen.");
		}
	}
	
	public void schulen(){
		if(durchgefuehrteSchulungen >= 0 && durchgefuehrteSchulungen < 5){
			durchgefuehrteSchulungen++;
			qualitaet = durchgefuehrteSchulungen * 0.03;
			writer.println("Sie haben Ihre Mitarbeiter um eine Aktion geschult.");
		} else {
			System.out.println("Sie haben bereits maximal geschult");
		}
	}
	
	public int getAnzahlSchulungen(){
		return durchgefuehrteSchulungen;
	}
	
	public void aktualisiereGehalt(double betrag){
		gehalt *= betrag;
	}
	
	public int[] getBereichsZahlen(){
		int[] tmp = new int[2];
		tmp[0] = anzahlHR;
		tmp[1] = anzahlJournalisten;
		return tmp;
	}
	
	public int getAnzahlAngestellte(){
		return (int) anzahlGesamt;
	}
	
	public double getGehalt(){
		return gehalt;
	}
	
	public double getQualitaet(){
		return qualitaet;
	}
	
	public void simulieren(String art, double betrag){
		if(art.equals("MITARBEITER_EINSTELLEN")){
			boolean tmp = einstellen((int) betrag);
		} else if(art.equals("MITARBEITER_ENTLASSEN")){
			entlassen((int) betrag);
		} else if(art.equals("MITARBEITER_SCHULEN")){
			schulen();
		} else {
			//ignore
		}
	}
}
