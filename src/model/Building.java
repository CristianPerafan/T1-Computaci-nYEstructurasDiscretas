package model;

import java.util.Hashtable;
import java.util.PriorityQueue;
import java.util.Queue;

public class Building {
	//Attributes
	private String identifier;
	private int numPeople;
	private int amountFloors;
	private int numOfficesPerFloor;
	@SuppressWarnings({"unused" })
	private Hashtable<Integer,Floor> tableOffice; 
	
	private Floor [] floors;
	
	private Queue<Person> people;
	
	
	
	
	public Building(String identifier,int numPeople, int amountFloors, int numOfficesPerFloor,
			Person [] other) {
		
		this.identifier = identifier;
		this.numPeople = numPeople;
		
		
		tableOffice = new Hashtable<Integer, Floor>();
		
		this.amountFloors = amountFloors;
		this.numOfficesPerFloor = numOfficesPerFloor;
		
		people = new PriorityQueue<>();
		
		floors = new Floor[amountFloors];
		
		toSavePeopleAtPriorityQueue(other);
	
	}
	
	
	public void toSavePeopleAtPriorityQueue(Person [] p) {
		for(int i = 0;i<p.length;i++) {
			people.add(p[i]);
		}
	}
	
	public String toShowBuildingInformation() {
		String out = "";
		out += "Building "+identifier+" information\n";
		out += "Num people "+numPeople+"\n";
		out += "Amount floors"+amountFloors+"\n";
		out += "Num offices per floor"+numOfficesPerFloor+"\n";
		
		while(!people.isEmpty()) {
			Person b = people.remove();
			out += "name: "+b.getName()+" Floor: "+b.getFloorPersonIs()+" Office"+b.getOfficesPersonGoes()+"\n";
		}
		
		return out;
		
	}
	
	//
	// === GETTERS AND SETTERS
	//
	public String getIdentifier() {
		return identifier;
	}
	
	

	

	
	
}
