package de.spiel.magazin;

public class Angestellte {
	/*
	 * @author Pascal Pronobis
	 */
	
	private int maxAnzahlGesamt;
	private int anzahlGesamt;
	private int anzahlHR;
	private int anzahlJournalisten;
	private int anzahlBereichA;
	private int anzahlBereichB;
	private int anzahlBereichC;
	private double gehalt;
	private double qualitaet;
	
	public Angestellte(int maxAnzahlGesamt, int anzahlGesamt, double gehalt, double qualitaet){
		this.maxAnzahlGesamt = maxAnzahlGesamt;
		this.anzahlGesamt = anzahlGesamt;
		
		anzahlHR = (int) anzahlGesamt * 1/6;
		anzahlJournalisten = (int) anzahlGesamt * 5/6;
		
		anzahlBereichA = (int) anzahlGesamt * 2/4;
		anzahlBereichB = (int) anzahlGesamt * 1/4;
		anzahlBereichC = (int) anzahlGesamt * 1/4;
		this.gehalt = gehalt;
		this.qualitaet = qualitaet;
	}
	
	public void schulen(double investition){
		
	}
	
	public boolean einstellen(int anzahl){
		if((anzahl + anzahlGesamt) <= maxAnzahlGesamt){
			anzahlGesamt += anzahl;
			
			anzahlHR += (int) anzahl * 1/6;
			anzahlJournalisten += (int) anzahl * 5/6;
			
			anzahlBereichA += (int) anzahl * 2/4;
			anzahlBereichB += (int) anzahl * 1/4;
			anzahlBereichC += (int) anzahl * 1/4;
			return true;
		} else {
			return false;
		}
	}
	
	public void entlassen(int anzahl){
		if((anzahlGesamt - anzahl) <= 0){
			anzahlGesamt = 0;
			
			anzahlHR = 0;
			anzahlJournalisten = 0;
			
			anzahlBereichA = 0;
			anzahlBereichB = 0;
			anzahlBereichC = 0;
		} else {
			anzahlGesamt -= anzahl;
			
			anzahlHR -= (int) anzahl * 1/6;
			anzahlJournalisten -= (int) anzahl * 5/6;
			
			anzahlBereichA -= (int) anzahl * 2/4;
			anzahlBereichB -= (int) anzahl * 1/4;
			anzahlBereichC -= (int) anzahl * 1/4;
		}
	}
	
	public void aktualisiereGehalt(double betrag){
		gehalt *= betrag;
	}
	
	public int[] getBereichsZahlen(){
		int[] tmp = new int[5];
		tmp[0] = anzahlBereichA;
		tmp[1] = anzahlBereichB;
		tmp[2] = anzahlBereichC;
		tmp[3] = anzahlHR;
		tmp[4] = anzahlJournalisten;
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
			boolean tmp = einstellen((int) betrag);
			
			if(!tmp){
				//Konsolenausgabe
			}
		} else if(art.equals("MITARBEITER_ENTLASSEN")){
			entlassen((int) betrag);
		} else if(art.equals("MITARBEITER_SCHULEN")){
			schulen(betrag);
		} else {
			//ignore
		}
	}
}
