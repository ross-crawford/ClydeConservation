package college;
import java.util.ArrayList;

public class Collection {
	
	/*
	 * VARIABLES
	 * ArrayList for all Cages / Animals / Keepers declared
	 * FileIO object declared
	 */
	private ArrayList<Cage> allCages;
	private ArrayList<Animal> allAnimals;
	private ArrayList<Keeper> allKeepers;
	private FileIO data;
	
	/*
	 * CONSTRUCTOR
	 * Initialise all arrayLists
	 * Instantiate FileIO object
	 * Call readData() method to populate data structures from
	 * text file data
	 * Collection object instantiated on program start so data is 
	 * automatically read
	 */
	
	public Collection() {
		allCages = new ArrayList<>();
		allAnimals = new ArrayList<>();
		allKeepers = new ArrayList<>();
		data = new FileIO();
		readData();
	}
	
	/*
	 * Cage search method
	 * Finds Cage object based on ID entered in ID search method
	 * Returns Cage object
	 */
	public Cage searchCage() {
		String id = searchId("Cage");
		Cage thisCage = null;
		for(Cage i : allCages) {
			if(id.equals(i.getCageId())) {
				thisCage = i;
			}
		}
		return thisCage;
	}
	
	/*
	 * Animal search method
	 * Finds Animal object based on ID entered in ID search method
	 * Returns Animal object
	 */
	public Animal searchAnimal() {
		String id = searchId("Animal");
		Animal thisAnimal = null;
		for(Animal i : allAnimals) {
			if(id.equals(i.getAnimalId())) {
				thisAnimal = i;
			}
		}
		return thisAnimal;
	}
	
	/*
	 * Keeper search method
	 * Finds Keeper object based on ID entered in ID search method
	 * Returns Keeper object
	 */
	public Keeper searchKeeper() {
		String id = searchId("Keeper");
		Keeper thisKeeper = null;
		for(Keeper i : allKeepers) {
			if(id.equals(i.getKeeperId())) {
				thisKeeper = i;
			}
		}
		return thisKeeper;
	}
	
	/*
	 * Add new Cage method
	 * Creates a new Cage object and passes it to the newCage() method in 
	 * Cage class for setup
	 * Adds new Cage to allCages ArrayList
	 * Prints new Cage details
	 */
	public void addCage() {
		Cage cage = new Cage();
		cage = cage.newCage(cage);
		allCages.add(cage);
		System.out.println("Cage successfully added");
		displayCageDetails(cage);
	}
	
	/*
	 * Add new Animal method
	 * Creates a new Animal object and passes it to the newAnimal() method in 
	 * Animal class for setup
	 * Adds new Animal to allAnimals ArrayList
	 * Prints new Animal details
	 */
	public void addAnimal() {
		Animal animal = new Animal();
		animal = animal.newAnimal(animal);
		allAnimals.add(animal);
		System.out.println("Animal successfully added");
		displayAnimalDetails(animal);
	}
	
	/*
	 * Add new Keeper method
	 * Creates a new Keeper object and passes it to the newKeeper() method in 
	 * Keeper class for setup
	 * Adds new Keeper to allKeepers ArrayList
	 * Prints new Keeper details
	 */
	public void addKeeper() {
		Keeper keeper = new Keeper();
		keeper = keeper.newKeeper(keeper);
		allKeepers.add(keeper);
		System.out.println("Keeper successfully added");
		displayKeeperDetails(keeper);
	}
	
	/*
	 * Assign Animal to Cage method
	 * Obtains an Animal and Cage object from the search methods above
	 * Checks neither are null
	 * Passes both objects to assignAnimal() method in Cage class
	 */
	public void assignAnimalCage() {
		Animal animal = searchAnimal();
		Cage cage = searchCage();
		if(animal == null) {
			Validate.errorMessage("Animal ID");
			assignAnimalCage();
		} else if(cage == null) {
			Validate.errorMessage("Cage ID");
			assignAnimalCage();
		} else {
			cage.assignAnimal(cage, animal);
		}
	}
	
	/*
	 * Assign Keeper to Cage method
	 * Obtains an Keeper and Cage object from the search methods above
	 * Checks neither are null
	 * Passes both objects to assignKeeper() method in Cage class
	 */
	public void assignKeeperCage() {
		Keeper keeper = searchKeeper();
		Cage cage = searchCage();
		if(keeper == null) {
			Validate.errorMessage("Keeper ID");
			assignKeeperCage();
		} else if(cage == null) {
			Validate.errorMessage("Cage ID");
			assignKeeperCage();
		} else {
			cage.assignKeeper(cage, keeper);
		}
	}
	
	/*
	 * Display all cages method
	 * Loops through allCages ArrayList
	 * and passes each Cage object to displayCageDetails()
	 * method below for printing
	 */
	public void displayAllCages() {
		for(Cage i : allCages) {
			displayCageDetails(i);
		}
	}
	
	/*
	 * Display Cage Details method
	 * Takes a Cage object as parameter
	 * Prints all details for that Cage 
	 * Formatted for readability
	 */
	public void displayCageDetails(Cage cage) {
		System.out.println("Cage ID: " + cage.getCageId());
		System.out.println("Cage Size: " + cage.getCageSize());
		System.out.println("Cage Type: " + cage.getCageType());
		System.out.println("Cage Animal Capacity: " + cage.getMaxAnimals());
		System.out.println("Cage Keeper Capacity: " + cage.getMaxKeepers() + "\n");
		System.out.println("Animals: ");
		for(Animal i : cage.getCagedAnimals()) {
			System.out.println("\t" + i.getAnimalName() + " the " + i.getAnimalSpecies());
		}
		System.out.println("\nKeepers:");
		for(Keeper i : cage.getCagedKeepers()) {
			System.out.println("\t" + i.getFirstName() + " " + i.getLastName());
		}
		System.out.println("\n");
	}
	
