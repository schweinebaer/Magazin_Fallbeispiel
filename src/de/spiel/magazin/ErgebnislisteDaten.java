package de.spiel.magazin;

public class ErgebnislisteDaten {
	private Spieler s;
	private int runde;
	private Marktanteil marktanteil;
	
	public ErgebnislisteDaten(Spieler s, int runde, Marktanteil marktanteil){
		this.s = s;
		this.runde = runde;
		this.marktanteil = marktanteil;
	}
	
	public Spieler getSpieler(){
		return s;
	}
	
	public int getRunde(){
		return runde;
	}
	
	public Marktanteil getMarktanteil(){
		return marktanteil;
	}
}