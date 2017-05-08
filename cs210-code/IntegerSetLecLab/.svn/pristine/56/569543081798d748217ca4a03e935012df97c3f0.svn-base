package ca.ubc.cs.cpsc210.integerset.test;

import ca.ubc.cs.cpsc210.integerset.util.IntegerSet;
import org.junit.Before;

import ca.ubc.cs.cpsc210.integerset.util.LinkedListIntegerSet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// Unit tests for LinkedListIntegerSet
public class LinkedListIntegerSetTest {
    private static final int NUMITEMS = 25000;
    private IntegerSet set;

	@Before
	public void runBefore() {
		set = new LinkedListIntegerSet();
	}

    @Test
    public void testSize() {
        assertEquals(0, set.size());

        for (int i = 0; i < NUMITEMS; i++) {
            set.insert(i);
        }

        assertEquals(NUMITEMS, set.size());
    }

    @Test
    public void testContains() {
        assertFalse(set.contains(1));
        set.insert(1);
        assertTrue(set.contains(1));
    }

    @Test
    public void testInsert() {
        set.insert(1);

        assertTrue(set.contains(1));
        assertEquals(1, set.size());
    }

    @Test
    public void testDuplicate() {
        set.insert(1);
        set.insert(1);

        assertTrue(set.contains(1));
        assertEquals(1, set.size());
    }

    @Test
    public void testInsertLots() {
        for (int i = 0; i < NUMITEMS; i++) {
            set.insert(i);
        }

        assertTrue(set.contains(0));
        assertTrue(set.contains(NUMITEMS / 2));
        assertTrue(set.contains(NUMITEMS - 1));
        assertEquals(NUMITEMS, set.size());
    }

    @Test
    public void testRemove() {
        set.insert(1);
        set.remove(1);
        assertFalse(set.contains(1));
        assertEquals(0, set.size());
    }

    @Test
    public void testRemoveLots() {
        for (int i = 0; i < NUMITEMS; i++) {
            set.insert(i);
        }

        for (int i = 0; i < NUMITEMS; i++) {
            set.remove(i);
        }

        assertFalse(set.contains(0));
        assertFalse(set.contains(NUMITEMS / 2));
        assertFalse(set.contains(NUMITEMS - 1));
        assertEquals(0, set.size());
    }
}
