/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PQExamples;

import Priority_queue.Entry;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author antoniosilva
 */
public class AirTrafficCCTest {

    AirTrafficCC instance;

    String[] flight = {"TP1926", "EZY1982", "FR4585", "TK1449", "FR4534", "TO3411", "IB3110", "TP1566", "LH1176", "EK191"};
    Integer[] priority = {30, 45, 21, 67, 34, 6, 78, 51, 39, 46};

    public AirTrafficCCTest() {
    }

    @Before
    public void setUp() {
        instance = new AirTrafficCC(priority, flight);
    }

    /**
     * Test of nextPlaneLanding method, of class AirTrafficCC.
     */
    @Test
    public void testNextPlaneLanding() {
        System.out.println("nextPlaneLanding");
        String result = instance.nextPlaneLanding();

        assertEquals("TO3411", result);
    }

    /**
     * Test of addPlane2Queue method, of class AirTrafficCC.
     */
    @Test
    public void testAddPlane2Queue() {
        System.out.println("addPlane2Queue");
        String id = "XXXXX";
        Integer pr = 1;
        Integer before = instance.nrPlanesWaiting();
        instance.addPlane2Queue(id, pr);
        Integer after = instance.nrPlanesWaiting();
        Integer newsize = before + 1;
        assertEquals(newsize, after);
        assertEquals(instance.nextPlaneLanding(), id);
    }

    /**
     * Test of clearPlane4Landing method, of class AirTrafficCC.
     */
    @Test
    public void testClearPlane4Landing() {
        System.out.println("clearPlane4Landing");

        Entry<Integer, String> plane = instance.clearPlane4Landing();
        String id = plane.getValue();

        assertEquals(id, "TO3411");

    }

    /**
     * Test of nrPlanesWaiting method, of class AirTrafficCC.
     */
    @Test
    public void testNrPlanesWaiting() {
        System.out.println("nrPlanesWaiting");

        Integer expResult = 10;
        Integer result = instance.nrPlanesWaiting();
        assertEquals(expResult, result);
    }

    /**
     * Test of time2land method, of class AirTrafficCC.
     */
    @Test
    public void testTime2land() {
        System.out.println("time2land");
        String id = "FR4534";

        Integer expResult = 15;
        Integer result = instance.time2land(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of changePriority2 method, of class AirTrafficCC.
     */
    @Test
    public void testChangePriority2() {
        System.out.println("changePriority2");
        String id = "LH1176";
        Integer newp = 3;

        instance.changePriority2(id, newp);
        String expResult = id;
        String result = instance.nextPlaneLanding();

        assertEquals(expResult, result);
    }

}
