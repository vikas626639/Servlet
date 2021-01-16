package com.nit.servleet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Header_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//set content type
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		pw.println("<marquee><h1>H C L TECHNOLOGY</h1></marquee");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
