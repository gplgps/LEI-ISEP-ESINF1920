/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esinf;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author DEI-ISEP
 * @param <E> Generic type of buffer element
 */
public class PriorityBufferPrinter<E extends Document> implements Iterable<E> {

    private final ArrayList<E> buffer;
    private final Integer maxSize;

    /**
     * Creates a new PriorityBufferPrinter with a maximum buffer size maxSize
     * 
     * @param maxSize maximum buffer size
     */
    public PriorityBufferPrinter(Integer maxSize) {
        buffer = new ArrayList<>(); // Diamond notation: the type can be inferred by the compiler
        this.maxSize = maxSize;
    }

    /**
     * Adds a document to the buffer.Documents are added using a numeric priority system, being FIFO when priorities are equal.
     * 
     * @param doc   the document to be added to the buffer
     * @return      true if the buffer has space, false otherwise
     */
    public Boolean addDocument(E doc) {
        int usedSize = 0;
        for (E d: this.buffer){
            usedSize += d.getSize();
        }
        if (this.maxSize < usedSize + doc.getSize())    return false;
        for (E d : this.buffer){
            if (doc.getPriority() < d.getPriority()){
                buffer.add(buffer.indexOf(d), doc);
                return true;
            }
        }
        buffer.add(doc);
        return true;
    }
    
     /**
     * Gets the next document in the queue.
     * 
     * @return The next document in the queue
     */
    public E getDocument() {
        E temp = this.buffer.get(0);
        this.buffer.remove(0);
        return temp;
    } 

    /**
     * Deletes a document from the buffer (if it exists), given a name and an author 
     * 
     * @param name      the name of the Document
     * @param author    the author of the Document
     * @return          true if the document existed, false otherwise
     */
    public Boolean delDocument(String name, String author) {
        for(E d : this.buffer){
            if (d.getName().equals(name) && d.getAuthor().equals(author)){
                this.buffer.remove(d);
                return true;
            }
        }
        return false;
    }

    /**
     * Deletes all the documents which are superior to a given size
     * 
     * @param size  the size above which documents will be deleted
     * @return      true if there is at least one Document size
     */
    public Boolean delDocumentsAbove(Integer size) {
        Boolean removed = false;
        ArrayList<E> temp = new ArrayList<>(buffer);
        for (E d : temp){
            if (d.getSize() > size){
                this.buffer.remove(d);
                removed = true;
            }
        }
        return removed;
    }

    @Override
    public String toString() {
        return "Buffer: "+ this.buffer.toString() + "\nMax Size: " + this.maxSize;
    }

    @Override
    public Iterator<E> iterator() {
        return buffer.iterator();
    }

}
