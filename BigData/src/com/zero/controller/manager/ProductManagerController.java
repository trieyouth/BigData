package com.zero.controller.manager;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zero.entity.Finaproduct;
import com.zero.service.ProductService;

/*
 * created by youth on 16-2-21
 * */

@RequestMapping("/manager/product")
@Controller
public class ProductManagerController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/index")
	public String index(){
		return "manager/product-manager/ProductManageMainFrame";
	}
	
	@RequestMapping("/list")
	public String productList(Model model){
		List<Finaproduct> products = productService.findAllProduct();
		model.addAttribute("products",products);
		return "manager/product-manager/ProductsList";
	}
	
	@RequestMapping("/detail/{prodId}")
	public String productDetail(@PathVariable("prodId")String prodId,Model model){
		model.addAttribute("product",productService.findById(Integer.valueOf(prodId)));
		return "manager/product-manager/ProductsMessageDetial";
	}
	
	@RequestMapping("/add")
	public String productAdd(){
		return "manager/product-manager/AddProducts";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String productAdd(String procode,String proname,String proriskleval,String proinittime,String prominmony,String prodetail){
		Finaproduct finaproduct = new Finaproduct();
		DateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = fmt.parse(proinittime);
			finaproduct.setIssueDate(date);
			finaproduct.setProdName(proname);
			finaproduct.setMiniMoney(Double.valueOf(prominmony));
			finaproduct.setProdDetail(prodetail);
			finaproduct.setProdCode(procode);
			finaproduct.setRiskLevel(proriskleval);
			productService.insertProduct(finaproduct);
		} catch (ParseException e) {
			System.out.println("debug : 日期数据格式错误");
		}
		
		return "redirect:/manager/product/list";
	}
	
	@RequestMapping("/update/{proId}")
	public String productUpdate(){
		return "";
	}
	
	@RequestMapping("/delete/{proId}")
	public String productDelete(@PathVariable("proId")String proId){
		System.out.println("debug : proId : "+proId);
		productService.deleteProductByID(Integer.valueOf(proId));
		return "redirect:/manager/product/list";
	}
	
}
