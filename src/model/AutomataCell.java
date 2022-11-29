package model;

import java.awt.Point;
import java.util.HashMap;

import javafx.scene.paint.Color;

public class AutomataCell {
	HashMap <String, Color> colorMap = new HashMap<String, Color>();
	String myState;
	Point myPosition;
	
	// I'm changing the constructor to have a String and Point
	public AutomataCell(String state, Point coordinate){
		setState(state);
		myPosition = coordinate;
		setUpColorMap();
	}
	
	private void setUpColorMap() {
		colorMap.put("R", Color.RED);
		colorMap.put("P", Color.WHITE);
		colorMap.put("S", Color.BLUE);
	}
	
	public Color getColor(){
		return colorMap.get(myState);
	}
	
	public Point getCoordinates(){
		return myPosition;
	}
	
	public void setState(String newState) {
		assert(newState.equals("R") || newState.equals("P") || newState.equals("S"));
		myState = newState;
	}
	
	public String getState() {
		return myState;
	}
	
	public String toString() {
		return "("+myPosition.x+","+myPosition.y+")"+myState;
	}
	
	public String stateOnlyString() {
		return myState;
	}
}
