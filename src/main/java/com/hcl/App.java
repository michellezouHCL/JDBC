package com.hcl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/junebatch", "root", "1234567890");
		Statement st = con.createStatement();
		st.execute("create table emp(eno numeric(10),ename varchar(50),eaddress varchar(100),primary key(eno))");
		st.execute("insert into emp values(1, 'luis','SanAntonio')");
		st.execute("insert into emp values(2, 'akin','SanAntonio')");
		st.execute("insert into emp values(3, 'Physa','SanAntonio')");
		st.execute("insert into emp values(4, 'Hesham','SanAntonio')");
		st.execute("insert into emp values(5, 'Tom','SanAntonio')");
		st.execute("insert into emp values(6, 'Tom','SanAntonio')");

		st.execute("update emp set eaddress='Dallas' where eno=5");
		st.execute("delete from emp where eno=6");

		ResultSet rs = st.executeQuery("select * from emp");
		while (rs.next()) {
			System.out.println("Emp Id :" + rs.getInt(1));
			System.out.println("Emp Name:" + rs.getString("ename"));
			System.out.println("Emp Address:" + rs.getString(3));
		}

		st.close();
		con.close();
		rs.close();
	}
}
