package de.spiel.magazin;

import java.io.PrintWriter;

public class Kredit {
	private double kreditbetrag;
	private double zinssatz;
	
	public Kredit(double betrag, double zinssatz){
		
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
}