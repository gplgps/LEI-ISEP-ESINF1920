/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esinf;

import java.time.LocalDate;
import java.util.*;

/**
 *
 * @author DEI-ISEP
 */
public class Supermarket {
    Map <Invoice, Set<Product>> m;
    
    Supermarket() {
        m = new HashMap<>();
    }
    
    // Reads invoices from a list of String
    void getInvoices(List <String> l) throws Exception {
        Invoice invoice = null;
        Set<Product> productSet= null;
        for (String line : l){
            if (line.trim().charAt(0) == 'I'){
                if (invoice != null){
                    m.put(invoice, productSet);
                }
                String[] temp = line.split(",");
                invoice = new Invoice(temp[1],temp[2]);
                productSet = new HashSet<>();
            }
            if (line.trim().charAt(0) == 'P'){
                String[] temp = line.trim().split(",");
                Product product = new Product(temp[1], Integer.parseInt(temp[2]), Long.parseLong(temp[3]));
                productSet.add(product);
            }
        }
        m.put(invoice, productSet);
    }   
    // returns a set in which each number is the number of products in the r
    // invoice 
    Map<Invoice, Integer> numberOfProductsPerInvoice() {
        Map<Invoice, Integer> productPerInvoice = new HashMap<>();
        for (Invoice inv : m.keySet()){
            Set<Product> productSet = m.get(inv);
            Integer nProducts = productSet.size();
            productPerInvoice.put(inv, nProducts);
        }
        return productPerInvoice;
    }

    // returns a Set of invoices in which each date is >d1 and <d2
    Set <Invoice> betweenDates(LocalDate d1, LocalDate d2) {
        Set<Invoice> invSet = new HashSet<>();
        for(Invoice inv : m.keySet()){
            if (inv.getDate().compareTo(d1) > 0 && inv.getDate().compareTo(d2) < 0){
                invSet.add(inv);
            }
        }
        return invSet;
    }
    
    // returns the sum of the price of the product in all the invoices
    long totalOfProduct(String productId) {
        long sum = 0;
        for (Invoice inv : m.keySet()){
            Set<Product> productSet = m.get(inv);
            for (Product prod : productSet){
                if (productId.equals(prod.getIdentification())){
                    sum += prod.getPrice() * prod.getQuantity();
                }
            }
        }
        return sum;
    }
    
    // converts a map of invoices and traduces to a map which key is a product
    // identification and the values are a set of the invoice references 
    // in which it appears
    Map <String, Set<Invoice>> convertInvoices() {
        Map <String, Set<Invoice>> invertedMap = new HashMap<>();
        for (Invoice inv : m.keySet()) {
            Set<Product> productSet = m.get(inv);
            for (Product prod : productSet){
                if (invertedMap.containsKey(prod.getIdentification())){
                    invertedMap.get(prod.getIdentification()).add(inv);
                } else {
                    Set<Invoice> invoiceSet = new HashSet<>();
                    invoiceSet.add(inv);
                    invertedMap.put(prod.getIdentification(), invoiceSet);
                }
            }
        }

        return invertedMap;
    }
}
