package de.spiel.magazin;

public class Umsatz {
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
		return umsatz;
	}
}