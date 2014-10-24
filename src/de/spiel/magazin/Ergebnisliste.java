package de.spiel.magazin;

import java.io.PrintWriter;
import java.util.Vector;

public class Ergebnisliste {
	private Object[] ergebnisliste;
	private Vector<Spieler> spielerListe;
	private Vector<Integer> spielerRunden;
	private Vector<Marktanteil> spielerMarktanteile;
	private PrintWriter writer;
	private ErgebnislisteAusgabe ausgabeErgebnis;
	
	public Ergebnisliste(PrintWriter writer){
		this.writer = writer;
		ergebnisliste = new Object[3];
		spielerListe = new Vector();
		spielerRunden = new Vector();
		spielerMarktanteile = new Vector();
		ausgabeErgebnis = new ErgebnislisteAusgabe();
	}
	
	public void addSpieler(Spieler s, int runde, Marktanteil marktanteil){
		spielerListe.add(s);
		spielerRunden.add(runde);
		spielerMarktanteile.add(marktanteil);
	}
	
	public void ausgabeListe(){
		ausgabeErgebnis.ausgabeErgebnis(writer, spielerListe, spielerRunden, spielerMarktanteile);
	}
	
	public Object[] getErgebnis(){
		ergebnisliste[0] = spielerListe;
		ergebnisliste[1] = spielerRunden;
		ergebnisliste[2] = spielerMarktanteile;
		
		return ergebnisliste;
	}
}