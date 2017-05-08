package ca.ubc.cs.cpsc210.integerset.test;

import ca.ubc.cs.cpsc210.integerset.util.IntegerSet;
import org.junit.Before;

import ca.ubc.cs.cpsc210.integerset.util.LinkedListIntegerSet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

    @Test
    // both sets empty
    public void testIntersectionEmptyEmpty() {
        IntegerSet other = new LinkedListIntegerSet();
        IntegerSet intersection = set.intersection(other);

        assertEquals(0, intersection.size());
    }

    @Test
    // set is empty, other contains many
    public void testIntersectionEmptyMany() {
        IntegerSet other = new LinkedListIntegerSet();
        for (int i = 0; i < 5; i++)
            other.insert(i);

        IntegerSet intersection = set.intersection(other);

        assertEquals(0, intersection.size());
    }

    @Test
    // set contains many, other is empty
    public void testIntersectionManyEmpty() {
        IntegerSet other = new LinkedListIntegerSet();

        for (int i = 0; i < 5; i++)
            set.insert(i);

        IntegerSet intersection = set.intersection(other);

        assertEquals(0, intersection.size());
    }

    @Test
    // the sets contain many but have no elements in common
    public void testIntersectionManyManyNoCommon() {
        IntegerSet other = new LinkedListIntegerSet();
        for (int i = 0; i < 5; i++)
            other.insert(i);

        for (int i = 5; i < 10; i++)
            set.insert(i);

        IntegerSet intersection = set.intersection(other);

        assertEquals(0, intersection.size());
    }

    @Test
    // the sets contain many and have many (but not all) elements in common
    public void testIntersectionManyManyWithCommon() {
        IntegerSet other = new LinkedListIntegerSet();
        for (int i = 0; i < 8; i++)
            other.insert(i);

        for (int i = 3; i < 10; i++)
            set.insert(i);

        IntegerSet intersection = set.intersection(other);

        assertEquals(5, intersection.size());

        for (int i = 3; i < 8; i++)
            assertTrue(intersection.contains(i));
    }

    @Test
    // the sets contain many and have all elements in common
    public void testIntersectionManyManyAllCommon() {
        IntegerSet other = new LinkedListIntegerSet();
        for (int i = 0; i < 5; i++)
            other.insert(i);

        for (int i = 0; i < 5; i++)
            set.insert(i);

        IntegerSet intersection = set.intersection(other);

        assertEquals(5, intersection.size());

        for (int i = 0; i < 5; i++)
            assertTrue(intersection.contains(i));
    }
}
