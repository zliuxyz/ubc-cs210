package ca.ubc.cpsc210.sustainabilityapp.model.parser;

import java.util.ArrayList;
import java.util.List;


import ca.ubc.cpsc210.sustainabilityapp.model.Feature;
import ca.ubc.cpsc210.sustainabilityapp.model.LatLong;
import ca.ubc.cpsc210.sustainabilityapp.model.PointOfInterest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MapInfoParser {

    /**
     * Parse list of point of interest from JSON data.
     *
     * @param pointsOfInterest  list to which points of interest are to be added
     * @param jsonData  the JSON data
     * @throws JSONException  when JSON data does not have expected format
     */
	public static void parseMapInfo(List<PointOfInterest> pointsOfInterest, String jsonData) throws JSONException {
        JSONArray poiJsonArray = new JSONArray(jsonData);

        for(int i = 0; i < poiJsonArray.length(); i++) {
            parsePOI(pointsOfInterest, poiJsonArray.getJSONObject(i));
        }
	}

    /**
     * Parse a single point of interest from JSON data and add it to list of points of interest.
     *
     * @param pointsOfInterest  list to which parsed point of interest will be added
     * @param poiJsonObject   the JSON data
     * @throws JSONException  when JSON data does not have expected format
     */
    private static void parsePOI(List<PointOfInterest> pointsOfInterest, JSONObject poiJsonObject) throws JSONException {
        String id = poiJsonObject.getString("id");
        String displayName = poiJsonObject.getString("displayName");
        PointOfInterest poi = new PointOfInterest(id, displayName);

        String address = poiJsonObject.getString("address");
        poi.setAddress(address);

        String description = poiJsonObject.getString("description");
        poi.setDescription(description);

        double lat = poiJsonObject.getDouble("lat");
        double lon = poiJsonObject.getDouble("long");
        LatLong locn = new LatLong(lat, lon);
        poi.setLatLong(locn);

        JSONArray featuresJsonArray = poiJsonObject.getJSONArray("features");
        addFeatures(poi, featuresJsonArray);

        pointsOfInterest.add(poi);
    }

    /**
     * Parse list of features from JSON data and add to point of interest
     *
     * @param poi  the point of interest to which parsed list of features is to be added
     * @param featuresJsonArray  the JSON data
     * @throws JSONException  when JSON data does not have expected format
     */
    private static void addFeatures(PointOfInterest poi, JSONArray featuresJsonArray) throws JSONException {
        List<Feature> features = new ArrayList<Feature>();

        for(int i = 0; i < featuresJsonArray.length(); i++) {
            String feature = featuresJsonArray.getString(i);
            features.add(Feature.parseFeature(feature));
        }

        poi.setFeatures(features);
    }
}
