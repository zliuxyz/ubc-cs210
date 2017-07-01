package ca.ubc.cs.cpsc210.mindthegap.tests.parsers;

import ca.ubc.cs.cpsc210.mindthegap.parsers.BranchStringParser;
import ca.ubc.cs.cpsc210.mindthegap.util.LatLon;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


/**
 * Created by HardingLiu on 2015-08-01.
 */
public class BranchStringParserTest {
    private String branch;

    @Before
    public void setup() {
        branch = "[[[0.093493,51.6037],[0.092077,51.6134],[0.075051,51.6179],[0.043657,51.6172]]]";
    }

    @Test
    public void testparseBranch() {
        List<LatLon> list = new ArrayList<LatLon>();
        LatLon latLon1 = new LatLon(51.6037,0.093493);
        LatLon latLon2 = new LatLon(51.6134,0.092077);
        LatLon latLon3 = new LatLon(51.6179,0.075051);
        LatLon latLon4 = new LatLon(51.6172,0.043657);
        list.add(latLon1);
        list.add(latLon2);
        list.add(latLon3);
        list.add(latLon4);

        assertEquals(list, BranchStringParser.parseBranch(branch));

    }

    @Test
    public void testempty() {
        List<LatLon> list = new ArrayList<LatLon>();
        assertEquals(list, BranchStringParser.parseBranch(""));
    }
}
