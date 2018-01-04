package com.model;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Demo {

	public static void main(String args[]) {

		String user = "root";
		String passwd = "";
		String driver = "com.mysql.jdbc.Driver";

		String url = "jdbc:mysql://localhost:3306/smarket";
		String dbname = "smarket";
		Connection con = null;
		ResultSet rs = null;

		int s1, s4, s5, s6, s7, s8, s9, s10;

		float sp, s11, cp;
		int sdd, sdd1;

		String s2, s22,s3;
		ArrayList<Integer> product_id = new ArrayList<Integer>();
		ArrayList<String> category = new ArrayList<String>();
		ArrayList<String> brand = new ArrayList<String>();
		ArrayList<String> sub_category = new ArrayList<String>();
		ArrayList<Integer> stock_available = new ArrayList<Integer>();
		ArrayList<Integer> cost_price = new ArrayList<Integer>();
		ArrayList<Integer> storage_price = new ArrayList<Integer>();
		ArrayList<Integer> selling_price = new ArrayList<Integer>();
		ArrayList<Integer> profit = new ArrayList<Integer>();
		ArrayList<Integer> stock_sold = new ArrayList<Integer>();
		ArrayList<Integer> sold_percent = new ArrayList<Integer>();

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, passwd);

			String queryString = ("SELECT * FROM dummy order by product_id");
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(queryString);
			while (rs.next()) {
				s1 = rs.getInt("product_id");
				s2 = rs.getString("category");
				s22=rs.getString("brand");
				
				s3 = rs.getString("sub_category");
				s4 = rs.getInt("stock_available");
				s5 = rs.getInt("cost_price");
				s6 = rs.getInt("storage_price");
				s7 = rs.getInt("selling_price");

				s9 = rs.getInt("stock_sold");

				cp = s5 / s4;                 //cost_price per unit

				cp *= s9;						 //cost_price total

				sdd1 = Math.round(cp);

				sp = s7 / s4;							 //selling_price per unit

				sp *= s9;								 //selling_price total
				sdd = Math.round(sp);

				s8 = sdd - (sdd1 + s6);           //profit_loss calculation

				s11 = ((float) s9 / s4) * 100;         //sold_percent calculation

				s10 = Math.round(s11);
                
				s5=s5/s4;                      //cost_price per unit

				product_id.add(s1);
				category.add(s2);
				brand.add(s22);
				sub_category.add(s3);
				stock_available.add(s4);
				cost_price.add(s5);
				storage_price.add(s6);
				selling_price.add(s7);
				profit.add(s8);
				stock_sold.add(s9);

				sold_percent.add(s10);

			} // end of while

			int sum = 0;
			for (int i = 301; i < profit.size(); i++) {

				sum += profit.get(i);

			}

			System.out.println(sum);

			String sql = "delete from decem";
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.executeUpdate();
			pstmt.close();


			sql = "delete from buffer";
			 pstmt = con.prepareStatement(sql);

			pstmt.executeUpdate();
			pstmt.close();

			
			
			
			sql = "delete from orders";
			pstmt = con.prepareStatement(sql);

			pstmt.executeUpdate();
			pstmt.close();

			for (int i = 0; i < product_id.size(); i++) {

				sql = "insert into decem(product_id,category,brand,sub_category,stock_available,cost_price,storage_price,selling_price,profit_loss,stock_sold,sold_percent) values (?,?,?,?,?,?,?,?,?,?,?)";
				pstmt = con.prepareStatement(sql);

				pstmt.setInt(1, product_id.get(i));
				pstmt.setString(2, category.get(i));
				pstmt.setString(3, brand.get(i));
				pstmt.setString(4, sub_category.get(i));
				pstmt.setInt(5, stock_available.get(i));
				pstmt.setInt(6, cost_price.get(i));
				pstmt.setInt(7, storage_price.get(i));
				pstmt.setInt(8, selling_price.get(i));
				pstmt.setInt(9, profit.get(i));
				pstmt.setInt(10, stock_sold.get(i));
				pstmt.setInt(11, sold_percent.get(i));

				pstmt.executeUpdate();

				pstmt.close();

			}
			
			
			
			for (int i = 0; i < product_id.size(); i++) {

				sql = "insert into buffer(product_id,category,brand,sub_category,stock_available,cost_price,storage_price,selling_price,profit_loss,stock_sold,sold_percent,stock_left) values (?,?,?,?,?,?,?,?,?,?,?,?)";
				pstmt = con.prepareStatement(sql);

				pstmt.setInt(1, product_id.get(i));
				pstmt.setString(2, category.get(i));
				
				pstmt.setString(3, brand.get(i));
				
				pstmt.setString(4, sub_category.get(i));
				pstmt.setInt(5, stock_available.get(i));
				pstmt.setInt(6, cost_price.get(i));
				pstmt.setInt(7, storage_price.get(i));
				pstmt.setInt(8, selling_price.get(i));
				pstmt.setInt(9, profit.get(i));
				pstmt.setInt(10, stock_sold.get(i));
				pstmt.setInt(11, sold_percent.get(i));
				pstmt.setInt(12, stock_available.get(i)-stock_sold.get(i));
				

				pstmt.executeUpdate();

				pstmt.close();

			}
			
			
			
			

			for (int i = 0; i < product_id.size(); i++) {

				sql = "insert into orders(product_id,category,brand,sub_category,quantity,cost_price) values (?,?,?,?,?,?)";
				pstmt = con.prepareStatement(sql);

				pstmt.setInt(1, product_id.get(i));
				pstmt.setString(2, category.get(i));
				pstmt.setString(3, brand.get(i));
				pstmt.setString(4, sub_category.get(i));
				pstmt.setInt(5, stock_available.get(i));
				pstmt.setInt(6, cost_price.get(i));
				

				pstmt.executeUpdate();

				pstmt.close();

			}

			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
