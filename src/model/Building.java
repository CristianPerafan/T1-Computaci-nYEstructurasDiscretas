package model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Queue;
import java.util.Stack;


public class Building {
	//Attributes
	private String identifier;
	private int numPeople;
	private int amountFloors;
	private int numOfficesPerFloor;
	@SuppressWarnings({"unused" })
	private Hashtable<Integer,Floor> tableOffice; 
	private Floor [] floors;
	private Person[] arrayPeople;
	private Stack<Person> people;
	
	private ArrayList<Person> peopleOutBuilding;
	
	
	public Building(String identifier,int numPeople, int amountFloors, int numOfficesPerFloor,
			Person [] other) {
		
		this.identifier = identifier;
		this.numPeople = numPeople;
		
		
		tableOffice = new Hashtable<Integer, Floor>();
		
		this.amountFloors = amountFloors;
		this.numOfficesPerFloor = numOfficesPerFloor;
		
		people = new Stack<>();
		
		arrayPeople = new Person[numPeople];
		
		floors = new Floor[amountFloors];
		 toSaveTheFloorInformation();
		toSaveArrayPeopleToValue(other);
		
		peopleOutBuilding = new ArrayList<>();
		
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
			out += aux.toString()+"\n";
			
			int destinationOffice =  aux.getOfficesPersonGoes();
			
			boolean stop = false;
			for(int i = 0;i<floors.length && !stop;i++) {
				int [] identifier = floors[i].getIdentifierOffices();
				
				for(int j = 0;j<identifier.length;j++) {
					if(identifier[j] == destinationOffice) {
						stop = true;
					}
				}
			}
			
		}
		return out;
	}
	
	public void toSaveTheFloorInformation() {
		for(int i = 0;i<floors.length;i++) {
			floors[i] = new Floor(numOfficesPerFloor);
			
			int id = 1;
			int [] identifier = new int[numOfficesPerFloor];
			
			for(int j = 0;j<identifier.length;j++) {
				identifier[i] = id;
				id++;
			}
			
			floors[i].toSaveOfficesIdentifiers(identifier);
			
		}
	}
	
}