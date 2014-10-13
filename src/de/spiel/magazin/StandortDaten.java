package de.spiel.magazin;

public class StandortDaten {
	/*
	 * Was ist was (genau diese Reihenfolge):
	 * String standort
	 * double preis
	 * double magazinkosten
	 * int maxMitarbeiter
	 * int startMitarbeiter
	 * double startGehaltMitarbeiter
	 * double startKostenMitarbeiter
	 * int maxAuflage
	 * int gedruckteMagazine
	 * int abgesetzteMagazine
	 * double kostenDruck
	 * int fwInSeitenProHeft
	 * int maxSeitenFW
	 * int ewInAktionen
	 * double kostenEW
	 * int maxEWAktionen
	 * double preisProHeft
	 * double maxPreisProHeft
	 * double kostenGesamt
	 * double erloesVerkauf
	 * double erloesFW
	 * double erloesGesamt
	 * double umsatz
	 * double kapital
	 */
	
	private final Object[][] daten = new Object[4][24];

	public StandortDaten(){
		daten[0][0] = "München";
		daten[0][1] = 500000.0;
		daten[0][2] = 5000.0;
		daten[0][3] = 2000;
		daten[0][4] = 500;
		daten[0][5] = 3100.0;
		daten[0][6] = 1550000.0;
		daten[0][7] = 500000;
		daten[0][8] = 500000;
		daten[0][9] = 125000;
		daten[0][10] = 65000.0;
		daten[0][11] = 30;
		daten[0][12] = 150;
		daten[0][13] = 7;
		daten[0][14] = 70000.0;
		daten[0][15] = 20;
		daten[0][16] = 4.0;
		daten[0][17] = 8.0;
		daten[0][18] = 1685000.0;
		daten[0][19] = 1300000.0;
		daten[0][20] = 150000.0;
		daten[0][21] = 1450000.0;
		daten[0][22] = -2350000.0;
		daten[0][23] = 7300000.0;
		
		daten[1][0] = "Berlin";
		daten[1][1] = 200000.0;
		daten[1][2] = 2000.0;
		daten[1][3] = 2000;
		daten[1][4] = 500;
		daten[1][5] = 3100.0;
		daten[1][6] = 1240000.0;
		daten[1][7] = 400000;
		daten[1][8] = 400000;
		daten[1][9] = 2566666;
		daten[1][10] = 51333.2;
		daten[1][11] = 100;
		daten[1][12] = 150;
		daten[1][13] = 5;
		daten[1][14] = 50000.0;
		daten[1][15] = 20;
		daten[1][16] = 4.0;
		daten[1][17] = 8.0;
		daten[1][18] = 1341333.2;
		daten[1][19] = 1026664.0;
		daten[1][20] = 500000.0;
		daten[1][21] = 1526664.0;
		daten[1][22] = 185330.8;
		daten[1][23] = 3200000.0;
		
		daten[2][0] = "Walldorf";
		daten[2][1] = 500000.0;
		daten[2][2] = 500.0;
		daten[2][3] = 2000;
		daten[2][4] = 500;
		daten[2][5] = 3100.0;
		daten[2][6] = 1860000.0;
		daten[2][7] = 600000;
		daten[2][8] = 600000;
		daten[2][9] = 430000;
		daten[2][10] = 86000.0;
		daten[2][11] = 50;
		daten[2][12] = 150;
		daten[2][13] = 6;
		daten[2][14] = 60000.0;
		daten[2][15] = 20;
		daten[2][16] = 4.0;
		daten[2][17] = 8.0;
		daten[2][18] = 2006000.0;
		daten[2][19] = 1720000.0;
		daten[2][20] = 250000.0;
		daten[2][21] = 1970000.0;
		daten[2][22] = -36000.0;
		daten[2][23] = 5360000.0;
		
		daten[3][0] = "Bonn";
		daten[3][1] = 50000.0;
		daten[3][2] = 500.0;
		daten[3][3] = 2000;
		daten[3][4] = 500;
		daten[3][5] = 3100.0;
		daten[3][6] = 1550000.0;
		daten[3][7] = 500000;
		daten[3][8] = 500000;
		daten[3][9] = 387500;
		daten[3][10] = 775000;
		daten[3][11] = 60;
		daten[3][12] = 150;
		daten[3][13] = 8;
		daten[3][14] = 80000.0;
		daten[3][15] = 20;
		daten[3][16] = 4.0;
		daten[3][17] = 8.0;
		daten[3][18] = 1707500.0;
		daten[3][19] = 1550000.0;
		daten[3][20] = 300000.0;
		daten[3][21] = 1850000.0;
		daten[3][22] = 142500.0;
		daten[3][23] = 3600000.0;
	}
	
	public Object[] getStandorte(int i){
		Object[] standort = new Standort[24];
		
		if(i == 1){
			//München
			standort = daten[0];
		} else if(i == 2){
			//Berlin
			standort = daten[1];
		} else if(i == 3){
			//Walldorf
			standort = daten[2];
		} else if(i == 3){
			//Bonn
			standort = daten[3];
		} else {
			//ignore
		}
		
		return standort;
	}
}