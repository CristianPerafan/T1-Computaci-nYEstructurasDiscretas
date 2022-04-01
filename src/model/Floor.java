package model;

import java.util.Hashtable;

public class Floor {
	//Attributes
	
	@SuppressWarnings("unused")
	private Hashtable<Integer,Person> tableOffice;
	
	private Person[] peopleAtFloor;
	
	public Floor(int numOffices, Person [] people) {
		peopleAtFloor = new Person[numOffices];
		tableOffice = new Hashtable<Integer,Person>();
		toSaveValuesPeopleAtFloor(people);
	}
	
	public void toSaveValuesPeopleAtFloor(Person [] people) {
		for (int i = 0; i < peopleAtFloor.length; i++) {
			peopleAtFloor[i] = people[i];
		}
	}
}
