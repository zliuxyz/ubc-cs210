package ca.ubc.cs.cpsc210.mindthegap.tests.model;

import ca.ubc.cs.cpsc210.mindthegap.model.LineResourceData;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by HardingLiu on 2015-07-29.
 */
public class LineResourceDataTest {
    private LineResourceData lineResourceData;

    @Before
    public void setup() {
        lineResourceData = LineResourceData.CENTRAL;
    }

    @Test
    public void testGetFileName() {
        assertEquals(lineResourceData.getFileName(), LineResourceData.CENTRAL.getFileName());

    }

    @Test
    public void testGetColour() {
        assertEquals(lineResourceData.getColour(), LineResourceData.CENTRAL.getColour());
    }


}
