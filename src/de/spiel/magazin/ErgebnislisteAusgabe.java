package de.spiel.magazin;

import java.io.PrintWriter;
import java.util.Vector;

public class ErgebnislisteAusgabe {
	/*
	 * @author Pascal Pronobis
	 * @description Ausgabe des Spielergebnisses
	 */
	
	public void ausgabeErgebnis(PrintWriter writer, Vector<Spieler> spielerListe, Vector<Integer> spielerRunden, Vector<Marktanteil> spielerMarktanteile) {
		writer.println("------Ergebnis------");
		writer.println("-----------------------------------------------");
		writer.println("Platz ---- Spieler ---- Marktanteil ---- bis Runde");
		
		Marktanteil tmp;
		
		for(int i = spielerListe.size(); i >= 0; i--){
			tmp = spielerMarktanteile.get(i);
			
			writer.print(spielerListe.size() - i);
			writer.print(spielerListe.get(i));
			
			if(tmp != null){
				writer.print(tmp.getAnteil() + "%");
			} else {
				writer.print("0%");
			}
			
			writer.print(spielerRunden.get(i));
		}
	}

	public void ausgabeErgebnis(PrintWriter writer, ErgebnislisteDaten[] daten) {
		writer.println("------Ergebnis------");
		writer.println("-----------------------------------------------");
		writer.println("Platz ---- Spieler ---- Marktanteil ---- bis Runde");
		
		Marktanteil tmp;
		
		for(int i = (daten.length - 1); i >= 0; i--){
			tmp = daten[i].getMarktanteil();
			
			writer.print("  " + (daten.length - i) + "         ");
			writer.print(daten[i].getSpieler().getName() + "         ");
			
			if(tmp != null){
				writer.print("   " + tmp.getAnteil() + "%      ");
			} else {
				writer.print("   0%      ");
			}
			
			writer.print("   " + daten[i].getRunde());
			writer.println();
		}
	}
}