/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Priority_queue;

/**
 * Interface for a key-value pair.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public interface Entry<K, V> {
    /**
     * Returns the key stored in this entry.
     *
     * @return the entry's key
     */
    K getKey();

    /**
     * Returns the value stored in this entry.
     *
     * @return the entry's value
     */
    V getValue();
}
