package model;

import java.util.Arrays;

public class Building {
	//Attributes
	private String identifier;
	private int numPeople;
	private int amountFloors;
	private int numOfficesPerFloor;
	@SuppressWarnings("unused")
	private Person [] persons;
	
	
	public Building(String identifier,int numPeople, int amountFloors, int numOfficesPerFloor,
			Person [] other) {
		this.identifier = identifier;
		this.numPeople = numPeople;
		
		//Array to save the people in the building
		persons = new Person[numPeople];
		
		this.amountFloors = amountFloors;
		this.numOfficesPerFloor = numOfficesPerFloor;
		
		
		assingArrayValuesToPersonsArray(other);
		
		
		
	}
	
	public void assingArrayValuesToPersonsArray(Person [] other) {
		for(int i  = 0;i<this.persons.length;i++) {
			this.persons[i] = other[i];
		}
	}


	
	
	
}
