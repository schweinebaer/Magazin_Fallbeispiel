package de.spiel.magazin;

import java.io.PrintWriter;

public class StandortAusgabe {
	public static void ausgabeStandortStartwerte(Object[] o, int standortNr, PrintWriter writer){
		writer.println("----- Standort " + standortNr + " -----");
		writer.println("Standort:                		" + o[0]);
		writer.println("Preis Standort:          		" + o[1] + "€");
		writer.println("Magazinkosten pro Runde: 		" + o[2] + "€");
		writer.println("Max. Mitarbeiter:		 	" + o[3]);
		writer.println("Startwert Mitarbeiter:	 		" + o[4]);
		writer.println("Gehalt Mitarbeiter:		 	" + o[5] + "€");
		writer.println("Kosten Mitarbeiter:		 	" + o[6] + "€");
		writer.println("Max. Auflage:			 	" + o[7]);
		writer.println("Gedruckte Magazine: 	 		" + o[8]);
		writer.println("Abgesetzte Magazine:     		" + o[9]);
		writer.println("Kosten Druck:			 	" + o[10] + "€");
		writer.println("Fremdwerbung (Seiten pro Heft): 	" + o[11]);
		writer.println("Max. Seiten Fremdwerbung:		" + o[12]);
		writer.println("Eigenwerbung in Aktionen: 		" + o[13]);
		writer.println("Kosten Eigenwerbung:			" + o[14] + "€");
		writer.println("Max. Eigenwerbung in Aktionen:		" + o[15]);
		writer.println("Verkaufspreis pro Heft:			" + o[16] + "€");
		writer.println("Max. Verkaufspreis pro Heft: 		" + o[17] + "€");
		writer.println("Fixkosten:						" + o[24] + "€");
		writer.println("Gesamtkosten des Magazins:		" + o[18] + "€");
		writer.println("Erlös aus Magazinverkauf: 		" + o[19] + "€");
		writer.println("Erlös aus Fremdwerbung:			" + o[20] + "€");
		writer.println("Gesamt Erlös:				" + o[21] + "€");
		writer.println("Umsatz:					" + o[22] + "€");
		writer.println("Kapital:				" + o[23] + "€");
		writer.println("-------------------------------------------------");
	}
}