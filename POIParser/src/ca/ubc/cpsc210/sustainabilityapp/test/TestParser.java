package ca.ubc.cpsc210.sustainabilityapp.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ca.ubc.cpsc210.sustainabilityapp.model.Feature;
import ca.ubc.cpsc210.sustainabilityapp.model.LatLong;
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
		
		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(new MapInfoParser(pointsOfInterest));
			reader.parse("UBC-Sustainability-MapInfo.xml");
			
			first = pointsOfInterest.get(0);
			last = pointsOfInterest.get(pointsOfInterest.size() - 1);
			
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
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

	@Test
	public void testAddressFirst(){
		assertEquals("1822 East Mall, Vancouver, BC", first.getAddress());
	}

	@Test
	public void testAddressLast(){
		assertEquals("2350 Health Sciences Mall, Vancouver, BC", last.getAddress());
	}

	@Test
	public void testLatLongFirst() {
		LatLong firstLatLong = new LatLong(49.269041, -123.25319);
		assertEquals(firstLatLong, first.getLatLong());
	}

	@Test
	public void testLatLongLast() {
		LatLong lastLatLong = new LatLong(49.26239, -123.246244);
		assertEquals(lastLatLong, last.getLatLong());
	}

	@Test
	public void testFeatureFirst(){
		List<Feature> features = new ArrayList<Feature>();
		features.add(Feature.LEED_CERTIFICATION);
		features.add(Feature.WASTEWATER_TREATMENT);
		assertEquals(features,first.getFeatures());
	}

	@Test
	public void testFeatureLast() {
		List<Feature> features = new ArrayList<Feature>();
		features.add(Feature.LEED_CERTIFICATION);
		assertEquals(features, last.getFeatures());
	}



}
