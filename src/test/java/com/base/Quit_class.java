package com.base;

import java.lang.reflect.Method;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Quit_class extends Pages {

	@AfterSuite
	public void quitBrowser()
	{
		Pages.quit();
	}
	
	
	 @DataProvider(name="TestLogin dp")
		public Object[][]getData(Method m) throws InterruptedException
		{
			String sheetname = m.getName();
			int rows = excel.getRowCount(sheetname);
			System.out.println(rows);
			int cols = excel.getColumnCount(sheetname);
			System.out.println(cols);
			Object[][] data = new Object[rows-1][cols];
			for(int rowNum=2;rowNum<=rows;rowNum++)
			{
				for(int colNum=0;colNum<cols;colNum++)
				{
					data[rowNum-2][colNum] = excel.getCellData(sheetname, colNum, rowNum);
				}
			}
			return data;
		}
}
