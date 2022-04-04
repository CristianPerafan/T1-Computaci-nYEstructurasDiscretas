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
			out += buildings.get(i).toOrderPeopleInElevator()+"\n";
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
	
	

}