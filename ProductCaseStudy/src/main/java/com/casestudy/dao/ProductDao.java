package com.casestudy.dao;

import java.sql.SQLException;
import java.util.List;

import com.casestudy.pojos.Product;

public interface ProductDao extends BaseDao {
	List<Product> getProductList(String category)throws SQLException;
}
