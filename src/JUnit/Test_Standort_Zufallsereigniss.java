package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.spiel.magazin.Zufallsereignis;


public class Test_Standort_Zufallsereigniss {
	

	


	@Before
	public void setUp() throws Exception {
	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMain() {
		Object[] vergleich = new Object[4];
		vergleich[0] = "Zinssatz für Kredite steigt um 0,2% an, EZB erhöht den Leitzinssatz.";
		vergleich[1] = "ZINSSATZ_ERHOEHEN";
		vergleich[2] = 0.2;
		vergleich[3] = 0.1;
		
		Zufallsereignis zufallsereignis;
		zufallsereignis = new Zufallsereignis();
		Object[] zufallsereignisDaten;
		zufallsereignisDaten = zufallsereignis.berechneZufallsEreignis();
		
		assertArrayEquals(vergleich, zufallsereignisDaten);
	}

}
