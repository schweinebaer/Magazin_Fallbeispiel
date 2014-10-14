package de.spiel.magazin;


/*
 * Organisation des Magazins
 */

public class Magazin {
	
	private Standort standort;
	private Werbung eigenwerbung;
	private Werbung fremdwerbung;
	private Marktanteil marktanteil;
	private int auflage;
	private Erlös erlös;
	private Kosten kosten;
	private Gewinn gewinn;

	public Magazin(Standort standort, Marktanteil marktanteil) {
		this.standort = standort;
		this.marktanteil = marktanteil;
	}
	
	public Standort getStandort() {
		return standort;
	}
	
	public void setStartwerte(Object[] o){
		//Daten auf Standortklasse übergeben bekommen
	}
	
	public Werbung getEW(){
		return eigenwerbung;
	}

	public Werbung getFW(){
		return fremdwerbung;
	}
	
	public void updateWerbung(double betrag, String art, double anteil){
		
	}
	
	public void updateAuflage(int auflage){
		this.auflage = auflage;
		//Erlös, Gewinn und Kosten und weitere notwenidge Daten updaten
	}
	
	private void aktualisiereWerte(){
		
	}
	
	public void simulieren(String art, double betrag){
		if(art.equals("WERBUNG_SCHALTEN")){
			//nochmal genauer wegen Befehl schauen, da man nicht richtig setzne kann
			//--> Seitenanzahl fehlt; genauer definieren
		} else if(art.equals("MITARBEITER_EINSTELLEN")){
			standort.simulieren(art, betrag);
		} else if(art.equals("MITARBEITER_ENTLASSEN")){
			standort.simulieren(art, betrag);
		} else if(art.equals("VERKAUFSPREIS_SETZEN")){
			
		} else if(art.equals("AUFLAGE_SETZEN")){
			updateAuflage((int) betrag);
		} else {
			//ignore
		}
	}
}
