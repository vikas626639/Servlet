package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(asyncSupported = true, urlPatterns = { "/Example_Servlet" })
public class Example_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Example_Servlet() {
    
    }

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
				//set content type
		res.setContentType("text/html");
		//get Writer 
		PrintWriter pw=res.getWriter();
		RequestDispatcher rd=null;
		int a=10;
		int b=5;
		try {
			int c=a/b;
			pw.println("<h1>value of c="+c+"</h>");			
		} catch (Exception e) {
			rd=req.getRequestDispatcher("/ErrorServlet");
			rd.forward(req, res);
		}
		pw.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
