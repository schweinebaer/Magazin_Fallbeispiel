package de.spiel.magazin;

import java.io.PrintWriter;
import java.util.Vector;

public class Ergebnisliste {
	/*
	 * @author Pascal Pronobis
	 * @description Ergebnisliste Koordination
	 */
	
	private Object[] ergebnisliste;
	private Vector<Spieler> spielerListe;
	private Vector<Integer> spielerRunden;
	private Vector<Marktanteil> spielerMarktanteile;
	private PrintWriter writer;
	private ErgebnislisteAusgabe ausgabeErgebnis;
	private ErgebnislisteDaten[] daten;
	private int zeigerArrayDaten;
	
	public Ergebnisliste(PrintWriter writer, int anzahlSpieler){
		this.writer = writer;
		daten = new ErgebnislisteDaten[anzahlSpieler];
		zeigerArrayDaten = 0;
		ergebnisliste = new Object[3];
		spielerListe = new Vector();
		spielerRunden = new Vector();
		spielerMarktanteile = new Vector();
		ausgabeErgebnis = new ErgebnislisteAusgabe();
	}
	
	public void addSpieler(Spieler s, int runde, Marktanteil marktanteil){
		daten[zeigerArrayDaten] = new ErgebnislisteDaten(s, runde, marktanteil);
		zeigerArrayDaten++;
		
		/*
		spielerListe.add(s);
		spielerRunden.add(runde);
		spielerMarktanteile.add(marktanteil);
		*/
	}
	
	public void ausgabeListe(){
		ausgabeErgebnis.ausgabeErgebnis(writer, daten);
		//ausgabeErgebnis.ausgabeErgebnis(writer, spielerListe, spielerRunden, spielerMarktanteile);
	}
}