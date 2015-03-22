package segelverein;

import javax.swing.*;

import org.apache.commons.cli.*;

/**
 * 
 * Liest die Parameter aus der Konsole mithilfe der Apache Commons CLI-Library ein und leitet die gegebenen Werte weiter.
 * 
 * @author Michael Weinberger 4AHITT
 *
 */
public class cliParser {
	private Options param;
	private String[] args;
	private CommandLineParser parser;
	private CommandLine cmd;
	
	private String hostname = "localhost";
	private String username = "schueler";
	private String password = "schueler";
	private String database = "segelverein";
	
	
	/**
	 * 
	 * Erstellt ein neues cliParser-Objekt und nimmt die Parameter inklusive Werte entgegen.
	 * 
	 * @param args Die Parameter mit ihren (wenn gegebenen) Werten in einem String-Array
	 * 
	 */
	public cliParser(String[] args) {
		this.param= new Options();
		this.args = args;
	}
	
	/**
	 * 
	 * Mithilfe der ArgumentFactory werden die zulaessigen Parameter initaisiert.
	 * 
	 */
	public void initArgs() {
		ArgumentFactory fac = new ArgumentFactory();
		
		param.addOption(fac.getArgument("help"));
		param.addOption(fac.getArgument("h"));
		param.addOption(fac.getArgument("u"));
		param.addOption(fac.getArgument("p"));
		param.addOption(fac.getArgument("P"));
		param.addOption(fac.getArgument("d"));
		
		parser = new BasicParser();
		try {
			cmd = parser.parse(param, args);
		} catch (ParseException e) {
			System.out.println("Das Parsen ist fehlgeschlagen! Bei folgendem Parameter kam es zu einem Fehler: " +e.getMessage());
			System.exit(1);
		}
		
		getValues();
	}
	
	/**
	 * 
	 * Wenn die Argumente auf der Konsole gegeben sind, so wird entschieden, wie diese weiterverwendet werden.
	 * Die meisten Argumente benoetigen einen Wert, dieser wird in eine Variable gespeichert, die von den untenstehenden Getter-Methoden bekommenw werden koennen.
	 * Manche Parameter brauchen keine Werte, wie etwa -help, wo gleich die Routine ausgefuehrt wird. 
	 * 
	 */
	public void getValues() {
		
		if (cmd.hasOption("help")) {
			HelpFormatter hilfe = new HelpFormatter();
			hilfe.printHelp("The Exporter", param);
			System.exit(0);
		}
		
		if (cmd.hasOption("h")) {
			hostname = cmd.getOptionValue("h");
		}
		
		if (cmd.hasOption("u")) {
			username = cmd.getOptionValue("u");
		}
		
		if (cmd.hasOption("p")) {
			password = cmd.getOptionValue("p");
		}
		
		if (cmd.hasOption("P")) {
			JPasswordField pf = new JPasswordField();
			int okCxl = JOptionPane.showConfirmDialog(null, pf, "Geben sie ihr Passwort ein!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

			String tmp = new String(pf.getPassword()); 
			
			if (okCxl == JOptionPane.OK_OPTION && tmp.equals("") == false) {
			  password = tmp;
			} else {
				System.err.println("Fehlerhaftes Passwort");
				System.exit(1);
			}
		}
		
		if (cmd.hasOption("d")) {
			database = cmd.getOptionValue("d");
		}
		
	}

	/**
	 * @return the hostname
	 */
	public String getHostname() {
		return hostname;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the database
	 */
	public String getDatabase() {
		return database;
	}
	
}
