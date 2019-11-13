/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PL;

/**
 *
 * @author DEI-ESINF
 * @param <E>
 */
public class AVL <E extends Comparable<E>> extends BST<E> {
    
    
    private int balanceFactor(Node<E> node){
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private Node<E> rightRotation(Node<E> node){
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private Node<E> leftRotation(Node<E> node){
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private Node<E> twoRotations(Node<E> node){
        
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    private Node<E> balanceNode(Node<E> node)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void insert(E element){
        root = insert(element, root);
    }
    private Node<E> insert(E element, Node<E> node){
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override  
    public void remove(E element){
        root = remove(element, root());
    }

    private Node<E> remove(E element, BST.Node<E> node) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    public boolean equals(Object otherObj) {

        if (this == otherObj) 
            return true;

        if (otherObj == null || this.getClass() != otherObj.getClass())
            return false;

        AVL<E> second = (AVL<E>) otherObj;
        return equals(root, second.root);
    }

    public boolean equals(Node<E> root1, Node<E> root2) {
        if (root1 == null && root2 == null) 
           return true;
        else if (root1 != null && root2 != null) {
            if (root1.getElement().compareTo(root2.getElement()) == 0) {
                return equals(root1.getLeft(), root2.getLeft())
                        && equals(root1.getRight(), root2.getRight());
            } else  
                return false; 
        }
        else return false;
    }
   
}