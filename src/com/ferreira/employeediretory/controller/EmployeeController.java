package com.ferreira.employeediretory.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ferreira.employeediretory.dao.EmployeeDAO;
import com.ferreira.employeediretory.dao.EmployeeDAOImp;
import com.ferreira.employeediretory.entity.Employee;

/**
 * Servlet implementation class EmployeeController
 */
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private EmployeeDAO employeeDAO;
	
	private static final String EMPLOYEE_LIST = "/view/employee-list.jsp";
	private static final String EMPLOYEE_ADD = "/view/employee-add.jsp";
	
	public EmployeeController() {
		employeeDAO = new EmployeeDAOImp();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		String action = request.getParameter("action");
		
		if(action == null) {
			action = "LIST";
		}
		
		switch(action) {
			case "LIST":
				listEmployees(request, response);
			break;
			
			case "EDIT":
				getSingleEmployee(request, response);
			break;
			
			case "DELETE":
				deleteEmployee(request, response);
			break;
			
			default:
				listEmployees(request, response);
				break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");		

		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String designation = request.getParameter("designation");
		
		Employee employee = new Employee();
		employee.setName(name);
		employee.setDob(dob);
		employee.setDepartament(designation);
		
		if(id == null || id.isEmpty()) {
			if(employeeDAO.save(employee)) {
				request.setAttribute("message", "Saved successFully");
			}
		}else {
			employee.setId(Long.parseLong(id));
			if(employeeDAO.update(employee)) {
				request.setAttribute("message", "updated successFully");
			}
		}
		
		listEmployees(request, response);
	}
	
	private void listEmployees(HttpServletRequest request, HttpServletResponse response){

		try {
			request.setAttribute("list", employeeDAO.getList());		
		
			request.getRequestDispatcher(EMPLOYEE_LIST).forward(request, response);
			
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	private void getSingleEmployee(HttpServletRequest request, HttpServletResponse response) {
		
		try {			
			String id = request.getParameter("id");
			
			Employee employee = employeeDAO.get(Long.parseLong(id));
			
			request.setAttribute("employee", employee);
			
			request.getRequestDispatcher(EMPLOYEE_ADD).forward(request, response);
		}catch(IOException  | ServletException e ) {
			e.printStackTrace();
		}
	}
	
	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
		
		String id = request.getParameter("id");
		
		if(employeeDAO.delete(Long.parseLong(id))) {
			request.setAttribute("message", "Record has been deleted!");
		}
		
		listEmployees(request, response);
	}

}
