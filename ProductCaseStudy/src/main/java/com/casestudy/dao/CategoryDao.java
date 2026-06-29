package com.casestudy.dao;

import java.sql.SQLException;
import java.util.List;

import com.casestudy.pojos.Categories;

public interface CategoryDao extends BaseDao {
	List<Categories> getCategories() throws SQLException;
}
