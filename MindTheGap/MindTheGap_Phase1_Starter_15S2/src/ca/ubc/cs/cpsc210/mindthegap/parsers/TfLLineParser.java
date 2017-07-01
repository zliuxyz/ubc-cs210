package ca.ubc.cs.cpsc210.mindthegap.parsers;

import ca.ubc.cs.cpsc210.mindthegap.model.*;
import ca.ubc.cs.cpsc210.mindthegap.parsers.exception.TfLLineDataMissingException;
import ca.ubc.cs.cpsc210.mindthegap.util.LatLon;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A parser for the data returned by TFL line route query
 */
public class TfLLineParser extends TfLAbstractParser {

    /**
     * Parse line from JSON response produced by TfL.  No stations added to line if TfLLineDataMissingException
     * is thrown.
     *
     * @param lmd              line meta-data
     * @return                 line parsed from TfL data
     * @throws JSONException   when JSON data does not have expected format
     * @throws TfLLineDataMissingException when
     * <ul>
     *  <li> JSON data is missing lineName, lineId or stopPointSequences elements </li>
     *  <li> for a given sequence: </li>
     *    <ul>
     *      <li> the stopPoint array is missing </li>
     *      <li> all station elements are missing one of name, lat, lon or stationId elements </li>
     *    </ul>
     * </ul>
     */
    public static Line parseLine(LineResourceData lmd, String jsonResponse)
            throws JSONException, TfLLineDataMissingException {

        int a = 0;

        List<String> ids = new ArrayList<String>();

        JSONObject jsonObject = new JSONObject(jsonResponse);


        JSONArray jsonArray = jsonObject.getJSONArray("lineStrings");


        if (!jsonObject.has("lineId")) {


            throw new TfLLineDataMissingException();
        }

        String lineId = jsonObject.getString("lineId");

        if (!jsonObject.has("lineName")) {

            throw new TfLLineDataMissingException();
        }

        String lineName = jsonObject.getString("lineName");


        Line line = new Line(lmd,lineId,lineName);


        for (int i = 0; i < jsonArray.length(); i++) {

            Branch branch = new Branch(jsonArray.getString(i));

            line.addBranch(branch);
        }

        if (!jsonObject.has("stopPointSequences")) {
            line.clearStations();

            throw new TfLLineDataMissingException();
        }

        JSONArray jsonArray1 = jsonObject.getJSONArray("stopPointSequences");

        for (int i = 0; i < jsonArray1.length(); i++) {

            JSONObject jsonObject1 = jsonArray1.getJSONObject(i);

            if (!jsonObject1.has("stopPoint"))
            {
                line.clearStations();
                throw new TfLLineDataMissingException();
            }

            JSONArray jsonArray2 = jsonObject1.getJSONArray("stopPoint");



            for (int l = 0; l < jsonArray2.length(); l++) {



                JSONObject jsonObject2 = jsonArray2.getJSONObject(l);


                if (!jsonObject2.has("name")) {

                    a = a + 1;

                    if (a == jsonArray2.length()) {

                        line.clearStations();

                        throw new TfLLineDataMissingException();
                    }
                    continue;
                }

                String name = jsonObject2.getString("name");

                String stationName = TfLAbstractParser.parseName(name);

                if(!jsonObject2.has("stationId")) {

                    a = a + 1;

                    if (a == jsonArray2.length()) {

                        line.clearStations();

                        throw new TfLLineDataMissingException();
                    }
                    continue;
                }

                String stationId = jsonObject2.getString("stationId");

                if (!jsonObject2.has("lat")) {

                    a = a + 1;

                    if (a >= jsonArray2.length()) {

                        line.clearStations();

                        throw new TfLLineDataMissingException();
                    }
                    continue;
                }

                Double latitude = jsonObject2.getDouble("lat");

                if(!jsonObject2.has("lon")) {

                    a = a + 1;

                    if (a == jsonArray2.length()) {

                        line.clearStations();

                        throw new TfLLineDataMissingException();
                    }
                    continue;
                }

                Double longitude = jsonObject2.getDouble("lon");

                LatLon latLon = new LatLon(latitude,longitude);




                    Station station = new Station(stationId, stationName, latLon);

                    line.addStation(station);



            }

        }


        return line;
    }
}
