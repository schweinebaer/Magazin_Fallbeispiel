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
	
	private double magazinkosten;
	private int maxMitarbeiter;
	private int mitarbeiter;
	private double gehalt;
	private double kostenMitarbeiter;
	private Angestellte angestellte;
	private int maxAuflage;
	private int gedruckteMagazine;
	private int abgesetzteMenge;
	private double kostenDruck;
	private int fwInSeitenProHeft;
	private int maxSeitenFW;
	private int ewInAktionen;
	private double kostenEW;
	private int maxEWAktionen;
	private double preisProHeft;
	private double maxPreisProHeft;
	private double kostenGesamt;
	private double erloesVerkauf;
	private double erloesFW;
	private double erloesGesamt;
	private double umsatz;
	private double kapital;

	public Magazin(Standort standort, Object[] standortDaten, Marktanteil marktanteil) {
		this.standort = standort;
		this.marktanteil = marktanteil;
		
		Object[] o = standortDaten;
		
		/*
		if(standort.getOrt().equals("München")){
			o = standort.getStandort(1);
		} else if(standort.getOrt().equals("Berlin")){
			o = standort.getStandort(2);
		} else if(standort.getOrt().equals("Walldorf")){
			o = standort.getStandort(3);
		} else if(standort.getOrt().equals("Bonn")){
			o = standort.getStandort(4);
		} else {
			//ignore;
		}
		*/
		
		//erhaltene Werte einpflegen
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

	public int getMaxMitarbeiter(int maxMitabeiter) {
		return maxMitarbeiter;
	}
	
	public int[] getMitarbeiter(){
		return angestellte.getBereichsZahlen();
	}
	
	public Object[] getAktuelleDaten(){
		return null;
	}
	
	public void simulieren(String art, double betrag){
		if(art.equals("WERBUNG_SCHALTEN")){
			//nochmal genauer wegen Befehl schauen, da man nicht richtig setzne kann
			//--> Seitenanzahl fehlt; genauer definieren
		} else if(art.equals("MITARBEITER_EINSTELLEN") || 
				  art.equals("MITARBEITER_ENTLASSEN") ||
				  art.equals("MITARBEITER_SCHULEN")){
			angestellte.simulieren(art, betrag);
		} else if(art.equals("VERKAUFSPREIS_SETZEN")){
			
		} else if(art.equals("AUFLAGE_SETZEN")){
			updateAuflage((int) betrag);
		} else {
			//ignore
		}
	}
}
