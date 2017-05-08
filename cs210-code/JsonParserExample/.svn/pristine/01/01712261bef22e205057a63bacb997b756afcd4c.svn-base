package ca.ubc.cpsc210.sustainabilityapp.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ca.ubc.cpsc210.sustainabilityapp.model.datasource.FileDataProvider;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import ca.ubc.cpsc210.sustainabilityapp.model.PointOfInterest;
import ca.ubc.cpsc210.sustainabilityapp.model.parser.MapInfoParser;

public class TestParser {
	private static final double DELTA = 1.0e-6;   // for testing doubles
	private List<PointOfInterest> pointsOfInterest;
	private PointOfInterest first;
	private PointOfInterest last;
	
	@Before
	public void setUp() {
		pointsOfInterest = new ArrayList<PointOfInterest>();
        FileDataProvider source = new FileDataProvider("res/UBC-Sustainability-MapInfo.json");
        try {
            String jsonData = source.dataSourceToString();
            MapInfoParser.parseMapInfo(pointsOfInterest, jsonData);
            first = pointsOfInterest.get(0);
            last = pointsOfInterest.get(pointsOfInterest.size() - 1);
        } catch (IOException e) {
            System.out.println("Unable to open source file.");
            e.printStackTrace();
        } catch (JSONException e) {
            System.out.println("JSON data doesn't have expected format.");
            e.printStackTrace();
        }
    }

	@Test
	public void testNumPOIs() {
		assertEquals(7, pointsOfInterest.size());
	}
	
	@Test
	public void testIdFirst() {
		assertEquals("Law", first.getId());
	}
	
	@Test
	public void testIdLast() {
		assertEquals("LSC", last.getId());
	}
}
