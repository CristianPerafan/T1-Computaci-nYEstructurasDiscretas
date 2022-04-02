package model;

public class Person implements Comparable<Person>{
	//Attributes
	private String name;
	private int floorPersonIs;
	private int OfficePersonGoes;
	
	public Person(String name, int floorPersonIs, int floorPersonGoes) {
		this.name = name;
		this.floorPersonIs = floorPersonIs;
		this.OfficePersonGoes = floorPersonGoes;
	}
	
	
	
	public String getName() {
		return name;
	}
	
	public int getFloorPersonIs() {
		return floorPersonIs;
	}

	public int getOfficesPersonGoes() {
		return OfficePersonGoes;
	}




	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
