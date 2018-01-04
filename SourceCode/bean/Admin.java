package com.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Admin {
	String user = "root";
	String passwd = "";
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/smarket";
	

	private String email;
	private String password;
	Connection con;
	public boolean process(String email, String password) throws Exception {

		this.email = email;
		this.password = password;
		int count = 0;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		this.con = DriverManager.getConnection(url, user, passwd);
		
		String sql = "select count(*) as count from admin where user_name=? AND password=?";
		PreparedStatement pstmt = this.con.prepareStatement(sql);
		pstmt.setString(1, this.email);
		pstmt.setString(2, this.password);

		ResultSet rst = pstmt.executeQuery();
		if (rst.next()) {
			count = rst.getInt("count");
		}
		rst.close();
		pstmt.close();
		
		


		this.con.close();
		
		if (count == 1) {
			return true;
		}
		return false;
	}
	
}
