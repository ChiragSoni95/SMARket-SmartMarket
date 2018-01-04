package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Inventory {


	String user = "root";
	String passwd = "";
	String driver = "com.mysql.jdbc.Driver";

	String url = "jdbc:mysql://localhost:3306/smarket";
	String dbname = "smarket";
	Connection con = null;
	ResultSet rs = null;
	
public int cal_quantity(int rate_demand,double cost,double holding_cost){
	
	
	int r=500;
	int s=10;
	double root1, root2, d,diff1,diff2;
while(cost>1000)
	cost/=10;
if(holding_cost<1)
	holding_cost=1;
	
	
double a=holding_cost*cost;
double b=-(2*r+2*s*holding_cost*cost);
double c=2*rate_demand*cost;

d = b * b - 4 * a * c;


    
    root1 = ( - b + Math.sqrt(d))/(2*a);
    root2 = (-b - Math.sqrt(d))/(2*a);
    
    if(root1>rate_demand){
    	  diff1=root1-rate_demand;
    }
    else
    	 diff1=rate_demand-root1;
    
    
    if(root2>rate_demand){
    	  diff2=root2-rate_demand;
    }
    else
    	 diff2=rate_demand-root2;
    
	
	diff1=Math.sqrt((c)/holding_cost);
	
   int temp=(int)Math.round(diff1);
   return temp;
}	
	


public int regression(String category) throws Exception{
	
	db_connect();
	
	
	ArrayList<Integer> stock_available = new ArrayList<Integer>();
	ArrayList<Integer> sold_percent = new ArrayList<Integer>();
	
	
	int s1,s2,n,sum_x=0,sum_y=0,sum_xy=0,sum_x2=0;
 double x_bar,y_bar,a,b,num,den,y;
	
	String queryString ="SELECT * FROM decem where category=?";
	PreparedStatement stmt = con.prepareStatement(queryString);
	
	stmt.setString(1, category);
	rs = stmt.executeQuery();
	while (rs.next()) {
		s1 = rs.getInt("stock_available");
		s2 = rs.getInt("sold_percent");
		stock_available.add(s1);
		sold_percent.add(s2);
		
	} 
	
	rs.close();
	stmt.close();
	db_close();
	
	
	 n=stock_available.size();
	 
	for(int i=0;i<n;i++){
		
		sum_x+=stock_available.get(i);
		sum_x2+=Math.pow(stock_available.get(i), 2);
		sum_y+=sold_percent.get(i);
		sum_xy=sum_xy+stock_available.get(i)*sold_percent.get(i);
		
	}
	
	x_bar=(float)sum_x/n;
	y_bar=(float)sum_y/n;
	
	
	
	num=sum_xy-(n*x_bar*y_bar);
	den=sum_x2-(n*Math.pow(x_bar, 2));
	b=num/den;
	
	a=y_bar-b*x_bar;
	
y=a+b*x_bar;
	
	return (int)Math.round(y);
	
	
	
}
	




private void db_connect() throws Exception {
	Class.forName(driver);
	con = DriverManager.getConnection(url, user, passwd);
}

private void db_close() throws SQLException {

	con.close();
}
	
}
