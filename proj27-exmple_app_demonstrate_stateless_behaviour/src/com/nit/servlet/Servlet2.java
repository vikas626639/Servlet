package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(asyncSupported = true, urlPatterns = { "/Servlet2" })
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		//get Writer 
		PrintWriter pw=res.getWriter();
		//read form data
		//printing first form data
			pw.print("Name ::"+req.getParameter("name")+"<br>");
			pw.print("Age ::"+req.getParameter("age")+"<br>");
			pw.print("Marital Status is ::"+req.getParameter("ms")+"<br>");
			//printing second form data
			pw.println("Second form data is"+req.getParameter("st1")+" <br>"+req.getParameter("st2"));
			pw.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
