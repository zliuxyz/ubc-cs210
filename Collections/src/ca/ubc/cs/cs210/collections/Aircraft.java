package ca.ubc.cs.cs210.collections;

import java.util.Objects;

/**
 * Represents an aircraft servicing a route from origin
 * to destination.   Aircraft has a tail number that is
 * immutable.
 */
public class Aircraft {
	private String tailNumber;
	private String origin;
	private String destination;

    /**
     * Constructs aircraft with given tail number
     *
     * @param tailNumber  the tail number
     */
	public Aircraft(String tailNumber) {
		this.tailNumber = tailNumber;
		origin = null;
		destination = null;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTailNumber() {
		return tailNumber;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Aircraft aircraft = (Aircraft) o;

		if (tailNumber != null ? !tailNumber.equals(aircraft.tailNumber) : aircraft.tailNumber != null) return false;
		if (origin != null ? !origin.equals(aircraft.origin) : aircraft.origin != null) return false;
		return !(destination != null ? !destination.equals(aircraft.destination) : aircraft.destination != null);

	}

	@Override
	public int hashCode() {
		int result = tailNumber != null ? tailNumber.hashCode() : 0;
		result = 31 * result + (origin != null ? origin.hashCode() : 0);
		result = 31 * result + (destination != null ? destination.hashCode() : 0);
		return result;
	}
}
