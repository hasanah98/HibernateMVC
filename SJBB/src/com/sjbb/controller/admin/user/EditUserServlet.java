package com.sjbb.controller.admin.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sjbb.controller.admin.BaseServlet;
import com.sjbb.service.UserServices;

@WebServlet("/admin/edit_user")
public class EditUserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
   
    public EditUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
			UserServices userServices= new UserServices(entityManager,request, response);
			userServices.editUser();
	}

	

}
