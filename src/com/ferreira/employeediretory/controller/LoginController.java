package com.ferreira.employeediretory.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ferreira.employeediretory.dao.LoginDAOImp;
import com.ferreira.employeediretory.entity.Login;

/**
 * @author ferreira
 *
 */
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 4656256880693050661L;

	private LoginDAOImp loginDAOImp;
	
	private final String LOGIN_TRUE = "EmployeeController?action=LIST";

	private final String LOGIN_FALSE = "index.jsp?status=false";

	private final String LOGIN_ERROR = "index.jsp?status=error";
	
	public LoginController() {
		loginDAOImp = new LoginDAOImp();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		Login login = new Login(req.getParameter("email"), req.getParameter("password"));

		switch (loginDAOImp.authenticate(login)) {
			case "true":
				session.setAttribute("email", login.getEmail());
				resp.sendRedirect(LOGIN_TRUE);
				break;
			case "false":
				resp.sendRedirect(LOGIN_FALSE);
				break;
			default:
				resp.sendRedirect(LOGIN_ERROR);
		}

	}
}
