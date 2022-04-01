package model;

public class Person {
	//Attributes
	@SuppressWarnings("unused")
	private String name;
	private int floorPersonIs;
	@SuppressWarnings("unused")
	private int floorPersonGoes;
	
	public Person(String name, int floorPersonIs, int floorPersonGoes) {
		this.name = name;
		this.floorPersonIs = floorPersonIs;
		this.floorPersonGoes = floorPersonGoes;
	}
	
	public int getFloorPersonIs() {
		return floorPersonIs;
		
	}
	
	
	
}
