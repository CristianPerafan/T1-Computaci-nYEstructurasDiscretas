package model;

public class Person implements Comparable<Person>{
	//Attributes
	private String name;
	private int floorPersonIs;
	private int OfficePersonGoes;
	private int indexElevator;
	
	public Person(String name, int floorPersonIs, int floorPersonGoes) {
		this.name = name;
		this.floorPersonIs = floorPersonIs;
		this.OfficePersonGoes = floorPersonGoes;
		indexElevator = 0;
	}
	
	public void setIndexElevator(int indexElevator) {
		this.indexElevator = indexElevator;
	}
	
	public int getIndexElevator() {
		return indexElevator;
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
	
	public String toString() {
		String out = "";
		out += "Name: "+name+"\n";
		out += "Floor: "+floorPersonIs+"\n";
		out += "Destination office: "+OfficePersonGoes+"\n";
		out += "Index: "+indexElevator+"\n";
		return out;
	}

	@Override
	public int compareTo(Person o) {
		int out = 0;
		if(o.getIndexElevator()>this.getIndexElevator()) {
			out = 1;
		}
		else {
			out = -1;
		}
		
		return out;
	}
	
	
}
