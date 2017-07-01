package ca.ubc.cs.cpsc210.integerset.app;

import ca.ubc.cs.cpsc210.integerset.util.IntegerSet;
import ca.ubc.cs.cpsc210.integerset.util.LinkedListIntegerSet;

/**
 * Created by HardingLiu on 2015-07-13.
 */
public class Main {
    public static void main(String[] args) {
        IntegerSet mySet;
        mySet = new LinkedListIntegerSet();

        mySet.insert(10);
        mySet.insert(25);
        System.out.println(mySet.size());
    }
}
