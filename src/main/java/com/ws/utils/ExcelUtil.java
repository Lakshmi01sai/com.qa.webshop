package com.ws.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
		   
		   XSSFWorkbook wb;

	    public ExcelUtil(String excelpath) {
	    	
	    	try {
	    		 File file = new File (excelpath);
	        	 FileInputStream fis = new FileInputStream(file);
	        	  wb = new XSSFWorkbook(fis);
	    	}
	    	catch (Exception e)
	    	{
	    		System.out.println("file not found, please check");
	    		e.printStackTrace();
	    	}
	    	
	    }
	    
	    public int getRowCount(int sheetNo) {
	    	 int count = wb.getSheetAt(0).getLastRowNum()+1;
	    	 return count;
	    	
	    }
	    
	    public String getCellData(int sheetNo, int row, int cell ) {
	    	String data = wb.getSheetAt(0).getRow(0).getCell(0).toString();
	    	return data;
	    }

	}
	   
	   


}
