package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(asyncSupported = true, urlPatterns = { "/FirstServlet" })
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		//get Writer 
		PrintWriter pw=res.getWriter();
		//
		//read form data
		String name=req.getParameter("name");
		String addrs=req.getParameter("addrs");
		int age =Integer.parseInt(req.getParameter("age"));
		
		//create Session for Browser windows
		HttpSession session=req.getSession();
		//put the data in session
		session.setAttribute("name", name);
		session.setAttribute("addrs", addrs);
		session.setAttribute("age", age);
		
		//generating second dynamic form page
			pw.println("<h2 style='color: red; border: 1cm; text-align: center;'>Provide your experience skill</h2>");
			pw.println("<form action='SecondServlet'  method='post'>");
			pw.println("<table align='center'>");
			pw.println("<tr><td>Enter Number of year Exp ::</td><td><input type='text' name='exp'></td></tr>");
			pw.println("<tr><td>Select Skill ::</td><td><select name='skill'><br>");
			pw.println("<option value=''>SELECT YOUR SKILL</option>");
			pw.println("<option value='java'>JAVA/J2EE</option>");
			pw.println("<option value='.net'>.NET</option>");
			pw.println("<option value='oracle'>ORACLE 12c</option>");
			pw.println("<option value='xml'>XML & WEBSERVICE</option>");
			pw.println("</select></td></tr>");
			pw.println("<tr><td colspan='2' align='center'><input type='submit' value='continue'></td></tr>");
			pw.println("</table>");
			pw.println("</form>");
			pw.close();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}


}
