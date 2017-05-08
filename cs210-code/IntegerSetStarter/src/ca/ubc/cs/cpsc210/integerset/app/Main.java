package ca.ubc.cs.cpsc210.integerset.app;


import ca.ubc.cs.cpsc210.integerset.util.IntegerSet;

/**
 * Very simple app to demonstrate *use* of IntegerSet
 */
public class Main {

    public static void main(String[] args)  {
        IntegerSet mySet = new IntegerSet();
        IntegerSet myOtherSet = new IntegerSet();

        mySet.insert(10);
        myOtherSet.insert(2);
        myOtherSet.insert(3);
        myOtherSet.insert(3);

        //myOtherSet.remove(23); // not allowed

        System.out.println("Size of myOtherSet: " + myOtherSet.size());

    }
}
