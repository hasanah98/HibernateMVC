package com.sjbb.controller.admin.category;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sjbb.controller.admin.BaseServlet;
import com.sjbb.service.CategoryServices;

@WebServlet("/admin/list_category")
public class ListCatServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	public ListCatServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		response.getWriter().println("List Category");
		CategoryServices categoryServices = new CategoryServices(entityManager, request, response);
		categoryServices.listCategory();

	}

}
