package com.jsp.Jdbc_PreparedStatement_Crud.controller;
import java.sql.Connection;
import java.sql.DriverManager;

public class demo {

	public static void main(String[] args) {
		 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-preparedstatement")
		}
		catch (Exception e) {
			 
		}
	}

}
