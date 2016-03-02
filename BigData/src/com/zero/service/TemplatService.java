package com.zero.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.zero.entity.CreditTemplateAllInfo;
import com.zero.entity.Templatedata;
import com.zero.dao.AdminuserDAO;
import com.zero.dao.TemplatedataDAO;
import com.zero.dao.TemplateuserDAO;
import com.zero.service.LogService;


@Service
public class TemplatService {
	@Autowired
	private TemplatedataDAO templateDataDao;
	@Autowired
	private TemplateuserDAO templateUserDAO;
	@Autowired
	private AdminuserDAO adminuserDao;
	@Autowired
	private LogService logservice;
	public int adminID;
	public int templateID;
	public TemplatService() {
		
	}

	/**
	 * 查询模板列表
	 * 
	 * @return 返回一个list
	 */
	public List<Templatedata> checkTotalCreditTemplate() {
		return templateDataDao.findAll();
	}

	public List<Templatedata> getUserList() {
		return templateDataDao.findAll();
	}
	
	/**
	 * 根据模板id查询
	 * 
	 * @param templateID
	 * @return
	 */
	public List<Templatedata> checkUseDetailCreditTemplate(String templateID) {
		return templateDataDao.findByProperty("tempId", templateID);
	}

	/**
	 * 插入一个模板
	 * 
	 * @param templateData
	 */
	public void insertTemplateData(Templatedata templateData,CreditTemplateAllInfo tempCreditTemplateAllInfo) 
	{
		
	}

	/**
	 * 删除一个模板
	 * 
	 * @param templateData
	 */
	public void deleteTemplateData(Templatedata templateData) {
		
	}

	/**
	 * 根据模板id删除一个模板
	 * 
	 * @param templateData
	 */
	public void deleteTemplateDataByID(String TempId) {
		
	}

	/**
	 * 删除一个模板
	 * 
	 * @param tempId
	 * @param adminId
	 */
	public void deleteTemplateUserByID(String tempId, String adminId) {
		
	}

	/**
	 * 保存模板
	 * 
	 * @param templateUser
	 */
	public void useTemplateUser(Templatedata templateUser) {
		
	}

	/**
	 * 删除模板
	 * 
	 * @param templateUser
	 */
	public void deleteTemplateUser(Templatedata templateUser) {
		
	}

}
