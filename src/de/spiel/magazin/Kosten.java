package de.spiel.magazin;

public class Kosten {
	private double kostenPapierProHeft;
	private double kostenDruckProHeft;
	private double personalKostenProHeft;
	private double gesamtKostenAuflage;
	private double gesamtkostenProHeft;
	private int auflage;
	
	public Kosten(){
		
	}
	
	public void updateKosten(double papier, double druck, double personal){
		kostenPapierProHeft = papier;
		kostenDruckProHeft = druck;
		personalKostenProHeft = personal;
	}
	
	public void updateAuflage(int auflage){
		
	}
	
	public double[] getKosten(){
		double[] d = new double[5];
		d[0] = kostenPapierProHeft;
		d[1] = kostenDruckProHeft;
		d[2] = personalKostenProHeft;
		d[3] = gesamtKostenAuflage;
		d[4] = gesamtkostenProHeft;
		return d;
	}
}