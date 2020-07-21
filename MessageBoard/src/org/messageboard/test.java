package org.messageboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.sql.ConnectionPool;
import org.sql.SQLUtil;

public class test {
	public static String test1() {
		ConnectionPool pool = ConnectionPool.getinstance();
		Connection conn = pool.getConnection();
		
		String sql = "select * from user";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			String str = SQLUtil.getHtmlTable(rs);
		
			System.out.println(str);
			return str;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			pool.freeConnection(conn);
		}
		
		
	}
}
