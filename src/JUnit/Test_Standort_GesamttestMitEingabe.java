package JUnit;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Vector;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import de.spiel.magazin.Spieler;

public class Test_Standort_GesamttestMitEingabe {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMain() {
		Vector<Spieler> spieler;
		spieler = new Vector();
		Spieler aktuellerSpieler;
		int maxRunde = 5;
		PrintWriter writer = new PrintWriter(System.out, true);
		Spieler einzelnerSpieler = new Spieler("Pascal", writer);
		Spieler einzelnerSpieler2 = new Spieler("Benni", writer);
		
		//Spieler Hinzufüegen
		spieler.add(einzelnerSpieler);
		spieler.add(einzelnerSpieler2);
		
		for(int i = 0; i < spieler.size(); i++){
			aktuellerSpieler = spieler.elementAt(i);
			
		}
	}

}
