package com.nit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nit.dto.StudentDTO;
import com.nit.service.StudentService;
import com.nit.service.StudentServiceImpl;

@WebServlet(asyncSupported = true, urlPatterns = { "/StudentController" })
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public StudentController() {
       System.out.println("*******STUDENT CONTROLLER 0 PARAM CONSTRUCTOR*******");
    }

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//set content type
		res.setContentType("text/html");
		StudentDTO dto=null;
		StudentService service=null;
		String result=null;
		//get Writer 
		PrintWriter pw=null;
		//read form data
		Integer no=Integer.parseInt(req.getParameter("no"));
		String name=req.getParameter("name");
		Integer m1=Integer.parseInt(req.getParameter("m1"));
		Integer m2=Integer.parseInt(req.getParameter("m2"));
		Integer m3=Integer.parseInt(req.getParameter("m3"));
		
		System.err.println(no+","+name+" "+m1+" "+m2+" "+m3);
		
		//put data into the dto class object
		dto=new StudentDTO();
		dto.setNo(no);
		dto.setName(name);
		dto.setMark1(m1);
		dto.setMark2(m2);
		dto.setMark3(m3);
		
		//use service
		service=new StudentServiceImpl();
		result=service.GenerateResult(dto);
		pw=res.getWriter();
		pw.println("<b><center>"+result+"</center></b>");
		pw.println("<a href='form.html'>Home</a>");
		}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	public void destroy() {
		System.out.println("StudentController.destroy()");
	}
}
