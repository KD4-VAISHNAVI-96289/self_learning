package com.casestudy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.casestudy.pojos.Product;
import com.casestudyutils.DbUtils;

public class ProductDaoImpl implements ProductDao {
	Connection connection;
	PreparedStatement pst1;
	
	public ProductDaoImpl() throws SQLException {
		connection=DbUtils.getConnection();
		pst1=connection.prepareStatement("select p.product_id , p.product_name , p.price , p.stock from products p inner join categories c on p.category_id=c.category_id where category_name=?");
	}
	
	@Override
	public void cleanUp() {
		// TODO Auto-generated method stub
	}

	@Override
	public List<Product> getProductList(String category) throws SQLException {
		List<Product>list=new ArrayList<>();
		pst1.setString(1, category);
		ResultSet rs=pst1.executeQuery();
		while(rs.next()) {
			System.out.print("fff");

			System.out.print(rs.getLong(1)+" "+rs.getString(2)+" "+rs.getDouble(3)+" "+rs.getInt(4));
			list.add(new Product(rs.getLong(1),rs.getString(2),rs.getDouble(3),rs.getInt(4)));
		}
		System.out.print(list);
		return list;
	}

}
