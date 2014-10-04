package de.spiel.magazin;

import java.io.*;
import java.util.Vector;

public class Spiel {
	/*
	 * @author Pascal Pronobis
	 * @description Allgemeine Koordination des Spieles auf der Konsole
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
		spieler = new Vector();
		
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
		writer.println("Die maximale Rundenanzahl für das Spiel beträgt " + maxRunde + " Runden.");
		
		aktuelleEingabe = reader.readLine();
		splitAktuelleEingabe = aktuelleEingabe.split(" ");
		splitAktuelleEingabe[0] = splitAktuelleEingabe[0].toUpperCase();
		
		while(true){
			if(splitAktuelleEingabe[0].equals("SPIELER_HINZUFUEGEN")){
				Spieler einzelnerSpieler = new Spieler(splitAktuelleEingabe[1]);
				spieler.add(einzelnerSpieler);
				writer.println("Spieler " + splitAktuelleEingabe[1] + " hinzugefügt.");
			} else if(splitAktuelleEingabe[0].equals("SPIELER_FERTIG")){
				if(spieler.size() < 2){
					writer.println("Bitte geben Sie mindestend zwei Spieler an.");
				} else {
					break;
				}
			} else if(splitAktuelleEingabe[0].equals("HILFE")){
				hilfe(0);
			} else if(splitAktuelleEingabe[0].equals("BEENDEN")){
				System.exit(0);
			} else {
				writer.println("Invalide Eingabe. Wiederholen Sie bitte Ihre Eingabe oder suchen Sie die Hilfe unter HILFE auf.");
			}
			
			aktuelleEingabe = reader.readLine();
			splitAktuelleEingabe = aktuelleEingabe.split(" ");
			splitAktuelleEingabe[0] = splitAktuelleEingabe[0].toUpperCase();
		}
		
		while(aktuelleRunde < maxRunde){
			for(int i = 0; i < spieler.capacity(); i++){
				aktuellerSpieler = spieler.elementAt(i);
				writer.println("Nächste Aktionen für " + aktuellerSpieler.getName());
				
				aktuelleEingabe = reader.readLine();
				splitAktuelleEingabe = aktuelleEingabe.split(" ");
				splitAktuelleEingabe[0] = splitAktuelleEingabe[0].toUpperCase();
				
				while(!splitAktuelleEingabe[0].equals("FERTIG")){					
					if(splitAktuelleEingabe[0].equals("HILFE")){
						hilfe(1);
					} else if(splitAktuelleEingabe[0].equals("BEENDEN")){
						System.exit(0);
					} else if(splitAktuelleEingabe[0].equals("FERTIG")){
						writer.println("Runde von " + aktuellerSpieler.getName() + "beendet.");
						break;
					} else {
						if(splitAktuelleEingabe[1].equals("")){
							simulieren(splitAktuelleEingabe[0], 0);
						} else {
							simulieren(splitAktuelleEingabe[0], Double.parseDouble(splitAktuelleEingabe[1]));
						}
					}
					
					aktuelleEingabe = reader.readLine();
					splitAktuelleEingabe = aktuelleEingabe.split(" ");
					splitAktuelleEingabe[0] = splitAktuelleEingabe[0].toUpperCase();
				}
			}

			aktuelleRunde++;
		}
		
		reader.close();
		writer.close();
	}
	
	private static void simulieren(String art, double Betrag){
		if(splitAktuelleEingabe[0].equals("BERICHT")){
			if(splitAktuelleEingabe[1].equals("")){
				//aktuellerSpieler.getBericht(aktuelleRunde - 1).generiereAusgabe();
			} else if(isNumeric(splitAktuelleEingabe[1]) && Integer.parseInt(splitAktuelleEingabe[1]) > 0){
				//aktuellerSpieler.getBericht(Integer.parseInt(splitAktuelleEingabe[1]) - 1).generiereAusgabe();
			} else if(!isNumeric(splitAktuelleEingabe[1])){
				writer.println("Falsche Eingabe der Zahl.");
			} else {
				writer.println("Falsche Eingabe.");
			}
		} else if(splitAktuelleEingabe[0].equals("STANDORT")){
			
		} else if(splitAktuelleEingabe[0].equals("MAGAZIN_EROEFFNEN")){
			if(aktuellerSpieler.getMagazin() == null){
				if(splitAktuelleEingabe[1].equals("München") ||
						splitAktuelleEingabe[1].equals("Berlin") ||	
						splitAktuelleEingabe[1].equals("Walldorf")){
					//aktuellerSpieler.setStandort(splitAktuelleEingabe[1]);
					//aktuellerSpieler.minimiereKapitalUm(Standort.getPreis(splitAktuelleEingabe[1]));
				} else {
					writer.println("Invalide Standortwahl.");
				}
			} else {
				writer.println("Mehrere Standorte nicht erlaubt.");
			}
		} else if(splitAktuelleEingabe[0].equals("KREDIT_AUFNEHMEN")){
			if(Double.parseDouble(splitAktuelleEingabe[1]) != 0){
				
			} else {
				writer.println("Es kann kein Kredit in der Höhe von 0€ aufgenommen werden.");
			}
		} else if(splitAktuelleEingabe[0].equals("KREDIT_TILGEN")){
			if(Double.parseDouble(splitAktuelleEingabe[1]) != 0){
				
			} else {
				writer.println("Es kann kein Kredit mit einem Betrag von 0€ getilgt werden.");
			}			
		} else if(splitAktuelleEingabe[0].equals("WERBUNG SCHALTEN")){
			
		} else if(splitAktuelleEingabe[0].equals("MITARBEITER_EINSTELLEN")){
			if(Double.parseDouble(splitAktuelleEingabe[1]) != 0){
				
			} else {
				writer.println("Es können keine 0 Mitarbeiter eingestellt werden.");
			}
		} else if(splitAktuelleEingabe[0].equals("MITARBEITER_ENTLASSEN")){
			if(Double.parseDouble(splitAktuelleEingabe[1]) != 0){
				
			} else {
				writer.println("Es können keine 0 Mitarbeiter entlassen werden.");
			}
		} else if(splitAktuelleEingabe[0].equals("VERKAUFSPREIS_SETZEN")){
			
		} else {
			//ignore
		}
	}
	
	private static void hilfe(int art){
		if(art == 0){
			writer.println("---------- HILFE ----------");
			writer.println("Es stehen folgende Kommandos zur Verfügung (Kommandos in Großbuchstaben, Parameter in Kamelschreibweise)");
			writer.println("HILFE ------------------------------------------------- Zeigt eine Liste aller Kommandos an");
			writer.println("SPIELER_HINZUFUEGEN nameDesSpielers ------------------- Fügt einen neuen Spieler mit dem entsprechenden Namen hinzu");
			writer.println("SPIELER_FERTIG ---------------------------------------- Beendet die Eingabe der Spieler");
			writer.println("BEENDEN ----------------------------------------------- Beendet das Programm vorzeitig (ohne Spielstandabspeicherung und ohne Darstellung der letzten Stände)");
		} else if (art == 1){
			writer.println("---------- HILFE ----------");
			writer.println("Es stehen folgende Kommandos zur Verfügung (Kommandos in Großbuchstaben, Parameter in Kamelschreibweise)");
			writer.println("HILFE ------------------------------------------------- Zeigt eine Liste aller Kommandos an");
			writer.println("BERICHT ----------------------------------------------- Zeigt den aktuellen Bericht des Spielers mit allen Informationen an");
			writer.println("BERICHT rundenNummer ---------------------------------- Zeigt den  Bericht des Spielers mit allen Informationen an zur Runde rundenNummer an");
			writer.println("STANDORT ---------------------------------------------- Zeigt eine Liste aller Standorte an");
			writer.println("MAGAZIN_EROEFFNEN standortName ------------------------ Erzeugt ein Magazin am angegebenen Standort mit der entsprechend Mitarbeiteranzahl");
			writer.println("KREDIT_AUFNEHMEN betrag ------------------------------- Nimmt einen Kredit in der angegebenen Höhe auf");
			writer.println("KREDIT_TILGEN betrag ---------------------------------- Tilgt einen Kredit in der angegebenen Höhe");
			writer.println("WERBUNG SCHALTEN betrag ------------------------------- Schaltet Werbung für das Magazin");
			writer.println("MITARBEITER_EINSTELLEN mitarbeiterAnzahl -------------- Stellt mitarbeiterAnzahl Mitarbeiter im Magazin ein");
			writer.println("MITARBEITER_ENTLASSEN mitarbeiterAnzahl --------------- Entlässt mitarbeiterAnzahl Mitarbeiter aus dem Magazin");
			writer.println("VERKAUFSPREIS_SETZEN preis ---------------------------- Setzt den Preis für das Magazin");
			writer.println("AUFLAGE_SETZEN ---------------------------------------- Setzt die Auflage für das Magazin");
			writer.println("FERTIG ------------------------------------------------ Beendet das Treffen der Entscheidungen und lässt den nächsten Spieler dran");
			writer.println("BEENDEN ----------------------------------------------- Beendet das Programm vorzeitig (ohne Spielstandabspeicherung und ohne Darstellung der letzten Stände)");
		} else {
			//ignore
		}
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
