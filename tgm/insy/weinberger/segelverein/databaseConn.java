package segelverein;

import java.io.*;
import java.net.*;
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
	private String hostname, username, password, database;

	private String select;

	private String url = "jdbc:postgresql://";

	private ResultSet rs;
	private Statement stmt;
	private Connection conn;

	/**
	 * 
	 * Erstellt databaseConn-Objekt, regelt den Ablauf des Programms
	 * 
	 * @param args
	 *            Die Konsolenargumente
	 * 
	 */
	public databaseConn(String[] args) {
		cliParser prs = new cliParser(args);
		prs.initArgs();

		hostname = prs.getHostname();
		username = prs.getUsername();
		password = prs.getPassword();
		database = prs.getDatabase();

		checkIfValidHost();
		assembleSelect();
		letsgoDB();
		// initGUI();

		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.err
					.println("Beim Schliessen des ResultSets ist ein Fehler aufgetreten! "
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
		url = url + hostname + "/" + database;

		select = "SELECT * FROM Boot";
		System.out.println(select);
	}

	/**
	 * 
	 * Erstellt mit dem gerade erstellten SELECT-Befehl eine Query an die DB und
	 * erhaelt ein ResultSet.
	 * 
	 */
	public void letsgoDB() {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("JDBC-Treiber wurde geladen...");
		} catch (ClassNotFoundException e) {
			System.out.println("Der JDBC-Treiber wurde nicht gefunden! "
					+ e.getMessage());
			System.exit(1);
		}

		System.out.println("Connecting to database...");
		try {

			conn = DriverManager.getConnection(url, username, password);
			System.out.println("DB-Verbindung aufgebaut!");

			System.out.println("Creating statement...\n");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(select);

		} catch (SQLException e) {
			System.out
					.println("Es konnte keine Verbindung zur DB hergestellt werden! "
							+ e.getMessage());
		}

		try {
			while (rs.next()) {
				for (int i = 1; i < 5; i++) {
					String val = rs.getString(i);
					System.out.print(val + "\n");
				}

			}
		} catch (SQLException e) {
			System.err.println("Eine SQLException ist aufgetreten! "
					+ e.getMessage());
		}

		System.out.println("\nProgramm wird beendet.");
		System.exit(0);

	}
}
