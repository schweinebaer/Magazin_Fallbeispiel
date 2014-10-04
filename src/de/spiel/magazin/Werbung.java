package de.spiel.magazin;

import java.io.PrintWriter;

public class Werbung {
	private double betrag;
	private String art;
	private int anteil;
	
	public Werbung(double betrag, String art, int anteil){
		this.betrag = betrag;
		this.art = art;
		this.anteil = anteil;
	}
	
	public void setKonditionen(double betrag, int anteil){
		this.betrag = betrag;
		this.anteil = anteil;
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