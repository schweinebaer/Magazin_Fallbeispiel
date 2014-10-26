package de.spiel.magazin;

import java.io.PrintWriter;

public class Kredit {
	/*
	 * @author Pascal Pronobis
	 * @description Koordination der Kredite
	 */
	
	// noch einbauen: FK nicht mehr als 300% des EK sein
	private double kreditbetrag;
	private double zinssatz;
	private static double zinssatzNeuaufnahme = 5.0;
	
	public Kredit(double betrag){
		kreditbetrag = betrag;
		zinssatz = zinssatzNeuaufnahme;
	}
	
	public void ausgabeKonditionen(PrintWriter writer){
		writer.println("Kreditbetrag: " + kreditbetrag);
		writer.println("Zinssatz:     " + zinssatz);
	}
	
	public void tilgung(double betrag){
		kreditbetrag -= betrag;
	}
	
	public void berechnungPeriode(){
		kreditbetrag = rundeBetrag(kreditbetrag + kreditbetrag * zinssatz);
	}
	
	public double getBetrag(){
		return kreditbetrag;
	}
	
	public static void updateZinsatz(double update){
		zinssatzNeuaufnahme += update;
	}
	
	public static double getZinsatzNeuaufnahme(){
		return zinssatzNeuaufnahme;
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