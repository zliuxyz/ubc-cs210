package ca.ubc.cpsc210.todo.test;

import ca.ubc.cpsc210.todo.model.UnscheduledTodoItem;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by HardingLiu on 2015-07-22.
 */
public class UnscheduledTodoItemTest {
    private UnscheduledTodoItem unscheduledTodoItem;

    @Before
    public void setUp() {
        unscheduledTodoItem = new UnscheduledTodoItem("FinalExam", "EndOftheWorld", true);

    }

    @Test
    public void testisHighPriority () {
        assertTrue(unscheduledTodoItem.isHighPriority());
        unscheduledTodoItem.setHighPriority(false);
        assertFalse(unscheduledTodoItem.isHighPriority());
    }

    @Test
    public void testsetHighPriority() {
        assertTrue(unscheduledTodoItem.isHighPriority());
        unscheduledTodoItem.setHighPriority(false);
        assertFalse(unscheduledTodoItem.isHighPriority());
        unscheduledTodoItem.setHighPriority(true);
        assertTrue(unscheduledTodoItem.isHighPriority());
    }





}