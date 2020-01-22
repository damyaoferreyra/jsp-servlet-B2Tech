package com.ferreira.employeediretory.dao;

import com.ferreira.employeediretory.entity.Login;

public interface LoginDAO {

	String authenticate(Login login);
}
