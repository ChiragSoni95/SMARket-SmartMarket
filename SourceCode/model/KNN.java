package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class KNN {

	String user = "root";
	String passwd = "";
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/smarket";
	String dbname = "smarket";

	Connection con = null;
	ResultSet rs = null;

	public String classify(int current_percent) throws Exception {

		LinkedList<String> label = new LinkedList<String>();

		LinkedList<Integer> stock_percent = new LinkedList<Integer>();

		LinkedList<Integer> dist = new LinkedList<Integer>();
		Integer[] dist1;
		String[] label1;

		int s1;
		db_connect();

		try {
			String queryString = ("SELECT * FROM hot");
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(queryString);
			while (rs.next()) {
				s1 = rs.getInt("sold_percent");
				stock_percent.add(s1);
				label.add("hot");

			} // end of while

			rs = null;

			String queryString1 = ("SELECT * FROM warm");
			Statement stmt1 = con.createStatement();
			rs = stmt1.executeQuery(queryString1);
			while (rs.next()) {
				s1 = rs.getInt("sold_percent");
				stock_percent.add(s1);

				label.add("warm");

			} // end of while

			rs = null;

			String queryString2 = ("SELECT * FROM cold");
			Statement stmt2 = con.createStatement();
			rs = stmt2.executeQuery(queryString2);
			while (rs.next()) {
				s1 = rs.getInt("sold_percent");
				stock_percent.add(s1);

				label.add("cold");

			} // end o

		}// end of try
		catch (SQLException sqle) {
			System.out.println("Some SQL error occured.");
		}

		db_close();

		for (int j = 0; j < stock_percent.size(); j++) {

			dist.add(Math.abs(stock_percent.get(j) - current_percent));

		}

		Sorting s = new Sorting();

		dist1 = (Integer[]) dist.toArray(new Integer[dist.size()]);
		label1 = (String[]) label.toArray(new String[label.size()]);

		String type = s.sort(dist1, label1);

		if(type.equals("hot"))
		type="Best-Fit Category";
		else 		if(type.equals("warm"))
			type="Good-Fit Category";
		else
				type="Low-Fit Category";
		return type;

	}

	private void db_connect() throws Exception {
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, passwd);
	}

	private void db_close() throws SQLException {

		con.close();
	}

}
