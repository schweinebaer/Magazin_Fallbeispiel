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
		
		if(spieler.getMagazin() == null){
			this.writer.println("Noch kein Magazin eröffnet.");
		}
	}
	
	public void generiereAusgabe(){
		Object[] o = spieler.getMagazin().getAktuelleDaten();
		
		writer.println("------ Bericht für " + spieler.getName() + " ------");
		writer.println("Standort:           	   	             " + ((Standort) o[0]).getOrt());
		writer.println("Anzahl Mitarbeiter gesamt:               " + ((Angestellte) o[1]).getAnzahlAngestellte());
		writer.println("Anzahl Mitarbeiter Bereich HR:           " + ((Angestellte) o[1]).getBereichsZahlen()[0]);
		writer.println("Anzahl Mitarbeiter Bereich Journalisten: " + ((Angestellte) o[1]).getBereichsZahlen()[1]);
		writer.println("Umsatz:                       			 " + ((Umsatz) o[6]).getUmsatz());
		writer.println("-> davon Erlös:               			 " + ((Erloes) o[4]).getGesamtErloes());
		writer.println("-> davon Kosten:              			 " + ((Kosten) o[5]).getGesamtKosten());
		writer.println("   -> davon Fixkosten: 		  			 " + ((Standort) o[0]).getFixkosten());
		writer.println("Kapital:                      			 " + spieler.getKapital());
		writer.println("-> davon EK:                  		     " + spieler.getEK());
		writer.println("-> davon FK:                  			 " + spieler.getFK());
		writer.println("Werbung:                 			     ");
		((Werbung) o[2]).ausgabeKonditionen(writer);
		((Werbung) o[3]).ausgabeKonditionen(writer);
		writer.println("-------------------------------------------------------------------");
	}
}