package com.ferreira.employeediretory.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ferreira.employeediretory.entity.Employee;
import com.ferreira.employeediretory.util.DBConnectionUtil;

public class EmployeeDAOImp implements EmployeeDAO{

	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement preparedStatement;
	
	@Override
	public List<Employee> getList() {
		
		List<Employee> employeeList = new ArrayList<>();
		String sql = "SELECT * FROM tbl_employee";
		
		try {
			connection = DBConnectionUtil.openConnection();
			
			statement = connection.createStatement();		
			
			resultSet = statement.executeQuery(sql);
			
			while(resultSet.next()) {
				Employee employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setDepartament(resultSet.getString("department"));
				employee.setDob(resultSet.getString("dob"));
				employeeList.add(employee);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			employeeList = new ArrayList<Employee>();
		}
		
		return employeeList;
	}
	@Override
	public boolean save(Employee e) {
		
		try {
			String sql = "INSERT INTO tbl_employee (name, dob, department) "
					+ "values('"+e.getName()+"', '"+e.getDob()+"','"+e.getDepartament()+"')";
			connection = DBConnectionUtil.openConnection();
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}

		return true;
	}
	@Override
	public Employee get(long id) {
		
		Employee employee = new Employee();
		try {
			
				String sql = "SELECT * FROM tbl_employee where id = '"+id+"'";
				
				connection = DBConnectionUtil.openConnection();
				statement = connection.createStatement();
				resultSet = statement.executeQuery(sql);
				
				while(resultSet.next()) {
					employee.setId(resultSet.getLong("id"));
					employee.setName(resultSet.getString("name"));
					employee.setDob(resultSet.getString("dob"));
					employee.setDepartament(resultSet.getString("department"));
				}
			
			}catch(SQLException | ClassNotFoundException sqe) {
				sqe.printStackTrace();
				employee = new Employee();
			}
		
		return employee;
	}
	
	@Override
	public boolean delete(long id) {
		
		
		try {
			connection = DBConnectionUtil.openConnection();
			return connection.createStatement().execute("DELETE FROM tbl_employee where id = '"+id+"'");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean update(Employee e) {
		try {
			connection = DBConnectionUtil.openConnection();
			String sql = "UPDATE tbl_employee set name = '"+e.getName()+"', department = '"
					+e.getDepartament()+"', dob = '"+e.getDob()+"' WHERE id = '"+e.getId()+"';";
			connection.prepareStatement(sql).executeUpdate();
			
			return true;
		} catch (SQLException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
	}
	

}
