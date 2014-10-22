package de.spiel.magazin;

import java.util.Vector;


public class Standort {
	private String name;
	private double preis;
	
	//alt
	private static StandortDaten anfangswerteStandorte = new StandortDaten();
	//neu
	private static StandortDaten muenchen = new StandortDaten("München", 500000.0, 5000.0, 2000, 500, 3200.0, 1600000.0, 500000, 500000, 125000, 65000.0, 16, 60, 7, 70000.0, 20, 4.0, 8.0, 1685000.0, 1300000.0, 150000.0, 1450000.0, -2350000.0, 7300000.0);
	private static StandortDaten berlin = new StandortDaten("Berlin", 200000.0, 2000.0, 2000, 500, 3150.0, 1575000.0, 400000, 400000, 2566666, 51333.2, 16, 60, 5, 50000.0, 20, 4.0, 8.0, 1341333.2, 1026664.0, 500000.0, 1526664.0, 185330.8, 3200000.0);
	private static StandortDaten walldorf = new StandortDaten("Walldorf", 500000.0, 500.0, 2000, 500, 3100.0, 1550000.0, 600000, 600000, 430000, 86000.0, 17, 60, 6, 60000.0, 20, 4.0, 8.0, 2006000.0, 1720000.0, 250000.0, 1970000.0, -36000.0, 5360000.0);
	private static StandortDaten bonn = new StandortDaten("Bonn", 50000.0, 500.0, 2000, 500, 3000.0, 1500000.0, 500000, 500000, 387500, 775000, 16, 60, 8, 80000.0, 20, 4.0, 8.0, 1707500.0, 1550000.0, 300000.0, 1850000.0, 142500.0, 3600000.0);
	
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
