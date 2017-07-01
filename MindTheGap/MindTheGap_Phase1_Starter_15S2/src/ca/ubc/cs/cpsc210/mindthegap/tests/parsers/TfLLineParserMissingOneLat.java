package ca.ubc.cs.cpsc210.mindthegap.tests.parsers;

import ca.ubc.cs.cpsc210.mindthegap.TfL.DataProvider;
import ca.ubc.cs.cpsc210.mindthegap.TfL.FileDataProvider;
import ca.ubc.cs.cpsc210.mindthegap.model.LineResourceData;
import ca.ubc.cs.cpsc210.mindthegap.parsers.TfLLineParser;
import ca.ubc.cs.cpsc210.mindthegap.parsers.exception.TfLLineDataMissingException;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * Created by HardingLiu on 2015-08-02.
 */
public class TfLLineParserMissingOneLat {
    private String lineData;

    @Before
    public void setUp() throws Exception {
        DataProvider dataProvider = new FileDataProvider("./res/raw/OneLat.json");
        lineData = dataProvider.dataSourceToString();
    }

    @Test
    public void missingOneLat() throws JSONException, TfLLineDataMissingException {
        try {
            TfLLineParser.parseLine(LineResourceData.CENTRAL, lineData);
        } catch (JSONException e) {
            fail("JSONException should not have been thrown while parsing data in central_inbound.json");
        } catch (TfLLineDataMissingException e) {
            fail("TfLLineDataMissingException should not have been thrown while parsing data in central_inbound.json");
        }

    }
}
