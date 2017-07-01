package whereami;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * A class that uses a LocationService to determine the current continent ---
 * via the whichContinent method.
 */
public class WhereAmI {

    /*
     * This method queries locator for Internet distances to the 7 continents
     * around the globe and returns the current continent name as a string.
     * 
     * EFFECTS: returns the current continent
     */
    public Continent whichContinent(ILocationService locator) {

        Continent x = Continent.N_AMERICA;
        for (Continent i : Continent.values()) {
            if (locator.timeTo(x) <= locator.timeTo(i))
            {      }
            else
            {x = i;}
        }

        return x;
    }

}


