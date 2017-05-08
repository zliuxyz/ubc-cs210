package ca.ubc.cs.cpsc210.mindthegap.TfL;

import ca.ubc.cs.cpsc210.mindthegap.model.Arrival;
import ca.ubc.cs.cpsc210.mindthegap.model.ArrivalBoard;
import ca.ubc.cs.cpsc210.mindthegap.model.Line;
import ca.ubc.cs.cpsc210.mindthegap.model.Station;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Wrapper for TfL Arrival Data Provider
 */
public class TfLHttpArrivalDataProvider extends AbstractHttpDataProvider {
    private Station stn;

    public TfLHttpArrivalDataProvider(Station stn) {
        super();
        this.stn = stn;
    }

    @Override
    /**
     * Produces URL used to query TfL web service for expected arrivals at
     * station specified in call to constructor.
     *
     * @returns URL to query TfL web service for arrival data
     */
    protected URL getURL() throws MalformedURLException {
        String request = "";

        String stopPointId = stn.getID();
        List<String> lineIds = new ArrayList<String>();
        for (Line line: stn.getLines()) {
            lineIds.add(line.getId());
        }

        request = "https://api.tfl.gov.uk/Line//Arrivals?stopPointId=&app_id=&app_key=";


        request = new StringBuilder(request).insert(request.length()-17, stopPointId).toString();

        StringBuilder sb = new StringBuilder();
        String delim = "";


        for (String id: lineIds) {

            sb.append(delim).append(id);

            delim = ",";

        }

        String lineIdsString = sb.toString();

        request = request.substring(0,28) + lineIdsString + request.substring(28,request.length());


        return new URL(request);

    }
}
