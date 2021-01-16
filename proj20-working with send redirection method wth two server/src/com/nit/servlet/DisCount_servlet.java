package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(asyncSupported = true, urlPatterns = { "/DisCount_servlet" })
public class DisCount_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public DisCount_servlet() {
        // TODO Auto-generated constructor stub
    }

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get content type
				res.setContentType("text/html");
				//get Writer
				PrintWriter pw=res.getWriter();
				//read request  data from source page
				float total=Float.parseFloat(req.getParameter("total"));
				String name=req.getParameter("name");
				
				System.out.println("From discount servlet do get method()");
				float discount=total*0.3f;
				float finalAmt=total-discount;
				//dislay data
				pw.println("<br>Item name :"+name);
				pw.println("<br>BillAmount :"+total);
				pw.println("<br>Discount :"+discount);
				pw.println("<br>Final Amount :"+finalAmt);
				pw.close();
	}//close stram

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
