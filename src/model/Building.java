package model;

import java.util.Hashtable;

public class Building {
	//Attributes
	@SuppressWarnings("unused")
	private String identifier;
	@SuppressWarnings("unused")
	private int numPeople;
	@SuppressWarnings("unused")
	private int amountFloors;
	@SuppressWarnings("unused")
	private int numOfficesPerFloor;
	@SuppressWarnings({ "unused" })
	private Hashtable<Integer,Floor> tableOffice; 
	
	@SuppressWarnings("unused")
	private Floor [] floors;
	
	
	
	
	public Building(String identifier,int numPeople, int amountFloors, int numOfficesPerFloor,
			Person [] other) {
		
		this.identifier = identifier;
		this.numPeople = numPeople;
		
		
		tableOffice = new Hashtable<Integer, Floor>();
		
		this.amountFloors = amountFloors;
		this.numOfficesPerFloor = numOfficesPerFloor;
		
		floors = new Floor[amountFloors];
		

		
		toCreateFloors(floors,numOfficesPerFloor,other);
		toSaveOfficesAtHashTable(floors);
	}
	
	public void toCreateFloors(Floor[] array, int numOfficesPerFloor, Person [] people) {
		
		Person [] aux = null;
		
		for(int i = 0;i<array.length;i++) {
			for(int k = 0;k<2;k++) {
				int count = 1;
				if(k == 0) {
					for(int j = 0;j<people.length;j++) {
					
						if(people[j].getFloorPersonIs() == (i+1)) {
							count++;
						}
					}
					
					aux = new Person[count];
					
				}
				else {
					
					for(int j = 0;j<aux.length;j++) {
						if(people[j].getFloorPersonIs() == (i+1)) {
							aux[j] = people[j];
						}
					}
				}
				
				
			}
		
			floors[i] = new Floor(numOfficesPerFloor,aux);
		}
	}
	
	
	public void toSaveOfficesAtHashTable(Floor[] array) {
		for(int i = 0;i<array.length;i++) {
			tableOffice.put(i+1,array[i]);
		}
	}
	

	
	
}
