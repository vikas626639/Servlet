package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(asyncSupported = true, urlPatterns = { "/ThirdServlet" })
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		//get Writer 
		PrintWriter pw=res.getWriter();
		//
		//read form2 request data
		String city=req.getParameter("city");
		float  sal=Float.parseFloat(req.getParameter("sal"));

		//get Access to Session scope object
		HttpSession session=req.getSession(false);
		//read form1 and form 2 data from the HttpSession Scope
		String name=(String) session.getAttribute("name");
		String addrs=(String) session.getAttribute("addrs");
		int  age=(int) session.getAttribute("age");
		String exp=(String) session.getAttribute("exp");
		String skill=(String) session.getAttribute("skill");
		
		pw.println("<center><h1>User Data::</h1><br>");
		pw.println("<table border='1'><tr><th>NAME::</th><td>"+name.toUpperCase()+"</td><tr>");
		pw.println("<tr><th>ADDRESS ::</th><td>"+addrs.toUpperCase()+"</td><tr>");
		pw.println("<tr><th>AGE::</th><td>"+age+"</td><tr>");
		pw.println("<tr><th>EXPERIENCE::</th><td>"+exp.toUpperCase()+"</td><tr>");
		pw.println("<tr><th>SKILL::</th><td>"+skill.toUpperCase()+"</td><tr>");
		pw.println("<tr><th>CITY::</th><td>"+city.toUpperCase()+"</td><tr>");
		pw.println("<tr><th>Salary::</th><td>"+sal+"</td><tr></center>");
		pw.close();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
