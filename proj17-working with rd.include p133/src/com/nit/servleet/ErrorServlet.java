package com.nit.servleet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ErrorServlet() {
      }

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//set content tyep
		res.setContentType("text/html");
		//include the header file 
		RequestDispatcher rd=null,rd1=null;
		PrintWriter pw=null;
		/*
		 * rd=req.getRequestDispatcher("/Header_servlet"); rd.include(req, res);
		 */
		pw=res.getWriter();
		//display msg
		pw.println("<h1><center><font color=red>Internal problem<font></center></h1>");
		pw.print("<a href='input.html'></a>");
		//include the footer content
		/*
		 * rd1=req.getRequestDispatcher("Footer.html"); rd1.include(req, res);
		 */
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
