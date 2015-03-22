package segelverein;

import org.apache.commons.cli.*;

/**
 * 
 * Trennt die Instanzierung der Option()-Objekten von anderen Teilen des Codes.
 * 
 * @author Michael Weinberger 4AHIT
 * @version 1.0
 *
 */
public class ArgumentFactory {
	
	/**
	 * Erstellt ein Objekt von ArgumentFactory
	 */
	public ArgumentFactory() {
		//nichts grossartiges ist hier zu finden.
	}
	
	/**
	 * 
	 * Der OptionBuilder moechte eigentlich static aufgerufen werden, funktioniert aber wie im Entwickler-Beispiel gezeigt.
	 * 
	 * @param letter Der zu initialisierende Parameter
	 * @return Das fertige Objekt des gewuenschten Parameters inklusive Beschreibung fuer die Help-Ausgabe.
	 * 
	 */
	@SuppressWarnings("static-access")
	public Option getArgument(String letter) {
		switch(letter) {
			case "help": return new Option("help", "Ausgabe der Hilfsanweisungen."); 
			case "h": return OptionBuilder.withDescription("Hostname des DBMS").withValueSeparator(' ').hasArg().create(letter); 
			case "u": return OptionBuilder.withDescription("Benutzername").withValueSeparator(' ').hasArg().create(letter); 
			case "p": return OptionBuilder.withDescription("Passwort").withValueSeparator(' ').hasArg().create(letter);
			case "P": return new Option("P", "Gibt eine Prompt aus, in der das Passwort eingegeben werden kann. ACHTUNG! Nicht auf der Konsole moeglich"); 
			case "d": return OptionBuilder.withDescription("Name der Datenbank").withValueSeparator(' ').hasArg().create(letter);
			default: return null;
		}
	}
}
