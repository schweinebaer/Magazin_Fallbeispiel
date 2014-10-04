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
	
	public void setMagazin(String standort, Marktanteil marktanteil){
		Object[] o;
		
		if(standort.equals("M�nchen")){
			o = Standort.getStandort(1);
			this.standort = new Standort((String) o[0], (double) o[1], (double) o[2], (int) o[3], 200);
		} else if(standort.equals("Berlin")){
			o = Standort.getStandort(2);
			this.standort = new Standort((String) o[0], (double) o[1], (double) o[2], (int) o[3], 100);
		} else if(standort.equals("Walldorf")){
			o = Standort.getStandort(3);
			this.standort = new Standort((String) o[0], (double) o[1], (double) o[2], (int) o[3], 50);
		}
		
		magazin = new Magazin(this.standort, marktanteil);
	}
	
	public Kredit getKredit(){
		return null;
	}
	
	public void setKredit(int betrag){
		
	}
	
	public void addBericht(){
		berichte.add(new Bericht(this));
	}
	
	public Bericht getBericht(int berichtnummer){
		if(!berichte.isEmpty()){
			return berichte.elementAt(berichtnummer);
		} else {
			return null;
		}
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
		
	}
	
	public Standort getStandort(){
		return standort;
	}
	
	public void minimiereKapitalUm(double kapitalMinimierung){
		kapital -= kapitalMinimierung;
	}
}
