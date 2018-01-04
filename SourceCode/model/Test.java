package com.model;

public class Test {

	public static void main(String args[]){
		
		
		Order t1=new Order();
		String best="";
		try {
			best=t1.checkBest();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(best);
	}
	
	
	
}
