package de.spiel.magazin;

import java.io.PrintWriter;

public class Werbung {
	private double betrag;
	private String art;
	private double anteil;
	
	public Werbung(double betrag, String art, int anteilSeiten){
		this.betrag = betrag;
		this.art = art;
		
		if(art.equals("Fremdwerbung")){
			anteil = Math.round(100.0 * (anteilSeiten / 150)) / 100.0;
		} else {
			anteil = 0;
		}
	}
	
	public void setKonditionen(double betrag, int anteilSeiten){
		this.betrag = betrag;
		anteil = Math.round(100.0 * (anteilSeiten / 150)) / 100.0;
	}
	
	public void ausgabeKonditionen(PrintWriter writer){
		if(art.equals("Eigenwerbung")){
			writer.println("Art der Werbung: " + art);
			writer.println("Betrag:          " + betrag);			
		} else {
			writer.println("Art der Werbung: " + art);
			writer.println("Betrag:          " + betrag);
			writer.println("Anteil:          " + anteil);			
		}
	}
}