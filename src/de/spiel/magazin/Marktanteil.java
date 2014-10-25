package de.spiel.magazin;

import java.util.Vector;

public class Marktanteil {
	private double anteil;
	private int abgesetzteMagazine;
	private static int gesamtAbgesetzteMagazine;
	
	public Marktanteil(){
		
	}
	
	public void updateAbgesetzteMengeSpieler(int abgesetzteMagazine){
		this.abgesetzteMagazine = abgesetzteMagazine;
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
		anteil = rundeBetrag(abgesetzteMagazine / gesamtAbgesetzteMagazine);
	}
	
	public double getAnteil(){
		return anteil;
	}
	
	private double rundeBetrag(double betrag){ 
	      double round = Math.round(betrag*10000); 
	      
	      round = round / 10000; 
	      round = Math.round(round*1000); 
	      round = round / 1000; 
	      round = Math.round(round*100); 
	      
	      return round / 100; 
	 }
}