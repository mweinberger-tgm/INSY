package tgm.exp.build;

import java.io.*;
import java.net.*;
//STEP 1. Import required packages
import java.sql.*;

/**
 * 
 * Erhaelt die Werte des cliParsers, prueft diese auf Richtigkeit, bastelt einen
 * SELECT-Befehl zusammen, schickt diesen zur Datenbank und gibt das Ergebnis
 * wie gewuenscht aus.
 * 
 * @author Michael Weinberger 4AHITT
 * @version 1.0
 *
 */
public class databaseConn {
	private String hostname;
	private String username;
	private String password;
	private String database;
	private String tablename;
	private String sortfield;
	private String sortdirection;
	private String condition;
	private String delimiter;
	private String list;
	private String tofile;

	private String select;

	private String url = "jdbc:mysql://";

	private ResultSet rs;
	private Statement stmt;
	private Connection conn;

	/**
	 * 
	 * Erstellt databaseConn-Objekt, regelt den Ablauf des Programms 
	 * 
	 * @param args Die Konsolenargumente
	 * 
	 */
	public databaseConn(String[] args) {
		cliParser prs = new cliParser(args);
		prs.initArgs();

		hostname = prs.getHostname();
		username = prs.getUsername();
		password = prs.getPassword();
		database = prs.getDatabase();
		tablename = prs.getTablename();
		sortfield = prs.getSortfield();
		sortdirection = prs.getSortdirection();
		condition = prs.getCondition();
		delimiter = prs.getDelimiter();
		list = prs.getList();
		tofile = prs.getTofile();

		checkIfValidHost();
		assembleSelect();
		letsgoDB();
		showResult();

		// STEP 6: Clean-up environment
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.err
					.println("Beim Schlieﬂen des ResultSets ist ein Fehler aufgetreten! "
							+ e.getMessage());
		}
	}

	/**
	 * 
	 * Pingt den Host an, ob dieser erreichbar ist.
	 * 
	 */
	public void checkIfValidHost() {
		try {
			InetAddress host = InetAddress.getByName(hostname);
			host.isReachable(5000);
		} catch (UnknownHostException e) {
			System.err.println("Host kann nicht erreicht werden!");
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Host kann nicht erreicht werden!");
			System.exit(1);
		}
	}

	/**
	 * 
	 * Setzt einen SELECT-Befehl zusammen.
	 * 
	 */
	public void assembleSelect() {
		url = url + hostname + ":3306/" + database;

		select = "SELECT " + list + " FROM " + tablename;
		
		if(condition.equals("") == false) {
			select = select + " WHERE "+ condition;
		}
		
		if(sortfield.equals("") == false) {
			select = select +" ORDER BY "+sortfield +" " +sortdirection;
		}

		System.out.println(select);
	}

	/**
	 * 
	 * Erstellt mit dem gerade erstellten SELECT-Befehl eine Query an die DB und erhaelt ein ResultSet.
	 * 
	 */
	public void letsgoDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("JDBC-Treiber wurde geladen...");
		} catch (ClassNotFoundException e) {
			System.out.println("Der JDBC-Treiber wurde nicht gefunden! "
					+ e.getMessage());
			System.exit(1);
		}

		// STEP 3: Open a connection
		// Database credentials
		System.out.println("Connecting to database...");
		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("JDBC-Treiber wurde geladen...");

			conn = DriverManager.getConnection(url, username, password);
			System.out.println("DB-Verbindung aufgebaut!");

			// STEP 4: Execute a query
			System.out.println("Creating statement...\n");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(select);

		} catch (SQLException e) {
			System.out
					.println("Es konnte keine Verbindung zur DB hergestellt werden! "
							+ e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Der JDBC-Treiber wurde nicht gefunden! "
					+ e.getMessage());
			System.exit(1);

		}

	}

	/**
	 * 
	 * Gibt das Resultat aus dem ResultSet entweder auf der Konsole oder als Textfile aus.
	 * 
	 */
	public void showResult() {
		if (tofile == null) {

			// STEP 5: Extract data from result set
			try {
				while (rs.next()) {
					// Retrieve by column name
					String val = rs.getString(list);

					// Display values
					System.out.print(val + delimiter + "\n");
				}
			} catch (SQLException e) {
				System.err.println("Eine SQLException ist aufgetreten! "
						+ e.getMessage());
			}

			System.out.println("\nProgramm wird beendet.");
			System.exit(0);
		} else if (tofile != null) {
			//http://www.javabeginners.de/Dateien_und_Verzeichnisse/In_Textdatei_schreiben.php
			System.out.println("Ausgabe wird im File "+tofile+".txt gespeichert.");
			
			PrintWriter pWriter = null; 
	        try { 
	            pWriter = new PrintWriter(new BufferedWriter(new FileWriter(tofile +".txt"))); 
	            while (rs.next()) {
					// Retrieve by column name
					String name = rs.getString("sname");

					// Display values
					pWriter.println(name + delimiter + "\n");
				} 
	        } catch (IOException e) { 
	            System.err.println("Eine IOExcpetion ist aufgetreten! "+e.getMessage());
	        } catch (SQLException e) {
	        	System.err.println("Eine SQLException ist aufgetreten! "+e.getMessage());
			} finally { 
	            if (pWriter != null){ 
	                pWriter.flush(); 
	                pWriter.close(); 
	            } 
	        } 
			
			
			System.out.println("\nProgramm wird beendet.");
			System.exit(0);
		}
	}
}
