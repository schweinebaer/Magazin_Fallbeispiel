package de.spiel.magazin;


/*
 * Organisation des Magazins
 */

public class Magazin {
	
	private Standort standort;
	private Werbung eigenwerbung;
	private Werbung fremdwerbung;
	private Marktanteil marktanteil;
	private double kostenPapierProHeft;
	private double kostenDruckProHeft;
	private double PersonalkostenProHeft;
	private double gesamtkostenProHeft;
	private int auflage;
	private double gesamtkostenAuflage;
	private double einnahmenAuflage;
	private double gewinnAuflage;
	private int mitarbeiter;
	private int mitarbeiterbeginn;
	private int mitarbeiterfrei;

	public void Magazin(Standort standort, Marktanteil marktanteil) {
		this.standort = standort;
		setmitarbeiter(0);
		aktuellerMitarbeiterstand();
	}

	private void aktuellerMitarbeiterstand() {
		this.setmitarbeiter(this.getStandort().getMaxMitarbeiter(this.getMitarbeiter()));
		mitarbeiterbeginn = mitarbeiterfrei;
		System.out.println(mitarbeiter);
		System.out.println(mitarbeiterbeginn);
		System.out.println(mitarbeiterfrei);
	}

	private void setmitarbeiter(int i) {
		// TODO Auto-generated method stub
		
	}
	
	public Standort getStandort() {
		return this.standort;
	}
	
	public int getMitarbeiter(){
		return this.mitarbeiter;
	}

	

}
