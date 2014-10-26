package de.spiel.magazin;

public class Umsatz {
	/*
	 * @author Pascal Pronobis
	 * @description Eigentlich Erlösklasse --> Umsatz und Erlös wurden vertauscht  
	 */
	
	private double erloes;
	private double kosten;
	private double umsatz;
	
	public Umsatz(double erloes, double kosten){
		this.erloes = erloes;
		this.kosten = kosten;
		umsatz = erloes - kosten;
	}
	
	public void updateErloes(double erloes){
		umsatz -= this.erloes;
		this.erloes = erloes;
		umsatz += this.erloes;
	}
	
	public void updateKosten(double kosten){
		umsatz += this.kosten;
		this.kosten = kosten;
		umsatz -= this.kosten;
	}
	
	public double getUmsatz(){
		return rundeBetrag(umsatz);
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