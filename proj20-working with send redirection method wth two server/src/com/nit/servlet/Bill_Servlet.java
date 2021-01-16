package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(asyncSupported = true, urlPatterns = { "/Bill_Servlet" })
public class Bill_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get content type
		res.setContentType("text/html");
		//get Writer
		PrintWriter pw=res.getWriter();
		//read form data
		String name=req.getParameter("t1");
		float priece=Float.parseFloat(req.getParameter("t2"));
		int qty=Integer.parseInt(req.getParameter("t3"));
		float total=priece*qty;
		
		if(total>=50000) {
			System.out.println("before res.sendRd(-) in BillServlet");
			res.sendRedirect("DisCount_servlet?total="+total+"&name="+name);
		}else {
			pw.println("<b>From bill servlet component</b><br>");
			pw.println("Item name :: "+name+" Price ::"+priece+" Qty :: "+qty+" Bill Amout= "+total+" ");
		}//else
		pw.close();
	}//doget

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
