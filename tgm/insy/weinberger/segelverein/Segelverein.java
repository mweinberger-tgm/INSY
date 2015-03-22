package segelverein;

/**
 * 
 * @author Michael Weinberger 4AHIT
 * @version 2015-03-22
 *
 */
public class Segelverein {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("Bitte geben Sie Zeilenargumente an!");
			System.exit(1);
		}
		
		databaseConn run = new databaseConn(args);
	}
}