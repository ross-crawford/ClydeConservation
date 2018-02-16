package college;


public class UserInterface {
	
	/*
	 * VARIABLES
	 * Declare Collection object
	 */
	private Collection col;
	
	/*
	 * CONSTRUCTOR
	 * Initialise Collection object
	 */
	public UserInterface() {
		col = new Collection();
	}
	
	/*
	 * Main menu processor method to accept user input
	 * and direct to appropriate section of program
	 * Prints the main menu options
	 */
	public void menuProcessor() {
		int choice = 0;
		while(true) {
			try {
				displayMainMenu();
				choice = Validate.validateInteger();
				switch(choice) {
				case 1:
					addMenuProcessor();
					break;
				case 2:
					assignMenuProcessor();
					break;
				case 3:
					viewMenuProcessor();
					break;
				case 4:
					editMenuProcessor();
					break;
				case 5:
					removeMenuProcessor();
					break;
				case 6:
					reportsMenuProcessor();
					break;
				case 7:
					col.saveData();
					System.out.println("Exiting...");
					System.exit(0);
					break;
				default:
					Validate.errorMessage("selection");
					break;
				}
			} catch(NumberFormatException e) {
				Validate.errorMessage("input");
				menuProcessor();
			}
		}
	}
	
	/*
	 * Add sub-menu processor
	 * Directs user to section of program related to
	 * adding new items (Cage, Animal, or Keeper)
	 * Prints Add menu options
	 */
	public void addMenuProcessor() {
		int choice = 0;
		while(true) {
			try {
				displayAddMenu();
				choice = Validate.validateInteger();
				switch(choice) {
				case 1:
					col.addCage();
					break;
				case 2:
					col.addAnimal();
					break;
				case 3:
					col.addKeeper();
					break;
				case 4:
					menuProcessor();
					break;
				default:
					Validate.errorMessage("selection");
					break;
				}
			} catch(NumberFormatException e) {
				Validate.errorMessage("input");
				addMenuProcessor();
			}
		}
	}
	
	/*
	 * Assign sub-menu processor
	 * Directs user to section of program related to
	 * assigning items (Animal or Keeper) to a Cage
	 * Prints Assign menu options
	 */
	public void assignMenuProcessor() {
		int choice = 0;
		while(true) {
			try {
				displayAssignMenu();
				choice = Validate.validateInteger();
				switch(choice) {
				case 1:
					col.assignAnimalCage();
					break;
				case 2:
					col.assignKeeperCage();
					break;
				case 3:
					menuProcessor();
					break;
				default:
					Validate.errorMessage("selection");
					break;
				}
			} catch(NumberFormatException e) {
				Validate.errorMessage("input");
				assignMenuProcessor();
			}
		}
	}
	
	/*
	 * View sub-menu processor
	 * Directs user to section of program related to
	 * viewing items (Cage, Animal, or Keeper) details
	 * Prints View menu options
	 */
	public void viewMenuProcessor() {
		int choice = 0;
		while(true) {
			try {
				displayViewMenu();
				choice = Validate.validateInteger();
				switch(choice) {
				case 1:
					col.displayAllCages();
					break;
				case 2:
					col.displayAllAnimals();
					break;
				case 3:
					col.displayAllKeepers();
					break;
				case 4:
					menuProcessor();
					break;
				default:
					Validate.errorMessage("selection");
					break;
				}
			} catch(NumberFormatException e) {
				Validate.errorMessage("input");
				viewMenuProcessor();
			}
		}
	}
	
	/*
	 * Edit sub-menu processor
	 * Directs user to section of program related to
	 * editing items (Cage, Animal, or Keeper)
	 * Prints Edit menu options
	 */
	public void editMenuProcessor() {
		int choice = 0;
		while(true) {
			try {
				displayEditMenu();
				choice = Validate.validateInteger();
				switch(choice) {
				case 1:
					col.editAnimal();
					break;
				case 2:
					col.editKeeper();
					break;
				case 3:
					menuProcessor();
					break;
				default:
					Validate.errorMessage("selection");
					break;
				}
			} catch(NumberFormatException e) {
				Validate.errorMessage("input");
				editMenuProcessor();
			}
		}
	}
	
