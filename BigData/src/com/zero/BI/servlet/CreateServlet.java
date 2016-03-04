package com.zero.BI.servlet;


import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import sun.misc.BASE64Decoder;

/*
 * 打印图表
 * */

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/ccas/index/BIShow/createServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String data = request.getParameter("img");
	    try {
	    	
	    	String userName = System.getProperty("user.name");
	    	System.out.println("userName:"+userName);
	    	
	    	String filePath = "C:\\Users\\"+userName+"\\Desktop\\chart";
	    	File file = new File(filePath);
	    	if(!file.exists()){
	    		file.mkdir();
	    	}
	    	
	    	String fileName = filePath +"\\"+ System.currentTimeMillis()+".png";
	       
	    	createImage(request, response, fileName, data);
	    	
	    	createExcel(request, response, fileName);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void createImage(HttpServletRequest request, HttpServletResponse response,
			String fileName, String data) 
			throws ServletException, IOException {
		try {
	        String[] url = data.split(",");
	        String u = url[1];
	        byte[] b = new BASE64Decoder().decodeBuffer(u);
	        OutputStream out = new FileOutputStream(new File(fileName));
	        out.write(b);
	        out.flush();
	        out.close();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createExcel(HttpServletRequest request, HttpServletResponse response, String fileName) 
			throws ServletException, IOException {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("echart");
		
		HSSFRow row = null;
        row = sheet.createRow(60);
        
        /*HSSFCell headerCell = row.createCell(0);    
        headerCell.setCellType(HSSFCell.CELL_TYPE_BLANK);  
        headerCell.setCellValue("echarts");*/
        
        row = sheet.createRow(60);
        HSSFCell cells = row.createCell(0);
        cells.setCellType(HSSFCell.CELL_TYPE_BLANK);
        
        ByteArrayOutputStream outStream = new ByteArrayOutputStream(); // 锟斤拷图片写锟斤拷锟斤拷锟斤拷
        BufferedImage bufferImg = ImageIO.read(new File(fileName));
        ImageIO.write(bufferImg, "PNG", outStream); // 锟斤拷锟斤拷HSSFPatriarch锟斤拷图片写锟斤拷EXCEL
        HSSFPatriarch patri = sheet.createDrawingPatriarch();
        HSSFClientAnchor anchor = new HSSFClientAnchor(20, 20, 20, 20,
          (short) 10, 20, (short) 20, 45);
        
        patri.createPicture(anchor, wb.addPicture(
          outStream.toByteArray(), HSSFWorkbook.PICTURE_TYPE_PNG));
        
        try {
        	OutputStream out = null;
        	response.setContentType("application/x-msdownload");
        	response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode("echarts.xls", "UTF-8"));
        	out = response.getOutputStream();	        
        	wb.write(out);
        	out.flush();
        	out.close();		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
	
}
