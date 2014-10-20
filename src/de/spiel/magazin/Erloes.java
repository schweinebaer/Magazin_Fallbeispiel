package de.spiel.magazin;

public class Erloes {
	private int abgesetzteMagazine;
	private double preisMagazin;
	private double erloesVerkauf;
	private double erloesFW;
	private double erloesZusatz;
	private double erloesGesamt;
	
	public Erloes(int abgesetzteMagazine, double preisMagazin, double erloesVerkauf, double erloesFW, double erloesGesamt){
		this.abgesetzteMagazine = abgesetzteMagazine;
		this.preisMagazin = preisMagazin;
		this.erloesVerkauf = erloesGesamt;
		this.erloesFW = erloesFW;
		this.erloesZusatz = 0;
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
	
	public void speziellesErloeseUpdate(String art, double betrag){
		if(art.equals("ABSATZPLUS_EIMALIG")){
			erloesZusatz = preisMagazin * betrag;
			erloesGesamt += erloesZusatz;
			erloesZusatz = 0;
		} else if (art.equals("ABSATZMINUS_EINMALIG")){
			erloesZusatz = preisMagazin * betrag;
			erloesGesamt -= erloesZusatz;
			erloesZusatz = 0;
		} else if(art.equals("SPENDE_BEKOMMEN")){
			erloesZusatz = betrag;
			erloesGesamt  += erloesZusatz;
			erloesZusatz = 0;
		} else if(art.equals("RECHTSSTREIT")){
			erloesGesamt -= erloesVerkauf;
			abgesetzteMagazine += betrag;
			erloesVerkauf = abgesetzteMagazine * preisMagazin;
			abgesetzteMagazine -= betrag;
			erloesGesamt += erloesVerkauf;
			erloesVerkauf = abgesetzteMagazine * preisMagazin;
		} else {
			//ignore
		}
	}
	
	public void updateFWErloes(double betrag){
		erloesFW = betrag;
		erloesGesamt += betrag;
	}
	
	public void aktualisieren(){
		erloesGesamt = erloesVerkauf + erloesFW;
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