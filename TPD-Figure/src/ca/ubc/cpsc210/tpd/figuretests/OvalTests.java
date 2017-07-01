package ca.ubc.cpsc210.tpd.figuretests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import ca.ubc.cpsc210.tpd.figures.Oval;


public class OvalTests {
	private Oval oval;
	
	@Before
	public void runBefore() {
		oval = new Oval(new Point(2, 3));
	}
	
	@Test
	public void testConstructor() {
		assertEquals(0, oval.getWidth());
		assertEquals(0, oval.getHeight());
		assertEquals(2, oval.getX());
		assertEquals(3, oval.getY());
	}

	@Test
	public void testSetBounds() {
		oval.setBounds(10, 7);
		assertEquals(10, oval.getWidth());
		assertEquals(7, oval.getHeight());
		assertEquals(2, oval.getX());
		assertEquals(3, oval.getY());
	}
	
	@Test
	public void testContains() {
		oval.setBounds(10, 4);
		assertTrue(oval.contains(new Point(7, 3)));
		assertTrue(oval.contains(new Point(7, 5)));
		assertTrue(oval.contains(new Point(2, 5)));
		assertTrue(oval.contains(new Point(12, 5)));
		assertTrue(oval.contains(new Point(2 + 10 / 2, 3 + 4 / 2)));
		assertFalse(oval.contains(new Point(2, 3)));
		assertFalse(oval.contains(new Point(12, 3)));
		assertFalse(oval.contains(new Point(2, 8)));
		assertFalse(oval.contains(new Point(12, 8)));
	}
	
	@Test 
	public void testTranslate() {
		oval.setBounds(10, 5);
		oval.translate(4, -2);
		assertEquals(10, oval.getWidth());
		assertEquals(5, oval.getHeight());
		assertEquals(6, oval.getX());
		assertEquals(1, oval.getY());	
	}
}
