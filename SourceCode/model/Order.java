package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

public class Order {

	String user = "root";
	String passwd = "";
	String driver = "com.mysql.jdbc.Driver";

	String url = "jdbc:mysql://localhost:3306/smarket";
	String dbname = "smarket";
	Connection con = null;
	

	public void insertorder(int product_id, String category,String brand,
			String sub_category, int quantity,int cost) throws Exception {

		
			db_connect();
			int count = 0;

			String sql = "select count(*) as count from orders where product_id=?";

			PreparedStatement pstmt = this.con.prepareStatement(sql);
			pstmt.setInt(1, product_id);


			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("count");
			}
			rs.close();
			pstmt.close();

			if (count == 1) {

				sql = "update orders set quantity =?  where product_id = ?";
				pstmt = con.prepareStatement(sql);

				pstmt.setInt(1, quantity);
				pstmt.setInt(2, product_id);

				pstmt.executeUpdate();

				pstmt.close();
				
				sql = "delete from buffer where product_id = ?";
				pstmt = con.prepareStatement(sql);

				
				pstmt.setInt(1, product_id);

				pstmt.executeUpdate();

				pstmt.close();
				
				
				

			} else {

				sql = "insert into orders(product_id,category,brand,sub_category,quantity,cost_price) values (?,?,?,?,?,?)";
				pstmt = con.prepareStatement(sql);

				pstmt.setInt(1, product_id);
				pstmt.setString(2, category);
				pstmt.setString(3, brand);
				pstmt.setString(4, sub_category);
				pstmt.setInt(5, quantity);
				pstmt.setInt(6, cost);
				
				pstmt.executeUpdate();

				pstmt.close();

			}

			db_close();
			
		

	}
	
	
	public void remove(String id) throws Exception{
		
		
		db_connect();
		
			String sql="DELETE FROM orders WHERE product_id=?"; 
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(id));
			pstmt.executeUpdate();
			pstmt.close();
			
		
		db_close();
		
		
		
	}
	
	
	
public int cal_id() throws Exception{
		
		
		db_connect();
	
		int s1=0;
		String queryString = ("select * from orders order by product_id desc");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(queryString);
		while (rs.next()) {
			s1 = rs.getInt("product_id");
			
			break;
	
		}
		
		db_close();
		
		return s1+1;
		
		
	}

public String checkBest() throws Exception{
	
	
	db_connect();
	int s1,s4;
	String s2,s22,s3;

	ArrayList<Integer> product_id = new ArrayList<Integer>();
	ArrayList<String> category = new ArrayList<String>();
	ArrayList<String> brand = new ArrayList<String>();
	ArrayList<String> sub_category = new ArrayList<String>();
	ArrayList<Integer> stock_sold = new ArrayList<Integer>();
	
	String queryString = ("select * from decem");
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(queryString);
	while (rs.next()) {
		s1 = rs.getInt("product_id");
		s22=rs.getString("category");
		s2 = rs.getString("brand");
		s3 = rs.getString("sub_category");
		s4 = rs.getInt("stock_sold");
		
		product_id.add(s1);
		category.add(s22);
		brand.add(s2);
		sub_category.add(s3);
		stock_sold.add(s4);
	
	}
	
	rs.close();
	
	
	ArrayList<Integer> stock_sold1 = new ArrayList<Integer>();
	
	queryString = ("select * from nov");
	stmt = con.createStatement();
	 rs = stmt.executeQuery(queryString);
	while (rs.next()) {
		
		s4 = rs.getInt("stock_sold");
		
		
		stock_sold1.add(s4);
	
	}
	
	rs.close();
	int[] diff=new int[product_id.size()]; 
	
	
	int max=0;
	String category2="";
	String brand2="";
	String subcategory2="";
	for(int i=0;i<product_id.size();i++){
		
		diff[i]=stock_sold.get(i)-stock_sold1.get(i);
		
		if(diff[i]>max){
			
			max=diff[i];
			category2=category.get(i);
			brand2=brand.get(i);
			subcategory2=sub_category.get(i);
			
		}
		
	}
	db_close();
	
	
	return category2+"_"+brand2+"_"+subcategory2;
	
	
	
}


public String checkWorst() throws Exception{
	
	
	db_connect();
	int s1,s4;
	String s2,s22,s3;

	ArrayList<Integer> product_id = new ArrayList<Integer>();
	ArrayList<String> category = new ArrayList<String>();
	ArrayList<String> brand = new ArrayList<String>();
	ArrayList<String> sub_category = new ArrayList<String>();
	ArrayList<Integer> stock_sold = new ArrayList<Integer>();
	
	String queryString = ("select * from decem");
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery(queryString);
	while (rs.next()) {
		s1 = rs.getInt("product_id");
		s22=rs.getString("category");
		s2 = rs.getString("brand");
		s3 = rs.getString("sub_category");
		s4 = rs.getInt("stock_sold");
		
		product_id.add(s1);
		category.add(s22);
		brand.add(s2);
		sub_category.add(s3);
		stock_sold.add(s4);
	
	}
	
	rs.close();
	
	
	ArrayList<Integer> stock_sold1 = new ArrayList<Integer>();
	
	queryString = ("select * from nov");
	stmt = con.createStatement();
	 rs = stmt.executeQuery(queryString);
	while (rs.next()) {
		
		s4 = rs.getInt("stock_sold");
		
		
		stock_sold1.add(s4);
	
	}
	
	rs.close();
	int[] diff=new int[product_id.size()]; 
	
	
	int max=0;
	String category2="";
	String brand2="";
	String subcategory2="";
	for(int i=0;i<product_id.size();i++){
		
		diff[i]=stock_sold1.get(i)-stock_sold.get(i);
		
		if(diff[i]>max){
			
			max=diff[i];
			category2=category.get(i);
			brand2=brand.get(i);
			subcategory2=sub_category.get(i);
			
		}
		
	}
	db_close();
	
	
	return brand2+"_"+subcategory2;
	
	
	
}


	

	
	private void db_connect() throws Exception {
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, passwd);
	}

	private void db_close() throws SQLException {

		con.close();
	}
	

}
