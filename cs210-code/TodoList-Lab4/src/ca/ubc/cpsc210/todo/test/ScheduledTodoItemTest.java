package ca.ubc.cpsc210.todo.test;

import ca.ubc.cpsc210.todo.model.ScheduledTodoItem;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by HardingLiu on 2015-07-22.
 */
public class ScheduledTodoItemTest {
    private ScheduledTodoItem scheduledTodoItem;



    @Before
    public void setUp() {
        Calendar cal = Calendar.getInstance();
        cal.set(2000, Calendar.JANUARY,10);
        Date date = cal.getTime();

        scheduledTodoItem = new ScheduledTodoItem("FinalExam", "EndOftheWorld", date);
    }

    @Test
    public void testgetDueDate() {
        Date date = new Date();
        scheduledTodoItem.setDueDate(date);
        assertEquals(date, scheduledTodoItem.getDueDate());
    }

    @Test
    public void testsetDueDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(2015, Calendar.JANUARY,10);
        Date date = cal.getTime();

        scheduledTodoItem.setDueDate(date);

        assertEquals(date, scheduledTodoItem.getDueDate());
    }

    @Test
    public void testisCompleted() {
        assertTrue(scheduledTodoItem.isCompleted());

        Calendar cal = Calendar.getInstance();
        cal.set(2016, Calendar.DECEMBER, 12);
        Date date = cal.getTime();

        scheduledTodoItem.setDueDate(date);
        assertFalse(scheduledTodoItem.isCompleted());
    }

    @Test
    public void testisHighPriority() {
        assertFalse(scheduledTodoItem.isHighPriority());
        Date date = new Date();
        scheduledTodoItem.setDueDate(date);
        assertTrue(scheduledTodoItem.isHighPriority());
    }



}