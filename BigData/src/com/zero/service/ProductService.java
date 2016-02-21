package com.zero.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zero.dao.FinaproductDAO;
import com.zero.entity.Finaproduct;

@Service
public class ProductService {

	@Autowired
	private FinaproductDAO finaProductDAO;
	
	@Autowired
	private LogService logService;
	
	
	public String ProductID="";
	public int adminID;
	
	public void insertProduct(Finaproduct finaProduct)
	{
		finaProductDAO.save(finaProduct);
		List<Finaproduct> tempList=finaProductDAO.findByProdName(finaProduct.getProdName());
		logService.saveProductLog(adminID, tempList.get(0).getProdId());
	}
	
	public List<Finaproduct> findAllProduct()
	{
		return finaProductDAO.findAll();
	}
	
	public void deleteProductByID(int prodId)
	{
		finaProductDAO.deleteProductId(prodId);
		logService.deleteProductLog(adminID, prodId);
	}
	public Finaproduct findById(int id)
	{
		return finaProductDAO.findById(id);
	}
	
	public List<Finaproduct> findByProdName(Finaproduct prodName)
	{
		return finaProductDAO.findByProdName(prodName);
	}
	public void updateProduct(Finaproduct tempFinaProduct)
	{
		finaProductDAO.deleteProductId(tempFinaProduct.getProdId());
		finaProductDAO.save(tempFinaProduct);
	}
	public List<Finaproduct> findByrisklevel(Finaproduct prodrisklevel)
	{
		return finaProductDAO.findByRiskLevel(prodrisklevel);
	}
	
}
