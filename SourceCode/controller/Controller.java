package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Admin;
import com.model.Inventory;
import com.model.KNN;
import com.model.Kmean;
import com.model.Order;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	int product_id,threshold,buffer;
	String category,brand,sub_category;
	double cost,holding_cost;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action"); // action
		if (action == null) {
			request.getRequestDispatcher("test.jsp").forward(request, response);
		} else {
			doPost(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String action = request.getParameter("action"); // user-login
		if (action.equals("doLogin")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");

			Admin account = new Admin();

			boolean status = false;
			try {
				status = account.process(username, password);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (status) {
				account = null;
				Order t1=new Order();
				String best="";
				String worst="";
				try {
					best=t1.checkBest();
					worst=t1.checkWorst();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				HttpSession session = request.getSession();
			session.setAttribute("best", best);
			session.setAttribute("worst", worst);
				session.setAttribute("username", username);
				session.setAttribute("userpic", username);
				request.getRequestDispatcher("login1.jsp").forward(request,
						response);
			} else {
				request.setAttribute("msg", "INVALID LOGIN");
				request.getRequestDispatcher("test.jsp").forward(request,
						response);
			}

		}

		

		if (action.equals("existing_inventory")) {

			request.getRequestDispatcher("inventory_existing.jsp").forward(
					request, response);
		}
		
		
		if (action.equals("existing_inventory1")) {

			
			try {
				
				 buffer = Integer.parseInt(request
						.getParameter("buffer"));

				category = request.getParameter("category");
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			request.setAttribute("category",category);
			request.setAttribute("buffer",buffer);
			
			request.getRequestDispatcher("inventory_existing.jsp").forward(
					request, response);
		}
		

		if (action.equals("new_inventory")) {
			
			
			Order t1=new Order();
			int new_id=0;
			try {
				 new_id=t1.cal_id();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			t1=null;
			
			
			request.setAttribute("newid",String.valueOf(new_id));

			request.getRequestDispatcher("inventory_c.jsp").forward(request,
					response);
		}

		if (action.equals("inventory_calc")) {

			Inventory t1 = new Inventory();

			int rate_demand = 0;
			

			
			int value = 0;

			try {

				product_id = Integer.parseInt(request
						.getParameter("product_id"));

				category = request.getParameter("category");
				brand = request.getParameter("brand");

				sub_category = request.getParameter("sub_category");

				rate_demand = Integer.parseInt(request
						.getParameter("rate_demand"));

				cost = Double.parseDouble(request.getParameter("cost"));

				holding_cost = Double.parseDouble(request
						.getParameter("holding_cost"));

				value = t1.cal_quantity(rate_demand, cost, holding_cost);

				request.setAttribute("class", "Optimum Quantity To Order is "
						+ value);

			}

			catch (NumberFormatException e) {

				
				request.setAttribute("class", "Invalid Input");

			}

			t1 = null;

			request.getRequestDispatcher("order_entry.jsp").forward(request,
					response);
		}

		if (action.equals("order_table")) {

			request.getRequestDispatcher("order_table.jsp").forward(request,
					response);
		}

		if (action.equals("sale_table")) {

			request.getRequestDispatcher("sale_table.jsp").forward(request,
					response);
		}

		if (action.equals("cluster")) {

			Kmean t = new Kmean();
			try {
				t.getdata();
				t.cluster();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			t = null;
			request.getRequestDispatcher("login1.jsp").forward(request,
					response);

		}


		
		if (action.equals("existing_data")) {

			request.getRequestDispatcher("existing_data.jsp").forward(
					request, response);
		}
		
		
		if (action.equals("classify3")) {

			
			category = request.getParameter("category");
			request.setAttribute("category",category);
			
			request.getRequestDispatcher("existing_data1.jsp").forward(
					request, response);
		}
	
if (action.equals("classify4")) {

			
			brand = request.getParameter("brand");
			
			request.setAttribute("brand",brand);
			request.setAttribute("category",category);
			
			request.getRequestDispatcher("existing_data2.jsp").forward(
					request, response);
		}
		
		
		if (action.equals("new_data")) {

			Order t1=new Order();
			int new_id=0;
			try {
				 new_id=t1.cal_id();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			t1=null;
			
			
			request.setAttribute("newid",String.valueOf(new_id));
			
			
			request.getRequestDispatcher("classtype.jsp").forward(request,
					response);
		}

		if (action.equals("classify1")) {

			KNN t1 = new KNN();
			Inventory t2 = new Inventory();

			String label = "";

			
			int stock_available = 0;
			int stock_sold = 0;
			float sold_percent = 0;
			int sold_percent1 = 0;
			int value=0;

			try {
				
				product_id = Integer.parseInt(request
						.getParameter("product_id"));

				category = request.getParameter("category");
				
				brand = request.getParameter("brand");

				sub_category = request.getParameter("sub_category");

				cost = Double.parseDouble(request.getParameter("cost"));
				
				holding_cost = Double.parseDouble(request
						.getParameter("holding_cost"));
				
				stock_available = Integer.parseInt(request
						.getParameter("stock_available"));
				stock_sold = Integer.parseInt(request
						.getParameter("stock_sold"));

				sold_percent = ((float) (stock_sold * 100) / stock_available);

				sold_percent1 = Math.round(sold_percent);

				label = t1.classify(sold_percent1);
				value = t2.cal_quantity(stock_sold, cost, holding_cost);
				
				
				request.setAttribute("class", "Class Type= " + label);
				request.setAttribute("class1", "Optimum Quantity To Order is "
						+ value);
				
				
			} catch (Exception e) {

				request.setAttribute("class", "Invalid Input");

			}

			t1 = null;

			request.getRequestDispatcher("order_entry1.jsp").forward(request,
					response);

		}

		if (action.equals("order_confirm")) {

			request.getRequestDispatcher("order_details.jsp").forward(request,
					response);
		}

		if (action.equals("order_reject")) {

			request.getRequestDispatcher("login1.jsp").forward(request,
					response);
		}

		if (action.equals("order1")) {

			Order t1 = new Order();

			int quantity = Integer.parseInt(request.getParameter("quantity"));

			try {
				t1.insertorder(product_id, category, brand,sub_category, quantity,(int)cost);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			t1 = null;

			request.getRequestDispatcher("login1.jsp").forward(request,
					response);
		}

		if (action.equals("outlier")) {
			
			request.getRequestDispatcher("retainremove.jsp").forward(request,
					response);
		}
		
		
		if (action.equals("outlier1")) {

			

			try {
				
				 threshold = Integer.parseInt(request
						.getParameter("threshold"));

				category = request.getParameter("category");
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			request.setAttribute("category",category);
			request.setAttribute("threshold",threshold);
			request.getRequestDispatcher("retainremove.jsp").forward(request,
					response);
		}
		
		
		
		if(action.equals("outlier-delete")){
			
			Order t1 = new Order();
			
			Kmean t = new Kmean();
			
			
			String id = request.getParameter("id");
			try {
				
				t1.remove(id);
				t.delete_cold(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			t1=null;
			t=null;
			
			request.setAttribute("category",category);
			request.setAttribute("threshold",threshold);
			
			request.getRequestDispatcher("retainremove.jsp").forward(request,
					response);
			
			
		}
		

		if (action.equals("regression")) {
			request.setAttribute("sale", "");
			request.getRequestDispatcher("prediction.jsp").forward(request,
					response);
		}
		
		
		if (action.equals("category_graph")) {
			
			String month=request.getParameter("month");
			request.setAttribute("month", month);
			request.getRequestDispatcher("graph1.jsp").forward(request,
					response);
		}
		
		
if (action.equals("brand_graph")) {
			
			String month=request.getParameter("month");
			request.setAttribute("brand1", month+"1");
			request.setAttribute("brand2", month+"2");
			request.getRequestDispatcher("graph2.jsp").forward(request,
					response);
			
		}


if (action.equals("product_graph")) {
	
	String product=request.getParameter("product");
	request.setAttribute("product", product);
	
	request.getRequestDispatcher("graph3.jsp").forward(request,
			response);
	
}
		
		if (action.equals("predict")) {

			category = request.getParameter("category");
			Inventory t1 = new Inventory();

			int sale = 0;
			try {
				sale = t1.regression(category);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			request.setAttribute("sale", "Sale-Percent Prediction of "+category+" = "+sale);

			request.getRequestDispatcher("prediction.jsp").forward(request,
					response);
		}

		if (action.equals("hot")) {

			request.getRequestDispatcher("hot.jsp").forward(request, response);
		}

		if (action.equals("warm")) {

			request.getRequestDispatcher("warm.jsp").forward(request, response);
		}

		if (action.equals("cold")) {

			request.getRequestDispatcher("cold.jsp").forward(request, response);
		}

		
		if (action.equals("category_wise")) {

			request.getRequestDispatcher("graph.jsp").forward(request, response);
		}

		
		if (action.equals("brand_wise")) {

			request.getRequestDispatcher("graph4.jsp").forward(request, response);
		}

		
		if (action.equals("product_wise")) {

			request.getRequestDispatcher("graph5.jsp").forward(request, response);
		}

		
		
		
		if (action.equals("cold-delete")) {
			Kmean t = new Kmean();
			String id = request.getParameter("id");
			try {
				t.delete_cold(id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("cold.jsp").forward(request, response);
		}

		;
		if (action.equals("log-out")) {

			request.logout();
			request.getRequestDispatcher("test.jsp").forward(request, response);
		}

		if (action.equals("home")) {

			request.getRequestDispatcher("login1.jsp").forward(request,
					response);
		}

		if (action.equals("about_us")) {

			request.getRequestDispatcher("about_us.jsp").forward(request,
					response);
		}

	
	}
}
