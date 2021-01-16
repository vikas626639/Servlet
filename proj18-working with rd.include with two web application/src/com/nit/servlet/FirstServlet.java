package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FirstServlet() {
        // TODO Auto-generated constructor stub
    }

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get RequestDisptacher
		RequestDispatcher rd=null;
		rd=req.getRequestDispatcher("/SecondServlet");
		rd.include(req, res);
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		//read form data
		int no=Integer.parseInt(req.getParameter("v1"));
		int squre=no*no;
		pw.print("<center><h1>SQURE ="+squre+"</h1></center>");
		pw.print("<a href='index.html'>home page</a>");
		pw.close();
	}

		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
