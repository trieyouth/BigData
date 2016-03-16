package com.zero.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zero.entity.PersonalCreditQuery;
import com.zero.entity.Singleusercreditinformation;
import com.zero.entity.Singleuserriskinformation;
import com.zero.utils.DBUtils_Hive;

/**
 * 提供一些需要查询Hive的服务
 * @author WangHong
 *
 */

@Service
public class HiveQueryService {
	private static Random random=new Random(10);
	/**
	 * 根据传入的用户card id获得用户全部信用信息
	 * 
	 * @param nums
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<String> getInfoByCardnums(String nums) throws SQLException {
		ResultSet resultSet = DBUtils_Hive.getResultSet(
				DBUtils_Hive.getStatement(DBUtils_Hive.getConn()),
				"select * from makedata1_table_orc where v2=" + nums);
		System.out.println("10000=== "+nums);
		ArrayList list = new ArrayList<String>();
		//System.out.println("10000=== "+list.size());
		while (resultSet.next()) {
			for (int i = 1; i < 64; i++) {
				list.add(resultSet.getString(i));
			}
		}
		return list;
	}
	/**
	 * 根据传入的用户card id获得用户全部投资信息，注意输入的字符串一定是8位字符串！！！！！！！！！！！
	 * @param nums
	 * @return
	 * @throws SQLException 
	 */
	public ArrayList<String> getInfobyCardnums2(String nums) throws SQLException{
		ResultSet resultSet = DBUtils_Hive.getResultSet(
				DBUtils_Hive.getStatement(DBUtils_Hive.getConn()),
				"select * from makedata2_table where v1=" + nums);
		ArrayList list = new ArrayList<String>();
		while (resultSet.next()) {
			for (int i = 1; i < 16; i++) {
				list.add(resultSet.getString(i));
			}
		}
		return list;
	}
	/**
	 * 模糊查询符合条件的用户的信用信息
	 * 
	 * @param personalCreditQuery
	 * @return
	 * @throws SQLException 
	 */
	public ArrayList<ArrayList<String>> getInfoArrByFuzzy(
			
			PersonalCreditQuery personalCreditQuery) throws SQLException {
		System.out.println("start");
		// 范围转化为字符串
		String minAge = String.valueOf(personalCreditQuery.getMinAge());// v14
		String minMonthlyIncome = String.valueOf(personalCreditQuery
				.getMinMonthlyIncome() * 12);// v9/12
		String minWorkYears = String.valueOf(personalCreditQuery
				.getMinWorkYears() * 12);// v20/12
		String minCreditNum = String.valueOf(personalCreditQuery
				.getMinCreditNum());// v50
		String minLoansNum = String.valueOf(personalCreditQuery
				.getMinLoansNum());// v37
		String minLoansAmount = String.valueOf(personalCreditQuery
				.getMinLoansAmount());// v38
		String minApplyForLoanNum = String.valueOf(personalCreditQuery
				.getMinApplyForLoanNum());// v24

		String maxAge = String.valueOf(personalCreditQuery.getMaxAge());
		String maxMonthlyIncome = String.valueOf(personalCreditQuery
				.getMaxMonthlyIncome() * 12);
		String maxWorkYears = String.valueOf(personalCreditQuery
				.getMaxWorkYears() * 12);
		String maxCreditNum = String.valueOf(personalCreditQuery
				.getMaxCreditNum());
		String maxLoansNum = String.valueOf(personalCreditQuery
				.getMaxLoansNum());
		String maxLoansAmount = String.valueOf(personalCreditQuery
				.getMaxLoansAmount());
		String maxApplyForLoanNum = String.valueOf(personalCreditQuery
				.getMaxApplyForLoanNum());
		// 新建对象存放返回结果
		ArrayList<ArrayList<String>> lists = new ArrayList<>();
		// 得到查询结果集合
//		String sql="select * from makedata1_table_orc where v14>" + minAge
//				+ " And v14<" + maxAge + " And v9>" + minMonthlyIncome
//				+ " And v9<" + maxMonthlyIncome + " And v20>"
//				+ minWorkYears + " And v20<" + maxWorkYears
//				+ " And v50>" + minCreditNum + " And v50<"
//				+ maxCreditNum + " And v37>" + minLoansNum
//				+ " And v37<" + maxLoansNum + " And v38>"
//				+ minLoansAmount + " And v38<" + maxLoansAmount
//				+ " And v24>" + minApplyForLoanNum + " And v24<"
//				+ maxApplyForLoanNum;
		
		String sql="select * from makedata1_table_orc where cast(v14 as bigint)>" + Integer.parseInt(minAge)
				+ " And cast(v14 as  bigint)<" + Integer.parseInt(maxAge) + " And cast(v9 as bigint)>" + Integer.parseInt(minMonthlyIncome)
				+ " And cast(v9 as bigint)<" + Integer.parseInt(maxMonthlyIncome) + " And cast(v20 as bigint)>"
				+ Integer.parseInt(minWorkYears) + " And cast(v20 as bigint)<" + Integer.parseInt(maxWorkYears)
				+ " And cast(v50 as bigint)>" + Integer.parseInt(minCreditNum) + " And cast(v50 as bigint)<"
				+ Integer.parseInt(maxCreditNum) + " And cast(v37 as bigint)>" + Integer.parseInt(minLoansNum)
				+ " And cast(v37 as bigint)<" + Integer.parseInt(maxLoansNum) + " And cast(v38 as bigint)>"
				+ Integer.parseInt(minLoansAmount) + " And cast(v38 as bigint)<" + Integer.parseInt(maxLoansAmount)
				+ " And cast(v24 as bigint)>" + Integer.parseInt(minApplyForLoanNum) + " And cast(v24 as bigint)<"
				+ Integer.parseInt(maxApplyForLoanNum) +"  limit 1000";
		
		System.out.println(sql);
		ResultSet resultSet = DBUtils_Hive.getResultSet(
				DBUtils_Hive.getStatement(DBUtils_Hive.getConn()),sql);
		
		while(resultSet.next()){
			ArrayList<String> list=new ArrayList<>();
			for (int i = 1; i < 64; i++) {
				//System.out.print(resultSet.getString(i));
				list.add(resultSet.getString(i));
			}
			lists.add(list);
		}
		return lists;
	}
	/*
	 * 新的模糊查询， 系统一
	 * @return id
	 */
	public String getInfoCreditReturnId (Singleusercreditinformation singleusercreditinformation)
	{
		String res="";
		String age=singleusercreditinformation.getAge();
		String monthlyIncome=Integer.parseInt(singleusercreditinformation.getMonthlyIncome())*1+"";
		String creditNum=singleusercreditinformation.getCreditNum();
		String houseLoan=singleusercreditinformation.getHouseLoan();
		ArrayList<ArrayList<String>> lists = new ArrayList<>();
		String sql="select * from makedata1_table_orc where cast (v14 as bigint)="+Integer.parseInt(age)+
				" And cast(v9 as bigint)="+Integer.parseInt(monthlyIncome)+" And cast(v50 as bigint)="+
				Integer.parseInt(creditNum)+" limit 1";
		System.out.println(sql);
		ResultSet resultSet = DBUtils_Hive.getResultSet(
				DBUtils_Hive.getStatement(DBUtils_Hive.getConn()),sql);
		try {
			while(resultSet.next()){
				ArrayList<String> list=new ArrayList<>();
				for (int i = 1; i < 64; i++) {
					list.add(resultSet.getString(i));
				}
				lists.add(list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(lists.size()>0)
			res+=lists.get(0).get(1);
		return res;
	}
	
	/*
	 * 新的模糊查询， 系统一
	 * @return id
	 */
	public String getInfoRiskReturnId (Singleuserriskinformation singleuserriskinformation)
	{
		String res="";
		String age="";
		String proportionOfIncome="";
		if(Integer.parseInt(singleuserriskinformation.getAge())<=30)
				age="30岁以下";
		else if(Integer.parseInt(singleuserriskinformation.getAge())>30&&Integer.parseInt(singleuserriskinformation.getAge())<=40)
			   age="31-40岁";
		else if(Integer.parseInt(singleuserriskinformation.getAge())>40&&Integer.parseInt(singleuserriskinformation.getAge())<=50)
			   age="41-50岁";
		else if(Integer.parseInt(singleuserriskinformation.getAge())>50&&Integer.parseInt(singleuserriskinformation.getAge())<=60)
			   age="51-60岁";
		else if(Integer.parseInt(singleuserriskinformation.getAge())>60)
			age="60岁以上";
		if(Integer.parseInt(singleuserriskinformation.getProportionOfIncome())<10)
			proportionOfIncome="10%以下";
		else if(Integer.parseInt(singleuserriskinformation.getProportionOfIncome())>=10&&Integer.parseInt(singleuserriskinformation.getProportionOfIncome())<=30)
			proportionOfIncome="10%-30%";
		else if(Integer.parseInt(singleuserriskinformation.getProportionOfIncome())>30&&Integer.parseInt(singleuserriskinformation.getProportionOfIncome())<=50)
			proportionOfIncome="30%-50%";
		else if(Integer.parseInt(singleuserriskinformation.getProportionOfIncome())>50&&Integer.parseInt(singleuserriskinformation.getProportionOfIncome())<=70)
			proportionOfIncome="50%-70%";
		else if(Integer.parseInt(singleuserriskinformation.getProportionOfIncome())>70)
			proportionOfIncome="70%以上";
		
		ArrayList<ArrayList<String>> lists = new ArrayList<>();
		String sql="select * from makedata2_table where  v2='"+age+
				"' And v3='"+proportionOfIncome+"' limit 1";
		System.out.println(sql);
		ResultSet resultSet = DBUtils_Hive.getResultSet(
				DBUtils_Hive.getStatement(DBUtils_Hive.getConn()),sql);
		try {
			while(resultSet.next()){
				ArrayList<String> list=new ArrayList<>();
				for (int i = 1; i < 16; i++) {
					list.add(resultSet.getString(i));
				}
				lists.add(list);
			}
			System.out.println(lists.size()+"fffffffffffffffffffffffffffffffffff");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(lists.size()>0)
			res+=lists.get(0).get(0);
		return res;
	}
	/**
	 * 模糊查询符合条件的用户的投资信息
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<ArrayList<String>> getInfoArrByFuzzy2() throws SQLException{
		String sql="select * from makedata2_table_orc limit "+random.nextInt(30);
		ResultSet resultSet = DBUtils_Hive.getResultSet(
				DBUtils_Hive.getStatement(DBUtils_Hive.getConn()),sql);
		ArrayList<ArrayList<String>> lists = new ArrayList<>();
		while(resultSet.next()){
			ArrayList<String> list=new ArrayList<>();
			for (int i = 1; i < 16; i++) {
				list.add(resultSet.getString(i));
			}
			lists.add(list);
		}
		return lists;
	}
}
