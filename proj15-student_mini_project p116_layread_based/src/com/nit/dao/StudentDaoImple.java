package com.nit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nit.bo.StudentBO;

public class StudentDaoImple implements StudentDao {
	private static String query="INSERT INTO STUDENT_SERVLET VALUES(?,?,?,?,?,?,?,?)";

	@Override
	public int insertStudentRecord(StudentBO bo) {
		InitialContext ic=null;
		DataSource ds=null;
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		try {
			//create intitalContext
			ic=new InitialContext();
			//get Datasource object throw lookup operation
			ds = (DataSource) ic.lookup("java:/comp/env/DsJndi");
			//get connection from jdbc Conenction Pool
			con=ds.getConnection();
			//create PrepateStatement
			ps=con.prepareStatement(query);
			System.out.println(bo);
			//set param
			ps.setInt(1, bo.getNo());
			ps.setString(2, bo.getName());
			ps.setInt(3, bo.getMark1());
			ps.setInt(4, bo.getMark2());
			ps.setInt(5, bo.getMark3());
			ps.setInt(6, bo.getTotal());
			ps.setFloat(7, bo.getPersent());
			ps.setString(8, bo.getStatus());
			//execute query
			result=ps.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
