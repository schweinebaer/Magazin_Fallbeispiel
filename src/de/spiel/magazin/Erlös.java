package de.spiel.magazin;

public class Erlös {
	private int abgesetzteMagazine;
	private double preisMagazin;
	private double erloesVerkauf;
	private double erloesFW;
	private double erloesGesamt;
	
	public Erlös(int abgesetzteMagazine, double preisMagazin, double erloesVerkauf, double erloesFW, double erloesGesamt){
		this.abgesetzteMagazine = abgesetzteMagazine;
		this.preisMagazin = preisMagazin;
		this.erloesVerkauf = erloesGesamt;
		this.erloesFW = erloesFW;
		this.erloesGesamt = erloesGesamt;
	}
	
	public void updateAbgesetzteMagazine(int anzahl){
		erloesGesamt -= erloesVerkauf;
		abgesetzteMagazine = anzahl;
		erloesVerkauf = anzahl * preisMagazin;
		erloesGesamt += erloesVerkauf;
	}
	
	public void updatePreisMagazin(double preis){
		erloesGesamt -= erloesVerkauf;
		preisMagazin = preis;
		erloesVerkauf = abgesetzteMagazine * preis;
		erloesGesamt += erloesVerkauf;
	}
	
	public void updateVerkaufserloes(int anzahl, double preis){
		erloesGesamt -= erloesVerkauf;
		abgesetzteMagazine = anzahl;
		preisMagazin = preis;
		erloesVerkauf = anzahl * preis;
		erloesGesamt += erloesVerkauf;
	}
	
	public void updateFWErloes(double betrag){
		erloesFW = betrag;
		erloesGesamt += betrag;
	}
	
	public double getGesamtErloes(){
		return erloesGesamt;
	}
	
	public double[] getErloese(){
		double[] tmp = new double[3];
		
		tmp[0] = erloesVerkauf;
		tmp[1] = erloesFW;
		tmp[2] = erloesGesamt;
		
		return tmp;
	}
}