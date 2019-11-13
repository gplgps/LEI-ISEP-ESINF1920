
package PL;

import java.util.*;

/*
 * @author DEI-ESINF
 * @param <E>
 */

public class TREE<E extends Comparable<E>> extends BST<E>{
 
   /*
   * @param element A valid element within the tree
   * @return true if the element exists in tree false otherwise
   */   
    public boolean contains(E element) {
        if (element == null)
            return false;
        else if (find(element, root) != null){
            return true;
        }
        return false;
    }

 
    public boolean isLeaf(E element){
        if (element == null)
            return false;
        else {
            Node<E> node = find(element, root);
            if (node == null){
                return false;
            }
            if (node.getLeft() == null && node.getRight() == null){
                return true;
            }
        }
        return false;
    }

   /*
   * build a list with all elements of the tree. The elements in the 
   * left subtree in ascending order and the elements in the right subtree 
   * in descending order. 
   *
   * @return    returns a list with the elements of the left subtree 
   * in ascending order and the elements in the right subtree is descending order.
   */
    public Iterable<E> ascdes(){
        List<E> nodeList = new ArrayList<>();
        if (root != null) {
            ascSubtree(root.getLeft(), nodeList);
            nodeList.add(root.getElement());
            desSubtree(root.getRight(), nodeList);
        }
        return nodeList;
    }

    private void ascSubtree(Node<E> node, List<E> snapshot) {
        if (node == null) return;
        if (node.getLeft() != null){
            ascSubtree(node.getLeft(), snapshot);
        }
        snapshot.add(node.getElement());
        if (node.getRight() != null){
            ascSubtree(node.getRight(), snapshot);
        }
    }
    
    private void desSubtree(Node<E> node, List<E> snapshot) {
        if (node == null) return;
        if (node.getLeft() != null){
            desSubtree(node.getLeft(), snapshot);
        }
        snapshot.add(node.getElement());
        if (node.getRight() != null){
            desSubtree(node.getRight(), snapshot);
        }
    }
   
    /**
    * Returns the tree without leaves.
    * @return tree without leaves
    */
    public BST<E> autumnTree() {
           throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private Node<E> copyRec(Node<E> node){
           throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
    * @return the the number of nodes by level.
    */
    public int[] numNodesByLevel(){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private void numNodesByLevel(Node<E> node, int[] result, int level){
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
