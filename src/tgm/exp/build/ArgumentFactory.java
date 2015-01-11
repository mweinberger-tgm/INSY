package tgm.exp.build;

import org.apache.commons.cli.*;

public class ArgumentFactory {
	
	/**
	 * 
	 */
	public ArgumentFactory() {
		//
	}
	
	/**
	 * 
	 * Der OptionBuilder moechte eigentlich static aufgerufen werden, funktioniert aber wie im Entwickler-Beispiel gezeigt.
	 * 
	 * @param letter
	 * @return
	 */
	@SuppressWarnings("static-access")
	public Option getArgument(String letter) {
		switch(letter) {
			case "help": return OptionBuilder.withDescription("Aufruf der Hilfe").withValueSeparator(' ').hasArg().create(letter); 
			case "h": return OptionBuilder.withDescription("Hostname des DBMS").withValueSeparator(' ').hasArg().create(letter); 
			case "u": return OptionBuilder.withDescription("Benutzername").withValueSeparator(' ').hasArg().create(letter); 
			case "p": return OptionBuilder.withDescription("Passwort").withValueSeparator(' ').hasArg().create(letter); 
			case "d": return OptionBuilder.withDescription("Name der Datenbank").withValueSeparator(' ').hasArg().create(letter); 
			case "T": return OptionBuilder.withDescription("Tabellenname").withValueSeparator(' ').hasArg().create(letter); 
			case "s": return OptionBuilder.withDescription("Feld, nach dem sortiert werden soll").withValueSeparator(' ').hasArg().create(letter); 
			case "r": return OptionBuilder.withDescription("Sortierrichtung").withValueSeparator(' ').hasArg().create(letter); 
			case "w": return OptionBuilder.withDescription("eine Bedingung in SQL-Syntax, die um Filtern der Tabelle verwendet wird").withValueSeparator(' ').hasArg().create(letter); 
			case "t": return OptionBuilder.withDescription("Trennzeichen, dass für die Ausgabe verwendet werden soll").withValueSeparator(' ').hasArg().create(letter); 
			case "f": return OptionBuilder.withDescription("Kommagetrennte Liste (ohne Leerzeichen) der Felder, die im Ergebnis enthalten sein sollen").withValueSeparator(' ').hasArg().create(letter); 
			case "o": return OptionBuilder.withDescription("Name der Ausgabedatei").withValueSeparator(' ').hasArg().create(letter); 
			default: return null;
		}
	}
}
