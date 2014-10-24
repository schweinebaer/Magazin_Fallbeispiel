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
		StandortDaten muenchen = new StandortDaten("München", 500000.0, 5000.0, 2000, 500, 3200.0, 1600000.0, 500000, 500000, 125000, 65000.0, 16, 60, 7, 70000.0, 20, 4.0, 8.0, 1685000.0, 1300000.0, 150000.0, 1450000.0, -2350000.0, 7300000.0, 50000.0);
		StandortDaten berlin = new StandortDaten("Berlin", 200000.0, 2000.0, 2000, 500, 3150.0, 1575000.0, 400000, 400000, 2566666, 51333.2, 16, 60, 5, 50000.0, 20, 4.0, 8.0, 1341333.2, 1026664.0, 500000.0, 1526664.0, 185330.8, 3200000.0, 40000.0);
		StandortDaten walldorf = new StandortDaten("Walldorf", 500000.0, 500.0, 2000, 500, 3100.0, 1550000.0, 600000, 600000, 430000, 86000.0, 17, 60, 6, 60000.0, 20, 4.0, 8.0, 2006000.0, 1720000.0, 250000.0, 1970000.0, -36000.0, 5360000.0, 35000.0);
		StandortDaten bonn = new StandortDaten("Bonn", 50000.0, 500.0, 2000, 500, 3000.0, 1500000.0, 500000, 500000, 387500, 775000, 16, 60, 8, 80000.0, 20, 4.0, 8.0, 1707500.0, 1550000.0, 300000.0, 1850000.0, 142500.0, 3600000.0, 30000.0);
		
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
