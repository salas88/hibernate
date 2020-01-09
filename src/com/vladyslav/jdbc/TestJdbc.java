package com.vladyslav.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/users";
		String user = "test";
		String pass = "123456";
		
	try {
		System.out.println("Connecting to jdbc " + jdbcUrl);
		Connection myCon = DriverManager.getConnection(jdbcUrl, user, pass);
		System.out.println("Connecting sucssesfull");
		
	}catch(Exception ex) {
		ex.printStackTrace();}
	}

}
