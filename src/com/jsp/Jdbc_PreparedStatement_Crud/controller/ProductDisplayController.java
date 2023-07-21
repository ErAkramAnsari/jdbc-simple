package com.jsp.Jdbc_PreparedStatement_Crud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDisplayController {
	
	Connection connection=null;
	try {

		// step-1 load/register driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// step-2 create connection
		String url = "jdbc:mysql://localhost:3306/jdbc-preparedstatement";
		String user = "root";
		String pass = "akram";

	    connection = DriverManager.getConnection(url, user, pass);

		String displayQuery  = "select * from product";
		// step-3 create statement
		PreparedStatement preparedStatement=connection.prepareStatement(displayQuery);
		
		
		ResultSet resultSet=prepareStatement.excuteQuery();
		while(resultSet.next()) {
			
			int id = resultSet.getInt("productid");
			String name = resultSet.getString("productname");
			Double price =resultSet.getDouble("productprice");
			String color = resultSet.getString("productcolor");
			
			
			System.out.println("id="+id);
			System.out.println("name="+name);
			System.out.println("price="+price);
			System.out.println("color="+color);
			
			
			System.out.println("###############################################");
		
		}
		
	 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
