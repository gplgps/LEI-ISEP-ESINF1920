/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esinf;

/**
 *
 * @author nunotmalheiro
 */
public interface Document extends Comparable <Document> {
    Integer getPriority();
    Integer getSize();
    String getName();
    String getAuthor();
}
