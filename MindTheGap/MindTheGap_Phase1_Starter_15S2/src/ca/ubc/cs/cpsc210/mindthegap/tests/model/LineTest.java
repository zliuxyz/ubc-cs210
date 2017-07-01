package ca.ubc.cs.cpsc210.mindthegap.tests.model;

import ca.ubc.cs.cpsc210.mindthegap.model.Branch;
import ca.ubc.cs.cpsc210.mindthegap.model.Line;
import ca.ubc.cs.cpsc210.mindthegap.model.LineResourceData;
import ca.ubc.cs.cpsc210.mindthegap.model.Station;
import ca.ubc.cs.cpsc210.mindthegap.util.LatLon;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;


/**
 * Created by HardingLiu on 2015-07-29.
 */
public class LineTest {
    private Line line;


    @Before
    public void setup() {
        line = new Line(LineResourceData.BAKERLOO, "lol", "ahahah");
    }

    @Test
    public void testgetName() {
        assertEquals(line.getName(), "ahahah");
    }

    @Test
    public void testgetId(){
        assertEquals(line.getId(), "lol");
    }

    @Test
    public void testgetColour() {
        assertEquals(line.getColour(), LineResourceData.BAKERLOO.getColour());
    }

    @Test
    public void testaddStation() {
        List<Station> stationList = new ArrayList<Station>();
        assertEquals(line.getStations(), stationList);

        LatLon latlon = new LatLon(100.1234, 200.3456);
        Station station = new Station("47357124", "King's Garden", latlon);

        line.addStation(station);

        assertTrue(line.hasStation(station));
    }

    @Test
    public void testremoveStation() {
        List<Station> stationList = new ArrayList<Station>();
        assertEquals(line.getStations(), stationList);

        LatLon latlon = new LatLon(100.1234, 200.3456);
        Station station = new Station("47357124", "King's Garden", latlon);

        line.addStation(station);

        assertTrue(line.hasStation(station));

        line.removeStation(station);

        assertFalse(line.hasStation(station));

        assertEquals(line.getStations(), stationList);


    }

    @Test
    public void testclearStations() {
        List<Station> stationList = new ArrayList<Station>();
        assertEquals(line.getStations(), stationList);

        LatLon latlon = new LatLon(100.1234, 200.3456);
        LatLon latilon = new LatLon(300,400);
        Station station1 = new Station("47357124", "King's Garden", latlon);
        Station station2 = new Station("34343434", "Queens' Mother", latilon);

        line.addStation(station1);
        line.addStation(station2);

        List<Station> stations = new LinkedList<Station>();
        stations.add(station1);
        stations.add(station2);

        assertEquals(line.getStations(), stations);

        line.clearStations();

        assertEquals(line.getStations(), stationList);
    }


    @Test
    public void testgetStations() {
        LatLon latlon = new LatLon(100.1234, 200.3456);
        LatLon latilon = new LatLon(300,400);
        Station station1 = new Station("47357124", "King's Garden", latlon);
        Station station2 = new Station("34343434", "Queens' Mother", latilon);

        line.addStation(station1);
        line.addStation(station2);

        List<Station> stations = new LinkedList<Station>();
        stations.add(station1);
        stations.add(station2);

        assertEquals(line.getStations(), stations);

    }

    @Test
    public void testhasStation() {
        LatLon latlon = new LatLon(100.1234, 200.3456);
        LatLon latilon = new LatLon(300,400);
        Station station1 = new Station("47357124", "King's Garden", latlon);
        Station station2 = new Station("34343434", "Queens' Mother", latilon);

        line.addStation(station1);
        line.addStation(station2);

        assertTrue(line.hasStation(station1));
        assertTrue(line.hasStation(station2));
    }

