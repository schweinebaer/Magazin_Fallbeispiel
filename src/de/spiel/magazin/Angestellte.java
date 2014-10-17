package de.spiel.magazin;

public class Angestellte {
	/*
	 * @author Pascal Pronobis
	 */
	
	private int anzahlGesamt;
	//HR und Journalisten --> Benni nochmal wegen genauer Aufspaltung nachfragen
	private int anzahlBereichA;
	private int anzahlBereichB;
	private int anzahlBereichC;
	private double gehalt;
	private double qualitaet;
	
	public Angestellte(int anzahlGesamt, double gehalt, double qualitaet){
		this.anzahlGesamt = anzahlGesamt;
		anzahlBereichA = (int) anzahlGesamt * 2/4;
		anzahlBereichB = (int) anzahlGesamt * 1/4;
		anzahlBereichC = (int) anzahlGesamt * 1/4;
		this.gehalt = gehalt;
		this.qualitaet = qualitaet;
	}
	
	public void schulen(double investition){
		
	}
	
	public void einstellen(int anzahl){
		anzahlGesamt += anzahl;
		anzahlBereichA += (int) anzahl * 2/4;
		anzahlBereichB += (int) anzahl * 1/4;
		anzahlBereichC += (int) anzahl * 1/4;
	}
	
	public void entlassen(int anzahl){
		anzahlGesamt -= anzahl;
		anzahlBereichA -= (int) anzahl * 2/4;
		anzahlBereichB -= (int) anzahl * 1/4;
		anzahlBereichC -= (int) anzahl * 1/4;
	}
	
	public int[] getBereichsZahlen(){
		int[] tmp = new int[3];
		tmp[0] = anzahlBereichA;
		tmp[1] = anzahlBereichB;
		tmp[2] = anzahlBereichC;
		return tmp;
	}
	
	public int getAnzahlAngestellte(){
		return anzahlGesamt;
	}
	
	public double getGehalt(){
		return gehalt;
	}
	
	public double getQualitaet(){
		return qualitaet;
	}
	
	public void simulieren(String art, double betrag){
		if(art.equals("MITARBEITER_EINSTELLEN")){
			
		} else if(art.equals("MITARBEITER_ENTLASSEN")){
			
		} else if(art.equals("MITARBEITER_SCHULEN")){
			
		} else {
			
		}
	}
}
