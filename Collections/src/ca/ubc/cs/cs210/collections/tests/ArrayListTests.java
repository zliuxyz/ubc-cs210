package ca.ubc.cs.cs210.collections.tests;

import java.util.ArrayList;

import org.junit.Before;

import ca.ubc.cs.cs210.collections.Aircraft;

public class ArrayListTests extends CollectionTests {

	@Before
	public void runBefore() {
		aircraft = new ArrayList<Aircraft>();
		setUpAircraft();
	}
}
