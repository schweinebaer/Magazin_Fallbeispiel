package de.spiel.magazin;

public class Zufallsereignis {
	private static int ereignisRandomZahl;
	private static Object[] ereignisString = ereignisString = new String[4];
	private static ZufallsereignisDaten daten = new ZufallsereignisDaten(); 
		
	public static Object[] berechneZufallsEreignis(){
		ereignisRandomZahl = (int) Math.random() * 14;
		
		return daten.getEreignis(ereignisRandomZahl);
	}
}