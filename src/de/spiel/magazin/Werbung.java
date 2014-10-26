package de.spiel.magazin;

import java.io.PrintWriter;

public class Werbung {
	/*
	 * @author Pascal Pronobis
	 * @description Koordination von Eigen- und Fremdwerbung 
	 */
	
	private String art;
	
	private int ewAktionen;
	private int maxEWAktionen;
	private final double kostenEWAktion = 10000.0;
	private double kostenEWGesamt;
	
	private int fwInSeiten;
	private int maxSeitenFW;
	private int auflage;
	private final double einnahmenFWSeite = 12500;
	private double einnahmenFW;
	
	public Werbung(int typ, int anteil, int maxAnteil, int auflage){
		//WISCHTISCH: runden auf 2 Nachkommastellen: Math.round(100.0 * (anteilSeiten / 150)) / 100.0
		
		if(typ == 0){
			//EW
			art = "Eigenwerbung";
			ewAktionen = anteil;
			maxEWAktionen = maxAnteil;
			kostenEWGesamt = ewAktionen * kostenEWAktion;
		} else if(typ == 1){
			//FW
			art = "Fremdwerbung";
			fwInSeiten = anteil;
			maxSeitenFW = maxAnteil;
			this.auflage = auflage;
			einnahmenFW = fwInSeiten * einnahmenFWSeite;
		} else {
			//ignore
		}
	}
	
	public void updateEW(PrintWriter writer, int ewAktionen){
		if(ewAktionen > maxEWAktionen){
			writer.println("Kein Update der Konditionen der Eigenwerbung möglich, da der Aktionanteil höher ist als der maxmimal mögliche Anteil.");
			writer.println("Bitte geben Sie einen Wert für die Aktionen kleiner oder gleich " + maxEWAktionen + " an.");
		} else {
			this.ewAktionen = ewAktionen;
			kostenEWGesamt = ewAktionen * kostenEWAktion;
			writer.println("Die Anzahl der Aktionen wurde auf "+this.ewAktionen+" festegelget");
		}
	}

	public void updateFW(PrintWriter writer, int fwInSeiten, int auflage){
		if(fwInSeiten > maxSeitenFW){
			writer.println("Kein Update der Konditionen der Fremdwerbung möglich, da der Seitenanteil höher ist als der maxmimal mögliche Seitenanteil.");
			writer.println("Bitte geben Sie einen Wert für die Seiten kleiner oder gleich " + maxSeitenFW + " an.");
		} else {
			this.auflage = auflage;
			this.fwInSeiten = fwInSeiten;
			einnahmenFW = fwInSeiten * einnahmenFWSeite;
			writer.println("Die Anzahl der Seiten für Fremdwerbung im  Magazin wurde auf "+this.fwInSeiten+" festegelget");
		}
	}
	
	public void updateFW(double betrag){
		fwInSeiten *= betrag;
		einnahmenFW = fwInSeiten * einnahmenFWSeite;
	}
	
	public double getKosten(){
		return kostenEWGesamt;
	}
	
	public double getEinnahmen(){
		return einnahmenFW;
	}
	
	public void ausgabeKonditionen(PrintWriter writer){
		if(art.equals("Eigenwerbung")){
			writer.println("-> Art der Werbung:              	" + art);
			writer.println("   -> Anzahl Aktionen:           	" + ewAktionen);
			writer.println("   -> Maximale Anzahl Aktionen:  	" + maxEWAktionen);
			writer.println("   -> Gesamtkosten Eigenwerbung: 	" + kostenEWGesamt);
		} else {
			writer.println("-> Art der Werbung:              	" + art);
			writer.println("   -> Anzahl Seiten:             	" + fwInSeiten);
			writer.println("   -> Einnahmen FW pro Seite:    	" + einnahmenFWSeite);
			writer.println("   -> Gesamteinnahmen FW:        	" + einnahmenFW);
		}
	}
}