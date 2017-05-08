package ca.ubc.cs.cpsc210.mindthegap.tests.model;

import ca.ubc.cs.cpsc210.mindthegap.model.Arrival;
import ca.ubc.cs.cpsc210.mindthegap.model.Line;
import ca.ubc.cs.cpsc210.mindthegap.model.LineResourceData;
import ca.ubc.cs.cpsc210.mindthegap.model.Station;
import ca.ubc.cs.cpsc210.mindthegap.util.LatLon;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by HardingLiu on 2015-07-29.
 */
public class StationTest {
    private Station station;

    @Before
    public void setup() {
        LatLon latlon = new LatLon(100.1234, 200.3456);
        station = new Station("47357124", "King's Garden", latlon);
    }


    @Test
    public void testgetName() {

        assertEquals("King's Garden", station.getName());
    }

    @Test
    public void testgetLocn() {

        LatLon latlon = new LatLon(100.1234, 200.3456);
        assertEquals(latlon, station.getLocn());
    }

    @Test
    public void testgetID() {
        assertEquals("47357124", station.getID());
    }

    @Test
    public void testgetLines() {
        Set<Line> lineSet = new HashSet<Line>();
        assertEquals(station.getLines(), lineSet);

        Line line1 = new Line(LineResourceData.CENTRAL, "aaa", "Uxbridge");
        Line line2 = new Line(LineResourceData.BAKERLOO, "bbb", "Northfields");

        station.addLine(line1);
        station.addLine(line2);

        Set<Line> lines = new HashSet<Line>();
        lines.add(line1);
        lines.add(line2);

        assertEquals(station.getLines(), lines);
    }

    @Test
    public void testgetNumArrivalBoards() {
        assertEquals(0, station.getNumArrivalBoards());

        Arrival arrival = new Arrival(60, "lollll", "NorthWest - Platform0");

        Line line1 = new Line(LineResourceData.CENTRAL, "aaa", "Uxbridge");

        station.addArrival(line1, arrival);

        assertEquals(1, station.getNumArrivalBoards());

    }

    @Test
    public void testaddLine() {
        Set<Line> lineSet = new HashSet<Line>();
        assertEquals(station.getLines(), lineSet);

        Line line1 = new Line(LineResourceData.CENTRAL, "aaa", "Uxbridge");

        station.addLine(line1);

        assertEquals(station.hasLine(line1), true);
    }


    @Test
    public void testremoveLine() {

        Set<Line> lineSet = new HashSet<Line>();
        assertEquals(station.getLines(), lineSet);

        Line line1 = new Line(LineResourceData.CENTRAL, "aaa", "Uxbridge");

        station.addLine(line1);

        assertEquals(station.hasLine(line1), true);

        station.removeLine(line1);

        assertEquals(station.hasLine(line1), false);

    }

    @Test
    public void testhasLine() {
        Line line1 = new Line(LineResourceData.CENTRAL, "aaa", "Uxbridge");

        assertFalse(station.hasLine(line1));

        station.addLine(line1);

        assertTrue(station.hasLine(line1));


    }

    @Test
    public void testaddArrival() {
        assertEquals(station.getNumArrivalBoards(), 0);

        Arrival arrival = new Arrival(60, "lollll", "West - Platform3");

        Line line1 = new Line(LineResourceData.CENTRAL, "aaa", "Uxbridge");

        station.addArrival(line1, arrival);

        assertEquals(station.getNumArrivalBoards(), 1);


    }

    @Test
    public void testclearArrivalBoards() {
        Arrival arrival = new Arrival(60, "lollll", "East - Platform10");

        Line line1 = new Line(LineResourceData.CENTRAL, "aaa", "Uxbridge");


        station.addArrival(line1, arrival);

        assertEquals(station.getNumArrivalBoards(), 1);

        station.clearArrivalBoards();

        assertEquals(station.getNumArrivalBoards(), 0);
    }

    @Test
    public void testequals() {
        LatLon latlon = new LatLon(200, 19);
        Station station1 = new Station ("47357124", "wahaha", latlon);

        assertTrue(station.equals(station1));

    }

}
