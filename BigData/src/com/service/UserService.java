package com.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.AdimauthorityDAO;
import com.dao.AdminuserDAO;
import com.dao.AuthoritypageDAO;
import com.entity.Adimauthority;
import com.entity.AdimauthorityId;
import com.entity.Adminuser;
import com.entity.Authoritypage;
import com.entity.Logweb;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private AdminuserDAO adminuserDao;
	@Autowired
	private AdimauthorityDAO adminauthorityDao;
	@Autowired
	private AuthoritypageDAO authorityPageDao;
	public int adminID;
	
	@Autowired
	private LogService logservice;

	public UserService() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public List<Authoritypage> loginValidation(String username, String password) {
		Adminuser adminuser = new Adminuser();
		adminuser.setAdminName(username);
		adminuser.setAdminPasswd(password);
		List<Adminuser> userList = null;
		List<Adimauthority> tempAuthorityList = null;
		List<Authoritypage> authorityPageList = null;
		userList = adminuserDao.findByExample(adminuser);
		if (userList != null) {
			AdimauthorityId tempAdimAuthorityId = new AdimauthorityId();
			tempAdimAuthorityId.setAdminId(userList.get(0).getAdminId());
			Adimauthority tempAdimAuthority = new Adimauthority();
			tempAdimAuthority.setId(tempAdimAuthorityId);

			tempAuthorityList = adminauthorityDao
					.findByExample(tempAdimAuthority);
			if (tempAuthorityList != null) {
				authorityPageList = authorityPageDao
						.findByAuthId(tempAuthorityList.get(0).getId()
								.getAuthId());
				if (authorityPageList != null) {
					Logweb logWeb = new Logweb();
					logWeb.setAdminId(userList.get(0).getAdminId());
					logWeb.setLogDate(new java.sql.Date(new Date().getTime()));
					logWeb.setLogTime(new java.sql.Time(new java.util.Date()
							.getTime()));
					logWeb.setLogConten(userList.get(0).getAdminName() + " 登录");
					logservice.saveLog(logWeb);
				}
			}
		}
		return authorityPageList;
	}
	
	public Boolean loginValidation1(String username, String password) 
	{
		Adminuser adminuser = new Adminuser();
		adminuser.setAdminName(username);
		adminuser.setAdminPasswd(password);
		List<Adminuser> userList = adminuserDao.findByExample(adminuser);
		if(userList.size()!=0)
		{
			Logweb logWeb = new Logweb();
			logWeb.setAdminId(userList.get(0).getAdminId());
			logWeb.setLogDate(new Date());
			logWeb.setLogTime(new java.sql.Time(new java.util.Date()
					.getTime()));
			logWeb.setLogConten(userList.get(0).getAdminName() + " 登录");
			logservice.saveLog(logWeb);
			return true;
		}
		return false;
	}
	
	public Boolean findAuthority(String username,int pageId)
	{
		List<Adminuser> userList = adminuserDao.findByAdminName(username);
		if (userList.size() != 0) 
		{
			List<Adimauthority> tempAuthorityList = adminauthorityDao
					.findAuthId(userList.get(0).getAdminId());
			if (tempAuthorityList.size()!=0) 
			{
				for(int i=0;i<tempAuthorityList.size();i++)
				{
					List<Authoritypage> tempList=authorityPageDao.findAuthorityPage(tempAuthorityList.get(0).getId().getAuthId(), pageId);
					if(tempList.size()!=0)
					{
						return true;
					}
				}
			}
		}
		return false;
		
	}
	
	/**
	 * 更新权限
	 * 
	 * @param username
	 * @param AuthorityList
	 */
	public void updateAuthority(String username,
			List<Authoritypage> AuthorityList) {
		List<Adminuser> userList = (List<Adminuser>) adminuserDao
				.findByAdminName(username);
		List<AdimauthorityId> authorityIDList = adminauthorityDao
				.findByProperty("adminId", userList.get(0).getAdminId());
		int AuthId = authorityIDList.get(0).getAuthId();

		if (authorityPageDao.findByAuthId(AuthId).size() != 0) {
			authorityPageDao.deleteByAuthId(String.valueOf(AuthId));
		}
		for (int i = 0; i < AuthorityList.size(); i++) {
			authorityPageDao.save(AuthorityList.get(i));
		}
		Logweb logWeb = new Logweb();
		logWeb.setAdminId(adminID);
		logWeb.setLogDate(new java.sql.Date(new Date().getTime()));
		logWeb.setLogTime(new java.sql.Time(new java.util.Date().getTime()));
		logWeb.setLogConten(userList.get(0).getAdminName() + "重新设置了权限 ");
		logservice.saveLog(logWeb);
	}

	/**
	 * 获取整个权限表
	 * 
	 * @return
	 */
	public List<Authoritypage> getAuthorityList() {
		return authorityPageDao.findAll();
	}
	public List<Adminuser> getAdminUser1()
	{
		List<Adminuser> temp=adminuserDao.findAll();
		for(int i=0;i<temp.size();i++)
		{
			temp.get(i).setAdminPasswd(String.valueOf(findAuthority(temp.get(i).getAdminName())));
		}
		return temp;
	}
	
	/**
	 * 根据id查找name
	 * 
	 * @param adminId
	 * @return
	 */
	public String findAdminName(int adminId) {
		List<Adminuser> tempList = adminuserDao.findByProperty("adminId",
				adminId);
		return tempList.get(0).getAdminName();
	}

	/**
	 * 根据name查找id
	 * 
	 * @param adminName
	 * @return
	 */
	public int findAdminID(String adminName) {
		List<Adminuser> tempList = adminuserDao.findByProperty("adminName",
				adminName);
		return tempList.get(0).getAdminId();
	}
	
	public int findAuthority(String adminName)
	{
		List<Adminuser> userList = adminuserDao.findByProperty("adminName",
				adminName);
		List<Adimauthority> tempAuthorityList = adminauthorityDao
				.findAuthId(userList.get(0).getAdminId());
		return tempAuthorityList.get(0).getId().getAuthId();
	}
	public void updateAuthority(int AuthId,String adminName)
	{
		List<Adminuser> userList = adminuserDao.findByProperty("adminName",
				adminName);
		List<Adimauthority> tempAuthorityList = adminauthorityDao
				.findAuthId(userList.get(0).getAdminId());
		adminauthorityDao.deleteByAuthId(userList.get(0).getAdminId(), tempAuthorityList.get(0).getId().getAuthId());
		
		AdimauthorityId tempAdimAuthorityId1=new AdimauthorityId(AuthId,userList.get(0).getAdminId());
		Adimauthority tempAdimAuthority1=new Adimauthority(tempAdimAuthorityId1);
		adminauthorityDao.save(tempAdimAuthority1);
		Logweb logWeb = new Logweb();
		logWeb.setAdminId(adminID);
		logWeb.setLogDate(new java.sql.Date(new Date().getTime()));
		logWeb.setLogTime(new java.sql.Time(new java.util.Date().getTime()));
		logWeb.setLogConten(userList.get(0).getAdminName() + "重新设置了权限 ");
		logservice.saveLog(logWeb);
	}
	public List<Adminuser> findUserList()
	{
		return adminuserDao.findAll();
	}
	public void insertAdmin(Adminuser tempAdminUser,int Authid)
	{
		adminuserDao.save(tempAdminUser);
		List<Adminuser> tempList=adminuserDao.findByAdminName(tempAdminUser.getAdminName());
		int adminID=tempList.get(0).getAdminId();
		AdimauthorityId adimAuthorityId=new AdimauthorityId(Authid, adminID);
		Adimauthority adimAuthority=new Adimauthority(adimAuthorityId);
		adminauthorityDao.save(adimAuthority);
		logservice.insertUserLog(adminID, tempAdminUser.getAdminName());
	}
}
