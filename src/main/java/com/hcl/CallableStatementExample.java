package com.hcl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CallableStatementExample {
	// PLSQL
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/junebatch", "root", "1234567890");
				CallableStatement cst = con.prepareCall("{call inserttemp(?,?,?)}")) {
			cst.setInt(1, 7);
			cst.setString(2, "Luis");
			cst.setString(3, "NY");
			int y = cst.executeUpdate();
			System.out.println(y);
		} catch (Exception e) {
		}
	}

}
