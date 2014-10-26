package de.spiel.magazin;

import java.io.*;
import java.util.Vector;

public class Spiel {
	/*
	 * @author Pascal Pronobis
	 * @description Allgemeine Koordination des Spieles auf der Konsole
	 */
	
	//Überprüfen: 
	// - Fremdwerbung --> vor allem im Bericht, da komische Zhl
	// - Zufallsereignisse ab Runde 2 --> sie werden nicht angezeigt
	
	private static Vector<Spieler> spieler;
	private static Spieler aktuellerSpieler;
	private static int aktuelleRunde;
	private static int maxRunde;
	private static BufferedReader reader;
	private static PrintWriter writer;
	private static String aktuelleEingabe;
	private static String[] splitAktuelleEingabe;
	private static Zufallsereignis zufallsereignis;
	private static Object[] zufallsereignisDaten;
	private static Ergebnisliste ergebnisliste;
	
	public static void main(String[] args) throws IOException {
		zufallsereignis = new Zufallsereignis();
		
		spieler = new Vector();
		
		reader = new BufferedReader(new InputStreamReader(System.in));
		writer = new PrintWriter(System.out, true);
		
		spieler.add(new Spieler("Pascal", writer));
		spieler.add(new Spieler("Benni", writer));
		
		writer.println("Willkommen beim Planspiel!");
		writer.println("Bitte geben Sie eine maximale Rundenanzahl ein! Die Mindestrundenanzahl beträgt 5 Runden.");
		
		//Rundenanzahl abfragen
		aktuelleEingabe = reader.readLine();
		
		//Überprüfen ob Eingabe eine Zahl ist
		while(!isNumeric(aktuelleEingabe) || Integer.parseInt(aktuelleEingabe) < 5){
			aktuelleEingabe.toUpperCase();
			
			//Programm vorzeitig beenden
			if(aktuelleEingabe.equals("BEENDEN")){
				System.exit(0);
			}
			
			writer.println("Eingabe keine gültige Zahl. Bitte neu eingeben.");
			aktuelleEingabe = reader.readLine();
		}
		
		maxRunde = Integer.parseInt(aktuelleEingabe);
		writer.println("Die maximale Rundenanzahl für das Spiel beträgt " + maxRunde + " Runden.");
		
		//Spielereingaben
		writer.println("Bitte fügen Sie mindestens zwei Spieler hinzu.");
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
		
		//Ergebnisliste anlegen auf Basis der Spielerzahl
		ergebnisliste = new Ergebnisliste(writer, spieler.size());
		
		//Aktuelle Zinsoknditionen ausgeben
		writer.println("Der derzeitige Zinssatz für Kredite für alle Spieler liegt bei " + Kredit.getZinsatzNeuaufnahme() + "%.");
		writer.println("--------------------------------------------------");		
		
		//eigentliche Spielhandlungen
		while(aktuelleRunde < maxRunde){
			//allgemeines Zufallsereignis für alle Spieler berechnen
			zufallsereignisDaten = zufallsereignis.berechneZufallsEreignis();
			
			//in der ersten Runde keine Zinsänderungen durchführen lassen
			if(zufallsereignisDaten[1].equals("ZINSSATZ_ERHOEHEN") && aktuelleRunde > 0){
				writer.println(zufallsereignisDaten[0]);
				Kredit.updateZinsatz((double) zufallsereignisDaten[2]);
			} else if(zufallsereignisDaten[1].equals("ZINSSATZ_VERKLEINERN") && aktuelleRunde > 0){
				writer.println(zufallsereignisDaten[0]);
				Kredit.updateZinsatz(-1 * (double) zufallsereignisDaten[2]);
			}
			
			//Ab der zweiten Runde können auch Zinsänderungen durchgeführt werden
			if(aktuelleRunde >= 1){
				//evtl. noch folgende Nebenbedingung
				// && (zufallsereignis[1].equals("ZINSSATZ_ERHOEHEN") || zufallsereignis[1].equals("ZINSSATZ_VERKLEINERN"))
				writer.println("Der derzeitige Zinssatz für Kredite für alle Spieler liegt bei " + Kredit.getZinsatzNeuaufnahme() + "%.");
				writer.println("--------------------------------------------------");				
			}
			
			//aktuelle Berechnungen für aktuellen Spieler
			for(int i = 0; i < spieler.size(); i++){
				//genaue Berechnungen durchführen!!
				aktuellerSpieler = spieler.elementAt(i);
				
				if(aktuelleRunde > 0){
					aktuellerSpieler.getMagazin().aktualisiereWerte();
				}
				
				//Überprüfen, ob aktueller Spieler noch im Spiel ist hinsichtlich Kapital
				if(aktuellerSpieler.getKapital() < 0.0){
					writer.println(aktuellerSpieler.getName() + " hat leider nicht mehr genügend Geld.");
					spieler.remove(aktuellerSpieler);
					ergebnisliste.addSpieler(aktuellerSpieler, aktuelleRunde, null);
				} else {
					writer.println("Nächste Aktionen für " + aktuellerSpieler.getName());
					
					//ab der zweiten Runde können spielerbasierte Zufallsereignisse eintreffen
					if(aktuelleRunde > 0){
						zufallsereignisDaten = zufallsereignis.berechneZufallsEreignis();
						
						while(zufallsereignisDaten[1].equals("ZINSSATZ_ERHOEHEN") || zufallsereignisDaten[1].equals("ZINSSATZ_VERKLEINERN") || zufallsereignisDaten == null){
							zufallsereignisDaten = zufallsereignis.berechneZufallsEreignis();
						}
						
						writer.println(zufallsereignisDaten[0]);
						
						if(zufallsereignisDaten[3] == null){
							simulierenZufall((String) zufallsereignisDaten[1], (double) zufallsereignisDaten[2], 0.0);
						} else {
							simulierenZufall((String) zufallsereignisDaten[1], (double) zufallsereignisDaten[2], (double) zufallsereignisDaten[3]);
						}
					}
					
					//Eingaben lesen
					aktuelleEingabe = reader.readLine();
					splitAktuelleEingabe = aktuelleEingabe.split(" ");
					splitAktuelleEingabe[0] = splitAktuelleEingabe[0].toUpperCase();
					
					//Keine Runde aufhören ohne ein Magazin zu erstellen
					while(splitAktuelleEingabe[0].equals("FERTIG") && aktuellerSpieler.getMagazin() == null){
						writer.println("Es ist noch kein Magazin erstellt. Bitte erst richtig fertig spielen!");
						aktuelleEingabe = reader.readLine();
						splitAktuelleEingabe = aktuelleEingabe.split(" ");
						splitAktuelleEingabe[0] = splitAktuelleEingabe[0].toUpperCase();
					}
					
					//Eingaben überprüfen und Aktionen in die Wege leiten
					while(!splitAktuelleEingabe[0].equals("RUNDE_FERTIG")){					
						try{
							if(splitAktuelleEingabe[0].equals("HILFE")){
								hilfe(1);
							} else if(splitAktuelleEingabe[0].equals("BEENDEN")){
								System.exit(0);
							} else {
								if(splitAktuelleEingabe.length < 2){
									simulieren(splitAktuelleEingabe[0], 0);
								} else {
									if(splitAktuelleEingabe[0].equals("MAGAZIN_EROEFFNEN")){
										if(aktuellerSpieler.getMagazin() == null){
											if(splitAktuelleEingabe[1].equals("München")  
												|| splitAktuelleEingabe[1].equals("Berlin")   
												|| splitAktuelleEingabe[1].equals("Walldorf") 
												|| splitAktuelleEingabe[1].equals("Bonn")){
												
												if(splitAktuelleEingabe[1].equals("München")){
													aktuellerSpieler.setMagazin(splitAktuelleEingabe[1]);
												} else if(splitAktuelleEingabe[1].equals("Berlin")){
													aktuellerSpieler.setMagazin(splitAktuelleEingabe[1]);
												} else if(splitAktuelleEingabe[1].equals("Walldorf")){
													aktuellerSpieler.setMagazin(splitAktuelleEingabe[1]);
												} else if(splitAktuelleEingabe[1].equals("Bonn")){
													aktuellerSpieler.setMagazin(splitAktuelleEingabe[1]);
												} else {
													//ignore
												}
												
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
						} catch(Exception e){
							writer.println("Falsche Eingabe. Geben Sie erneut was ein. Unter HILFE finden sie erwiterte Informationen.");
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
					
					if(splitAktuelleEingabe[0].equals("RUNDE_FERTIG")){
						if(aktuelleRunde > 0){
							Marktanteil.updateAbgesetzteMengeGesamt(spieler);
						}
						
						aktuellerSpieler.getMagazin().aktualisiereWerte();
						aktuellerSpieler.updateKapital();
						aktuellerSpieler.addBericht(aktuellerSpieler);
						aktuellerSpieler.getBericht(aktuelleRunde).generiereAusgabe();
						writer.println("Runde von " + aktuellerSpieler.getName() + " beendet.");
						writer.println("-----------------------------------------------");
					}
				}
				
				if(aktuelleRunde > 0){
					Marktanteil.updateAbgesetzteMengeGesamt(spieler);
					/*Spieler tmp;
					
					for(int j = 0; (j < spieler.size()) && spieler.elementAt(j) != null; j++){
						tmp = spieler.get(j);
						tmp.getMagazin().updateMarktanteil();
					}*/
				}
			}
			
			if(aktuelleRunde == 0){
				Marktanteil.updateAbgesetzteMengeGesamt(spieler);
				/*Spieler tmp;
				
				for(int i = 0; i < spieler.size(); i++){
					tmp = spieler.get(i);
					tmp.getMagazin().updateMarktanteil();
				}*/
			}
			
			aktuelleRunde++;
		}
		
		while(!spieler.isEmpty()){
			Spieler tmp1;
			Spieler tmp2;
			
			tmp1 = spieler.get(0);
			
			for(int i = 1; i < spieler.size(); i++){
				tmp2 = spieler.get(i);
				
				if(tmp2.getMagazin().getMarktanteil().getAnteil() < tmp2.getMagazin().getMarktanteil().getAnteil()){
					tmp1 = tmp2;
				}
			}
			
			spieler.remove(tmp1);
			
			ergebnisliste.addSpieler(tmp1, aktuelleRunde, tmp1.getMagazin().getMarktanteil());
		}
		
		ergebnisliste.ausgabeListe();
		
		reader.close();
		writer.close();
	}
	
	private static void simulierenZufall(String art, double betrag, double betrag2){
		//Zufallsereignisse simulieren
		if(art.equals("ABSATZPLUS_EINMALIG") 
			|| art.equals("ABSATZMINUS_EINMALIG")
			|| art.equals("ROHSTOFFPREISE_ERHOEHEN")
			|| art.equals("ROHSTOFFPREISE_SENKEN")
			|| art.equals("SPENDE_BEKOMMEN")
			|| art.equals("RECHTSSTREIT")
			|| art.equals("TARIFVERHANDLUNG")
			|| art.equals("QUALITAETSEINBRUCH")
			|| art.equals("JOURNALISTENPREIS")
			|| art.equals("WERBEEINNAHMEN_MINDERUNG")){
			aktuellerSpieler.getMagazin().simulieren(art, betrag, betrag2);
		} else {
			//ignore
		}
	}
	
	private static void simulieren(String art, double betrag){
		//normale Spielereignisse simulieren
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
			for(int i = 1; i <= 4; i++){
				Object[] o = Standort.getStandort(i);
				StandortAusgabe.ausgabeStandortStartwerte(o, i, writer);
			}
		} else if(splitAktuelleEingabe[0].equals("MAGAZIN_EROEFFNEN")){
			if(aktuellerSpieler.getMagazin() == null){
				if(splitAktuelleEingabe[1].equals("München") 
					|| splitAktuelleEingabe[1].equals("Berlin") 
					|| splitAktuelleEingabe[1].equals("Walldorf")
					|| splitAktuelleEingabe[1].equals("Bonn")){
					if(splitAktuelleEingabe[1].equals("München")){
						aktuellerSpieler.setMagazin(splitAktuelleEingabe[1]);
					} else if(splitAktuelleEingabe[1].equals("Berlin")){
						aktuellerSpieler.setMagazin(splitAktuelleEingabe[1]);
					} else if(splitAktuelleEingabe[1].equals("Walldorf")){
						aktuellerSpieler.setMagazin(splitAktuelleEingabe[1]);
					} else if(splitAktuelleEingabe[1].equals("Bonn")){
						aktuellerSpieler.setMagazin(splitAktuelleEingabe[1]);
					} else {
						//ignore
					}
				} else {
					writer.println("Invalide Standortwahl.");
				}
			} else {
				writer.println("Mehrere Standorte nicht erlaubt.");
			}
		} else if(splitAktuelleEingabe[0].equals("KREDIT_AUFNEHMEN")){
			if(Double.parseDouble(splitAktuelleEingabe[1]) > 0){
				aktuellerSpieler.simulieren(splitAktuelleEingabe[0], rundeBetrag(Double.parseDouble(splitAktuelleEingabe[1])));
			} else {
				writer.println("Es kann kein Kredit in der Höhe von 0€ oder weniger aufgenommen werden.");
			}
		} else if(splitAktuelleEingabe[0].equals("KREDIT_TILGEN")){
			if(Double.parseDouble(splitAktuelleEingabe[1]) > 0){
				aktuellerSpieler.simulieren(splitAktuelleEingabe[0], rundeBetrag(Double.parseDouble(splitAktuelleEingabe[1])));
			} else {
				writer.println("Es kann kein Kredit mit einem negativen oder 0€ - Betrag getilgt werden.");
			}			
		} else if(splitAktuelleEingabe[0].equals("WERBUNG_SCHALTEN")){
			//nochmal überprüfen! --> hinsichtlich ob Zahl mit Nachkommastellen oder nicht
			if(Double.parseDouble(splitAktuelleEingabe[1]) > 0){
				aktuellerSpieler.getMagazin().simulieren(splitAktuelleEingabe[0], Double.parseDouble(splitAktuelleEingabe[1]), 0.0);
			} else {
				writer.println("Es darf keine Werbung mit einem Betrag von 0€ oder weniger geschaltet werden.");
			}
		} else if(splitAktuelleEingabe[0].equals("WERBUNG_MAGAZIN")){
			if(Double.parseDouble(splitAktuelleEingabe[1]) > 0 && Double.parseDouble(splitAktuelleEingabe[1]) <= 151){
				aktuellerSpieler.getMagazin().simulieren(splitAktuelleEingabe[0], Double.parseDouble(splitAktuelleEingabe[1]), 0.0);
			} else {
				writer.println("Kein valider Werbeanteil für das Magazin. Bitte geben Sie einen Wert zwischen 1 und 150 ein.");
			}
		} else if(splitAktuelleEingabe[0].equals("MITARBEITER_EINSTELLEN")){
			if(Double.parseDouble(splitAktuelleEingabe[1]) > 0){
				aktuellerSpieler.getMagazin().simulieren(splitAktuelleEingabe[0], Double.parseDouble(splitAktuelleEingabe[1]), 0.0);
			} else {
				writer.println("Es können keine 0 oder negative Anzahl an Mitarbeiter eingestellt werden.");
			}
		} else if(splitAktuelleEingabe[0].equals("MITARBEITER_ENTLASSEN")){
			if(Double.parseDouble(splitAktuelleEingabe[1]) > 0){
				aktuellerSpieler.getMagazin().simulieren(splitAktuelleEingabe[0], Double.parseDouble(splitAktuelleEingabe[1]), 0.0);
			} else {
				writer.println("Es können keine 0 oder negative Anzahl an Mitarbeiter entlassen werden.");
			}
		} else if(splitAktuelleEingabe[0].equals("MITARBEITER_SCHULEN")){
			aktuellerSpieler.getMagazin().simulieren(splitAktuelleEingabe[0], 0.0, 0.0);
		} else if(splitAktuelleEingabe[0].equals("VERKAUFSPREIS_SETZEN")){
			aktuellerSpieler.getMagazin().simulieren(splitAktuelleEingabe[0], rundeBetrag(Double.parseDouble(splitAktuelleEingabe[1])), 0.0);
		} else if(splitAktuelleEingabe[0].equals("AUFLAGE_SETZEN")){
			aktuellerSpieler.getMagazin().simulieren(splitAktuelleEingabe[0], Double.parseDouble(splitAktuelleEingabe[1]), 0.0);
		} else {
			writer.println("Invalide Eingabe. Wiederholen Sie bitte Ihre Eingabe oder suchen Sie die Hilfe unter HILFE auf.");
		}
	}
	
	private static void hilfe(int art){
		//Ausgabe Hilfe --> Befehle etc.
		if(art == 0){
			writer.println("---------- HILFE ----------");
			writer.println("Es stehen folgende Kommandos zur Verfügung (Kommandos in Großbuchstaben, Parameter in Kamelschreibweise)");
			writer.println("HILFE ------------------------------------------------- Zeigt eine Liste aller Kommandos an");
			writer.println("SPIELER_HINZUFUEGEN nameDesSpielers ------------------- Fügt einen neuen Spieler mit dem entsprechenden Namen hinzu");
			writer.println("SPIELER_FERTIG ---------------------------------------- Beendet die Eingabe der Spieler");
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
			writer.println("WERBUNG_SCHALTEN aktion ------------------------------- Setzt den Anteil der Werbeaktionen für das Magazin auf aktion Aktionen zu je 10.000€");
			writer.println("WERBUNG_MAGAZIN anteil -------------------------------- Der Werbeanteil im Magazin wird auf anteil Seiten gesetzt (12.500€ pro Seite)");
			writer.println("MITARBEITER_EINSTELLEN mitarbeiterAnzahl -------------- Stellt mitarbeiterAnzahl Mitarbeiter im Magazin ein");
			writer.println("MITARBEITER_ENTLASSEN mitarbeiterAnzahl --------------- Entlässt mitarbeiterAnzahl Mitarbeiter aus dem Magazin");
			writer.println("MITARBEITER_SCHULEN ----------------------------------- Mitarbeiter werden um eine Schulungseinheit geschult");
			writer.println("VERKAUFSPREIS_SETZEN preis ---------------------------- Setzt den Preis für das Magazin");
			writer.println("AUFLAGE_SETZEN auflage -------------------------------- Setzt die Auflage für das Magazin auf auflage");
			writer.println("RUNDE_FERTIG ------------------------------------------ Beendet das Treffen der Entscheidungen und lässt den nächsten Spieler dran");
		} else {
			//ignore
		}
	}
	
	private static boolean isNumeric(String z){
		//Überprüfen, ob Eingabe eine Zahl
		int zahl = 0;
		
		try {
			zahl = Integer.parseInt(z);
		} catch(NumberFormatException e){
			return false;
		}
		
		return true;
	}
	
    private static double rundeBetrag(double betrag){ 
      double round = Math.round(betrag*10000); 
      
      round = round / 10000; 
      round = Math.round(round*1000); 
      round = round / 1000; 
      round = Math.round(round*100); 
      
      return round / 100; 
    }
}