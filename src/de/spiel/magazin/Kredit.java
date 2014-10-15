package de.spiel.magazin;

import java.io.PrintWriter;

public class Kredit {
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
		kreditbetrag = kreditbetrag + kreditbetrag * zinssatz;
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
}