package tgm.exp.testing;

import org.apache.commons.cli.*;

/**
 * 
 * Ein Versuch mit der Apache Commons CLI Argumente zu interpretieren.
 * 
 * @author Michael Weinberger 4AHITT
 * @see http://commons.apache.org/proper/commons-cli/usage.html
 *
 */
public class options {
	public static void main(String[] args) throws ParseException {
		Options exporter = new Options();
		
		/*
		exporter.addOption("h", false, "Hostname des DBMS");
		exporter.addOption("u", false, "Benutzername");		
		exporter.addOption("p", false, "Passwort");
		exporter.addOption("d", true, "Name der Datenbank");
		exporter.addOption("T", true, "Tabellenname");
		exporter.addOption("s", false, "Feld, nach dem sortiert werden soll");
		exporter.addOption("r", false, "Sortierrichtung");
		exporter.addOption("w", false, "eine Bedingung in SQL-Syntax, die um Filtern der Tabelle verwendet wird");
		exporter.addOption("t", false, "Trennzeichen, dass für die Ausgabe verwendet werden soll");
		exporter.addOption("f", false, "Kommagetrennte Liste (ohne Leerzeichen) der Felder, die im Ergebnis enthalten sein sollen");
		exporter.addOption("o", false, "Name der Ausgabedatei");
		Auf diese Art lassen sich die OptionValues nicht auslesen!
		*/
		
		exporter.addOption( "help", false, "Ruft die Hilfe auf.");
		exporter.addOption(OptionBuilder.withDescription("Hostname des DBMS").withValueSeparator(' ').hasArg().create("h"));
		exporter.addOption(OptionBuilder.withDescription("Benutzername").withValueSeparator(' ').hasArg().create("u"));
		exporter.addOption(OptionBuilder.withDescription("Passwort").withValueSeparator(' ').hasArg().create("p"));
		exporter.addOption(OptionBuilder.withDescription("Name der Datenbank").withValueSeparator(' ').hasArg().create("d"));
		exporter.addOption(OptionBuilder.withDescription("Tabellenname").withValueSeparator(' ').hasArg().create("T"));
		exporter.addOption(OptionBuilder.withDescription("Feld, nach dem sortiert werden soll").withValueSeparator(' ').hasArg().create("s"));
		exporter.addOption(OptionBuilder.withDescription("Sortierrichtung").withValueSeparator(' ').hasArg().create("r"));
		exporter.addOption(OptionBuilder.withDescription("eine Bedingung in SQL-Syntax, die um Filtern der Tabelle verwendet wird").withValueSeparator(' ').hasArg().create("w"));
		exporter.addOption(OptionBuilder.withDescription("Trennzeichen, dass für die Ausgabe verwendet werden soll").withValueSeparator(' ').hasArg().create("t"));
		exporter.addOption(OptionBuilder.withDescription("Kommagetrennte Liste (ohne Leerzeichen) der Felder, die im Ergebnis enthalten sein sollen").withValueSeparator(' ').hasArg().create("f"));
		exporter.addOption(OptionBuilder.withDescription("Name der Ausgabedatei").withValueSeparator(' ').hasArg().create("o"));
		
		CommandLineParser parser = new BasicParser();
		CommandLine cmd = parser.parse(exporter, args);
		
		if(cmd.hasOption("u")) {
			System.out.println(cmd.getOptionValue("u"));
		}
		
		if(cmd.hasOption("p")) {
		    System.out.println(cmd.getOptionValue("p"));
		}
		
		if(cmd.hasOption("d")) {
		    System.out.println(cmd.getOptionValue("p"));
		} else {
			System.out.println("Nicht vorhanden!");
		}
		
		
		System.exit(0);
	}
}
