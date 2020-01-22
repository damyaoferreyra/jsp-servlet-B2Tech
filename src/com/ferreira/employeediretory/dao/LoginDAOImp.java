package com.ferreira.employeediretory.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.ferreira.employeediretory.entity.Login;
import com.ferreira.employeediretory.util.DBConnectionUtil;

/**
 * @author ferreira
 * @since 18/01/2020
 */
public class LoginDAOImp implements LoginDAO{

	@Override
	public String authenticate(Login login) {
		String sql = "SELECT * from tbl_login where email=? and password=?";
		
		try {
			Connection connection = DBConnectionUtil.openConnection();
			PreparedStatement preparedStatement =connection.prepareStatement(sql);
			preparedStatement.setString(1, login.getEmail());
			preparedStatement.setString(2, login.getPassword());
			
			if(preparedStatement.executeQuery().next()) {
				return "true";
			}else {
				return "false";
			}
		}catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

}
