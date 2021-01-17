package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(asyncSupported = true, urlPatterns = { "/Servlet1" })
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		//get Writer 
		PrintWriter pw=res.getWriter();
		//
		//read form data
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		String mstatus=req.getParameter("ms");

		if(mstatus==null) 
			mstatus="SINGLE";

		if(mstatus.equals("married")) {
			//generate second form page

			pw.println("<form action='Servlet2'  method='post'>");
			pw.println("<table border='1' align='center'>");
			pw.println("<tr><td>Spouse Name ::</td><td><input type='text' name='st1' placeholder='Enter Name'></td></tr>");
			pw.println("<tr><td>NUMBER OF CHILDREN NAME ::</td><td><input type='text' name='st2'></td></tr>");
			pw.println("<tr><td colspan='2' align='center'><input type='submit' value='submit'></td></tr>");
			pw.println("</table>");
			pw.println("</form>");
		}else {
			pw.println("<form action='Servlet2'  method='post'>");
			pw.println("<table border='1' align='center'>");
			pw.println("<tr><td>When do you want marry ::</td><td><input type='text' name='st1' ></td></tr>");
			pw.println("<tr><td>Why do you want to marry ::</td><td><input type='text' name='st2'></td></tr>");
			pw.println("<tr><td colspan='2' align='center'><input type='submit' value='submit'></td></tr>");
			pw.println("</table>");
			pw.println("</form>");
		}
		pw.close();
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
