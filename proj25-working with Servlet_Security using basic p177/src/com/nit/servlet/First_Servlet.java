package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(asyncSupported = true, urlPatterns = { "/First_Servlet" })
public class First_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
			res.setContentType("text/html");
			//get Writer 
			PrintWriter pw=res.getWriter();
			pw.println("<center><b>the user name is="+req.getRemoteUser()+"</b></center>");
			pw.println("<center><b>the auth type is="+req.getAuthType()+"</b></center>");
			pw.close();
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
