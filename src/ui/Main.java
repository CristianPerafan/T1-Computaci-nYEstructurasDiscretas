package ui;

import java.util.Scanner;

import model.Building;
import model.Controller;
import model.Person;

public class Main {
	
	//Attributes
	private Scanner sc;
	@SuppressWarnings("unused")
	private Controller controller;

	public Main() {
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
	
	public int showMenu() {
		
		System.out.println("*** MENU ***\n"+
				"(1) Enter data to simulate the operation of the building\n"+
				"(0) Exit");
		
		int option = sc.nextInt();
		sc.nextLine();
		return option;
		
	}
	
	public void executeOperation(int option) {
		switch(option) {
		case 0:
			System.out.println("Bye, see you soon");
			break;
		case 1:
			readSimulationInformation();
			break;
		}
	}
	
	public void readSimulationInformation() {
		System.out.println("*** SIMULATION INFORMATION ***\n"+
				"Enter simulation data");
		
		int numberOfBuildings = sc.nextInt();
		sc.nextLine();
		
		
		for (int i = 0; i < numberOfBuildings; i++) {
			
			String buildingInformation = sc.nextLine();
			
			String [] separetedBuildingInformation = buildingInformation.split(" ");
			
			String identifier = separetedBuildingInformation[0];
			
			int numPeople = Integer.valueOf(separetedBuildingInformation[1]);
			
			
			//Auxiliary array to save the people information at the building
			@SuppressWarnings("unused")
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
			System.out.println(obj.toString());
			
			controller.addABuildingToAList(obj);
		
			
			
			
		}
		
	}
	
	

}
