package ca.ubc.cs.cpsc210.mindthegap.parsers;


import ca.ubc.cs.cpsc210.mindthegap.util.LatLon;

import org.json.JSONArray;
import org.json.JSONException;



import java.util.ArrayList;
import java.util.List;

import java.util.regex.Pattern;



/**
 * Parser for route strings in TfL line data
 */
public class BranchStringParser {
    private List<LatLon> latLonList;

    /**
     * Parse a branch string obtained from TFL
     *
     * @param branch  branch string
     * @return       list of lat/lon points parsed from branch string
     */
    public static List<LatLon> parseBranch(String branch)  {
        List<LatLon> latLonList = new ArrayList<LatLon>();

        if (!branch.equals("")) {


            JSONArray jsonArray = null;
            try {
                jsonArray = new JSONArray(branch);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONArray lineStringJsonArray = null;
            try {
                lineStringJsonArray = jsonArray.getJSONArray(0);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < lineStringJsonArray.length(); i++) {

                JSONArray latLonJsonArray = null;

                try {
                    latLonJsonArray = lineStringJsonArray.getJSONArray(i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Double longitude = null;
                try {
                    longitude = Double.parseDouble(latLonJsonArray.get(0).toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Double latitude = null;
                try {
                    latitude = Double.parseDouble(latLonJsonArray.get(1).toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                LatLon latLon = new LatLon(latitude, longitude);
                latLonList.add(latLon);
            }

        }

        return latLonList;
    }
}
