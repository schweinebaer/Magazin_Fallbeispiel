package de.spiel.magazin;

public class ZufallsereignisDaten {
	private final Object[][] daten = new Object[14][4];
	
	public ZufallsereignisDaten(){
		//--> extra Klasse
		daten[0][0] = "Zinssatz f�r Kredite steigt um 0,2% an, EZB erh�ht den Leitzinssatz.";
		daten[0][1] = "ZINSSATZ_ERHOEHEN";
		daten[0][2] = 0.2;
		
		daten[1][0] = "Zinssatz f�r Kredite steigt um 0,5% an, EZB erh�ht den Leitzinssatz.";
		daten[1][1] = "ZINSSATZ_ERHOEHEN";
		daten[1][2] = 0.5;
		
		daten[2][0] = "Zinssatz f�r Kredite f�llt um 0,2%; EZB senkt den Leitzinssatz.";
		daten[2][1] = "ZINSSATZ_VERKLEINERN";
		daten[2][2] = 0.2;

		daten[3][0] = "Zinssatz f�r Kredite f�llt um 0,5%; EZB senkt den Leitzinssatz.";
		daten[3][1] = "ZINSSATZ_VERKLEINERN";
		daten[3][2] = 0.5;
		
		daten[4][0] = "Absatzplus, das Magazin wird zus�tzlich 10.000 mal verkauft, da ein besonders guter Artikel im Heft die K�ufer beeindruckt hat.";
		daten[4][1] = "ABSATZPLUS_EINMALIG";
		daten[4][2] = 10000.0;
		
		daten[5][0] = "Absatzeinbruch, das Magazin verkauft 8.000 Exemplare weniger, in Folge von Lieferschwierigkeiten.";
		daten[5][1] = "ABSATZMINUS_EINMALIG";
		daten[5][2] = 8000.0;
		
		daten[6][0] = "Rohstoffpreise f�r die Papierproduktion steigen um 5% in Folge von Preisspekulationen.";
		daten[6][1] = "ROHSTOFFPREISE_ERHOEHEN";
		daten[6][2] = 5.0;
		
		daten[7][0] = "Rohstoffpreise f�r die Produktion von Industriedruckertinte sinken um 5% auf Grund von einem aktuellen �berangebot am Markt.";
		daten[7][1] = "ROHSTOFFPREISE_SENKEN";
		daten[7][2] = 5.0;
		
		daten[8][0] = "Gro�z�gige Spende der Autolobby/Waffenlobby/Energielobby eingetroffen: +100.000�.";
		daten[8][1] = "SPENDE_BEKOMMEN";
		daten[8][2] = 100000.0;
		
		daten[9][0] = "Sie verlieren den Rechtsstreit mit einem hochrangigen Politiker und wurden auf 500.000� Schadensersatz verklagt. Allerdings verkauft sich ihr Magazin in der n�chsten Auflage auf Grund der erh�hten Aufmerksamkeit 10.000 Mal h�ufiger.";
		daten[9][1] = "RECHTSSTREIT";
		daten[9][2] = 500000.0;
		daten[9][3] = 10000.0;
		
		daten[10][0] = "Die Tarifverhandlungen mit dem Personal sind zu Ende gegangen. Sie erhalten 5% mehr Gehalt.";
		daten[10][1] = "TARIFVERHANDLUNG";
		daten[10][2] = 5.0;

		daten[11][0] = "Ein unangebrachter und schlecht recherchierter Artikel in ihrem Magazin beschert ihnen 5% Qualit�tsverlust bei der n�chsten Ausgabe.";
		daten[11][1] = "QUALITAETSEINBRUCH";
		daten[11][2] = 5.0;
		
		daten[12][0] = "Einer ihrer besten Journalisten erh�lt einen wichtigen Journalistenpreis f�r eine besonders gelungene Titelstory in ihrem Magazin. Die Qualit�t ihrer n�chsten Ausgabe steigt um 10%.";
		daten[12][1] = "JOURNALISTENPREIS";
		daten[12][2] = 10.0;
		
		daten[13][0] = "Einer unserer Hauptsponsoren der f�r 10% der Fremdwerbeeinnahmen verantwortlich ist geht pl�tzlich insolvent und kann die Werbung in der n�chsten Ausgabe nicht bezahlen. Leider konnte so kurzfristig kein Ersatz gefunden werden. Die Einnahmen gehen ihnen verloren.";
		daten[13][1] = "WERBEEINNAHMEN_MINDERUNG";
		daten[13][2] = 10.0;
	}
	
	public Object[] getEreignis(int random){
		Object[] ereignis = new Object[4];
		
		if((random - 1) == 9){
			ereignis[0] = daten[random - 1][0];
			ereignis[1] = daten[random - 1][1];
			ereignis[2] = daten[random - 1][2];
			ereignis[3] = daten[random - 1][3];
		} else if(((random - 1) > 0 && (random - 1) < 9) || ((random - 1) > 9 && (random - 1) < 14)){
			ereignis[0] = daten[random - 1][0];
			ereignis[1] = daten[random - 1][1];
			ereignis[2] = daten[random - 1][2];
		} else {
			//ignore
			ereignis[0] = "WRONG_RANDOM";
		}
		
		return ereignis;
	}
}