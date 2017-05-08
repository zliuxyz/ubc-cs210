package ca.ubc.cpsc210.sustainabilityapp.model.parser;

import java.util.ArrayList;
import java.util.List;

import ca.ubc.cpsc210.sustainabilityapp.model.Feature;
import ca.ubc.cpsc210.sustainabilityapp.model.LatLong;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import ca.ubc.cpsc210.sustainabilityapp.model.PointOfInterest;

public class MapInfoParser extends DefaultHandler {

	private List<PointOfInterest> pointsOfInterest;
    private StringBuffer accumulator;
    private PointOfInterest pointOfInterest;
    private List<Feature> features;
    private LatLong latlong;
    private Double latitude;
    private Double longitude;

    // Constructor
    // EFFECTS: this parsers list of points of interest get the list passed as a parameter
	public MapInfoParser(List<PointOfInterest> pointsOfInterest) {
		this.pointsOfInterest = pointsOfInterest;
        latitude = 0.0;
        longitude = 0.0;
    }

    //TODO: override methods in DefaultHandler to parse Point of Interest data
	@Override
    public void startDocument()  {
        System.out.println("Start Document!");

        accumulator = new StringBuffer();
    }


    @Override
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes) {

        System.out.println("Start Element: " + qName);


        if (qName.toUpperCase().equals("POI")) {
            String Id = attributes.getValue("Id");
            String DisplayName = attributes.getValue("DisplayName");
            pointOfInterest  = new PointOfInterest(Id, DisplayName);
            this.features = new ArrayList<Feature>();


            System.out.println("Reached a new POI with Id = " + attributes.getValue("Id") + " , DisplayName = " +
                    attributes.getValue("DisplayName"));
        }

        accumulator.setLength(0);

    }

    @Override
    public void characters(char[] temp, int start, int length)  {
        accumulator.append(temp, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        String data = accumulator.toString();


        if (qName.toUpperCase().equals("POI")) {
            pointsOfInterest.add(pointOfInterest);
        }

        else if (qName.toUpperCase().equals("ADDRESS")) {
            pointOfInterest.setAddress(data);

        }
        else if (qName.toUpperCase().equals("LAT")) {
            latitude = Double.parseDouble(data);
        }
        else if (qName.toUpperCase().equals("LONG")) {
            longitude = Double.parseDouble(data);
            latlong = new LatLong(latitude, longitude);
            pointOfInterest.setLatLong(latlong);
        }
        else if (qName.toUpperCase().equals("DESCRIPTION")) {
            pointOfInterest.setDescription(data);
        }

        else if (qName.toUpperCase().equals("FEATURE")) {
            features.add(Feature.parseFeature(data));
            pointOfInterest.setFeatures(features);
        }



        System.out.println("EndElement: " + qName + " value: " + data);


        accumulator.setLength(0);
    }

    @Override
    public void endDocument()  {
        // Just so you can visualize how the parser is working
        System.out.println("End Document!");
    }


}
