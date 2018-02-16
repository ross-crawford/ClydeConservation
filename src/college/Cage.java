package college;

import java.util.InputMismatchException;
import java.util.LinkedList;

public class Cage {
	
	/*
	 * VARIABLES - all Cage object attributed declared 
	 */
	private String cageId;
	private String cageSize;
	private String cageType;
	private int maxAnimals;
	private int maxKeepers;
	private LinkedList<Animal> cagedAnimals;
	private LinkedList<Keeper> cagedKeepers;
	
	/*
	 * CONSTRUCTOR - initialise both LinkedLists
	 */
	public Cage() {
		cagedAnimals = new LinkedList<Animal>();
		cagedKeepers = new LinkedList<Keeper>();
	}
	
	/*
	 * New Cage method
	 * Takes a blank Cage object as parameter
	 * Prompts user to enter Cage details
	 * Assigns these inputs to Keeper attributes with
	 * setters
	 * Switch used to set Cage size, maxAnimal, and maxKeeper, based
	 * on choice, and ID is automatically generated
	 * Cage Type set to "None" as default
	 * Returns Cage object
	 */
	public Cage newCage(Cage cage) {
		String size = "";
		int maxAnimal = 0;
		int maxKeeper = 0;
		boolean noError = true;
		
		while(noError) {
			
			try {
				System.out.println("Please enter cage size: ");
				cageSizeMenu();
				int choice = (int)Validate.validateInteger();
				switch(choice) {
				case 1:
					size = "Small";
					maxAnimal = 2;
					maxKeeper = 1;
					break;
				case 2:
					size = "Medium";
					maxAnimal = 4;
					maxKeeper = 2;
					break;
				case 3:
					size = "Large";
					maxAnimal = 8;
					maxKeeper = 3;
					break;
				case 4:
					size = "Extra-Large";
					maxAnimal = 16;
					maxKeeper = 4;
					break;
				default:
					Validate.errorMessage("selection");
					newCage(cage);
				}
			} catch (InputMismatchException e) {
				Validate.errorMessage("input");
				newCage(cage);
			}
			if(noError) {
				break;
			}
			
		}
		cage.setCageId(Validate.idGenerator("CG"));
		cage.setCageSize(size);
		cage.setCageType("None");
		cage.setMaxAnimals(maxAnimal);
		cage.setMaxKeepers(maxKeeper);
		return cage;
	}
	
	/*
	 * Cage Size Menu method
	 * Prints the different Cage sizes available
	 * Also prints corresponding animal/keeper limits
	 * for each size
	 * Used in New Cage method
	 */
	public void cageSizeMenu() {
		System.out.println("\t1. Small (2 Animals, 1 Keeper)");
		System.out.println("\t2. Medium (4 Animals, 2 Keeper)");
		System.out.println("\t3. Large (8 Animals, 3 Keeper)");
		System.out.println("\t4. Extra-Large (16 Animals, 4 Keeper)");
	}
	
	/*
	 * Assign Animal method
	 * Takes a Cage and Animal object as parameters
	 * Checks if Cage is full
	 * Checks if Animal already exists in Cage
	 * Checks Animal is valid species for Cage type
	 * Adds Animal to Cage, sets Cage type (if "None"),
	 * sets Animal CageAssignment
	 * Prints confirmation to user
	 */
	public void assignAnimal(Cage cage, Animal animal) {
		if(cage.cagedAnimals.size() >= cage.getMaxAnimals()) {
			System.err.println("This cage is full");
		} else if(cage.cagedAnimals.contains(animal)){
			System.err.println("This animal is already in this cage");
		} else if(!Validate.validateCageType(cage, animal)) {
			System.err.println("This animal can't go in this cage");
		} else {
			cage.cagedAnimals.add(animal);
			if(cage.getCageType().equals("None")) {
				cage.defineCageType(cage, animal);
			}
			animal.setCageAssignment(cage.getCageId());
			System.out.println(animal.getAnimalName() + " the " + animal.getAnimalSpecies() + " was successfully added to cage " + cage.getCageId());
		}
	}
	
	/*
	 * Define Cage Type method
	 * Takes Cage and Animal object as parameters
	 * Checks if species can share
	 * If they can share, set type to species1 and species2
	 * If not, set type to species
	 */
	public void defineCageType(Cage cage, Animal animal) {
		if(animal.getAnimalSpecies().equals("Zebra") || animal.getAnimalSpecies().equals("Marmoset-Monkey")) {
			cage.setCageType("Zebras and Marmoset Monkeys");
		} else if(animal.getAnimalSpecies().equals("Rabbit") || animal.getAnimalSpecies().equals("Guinea-Pig")) {
			cage.setCageType("Rabbits and Guinea Pigs");
		} else if(animal.getAnimalSpecies().equals("Horse") || animal.getAnimalSpecies().equals("Donkey")) {
			cage.setCageType("Horses and Donkeys");
		} else if(animal.getAnimalSpecies().equals("Bearded-Dragon") || animal.getAnimalSpecies().equals("Lizard")) {
			cage.setCageType("Bearded Dragons and Lizards");
		} else {
			cage.setCageType(animal.getAnimalSpecies() + "s");
		}
	}
	
