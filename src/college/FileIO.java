package college;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {
	
	/*
	 * VARIABLES - declare all utilities and files to be used
	 */
	private Scanner sc;
	private File animalFile;
	private File keeperFile;
	private File cageFile;
	private File weeklyReportFile;
	private FileReader in;
	private FileWriter write;
	private PrintWriter out;
	
	/*
	 * CONSTRUCTOR - intialise all 4 files
	 */
	public FileIO() {
		this.animalFile = new File("data/animalData.txt");
		this.keeperFile = new File("data/keeperData.txt");
		this.cageFile = new File("data/cageData.txt");
		this.weeklyReportFile = new File("data/weeklyReport.txt");
	}
	
	/*
	 * Write Animal Details method
	 * Takes ArrayList<Animal> as parameter
	 * Initialise FileWriter with the Animal File
	 * Initlaise PrintWriter with FileWriter
	 * Loop through Animal ArrayList and (if != null)
	 * Write all Animal attributes to Animal File
	 * Flush PrintWriter when complete
	 */
	public void writeAnimaDetails(ArrayList<Animal> animalList) {
		try {
			write = new FileWriter(animalFile);
			out = new PrintWriter(write);
			
			for(Animal i : animalList) {
				if(animalList != null) {
					out.write(i.getAnimalId() + "\n");
					out.write(i.getAnimalName() + "\n");
					out.write(i.getAnimalSex() + "\n");
					out.write(i.getAnimalFamily() + "\n");
					out.write(i.getAnimalSpecies() + "\n");
					out.write(i.getCageAssignment() + "\n");
				}
			}
			out.flush();
		} catch(IOException e) {
			System.err.println("Invalid path");
			e.printStackTrace();
		}
	}
	
	/*
	 * Write Keeper Details method
	 * Takes ArrayList<Keeper> as parameter
	 * Initialise FileWriter with the Keeper File
	 * Initlaise PrintWriter with FileWriter
	 * Loop through Keeper ArrayList and (if != null)
	 * Write all Keeper attributes to Keeper File
	 * Another loop is needed to write CageAssignments
	 * Flush PrintWriter when complete
	 */
	public void writeKeeperDetails(ArrayList<Keeper> keeperList) {
		try {
			write = new FileWriter(keeperFile);
			out = new PrintWriter(write);
			
			for(Keeper i : keeperList) {
				if(keeperList != null) {
					out.write(i.getKeeperId() + "\n");
					out.write(i.getFirstName() + "\n");
					out.write(i.getLastName() + "\n");
					for(String j : i.getCageAssignment()) {
						out.write(j + "\n");
					}
				}
			}
			out.flush();
		} catch(IOException e) {
			System.err.println("Invalid path");
			e.printStackTrace();
		}
	}
	
	/*
	 * Write Cage Details method
	 * Takes ArrayList<Cage> as parameter
	 * Initialise FileWriter with the Cage File
	 * Initlaise PrintWriter with FileWriter
	 * Loop through Cage ArrayList and (if != null)
	 * Write all Cage attributes to Cage File
	 * Flush PrintWriter when complete
	 */
	public void writeCageDetails(ArrayList<Cage> cageList) {
		try {
			write = new FileWriter(cageFile);
			out = new PrintWriter(write);
			
			for(Cage i : cageList) {
				if(cageList != null) {
					out.write(i.getCageId() + "\n");
					out.write(i.getCageSize() + "\n");
					out.write(i.getCageType() + "\n");
					out.write(i.getMaxAnimals() + "\n");
					out.write(i.getMaxKeepers() + "\n");
				}
			}
			out.flush();
		} catch(IOException e) {
			System.err.println("Invalid path");
			e.printStackTrace();
		}
	}
	
	/*
	 * Generate Weekly Report method
	 * Takes all three ArrayLists as parameters
	 * Initialise FileWriter with Weekly Report File
	 * Initialise PrintWriter with FileWriter
	 * Create Date objects with LocalDateTime.now();
	 * This will be used to print the current Date (and Week no.) 
	 * at the top of the report
	 * Loop through Cage list and write details for each Cage
	 * Each loop will also loop through Animal and Keeper LinkedLists in 
	 * Cage object and write details for each Animal and Keeper assigned
	 * to that Cage
	 * Loop through main Animal ArrayList and write Animal details for
	 * Animals not assigned to a Cage (cageAssignment = "None")
	 * Loop through main Keeper ArrayList and write Keeper details for
	 * Keepers not assigned their max no. of Cages (cageAssignment.contains("None")
	 * Flush PrintWriter when complete
	 */
	public void generateWeeklyReport(ArrayList<Animal> animalList, ArrayList<Keeper> keeperList, ArrayList<Cage> cageList) {
		try {
			write = new FileWriter(weeklyReportFile);
			out = new PrintWriter(write);
			Object day = LocalDateTime.now().getDayOfWeek();
			Object date = LocalDateTime.now().getDayOfMonth();
			Object month = LocalDateTime.now().getMonth();
			Object year = LocalDateTime.now().getYear();
			Object week = ((LocalDateTime.now().getDayOfYear()) / 7) + 1;
			
			out.write("CLYDE CONSERVATION\n");
			out.write("WEEKLY REPORT\n");
			out.write(day + " " + date + " " + month + " " + year + " (WEEK " + week + ")\n\n");
			for(Cage i : cageList) {
				out.write("CAGE\n");
				out.write("\tCage ID: " + i.getCageId() + "\n");
				out.write("\tCage Size: " + i.getCageSize() + "\n");
				out.write("\tCage Type: " + i.getCageType() + "\n");
				out.write("\tCage Animal Capacity: " + i.getMaxAnimals() + "\n");
				out.write("\tCage Keeper Capacity: " + i.getMaxKeepers() + "\n\n");
				out.write("\tANIMALS\n");
				for(Animal a : i.getCagedAnimals()) {
					out.write("\t\tAnimal ID: " + a.getAnimalId() + "\n");
					out.write("\t\tAnimal Name: " + a.getAnimalName() + "\n");
					out.write("\t\tAnimal Sex: " + a.getAnimalSex() + "\n");
					out.write("\t\tAnimal Family: " + a.getAnimalFamily() + "\n");
					out.write("\t\tAnimal Species: " + a.getAnimalSpecies() + "\n\n");
				}
				out.write("\tKEEPERS\n");
				for(Keeper k : i.getCagedKeepers()) {
					out.write("\t\tKeeper ID: " + k.getKeeperId() + "\n");
					out.write("\t\tKeeper First Name: " + k.getFirstName() + "\n");
					out.write("\t\tKeeper Last Name: " + k.getLastName() + "\n\n");
				}
			}

			out.write("\nANIMALS NOT ASSIGNED TO A CAGE\n\n");
			for(Animal j : animalList) {
				if(j.getCageAssignment().equals("None")) {
					out.write("\tAnimal ID: " + j.getAnimalId() + "\n");
					out.write("\tAnimal Name: " + j.getAnimalName() + "\n");
					out.write("\tAnimal Sex: " + j.getAnimalSex() + "\n");
					out.write("\tAnimal Family: " + j.getAnimalFamily() + "\n");
					out.write("\tAnimal Species: " + j.getAnimalSpecies() + "\n\n");
				}
			}
			out.write("KEEPERS NOT ASSIGNED TO MAX CAGES\n\n");
			for(Keeper x : keeperList) {
				if(x.getCageAssignment().contains("None")) {
					out.write("\tKeeper ID: " + x.getKeeperId() + "\n");
					out.write("\tKeeper First Name: " + x.getFirstName() + "\n");
					out.write("\tKeeper Last Name: " + x.getLastName() + "\n\n");
				}
			}
			out.flush();
		} catch(IOException e) {
			System.err.println("Invalid file");
			e.printStackTrace();
		}		
	}
	
	/*
	 * Read Animal Data method
	 * Takes ArrayList<Animal> as parameter
	 * Initialise FileReader with Animal File
	 * Initialise Scanner with FileReader
	 * Create new Animal Object
	 * Read through Animal File and Scan each line
	 * Set Animal attributes to these inputs
	 * Add Animal to Animal ArrayList
	 */
	public void readAnimalData(ArrayList<Animal> animalList) {
		try {
			in = new FileReader(animalFile);
			sc = new Scanner(in);
			while(sc.hasNextLine()) {
				Animal animal = new Animal();
				animal.setAnimalId(sc.nextLine());
				animal.setAnimalName(sc.nextLine());
				animal.setAnimalSex(sc.nextLine());
				animal.setAnimalFamily(sc.nextLine());
				animal.setAnimalSpecies(sc.nextLine());
				animal.setCageAssignment(sc.nextLine());			
				animalList.add(animal);
			}
		} catch(IOException e) {
			System.err.println("Invalid path");
			e.printStackTrace();
		}
		
	}
	
	/*
	 * Read Keeper Data method
	 * Takes ArrayList<Keeper> as parameter
	 * Initialise FileReader with Keeper File
	 * Initialise Scanner with FileReader
	 * Create new Keeper Object
	 * Read through Keeper File and Scan each line
	 * Set Keeper attributes to these inputs
	 * Add Keeper to Keeper ArrayList
	 */
	public void readKeeperData(ArrayList<Keeper> keeperList) {
		try {
			in = new FileReader(keeperFile);
			sc = new Scanner(in);
			
			while(sc.hasNextLine()) {
				Keeper keeper = new Keeper();
				keeper.setKeeperId(sc.nextLine());
				keeper.setFirstName(sc.nextLine());
				keeper.setLastName(sc.nextLine());
				keeper.getCageAssignment().add(sc.nextLine());
				keeper.getCageAssignment().add(sc.nextLine());
				keeper.getCageAssignment().add(sc.nextLine());
				keeper.getCageAssignment().add(sc.nextLine());
				keeperList.add(keeper);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * Read Cage Data method
	 * Takes ArrayList<Cage> as parameter
	 * Initialise FileReader with Cage File
	 * Initialise Scanner with FileReader
	 * Create new Cage Object
	 * Read through Cage File and Scan each line
	 * Set Cage attributes to these inputs
	 * Add Cage to Cage ArrayList
	 */
	public void readCageData(ArrayList<Cage> cageList) {
		try {
			in = new FileReader(cageFile);
			sc = new Scanner(in);
			
			while(sc.hasNextLine()) {
				Cage cage = new Cage();
				cage.setCageId(sc.nextLine());
				cage.setCageSize(sc.nextLine());
				cage.setCageType(sc.nextLine());
				cage.setMaxAnimals(Integer.parseInt(sc.nextLine()));
				cage.setMaxKeepers(Integer.parseInt(sc.nextLine()));
				cageList.add(cage);
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
