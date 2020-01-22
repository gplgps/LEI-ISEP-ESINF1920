/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Priority_queue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author antoniosilva
 */
public class HeapPriorityQueueTest {

    HeapPriorityQueue<Integer, String> instance;

    Integer[] keys = {20, 15, 10, 13, 8, 12, 40, 30, 5, 21};
    String[] values = {"vinte", "quinze", "dez", "treze", "oito", "doze", "quarenta", "trinta", "cinco", "vinteeum"};

    public HeapPriorityQueueTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new HeapPriorityQueue(keys, values);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of parent method, of class HeapPriorityQueue.
     */
    @Test
    public void testParent() {
        System.out.println("parent");

        assertEquals(instance.parent(8), 3);
        assertEquals(instance.parent(2), 0);
    }

    /**
     * Test of left method, of class HeapPriorityQueue.
     */
    @Test
    public void testLeft() {
        System.out.println("left");
        int j = 4;

        int expResult = 9;
        int result = instance.left(j);
        assertEquals(expResult, result);

    }

    /**
     * Test of right method, of class HeapPriorityQueue.
     */
    @Test
    public void testRight() {
        System.out.println("right");
        int j = 1;

        int expResult = 4;
        int result = instance.right(j);
        assertEquals(expResult, result);

    }

    /**
     * Test of hasLeft method, of class HeapPriorityQueue.
     */
    @Test
    public void testHasLeft() {
        System.out.println("hasLeft");
        int j = 3;
        int k = 12;

        boolean expResult = true;
        boolean result = instance.hasLeft(j);
        assertEquals(expResult, result);

        expResult = false;
        result = instance.hasLeft(k);
        assertEquals(expResult, result);

    }

    /**
     * Test of hasRight method, of class HeapPriorityQueue.
     */
    @Test
    public void testHasRight() {
        System.out.println("hasRight");
        int j = 0;
        int k = 4;

        boolean expResult = true;
        boolean result = instance.hasRight(j);
        assertEquals(expResult, result);

        expResult = false;
        result = instance.hasRight(k);
        assertEquals(expResult, result);
    }

    /**
     * Test of swap method, of class HeapPriorityQueue.
     */
    @Test
    public void testSwap() {
        System.out.println("swap");
        int i = 0;
        int j = 3;

        instance.swap(i, j);
        Entry<Integer, String> pq = instance.min();
        Integer k = pq.getKey();

        assertEquals(k, Integer.valueOf(13));

    }

    /**
     * Test of percolateUp method, of class HeapPriorityQueue is indirectly
     * performed by the test of the insert method
     */
    @Test
    public void testPercolateUp() {

    }

    /**
     * Test of percolateDown method, of class HeapPriorityQueue is indirectly
     * performed by the test of the removeMin method
     */
    @Test
    public void testPercolateDown() {

    }

    /**
     * Test of heapify method, of class HeapPriorityQueue is indirectly
     * performed by the test setUp method
     */
    @Test
    public void testBuildHeap() {

    }

    /**
     * Test of size method, of class HeapPriorityQueue
     */
    @Test
    public void testSize() {
        System.out.println("size");

        int expResult = 10;
        int result = instance.size();
        assertEquals(expResult, result);

    }

    /**
     * Test of min method, of class HeapPriorityQueue.
     */
    @Test
    public void testMin() {
        System.out.println("min");

        Entry<Integer, String> pq = instance.min();
        Integer k = pq.getKey();
        String v = pq.getValue();

        assertEquals(Integer.valueOf(5),k);
        assertEquals("cinco", v);
    }

    /**
     * Test of insert method, of class HeapPriorityQueue.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        instance.insert(3, "tres");

        Entry<Integer, String> pq = instance.min();
        Integer k = pq.getKey();
        String v = pq.getValue();

        assertEquals(v, "tres");

        String s = instance.toString();
        System.out.println(s);

    }

    /**
     * Test of removeMin method, of class HeapPriorityQueue.
     */
    @Test
    public void testRemoveMin() {
        System.out.println("removeMin");

        Entry<Integer, String> pq1 = instance.removeMin();
        String v1 = pq1.getValue();

        assertEquals(v1, "cinco");

        Entry<Integer, String> pq2 = instance.min();
        String v2 = pq2.getValue();

        assertEquals(v2, "oito");

        String s = instance.toString();
        System.out.println(s);

    }

    @Test
    public void toStringTest() {
        System.out.println("toString");

        String s = instance.toString();
        System.out.println(s);
    }

    @Test
    public void testClone() {
        System.out.println("Clone");

        HeapPriorityQueue<Integer, String> temp = new HeapPriorityQueue<>();

        temp = instance.clone();
        System.out.println(temp.toString());

    }

}
