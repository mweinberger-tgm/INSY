package tgm.exp.build;

import org.apache.commons.cli.*;

/**
 * 
 * Liest die Parameter aus der Konsole mithilfe der Apache Commons CLI-Library ein und leitet die gegebenen Werte weiter.
 * 
 * @author Michael Weinberger 4AHITT
 * @see tgm.exp.testing/options.java
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
	private String toconsole = "";
	private String tofile = "";
	
	
	/**
	 * 
	 * 
	 * 
	 * @param args
	 */
	public cliParser(String[] args) {
		this.param= new Options();
		this.args = args;
	}
	
	/**
	 * 
	 * Der OptionBuilder moechte eigentlich static aufgerufen werden, funktioniert aber wie im Entwickler-Beispiel gezeigt.
	 * 
	 */
	public void initArgs() {
		ArgumentFactory fac = new ArgumentFactory();
		
		param.addOption(fac.getArgument("help"));
		param.addOption(fac.getArgument("h"));
		param.addOption(fac.getArgument("u"));
		param.addOption(fac.getArgument("p"));
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
			System.out.println("Das Parsen ist fehlgeschlagen! " +e.getMessage());
			System.exit(1);
		}
		
		getValues();
	}
	
	/**
	 * 
	 */
	public void getValues() {
		//passwortprompt
		
		if (cmd.hasOption("help")) {
			HelpFormatter hilfe = new HelpFormatter();
			hilfe.printHelp("The Exporter", param);
		}
		
		if (cmd.hasOption("h")) {
			hostname = cmd.getOptionValue("h");
		}
		
		if (cmd.hasOption("u")) {
			username = cmd.getOptionValue("u");
		}
		
		if (cmd.hasOption("p")) {
			password = cmd.getOptionValue("p"); //Prompt!!
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
			toconsole = cmd.getOptionValue("f");
		}
		
		if (cmd.hasOption("o")) {
			tofile = cmd.getOptionValue("o");
		}
	}
	
	/**
	 * 
	 */
	public String SelectAssemble() {
		return null;
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
	public String getToconsole() {
		return toconsole;
	}

	/**
	 * @return the tofile
	 */
	public String getTofile() {
		return tofile;
	}
	
	public static void main(String[] args) {
		cliParser temp = new cliParser(args);
		temp.initArgs();
		
		System.out.println(temp.getPassword());
		
		System.exit(0);
	}
}
