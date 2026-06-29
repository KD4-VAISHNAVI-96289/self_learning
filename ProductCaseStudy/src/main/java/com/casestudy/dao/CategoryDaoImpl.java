package com.casestudy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.casestudy.pojos.Categories;
import com.casestudyutils.DbUtils;

public class CategoryDaoImpl implements CategoryDao {
	Connection connection;
	PreparedStatement pst;
	
	public CategoryDaoImpl() throws SQLException{
		connection=DbUtils.getConnection();
		pst=connection.prepareStatement("select category_id,category_name from categories");
	}

	@Override
	public void cleanUp() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Categories> getCategories() throws SQLException {
		List<Categories> list=new ArrayList<>();
		ResultSet rs=pst.executeQuery();
		while(rs.next()) {
			list.add(new Categories(rs.getLong(1),rs.getString(2)));
		}
		return list;
	}

}
