package de.spiel.magazin;

import java.util.Vector;
import de.spiel.magazin.Bericht;
import de.spiel.magazin.Kredit;
import de.spiel.magazin.Magazin;

public class Spieler {
	private Standort standort;
	private int mitarbeiter;
	private String name;
	private Magazin magazin;
	private Vector<Kredit> kredite;
	private Vector<Bericht> berichte;
	private double kapital;
	private double ek;
	
	public Spieler(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}

	public Magazin getMagazin() {
		return null;
	}
	
	public void setMagazin(String standort){
		
	}
	
	public Kredit getKredit(){
		return null;
	}
	
	public void setKredit(int betrag){
		
	}
	
	public double getKapital(){
		return kapital;
	}
	
	public void ermittleEK(){
		
	}
	
	public double getEK(){
		return 0;
	}
	
	public void simulieren(String art, double betrag){
		
	}

	public void setStandort(String name) {
		if(){
			
		} else if(){
			
		} else if(){
			
		}
	}
	
	public void minimiereKapitalUm(double kapitalMinimierung){
		kapital -= kapitalMinimierung;
	}
}
