package de.spiel.magazin;

import java.io.*;

public class Spiel {
	/*
	 * @author Pascal Pronobis
	 */
	
	private static Spieler[] spieler;
	private static Spieler aktuellerSpieler;
	private static int aktuelleRunde;
	private static int maxRunde;
	private static BufferedReader reader;
	private static PrintWriter writer;
	private static String aktuelleEingabe;
	private static String[] splitAktuelleEingabe;
	
	public static void main(String[] args) throws IOException {
		reader = new BufferedReader(new InputStreamReader(System.in));
		writer = new PrintWriter(System.out, true);
		
		writer.println("Willkommen beim Planspiel!");
		writer.println("Bitte geben Sie eine maximale Rundenanzahl ein!");
		
		aktuelleEingabe = reader.readLine();
		
		while(aktuelleEingabe.isNumeric())
		writer.println("");
		writer.println("");
		writer.println("");
		
		while(aktuelleRunde < maxRunde){
			for(int i = 0; i < spieler.length; i++){
				aktuellerSpieler = spieler[i];
				writer.println("Nächste Aktionen für " + aktuellerSpieler.getName());
				
				aktuelleEingabe = reader.readLine().toUpperCase();
				splitAktuelleEingabe = aktuelleEingabe.split(" ");
				
				simulieren(splitAktuelleEingabe[0], Double.parseDouble(splitAktuelleEingabe[1]));
			}

			aktuelleRunde++;
		}
		
		reader.close();
		writer.close();
	}
	
	private static void simulieren(String art, double Betrag){
		
	}
	
	private static boolean isNumeric(){
		return false;
	}
}
