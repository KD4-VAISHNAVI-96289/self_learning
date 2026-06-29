package com.casestudy.pojos;

import lombok.*;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class Product {
	long product_id;
	String product_name;
	double price;
	int stock;
}
