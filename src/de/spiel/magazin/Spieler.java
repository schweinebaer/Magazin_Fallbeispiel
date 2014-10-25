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
	private double fk;
	private PrintWriter writer;
	
	public Spieler(String name, PrintWriter writer){
		this.name = name;
		this.writer = writer;
		kredite = new Vector();
		berichte = new Vector();
		kapital = 5000000.0;
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
	
	public void setMagazin(String standort){
		Object[] o;
		
		if(standort.equals("München")){
			o = Standort.getStandort(1);
			magazin = new Magazin(new Standort(1), o, writer);
		} else if(standort.equals("Berlin")){
			o = Standort.getStandort(2);
			magazin = new Magazin(new Standort(2), o, writer);
		} else if(standort.equals("Walldorf")){
			o = Standort.getStandort(3);
			magazin = new Magazin(new Standort(3), o, writer);
		} else if(standort.equals("Bonn")){
			o = Standort.getStandort(4);
			magazin = new Magazin(new Standort(4), o, writer);
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
		ek = kapital - fk;
	}
	
	public double getEK(){
		ermittleEK();
		return ek;
	}
	
	public void ermittleFK(){
		//nochmal überprüfen, da IndexOutOfBounds Exception
		if(!kredite.isEmpty()){
			Kredit k = kredite.firstElement();
			fk = 0;
			
			for(int i = 0; k != null; i++){
				fk += k.getBetrag();
				k = kredite.elementAt(i);
				writer.println(fk);
			}
		} else {
			fk = 0;
		}
	}
	
	public double getFK(){
		ermittleFK();
		return fk;
	}
	
	public void simulieren(String art, double betrag){
		if(art.equals("KREDIT_AUFNEHMEN")){
			//überprüfen, ob der FK mehr als 300% EK
			Kredit k = new Kredit(betrag);
			kredite.add(k);
			writer.println("Kredit über " + betrag + "€ zu " + k.getZinsatzNeuaufnahme() + "% aufgenommen.");
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
