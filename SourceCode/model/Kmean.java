package com.model;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kmean {

	String user = "root";
	String passwd = "";
	String driver = "com.mysql.jdbc.Driver";

	String url = "jdbc:mysql://localhost:3306/smarket";
	String dbname = "smarket";
	Connection con = null;
	ResultSet rs = null;

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

	public void getdata() throws Exception {

		int s1,s4,s5,s6,s7,s8,s9,s10;
		String s2,s22,s3;
		
		db_connect();

		try {
			String queryString = ("select * from decem order by sold_percent");
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(queryString);
			while (rs.next()) {
				s1 = rs.getInt("product_id");
				s2 = rs.getString("category");
				s22 = rs.getString("brand");
				s3 = rs.getString("sub_category");
				s4 = rs.getInt("stock_available");
				s5 = rs.getInt("cost_price");
				s6 = rs.getInt("storage_price");
				s7 = rs.getInt("selling_price");
				s8=rs.getInt("profit_loss");
				s9 = rs.getInt("stock_sold");
				s10=rs.getInt("sold_percent");
				
				
				
				
			
				
				
				
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
		}// end of try
		catch (SQLException sqle) {
			System.out.println(sqle);
		}
		db_close();

	}// end of function

	public void cluster() throws Exception {

		
		
		delete_allhot();

		delete_allwarm();

		delete_allcold();

		int m1, m2, m3;
		int i;
		int d1 = 0, d2 = 0, d3 = 0;

		int a = 1, b = 1, c = 1;

		int count = product_id.size();

		int c11[] = new int[count];
		String c12[]=new String[count];
		
		String c122[]=new String[count];
		String c13[]=new String[count];
		int c14[] = new int[count];
		int c15[] = new int[count];
		int c16[] = new int[count];
		int c17[] = new int[count];
		int c18[] = new int[count];
		int c19[] = new int[count];
		int c10[] = new int[count];  // Cluster 1
		
		
		                             
		int c21[] = new int[count];
		String c22[]=new String[count];
		String c222[]=new String[count];
		
		String c23[]=new String[count];
		int c24[] = new int[count];
		int c25[] = new int[count];
		int c26[] = new int[count];
		int c27[] = new int[count];
		int c28[] = new int[count];
		int c29[] = new int[count];
		int c20[] = new int[count];  // Cluster 2
		
		int c31[] = new int[count];
		String c32[]=new String[count];
		String c322[]=new String[count];
		
		String c33[]=new String[count];
		int c34[] = new int[count];
		int c35[] = new int[count];
		int c36[] = new int[count];
		int c37[] = new int[count];
		int c38[] = new int[count];
		int c39[] = new int[count];
		int c30[] = new int[count];  // Cluster 3

		c11[0] = product_id.get(0);
		c12[0] = category.get(0);
		c122[0] = brand.get(0);
		c13[0] = sub_category.get(0);
		c14[0] = stock_available.get(0);
		c15[0] = cost_price.get(0);
		c16[0] = storage_price.get(0);
		c17[0] = selling_price.get(0);
		c18[0] = profit.get(0);
		c19[0] = stock_sold.get(0);
		c10[0] = sold_percent.get(0);    // Randomly place one product_name in each  cluster
		
		
		
		                                     
		
		c21[0] = product_id.get(count/2);
		c22[0] = category.get(count/2);
		c222[0] = brand.get(count/2);
		c23[0] = sub_category.get(count/2);
		c24[0] = stock_available.get(count/2);
		c25[0] = cost_price.get(count/2);
		c26[0] = storage_price.get(count/2);
		c27[0] = selling_price.get(count/2);
		c28[0] = profit.get(count/2);
		c29[0] = stock_sold.get(count/2);
		c20[0] = sold_percent.get(count/2);
		
		
		c31[0] = product_id.get(count-1);
		c32[0] = category.get(count-1);
		c322[0] = brand.get(count-1);
		c33[0] = sub_category.get(count-1);
		c34[0] = stock_available.get(count-1);
		c35[0] = cost_price.get(count-1);
		c36[0] = storage_price.get(count-1);
		c37[0] = selling_price.get(count-1);
		c38[0] = profit.get(count-1);
		c39[0] = stock_sold.get(count-1);
		c30[0] = sold_percent.get(count-1);
		
		m1 = c10[0];
		m2 = c20[0];
		m3 = c30[0];  		// Initial Mean value of each cluster
      
	  
	   int m11,m22,m33;
	  m11 = c10[0];
		m22 = c20[0];
		m33 = c30[0];  	
	  
	 
	  int count1=0;
	  do{
		  m1=m11;
		  m2=m22;
		  m3=m33;
		  
		  a=b=c=1;
		for (i = 1; i < count; i++) {

			if (i != count / 2 && i != count - 1) {
				d1 = Math.abs(m1 - sold_percent.get(i));
				d2 = Math.abs(m2 - sold_percent.get(i));
				d3 = Math.abs(m3 - sold_percent.get(i));

				if (d1 <= d2 && d1 <= d3) {
					c11[a] = product_id.get(i);
					c12[a] = category.get(i);
					c122[a]=brand.get(i);
					c13[a] = sub_category.get(i);
					c14[a] = stock_available.get(i);
					c15[a] = cost_price.get(i);
					c16[a] = storage_price.get(i);
					c17[a] = selling_price.get(i);
					c18[a] = profit.get(i);
					c19[a] = stock_sold.get(i);
					c10[a] = sold_percent.get(i);

					//m1 = (c10[a] + m1) / 2;
					a++;
				} else {

					if (d2 <= d1 && d2 <= d3) {
						c21[b] = product_id.get(i);
						c22[b] = category.get(i);
						c222[b] = brand.get(i);
						c23[b] = sub_category.get(i);
						c24[b] = stock_available.get(i);
						c25[b] = cost_price.get(i);
						c26[b] = storage_price.get(i);
						c27[b] = selling_price.get(i);
						c28[b] = profit.get(i);
						c29[b] = stock_sold.get(i);
						c20[b] = sold_percent.get(i);
						//m2 = (c20[b] + m2) / 2;
						b++;
					}

					else {
						if (d3 <= d1 && d3 <= d2) {
							c31[c] = product_id.get(i);
							c32[c] = category.get(i);
							c322[c] = brand.get(i);
							c33[c] = sub_category.get(i);
							c34[c] = stock_available.get(i);
							c35[c] = cost_price.get(i);
							c36[c] = storage_price.get(i);
							c37[c] = selling_price.get(i);
							c38[c] = profit.get(i);
							c39[c] = stock_sold.get(i);
							c30[c] = sold_percent.get(i);

							//m3 = (c30[c] + m3) / 2;
							c++;
						}

					}
				}
			}
		}// end of for...
		
		
		
		  int sum=0;
		  
		  for(i=0;i<a;i++)
			   sum+=c10[i];
		
		  m11=sum/a;
		  
		  sum=0;
		  
		   for(i=0;i<b;i++)
			   sum+=c20[i];
		   
		    
		  m22=sum/b;
		  
		  sum=0;
		   for(i=0;i<c;i++)
			   sum+=c30[i];
		   
		   
		  m33=sum/c;
		
		
		  
		count1++;
	
		
		System.out.println(count1+" iteration");
		System.out.println("m11="+m11);
		System.out.println("m22="+m22);
		System.out.println("m33="+m33);
		
		
		/*System.out.println("1st Cluster");
		for (i = 0; i < a; i++) {
			
			System.out.println(c10[i]);
			

		}
		
		System.out.println("2nd Cluster");

		for (i = 0; i < b; i++) {
			

			System.out.println(c20[i]);		
			}

		
		System.out.println("3rd Cluster");
		for (i = 0; i < c; i++) {
			

			System.out.println(c30[i]);
		}
		*/
		
	}while(m1!=m11 | m2!=m22 | m3!=m33);
		
	  System.out.println(count1);
	  
	  /*
		 * Data is classified into 3 clusters as follows.."
		 */
		
		
		
		
		for (i = 0; i < a; i++) {
			

			insertcold(c11[i], c12[i],c122[i], c13[i], c14[i], c15[i],c16[i],c17[i],c18[i],c19[i],c10[i]);

		}

		for (i = 0; i < b; i++) {
			

			insertwarm(c21[i], c22[i],c222[i], c23[i], c24[i], c25[i],c26[i],c27[i],c28[i],c29[i],c20[i]);
		}

		for (i = 0; i < c; i++) {
			

			inserthot(c31[i], c32[i],c322[i], c33[i], c34[i], c35[i],c36[i],c37[i],c38[i],c39[i],c30[i]);

		}
		
		
		System.out.println("Done");

	}// end of function

	public void inserthot(int product_id,String category,String brand,String sub_category, int stock_available,int cost_price, int storage_price, int selling_price,int profit,int stock_sold,int sold_percent)
			throws Exception {

		db_connect();

		String sql = "insert into hot(product_id,category,brand,sub_category,stock_available,cost_price,storage_price,selling_price,profit_loss,stock_sold,sold_percent) values (?,?,?,?,?,?,?,?,?,?,?)";	
		PreparedStatement pstmt = this.con.prepareStatement(sql);

		pstmt.setInt(1, product_id);
		pstmt.setString(2, category);
		pstmt.setString(3, brand);
		
		pstmt.setString(4, sub_category);
		pstmt.setInt(5, stock_available);
		pstmt.setInt(6, cost_price);
		pstmt.setInt(7, storage_price);
		pstmt.setInt(8, selling_price);
		pstmt.setInt(9, profit);
		pstmt.setInt(10, stock_sold);
		pstmt.setInt(11, sold_percent);

		pstmt.executeUpdate();

		pstmt.close();

		db_close();

	}

	public void insertcold(int product_id,String category,String brand,String sub_category, int stock_available,int cost_price, int storage_price, int selling_price,int profit,int stock_sold,int sold_percent)
			throws Exception {

		db_connect();
		String sql = "insert into cold(product_id,category,brand,sub_category,stock_available,cost_price,storage_price,selling_price,profit_loss,stock_sold,sold_percent) values (?,?,?,?,?,?,?,?,?,?,?)";	
		PreparedStatement pstmt = this.con.prepareStatement(sql);

		pstmt.setInt(1, product_id);
		pstmt.setString(2, category);
		pstmt.setString(3, brand);
		
		pstmt.setString(4, sub_category);
		pstmt.setInt(5, stock_available);
		pstmt.setInt(6, cost_price);
		pstmt.setInt(7, storage_price);
		pstmt.setInt(8, selling_price);
		pstmt.setInt(9, profit);
		pstmt.setInt(10, stock_sold);
		pstmt.setInt(11, sold_percent);

		pstmt.executeUpdate();

		pstmt.close();

		db_close();

	}

	public void insertwarm(int product_id,String category,String brand,String sub_category, int stock_available,int cost_price, int storage_price, int selling_price,int profit,int stock_sold,int sold_percent)
			throws Exception {

		db_connect();
		String sql = "insert into warm(product_id,category,brand,sub_category,stock_available,cost_price,storage_price,selling_price,profit_loss,stock_sold,sold_percent) values (?,?,?,?,?,?,?,?,?,?,?)";	
		PreparedStatement pstmt = this.con.prepareStatement(sql);

		pstmt.setInt(1, product_id);
		pstmt.setString(2, category);
		pstmt.setString(3, brand);
		
		pstmt.setString(4, sub_category);
		pstmt.setInt(5, stock_available);
		pstmt.setInt(6, cost_price);
		pstmt.setInt(7, storage_price);
		pstmt.setInt(8, selling_price);
		pstmt.setInt(9, profit);
		pstmt.setInt(10, stock_sold);
		pstmt.setInt(11, sold_percent);

		pstmt.executeUpdate();

		pstmt.close();

		db_close();

	}

	

	public void delete_cold(String id) throws Exception {
		db_connect();

		String sql = "delete from cold where product_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(id));
		pstmt.executeUpdate();
		pstmt.close();

		db_close();

	}

	public void delete_allhot() throws Exception {
		db_connect();
		String sql = "delete from hot";
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.executeUpdate();
		pstmt.close();

		db_close();

	}

	public void delete_allwarm() throws Exception {
		db_connect();

		String sql = "delete from warm";
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.executeUpdate();
		pstmt.close();

		db_close();

	}

	public void delete_allcold() throws Exception {
		db_connect();

		String sql = "delete from cold";
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.executeUpdate();
		pstmt.close();

		db_close();

	}

	private void db_connect() throws Exception {
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, passwd);
	}

	private void db_close() throws SQLException {

		con.close();
	}

}// end of class

