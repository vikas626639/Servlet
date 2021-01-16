package com.nit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadFile;


@WebServlet(asyncSupported = true, urlPatterns = { "/UpServlet" })
public class UpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//set content type
		res.setContentType("text/html");
		//get Writer 
		PrintWriter pw=null;
		MultipartFormDataRequest data=null;
		UploadBean bean=null;
		Hashtable ht=null;
		Enumeration e=null;
		try {
			pw=res.getWriter();
			//prepare special request object
			data=new MultipartFormDataRequest(req);
			//specify file uploading setting
			bean=new UploadBean();
			bean.setFolderstore("E:/store");
			bean.setOverwrite(false);
			//complete file uploading
			bean.store(data);
			//display the name of uploading file
			pw.println("<h1>The uploaded file are</h1>");
			ht=data.getFiles();
			e=ht.elements();
			while(e.hasMoreElements()) {
				UploadFile file = (UploadFile) e.nextElement();
				pw.println("<br>"+file.getFileName()+" "+file.getFileSize());
			}//while	
		} catch (Exception e1) {
			e1.printStackTrace();
		}//catch
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
