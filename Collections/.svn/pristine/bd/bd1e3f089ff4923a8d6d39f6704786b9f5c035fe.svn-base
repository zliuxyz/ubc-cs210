package ca.ubc.cs.cs210.collections.app;

import ca.ubc.cs.cs210.collections.Aircraft;

// Simple app to demonstrate equality.
public class Main {
    public static void main(String[] args) {
        Aircraft a1 = new Aircraft("C-GBRT");
        a1.setOrigin("YVR");
        a1.setDestination("YYZ");

        Aircraft a2 = new Aircraft("C-GBRT");
        a2.setOrigin("YVR");
        a2.setDestination("YYZ");

        Aircraft a3 = new Aircraft("C-RWEP");
        a3.setOrigin("YVR");
        a3.setDestination("PEK");

        Aircraft a4 = new Aircraft("C-RWEP");
        a4.setOrigin("YVR");
        a4.setDestination("NRT");

        System.out.println("a1 == a2 evaluates to " + (a1 == a2));
        System.out.println("a1.equals(a2) evaluates to " + (a1.equals(a2)));
        System.out.println("a3.equals(a4) evaluates to " + (a3.equals(a4)));
    }
}
