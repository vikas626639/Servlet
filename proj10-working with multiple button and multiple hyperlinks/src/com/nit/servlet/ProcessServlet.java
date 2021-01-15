package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(asyncSupported = true, urlPatterns = { "/ProcessUrl" })
public class ProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//set content type
		res.setContentType("text/html");
		//get Writer 
		PrintWriter pw=res.getWriter();
		//read form data
		String link=req.getParameter("s1");
		if(link.equalsIgnoreCase("link1")) {
			pw.println("<center><b><font color=red>DATE AND TIME="+new Date()+"</b><br></center>");
			res.setHeader("refresh", "1");
			pw.println("<a href='form.html'>HOME PAGE</a>");
		}else if(link.equalsIgnoreCase("link2")){
			pw.println("<center><b><font color=red>SYSTEM PROPERTY="+System.getProperties()+"</b><br></center>");			
			pw.println("<a href='form.html'>HOME PAGE</a>");
		} else if(link.equalsIgnoreCase("add")) {
			int value1=Integer.parseInt(req.getParameter("t1"));
			int value2=Integer.parseInt(req.getParameter("t2"));
			int add=value1+value2;
			pw.println("<center><b><font color=red>Addition of "+value1+" and "+value2+" ="+add+"</b><br></center>");
			pw.println("<a href='form.html'>HOME PAGE</a>");
		}else if(link.equalsIgnoreCase("sub")) {
			int value1=Integer.parseInt(req.getParameter("t1"));
			int value2=Integer.parseInt(req.getParameter("t2"));
			int sub=value1-value2;
			pw.println("<center><b><font color=red>Substraction of "+value1+" and "+value2+" ="+sub+"</b><br></center>");
			pw.println("<a href='form.html'>HOME PAGE</a>");
		}else {
			int value1=Integer.parseInt(req.getParameter("t1"));
			int value2=Integer.parseInt(req.getParameter("t2"));
			int mul=value1*value2;
			pw.println("<center><b><font color=red>Multiplication of "+value1+" and "+value2+" ="+mul+"</b><br></center>");
			pw.println("<a href='form.html'>HOME PAGE</a>");
		}
		pw.close();
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
