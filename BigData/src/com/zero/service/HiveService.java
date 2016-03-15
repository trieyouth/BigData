package com.zero.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;

@Service
public class HiveService {

	private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";
	private static String ip = "172.23.27.190";
	private static int port = 10000;
	private static String sql = null;
	private static ResultSet res;

	public HiveService() {

	}

	public Connection getConnection() {
		Connection connection = null;
		try {
			try {
				Class.forName(driverName);

				connection = DriverManager.getConnection("jdbc:hive://" + ip
						+ ":" + port + "/default", "", "");
				System.out.println("Get connection succesed.");
			} catch (SQLException e) {
				System.out.println("Get connection failed.");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	static void countData(Statement stmt, String tableName) throws SQLException {
		sql = "select count(1) from " + tableName;
		System.out.println("Running:" + sql);
		res = stmt.executeQuery(sql);
		System.out.println("执行“regular hive query”运行结果:");
		while (res.next()) {
			System.out.println("count ------>" + res.getString(1));
		}
	}

	static void selectData(Statement stmt, String tableName)
			throws SQLException {
		sql = "select * from " + tableName;
		System.out.println("Running:" + sql);
		res = stmt.executeQuery(sql);
		System.out.println("执行 select * query 运行结果:");
		while (res.next()) {
			System.out.println(res.getInt(1) + "\t" + res.getString(2));
		}
	}

	static void loadData(Statement stmt, String tableName) throws SQLException {
		String filepath = "/home/test.txt";
		sql = "load data local inpath '" + filepath + "' into table "
				+ tableName;
		System.out.println("Running:" + sql);
		res = stmt.executeQuery(sql);
	}

	static void describeTables(Statement stmt, String tableName)
			throws SQLException {
		sql = "describe " + tableName;
		System.out.println("Running:" + sql);
		res = stmt.executeQuery(sql);
		System.out.println("执行 describe table 运行结果:");
		while (res.next()) {
			System.out.println(res.getString(1) + "\t" + res.getString(2));
		}
	}

	static void showTables(Statement stmt, String tableName)
			throws SQLException {
		sql = "show tables '" + tableName + "'";
		System.out.println("Running:" + sql);
		res = stmt.executeQuery(sql);
		System.out.println("执行 show tables 运行结果:");
		if (res.next()) {
			System.out.println(res.getString(1));
		}
	}

	void createTable(Statement stmt, String tableName) throws SQLException {
		String sql = "create table "
				+ tableName
				+ " (key int, value string)  row format delimited fields terminated by '\t'";
		stmt.execute("drop table if exists " + tableName);
		stmt.executeQuery(sql);
		System.out.println("Create table success!");
	}

	static String dropTable(Statement stmt, String tableName)
			throws SQLException {
		// 创建的表名
		String sql = "drop table " + tableName;
		stmt.executeQuery(sql);
		System.out.println("drop table success!");
		return tableName;
	}

	/**
	 * 查询操作
	 * 
	 * @param sql
	 * @param st
	 * @throws SQLException
	 */
	public void select(String sql, Statement st) throws SQLException {
		ResultSet res = st.executeQuery(sql);
		ResultSetMetaData rsmd = res.getMetaData();

		int count = rsmd.getColumnCount();
		String columns = "";

		// 打印列名
		for (int i = 0; i < count; i++) {
			columns = columns + rsmd.getColumnName(i + 1) + "\t";
		}
		System.out.println(columns);
		columns = "";
		while (res.next()) {

			// 打印列名
			for (int i = 0; i < count; i++) {
				columns = columns + res.getString(i + 1) + "\t";
			}
			System.out.println(columns);
			columns = "";
		}
	}

}
