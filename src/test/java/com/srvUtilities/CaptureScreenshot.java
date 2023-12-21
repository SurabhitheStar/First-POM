package com.srvUtilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.Pages;


public class CaptureScreenshot extends Pages {
	static Date d = new Date();
	public static String screenshotname = d.toString().replace(":", "_").replace(",", "_").concat(".jpg");

public static File ssLocation = new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\"+screenshotname);

public CaptureScreenshot() throws IOException
{
	File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 FileUtils.copyFile(screenshotFile,ssLocation);
		
}
		
			
			

}
