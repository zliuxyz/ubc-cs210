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
    public void testgetTravelDirn() {
        assertEquals("NorthWest", arrival.getTravelDirn());
    }

    @Test
    public void testgetPlatformName() {
        assertEquals("Platform1", arrival.getPlatformName());
    }

    @Test
    public void testgetTimeToStationInMins() {
        assertEquals(2, arrival.getTimeToStationInMins());

    }

    @Test
    public void testgetDestination() {
        assertEquals("Taiyuan", arrival.getDestination());
    }

    @Test
    public void testgetPlatform() {
        assertEquals(" NorthWest - Platform1 ", arrival.getPlatform());
    }


}
