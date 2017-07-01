package ca.ubc.cpsc210.trafficlightrobust.model;

import ca.ubc.cpsc210.trafficlightrobust.model.exceptions.ColourException;
import ca.ubc.cpsc210.trafficlightrobust.model.exceptions.SequenceException;
import ca.ubc.cpsc210.trafficlightrobust.model.exceptions.TrafficLightException;

/*
 * Model a two-light intersection.
 * 
 * @author Gail Murphy
 */

public class Intersection {

	// The two traffic lights.
	private TrafficLight northSouthLight;
	private TrafficLight eastWestLight;

	/*
	 * Constructor
	 */
	public Intersection() {
		northSouthLight = new TrafficLight();
		eastWestLight = new TrafficLight();
	}

	/*
	 * Reset the intersection to a safe state
	 * MODIFIES: this
	 * EFFECTS: NS and EW lights are red
	 */
	public void reset() {
		northSouthLight.reset();
		eastWestLight.reset();
	}

	/*
	 * Retrieve the north-south light colour
	 * EFFECTS: returns colour of NS light
	 */
	public String getNorthSouthLightColour() {
		return northSouthLight.getColour();
	}

	/*
	 * Retrieve the east-west light colour
	 * EFFECTS: returns colour of EW light
	 */
	public String getEastWestLightColour() {
		return eastWestLight.getColour();
	}

	/* 
	 * Set the north-south light colour to the given colour. 
	 * MODIFIES: this
	 * EFFECTS: if colour is not one of "red", "green" or "yellow"
	 * 			throws ColourException
	 *          otherwise if colour is out of sequence 
	 *          throws SequenceException
	 *          otherwise NS light colour is set to given colour 
	 *          and colour of EW light is changed accordingly
	 */
	public void setNorthSouthLightColour(String colour) 
			throws ColourException, SequenceException {
		
		northSouthLight.setColour(colour);
		
		try {
			if (colour.equals("red"))
				eastWestLight.setColour("green");
			else if (colour.equals("yellow"))
				eastWestLight.setColour("red");
			else if (colour.equals("green"))
				eastWestLight.setColour("red");
		} catch (TrafficLightException e) {
			// undo change made to north-south light
			northSouthLight.advance();
			northSouthLight.advance();
			throw new SequenceException(colour);
		}
	}

	/*
	 * Set the east-west light colour to the given colour. 
	 * MODIFIES: this
	 * EFFECTS:  if colour is not one of "red", "green" or "yellow"
	 * 			 throws ColourException
	 *           otherwise if colour is out of sequence 
	 *           throws SequenceException
	 *           otherwise EW light colour is set to given colour 
	 *           and colour of NS light is changed accordingly
	 */
	public void setEastWestLightColour(String colour) 
			throws ColourException, SequenceException {
		
		eastWestLight.setColour(colour);
		
		try {
			if (colour.equals("red"))
				northSouthLight.setColour("green");
			else if (colour.equals("yellow"))
				northSouthLight.setColour("red");
			else if (colour.equals("green"))
				northSouthLight.setColour("red");
		} catch (TrafficLightException e) {
			// undo change made to east-west traffic light
			eastWestLight.advance();
			eastWestLight.advance();
			throw new SequenceException(colour);
		}
	}

	/*
	 * Advance the lights in the intersection.
	 * MODIFIES: this
	 * EFFECTS: advances lights in intersection to 
	 * next state
	 */
	public void advanceLights()  {
		if (northSouthLight.getColour().equals("red") 
				&& eastWestLight.getColour().equals("red")) {
			// system has been reset so pick one to advance
			northSouthLight.advance();
		} else if (northSouthLight.getColour().equals("red")
				&& eastWestLight.getColour().equals("yellow")) {
			eastWestLight.advance();
			northSouthLight.advance();
		} else if (northSouthLight.getColour().equals("red")
				&& eastWestLight.getColour().equals("green")) {
			eastWestLight.advance();
		} else if (northSouthLight.getColour().equals("yellow") 
				&& eastWestLight.getColour().equals("red")) {
			eastWestLight.advance();
			northSouthLight.advance();
		} else if (northSouthLight.getColour().equals("yellow")
				&& eastWestLight.getColour().equals("yellow"))
			reset(); 
		else if ( northSouthLight.getColour().equals("yellow")
				&& eastWestLight.getColour().equals("green") ) {
			northSouthLight.advance();
		} else if ( northSouthLight.getColour().equals("green") 
				&& eastWestLight.getColour().equals("red") ) {
			northSouthLight.advance();
		} else if ( northSouthLight.getColour().equals("green")
				&& eastWestLight.getColour().equals("yellow") ) {
			eastWestLight.advance();
		} else if ( northSouthLight.getColour().equals("green") 
				&& eastWestLight.getColour().equals("green") ) {
			reset(); 
		}
	}
}
