package ca.ubc.cs.cpsc210.integerset.test;

import ca.ubc.cs.cpsc210.integerset.util.IntegerSet;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Contains tests for IntegerSet
 */
public class IntegerSetTest {
    IntegerSet testSet;

    @Before
    public void runBefore() {
        testSet = new IntegerSet();
    }


    @Test
    public void testSize() {
        assertEquals(0, testSet.size());
    }

    @Test
    public void testSizeNonEmpty(){
        testSet.insert(10);
        testSet.insert(20);
        assertEquals(2,testSet.size());
    }
}