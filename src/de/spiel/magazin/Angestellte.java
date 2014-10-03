package de.spiel.magazin;

public class Angestellte {
	/*
	 * @author Pascal Pronobis
	 */
	
	private int anzahlGesamt;
	private int anzahlBereichA;
	private int anzahlBereichB;
	private int anzahlBereichC;
	private double gehalt;
	private double qualitaet;
	
	public Angestellte(int ag, double g, double q){
		anzahlGesamt = ag;
		anzahlBereichA = (int) ag * 2/4;
		anzahlBereichB = (int) ag * 1/4;
		anzahlBereichC = (int) ag * 1/4;
		gehalt = g;
		qualitaet = q;
	}
	
	public void schulen(double investition){
		
	}
	
	public void einstellten(int anzahl){
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
	
	public double getGehalt(){
		return gehalt;
	}
	
	public double getQualitaet(){
		return qualitaet;
	}
}
