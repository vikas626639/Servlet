package com.nit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(asyncSupported = true, urlPatterns = { "/Serach_Servlet" })
public class Serach_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//set content type
		res.setContentType("text/html");
		//read form data
		String input=req.getParameter("ss");
		String engin=req.getParameter("engin");
		String url="";
		RequestDispatcher rd=null,rd1=null;
		if(engin.equals("google")) {
			url="https://www.google.com/search?sxsrf="+input;
		}else if(engin.equals("bing")) {
			url="https://www.bing.com/search?q="+input;			
		}else {
			url="https://in.yahoo.com/?p="+input;
		}
		System.out.println("before the search servlet");
		res.sendRedirect(url);
		rd=req.getRequestDispatcher("index.html");
		rd.include(req, res);
		System.out.println("After send redirect()");
	}//do get

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
