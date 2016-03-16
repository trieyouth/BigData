package com.zero.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zero.dao.CreditratingclassificationDAO;
import com.zero.dao.SingleusercreditinformationDAO;
import com.zero.dao.SingleuserriskinformationDAO;
import com.zero.entity.Creditratingclassification;
import com.zero.entity.Singleusercreditinformation;
import com.zero.entity.Singleuserriskinformation;

@Service("singInformationservice")
public class SingInformationService {
	@Autowired
	private SingleusercreditinformationDAO singleusercreditinformationDAO;
	@Autowired
	private SingleuserriskinformationDAO singleuserriskinformationDAO;
	@Autowired
	private CreditratingclassificationDAO creditratingclassificationDAO;
	public SingInformationService() {
		// TODO Auto-generated constructor stub
	}
	
	public void addSingleusercreditinformation(Singleusercreditinformation singleusercreditinformation) {
		singleusercreditinformationDAO.save(singleusercreditinformation);
		if(singleusercreditinformationDAO.count()>=100)
		{
			singleusercreditinformationDAO.outPutTxT();
			singleusercreditinformationDAO.cleanAndRefresh();
		}
	}
	
	public void addSingleuserriskinformation(Singleuserriskinformation singleuserriskinformation) {
		singleuserriskinformationDAO.save(singleuserriskinformation);
		if(singleuserriskinformationDAO.count()>=100)
		{
			singleuserriskinformationDAO.outPutTxT();
			singleuserriskinformationDAO.cleanAndRefresh();
		}
	}
	
	public List<Singleusercreditinformation> checkSingleusercreditinformation() {
		return singleusercreditinformationDAO.findAll();
		
	}
	
	public List<Singleusercreditinformation> checkSingleuserriskinformation() {
		return singleuserriskinformationDAO.findAll();
		
	}
	
	public void addCreditratingclassification(Creditratingclassification creditratingclassification) {
		creditratingclassificationDAO.save(creditratingclassification);
	}
	public List<Creditratingclassification> checkCreditratingclassification() {
		return creditratingclassificationDAO.findAll();
		
	}
}
