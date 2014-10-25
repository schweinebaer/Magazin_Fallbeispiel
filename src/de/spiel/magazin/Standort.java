package de.spiel.magazin;

import java.util.Vector;


public class Standort {
	private String name;
	private double preis;
	
	//alt
	private static StandortDaten anfangswerteStandorte = new StandortDaten();
	//neu
	private static StandortDaten muenchen = new StandortDaten( "München", 500000.0, 5000.0, 2000, 500, 3200.0, 1600000.0, 500000, 500000, 344791, 68958.2, 16, 60, 8, 80000.0, 20, 4.0, 8.0, 1798958.2, 1379164.0, 200000, 1579164, -219794.2, 7197942, 50000.0);
	private static StandortDaten berlin = new StandortDaten(    "Berlin", 200000.0, 2000.0, 2000, 500, 3150.0, 1575000.0, 500000, 500000, 332291, 66458.2, 16, 60, 7, 70000.0, 20, 4.0, 8.0, 1751458.2, 1329164.0, 200000, 1529164, -222294.2, 7222942, 40000.0);
	private static StandortDaten walldorf = new StandortDaten("Walldorf", 500000.0, 500.0, 2000, 500, 3100.0, 1550000.0,  500000, 500000, 323958, 64791.6, 17, 60, 6, 60000.0, 20, 4.0, 8.0, 1709791.6, 1295832.0, 212500, 1508332, -201459.6, 7014596, 35000.0);
	private static StandortDaten bonn = new StandortDaten(         "Bonn", 50000.0, 500.0, 2000, 500, 3000.0, 1500000.0,  500000, 500000, 344791, 68958.2, 16, 60, 8, 80000.0, 20, 4.0, 8.0, 1678958.2, 1379164.0, 200000, 1579164, -99794.2, 5997942, 30000.0);
	
	public Standort(int standort){
		Object[] o = null;
		
		if(standort == 1){
			o = muenchen.getDaten();
		} else if(standort == 2){
			o = berlin.getDaten();
		} else if(standort == 3){
			o = walldorf.getDaten();
		} else if(standort == 4){
			o = bonn.getDaten();
		} else {
			//ignore
		}
		
		try {
			name = (String) o[0];
			preis = (double) o[1];
		} catch (NullPointerException e) {
			//ignore
		}
	}
	
	public static Object[] getStandort(int i){
		if(i == 1){
			return muenchen.getDaten();
		} else if(i == 2){
			return berlin.getDaten();
		} else if(i == 3){
			return walldorf.getDaten();
		} else if(i == 4){
			return bonn.getDaten();
		} else {
			//ignore
			return null;
		}
	}
	
	public static double getPreis(String name){
		Object[] o;
		if(name.equals("München")){
			o = anfangswerteStandorte.getStandorte(1);
			return (double) o[2];
		} else if(name.equals("Berlin")){
			o = anfangswerteStandorte.getStandorte(2);
			return (double) o[2];
		} else if(name.equals("Walldorf")){
			o = anfangswerteStandorte.getStandorte(3);
			return (double) o[2];
		} else if(name.equals("Bonn")){
			o = anfangswerteStandorte.getStandorte(4);
			return (double) o[2];
		}
		
		return 0;
	}
	
	public String getOrt(){
		return name;
	}
}
