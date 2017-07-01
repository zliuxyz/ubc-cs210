package ca.ubc.cs.cpsc210.integerset.app;

import ca.ubc.cs.cpsc210.integerset.util.IntegerSet;
import ca.ubc.cs.cpsc210.integerset.util.LinkedListIntegerSet;

/**
 * Created by HardingLiu on 2015-07-13.
 */
public class Main {
    public static void main(String[] args) {
        LinkedListIntegerSet mySet = new LinkedListIntegerSet();


        mySet.insert(10);
        mySet.insert(13);
        mySet.insert(10);

        //mySet.data.add(10);


        System.out.println("Size: " + mySet.size());

        IntegerSet setA = new LinkedListIntegerSet();
        IntegerSet setB = new LinkedListIntegerSet();

        IntegerSet intersectionAB = setA.intersection(setB);
        // IntegerSet intersectionAB = setB.intersection(setA);
    }
}
