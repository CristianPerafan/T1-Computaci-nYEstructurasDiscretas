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
	
	public void ToShowBuildingInformation() {
		
	}

}
