package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CountryServlet")
public class CountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//set content type
		res.setContentType("text/html");
		//get Writer 
		PrintWriter pw=null;
		pw=res.getWriter();
		
		String indianState[]= {"AP","TS","MP","UP","MH"};
		String UsState[]= {"CA","LA","NY","CR","AZ"};
		String ausisState[]= {"TMS","BB","CBR"};
		
		//read form data
		String country=req.getParameter("country");
		if(country.equalsIgnoreCase("india")) {
			pw.println("STATES ="+Arrays.toString(indianState));
		}else if(country.equalsIgnoreCase("us")){
			pw.println("STATES="+Arrays.toString(UsState));
		}else {
			pw.println("STATES="+Arrays.toString(ausisState));			
		}
		pw.close();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}
}
