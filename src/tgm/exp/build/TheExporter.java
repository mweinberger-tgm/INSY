package tgm.exp.build;

/**
 * 
 * Hier wird nur ein Objekt der Klasse erstellt, die den Programmverlauf bestimmt.
 * 
 * @author Michael Weinberger 4AHITT
 * @version 1.0
 *
 */
public class TheExporter {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Bitte geben Sie Zeilenargumente an!");
			System.exit(1);
		}
		
		databaseConn run = new databaseConn(args);
	}
}
