package ca.ubc.cs.cpsc210.mindthegap.tests.model;

import ca.ubc.cs.cpsc210.mindthegap.model.Line;
import ca.ubc.cs.cpsc210.mindthegap.model.LineResourceData;
import ca.ubc.cs.cpsc210.mindthegap.model.Station;
import ca.ubc.cs.cpsc210.mindthegap.model.StationManager;
import ca.ubc.cs.cpsc210.mindthegap.model.exception.StationException;
import ca.ubc.cs.cpsc210.mindthegap.util.LatLon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for StationManager
 */
public class StationManagerTest {
    private StationManager stnManager;

    @Before
    public void setUp() {
        stnManager = StationManager.getInstance();
        stnManager.clearSelectedStation();
        stnManager.clearStations();

    }

    @Test
    public void testStationManagerConstructor() {
        assertEquals(stnManager.getSelected(), null);

    }


    @Test
    public void testgetSelected() throws StationException {
        assertEquals(stnManager.getSelected(), null);

        Line line = new Line(LineResourceData.CENTRAL, "aaa", "Uxbridge");
        LatLon latlon = new LatLon(10.10923, 20.7812);
        Station station = new Station("lol", "alien", latlon);
        line.addStation(station);
        stnManager.addStationsOnLine(line);

        stnManager.setSelected(station);

        assertEquals(stnManager.getSelected(), station);


    }


    @Test
    public void testgetStationWithId() {
        assertEquals(stnManager.getStationWithId("198"), null);

        Line line = new Line(LineResourceData.CENTRAL, "aaa", "Uxbridge");
        LatLon latlon = new LatLon(10.10923, 20.7812);
        Station station = new Station("lol", "alien", latlon);
        line.addStation(station);
        stnManager.addStationsOnLine(line);

        assertEquals(stnManager.getStationWithId("lol"), station);
    }



    @Test
    public void testsetSelected() throws StationException {

        Line line = new Line(LineResourceData.CENTRAL, "aaa", "Uxbridge");
        LatLon latlon = new LatLon(10.10923, 20.7812);
        Station station = new Station("lol", "alien", latlon);
        line.addStation(station);
        stnManager.addStationsOnLine(line);

        stnManager.setSelected(station);

        assertEquals(stnManager.getSelected(), station);

    }

    @Test
    public void testclearSelectedStation() throws StationException {
        assertEquals(stnManager.getSelected(), null);

        Line line = new Line(LineResourceData.CENTRAL, "aaa", "Uxbridge");
        LatLon latlon = new LatLon(10.10923, 20.7812);
        Station station = new Station("lol", "alien", latlon);
        line.addStation(station);
        stnManager.addStationsOnLine(line);

        stnManager.setSelected(station);

        assertEquals(stnManager.getSelected(), station);

        stnManager.clearSelectedStation();

        assertEquals(stnManager.getSelected(), null);

    }

    @Test
    public void testaddStationsOnLine() {

        Line line = new Line(LineResourceData.CENTRAL, "aaa", "Uxbridge");
        LatLon latlon = new LatLon(10.10923, 20.7812);
        Station station = new Station("lol", "alien", latlon);
        line.addStation(station);

        stnManager.addStationsOnLine(line);

        assertEquals(stnManager.getNumStations(), 1);
        assertEquals(stnManager.getStationWithId("lol"), station);


    }

    @Test
    public void testgetNumStations() {
        assertEquals(0, stnManager.getNumStations());

        Line line = new Line(LineResourceData.CENTRAL, "aaa", "Uxbridge");
        LatLon latlon = new LatLon(10.10923, 20.7812);
        LatLon latilon = new LatLon(100.1098, 299.9989);
        Station station1 = new Station("lol", "alien", latlon);
        Station station2 = new Station("hahaha", "wuhaha", latilon);
        line.addStation(station1);
        line.addStation(station2);

        stnManager.addStationsOnLine(line);

        assertEquals(stnManager.getNumStations(), 2);

    }


    @Test
    public void testclearStations() {
        assertEquals(0, stnManager.getNumStations());

        Line line = new Line(LineResourceData.CENTRAL, "aaa", "Uxbridge");
        LatLon latlon = new LatLon(10.10923, 20.7812);
        LatLon latilon = new LatLon(100.1098, 299.9989);
        Station station1 = new Station("lol", "alien", latlon);
        Station station2 = new Station("hahaha", "wuhaha", latilon);
        line.addStation(station1);
        line.addStation(station2);

        stnManager.addStationsOnLine(line);

        assertEquals(stnManager.getNumStations(), 2);

        stnManager.clearStations();

        assertEquals(0, stnManager.getNumStations());


    }

    @Test
    public void testfindNearestTo() {

        Line line = new Line(LineResourceData.CENTRAL, "aaa", "Uxbridge");
        LatLon latlon = new LatLon(10.10923, 20.7812);
        LatLon latilon = new LatLon(100.1098, 299.9989);
        Station station1 = new Station("lol", "alien", latlon);
        Station station2 = new Station("hahaha", "wuhaha", latilon);
        line.addStation(station1);
        line.addStation(station2);

        LatLon pt = new LatLon(100.1099, 299.9988);
        stnManager.addStationsOnLine(line);

        assertEquals(station2, stnManager.findNearestTo(pt));

    }


}