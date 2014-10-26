package de.spiel.magazin;

public class StandortDaten {
	/*
	 * Was ist was (genau diese Reihenfolge):
	 * 0: String standort +
	 * 1: double preis -> Was für ein Preis? -
	 * 2: double magazinkosten -
	 * 3: int maxMitarbeiter +
	 * 4: int startMitarbeiter +
	 * 5: double startGehaltMitarbeiter +
	 * 6: double startKostenMitarbeiter +
	 * 7: int maxAuflage +
	 * 8: int gedruckteMagazine +
	 * 9: int abgesetzteMagazine +
	 * 10: double kostenDruck +
	 * 11: int fwInSeitenProHeft +
	 * 12: int maxSeitenFW +
	 * 13: int ewInAktionen +
	 * 14: double kostenEW +
	 * 15: int maxEWAktionen +
	 * 16: double preisProHeft +
	 * 17: double maxPreisProHeft +
	 * 18: double kostenGesamt +
	 * 19: double erloesVerkauf +
	 * 20: double erloesFW +
	 * 21: double erloesGesamt +
	 * 22: double umsatz +
	 * 23: double kapital +
	 * 24: double kostenFix
	 */
	
	//neu
	private String standort;
	private double preis;
	private double magazinkosten;
	private int maxMitarbeiter;
	private int startMitarbeiter;
	private double startGehaltMitarbeiter;
	private double startKostenMitarbeiter;
	private int maxAuflage;
	private int gedruckteMagazine;
	private int abgesetzteMagazine;
	private double kostenDruck;
	private int fwInSeitenProHeft;
	private int maxSeitenFW;
	private int ewInAktionen;
	private double kostenEW;
	private int maxEWAktionen;
	private double preisProHeft;
	private double maxPreisProHeft;
	private double kostenGesamt;
	private double erloesVerkauf;
	private double erloesFW;
	private double erloesGesamt;
	private double umsatz;
	private double kapital;
	private double kostenFix;
	
	public StandortDaten(String standort, double preis, double magazinkosten, int maxMitarbeiter, int startMitarbeiter, double startGehaltMitarbeiter, double startKostenMitarbeiter, int maxAuflage, int gedruckteMagazine, int abgesetzteMagazine,
			double kostenDruck, int fwInSeitenProHeft, int maxSeitenFW, int ewInAktionen, double kostenEW, int maxEWAktionen, double preisProHeft, double maxPreisProHeft, double kostenGesamt, double erloesVerkauf, double erloesFW, double erloesGesamt,
			double umsatz, double kapital, double kostenFix){
		
		this.standort = standort;
		this.preis = preis;
		this.magazinkosten = magazinkosten;
		this.maxMitarbeiter = maxMitarbeiter;
		this.startMitarbeiter = startMitarbeiter;
		this.startGehaltMitarbeiter = startGehaltMitarbeiter;
		this.startKostenMitarbeiter = startKostenMitarbeiter;
		this.maxAuflage = maxAuflage;
		this.gedruckteMagazine = gedruckteMagazine;
		this.abgesetzteMagazine = abgesetzteMagazine;
		this.kostenDruck = kostenDruck;
		this.fwInSeitenProHeft = fwInSeitenProHeft;
		this.maxSeitenFW = maxSeitenFW;
		this.ewInAktionen = ewInAktionen;
		this.kostenEW = kostenEW;
		this.maxEWAktionen = maxEWAktionen;
		this.preisProHeft = preisProHeft;
		this.maxPreisProHeft = maxPreisProHeft;
		this.kostenGesamt= kostenGesamt;
		this.erloesVerkauf = erloesVerkauf;
		this.erloesFW = erloesFW;
		this.erloesGesamt = erloesGesamt;
		this.umsatz = umsatz;
		this.kapital = kapital;
		this.kostenFix = kostenFix;
	}
	
	public Object[] getDaten(){
		Object[] standortDaten = new Object[25];
		
		standortDaten[0] = standort;
		standortDaten[1] = preis;
		standortDaten[2] = magazinkosten;
		standortDaten[3] = maxMitarbeiter;
		standortDaten[4] = startMitarbeiter;
		standortDaten[5] = startGehaltMitarbeiter;
		standortDaten[6] = startKostenMitarbeiter;
		standortDaten[7] = maxAuflage;
		standortDaten[8] = gedruckteMagazine;
		standortDaten[9] = abgesetzteMagazine;
		standortDaten[10] = kostenDruck;
		standortDaten[11] = fwInSeitenProHeft;
		standortDaten[12] = maxSeitenFW;
		standortDaten[13] = ewInAktionen;
		standortDaten[14] = kostenEW;
		standortDaten[15] = maxEWAktionen;
		standortDaten[16] = preisProHeft;
		standortDaten[17] = maxPreisProHeft;
		standortDaten[18] = kostenGesamt;
		standortDaten[19] = erloesVerkauf;
		standortDaten[20] = erloesFW;
		standortDaten[21] = erloesGesamt;
		standortDaten[22] = umsatz;
		standortDaten[23] = kapital;
		standortDaten[24] = kostenFix;
		
		return standortDaten;
	}
}