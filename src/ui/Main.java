package ui;

import java.util.Scanner;

import model.Building;
import model.Controller;
import model.Person;

public class Main {
	//Attributes
	private Scanner sc;
	private Controller controller;
	private boolean informationRegistered;
	private boolean simulationPerformed;

	public Main() {
		informationRegistered = false;
		simulationPerformed = false;
		sc = new Scanner(System.in);
		controller = new Controller();
	}
	
	public static void main(String [] args ) {
		Main pc = new Main();
		
		System.out.println("Starting the APP...");
		int option = 0;
		do {
			
			option = pc.showMenu();
			pc.executeOperation(option);
		}while(option != 0);
	}
	
	public void executeOperationSimulationMenu(int option) {
		switch(option){
		case 0:
			showMenu();
			break;
		case 1:
			toShowBuildingInformation();
			break;
		case 2:
			startSimulation();
			break;
		case 3:
			if(simulationPerformed == true) {
				consultPersonInsideAnOffice();
			}
			else {
				System.out.println("To perform the query you must start the simulation!!!");
				System.out.println("----> (2) Star simulation");
				
			}

			break;
		}
	}

	
	
	public int showMenu() {
		
		System.out.println("*** MENU ***\n"+
				"(1) Enter data to simulate the operation of the building\n"+
				"(2) Simulation\n"+
				"(0) Exit");
		
		int option = sc.nextInt();
		sc.nextLine();
		return option;
		
	}
	
	public void ShowSimulationMenu() {
		System.out.println("*** SIMULATION MENU ***\n"+
						"(1) Find the information of a building\n"+
						"(2) Start simulation\n"+
						"(3) Consult person inside an office\n"+
						"(0) Exit");
		
		int option = sc.nextInt();
		sc.nextLine();
		executeOperationSimulationMenu(option);
	}
	
	public void executeOperation(int option) {
		switch(option) {
		case 0:
			System.out.println("Bye, see you soon");
			break;
		case 1:
			readSimulationInformation();
			break;
		case 2:
			if(informationRegistered == true) {
				ShowSimulationMenu();
			}
			else {
				System.out.println("You must first register the information of the simulation!!");
			}
			
			break;
		default:
			System.out.println("No valid option!!!");
			break;
		}
	}
	
	public void readSimulationInformation() {
		System.out.println("*** SIMULATION INFORMATION ***\n"+
				"Enter simulation data: ");
		
		if(informationRegistered == true) {
			System.out.println("Do you want to overwrite the simulation information? YES or NOT");
			
			String answer = sc.nextLine().toUpperCase();
			
			if(answer.equals("YES")) {
				toEnterDataSimulation();
			}
			else if(answer.equals("NOT")) {
				showMenu();
			}
			else {
				System.out.println("No valid option!!");
			}
		}
		else {
			toEnterDataSimulation();
		}
		

		
	}
	
	public void toEnterDataSimulation() {
		int numberOfBuildings = sc.nextInt();
		sc.nextLine();
		
		
		for (int i = 0; i < numberOfBuildings; i++) {
			
			String buildingInformation = sc.nextLine();
			
			String [] separetedBuildingInformation = buildingInformation.split(" ");
			
			String identifier = separetedBuildingInformation[0];
			
			int numPeople = Integer.valueOf(separetedBuildingInformation[1]);
			
			
			//Auxiliary array to save the people information at the building
			Person [] peopleAtBuilding = new Person[numPeople];
			
			
			int amountFloors = Integer.valueOf(separetedBuildingInformation[2]);
			
			int numOfficesPerFloor = Integer.valueOf(separetedBuildingInformation[3]);
			
			for(int j = 0;j<numPeople;j++) {
				
				String personInformation = sc.nextLine();
				
				String [] separatedPersonInformation = personInformation.split(" ");
				
				String name = separatedPersonInformation[0];
				
				int floorPersonIs = Integer.valueOf(separatedPersonInformation[1]);
				
				int floorPersonGoes = Integer.valueOf(separatedPersonInformation[2]);
				
				peopleAtBuilding[j] = new Person(name,floorPersonIs,floorPersonGoes);
				
			}
			
			
			
			//To create a new object(Building)
			Building obj = new Building(identifier,numPeople,amountFloors,numOfficesPerFloor,peopleAtBuilding);
			
			controller.addABuildingToAList(obj);
		
			informationRegistered = true;
			
		}
	}
	
	
	public void toShowBuildingInformation() {
		System.out.println("Enter the building identifier");
		String identifier = sc.nextLine();
		System.out.println(controller.ToShowBuildingInformation(identifier));
	}
	
	public void startSimulation() {
		System.out.println("==== Entrance of people to the elevator ====");
		System.out.println(controller.toOrderPeopleInElevator());
		System.out.println(" ");
		System.out.println("==== Exit of people from the elevator ====");
		System.out.println(controller.toPutPeopleAtOffices());
		
		simulationPerformed = true;
	}
	
	public void consultPersonInsideAnOffice() {
		System.out.println("***CONSULT MENU***");
		System.out.println("Enter the identifier of the building in which you want to make the query:");
		String identifier = sc.nextLine();
		if(controller.validateIdentifier(identifier)) {
			System.out.println("Enter the number of office:");
			int numOffice = sc.nextInt();
			sc.nextLine();
			
			if(controller.validateNumOffices(numOffice, identifier)) {
				System.out.println(controller.consultPersonInAOffice(identifier,numOffice));
			}
			else {
				System.out.println("The office number does not correspond to an office in the building "+identifier+"!!!");
			}
		}
		else {
			System.out.println("The identifier does not correspond to any building in the system!!!");
		}
		
		
	}
	
	
	

}
