package com.zero.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hive连接
 * 
 * @author WangHong
 * 
 */

public class DBUtils_Hive {
	private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";
	// 加载驱动
	static {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 获得连接
	public static Connection getConn() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(
					"jdbc:hive://172.23.27.193:10000/default","","");
			System.out.println("Get connection succesed.");
		} catch (SQLException e) {
			System.out.println("Get connection failed.");
			e.printStackTrace();
		}
		return conn;
	}

	// 建表
	void createTable(Statement stmt, String tableName) throws SQLException {
		String sql = "create table "
				+ tableName
				+ " (key int, value string)  row format delimited fields terminated by '\t'";
		stmt.execute("drop table if exists " + tableName);
		stmt.executeQuery(sql);
		System.out.println("Create table success!");
	}

	// 删表
	static String dropTable(Statement stmt, String tableName)
			throws SQLException {
		// 创建的表名
		String sql = "drop table " + tableName;
		stmt.executeQuery(sql);
		System.out.println("drop table success!");
		return tableName;
	}

	// 加载指定数据到指定表
	static void loadData(Statement stmt, String tableName) throws SQLException {
		String filepath = "/home/test.txt";
		String sql = "load data local inpath '" + filepath + "' into table "
				+ tableName;
		System.out.println("Running:" + sql);
		ResultSet res = stmt.executeQuery(sql);
	}
	// 执行sql语句
	public static Boolean exeStatement(Statement stmt, String sql) {
			try {
				return stmt.execute(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return false;
	}
	// 执行sql查询
	public static ResultSet getResultSet(Statement stmt, String sql) {
		ResultSet res = null;
		try {
			res = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	// 执行sql查询(通过预处理Statement)
	public static ResultSet getResultSet(PreparedStatement pstmt) {
		ResultSet res = null;
		try {
			res = pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

	// 获得Statement
	public static Statement getStatement(Connection conn) {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}

	// 获得预处理Statement
	public static PreparedStatement getPreparedStatement(Connection conn,
			String sql) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;

	}

	// 关闭资源
	public static void close(Connection conn, Statement stmt, ResultSet res) {
		close(res);
		close(stmt);
		close(conn);
	}

	// close connection
	private static void close(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
				conn = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// close statement
	private static void close(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// close resultset
	private static void close(ResultSet res) {
		try {
			if (res != null) {
				res.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
