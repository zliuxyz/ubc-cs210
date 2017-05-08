package ca.ubc.cs.cpsc210.mindthegap.model;

import ca.ubc.cs.cpsc210.mindthegap.util.LatLon;

import java.util.*;

/**
 * Represents a station on the underground with an id, name, location (lat/lon)
 * set of lines with stops at this station and a list of arrival boards.
 */
public class Station implements Iterable<ArrivalBoard> {
    private List<ArrivalBoard> arrivalBoards;

    /**
     * Constructs a station with given id, name and location.
     * Set of lines and list of arrival boards are empty.
     *
     * @param id    the id of this station (cannot by null)
     * @param name  name of this station
     * @param locn  location of this station
     */
    public Station(String id, String name, LatLon locn) {
        // stub
    }

    public String getName() {
        return null;   // stub
    }

    public LatLon getLocn() {
        return null;   // stub
    }

    public String getID() {
        return null;   // stub
    }

    public Set<Line> getLines() {
        return null;   // stub
    }

    public int getNumArrivalBoards() {
        return 0;   // stub
    }

    /**
     * Add line to set of lines with stops at this station.
     *
     * @param line  the line to add
     */
    public void addLine(Line line) {
        // stub
    }

    /**
     * Remove line from set of lines with stops at this station
     *
     * @param line the line to remove
     */
    public void removeLine(Line line) {
        // stub
    }

    /**
     * Determine if this station is on a given line
     * @param line  the line
     * @return  true if this station is on given line
     */
    public boolean hasLine(Line line) {
        return false;   // stub
    }

    /**
     * Add train arrival travelling on a particular line in a particular direction to this station.
     * Arrival is added to corresponding arrival board based on the line on which it is
     * operating and the direction of travel (as indicated by platform prefix).  If the arrival
     * board for given line and travel direction does not exist, it is created and added to
     * arrival boards for this station.
     *
     * @param line    line on which train is travelling
     * @param arrival the train arrival to add to station
     */
    public void addArrival(Line line, Arrival arrival) {
        // stub
    }

    /**
     * Remove all arrival boards from this station
     */
    public void clearArrivalBoards() {
        // stub
    }

    /**
     * Two stations are equal if their ids are equal
     */
    @Override
    public boolean equals(Object o) {
        return false;   // stub
    }

    /**
     * Two stations are equal if their ids are equal
     */
    @Override
    public int hashCode() {
        return 0;   // stub
    }

    @Override
    public Iterator<ArrivalBoard> iterator() {
        // Do not modify the implementation of this method!
        return arrivalBoards.iterator();
    }
}
