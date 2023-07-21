package com.jsp.Jdbc_PreparedStatement_Crud.controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductinsertController {

	public static void main(String[] args) {

				Connection connection=null;
				try {
 
					// step-1 load/register driver
					Class.forName("com.mysql.cj.jdbc.Driver");
					// step-2 create connection
					String url = "jdbc:mysql://localhost:3306/jdbc-preparedstatement";
					String user = "root";
					String pass = "akram";

				    connection = DriverManager.getConnection(url, user, pass);

					String insertQuery = "insert into product values(?,?,?,?)";
					// step-3 create statement
					PreparedStatement preparedStatement=connection.prepareStatement(insertQuery);
					
					preparedStatement.setInt(1, 300);
					preparedStatement.setString(2, "pen");
					preparedStatement.setDouble(3, 199);
					preparedStatement.setString(4, " blue");
					
					//4 executeQuery
					
					preparedStatement.execute();
					
					System.out.println("Data---stored");	
				} catch (ClassNotFoundException | SQLException e) {
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
