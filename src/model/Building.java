package model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;


public class Building {
	//Attributes
	private String identifier;
	private int numPeople;
	private int amountFloors;
	private int totalOffices;
	private int numOfficesPerFloor; 
	private Floor [] floors;
	private Person[] arrayPeople;
	private Stack<Person> people;
	
	private ArrayList<Person> peopleOutBuilding;
	private ArrayList<Person> peopleInBuilding;
	
	
	public Building(String identifier,int numPeople, int amountFloors, int numOfficesPerFloor,
			Person [] other) {
		
		this.identifier = identifier;
		this.numPeople = numPeople;
		
		this.amountFloors = amountFloors;
		this.numOfficesPerFloor = numOfficesPerFloor;
		
		people = new Stack<>();
		
		arrayPeople = new Person[numPeople];
		
		floors = new Floor[amountFloors];
		 toSaveTheFloorInformation();
		toSaveArrayPeopleToValue(other);
		
		peopleOutBuilding = new ArrayList<>();
		
		peopleInBuilding = new ArrayList<>();
		
		totalOffices = amountFloors*numOfficesPerFloor;
		
	}
	
	public String toOrderPeopleInElevator() {
		String out = "";
		out = toOrderArrayOfPeople();
		
		return out;
	}
	
	
	public void toSaveArrayPeopleToValue(Person[] other) {
		for(int i = 0;i<other.length;i++) {
			arrayPeople[i] = other[i];
		}
	}
	public void toSavePeopleAtPriorityQueue() {
		for(int i = 0;i<arrayPeople.length;i++ ) {
			people.add(arrayPeople[i]);
		}
	}
	
	public String toShowBuildingInformation() {
		String out = "";
		out += "*** Building "+identifier+" information ***\n";
		out += "\n";
		out += "Amount of people: "+numPeople+".\n";
		out += "Amount of  floors: "+amountFloors+".\n";
		out += "Amount of offices per floor:"+numOfficesPerFloor+".\n";
		out += "\n";
		for(int i = 0;i<arrayPeople.length;i++) {
			out += arrayPeople[i].toString()+"\n";
			out += " \n";
		}
		
		return out;	
	}
	
	//
	// === GETTERS AND SETTERS
	//
	public String getIdentifier() {
		return identifier;
	}
	
	
	public String toOrderArrayOfPeople() {
		String out = "";
		Queue<Integer> aux = new ArrayDeque<>();
		
		
		int index = 1;
		
		out += "***The elevator is in the 1 floor***\n";
		
		arrayPeople[0].setIndexElevator(index);
		index++;
		
		out += "The elevator picks up "+arrayPeople[0].getName()+"\n";
		
		boolean stop = false;
		
		int posElevator = 1;
		
		for(int i = 0;i<arrayPeople.length;i++) {
			if(i == 0) {	
				posElevator = arrayPeople[i].getFloorPersonIs();
			}
			
			for(int j = i+1;j<arrayPeople.length && !stop;j++) {
				if(arrayPeople[j].getFloorPersonIs()>=posElevator) {
					arrayPeople[j].setIndexElevator(index);
					index++;
					posElevator = arrayPeople[j].getFloorPersonIs();
					out += "***The elevator is in the "+arrayPeople[j].getFloorPersonIs()+" floor***\n";
					out += "The elevator picks up "+arrayPeople[j].getName()+"\n";
					//stopFor = true;
					i = j-1;
				}
				else {
					aux.add(j);
				}
			}
		}
		
		for(int i = 0;i<aux.size();i++) {
			int indice = 0;
			
			if(!aux.isEmpty()) {
				indice = aux.poll();
			}
			
			for(int j = 0;j<arrayPeople.length;j++) {
				if(j == indice) {
					arrayPeople[j].setIndexElevator(index);
					index++;
					out += "***The elevator is in the "+arrayPeople[j].getFloorPersonIs()+" floor***\n";
					out += "The elevator picks up "+arrayPeople[j].getName()+"\n";
				}
			}
			
		}
		
		toSavePeopleAtPriorityQueue();
		return out;
	}
	
	public String toAssignPeopleToOffices() {
		String out = "";
		
		
		while(!people.isEmpty()) {
			Person aux = people.pop();
			int destinationOffice =  aux.getOfficesPersonGoes();
			
			boolean stop = false;
			for(int i = 0;i<floors.length && !stop;i++) {
				int [] identifier = floors[i].getIdentifierOffices();
				@SuppressWarnings("unused")
				boolean stopF = false;
				for(int j = 0;j<identifier.length && !stop;j++) {
					if(identifier[j] == destinationOffice) {

						if(floors[i].getOfficesAvailable(destinationOffice)) {
							floors[i].toAddPersonToHashTable(destinationOffice, aux);
							out += aux.getName()+" enters de office "+ destinationOffice+" \n";
							peopleInBuilding.add(aux);
						}
						else {
							peopleOutBuilding.add(aux);
							out += aux.getName()+" can not get into the office\n";
						}
						stopF = true;
						stop = true;
					}
				}
			}
			
		}
		
		out += " \n";
		out += "***FINAL STATE "+identifier+" BUILDING***2\n";
		out += "People in the building:\n";
		out += "[";
		
		if(peopleInBuilding.size()>1) {
			for(int i = 0;i<peopleInBuilding.size();i++) {
				
				if(i!=peopleInBuilding.size()-1) {
					out += peopleInBuilding.get(i).getName()+",";
				}
				else {
					out += peopleInBuilding.get(i).getName()+" ]\n";
				}
			}
		}
		else {
			out += "]\n";
		}
		
		
		
		out += "People out of the building:\n";
		out += "[";
		
		if(peopleOutBuilding.size()>1) {
			for(int i = 0;i<peopleOutBuilding.size();i++) {
				if(i!=peopleOutBuilding.size()-1) {
					out += peopleOutBuilding.get(i).getName()+",";
				}
				else {
					out += peopleOutBuilding.get(i).getName()+" ]";
				}
			}
		}
		else {
			out += "]\n";
		}
	
		
		return out;
	}
	
	public void toSaveTheFloorInformation() {
		int id = 1;
		
		for(int i = 0;i<floors.length;i++) {
			floors[i] = new Floor(numOfficesPerFloor);
			
			
			int [] identifier = new int[numOfficesPerFloor];
			
			for(int j = 0;j<identifier.length;j++) {
				identifier[j] = id;
				id++;
			}
			
			floors[i].toSaveOfficesIdentifiers(identifier);
			
		}
	}
	
	public boolean validateNumExists(int num) {
		boolean out = false;
		
		if(num>0) {
			if(num<=totalOffices) {
				out = true;
			}
		}
		return out;
	}
	
	public String consultInformationOfThePerson(int num) {
		String out = "";
		int numFloor = consultNumOfFloorPersonIs(num);
		
		Person p = floors[numFloor].getPersonInAOffice(num);
		
		if(p == null) {
			out = "There is no one in the office!!";
		}
		else {
			out = p.getName()+" is in the office number "+num;
		}
		
		
		return out;
	}
	
	public int consultNumOfFloorPersonIs(int num) {
		int out = 0;
		boolean stopi = false;
		boolean stopj = false;
		for(int i = 0;i<floors.length && !stopi;i++) {
			int [] idFloors = new int[numOfficesPerFloor];
			idFloors = floors[i].getIdentifierOffices();
			for(int j = 0;j<idFloors.length && !stopj;j++) {
				if(idFloors[j] == num) {
					out = i;
					stopi = true;
					stopj = true;
				}
			}
		}
		return out;
	}
	
}