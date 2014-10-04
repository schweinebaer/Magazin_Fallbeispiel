package de.spiel.magazin;

import java.io.PrintWriter;

public class Bericht {
	private Spieler spieler;
	private Magazin magazin;
	private Standort standort;
	private int anzahlMitarbeiter;
	private double umsatz;
	private double eigenkapital;
	private double fremdkapital;

	public Bericht(Spieler s){
		
	}
	
	public void generiereAusgabe(PrintWriter writer){
		writer.println("------ Bericht für " + spieler.getName() + " ------");
		writer.println("Standort:           	   	  " + standort.getOrt());
		writer.println("Anzahl Mitarbeiter gesamt:    " + standort.getMitarbeiter()[0]);
		writer.println("Anzahl Mitarbeiter Bereich A: " + standort.getMitarbeiter()[1]);
		writer.println("Anzahl Mitarbeiter Bereich B: " + standort.getMitarbeiter()[2]);
		writer.println("Anzahl Mitarbeiter Bereich C: " + standort.getMitarbeiter()[3]);
		writer.println("Umsatz:                       ");
		writer.println("Kapital:                      ");
		writer.println("-> davon EK:                  ");
		writer.println("-> davon FK:                  ");
		writer.println("Eigenwerbung:                 ");
		writer.println("Fremdwerbung:                 ");
		writer.println("------------------------------------");
	}
}