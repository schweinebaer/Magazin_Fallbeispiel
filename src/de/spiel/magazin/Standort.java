package de.spiel.magazin;

import java.util.Vector;


public class Standort {
	private String name;
	private double preis;
	private static StandortDaten anfangswerteStandorte = new StandortDaten();
	
	public Standort(int standort){
		Object[] o = anfangswerteStandorte.getStandorte(standort);
		name = (String) o[0];
		preis = (double) o[1];
	}
	
	public static Object[] getStandort(int i){
		return anfangswerteStandorte.getStandorte(i);
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
