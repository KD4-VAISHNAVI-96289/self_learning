package com.casestudy.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.casestudy.dao.CategoryDao;
import com.casestudy.dao.CategoryDaoImpl;
import com.casestudy.pojos.Categories;

/**
 * Servlet implementation class CategoryList
 */
@WebServlet("/categorylist")
public class CategoryList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CategoryDao categoryDao;
    /**
     * @throws SQLException 
     * @see HttpServlet#HttpServlet()
     */
    public CategoryList() throws SQLException {
    	categoryDao=new CategoryDaoImpl();
    	// TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Categories> list=categoryDao.getCategories();
			request.setAttribute("list", list);
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/home.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
