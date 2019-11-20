
package PL;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DEI-ESINF
 */
public class Utils {
    public static <E extends Comparable<E>> Iterable<E> sortByBST(List<E> listUnsorted){
        BST<E> BSTTree = new BST<>();
        for (E element : listUnsorted){
            BSTTree.insert(element);
        }
        return BSTTree.inOrder();
    }    
}
