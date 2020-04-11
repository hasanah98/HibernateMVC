package com.sjbb.service;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sjbb.controller.admin.user.ListUsersServlet;
import com.sjbb.dao.UserDAO;
import com.sjbb.entity.Users;

public class UserServices {

	private EntityManager entityManager;
	private UserDAO userDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;

	public UserServices(EntityManager entityManager, HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		this.entityManager=entityManager;
		userDAO = new UserDAO(entityManager);

	}

	public void listUser() throws ServletException, IOException {
		listUser(null);
	}

	public void listUser(String message) throws ServletException, IOException {
		List<Users> listUsers = userDAO.listAll();

		request.setAttribute("listUsers", listUsers);

		if (message != null) {
			request.setAttribute("message", message);
		}

		String listPage = "users_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);

		requestDispatcher.forward(request, response);

		// return listUsers;
	}

	public void createUser() throws ServletException, IOException {
		String email = request.getParameter("txtemail");
		String nameCust = request.getParameter("txtname");
		String password = request.getParameter("pass");

		Users existUser = userDAO.findByEmail(email);

		if (existUser != null) {
			String message = "Existing email, Try again";

			request.setAttribute("message", message);
			RequestDispatcher dispatcher = request.getRequestDispatcher("message.jsp");
			dispatcher.forward(request, response);

		} else {

			Users newUser = new Users(email, nameCust, password);
			userDAO.create(newUser);

			listUser("New user add successfully");

		}

	}

	public void editUser() throws ServletException, IOException {

		Integer idCust = Integer.parseInt(request.getParameter("id"));
		Users user = userDAO.get(idCust);

		// System.out.println(user.getNameCust());
		String editPage = "user_form.jsp";
		request.setAttribute("user", user);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
		requestDispatcher.forward(request, response);
	}

	public void updateUser() throws ServletException, IOException {

		// retrieve data from user update form
		int idCust = Integer.parseInt(request.getParameter("idCust"));
		String email = request.getParameter("txtemail");
		String nameCust = request.getParameter("txtname");
		String password = request.getParameter("pass");

		// System.out.println(idCust + "," + email + "," + nameCust + "," + password);

		Users userById = userDAO.get(idCust);

		Users userByEmail = userDAO.findByEmail(email);

		if (userByEmail != null && userByEmail.getIdCust() != userById.getIdCust()) {

			String message = "Could not update profile, user with email " + email + " existing";
			request.setAttribute("message", message);

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
			requestDispatcher.forward(request, response);
		} else {
			Users user = new Users(idCust, email, nameCust, password);
			userDAO.update(user);

			// call listUser to refresh then
			String message = "User update succesfully";
			listUser(message);
		}

	}

	public void deleteUser() throws ServletException, IOException {
		int idCust = Integer.parseInt(request.getParameter("id"));
		userDAO.delete(idCust);

		String message = "User has been delete successfully";
		listUser(message);

	}

}
