/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PL;

import java.util.Arrays;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DEI-ESINF
 */
public class AVLTest {
    
    public AVLTest() {
    }
    
      /**
     * Test of insert method, of class AVL.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        
        //test Simple right rotation 
        AVL<Integer> instance = new AVL();
        int arr[] = {8,4,10,2,6,3};
        Integer[] inorder1={2,3,4,6,8,10};
        for (int i=0; i<arr.length; i++)            //new elements
            instance.insert(arr[i]);
        
        List<Integer> lExpected = Arrays.asList(inorder1);           
        assertEquals("inOrder should be "+lExpected.toString(), lExpected, instance.inOrder());
        System.out.println("<instance 1>");
        System.out.println(instance);
        System.out.println("height1="+instance.height());
        System.out.println("------------------------------------");

        //test Simple left rotation
        AVL<Integer> instance2 = new AVL();
        int arr2[] = {8,4,10,9,15,12};
        Integer[] inorder2={4,8,9,10,12,15};
        for (int i=0; i<arr2.length; i++)          
            instance2.insert(arr2[i]);
        System.out.println("<instance 2>");
        System.out.println(instance2);
        System.out.println("height2="+instance2.height());
        lExpected = Arrays.asList(inorder2);
        assertEquals("inOrder should be "+lExpected.toString(), lExpected, instance2.inOrder());
        assertEquals("height should be 2 ",instance2.height(), 2);
        System.out.println("------------------------------------");
        
        //test double rotation 
        AVL<Integer> instance3 = new AVL();
        int arr3[] = {8,4,10,2,6,5};
        Integer[] inorder3={2,4,5,6,8,10};
        for (int i=0; i<arr3.length; i++)          
            instance3.insert(arr3[i]);
        System.out.println("<instance 3>");
        System.out.println(instance3);
        System.out.println("height3="+instance3.height());
        lExpected = Arrays.asList(inorder3);
        assertEquals("inOrder should be "+lExpected.toString(), lExpected, instance3.inOrder());
        assertEquals("height should be 2 ",instance3.height(), 2);       
        System.out.println("------------------------------------");
    }
      /**
     * Test of remove method, of class AVL.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        List<Integer> lExpected;
        AVL<Integer> instance;
        
        instance = new AVL();
        int arr[] = {8,4,10,2,6,3};
        for (int i=0; i<arr.length; i++)            
            instance.insert(arr[i]);
        

        //no rotations needed
        instance.remove(3);
        lExpected = Arrays.asList(2,4,6,8,10);           
        assertEquals("inOrder should be "+lExpected.toString(), lExpected, instance.inOrder());
        assertEquals("height should be 2 ",instance.height(), 2);       

        //test Simple left rotation 
        instance.remove(2);
        lExpected = Arrays.asList(4,6,8,10);           
        assertEquals("inOrder should be "+lExpected.toString(), lExpected, instance.inOrder());
        assertEquals("height should be 2 ",instance.height(), 2);       

        instance.remove(10);
        lExpected = Arrays.asList(4,6,8);           
        assertEquals("inOrder should be "+lExpected.toString(), lExpected, instance.inOrder());
        assertEquals("height should be 1 ",instance.height(), 1);       

        instance.remove(6);
        lExpected = Arrays.asList(4,8);           
        assertEquals("inOrder should be "+lExpected.toString(), lExpected, instance.inOrder());
        assertEquals("height should be 1 ", 1, instance.height());       

        instance.remove(4);
        lExpected = Arrays.asList(8);           
        assertEquals("inOrder should be "+lExpected.toString(), lExpected, instance.inOrder());
        assertEquals("height should be 1 ", 0, instance.height());       

        instance.remove(8);
        lExpected = Arrays.asList();           
        assertEquals("inOrder should be "+lExpected.toString(), lExpected, instance.inOrder());
        assertEquals("height should be 1 ", -1, instance.height());       

        System.out.println("------------------------------------");
    }
    
     @Test
    public void testEquals() {
        System.out.println("equals");
        AVL<Integer> instance = new AVL();
        int arr[] = {1, 8};
        for (int i = 0; i < arr.length; i++)
        {
            instance.insert(arr[i]);
        }
        AVL<Integer> instance2 = new AVL();
        int arr2[] = {1, 8};
        for (int i = 0; i < arr2.length; i++) 
        {
            instance2.insert(arr2[i]);
        }
        assertTrue("equals! ", instance.equals(instance2));
        instance2.remove(8);
        assertFalse("equals! ", instance.equals(instance2));
    }
}
