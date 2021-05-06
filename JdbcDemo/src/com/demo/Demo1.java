package com.demo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo1 {
 public static void main(String[] args) throws ClassNotFoundException, SQLException {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	Connection con= DriverManager.getConnection(url,"system","oracle");
	PreparedStatement st=con.prepareStatement("select * from cg_emp where dept=?");
	st.setString(1, "hr");
	ResultSet rs=st.executeQuery();
	while(rs.next()) {
		System.out.println(rs.getInt("eid"));
		System.out.println(rs.getString("ename"));
		System.out.println(rs.getDouble("sal"));
		System.out.println(rs.getString("dept"));
		System.out.println(rs.getDate("doj"));
		System.out.println("--------------");
		}
	con.close();
	
}
}
