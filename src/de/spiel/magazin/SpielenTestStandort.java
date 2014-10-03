package de.spiel.magazin;
import java.util.Vector;


public class SpielenTestStandort {
	public static void main(String[] args) {
		new SpielenTestStandort(5).spielen();
	}
	private static SpielenTestStandort spiel;
	private int rundenzahl;
	private Vector<Standort> standortListe;
	
	public SpielenTestStandort(int rundenzahl) {
		this.rundenzahl = rundenzahl;
	}

	private void spielen() {
		
		//Standorte erzeugen
		Standorttyp[] standorte = Standorttyp.values();
		for (int i = 0; i < standorte.length; i++) {
			System.out.println(i);
			hinzufuegenStandort(new Standort(standorte[i]));
			System.out.println(standorte[i]);
	}

}

	private void hinzufuegenStandort(Standort standort) {
		if (standort != null) {
			standortListe.add(standort);
			System.out.println(standortListe);
		}else{System.out.println("Feritg");}
	}	
	
	public static SpielenTestStandort getSpiel() {
		return spiel;
	}
}
