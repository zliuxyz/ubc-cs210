package ca.ubc.cs.cpsc210.mindthegap.model;

/**
 * Represents an estimated arrival with time to arrival in seconds,
 * name of destination and platform at which train arrives.  Platform
 * data is assumed to be of the form:
 *    "Travel Direction - Platform Name"
 * with an arbitrary number of spaces either side of "-" and at the
 * start and end of the string.
 */
public class Arrival implements Comparable<Arrival>{

    private int timeToStation;
    private String destination;
    private String platform;

    /**
     * Constructs a new arrival with the given time to station (in seconds),
     * destination and platform.
     *
     * @param timeToStation  time until train arrives at station (in seconds)
     * @param destination    name of destination station
     * @param platform       name of platform at which train will arrive
     */
    public Arrival(int timeToStation, String destination, String platform) {
        this.timeToStation = timeToStation;
        this.destination = destination;
        this.platform = platform;
    }
    

    /**
     * Get direction of travel as indicated by platform prefix (part of platform prior to "-" with
     * leading and trailing whitespace trimmed)
     *
     * @return direction of travel
     */
    public String getTravelDirn() {
        String travelDirection = this.getPlatform().substring(0,this.platform.indexOf("-")).trim();
        return travelDirection;
    }

    /**
     * Get platform name as indicated by platform suffix (part of platform after "-" with leading
     * and trailing whitespace trimmed)
     *
     * @return  platform name
     */
    public String getPlatformName() {
        String platformName = this.getPlatform().substring(this.platform.indexOf("-") + 1, this.platform.length()).trim();
        return platformName;
    }

    /**
     * Get time until train arrives at station rounded up to nearest minute.
     *
     * @return  time until train arrives at station in minutes
     */
    public int getTimeToStationInMins() {
        Double timeToStationInSeconds = ((double) timeToStation);
        Double timeToStationInMins = Math.ceil(timeToStationInSeconds / 60);
        Integer time = timeToStationInMins.intValue();
        return time;
    }

    public int getTimeToStation() {
        return this.timeToStation;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getPlatform() {
        return this.platform;
    }

    /**
     * Order train arrivals by time until train arrives at station
     * (shorter times ordered before longer times)
     */
    @Override
    public int compareTo(Arrival arrival) {
        // Do not modify the implementation of this method!
        return this.timeToStation - arrival.timeToStation;
    }
}
