package com.ferreira.employeediretory.dao;

import java.util.List;

import com.ferreira.employeediretory.entity.Employee;

public interface EmployeeDAO {

	List<Employee> getList();
	
	boolean save(Employee e);
	
	boolean delete(long id);

	boolean update(Employee e);

	Employee get(long id);
	
}
