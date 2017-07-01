package ca.ubc.cs.cpsc210.mindthegap.tests.parsers;

import ca.ubc.cs.cpsc210.mindthegap.TfL.DataProvider;
import ca.ubc.cs.cpsc210.mindthegap.TfL.FileDataProvider;
import ca.ubc.cs.cpsc210.mindthegap.model.LineResourceData;
import ca.ubc.cs.cpsc210.mindthegap.parsers.TfLLineParser;
import ca.ubc.cs.cpsc210.mindthegap.parsers.exception.TfLLineDataMissingException;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by HardingLiu on 2015-08-02.
 */
public class TfLLineParserMissingStopPointSequences {
    private String lineData;

    @Before
    public void setUp() throws Exception {
        DataProvider dataProvider = new FileDataProvider("./res/raw/MissingStopPointSequences.json");
        lineData = dataProvider.dataSourceToString();
    }

    @Test(expected = TfLLineDataMissingException.class)
    public void missingStopPointSequences() throws JSONException, TfLLineDataMissingException {
        TfLLineParser.parseLine(LineResourceData.CENTRAL, lineData);

    }
}
