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
	private Erlös erloes;
	private Kosten kosten;
	private Gewinn gewinn;
	private Umsatz umsatzMagazin;
	
	private double magazinkosten;
	private final int maxMitarbeiter;
	private int mitarbeiter;
	private double gehalt;
	private double kostenMitarbeiter;
	private Angestellte angestellte;
	private final int maxAuflage;
	private int gedruckteMagazine;
	private int abgesetzteMenge;
	private double kostenDruck;
	private int fwInSeitenProHeft;
	private final int maxSeitenFW;
	private int ewInAktionen;
	private double kostenEW;
	private final int maxEWAktionen;
	private double preisProHeft;
	private final double maxPreisProHeft;
	private double kostenGesamt;
	private double erloesVerkauf;
	private double erloesFW;
	private double erloesGesamt;
	private double umsatz;
	private double kapital;

	public Magazin(Standort standort, Object[] standortDaten, Marktanteil marktanteil) {
		Object[] o = standortDaten;
		
		this.standort = standort;
		this.marktanteil = marktanteil;
		
		magazinkosten = (double) o[2];
		maxMitarbeiter = (int) o[3];
		mitarbeiter = (int) o[4];
		gehalt = (double) o[5];
		kostenMitarbeiter = (double) o[6];
		maxAuflage = (int) o[7];
		gedruckteMagazine = (int) o[8];
		abgesetzteMenge = (int) o[9];
		kostenDruck = (double) o[10];
		fwInSeitenProHeft = (int) o[11];
		maxSeitenFW = (int) o[12];
		ewInAktionen = (int) o[13];
		kostenEW = (double) o[14];
		maxEWAktionen = (int) o[15];
		preisProHeft = (double) o[16];
		maxPreisProHeft = (double) o[17];
		kostenGesamt = (double) o[18];
		erloesVerkauf = (double) o[19];
		erloesFW = (double) o[20];
		erloesGesamt = (double) o[21];
		umsatz = (double) o[22];
		kapital = (double) o[23];
		
		double qualitaet;
		qualitaet = (ewInAktionen/maxEWAktionen + fwInSeitenProHeft/maxSeitenFW + mitarbeiter/maxMitarbeiter + preisProHeft/maxPreisProHeft) / 4;
		angestellte = new Angestellte((int) o[4], (double) o[5], qualitaet);
		
		erloes = new Erlös((double) o[19], (double) o[20], (double) o[21]);
		kosten = new Kosten((int) o[8], (int) o[9], (double) o[10], (double) o[6], (double) o[14], (double) o[18]);
		umsatzMagazin = new Umsatz(erloes.getGesamtErloes(), kosten.getGesamtKosten());
		
		eigenwerbung = new Werbung(0, (int) o[13], (int) o[15], 0);
		fremdwerbung = new Werbung(1, (int) o[11], (int) o[12], (int) o[8]);
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
