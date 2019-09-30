/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esinf;

import esinf.BufferDocument;
import esinf.PriorityBufferPrinter;
import esinf.Document;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nunotmalheiro
 */
public class PriorityBufferPrinterTest {
    private ArrayList <Document> setDoc;
    private int maxSize;
    
    public PriorityBufferPrinterTest() {
    }    
    
    @Before
    public void setUp() {
        setDoc = new ArrayList<>();
        
        setDoc.add(new BufferDocument(2,100,"The Stone Raft", "Jose Saramago"));
        setDoc.add(new BufferDocument(1,200,"The Alchemist", "Paulo Coelho"));
        setDoc.add(new BufferDocument(3,400,"Descartes' Error", "Antonio Damasio"));
        
        setDoc.add(new BufferDocument(6,1800,"I, Robot", "Isaac Asimov"));
        setDoc.add(new BufferDocument(5,367,"The Zap Gun", "Philip K. Dick"));
        setDoc.add(new BufferDocument(4,897,"2001: A Space Odyssey", "Arthur C. Clarcke"));        
        
        setDoc.add(new BufferDocument(3,5100,"The Singularity is Near", "Ray Kurzweil"));
        setDoc.add(new BufferDocument(10,1200,"The Future of the Mind", "Michio Kaku"));
        setDoc.add(new BufferDocument(2,1400,"End Aging", "Aubrey de Grey"));
        
        // get the sum of all the sizes of the documents
        maxSize = setDoc.stream().mapToInt(Document::getSize).sum();
    }

    /**
     * Test of addDocument method, of class PriorityBufferPrinter.
     */
    @Test
    public void testAddDocument() {
        System.out.println("addDocument");
        
        PriorityBufferPrinter <Document> instance = new PriorityBufferPrinter <>(maxSize);
        
        // add all the documents in setDoc and validate the operation
        Boolean expResult = true;
        for (Document doc : setDoc) {
            Boolean result = instance.addDocument(doc);
            assertEquals("The buffer should contain space for the Document", expResult, result);
        }
        
        // check the priorities
        Document pdoc = null;
        for (Document doc: instance) {
            if (pdoc != null) assertTrue("The buffer should be ordered by priorities", (pdoc.getPriority()<=doc.getPriority()));
            pdoc = doc;
        }
        
        // optional println
        System.out.println(instance);
        
        // try to add a new Document to a full buffer
        expResult = false;
        Boolean result = instance.addDocument(new BufferDocument(12,2200,"On Intelligence", "Jeff Hawkins"));
        assertEquals("The buffer should now be full and no Document can be added", expResult, result);
    }    

     /**
     * Test of getDocument method, of class PriorityBufferPrinter.
     */
    @Test
    public void testGetDocument() {
        System.out.println("getDocument");
        
        PriorityBufferPrinter <Document> instance = new PriorityBufferPrinter <>(maxSize);
        
        // add all the documents in setDoc and validate the operation
        Boolean expResult = true;
        for (Document doc : setDoc) {
            Boolean result = instance.addDocument(doc);
            assertEquals("The buffer should contain space for the Document", expResult, result);
        }
        
        // Use the streams to order the document set and get an ordered array
        Document [] orderedSetDoc = setDoc.stream().sorted((e1,e2)->e2.compareTo(e1)).toArray(Document[]::new);
        
        for (int i=0; i<orderedSetDoc.length; i++) {
            Document d = instance.getDocument();
            assertTrue("Documents should be the same", (d.compareTo(orderedSetDoc[i])==0));
        }
    }

    /**
     * Test of delDocument method, of class PriorityBufferPrinter.
     */
    @Test
    public void testDelDocument() {
        System.out.println("delDocument");
        
        String name = "The Singularity is Near";
        String author = "Ray Kurzweil";
        PriorityBufferPrinter <Document> instance=new PriorityBufferPrinter <>(maxSize);
        
        // add all the documents in setDoc (functional stream style)
        setDoc.stream().forEach( doc -> instance.addDocument(doc) );
        
        // try to delete an existing Document
        Boolean expResult = true;
        Boolean result = instance.delDocument(name, author);
        assertEquals("Document exists and should be deleted", expResult, result);

        // try to delete a non existing Document
        expResult = false;
        name = "On Intelligence";
        author = "Jeff Hawkins";
        result = instance.delDocument(name, author);
        assertEquals("Document does not exist so it should not be deleted", expResult, result);        
    }

    /**
     * Test of delDocumentsAbove method, of class PriorityBufferPrinter.
     */
    @Test
    public void testDelDocumentsAbove() {
        System.out.println("delDocuments");
        
        Integer size = 1000;
        PriorityBufferPrinter <Document> instance=new PriorityBufferPrinter <>(maxSize);
        
        // add all the documents in setDoc (functional stream style)
        setDoc.stream().forEach( doc -> instance.addDocument(doc) );
        
        // Try the deletion of Documents above size 1000 and check the result
        Boolean expResult = true;
        Boolean result = instance.delDocumentsAbove(size);
        assertEquals("There should be documents above size 1000", expResult, result);
        
        // Actually check the deletion of Documents above size 1000
        for (Document doc: instance) {
            assertTrue("No document should be above size 1000", (doc.getSize()<=1000));
        }        
    }    
}
