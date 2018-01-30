package college;

public class Animal {
	
	/*
	 * VARIABLES - all Animal object attributes declared
	 */
	private String animalId;
	private String animalName;
	private String animalSex;
	private String animalFamily;
	private String animalSpecies;
	private String cageAssignment;
	
	/*
	 * CONSTRUCTOR - no action required in this
	 */
	public Animal() {
		
	}
	
	/*
	 * New Animal method
	 * Takes a blank Animal object as parameter
	 * Prompts user to enter Animal details
	 * Assigns these inputs to Animal attributes with
	 * setters
	 * Animal Family and Species are defined with switch menus
	 * below, and ID is automatically generated
	 * Returns Animal object
	 */
	public Animal newAnimal(Animal animal) {
		System.out.println("Please enter Animal name: ");
		animal.setAnimalName(Validate.sc.nextLine());
		System.out.println("Please enter Animal sex: ");
		animal.setAnimalSex(Validate.sc.nextLine());
		System.out.println("Please enter Animal family: ");
		animal.setAnimalFamily(animalFamilySelector());
		System.out.println("Please enter Animal species: ");
		animal.setAnimalSpecies(animalSpeciesSelector(animal.getAnimalFamily()));
		animal.setAnimalId(Validate.idGenerator(animal.getAnimalSpecies().substring(0, 2).toUpperCase()));
		animal.setCageAssignment("None");
		return animal;
	}
	
	/*
	 * Animal Family Selector method
	 * Switch menu to setAnimalFamily() above
	 * returns family
	 */
	public String animalFamilySelector() {
		int choice;
		String family = "";
		System.out.println("\t1. Mammal");
		System.out.println("\t2. Bird");
		System.out.println("\t3. Reptile");
		choice = Validate.validateInteger();
		try {
			if(choice == 1) {
				family = "Mammal";
			} else if(choice == 2) {
				family = "Bird";
			} else if(choice == 3) {
				family = "Reptile";
			} else {
				Validate.errorMessage("selection");
				animalFamilySelector();
			}
		} catch(NumberFormatException e) {
			Validate.errorMessage("input");			
		}
		return family;
	}
	
	/*
	 * Animal Species Selector method
	 * Takes String family as parameter which determines
	 * which switch runs
	 * sets species based on user input
	 * Returns species
	 */
	public String animalSpeciesSelector(String family) {
		int choice;
		String type = "";
		if(family.equals("Mammal")) {
			System.out.println("\t1. Ape");
			System.out.println("\t2. Donkey");
			System.out.println("\t3. Guinea-Pig");
			System.out.println("\t4. Horse");
			System.out.println("\t5. Marmoset-Monkey");
			System.out.println("\t6. Rabbit");
			System.out.println("\t7. Tiger");
			System.out.println("\t8. Zebra");
			choice = Validate.validateInteger();
			try {
				switch(choice) {
				case 1:
					type = "Ape";
					break;
				case 2: 
					type = "Donkey";
					break;
				case 3:
					type = "Guinea-Pig";
					break;
				case 4:
					type = "Horse";
					break;
				case 5:
					type = "Marmoset-Monkey";
					break;
				case 6:
					type = "Rabbit";
					break;
				case 7:
					type = "Tiger";
					break;
				case 8:
					type = "Zebra";
					break;
				default:
					Validate.errorMessage("selection");
					choice = Validate.validateInteger();
				}
			} catch(NumberFormatException e) {
				Validate.errorMessage("input");
			}
			return type;
			
		} else if (family.equals("Bird")) {
			System.out.println("\t1. Emu");
			System.out.println("\t2. Owl");
			System.out.println("\t3. Penguin");
			System.out.println("\t4. Vulture");
			choice = Validate.validateInteger();
			try {
				switch(choice) {
				case 1:
					type = "Emu";
					break;
				case 2:
					type = "Owl";
					break;
				case 3:
					type = "Penguin";
					break;
				case 4:
					type = "Vulture";
					break;
				default:
					Validate.errorMessage("selection");
					choice = Validate.validateInteger();
				}
			} catch(NumberFormatException e) {
				Validate.errorMessage("input");
			}
			return type;
			
		} else {
			System.out.println("\t1. Bearded-Dragon");
			System.out.println("\t2. Chameleon");
			System.out.println("\t3. Lizard");
			choice = Validate.validateInteger();
			try {
				switch(choice) {
				case 1:
					type = "Bearded-Dragon";
					break;
				case 2:
					type = "Chameleon";
					break;
				case 3:
					type = "Lizard";
					break;
				default:
					Validate.errorMessage("selection");
					choice = Validate.validateInteger();
				}
			} catch(NumberFormatException e) {
				Validate.errorMessage("input");
			}
			return type;
		}
	}
	
	/*
	 * Edit Animal Details method
	 * Takes an Animal object as parameter
	 * Prints edit menu to determine which details are 
	 * to be edited for that Animal
	 * Takes user input for each case and sets new Animal
	 * details.
	 * Limited to only change name and sex as other attributes
	 * can negatively impact other aspects of the program
	 */
	public void editAnimalDetails(Animal animal) {
		boolean run = true;
		while(run) {
			if(animal != null) {
				System.out.println("\nPlease choose an option: \n");
				System.out.println("1. Edit Animal Name");
				System.out.println("2. Edit Animal Sex");
				System.out.println("3. Exit");
				int choice = Validate.validateInteger();
				try {
					switch(choice) {
					case 1:
						System.out.println("Enter new Animal Name: ");
						String newName = Validate.validateString();
						animal.setAnimalName(newName);
						break;
					case 2:
						System.out.println("Enter new Animal Sex: ");
						String newSex = Validate.validateString();
						animal.setAnimalSex(newSex);
						break;
					case 3:
						System.out.println("Animal Details updated\n");
						run = false;
						break;
					default:
						Validate.errorMessage("selection");
						editAnimalDetails(animal);
					}
				} catch(NumberFormatException e) {
					Validate.errorMessage("input");
					editAnimalDetails(animal);
				}
			}
		}
	}

	/*
	 * GETTERS AND SETTERS
	 */
	public String getAnimalId() {
		return animalId;
	}

	public void setAnimalId(String animalId) {
		this.animalId = animalId;
	}

	public String getAnimalName() {
		return animalName;
	}

	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	public String getAnimalSex() {
		return animalSex;
	}

	public void setAnimalSex(String animalSex) {
		this.animalSex = animalSex;
	}

	public String getAnimalFamily() {
		return animalFamily;
	}

	public void setAnimalFamily(String animalFamily) {
		this.animalFamily = animalFamily;
	}

	public String getAnimalSpecies() {
		return animalSpecies;
	}

	public void setAnimalSpecies(String animalSpecies) {
		this.animalSpecies = animalSpecies;
	}

	public String getCageAssignment() {
		return cageAssignment;
	}

	public void setCageAssignment(String cageAssignment) {
		this.cageAssignment = cageAssignment;
	}
}
