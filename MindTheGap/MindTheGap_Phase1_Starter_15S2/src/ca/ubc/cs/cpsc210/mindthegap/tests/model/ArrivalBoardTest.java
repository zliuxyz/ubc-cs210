package ca.ubc.cs.cpsc210.mindthegap.tests.model;

import ca.ubc.cs.cpsc210.mindthegap.model.Arrival;
import ca.ubc.cs.cpsc210.mindthegap.model.ArrivalBoard;
import ca.ubc.cs.cpsc210.mindthegap.model.Line;
import ca.ubc.cs.cpsc210.mindthegap.model.LineResourceData;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;



/**
 * Created by HardingLiu on 2015-07-29.
 */
public class ArrivalBoardTest {
    private ArrivalBoard arrivalBoard;

    @Before
    public void setup() {
        Line line = new Line(LineResourceData.BAKERLOO, "lol", "ahahah");

        arrivalBoard = new ArrivalBoard(line, "NorthWest");
    }


    @Test
    public void testGetLine() {
        Line line = new Line(LineResourceData.BAKERLOO, "lol", "ahahah");


        assertEquals(line.getId(),arrivalBoard.getLine().getId());

    }

    @Test
    public void testGetTravelDirn() {
        assertEquals("NorthWest", arrivalBoard.getTravelDirn());
    }

    @Test
    public void testGetNumArrivals() {
        assertEquals(0, arrivalBoard.getNumArrivals());
    }

    @Test
    public void testAddArrival() {
        Arrival arrival = new Arrival(100, "Beijing", "Platform3");

        arrivalBoard.addArrival(arrival);
        Arrival arrival1 = new Arrival(70, "Taiyuan", "Platform3");
        Arrival arrival2 = new Arrival(1999, "Changsha", "Platform3");
        Arrival arrival3 = new Arrival(50, "Taibei", "Platform3");

        arrivalBoard.addArrival(arrival1);
        arrivalBoard.addArrival(arrival2);
        arrivalBoard.addArrival(arrival3);

        assertEquals(arrivalBoard.getNumArrivals(), 4);
    }

    @Test
    public void testClearArrivals() {
        Arrival arrival = new Arrival(100, "Beijing", "Platform3");

        arrivalBoard.addArrival(arrival);

        assertEquals(arrivalBoard.getNumArrivals(), 1);

        arrivalBoard.clearArrivals();

        assertEquals(arrivalBoard.getNumArrivals(), 0);
    }


    @Test
    public void testEquals() {
        Line line = new Line(LineResourceData.BAKERLOO, "lol", "ahahah");

        ArrivalBoard arrivalBoard1 = new ArrivalBoard(line, "NorthWest");

        assertTrue(arrivalBoard.equals(arrivalBoard1));
    }





}
