package tgm.exp.build;

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
	private String username = System.getProperty("user.name");
	private String password = "";
	private String database = "";
	private String tablename = "";
	private String sortfield = "";
	private String sortdirection = "ASC";
	private String condition = "";
	private String delimiter = ";";
	private String list = "";
	private String tofile = null;
	
	
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
		param.addOption(fac.getArgument("T"));
		param.addOption(fac.getArgument("s"));
		param.addOption(fac.getArgument("r"));
		param.addOption(fac.getArgument("w"));
		param.addOption(fac.getArgument("t"));
		param.addOption(fac.getArgument("f"));
		param.addOption(fac.getArgument("o"));
		
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
			//see http://stackoverflow.com/questions/8881213/joptionpane-to-get-password
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
		
		if (cmd.hasOption("T")) {
			tablename = cmd.getOptionValue("T");
		}
		
		if (cmd.hasOption("s")) {
			sortfield = cmd.getOptionValue("s");
		}
		
		if (cmd.hasOption("r")) {
			sortdirection = cmd.getOptionValue("r");
		}
		
		if (cmd.hasOption("w")) {
			condition = cmd.getOptionValue("w");
		}
		
		if (cmd.hasOption("t")) {
			delimiter = cmd.getOptionValue("t");
		}
		
		if (cmd.hasOption("f")) {
			list = cmd.getOptionValue("f");		
		}
		
		if (cmd.hasOption("o")) {
			tofile = cmd.getOptionValue("o");
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

	/**
	 * @return the tablename
	 */
	public String getTablename() {
		return tablename;
	}

	/**
	 * @return the sortfield
	 */
	public String getSortfield() {
		return sortfield;
	}

	/**
	 * @return the sortdirection
	 */
	public String getSortdirection() {
		return sortdirection;
	}

	/**
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * @return the delimiter
	 */
	public String getDelimiter() {
		return delimiter;
	}

	/**
	 * @return the toconsole
	 */
	public String getList() {
		return list;
	}

	/**
	 * @return the tofile
	 */
	public String getTofile() {
		return tofile;
	}
	
}
