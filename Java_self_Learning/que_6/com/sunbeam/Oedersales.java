package com.sunbeam;
class EcommerceException extends Exception {
    public EcommerceException(String msg) {
        super(msg);
    }
}


class PaymentException extends EcommerceException {
    public PaymentException(String msg) {
        super(msg);
    }
}

class InventoryException extends EcommerceException {
    public InventoryException(String msg) {
        super(msg);
    }
}

class ShippingException extends EcommerceException {
    public ShippingException(String msg) {
        super(msg);
    }
}
public class Oedersales {

	public void processOrder(double amount, int stock, String address) 
		throws PaymentException, InventoryException, ShippingException {

	        if (amount <= 0)
	            throw new PaymentException("invalid payy");

	        if (stock <= 0)
	            throw new InventoryException("Out of Stock");

	        if (address == null || address.isEmpty())
	            throw new ShippingException("invalid Addr");

	        System.out.println("order placed");
	    }

	}


