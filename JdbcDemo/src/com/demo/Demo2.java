package com.demo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo2 {
 public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	Connection con= DriverManager.getConnection(url,"system","ankush");
	PreparedStatement st=con.prepareStatement("select * from cg_employee where sal between ? and ?");
	st.setDouble(1, 10000);
	st.setDouble(2,15000);
	ResultSet rs=st.executeQuery();
	while(rs.next()) {
		System.out.println("eid"+rs.getInt("eid"));
		System.out.println("ename"+rs.getInt("ename"));
		System.out.println(".sal"+rs.getInt("sal"));
		System.out.println("dept"+rs.getInt("dept"));
		System.out.println("doj"+rs.getInt("doj"));
	}	
	con.close();
 }
}
		