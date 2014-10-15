package de.spiel.magazin;

public class Kosten {
	private int gedruckteMagazine;
	private int abgesetzteMagazine;
	private double kostenDruck;
	private double kostenPersonal;
	private double kostenEW;
	private double kostenGesamt;
	
	public Kosten(int gedruckteMagazine, int abgesetzteMagazine, double druck, double personal, double ew, double kostenGesamt){
		this.gedruckteMagazine = gedruckteMagazine;
		this.abgesetzteMagazine = abgesetzteMagazine;
		kostenDruck = druck;
		kostenPersonal = personal;
		this.kostenGesamt = kostenGesamt;
	}
	
	public void updateDruckKosten(double druck){
		kostenGesamt += (kostenDruck - druck);
		kostenDruck = druck;
	}
	
	public void updatePersonalKosten(double personal){
		kostenGesamt += (kostenPersonal - personal);
		kostenPersonal = personal;
	}
	
	public void updateEWKosten(double ew){
		kostenGesamt += (kostenEW - ew);
		kostenEW = ew;
	}
	
	public void updateKosten(int gedruckteMagazine, int abgesetzteMagazine, double druck, double personal, double ew, double kostenGesamt){
		kostenGesamt += ((kostenDruck - druck) + (kostenPersonal - personal) + (kostenEW - ew));
		kostenDruck = druck;
		kostenPersonal = personal;
		kostenEW = ew;
	}
	
	public void updateGedruckteMag(int auflage){
		gedruckteMagazine = auflage;
		kostenGesamt -= kostenDruck;
		kostenDruck = auflage * 0.2;
		kostenGesamt += kostenDruck;
	}
	
	public void updateAbgesetzteMag(int absatz){
		abgesetzteMagazine = absatz;
	}
	
	public double getGesamtKosten(){
		return kostenGesamt;
	}
	
	public double[] getKosten(){
		double[] d = new double[4];
		
		d[0] = kostenDruck;
		d[1] = kostenPersonal;
		d[2] = kostenEW;
		d[3] = kostenGesamt;
		
		return d;
	}
}