package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(asyncSupported = true, urlPatterns = { "/Secon_Servlet" })
public class Secon_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		//get Writer 
		PrintWriter pw=res.getWriter();
		//read form1 hidden box data
		String name=req.getParameter("hname").toUpperCase();
		String lname=req.getParameter("hlname").toUpperCase();
		String fname=req.getParameter("hfname").toUpperCase();
		String mstatus=req.getParameter("hms").toUpperCase();
		//printing first form data
			pw.print("Name ::"+name+" "+lname+"<br>");
			pw.print("Father Name ::"+fname+" "+lname+"<br>");
			pw.print("Marital Status is ::"+mstatus+"<br>");
			//printing second form data
			pw.println("Second form data is"+req.getParameter("st1")+" <br>"+req.getParameter("st2"));
			pw.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
