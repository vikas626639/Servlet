package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(asyncSupported = true, urlPatterns = { "/SecondServlet" })
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		//get Writer 
		PrintWriter pw=res.getWriter();
		//read form2 request data
		String exp=req.getParameter("exp");
		String skill=req.getParameter("skill");
		//get Access to Session scope object
		HttpSession session=req.getSession(false);
		//put the data in session
		session.setAttribute("exp", exp);
		session.setAttribute("skill", skill);
		//generating Third dynamic form page
			pw.println("<h2 style='color: red; border: 1cm; text-align: center;'>Provide City & Salary</h2>");
			pw.println("<form action='ThirdServlet'  method='post'>");
			pw.println("<table border='1' align='center'>");
			pw.println("<tr><td>Enter Preference City ::</td><td><input type='text' name='city' size=6></td></tr>");
			pw.println("<tr><td>Enter Expected Salary ::</td><td><input type='text' name='sal' size=6></td></tr>");
			pw.println("<tr><td colspan='2' align='center'><input type='submit' value='Submit'></td></tr>");
			pw.println("</table>");
			pw.println("</form>");
			pw.close();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}



}
