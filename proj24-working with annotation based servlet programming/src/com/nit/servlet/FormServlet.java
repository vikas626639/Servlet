package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(asyncSupported = true, urlPatterns = { "/FormServlet" },
			initParams = @WebInitParam(name = "user", value = "system"))
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FormServlet() {
      System.out.println("FormServlet.FormServlet()");
    }


	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	//set content type
		res.setContentType("text/html");
		//get Writer 
		PrintWriter pw=null;
		//read form data
		String name=req.getParameter("user");
		String pwd=req.getParameter("pwd");
		pw=res.getWriter();
		if(name.equals("raja") && pwd.equals("rani")) {
			pw.println("<h1><center>VALID CREDENTIAL</center></h1>");
		}else {
			pw.println("<h1><center>InVALID CREDENTIAL</center></h1>");			
		}
		pw.println("<a href='form.html'>homepage</a>");
		ServletConfig cg=getServletConfig();
		String user=cg.getInitParameter("user");
		pw.println("DB user init param value="+user);
		pw.close();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
