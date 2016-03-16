package com.zero.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zero.entity.CreditTemplateAllInfo;
import com.zero.entity.InvestTemplateAllInfo;
import com.zero.utils.DBUtils_Hive;
import com.zero.utils.JobServiceCon;

/**
 * 模拟数据服务
 * 
 * @author WangHong
 * 
 */
@Service
public class SimulationDataService {
	/**
	 * 根据需要生成信用模拟数据，并返回前十条数据（系统1）
	 * 
	 * @param allInfo
	 *            包含模板所有信息的javabean
	 * @return
	 */
	
	@Autowired
	DBUtils_Hive hive;
	
	public String[][] generateCreditSimulationData(CreditTemplateAllInfo allInfo) {
		String userAndTime = allInfo.getUseUser().getAdminName()
				+ allInfo.getTime();
		String dataSaveDir = "/tmp/makedata/" + userAndTime;
		String scopeInput = allInfo.getCreditTemplateContext().getMinAge()
				+ "s" + allInfo.getCreditTemplateContext().getMaxAge() + "s"
				+ allInfo.getCreditTemplateContext().getMinMonthlyIncome()
				+ "s"
				+ allInfo.getCreditTemplateContext().getMaxMounthlyIncome()
				+ "s" + allInfo.getCreditTemplateContext().getMinWorkYears()
				+ "s" + allInfo.getCreditTemplateContext().getMaxWorkYears();
		// 生成数据
		String[][] dataarr = JobServiceCon.runMakedataJobAndGetDoubleArr1(
				"sc11", Integer.valueOf(allInfo.getGenerateNums()), dataSaveDir,
				userAndTime, "/tmp/modelsave/model", scopeInput, 40);
		// 将生成数据插入hive
		Connection con = hive.getConn();
		String sql = "ALTER TABLE makedata1_table ADD PARTITION (v63='"
				+ userAndTime + "') location '" + dataSaveDir + "'";
		DBUtils_Hive.exeStatement(DBUtils_Hive.getStatement(con), sql);
		// 返回十个
		return dataarr;
	}

	public String[][] generateInvestSimulationData(InvestTemplateAllInfo allInfo) {
		String userAndTime = allInfo.getUseUser().getAdminName()
				+ allInfo.getTime();
		String dataSaveDir = "/tmp/makedata2/" + userAndTime;
		String[][] dataarr = JobServiceCon.runMakedataJobAndGetDoubleArr2(
				"sc12", Integer.valueOf(allInfo.getGenerateNums()), dataSaveDir,
				userAndTime, 20);
		// 将生成数据插入hive
		Connection con = hive.getConn();
		String sql = "ALTER TABLE makedata2_table ADD PARTITION (v15='"
				+ userAndTime + "') location '" + dataSaveDir + "'";
		try {
			Statement stmt = con.createStatement();
			System.out.println(sql);
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBUtils_Hive.exeStatement(DBUtils_Hive.getStatement(con),sql);
		// 返回十个
		return dataarr;
	}
}

// ResultSet resultSet=DBUtils_Hive.getResultSet(DBUtils_Hive.getStatement(con),
// "ALTER TABLE makedata1_table ADD PARTITION (v63='admin201511241940') location '/tmp/makedata/admin201511241940'");
// ResultSet resultSet=DBUtils_Hive.getResultSet(DBUtils_Hive.getStatement(con),
// "LOAD DATA INPATH '/tmp/makedata/admin201511241940' INTO TABLE makedata1_table PARTITION(v63='admin201511241940')");
