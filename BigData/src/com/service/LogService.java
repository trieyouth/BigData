package com.service;

import java.util.Date;
import java.util.List;

import com.entity_dao.Logweb;
import com.entity_dao.LogwebDAO;

public class LogService {
	private LogwebDAO logWebDao = new LogwebDAO();

	public LogService() {
		// TODO Auto-generated constructor stub
	}

	public List<Logweb> selectAllLog() {
		return logWebDao.findAll();
	}

	public void saveLog(Logweb logweb) {
		logWebDao.save(logweb);
	}

	public void saveTemplateLog(int adminID, int templateID) {
		Logweb logWeb = new Logweb();
		logWeb.setAdminId(adminID);
		logWeb.setLogDate(new Date());
		logWeb.setLogTime(new java.sql.Time(new java.util.Date().getTime()));
		logWeb.setLogConten("����" + templateID + "ģ��");
		saveLog(logWeb);
	}
	public void useTemplateLog(int adminID, int templateID) {
		Logweb logWeb = new Logweb();
		logWeb.setAdminId(adminID);
		logWeb.setLogDate(new Date());
		logWeb.setLogTime(new java.sql.Time(new java.util.Date().getTime()));
		logWeb.setLogConten("ʹ��" + templateID + "ģ��");
		saveLog(logWeb);
	}
	public void deleteTemplateLog(int adminID, int templateID) {
		Logweb logWeb = new Logweb();
		logWeb.setAdminId(adminID);
		logWeb.setLogDate(new Date());
		logWeb.setLogTime(new java.sql.Time(new java.util.Date().getTime()));
		logWeb.setLogConten("ɾ��" + templateID + "ģ��");
		saveLog(logWeb);
	}
	public void saveProductLog(int adminID, int productID) {
		Logweb logWeb = new Logweb();
		logWeb.setAdminId(adminID);
		logWeb.setLogDate(new Date());
		logWeb.setLogTime(new java.sql.Time(new java.util.Date().getTime()));
		logWeb.setLogConten("����" + productID + "��Ʒ");
		saveLog(logWeb);
	}
	public void deleteProductLog(int adminID, int productID) {
		Logweb logWeb = new Logweb();
		logWeb.setAdminId(adminID);
		logWeb.setLogDate(new Date());
		logWeb.setLogTime(new java.sql.Time(new java.util.Date().getTime()));
		logWeb.setLogConten("ɾ��" + productID + "ģ��");
		saveLog(logWeb);
	}
	public void insertUserLog(int adminID,String newUserName) {
		Logweb logWeb = new Logweb();
		logWeb.setAdminId(adminID);
		logWeb.setLogDate(new Date());
		logWeb.setLogTime(new java.sql.Time(new java.util.Date().getTime()));
		logWeb.setLogConten("������" + newUserName + "�û�");
		saveLog(logWeb);
	}
}
