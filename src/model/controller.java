package model;

import java.util.ArrayList;

public class Controller {
	
	//Attributes
	private ArrayList <Building> buildings;
	
	public Controller() {
		buildings = new ArrayList<Building>();
	}
	
	public void addABuildingToAList(Building obj) {
		buildings.add(obj);
	}
	
	
	public String toOrderPeopleInElevator() {
		String out = "";
		
		for(int i = 0;i<buildings.size();i++) {
			out += " \n";
			out += "///ELEVATOR PEOPLE ENTER INFORMATION "+
					buildings.get(i).getIdentifier()+" BUILDING///\n";
			
			out += buildings.get(i).toOrderPeopleInElevator()+"\n";
			out += " \n";
		}
		
		return out;
		
	}
	
	public String toPutPeopleAtOffices() {
		String out = "";
		for(int i = 0;i<buildings.size();i++) {
			out += "\n";
			out += "///ELEVATOR PEOPLE EXIT INFORMATION "+
					buildings.get(i).getIdentifier()+" BUILDING///\n";
			out += buildings.get(i).toAssignPeopleToOffices();
			out += " \n";
		}
		return out;
	}
	
	
	public String ToShowBuildingInformation(String identifier) {
		String out = "";
		boolean stop = false;
		for(int i = 0;i<buildings.size() && !stop;i++) {
			if(buildings.get(i).getIdentifier().equals(identifier)) {
				out = buildings.get(i).toShowBuildingInformation();
				stop = true;
			}
		}
		
		if(out.equals("")) {
			out = "The building does not exist";
		}
		
		return out;
	}
	
	public boolean validateIdentifier(String id) {
		boolean out = false;
		boolean stop = false;
		for(int i = 0;i<buildings.size() && !stop;i++) {
			if(buildings.get(i).getIdentifier().equals(id)) {
				out = true;
				stop = true;
			}
		}
		return out;
	}
	
	
	public boolean validateNumOffices(int num,String id) {
		boolean out = false;
		boolean stop = false;
		for(int i = 0;i<buildings.size() && !stop;i++) {
			if(buildings.get(i).getIdentifier().equals(id)) {
				out = buildings.get(i).validateNumExists(num);
				stop = true;
			}
		}
		return out;
	}
	
	public String consultPersonInAOffice(String id,int num) {
		String out = "";
		boolean stop = false;
		
		for(int i = 0;i<buildings.size() && !stop;i++) {
			if(buildings.get(i).getIdentifier().equals(id)) {
				out = buildings.get(i).consultInformationOfThePerson(num);
				stop = true;
			}
		}
		
		return out;
		
		
	}
	
	
	

}