package de.spiel.magazin;

import java.io.*;
import java.util.Vector;

public class Spiel {
	/*
	 * @author Pascal Pronobis
	 */
	
	private static Vector<Spieler> spieler;
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
		
		while(!isNumeric(aktuelleEingabe)){
			aktuelleEingabe.toUpperCase();
			
			if(aktuelleEingabe.equals("BEENDEN")){
				System.exit(0);
			}
			
			writer.println("Eingabe keine gültige Zahl. Bitte neu eingeben.");
			aktuelleEingabe = reader.readLine();
		}
		
		maxRunde = Integer.parseInt(aktuelleEingabe);
		
		aktuelleEingabe = reader.readLine();
		aktuelleEingabe.toUpperCase();
		splitAktuelleEingabe = aktuelleEingabe.split(" ");
		
		while(!aktuelleEingabe.equals("SPIELER_FERTIG")){
			if(splitAktuelleEingabe[0].equals("SPIELER_HINZUFUEGEN")){
				Spieler einzelnerSpieler = new Spieler(splitAktuelleEingabe[1]);
				spieler.add(einzelnerSpieler);
			} else if(aktuelleEingabe.equals("HILFE")){
				
			} else if(aktuelleEingabe.equals("BEENDEN")){
				System.exit(0);
			} else {
				writer.println("Invalide Eingabe. Wiederholen Sie bitte Ihre Eingabe oder suchen Sie die Hilfe unter HILFE auf.");
			}
			
			aktuelleEingabe = reader.readLine();
			aktuelleEingabe.toUpperCase();
			splitAktuelleEingabe = aktuelleEingabe.split(" ");
		}
		
		while(aktuelleRunde < maxRunde){
			for(int i = 0; i < spieler.capacity(); i++){
				aktuellerSpieler = spieler.elementAt(i);
				writer.println("Nächste Aktionen für " + aktuellerSpieler.getName());
				
				aktuelleEingabe = reader.readLine().toUpperCase();
				splitAktuelleEingabe = aktuelleEingabe.split(" ");
				
				if(aktuelleEingabe.equals("HILFE")){
					
				} else if(aktuelleEingabe.equals("BEENDEN")){
					System.exit(0);
				} else {
					simulieren(splitAktuelleEingabe[0], Double.parseDouble(splitAktuelleEingabe[1]));
				}
			}

			aktuelleRunde++;
		}
		
		reader.close();
		writer.close();
	}
	
	private static void simulieren(String art, double Betrag){
		
	}
	
	private static boolean isNumeric(String z){
		int zahl = 0;
		
		try {
			zahl = Integer.parseInt(z);
		} catch(NumberFormatException e){
			return false;
		}
		
		return true;
	}
}
