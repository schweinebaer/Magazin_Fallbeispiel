package de.spiel.magazin;

public class Kosten {
	private int gedruckteMagazine;
	private int abgesetzteMagazine;
	private double kostenDruck;
	private double kostenPersonal;
	private double kostenEW;
	private double kostenFix;
	private double kostenZusatz;
	private double kostenGesamt;
	
	public Kosten(int gedruckteMagazine, int abgesetzteMagazine, double druck, double personal, double ew, double kostenFix, double kostenGesamt){
		this.gedruckteMagazine = gedruckteMagazine;
		this.abgesetzteMagazine = abgesetzteMagazine;
		kostenDruck = druck;
		kostenPersonal = personal;
		this.kostenFix = kostenFix;
		kostenZusatz = 0;
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
		kostenDruck = rundeBetrag(auflage * 0.2);
		kostenGesamt += kostenDruck;
	}
	
	public void updateAbgesetzteMag(int absatz){
		abgesetzteMagazine = absatz;
	}
	
	public void speziellesKostenUpdate(String art, double betrag){
		if(art.equals("ROHSTOFFPREISE_ERHOEHEN") || art.equals("ROHSTOFFPREISE_SENKEN")){
			kostenGesamt -= kostenDruck;
			kostenDruck *= betrag;
			kostenDruck = rundeBetrag(kostenDruck);
			kostenGesamt += kostenDruck;
		} else if(art.equals("RECHTSSTREIT")){
			kostenZusatz = betrag;
			kostenGesamt += kostenZusatz;
			kostenZusatz = 0;
		} else if(art.equals("TARIFVERHANDLUNG")){
			kostenGesamt -= kostenPersonal;
			kostenPersonal = betrag;
			kostenGesamt += kostenPersonal;
		} else {
			//ignore
		}
	}
	
	public void aktualisieren(){
		kostenGesamt = kostenDruck + kostenPersonal + kostenEW;
	}
	
	public double getGesamtKosten(){
		return rundeBetrag(kostenGesamt);
	}
	
	public double[] getKosten(){
		double[] d = new double[4];
		
		d[0] = kostenDruck;
		d[1] = kostenPersonal;
		d[2] = kostenEW;
		d[3] = kostenGesamt;
		
		return d;
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