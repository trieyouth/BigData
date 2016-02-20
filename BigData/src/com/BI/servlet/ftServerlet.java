package com.BI.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.HiveService;

@WebServlet("/ftServerlet")
public class ftServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ftServerlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Connection connection = null;
		Statement stmt = null;
		try {
			HiveService service = new HiveService();
			// 建立JDBC连接
			while (null == connection) {
				connection = service.getConnection();
			}
			stmt = connection.createStatement();
			String sql = "select v2,v3,count(*) from  makedata2_table_orc group by v2,v3 order by v2,v3";
			ResultSet res = stmt.executeQuery(sql);
			
			String msg1 = "";
			String msg2 = "";
			String msg3 = "";
			String msg4 = "";
			String msg5 = "";
			String msg = "";
			while (res.next()) {
				if (res.getString(1).equals("30岁以下")) {
					msg1 += res.getString(3) + ",";
				} else if (res.getString(1).equals("31-40岁")) {
					msg2 += res.getString(3) + ",";
				} else if (res.getString(1).equals("41-50岁")) {
					msg3 += res.getString(3) + ",";
				} else if (res.getString(1).equals("51-60岁")) {
					msg4 += res.getString(3) + ",";
				} else {
					msg5 += res.getString(3) + ",";
				}
			}
			msg += msg1.substring(0, msg1.length() - 1) + ";"
					+ msg2.substring(0, msg2.length() - 1) + ";"
					+ msg3.substring(0, msg3.length() - 1) + ";"
					+ msg4.substring(0, msg4.length() - 1) + ";"
					+ msg5.substring(0, msg5.length() - 1);
			out.print(msg);
			System.out.println(msg);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			try {
				if (connection != null) {
					connection.close();
					connection = null;
				}
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}