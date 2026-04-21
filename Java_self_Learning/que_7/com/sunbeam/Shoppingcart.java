package com.sunbeam;

import java.util.ArrayList;
import java.util.HashMap;

public class Shoppingcart {
    private HashMap<Integer, Product> cart = new HashMap<>();
    private ArrayList<Product> history = new ArrayList<>();

    
    public void addProduct(Product p) {
        cart.put(p.getId(), p);
    }

    public void displayCart() {
        for (Product p : cart.values())
            System.out.println(p);
    }

    public void checkout() {
        history.addAll(cart.values());
        cart.clear();
        System.out.println("checkout done");
    }

    
    
    public void displayHistory() {
        for (Product p : history)
            System.out.println(p);
    }
}