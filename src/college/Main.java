package college;

public class Main {
	
	/*
	 * Main method - entry point into system
	 * Instantiate UserInterface object and
	 * run the main menu processor method from it
	 */

	public static void main(String[] args) {

		UserInterface ui = new UserInterface();
		
		ui.menuProcessor();
	}

}
