package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(asyncSupported = true, urlPatterns = { "/Servlet2" })
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw =null;
		//get RequestDispatcher
		RequestDispatcher rd=null;
		//creting Session Scope
		HttpSession ses=null;
		//creating Application Scope
		ServletContext sc=null;
		//set content type
		res.setContentType("text/html");
		//get Writer 
		pw=res.getWriter();
		//get data from request attribure
		pw.println("Servlet 2::->Request attribute value= "+req.getAttribute("req1")+"<br>");
		//get data from Session attribure
		ses=req.getSession();
		pw.println("Servlet 2::-> Session attribute value= "+ses.getAttribute("ses1")+"<br>");
		//get data from Application attribure
		sc=req.getServletContext();
		pw.println("Servlet 2::->Application attribute value= "+sc.getAttribute("app1")+"<br>");
		pw.println("visuable in servlet 2 scope");
		//forword the request 3rd servlet
		
		 rd=req.getRequestDispatcher("/Servlet3");
		rd.forward(req, res);
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
