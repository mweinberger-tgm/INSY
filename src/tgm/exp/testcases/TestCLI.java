package tgm.exp.testcases;

import static org.junit.Assert.*;

import org.junit.*;

import tgm.exp.build.cliParser;

/**
 * 
 * @author Michael
 *
 */
public class TestCLI {
	cliParser temp;
	String args[] = {"-h", "projekte.tgm.ac.at", "-u", "test", "-p", "test", "-d", "megamarkt", "-T", "produkt", "-s", "titel,preis", "-r", "DESC", "-w", "preis > 4", "-t", "$", "-f", "-o", "ausgabe.txt"};
	
	@Before
	public void setup()	{
		temp = new cliParser(args);
		temp.initArgs();
	}
	
	@Test
	public void testgetHost()	{
		assertEquals(temp.getHostname(), "projekte.tgm.ac.at");
	}
	
	@Test
	public void testgetUser()	{
		assertEquals(temp.getUsername(), "test");
	}
	
	@Test
	public void testgetpassword()	{
		assertEquals(temp.getPassword(), "test");
	}
	
	@Test
	public void testgetDatabase()	{
		assertEquals(temp.getDatabase(), "megamarkt");
	}
	
	@Test
	public void testgetTablename()	{
		assertEquals(temp.getTablename(), "produkt");
	}
	
	@Test
	public void testgetSortField()	{
		assertEquals(temp.getSortfield(), "titel,preis");
	}
	
	@Test
	public void testgetSortDirection()	{
		assertEquals(temp.getSortdirection(), "DESC");
	}
	
	@Test
	public void testgetCondition()	{
		assertEquals(temp.getCondition(), "preis > 4");
	}
	
	@Test
	public void testDelimiter()	{
		assertEquals(temp.getDelimiter(), "$");
	}
	
	@Test
	public void testToConsole()	{
		assertEquals(temp.getToconsole(), "");
	}
	
	@Test
	public void testToFile()	{
		assertEquals(temp.getTofile(), "ausgabe.txt");
	}
	
}
