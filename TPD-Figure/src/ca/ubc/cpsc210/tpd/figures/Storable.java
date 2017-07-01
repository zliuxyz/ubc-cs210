package ca.ubc.cpsc210.tpd.figures;

import java.io.File;

/**
 * Created by HardingLiu on 2015-07-15.
 */
public interface Storable {

    // EFFECTS: data has been written to file f
    public void toFile(File f);

    // EFFECTS: data has been read from file f
    public void fromFile(File f);
}
