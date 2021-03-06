package de.spiel.magazin;

import java.util.Vector;

public class Marktanteil {
	/*
	 * @author Pascal Pronobis
	 * @description Marktanteil der jeweiligen Magazinen 
	 */
	
	private double anteil;
	private int abgesetzteMagazine;
	private static int gesamtAbgesetzteMagazine;
	
	public Marktanteil(){
		
	}
	
	public void updateAbgesetzteMengeSpieler(int abgesetzteMagazine){
		this.abgesetzteMagazine = abgesetzteMagazine;
	}
	
	public static int getGesamtAbgesetzteMagazine(){
		return gesamtAbgesetzteMagazine;
	}
	
	public static void setGesamtAbgesetzteMagazine(int betrag){
		gesamtAbgesetzteMagazine = betrag;
	}
	
	public static void updateAbgesetzteMengeGesamt(Vector<Spieler> spieler){
		//Marktanteil.gesamtAbgesetzteMagazine = 0;
		//Marktanteil.setGesamtAbgesetzteMagazine(0);
		gesamtAbgesetzteMagazine = 0;
		
		for(int i = 0; (i < spieler.size()) && spieler.elementAt(i) != null; i++){
			Marktanteil.gesamtAbgesetzteMagazine += spieler.elementAt(i).getMagazin().getAbgesetzteMagazine();
			//gesamtAbgesetzteMagazine += spieler.elementAt(i).getMagazin().getAbgesetzteMagazine();
		}
		
		for(int i = 0; (i < spieler.size()) && spieler.elementAt(i) != null; i++){
			spieler.elementAt(i).getMagazin().updateMarktanteil();
		}
	}
	
	public void berechneAnteilNeu(){
		//anteil = rundeBetrag(abgesetzteMagazine / Marktanteil.getGesamtAbgesetzteMagazine());
		//int tmp = gesamtAbgesetzteMagazine;
		anteil = ((double) abgesetzteMagazine / (double) gesamtAbgesetzteMagazine) * 100;
		anteil = rundeBetrag(anteil);
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