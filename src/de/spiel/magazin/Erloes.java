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
		erloesVerkauf = rundeBetrag(anzahl * preisMagazin);
		erloesGesamt += erloesVerkauf;
	}
	
	public void updatePreisMagazin(double preis){
		erloesGesamt -= erloesVerkauf;
		preisMagazin = preis;
		erloesVerkauf = rundeBetrag(abgesetzteMagazine * preis);
		erloesGesamt += erloesVerkauf;
	}
	
	public void updateVerkaufserloes(int anzahl, double preis){
		erloesGesamt -= erloesVerkauf;
		abgesetzteMagazine = anzahl;
		preisMagazin = preis;
		erloesVerkauf = rundeBetrag(anzahl * preis);
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
			erloesVerkauf = rundeBetrag(abgesetzteMagazine * preisMagazin);
			abgesetzteMagazine -= betrag;
			erloesGesamt += erloesVerkauf;
			erloesVerkauf = rundeBetrag(abgesetzteMagazine * preisMagazin);
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
	
	private double rundeBetrag(double betrag){ 
	      double round = Math.round(betrag*10000); 
	      
	      round = round / 10000; 
	      round = Math.round(round*1000); 
	      round = round / 1000; 
	      round = Math.round(round*100); 
	      
	      return round / 100; 
	 }
}