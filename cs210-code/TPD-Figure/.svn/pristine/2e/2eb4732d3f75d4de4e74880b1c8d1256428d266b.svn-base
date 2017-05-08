package ca.ubc.cpsc210.tpd.figuretests;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import ca.ubc.cpsc210.tpd.figures.Rectangle;


public class RectangleTests {
	private Rectangle rect;
	
	@Before
	public void runBefore() {
		rect = new Rectangle(new Point(2, 3));
	}
	
	@Test
	public void testConstructor() {
		assertEquals(0, rect.getWidth());
		assertEquals(0, rect.getHeight());
		assertEquals(2, rect.getX());
		assertEquals(3, rect.getY());
	}
		
	@Test
	public void testSetBounds() {
		rect.setBounds(10, 7);
		assertEquals(10, rect.getWidth());
		assertEquals(7, rect.getHeight());
		assertEquals(2, rect.getX());
		assertEquals(3, rect.getY());
	}
	
	@Test
	public void testContains() {
		rect.setBounds(10, 5);
		assertTrue(rect.contains(new Point(2, 3)));
		assertTrue(rect.contains(new Point(12, 8)));
		assertTrue(rect.contains(new Point(2, 8)));
		assertTrue(rect.contains(new Point(12, 3)));
		assertTrue(rect.contains(new Point(2 + 10 / 2, 3 + 5 / 2)));
	}
	
	@Test
	public void testTranslate() {
		rect.setBounds(10, 5);
		rect.translate(4, -2);
		assertEquals(10, rect.getWidth());
		assertEquals(5, rect.getHeight());
		assertEquals(6, rect.getX());
		assertEquals(1, rect.getY());
	}
}
