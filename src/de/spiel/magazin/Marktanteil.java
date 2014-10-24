package de.spiel.magazin;

import java.util.Vector;

public class Marktanteil {
	private double anteil;
	private int abgesetzteMagazine;
	private static int gesamtAbgesetzteMagazine;
	
	public Marktanteil(Spieler s, int abgesetzteMagazine, Vector<Spieler> spieler){
		this.abgesetzteMagazine = abgesetzteMagazine;
		
		for(int i = 0; i < spieler.capacity(); i++){
			gesamtAbgesetzteMagazine += spieler.get(i).getMagazin().getAbgesetzteMagazine();
		}
		
		anteil = abgesetzteMagazine / gesamtAbgesetzteMagazine;
	}
	
	public static void updateAbgesetzteMengeGesamt(Vector<Spieler> spieler){
		gesamtAbgesetzteMagazine = 0;
		
		for(int i = 0; i < spieler.capacity(); i++){
			gesamtAbgesetzteMagazine += spieler.get(i).getMagazin().getAbgesetzteMagazine();
		}
		
		for(int i = 0; i < spieler.capacity(); i++){
			spieler.get(i).getMagazin().updateMarktanteil();
		}
	}
	
	public void berechneAnteilNeu(){
		anteil = abgesetzteMagazine / gesamtAbgesetzteMagazine;
	}
	
	public double getAnteil(){
		return anteil;
	}
}