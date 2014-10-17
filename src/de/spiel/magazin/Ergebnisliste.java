package de.spiel.magazin;

import java.util.Vector;

public class Ergebnisliste {
	private Vector<Spieler> spielerListe;
	
	public Ergebnisliste(){
		spielerListe = new Vector();
	}
	
	public void addSpieler(Spieler s){
		spielerListe.add(s);
	}
	
	public Vector<Spieler> getErgebnis(){
		return spielerListe;
	}
}