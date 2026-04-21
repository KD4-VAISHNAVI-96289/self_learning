package com.sunbeam;

import java.util.Scanner;

public class Tester {
	 static Scanner sc = new Scanner(System.in);

	    public static int menuList() {
	        System.out.println("0.Exit 1.Add Product 2.View Cart 3.Checkout 4.History ");
	        return sc.nextInt();
	    }

	    public static void main(String[] args) {

	        Shoppingcart service = new Shoppingcart();
	        int ch;

	        while ((ch = menuList()) != 0) {

	            switch (ch) {

	                case 1:
	                    System.out.print("Enter id, name: ");
	                    service.addProduct(new Product(sc.nextInt(), sc.next()));
	                    break;

	                case 2:
	                    service.displayCart();
	                    break;

	                case 3:
	                    service.checkout();
	                    break;

	                case 4:
	                    service.displayHistory();
	                    break;
	            }
	        }
	    
	}

}
