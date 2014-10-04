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
	private int mitarbeiter;
	private int mitarbeiterbeginn;
	private int mitarbeiterfrei;
	private Erlös erlös;
	private Kosten kosten;
	private Gewinn gewinn;

	public Magazin(Standort standort, Marktanteil marktanteil) {
		this.standort = standort;
		setMitarbeiter(0);
		aktuellerMitarbeiterstand();
	}

	private void aktuellerMitarbeiterstand() {
		this.setMitarbeiter(this.getStandort().getMaxMitarbeiter(this.getMitarbeiter()));
		mitarbeiterbeginn = mitarbeiterfrei;
		System.out.println(mitarbeiter);
		System.out.println(mitarbeiterbeginn);
		System.out.println(mitarbeiterfrei);
	}

	private void setMitarbeiter(int i) {
		
	}
	
	public Standort getStandort() {
		return standort;
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
		
	}
	
	public int getMitarbeiter(){
		return mitarbeiter;
	}

	public void simulieren(String art, double Betrag){
		
	}
}
