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


@WebServlet(asyncSupported = true, urlPatterns = { "/Servlet1" })
public class Servlet1 extends HttpServlet {
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
		//set data in request scope
		req.setAttribute("req1", "val1");
		//set data in Session Scope
		ses=req.getSession();
		ses.setAttribute("ses1", "val2");
		//create ServletContext/application scope and set data
		sc=req.getServletContext();
		sc.setAttribute("app1", "val3");
		//forword the request to servlet2 componenet
		rd=req.getRequestDispatcher("/Servlet2");
		rd.forward(req, res);
		//close the stream
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
