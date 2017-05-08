package ca.ubc.cs.cpsc210.mindthegap.model;

import ca.ubc.cs.cpsc210.mindthegap.util.LatLon;


import java.util.*;

/**
 * Represents a station on the underground with an id, name, location (lat/lon)
 * set of lines with stops at this station and a list of arrival boards.
 */
public class Station implements Iterable<ArrivalBoard> {
    private List<ArrivalBoard> arrivalBoards;
    private Set<Line> lines;
    private LatLon latLon;
    private String id;
    private String name;

    /**
     * Constructs a station with given id, name and location.
     * Set of lines and list of arrival boards are empty.
     *
     * @param id    the id of this station (cannot by null)
     * @param name  name of this station
     * @param locn  location of this station
     */
    public Station(String id, String name, LatLon locn) {
        this.id = id;
        this.name = name;
        this.latLon = locn;
        this.arrivalBoards = new ArrayList<ArrivalBoard>();
        this.lines = new HashSet<Line>();
    }

    public String getName() {
        return this.name;
    }

    public LatLon getLocn() {
        return this.latLon;
    }

    public String getID() {
        return this.id;
    }

    public Set<Line> getLines() {
        return this.lines;
    }

    public int getNumArrivalBoards() {
        return this.arrivalBoards.size();
    }

    /**
     * Add line to set of lines with stops at this station.
     *
     * @param line  the line to add
     */
    public void addLine(Line line) {
        this.lines.add(line);
        line.addStation(this);
    }

    /**
     * Remove line from set of lines with stops at this station
     *
     * @param line the line to remove
     */
    public void removeLine(Line line) {
        line.removeStation(this);
        this.lines.remove(line);

    }

    /**
     * Determine if this station is on a given line
     * @param line  the line
     * @return  true if this station is on given line
     */
    public boolean hasLine(Line line) {
        for (Line l: lines) {
            if (l.equals(line)) {
                return true;
            }
        }
        return false;
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

        String direction = arrival.getTravelDirn();

        for (ArrivalBoard arrivalBoard: arrivalBoards) {
            if (arrivalBoard.getLine().equals(line) && arrivalBoard.getTravelDirn().equals(direction)) {
                arrivalBoard.addArrival(arrival);
                return;
            }

        }

        ArrivalBoard arrivalBoardNew = new ArrivalBoard(line, direction);
        arrivalBoardNew.addArrival(arrival);
        this.arrivalBoards.add(arrivalBoardNew);

    }

    /**
     * Remove all arrival boards from this station
     */
    public void clearArrivalBoards() {
        this.arrivalBoards.clear();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Station that = (Station) o;

        return !(id != null ? !id.equals(that.id) : that.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public Iterator<ArrivalBoard> iterator() {
        // Do not modify the implementation of this method!
        return arrivalBoards.iterator();
    }
}
