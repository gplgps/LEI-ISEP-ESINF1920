/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PQExamples;

import Priority_queue.Entry;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static PQExamples.PrintQueue.Document;

import java.util.Iterator;
import java.util.List;

/**
 * @author user
 */
public class PrintQueueTest {

    PrintQueue instance;
    List<Document> ld;
    List<Integer> lp;

    List<Document> ldo;
    List<Integer> lpo;

    Double timeslot = 2.0;
    List<Double> ltp;

    public PrintQueueTest() {
    }

    @Before
    public void setUp() {
        instance = new PrintQueue();
        ld = Arrays.asList(new Document(1, 10), new Document(2, 20), new Document(3, 30),
                new Document(4, 40), new Document(5, 50), new Document(6, 60));
        lp = Arrays.asList(12, 5, 20, 60, 39, 19);

        ldo = Arrays.asList(new Document(2, 20), new Document(1, 10), new Document(6, 60),
                new Document(3, 30), new Document(5, 50), new Document(4, 40));
        lpo = Arrays.asList(5, 12, 19, 20, 39, 60);

        ltp = Arrays.asList(0 * timeslot, 20 * timeslot, (20 + 10) * timeslot, (20 + 10 + 60) * timeslot, (20 + 10 + 60 + 30) * timeslot, (20 + 10 + 60 + 30 + 50) * timeslot);
    }

    /**
     * Test of addDoc2Queue, send2Printer, nextDoc2Print  method, of class PrintQueue.
     */
    @Test
    public void testAddDoc2Queue() {
        System.out.println("addDoc2Queue, send2Printer, nextDoc2Print");

        // addDoc2Queue
        Iterator<Document> itd = ld.iterator();
        Iterator<Integer> itp = lp.iterator();
        while (itd.hasNext() && itp.hasNext()) {
            assertTrue(instance.addDoc2Queue(itp.next(), itd.next()));
        }

        // send2Printer, nextDoc2Print
        itd = ldo.iterator();
        itp = lpo.iterator();
        while (instance.nextDoc2Print() != null) {
            Document nextDoc = itd.next();
            Integer nextPrio = itp.next();

            assertEquals(nextDoc, instance.nextDoc2Print());
            Entry<Integer, Document> e = instance.send2Printer();
            assertEquals(nextDoc, e.getValue());
            assertEquals(nextPrio, e.getKey());
        }
        assertEquals(null, instance.send2Printer());
        assertFalse(itd.hasNext());
        assertFalse(itp.hasNext());
    }

    /**
     * Test of time2print method, of class PrintQueue.
     */
    @Test
    public void testTime2print() {
        System.out.println("time2print");

        Iterator<Document> itd = ld.iterator();
        Iterator<Integer> itp = lp.iterator();
        while (itd.hasNext() && itp.hasNext()) {
            assertTrue(instance.addDoc2Queue(itp.next(), itd.next()));
        }

        itd = ldo.iterator();
        Iterator<Double> itt = ltp.iterator();
        while (itd.hasNext() && itt.hasNext()) {
            assertEquals(itt.next(), instance.time2print(itd.next(), timeslot));
        }

        assertEquals((Double) Double.MAX_VALUE, instance.time2print(new Document(10010, 10010), timeslot));
    }
}
