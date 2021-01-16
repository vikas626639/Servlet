package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

@WebServlet(asyncSupported = true, urlPatterns = { "/Life_Cycle_Test_Servlet" }, loadOnStartup = 1)
public class Life_Cycle_Test_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Life_Cycle_Test_Servlet() {
        System.out.println("Life_Cycle_Test_Servlet.--> 0 param constructor");
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	System.out.println("Life_Cycle_Test_Servlet---->init()");
    }

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("Life_Cycle_Test_Servlet----->service()");
		//set content type
		res.setContentType("text/html");
		//get Printwriter object
		PrintWriter pw = res.getWriter();
		//write the responce
		Date d=new Date();
		pw.println("<b><center>Today Date is="+d+"</center></b>");
		((HttpServletResponse) res).setHeader("refresh","1");
		pw.close();
		
	}//service
	@Override
	public void destroy() {
		System.out.println("Life_Cycle_Test_Servlet.destroy()");
	}
}//class
