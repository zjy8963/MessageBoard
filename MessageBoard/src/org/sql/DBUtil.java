package org.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//通用的数据操作方法
public class DBUtil {
	
	//提出来是单例程的，应该是不能多线程访问的，不过对于简单的例子还是可以实行的。
	//日期转换时存在时区问题
	private static final String URL = "jdbc:mysql://localhost:3306/messageboard?serverTimezone=GMT%2B8&useTimezone=true";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "123";
	public static Connection connection = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs = null;
	
	//通用增删改
	public static int executeUpdate(String sql, Object[] params) {
		try {
			//Object[] obs = {String, int, ...};
			//将sql中？填充，之后可以运行。
			pstmt = createPreparedStatement(sql, params);
			
			int count = pstmt.executeUpdate();
			
			if(count > 0) {
				return count;
			}else {
				return 0;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return -1;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally {
			closeAll(null, pstmt, connection);
		}
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
	
	public static PreparedStatement createPreparedStatement(String sql, Object[] params) throws ClassNotFoundException, SQLException {
		pstmt = getConnection().prepareStatement(sql);
		if(params != null) {
			for(int i = 0; i < params.length; i++) {
				pstmt.setObject(i+1, params[i]);
			}
		}
		return pstmt;
	}
	
	public static void closeAll(ResultSet rs, Statement stmt, Connection connection) {
		try {
			if(rs != null)	rs.close();
			if(pstmt != null)	pstmt.close();
			if(connection != null)	connection.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void closeAll(ResultSet rs) {
		try {
			if(rs != null)	rs.close();
			if(pstmt != null)	pstmt.close();
			if(connection != null)	connection.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//通用的查询， 返回值是一个集合。
	//通用表示适合于任何查询
	//这样的返回值，有关数据库的连接都没有关闭
	public static ResultSet executeQuery(String sql, Object[] params) {
		try {
			pstmt = createPreparedStatement(sql, params);
			
			rs = pstmt.executeQuery();
			
			return rs;
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
}
