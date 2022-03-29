package ui;

import java.util.Scanner;

public class Main {
	
	//Attributes
	private Scanner sc;

	public Main() {
		sc = new Scanner(System.in);
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
		
		
		
	}
	
	

}
