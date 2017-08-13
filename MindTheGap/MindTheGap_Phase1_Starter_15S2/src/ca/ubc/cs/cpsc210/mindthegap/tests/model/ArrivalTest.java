package ca.ubc.cs.cpsc210.mindthegap.tests.model;

import ca.ubc.cs.cpsc210.mindthegap.model.Arrival;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by HardingLiu on 2015-07-29.
 */
public class ArrivalTest {
    private Arrival arrival;

    @Before
    public void setup() {
        arrival = new Arrival(70, "Taiyuan", " NorthWest - Platform1 ");
    }

    @Test
    public void testGetTravelDirn() {
        assertEquals("NorthWest", arrival.getTravelDirn());
    }

    @Test
    public void testGetPlatformName() {
        assertEquals("Platform1", arrival.getPlatformName());
    }

    @Test
    public void testGetTimeToStationInMins() {
        assertEquals(2, arrival.getTimeToStationInMins());

    }

    @Test
    public void testGetDestination() {
        assertEquals("Taiyuan", arrival.getDestination());
    }

    @Test
    public void testGetPlatform() {
        assertEquals(" NorthWest - Platform1 ", arrival.getPlatform());
    }


}
