package ca.ubc.cpsc210.sustainabilityapp.model.datasource;

import java.io.IOException;

/**
 * Specifies behaviours for data providers
 */
public interface DataProvider {

    /**
     * Read data source as string
     *
     * @return  string containing data read from source
     * @throws IOException  when error occurs reading from source
     */
    String dataSourceToString() throws IOException;
}
