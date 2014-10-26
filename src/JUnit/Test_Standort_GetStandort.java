package JUnit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.spiel.magazin.Standort;
import de.spiel.magazin.StandortDaten;

public class Test_Standort_GetStandort {

	/*
	 * @Before public void setUp() throws Exception { 
	 * 
	 * 
	 * }
	 * 
	 * @After public void tearDown() throws Exception { }
	 */

	@Test
	public void testGetStandort() {		
		StandortDaten muenchen = new StandortDaten( "München", 500000.0, 5000.0, 2000, 500, 3200.0, 1600000.0, 500000, 500000, 344791, 68958.2, 16, 60, 8, 80000.0, 20, 4.0, 8.0, 1798958.2, 1379164.0, 200000, 1579164, -219794.2, 7197942, 50000.0);
		StandortDaten berlin = new StandortDaten(    "Berlin", 200000.0, 2000.0, 2000, 500, 3150.0, 1575000.0, 500000, 500000, 332291, 66458.2, 16, 60, 7, 70000.0, 20, 4.0, 8.0, 1751458.2, 1329164.0, 200000, 1529164, -222294.2, 7222942, 40000.0);
		StandortDaten walldorf = new StandortDaten("Walldorf", 500000.0, 500.0, 2000, 500, 3100.0, 1550000.0,  500000, 500000, 323958, 64791.6, 17, 60, 6, 60000.0, 20, 4.0, 8.0, 1709791.6, 1295832.0, 212500, 1508332, -201459.6, 7014596, 35000.0);
		StandortDaten bonn = new StandortDaten(         "Bonn", 50000.0, 500.0, 2000, 500, 3000.0, 1500000.0,  500000, 500000, 344791, 68958.2, 16, 60, 8, 80000.0, 20, 4.0, 8.0, 1678958.2, 1379164.0, 200000, 1579164, -99794.2, 5997942, 30000.0);
		
		Standort test1 = new Standort(1);
		Standort test2 = new Standort(1);
		Standort test3 = new Standort(1);
		Standort test4 = new Standort(1);
		
		Object[] o1 = muenchen.getDaten();
		Object[] o2 = berlin.getDaten();
		Object[] o3 = walldorf.getDaten();
		Object[] o4 = bonn.getDaten();

		Object[] result1 = test1.getStandort(1);
		Object[] result2 = test2.getStandort(2);
		Object[] result3 = test3.getStandort(3);
		Object[] result4 = test4.getStandort(4);
		
		//Vergleich:
		assertArrayEquals(o1, result1);
		assertArrayEquals(o2, result2);
		assertArrayEquals(o3, result3);
		assertArrayEquals(o4, result4);
		
	}

}
