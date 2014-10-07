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
	private static Object[] zufallsereignis;
	
	public static void main(String[] args) throws IOException {
		spieler = new Vector();
		
		reader = new BufferedReader(new InputStreamReader(System.in));
		writer = new PrintWriter(System.out, true);
		
		spieler.add(new Spieler("Pascal", writer));
		spieler.add(new Spieler("Benni", writer));
		
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
				Spieler einzelnerSpieler = new Spieler(splitAktuelleEingabe[1], writer);
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
		
		writer.println("Der derzeitige Zinssatz für Kredite für alle Spieler liegt bei " + Kredit.getZinsatzNeuaufnahme() + "%.");
		writer.println("--------------------------------------------------");		
		
		while(aktuelleRunde < maxRunde){
			zufallsereignis = Zufallsereignis.berechneZufallsEreignis();
			
			if(zufallsereignis[1].equals("ZINSSATZ_ERHOEHEN")){
				writer.println(zufallsereignis[0]);
				Kredit.updateZinsatz((double) zufallsereignis[2]);
			} else if(zufallsereignis[1].equals("ZINSSATZ_VERKLEINERN")){
				writer.println(zufallsereignis[0]);
				Kredit.updateZinsatz(-1 * (double) zufallsereignis[2]);
			}
			
			if(aktuelleRunde >= 1){
				//evtl. noch folgende Nebenbedingung
				// && (zufallsereignis[1].equals("ZINSSATZ_ERHOEHEN") || zufallsereignis[1].equals("ZINSSATZ_VERKLEINERN"))
				writer.println("Der derzeitige Zinssatz für Kredite für alle Spieler liegt bei " + Kredit.getZinsatzNeuaufnahme() + "%.");
				writer.println("--------------------------------------------------");				
			}
			
			for(int i = 0; i < spieler.size(); i++){
				//genaue Berechnungen durchführen!!
				if(aktuelleRunde > 1){
					zufallsereignis = Zufallsereignis.berechneZufallsEreignis();
					
					while(zufallsereignis[1].equals("ZINSSATZ_ERHOEHEN") || zufallsereignis[1].equals("ZINSSATZ_VERKLEINERN")){
						zufallsereignis = Zufallsereignis.berechneZufallsEreignis();
						writer.println(zufallsereignis[0]);
					}
				}
				
				aktuellerSpieler = spieler.elementAt(i);
				
				if(aktuellerSpieler.getKapital() < 0.0){
					writer.println(aktuellerSpieler.getName() + " hat leider nicht mehr genügend Geld.");
					//hinten an Ergebnisliste anhängen
					spieler.remove(aktuellerSpieler);
				} else {
					writer.println("Nächste Aktionen für " + aktuellerSpieler.getName());
					
					aktuelleEingabe = reader.readLine();
					splitAktuelleEingabe = aktuelleEingabe.split(" ");
					splitAktuelleEingabe[0] = splitAktuelleEingabe[0].toUpperCase();
					
					while(splitAktuelleEingabe[0].equals("FERTIG") && aktuellerSpieler.getMagazin() == null){
						writer.println("Es ist noch kein Magazin erstellt. Bitte erst richtig fertig spielen!");
						aktuelleEingabe = reader.readLine();
						splitAktuelleEingabe = aktuelleEingabe.split(" ");
						splitAktuelleEingabe[0] = splitAktuelleEingabe[0].toUpperCase();
					}
					
					while(!splitAktuelleEingabe[0].equals("FERTIG")){					
						if(splitAktuelleEingabe[0].equals("HILFE")){
							hilfe(1);
						} else if(splitAktuelleEingabe[0].equals("BEENDEN")){
							System.exit(0);
						} else {
							if(splitAktuelleEingabe.length < 2){
								simulieren(splitAktuelleEingabe[0], 0);
							} else {
								if(splitAktuelleEingabe[0].equals("MAGAZIN_EROEFFNEN")){
									//richtig machen!!!
									if(aktuellerSpieler.getMagazin() == null){
										if(splitAktuelleEingabe[1].equals("München") ||
										   splitAktuelleEingabe[1].equals("Berlin") ||	
										   splitAktuelleEingabe[1].equals("Walldorf")){
											aktuellerSpieler.setMagazin(splitAktuelleEingabe[1], new Marktanteil(1/spieler.size()));
											writer.println("Magazin in " + splitAktuelleEingabe[1] + " eröffnet.");
										} else {
											writer.println("Invalide Standortwahl.");
										}
									} else {
										writer.println("Mehrere Standorte nicht erlaubt.");
									}
								} else {
									simulieren(splitAktuelleEingabe[0], Double.parseDouble(splitAktuelleEingabe[1]));
								}
							}
						}
						
						aktuelleEingabe = reader.readLine();
						splitAktuelleEingabe = aktuelleEingabe.split(" ");
						splitAktuelleEingabe[0] = splitAktuelleEingabe[0].toUpperCase();
						
						while(splitAktuelleEingabe[0].equals("FERTIG") && aktuellerSpieler.getMagazin() == null){
							writer.println("Es ist noch kein Magazin erstellt. Bitte erst richtig fertig spielen!");
							aktuelleEingabe = reader.readLine();
							splitAktuelleEingabe = aktuelleEingabe.split(" ");
							splitAktuelleEingabe[0] = splitAktuelleEingabe[0].toUpperCase();
						}
					}
					
					if(splitAktuelleEingabe[0].equals("FERTIG")){
						aktuellerSpieler.addBericht(aktuellerSpieler);
						aktuellerSpieler.getBericht(aktuelleRunde).generiereAusgabe();
						writer.println("Runde von " + aktuellerSpieler.getName() + " beendet.");
						writer.println("-----------------------------------------------");
					}
				}
			}

			aktuelleRunde++;
		}
		
		reader.close();
		writer.close();
	}
	
	private static void simulieren(String art, double Betrag){
		if(splitAktuelleEingabe[0].equals("BERICHT")){
			if(splitAktuelleEingabe.length < 2){
				if(aktuellerSpieler.getBericht(aktuelleRunde - 1) != null){
					aktuellerSpieler.getBericht(aktuelleRunde - 1).generiereAusgabe();
				} else {
					writer.println("Es sind noch keine Berichte vorhanden.");
				}
			} else if(isNumeric(splitAktuelleEingabe[1]) && Integer.parseInt(splitAktuelleEingabe[1]) > 0){
				if(aktuellerSpieler.getBericht(Integer.parseInt(splitAktuelleEingabe[1]) - 1) != null){
					aktuellerSpieler.getBericht(Integer.parseInt(splitAktuelleEingabe[1]) - 1).generiereAusgabe();
				} else {
					writer.println("Bericht mit der Nummer " + splitAktuelleEingabe[1] + " nicht vorhanden.");
				}
			} else if(!isNumeric(splitAktuelleEingabe[1])){
				writer.println("Falsche Eingabe der Zahl.");
			} else {
				writer.println("Falsche Eingabe.");
			}
		} else if(splitAktuelleEingabe[0].equals("STANDORT")){
			for(int i = 1; i <= 3; i++){
				Object[] o = Standort.getStandort(i);
				writer.println("----- Standort " + i + " -----");
				writer.println("Standort:               " + o[0]);
				writer.println("Preis:                  " + o[1]);
				writer.println("Kosten pro Runde:       " + o[2]);
				writer.println("Max. Mitarbeiteranzahl: " + o[3]);
				writer.println("-------------------------------");
			}
		} else if(splitAktuelleEingabe[0].equals("MAGAZIN_EROEFFNEN")){
			if(aktuellerSpieler.getMagazin() == null){
				if(splitAktuelleEingabe[1].equals("München") ||
				   splitAktuelleEingabe[1].equals("Berlin") ||	
				   splitAktuelleEingabe[1].equals("Walldorf")){
					aktuellerSpieler.setMagazin(splitAktuelleEingabe[1], new Marktanteil(1/spieler.size()));
				} else {
					writer.println("Invalide Standortwahl.");
				}
			} else {
				writer.println("Mehrere Standorte nicht erlaubt.");
			}
		} else if(splitAktuelleEingabe[0].equals("KREDIT_AUFNEHMEN")){
			if(Double.parseDouble(splitAktuelleEingabe[1]) > 0){
				aktuellerSpieler.simulieren(splitAktuelleEingabe[0], Double.parseDouble(splitAktuelleEingabe[1]));
			} else {
				writer.println("Es kann kein Kredit in der Höhe von 0€ oder weniger aufgenommen werden.");
			}
		} else if(splitAktuelleEingabe[0].equals("KREDIT_TILGEN")){
			if(Double.parseDouble(splitAktuelleEingabe[1]) > 0){
				aktuellerSpieler.simulieren(splitAktuelleEingabe[0], Double.parseDouble(splitAktuelleEingabe[1]));
			} else {
				writer.println("Es kann kein Kredit mit einem negativen oder 0€ - Betrag getilgt werden.");
			}			
		} else if(splitAktuelleEingabe[0].equals("WERBUNG_SCHALTEN")){
			//nochmal überprüfen!
			if(Double.parseDouble(splitAktuelleEingabe[1]) > 0){
				aktuellerSpieler.simulieren(splitAktuelleEingabe[0], Double.parseDouble(splitAktuelleEingabe[1]));
			} else {
				writer.println("Es darf keine Werbung mit einem Betrag von 0€ oder weniger geschaltet werden.");
			}
		} else if(splitAktuelleEingabe[0].equals("MITARBEITER_EINSTELLEN")){
			if(Double.parseDouble(splitAktuelleEingabe[1]) > 0){
				aktuellerSpieler.simulieren(splitAktuelleEingabe[0], Double.parseDouble(splitAktuelleEingabe[1]));
			} else {
				writer.println("Es können keine 0 oder negative Anzahl an Mitarbeiter eingestellt werden.");
			}
		} else if(splitAktuelleEingabe[0].equals("MITARBEITER_ENTLASSEN")){
			if(Double.parseDouble(splitAktuelleEingabe[1]) > 0){
				aktuellerSpieler.simulieren(splitAktuelleEingabe[0], Double.parseDouble(splitAktuelleEingabe[1]));
			} else {
				writer.println("Es können keine 0 oder negative Anzahl an Mitarbeiter entlassen werden.");
			}
		} else if(splitAktuelleEingabe[0].equals("VERKAUFSPREIS_SETZEN")){
			
		} else {
			writer.println("Invalide Eingabe. Wiederholen Sie bitte Ihre Eingabe oder suchen Sie die Hilfe unter HILFE auf.");
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