	/*
	 * Display all Animals method
	 * Loops through allAnimals ArrayList
	 * and passes each Animal object to displayAnimalDetails()
	 * method below for printing
	 */
	public void displayAllAnimals() {
		for(Animal i : allAnimals) {
			displayAnimalDetails(i);
		}
	}
	
	/*
	 * Display Animal Details method
	 * Takes a Animal object as parameter
	 * Prints all details for that Animal 
	 * Formatted for readability
	 */
	public void displayAnimalDetails(Animal animal) {
		System.out.println("Animal ID: " + animal.getAnimalId());
		System.out.println("Animal Name: " + animal.getAnimalName());
		System.out.println("Animal Sex: " + animal.getAnimalSex());
		System.out.println("Animal Family: " + animal.getAnimalFamily());
		System.out.println("Animal Species: " + animal.getAnimalSpecies());
		System.out.println("Cage: " + animal.getCageAssignment() + "\n");
	}
	
	/*
	 * Display all Keepers method
	 * Loops through allKeepers ArrayList
	 * and passes each Keeper object to displayKeeperDetails()
	 * method below for printing
	 */
	public void displayAllKeepers() {
		for(Keeper i : allKeepers) {
			displayKeeperDetails(i);
		}
	}
	
	/*
	 * Display Keeper Details method
	 * Takes a Keeper object as parameter
	 * Prints all details for that Keeper 
	 * Formatted for readability
	 */
	public void displayKeeperDetails(Keeper keeper) {
		System.out.println("Keeper ID: " + keeper.getKeeperId());
		System.out.println("Keeper First Name: " + keeper.getFirstName());
		System.out.println("Keeper Last Name: " + keeper.getLastName());
		for(String i : keeper.getCageAssignment()) {
			int j = 1;
			System.out.println("Cage Assignment " + j + ": " + i);
			j++;
		}
		System.out.println("\n");
	}
	
	/*
	 * Edit Animal method
	 * Obtains Animal object from search method above
	 * Passes Animal object to editAnimalDetails() method in
	 * Animal class
	 * Prints new Animal details after editing
	 */
	public void editAnimal() {
		Animal animal = searchAnimal();
		animal.editAnimalDetails(animal);
		displayAnimalDetails(animal);
	}
	
	/*
	 * Edit Keeper method
	 * Obtains Keeper object from search method above
	 * Passes Keeper object to editKeeperDetails() method in
	 * Keeper class
	 * Prints new Keeper details after editing
	 */
	public void editKeeper() {
		Keeper keeper = searchKeeper();
		keeper.editKeeperDetails(keeper);
		displayKeeperDetails(keeper);
	}
	
	/*
	 * Remove Animal method
	 * Obtains Animal and Cage objects from search method above
	 * Passes both objects to the unassignAnimal() method in Cage class
	 */
	public void removeAnimal() {
		Animal animal = searchAnimal();
		Cage cage = searchCage();
		cage.unassignAnimal(cage, animal);
	}
	
	/*
	 * Remove Keeper method
	 * Obtains Keeper and Cage objects from search method above
	 * Passes both objects to the unassignKeeper() method in Cage class
	 */
	public void removeKeeper() {
		Keeper keeper = searchKeeper();
		Cage cage = searchCage();
		cage.unassignKeeper(cage, keeper);
	}
	
	/*
	 * Search ID method
	 * Takes in String of type as parameter
	 * type defines what type of ID is being searched for
	 * Variable id reads user input
	 * returns id
	 */
	public String searchId(String type) {
		System.out.println("Please enter " + type + " ID: ");
		String id = Validate.sc.nextLine();
		return id;
	}
	
	/*
	 * Save Data method
	 * Passes each ArrayList to their respective
	 * write details method in FileIO class
	 */
	public void saveData() {
		data.writeAnimaDetails(allAnimals);
		data.writeKeeperDetails(allKeepers);
		data.writeCageDetails(allCages);
	}
	
	/*
	 * Read Data method
	 * Passes each ArrayList to their respective 
	 * read data method in FileIO class
	 * ArrayLists in Cage class also defined here
	 * after main ArrayLists are populated
	 */
	public void readData() {
		data.readAnimalData(allAnimals);
		data.readKeeperData(allKeepers);
		data.readCageData(allCages);
		for(Cage cage : allCages) {
			for(Animal animal : allAnimals) {
				if(animal.getCageAssignment().equals(cage.getCageId())) {
					cage.getCagedAnimals().add(animal);
				}
			}
			for(Keeper keeper : allKeepers) {
				if(keeper.getCageAssignment().contains(cage.getCageId())) {
					cage.getCagedKeepers().add(keeper);
				}
			}
		}
	}
	
	/*
	 * Weekly Report Method
	 * Passes each ArrayList into the generateWeeklyReport()
	 * method in FileIO class
	 * Inform user that report has been generated after
	 */
	public void weeklyReport() {
		data.generateWeeklyReport(allAnimals, allKeepers, allCages);
		System.out.println("Weekly Report Generated\n");
	}

	/*
	 * GETTERS AND SETTERS
	 */
	public ArrayList<Cage> getAllCages() {
		return allCages;
	}

	public void setAllCages(ArrayList<Cage> allCages) {
		this.allCages = allCages;
	}

	public ArrayList<Animal> getAllAnimals() {
		return allAnimals;
	}

	public void setAllAnimals(ArrayList<Animal> allAnimals) {
		this.allAnimals = allAnimals;
	}

	public ArrayList<Keeper> getAllKeepers() {
		return allKeepers;
	}

	public void setAllKeepers(ArrayList<Keeper> allKeepers) {
		this.allKeepers = allKeepers;
	}
}