	/*
	 * Assign Keeper method
	 * Takes a Cage and Keeper object as parameters
	 * Checks if Cage is assigned max Keepers
	 * Checks if Keeper already exists in Cage
	 * Checks if Keeper is assigned max (4) cages
	 * Adds Keeper to Cage, sets Keeper cageAssignment to
	 * Cage ID (for next "None" in cageAssignment ArrayList)
	 * Prints confirmation to user
	 */
	public void assignKeeper(Cage cage, Keeper keeper) {
		if(cage.getCagedKeepers().size() >= cage.getMaxKeepers()) {
			System.err.println("This cage can't be assigned any more keepers");
		} else if(cage.getCagedKeepers().contains(keeper)) {
			System.err.println("This keeper is already assigned to this cage");
		} else if(!keeper.getCageAssignment().contains("None")) {
			System.err.println("This keeper can't be assigned any more cages");
		} else {
			cage.getCagedKeepers().add(keeper);
			for(String i : keeper.getCageAssignment()) {
				if(i.equals("None")) {
					i = cage.getCageId();
				}
			}
			System.out.println(keeper.getFirstName() + " " + keeper.getLastName() + " was successfully assigned to cage " + cage.getCageId());
		}
	}
	
	/*
	 * Unassign Animal method
	 * Takes a Cage and Animal object as parameters
	 * Checks Cage and Animal are not null
	 * Loops through Cage's cagedAnimals LinkedList
	 * If param Animal ID matches an Animal ID in the list, remove
	 * that Animal from list
	 * Set the Animal cageAssignment to "None"
	 * Prints confirmation to user
	 * If CagedAnimals List is empty, set cageType to "None"
	 */
	public void unassignAnimal(Cage cage, Animal animal) {
		if(cage != null && animal != null) {
			for(Animal i : cage.getCagedAnimals()) {
				if(i.getAnimalId().equals(animal.getAnimalId())) {
					cage.getCagedAnimals().remove(i);
					animal.setCageAssignment("None");
					System.out.println(animal.getAnimalName() + " the " + animal.getAnimalSpecies() + " successfully removed from " + cage.getCageId());
					if(cage.getCagedAnimals().isEmpty()) {
						cage.setCageType("None");
					}
				}
			}
		} else {
			System.err.println("Unable to unassign animal");
		}
	}
	
	/*
	 * Unassign Keeper method
	 * Takes a Cage and Keeper object as parameters
	 * Checks Cage and Keeper are not null
	 * Loops through Cage's cagedKeepers LinkedList
	 * If param Keeper ID matches a Keeper ID in the list, remove
	 * that Keeper from list
	 * Set the Keeper cageAssignment (where = Cage ID) to "None"
	 * Prints confirmation to user
	 */
	public void unassignKeeper(Cage cage, Keeper keeper) {
		if(cage != null && keeper != null) {
			for(Keeper i : cage.getCagedKeepers()) {
				if(i.getKeeperId().equals(keeper.getKeeperId())) {
					cage.getCagedKeepers().remove(i);
					System.out.println(keeper.getFirstName() + " " + keeper.getLastName() + " successfully removed from " + cage.getCageId());
					for(String j : keeper.getCageAssignment()) {
						if(j.equals(cage.getCageId())) {
							j = "None";
						}
					}
				}
			}
		} else {
			System.err.println("Unable to assign keeper");
		}
	}

	/*
	 * SETTERS AND GETTERS
	 */
	public String getCageId() {
		return cageId;
	}

	public void setCageId(String cageId) {
		this.cageId = cageId;
	}

	public String getCageSize() {
		return cageSize;
	}

	public void setCageSize(String cageSize) {
		this.cageSize = cageSize;
	}

	public String getCageType() {
		return cageType;
	}

	public void setCageType(String cageType) {
		this.cageType = cageType;
	}

	public int getMaxAnimals() {
		return maxAnimals;
	}

	public void setMaxAnimals(int maxAnimals) {
		this.maxAnimals = maxAnimals;
	}

	public int getMaxKeepers() {
		return maxKeepers;
	}

	public void setMaxKeepers(int maxKeepers) {
		this.maxKeepers = maxKeepers;
	}

	public LinkedList<Animal> getCagedAnimals() {
		return cagedAnimals;
	}

	public void setCagedAnimals(LinkedList<Animal> cagedAnimals) {
		this.cagedAnimals = cagedAnimals;
	}

	public LinkedList<Keeper> getCagedKeepers() {
		return cagedKeepers;
	}

	public void setCagedKeepers(LinkedList<Keeper> cagedKeepers) {
		this.cagedKeepers = cagedKeepers;
	}
}
