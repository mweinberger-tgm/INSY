package tgm.exp.testcases;

import static org.junit.Assert.*;

import org.junit.*;

import tgm.exp.build.databaseConn;

/**
 * 
 * Testet die Klasse databaseConn auf Funktionalitaet.
 * 
 * @author Michael Weinberger 4AHIT
 * @version 1.0
 *
 */
public class TestDatabaseConn {

	String args[] = {"-h", "127.0.0.1", "-u", "insy4", "-p", "blabla", "-d", "premiere", "-T", "sender", "-f", "sname"};
	
	//Test-Datenbank aus dem INSY-Unterricht mit MARM/BREC 
	
	/*@Test
	public void testSampleQuery()	{
		databaseConn test = new databaseConn(args);
		
		assertEquals();
	}*/
	
}
