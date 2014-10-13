package de.spiel.magazin;

import java.io.PrintWriter;
import java.util.Vector;

import de.spiel.magazin.Bericht;
import de.spiel.magazin.Kredit;
import de.spiel.magazin.Magazin;

public class Spieler {
	//private Standort standort;
	private int mitarbeiter;
	private String name;
	private Magazin magazin;
	private Vector<Kredit> kredite;
	private Vector<Bericht> berichte;
	private double kapital;
	private double ek;
	private PrintWriter writer;
	
	public Spieler(String name, PrintWriter writer){
		this.name = name;
		this.writer = writer;
		kredite = new Vector();
		berichte = new Vector();
	}
	
	public String getName(){
		return name;
	}

	public Magazin getMagazin() {
		if(magazin == null){
			return null;
		} else {
			return magazin;
		}
	}
	
	public void setMagazin(String standort, Marktanteil marktanteil){
		Object[] o;
		
		if(standort.equals("München")){
			o = Standort.getStandort(1);
			magazin = new Magazin(new Standort((String) o[0], (double) o[1], (double) o[2], (int) o[3], 200), marktanteil);
		} else if(standort.equals("Berlin")){
			o = Standort.getStandort(2);
			magazin = new Magazin(new Standort((String) o[0], (double) o[1], (double) o[2], (int) o[3], 100), marktanteil);
		} else if(standort.equals("Walldorf")){
			o = Standort.getStandort(3);
			magazin = new Magazin(new Standort((String) o[0], (double) o[1], (double) o[2], (int) o[3], 50), marktanteil);
		}
	}
	
	public void addBericht(Spieler s){
		berichte.add(new Bericht(s, writer));
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
		if(art.equals("KREDIT_AUFNEHMEN")){
			Kredit k = new Kredit(betrag);
			kredite.add(k);
		} else if(art.equals("KREDIT_TILGEN")){
			for(int i = 0; betrag > 0 && !kredite.isEmpty(); i++){
				double betragSchleifeKredit = kredite.get(i).getBetrag();
				
				if(betragSchleifeKredit < betrag){
					kredite.remove(i);
					betrag -= betragSchleifeKredit;
				} else if(betragSchleifeKredit > betrag){
					kredite.get(i).tilgung(betrag);
				} else {
					kredite.remove(i);
				}
			}
		} else {
			//ignore
		}
	}
	
	public void erhoeheKapitalUm(double kapitalErhoehung){
		kapital += kapitalErhoehung;
	}
	
	public void minimiereKapitalUm(double kapitalMinderung){
		kapital -= kapitalMinderung;
	}
}
