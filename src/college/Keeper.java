package college;

import java.util.ArrayList;

public class Keeper {
	
	/*
	 * VARIABLES - all Keeper object attributes declared
	 */
	private String keeperId;
	private String firstName;
	private String lastName;
	private ArrayList<String> cageAssignment;
	
	/*
	 * CONSTRUCTOR - cageAssignment ArrayList initialised
	 */
	public Keeper() {
		cageAssignment = new ArrayList<>();
	}

	/*
	 * New Keeper method
	 * Takes a blank Keeper object as parameter
	 * Prompts user to enter Keeper details
	 * Assigns these inputs to Keeper attributes with
	 * setters
	 * Keeper cageAssignment ArrayList is looped through and
	 * initialised to "None", and ID is automatically generated
	 * Returns Keeper object
	 */
	public Keeper newKeeper(Keeper keeper) {
		System.out.println("Please enter Keeper first name: ");
		keeper.setFirstName(Validate.validateString());
		System.out.println("Please enter Keeper last name: ");
		keeper.setLastName(Validate.validateString());
		keeper.setKeeperId(Validate.idGenerator("KP"));
		for(int i = 0; i < 4; i++) {
			keeper.cageAssignment.add("None");
		}
		return keeper;
	}
	
	/*
	 * Edit Keeper Details method
	 * Takes an Keeper object as parameter
	 * Prints edit menu to determine which details are 
	 * to be edited for that Keeper
	 * Takes user input for each case and sets new Keeper
	 * details.
	 * Limited to only change first and last name as other attributes
	 * can negatively impact other aspects of the program
	 */
	public void editKeeperDetails(Keeper keeper) {
		boolean run = true;
		while(run) {
			try {
				if(keeper != null) {
					System.out.println("\nPlease choose an option: \n");
					System.out.println("1. Edit Keeper First Name");
					System.out.println("2. Edit Keeper Last Name");
					System.out.println("3. Exit");
					int choice = Validate.validateInteger();
					switch(choice) {
					case 1:
						System.out.println("Enter new First Name: ");
						String newFirstName = Validate.validateString();
						keeper.setFirstName(newFirstName);
						break;
					case 2:
						System.out.println("Enter new Last Name: ");
						String newLastName = Validate.validateString();
						keeper.setLastName(newLastName);
						break;
					case 3:
						System.out.println("Keeper Details udated\n");
						run = false;
						break;
					default:
						Validate.errorMessage("selection");
						editKeeperDetails(keeper);
					}
				}
			} catch(NumberFormatException e) {
				Validate.errorMessage("input");
				editKeeperDetails(keeper);
			}
		}
	}
	
	/*
	 * SETTERS AND GETTERS
	 */
	public String getKeeperId() {
		return keeperId;
	}

	public void setKeeperId(String keeperId) {
		this.keeperId = keeperId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public ArrayList<String> getCageAssignment() {
		return cageAssignment;
	}

	public void setCageAssignment(ArrayList<String> cageAssignment) {
		this.cageAssignment = cageAssignment;
	}
}