	/*
	 * Remove sub-menu processor
	 * Directs user to section of program related to
	 * removing items (Animal or Keeper) from a Cage
	 * Prints Remove menu options
	 */
	public void removeMenuProcessor() {
		int choice = 0;
		while(true) {
			try {
				displayRemoveMenu();
				choice = Validate.validateInteger();
				switch(choice) {
				case 1:
					col.removeAnimal();
					break;
				case 2:
					col.removeKeeper();
					break;
				case 3:
					menuProcessor();
					break;
				default:
					Validate.errorMessage("selection");
					break;
				}
			} catch(NumberFormatException e) {
				Validate.errorMessage("input");
				removeMenuProcessor();
			}
		}
	}
	
	/*
	 * Reports sub-menu processor
	 * Directs user to section of program related to
	 * generating reports
	 * Prints Reports menu options
	 */
	public void reportsMenuProcessor() {
		int choice = 0;
		while(true) {
			try {
				displayReportsMenu();
				choice = Validate.validateInteger();
				switch(choice) {
				case 1:
					col.weeklyReport();
					break;
				case 2:
					menuProcessor();
					break;
				default:
					Validate.errorMessage("selection");
					break;
				}
			} catch(NumberFormatException e) {
				Validate.errorMessage("input");
				reportsMenuProcessor();
			}
		}
	}
	
	/*
	 * Method for printing Main Menu
	 */
	public void displayMainMenu() {
		System.out.println("\n======== MAIN MENU ========\n");
		System.out.println("1.  Add");
		System.out.println("2.  Assign");
		System.out.println("3.  View");
		System.out.println("4.  Edit");
		System.out.println("5.  Remove");
		System.out.println("6.  Reports");
		System.out.println("7.  Exit");
		System.out.println("\n\nPlease choose an option:");
		System.out.flush();
	}
	
	/*
	 * Method for printing Add Menu
	 */
	public void displayAddMenu() {
		System.out.println("\n======== ADD ========\n");
		System.out.println("1.  Add new Cage");
		System.out.println("2.  Add new Animal");
		System.out.println("3.  Add new Keeper");
		System.out.println("4.  Return to Main Menu");
		System.out.println("\n\nPlease choose an option:");
		System.out.flush();
	}
	
	/*
	 * Method for printing Assign Menu
	 */
	public void displayAssignMenu() {
		System.out.println("\n======== ASSIGN ========\n");
		System.out.println("1.  Assign Animal to Cage");
		System.out.println("2.  Assign Keeper to Cage");
		System.out.println("3.  Return to Main Menu");
		System.out.println("\n\nPlease choose an option:");
		System.out.flush();
	}
	
	/*
	 * Method for printing View Menu
	 */
	public void displayViewMenu() {
		System.out.println("\n======== VIEW ========\n");
		System.out.println("1.  View Cage Details");
		System.out.println("2.  View Animal Details");
		System.out.println("3.  View Keeper Details");
		System.out.println("4.  Return to Main Menu");
		System.out.println("\n\nPlease choose an option:");
		System.out.flush();
	}
	
	/*
	 * Method for printing Edit Menu
	 */
	public void displayEditMenu() {
		System.out.println("\n======== EDIT ========\n");
		System.out.println("1.  Edit Animal Details");
		System.out.println("2.  Edit Keeper Details");
		System.out.println("3.  Return to Main Menu");
		System.out.println("\n\nPlease choose an option:");
		System.out.flush();
	}
	
	/*
	 * Method for printing Remove Menu
	 */
	public void displayRemoveMenu() {
		System.out.println("\n======== REMOVE ========\n");
		System.out.println("1.  Remove Animal from Cage");
		System.out.println("2.  Remove Keeper from Cage");
		System.out.println("3.  Return to Main Menu");
		System.out.println("\n\nPlease choose an option:");
		System.out.flush();
	}
	
	/*
	 * Method for printing Reports Menu
	 */
	public void displayReportsMenu() {
		System.out.println("\n======== REPORTS ========\n");
		System.out.println("1.  Generate Weekly Report");
		System.out.println("2.  Return to Main Menu");
		System.out.println("\n\nPlease choose an option:");
	}
}
