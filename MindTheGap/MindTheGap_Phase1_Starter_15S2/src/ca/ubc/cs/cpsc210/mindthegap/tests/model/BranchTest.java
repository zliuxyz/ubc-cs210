package ca.ubc.cs.cpsc210.mindthegap.tests.model;

import ca.ubc.cs.cpsc210.mindthegap.model.Branch;
import ca.ubc.cs.cpsc210.mindthegap.util.LatLon;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Created by HardingLiu on 2015-07-29.
 */
public class BranchTest {
    private Branch branch;

    @Before
    public void setup()  {
        branch = new Branch("[[[0.093493,51.6037],[0.092077,51.6134]]]");

    }

    @Test
    public void testGetPoints() {
        List<LatLon> pts = new ArrayList<LatLon>();
        LatLon latLon = new LatLon(51.6037, 0.093493);
        LatLon latLon1 = new LatLon(51.6134, 0.092077);
        pts.add(latLon);
        pts.add(latLon1);

        assertEquals(pts, branch.getPoints());



    }




}
