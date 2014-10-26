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
	private Object[] o;
	private double kapital;
	private double ek;
	private double fk;

	public Bericht(Spieler s, PrintWriter writer){
		//Werte richtig abspeichern, damit man auch alte Geschäftsberichte abrufen kann
		this.writer = writer;
		spieler = s;
		
		o = spieler.getMagazin().getAktuelleDaten();
		
		kapital = s.getKapital();
		ek = s.getEK();
		fk = s.getFK();
		
		if(spieler.getMagazin() == null){
			this.writer.println("Noch kein Magazin eröffnet.");
		}
	}
	
	public void generiereAusgabe(){
		writer.println("------ Bericht für " + spieler.getName() + " ------");
		writer.println("Standort:                                " + ((Standort) o[0]).getOrt());

		if(spieler.getMagazin().getMarktanteil().getAnteil() != 0){
			writer.println("Marktanteil des Magazins:                " + spieler.getMagazin().getMarktanteil().getAnteil());
		}
		
		writer.println("Anzahl Mitarbeiter gesamt:               " + ((Angestellte) o[1]).getAnzahlAngestellte());
		writer.println("Anzahl Mitarbeiter Bereich HR:           " + ((Angestellte) o[1]).getBereichsZahlen()[0]);
		writer.println("Anzahl Mitarbeiter Bereich Journalisten: " + ((Angestellte) o[1]).getBereichsZahlen()[1]);
		writer.println("Umsatz:                                  " + ((Umsatz) o[6]).getUmsatz() + "€");
		writer.println("-> davon Erlös:                          " + ((Erloes) o[4]).getGesamtErloes() + "€");
		writer.println("-> davon Kosten:                         " + ((Kosten) o[5]).getGesamtKosten() + "€");
		writer.println("   -> davon Fixkosten:                   " + ((Standort) o[0]).getFixkosten() + "€");
		writer.println("Kapital:                                 " + rundeBetrag(spieler.getKapital()) + "€");
		writer.println("-> davon EK:                             " + rundeBetrag(spieler.getEK()) + "€");
		writer.println("-> davon FK:                             " + rundeBetrag(spieler.getFK()) + "€");
		writer.println("Werbung:                 			     ");
		((Werbung) o[2]).ausgabeKonditionen(writer);
		((Werbung) o[3]).ausgabeKonditionen(writer);
		writer.println("-------------------------------------------------------------------");
	}
	
	private double rundeBetrag(double betrag){ 
	      double round = Math.round(betrag*10000); 
	      
	      round = round / 10000; 
	      round = Math.round(round*1000); 
	      round = round / 1000; 
	      round = Math.round(round*100); 
	      
	      return round / 100; 
	    }
}