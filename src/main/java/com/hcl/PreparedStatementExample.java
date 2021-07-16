package com.hcl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedStatementExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/junebatch", "root",
				"1234567890");
				PreparedStatement pst = con.prepareStatement("insert into emp(eno,ename,eaddress) values(?,?,?)")) {
			// this would prevent SQLInjection
			pst.setInt(1, 6);
			pst.setString(2, "Aaron");
			pst.setString(3, "Wisconsin");
			int x = pst.executeUpdate();
			System.out.println(x);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
