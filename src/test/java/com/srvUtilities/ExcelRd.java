package com.srvUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRd {

		File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\TestData.xlsx");
        FileInputStream fs = new FileInputStream(f);
    
    	XSSFWorkbook wk = new XSSFWorkbook(fs);
        XSSFSheet sheet = wk.getSheet("AddCustomer");
        int rowsize = sheet.getLastRowNum();
       
        
        public ExcelRd() throws IOException {
        	
        
        	for(int r=1;r<rowsize+1;r++)
            {
            	
            	int colsize = sheet.getRow(r).getLastCellNum();
            	
            	for(int c=0;c<colsize;c++)
            	{   
            		
            	try {
            		Cell cell = sheet.getRow(r).getCell(c);
                	CellType type = cell.getCellType();
                	//System.out.println(sheet.getRow(r).getLastCellNum());
            	if(type==type.NUMERIC)
                	{
                		System.out.println(cell.getNumericCellValue());
                	}
                	else if(type==type.STRING)
                	{
                		System.out.println(cell.getStringCellValue());
                	}
                	else if(type==type.BOOLEAN)
                	{
                		System.out.println(cell.getBooleanCellValue());
                	}
                	else
                	{
                		System.out.println("value is blank");
                	}
            	}
            	catch(NullPointerException e)
            	{
            		System.out.println("Cell is empty");
            	}
            	}
            }
            
        
        

	}

}
