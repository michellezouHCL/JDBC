package com.hcl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcBatchUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/junebatch", "root",
				"1234567890");
				PreparedStatement pstInsert = con.prepareStatement("insert into emp(eno,ename,eaddress) values(?,?,?)");
				PreparedStatement pstUpdate = con.prepareStatement("update emp set eaddress=? where eno=?");
				PreparedStatement pstDelete = con.prepareStatement("delete from emp where eno=?");) {
			pstInsert.setInt(1, 8);
			pstInsert.setString(2, "John");
			pstInsert.setString(3, "McDonald");
			pstInsert.addBatch();

			pstUpdate.setString(1, "SantaClara");
			pstUpdate.setInt(2, 6);
			pstUpdate.addBatch();

			pstDelete.setInt(1, 7);
			pstDelete.addBatch();

			int[] rows1 = pstInsert.executeBatch();
			System.out.println(rows1);

			int[] rows2 = pstUpdate.executeBatch();
			System.out.println(rows2);

			int[] rows3 = pstDelete.executeBatch();
			System.out.println(rows3);

		} catch (Exception e) {
		}
	}

}
