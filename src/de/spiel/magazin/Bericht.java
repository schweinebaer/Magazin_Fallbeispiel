package de.spiel.magazin;

import java.io.PrintWriter;

public class Bericht {
	private Spieler spieler;
	private Magazin magazin;
	private Standort standort;
	private int[] anzahlMitarbeiter;
	private double umsatz;
	private double eigenkapital;
	private double fremdkapital;
	private PrintWriter writer;

	public Bericht(Spieler s, PrintWriter writer){
		this.writer = writer;
		spieler = s;
		
		try {
			magazin = spieler.getMagazin();
			standort = magazin.getStandort();
			anzahlMitarbeiter = magazin.getMitarbeiter();
		} catch (NullPointerException e){
			this.writer.println("Noch kein Magazin eröffnet.");
		}
		
		//umsatz
		eigenkapital = spieler.getEK();
		//fremdkapital = spieler.getFK();
	}
	
	public void generiereAusgabe(){
		Object[] o = magazin.getAktuelleDaten();
		
		writer.println("------ Bericht für " + spieler.getName() + " ------");
		writer.println("Standort:           	   	  " + standort.getOrt());
		writer.println("Anzahl Mitarbeiter gesamt:    " + (anzahlMitarbeiter[0] + anzahlMitarbeiter[1] + anzahlMitarbeiter[2]));
		writer.println("Anzahl Mitarbeiter Bereich A: " + anzahlMitarbeiter[0]);
		writer.println("Anzahl Mitarbeiter Bereich B: " + anzahlMitarbeiter[1]);
		writer.println("Anzahl Mitarbeiter Bereich C: " + anzahlMitarbeiter[2]);
		writer.println("Umsatz:                       ");
		writer.println("-> davon Gewinn:              ");
		writer.println("-> davon Kosten:              ");
		writer.println("Kapital:                      ");
		writer.println("-> davon EK:                  ");
		writer.println("-> davon FK:                  ");
		writer.println("Eigenwerbung:                 ");
		writer.println("Fremdwerbung:                 ");
		writer.println("-----------------------------------------------");
	}
}