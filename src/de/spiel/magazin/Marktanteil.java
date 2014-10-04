package de.spiel.magazin;

import java.util.Vector;

public class Marktanteil {
	private double anteil;
	
	public Marktanteil(double anteil){
		this.anteil = anteil;
	}
	
	public static void berechneNeu(Vector<Spieler> spieler){
		
	}
	
	public double getAnteil(){
		return anteil;
	}
}