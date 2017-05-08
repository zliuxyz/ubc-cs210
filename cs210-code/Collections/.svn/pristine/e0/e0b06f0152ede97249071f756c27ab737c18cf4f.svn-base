package ca.ubc.cs.cs210.collections.tests;

import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.Test;

import ca.ubc.cs.cs210.collections.Aircraft;

public abstract class CollectionTests {
	protected Collection<Aircraft> aircraft;
	private Aircraft a1;
	private Aircraft a2;
	private Aircraft a3;
	private Aircraft a4;
	private Aircraft a5;
	
	protected void setUpAircraft() {
		a1 = new Aircraft("C-GBRT");
		a1.setOrigin("YVR");
		a1.setDestination("YYZ");
		
		a2 = new Aircraft("C-GBRT");
		a2.setOrigin("YVR");
		a2.setDestination("YYZ");
		
		a3 = new Aircraft("C-RWEP");
		a3.setOrigin("YVR");
		a3.setDestination("PEK");
		
		a4 = new Aircraft("C-RWEP");
		a4.setOrigin("YVR");
		a4.setDestination("NRT");
		
		a5 = a1;
	}
	
	@Test
	public void testEqualsWithReferenceToSameObject() {
		assertTrue(a1.equals(a5));
	}
	
	@Test
	public void testEqualsWithReferenceToDuplicateObject() {
		assertTrue(a1.equals(a2));
	}
	
	@Test
    // Think carefully about the circumstances under which you'd want this test to pass
    // What does it mean for two Aircraft objects to be equal?
	public void testWhatDoesItMeanToBeEqual() {
		assertTrue(a3.equals(a4));
	}
	
	@Test
	public void testContainsWithReferenceToSameObject() {
		aircraft.add(a1);
		
		assertTrue(aircraft.contains(a1));
		assertTrue(aircraft.contains(a5));
	}
	
	@Test
	public void testContainsWithReferenceToDuplicateObject() {
		aircraft.add(a1);
		
		assertTrue(aircraft.contains(a2));
	}
	
	@Test
    // Think carefully about the circumstances under which you'd want this test to pass
    // What does it mean for a Collection to contain an Aircraft object?
	public void testWhatDoesItMeanToContain() {
		aircraft.add(a3);
		
		assertTrue(aircraft.contains(a4));
	}
}