    @Test
    public void testaddBranch()  {
        Branch branch1 = new Branch("[[[0.093493,51.6037],[0.092077,51.6134],[0.075051,51.6179],[0.043657,51.6172],[0.03398,51.6069],[0.027347,51.5919],[0.021449,51.5807],[0.008202,51.5683],[-0.005515,51.5566],[-0.00345,51.5418],[-0.033633,51.5251],[-0.0555,51.5272],[-0.083176,51.5174],[-0.088948,51.5134],[-0.097562,51.5149],[-0.111578,51.5183],[-0.12047,51.5176],[-0.130406,51.5164],[-0.141899,51.5152],[-0.149719,51.5143],[-0.15895,51.5134],[-0.175491,51.5117],[-0.187149,51.5103],[-0.196102,51.5091],[-0.205677,51.5071],[-0.218812,51.5044],[-0.224295,51.512],[-0.247248,51.5166],[-0.259754,51.5235],[-0.292704,51.5302],[-0.323447,51.5367],[-0.346052,51.5424],[-0.368702,51.5482],[-0.398904,51.5569],[-0.410699,51.5607],[-0.437875,51.5697]]]"
        );
        Branch branch2 = new Branch("[[[0.093493,51.6037],[0.091015,51.5956],[0.088596,51.5857],[0.090015,51.5757],[0.066195,51.5765],[0.045369,51.5762],[0.028537,51.5755],[0.008202,51.5683],[-0.005515,51.5566],[-0.00345,51.5418],[-0.033633,51.5251],[-0.0555,51.5272],[-0.083176,51.5174],[-0.088948,51.5134],[-0.097562,51.5149],[-0.111578,51.5183],[-0.12047,51.5176],[-0.130406,51.5164],[-0.141899,51.5152],[-0.149719,51.5143],[-0.15895,51.5134],[-0.175491,51.5117],[-0.187149,51.5103],[-0.196102,51.5091],[-0.205677,51.5071],[-0.218812,51.5044],[-0.224295,51.512],[-0.247248,51.5166],[-0.259754,51.5235],[-0.28098,51.518],[-0.301457,51.515]]]"
        );


        line.addBranch(branch1);
        line.addBranch(branch2);

        Set<Branch> branches = new HashSet<Branch>();

        branches.add(branch1);
        branches.add(branch2);

        assertEquals(line.getBranches(), branches);

    }


    @Test
    public void testgetBranches() {
        Set<Branch> brancheSet = new HashSet<Branch>();
        assertEquals(line.getBranches(), brancheSet);

        Branch branch1 = new Branch("[[[0.093493,51.6037],[0.092077,51.6134],[0.075051,51.6179],[0.043657,51.6172],[0.03398,51.6069],[0.027347,51.5919],[0.021449,51.5807],[0.008202,51.5683],[-0.005515,51.5566],[-0.00345,51.5418],[-0.033633,51.5251],[-0.0555,51.5272],[-0.083176,51.5174],[-0.088948,51.5134],[-0.097562,51.5149],[-0.111578,51.5183],[-0.12047,51.5176],[-0.130406,51.5164],[-0.141899,51.5152],[-0.149719,51.5143],[-0.15895,51.5134],[-0.175491,51.5117],[-0.187149,51.5103],[-0.196102,51.5091],[-0.205677,51.5071],[-0.218812,51.5044],[-0.224295,51.512],[-0.247248,51.5166],[-0.259754,51.5235],[-0.292704,51.5302],[-0.323447,51.5367],[-0.346052,51.5424],[-0.368702,51.5482],[-0.398904,51.5569],[-0.410699,51.5607],[-0.437875,51.5697]]]"
        );
        Branch branch2 = new Branch("[[[0.093493,51.6037],[0.091015,51.5956],[0.088596,51.5857],[0.090015,51.5757],[0.066195,51.5765],[0.045369,51.5762],[0.028537,51.5755],[0.008202,51.5683],[-0.005515,51.5566],[-0.00345,51.5418],[-0.033633,51.5251],[-0.0555,51.5272],[-0.083176,51.5174],[-0.088948,51.5134],[-0.097562,51.5149],[-0.111578,51.5183],[-0.12047,51.5176],[-0.130406,51.5164],[-0.141899,51.5152],[-0.149719,51.5143],[-0.15895,51.5134],[-0.175491,51.5117],[-0.187149,51.5103],[-0.196102,51.5091],[-0.205677,51.5071],[-0.218812,51.5044],[-0.224295,51.512],[-0.247248,51.5166],[-0.259754,51.5235],[-0.28098,51.518],[-0.301457,51.515]]]"
        );


        line.addBranch(branch1);
        line.addBranch(branch2);

        Set<Branch> branches = new HashSet<Branch>();

        branches.add(branch1);
        branches.add(branch2);

        assertEquals(line.getBranches(), branches);

    }

    @Test
    public void testequals() {
        Line line1 = new Line(LineResourceData.CENTRAL, "lol", "hhahahha");

        assertTrue(line.equals(line1));

        Line line2 = new Line(LineResourceData.CENTRAL, "gta", "aaaaa");

        assertFalse(line.equals(line2));

    }



}
