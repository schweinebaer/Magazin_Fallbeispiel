package de.spiel.magazin;

public class Erlös {
	private double erloesVerkauf;
	private double erloesFW;
	private double erloesGesamt;
	
	public Erlös(double erloesVerkauf, double erloesFW, double erloesGesamt){
		this.erloesVerkauf = erloesGesamt;
		this.erloesFW = erloesFW;
		this.erloesGesamt = erloesGesamt;
	}
	
	public void updateVerkaufserloes(double betrag){
		erloesVerkauf = betrag;
		erloesGesamt += betrag;
	}
	
	public void updateFWErloes(double betrag){
		erloesFW = betrag;
		erloesGesamt += betrag;
	}
	
	public void updateVerkaufUndFW(double betragVerkauf, double betragFW){
		erloesVerkauf = betragVerkauf;
		erloesFW = betragFW;
		erloesGesamt += (betragVerkauf + betragFW);
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