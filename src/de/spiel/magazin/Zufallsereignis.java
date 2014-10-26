package de.spiel.magazin;

public class Zufallsereignis {
	private ZufallsereignisDaten[] daten;
	
	public Zufallsereignis(){
		daten = new ZufallsereignisDaten[14];
		
		daten[0] = new ZufallsereignisDaten("Zinssatz f�r Kredite steigt um 0,2% an, EZB erh�ht den Leitzinssatz.", "ZINSSATZ_ERHOEHEN", 0.2, 0.1);
		daten[1] = new ZufallsereignisDaten("Zinssatz f�r Kredite steigt um 0,5% an, EZB erh�ht den Leitzinssatz.", "ZINSSATZ_ERHOEHEN", 0.5, 0.0);
		daten[2] = new ZufallsereignisDaten("Zinssatz f�r Kredite f�llt um 0,2%; EZB senkt den Leitzinssatz.", "ZINSSATZ_VERKLEINERN", 0.2, 0.0);
		daten[3] = new ZufallsereignisDaten("Zinssatz f�r Kredite f�llt um 0,5%; EZB senkt den Leitzinssatz.", "ZINSSATZ_VERKLEINERN", 0.5, 0.0);
		daten[4] = new ZufallsereignisDaten("Absatzplus, das Magazin wird zus�tzlich 10.000 mal verkauft, da ein besonders guter Artikel im Heft die K�ufer beeindruckt hat.", "ABSATZPLUS_EINMALIG", 10000.0, 0.0);
		daten[5] = new ZufallsereignisDaten("Absatzeinbruch, das Magazin verkauft 8.000 Exemplare weniger in Folge von Lieferschwierigkeiten.", "ABSATZMINUS_EINMALIG", 8000.0, 0.0);
		daten[6] = new ZufallsereignisDaten("Rohstoffpreise f�r die Papierproduktion steigen um 5% in Folge von Preisspekulationen.", "ROHSTOFFPREISE_ERHOEHEN", 1.05, 0.0);
		daten[7] = new ZufallsereignisDaten("Rohstoffpreise f�r die Produktion von Industriedruckertinte sinken um 5% auf Grund von einem aktuellen �berangebot am Markt.", "ROHSTOFFPREISE_SENKEN", 0.95, 0.0);
		daten[8] = new ZufallsereignisDaten("Gro�z�gige Spende der Autolobby/Waffenlobby/Energielobby eingetroffen: +100.000�.", "SPENDE_BEKOMMEN", 100000.0, 0.0);
		daten[9] = new ZufallsereignisDaten("Sie verlieren den Rechtsstreit mit einem hochrangigen Politiker und wurden auf 500.000� Schadensersatz verklagt. Allerdings verkauft sich ihr Magazin in der n�chsten Auflage auf Grund der erh�hten Aufmerksamkeit 10.000 Mal h�ufiger.", "RECHTSSTREIT", 500000.0, 10000.0);
		daten[10] = new ZufallsereignisDaten("Die Tarifverhandlungen mit dem Personal sind zu Ende gegangen. Sie erhalten 5% mehr Gehalt.", "TARIFVERHANDLUNG", 1.05, 0.0);
		daten[11] = new ZufallsereignisDaten("Ein unangebrachter und schlecht recherchierter Artikel in ihrem Magazin beschert ihnen 5% Qualit�tsverlust bei der n�chsten Ausgabe.", "QUALITAETSEINBRUCH", 0.95, 0.0);
		daten[12] = new ZufallsereignisDaten("Einer ihrer besten Journalisten erh�lt einen wichtigen Journalistenpreis f�r eine besonders gelungene Titelstory in ihrem Magazin. Die Qualit�t ihrer n�chsten Ausgabe steigt um 10%.", "JOURNALISTENPREIS", 1.1, 0.0);
		daten[13] = new ZufallsereignisDaten("Einer unserer Hauptsponsoren der f�r 10% der Fremdwerbeeinnahmen verantwortlich ist geht pl�tzlich insolvent und kann die Werbung in der n�chsten Ausgabe nicht bezahlen. Leider konnte so kurzfristig kein Ersatz gefunden werden. Die Einnahmen gehen ihnen verloren.", "WERBEEINNAHMEN_MINDERUNG", 0.9, 0.0);
	}
		
	public Object[] berechneZufallsEreignis(){
		int ereignisRandomZahl = (int) (Math.random() * (14 - 1) + 1);
		Object[] ereignis = daten[ereignisRandomZahl].getEreignis();
		
		while(ereignis == null){
			ereignisRandomZahl = (int) (Math.random() * (14 - 1) + 1);
			ereignis = daten[ereignisRandomZahl].getEreignis();
		}
		
		return ereignis;
	}
}