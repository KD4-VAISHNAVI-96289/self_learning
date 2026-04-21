package com.sunbeam;
import java.util.Scanner;

public class Tester {
	public static void main(String[] args) {

		
	Scanner sc = new Scanner(System.in);
	Oedersales service = new Oedersales();

	
	
	
	        try {
	            System.out.print("enter amount: ");
	            double amount = sc.nextDouble();
	            System.out.print("enter stock: ");
	            int stock = sc.nextInt();
	            sc.nextLine(); 
	            System.out.print("enter address: ");
	            String address = sc.nextLine();

	            
	            service.processOrder(amount, stock, address);

	        } catch (EcommerceException e) {
	            System.out.println("error: " + e.getMessage());
	      }
	}
}