package model;

import java.util.Hashtable;

public class Floor {
	//Attributes
	@SuppressWarnings("unused")
	private int numOfficesAvailable;
	private Hashtable<Integer,Person> peopleInOffice;
	private int [] identifierOffices;
	
	
	public Floor(int numOffices) {
		this.numOfficesAvailable = numOffices;
		peopleInOffice = new Hashtable<Integer,Person>();
		identifierOffices = new int[numOffices];
	}
	
	public int [] getIdentifierOffices() {
		return identifierOffices;
	}
	
	public boolean getOfficesAvailable(int key) {
		boolean out = false;
		
		if(peopleInOffice.get(key) == null) {
			out = true;
		}
		
		
		return out;
	}
	
	public Person getPersonInAOffice(int key) {
		Person out = peopleInOffice.get(key);
		return out;
	}
	
	
	
	public void toAddPersonToHashTable(Integer key,Person p) {
		peopleInOffice.put(key, p);
	}
	
	public void setNumOfficesAvailable() {
		numOfficesAvailable--;
	}
	
	
	public void toSaveOfficesIdentifiers(int [] identifiers) {
		for(int i = 0;i<identifierOffices.length;i++) {
			identifierOffices[i] = identifiers[i];
		}
	}
}
