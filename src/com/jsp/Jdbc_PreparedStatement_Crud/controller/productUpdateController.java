package com.jsp.Jdbc_PreparedStatement_Crud.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class productUpdateController {

	public static void main(String[] args) {
		
Connection connection=null;

		try {
			// step-1 load/Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// step-2 create connection
			
			String url = "jdbc:mysql://localhost:3306/jdbc-preparedstatement";
			String user = "root";
			String pass = "akram";
			
			connection=DriverManager.getConnection(url, user, pass);
			
			//step-3 create statement 
			String updateColorQuery = "update product set productcolor = ? where productid=?";
			
			PreparedStatement preparedStatement=connection.prepareStatement(updateColorQuery);
			
			preparedStatement.setString(1, "white");
			preparedStatement.setInt(2, 100);
			
			int a=preparedStatement.executeUpdate();
			
			if(a==1) {
				System.out.println("Data is updated");
			}else {
				System.err.println("given id is not present");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

