
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

   /**
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
        if (node.getRight() != null){
            desSubtree(node.getRight(), snapshot);
        }
        snapshot.add(node.getElement());
        if (node.getLeft() != null){
            desSubtree(node.getLeft(), snapshot);
        }
    }
   
    /**
    * Returns the tree without leaves.
    * @return tree without leaves
    */
    public BST<E> autumnTree() {
        TREE<E> autumnTree = new TREE<>();
        autumnTree.root = copyRec(this.root);
        return autumnTree;
    }
    
    private Node<E> copyRec(Node<E> node){
        if (node == null) return null;
        if (!isLeaf(node.getElement())) return new Node<>(node.getElement(), copyRec(node.getLeft()), copyRec(node.getRight()));
        return null;
    }
    
    /**
    * @return the the number of nodes by level.
    */
    public int[] numNodesByLevel(){
        int[] nodesByLevel = new int[this.height() + 1];
        numNodesByLevel(root, nodesByLevel, 0);
        return nodesByLevel;
    }
    
    private void numNodesByLevel(Node<E> node, int[] result, int level){
        if (node == null) return;
        result[level]++;
        numNodesByLevel(node.getLeft(), result, level + 1);
        numNodesByLevel(node.getRight(), result, level + 1);
    }

}
