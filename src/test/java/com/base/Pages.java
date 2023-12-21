package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.srvUtilities.ExcelReader;

public class Pages {
	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties or = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\TestData.xlsx");
	public Pages()
	{
		if (driver==null) {

				try {
					fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					config.load(fis);
					log.config("Config loaded");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				try {
					fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					or.load(fis);
					log.config("OR loaded");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if(config.getProperty("browser").equals("chrome"))
				{
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
					driver= new ChromeDriver();
				}
				else if(config.getProperty("browser").equals("firefox"))
				{
					//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables.chromedriver.exe");
					driver= new FirefoxDriver();
				}
				else if(config.getProperty("browser").equals("edge"))
				{
					//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables.chromedriver.exe");
					driver= new EdgeDriver();
				}
	        driver.get(config.getProperty("url"));
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}
	        
	        public boolean isElementPresent(By string)
			{
				try {
					driver.findElement(string);
					return true;
				}
				catch(NoSuchElementException e)
				{
					return false;
				}
			}
		
	        public void checkAlert()
			{
		
				Alert alert = driver.switchTo().alert();
				alert.accept();
		
		
			}
	        public void dropDownSelect(WebElement element, String value)
	        {
	        	Select select = new Select(element);
	        	select.selectByVisibleText(value);
	        	
	        }
	        public void click(String locator)
	        {
	        	if(locator.endsWith("css"))
	        	{
	        		driver.findElement(By.cssSelector(or.getProperty(locator))).click();
	        	}
	        	else if(locator.endsWith("id"))
	        	{
	        		driver.findElement(By.id(or.getProperty(locator))).click();
	        	}
	        	else if(locator.endsWith("name"))
	        	{
	        		driver.findElement(By.name(or.getProperty(locator))).click();
	        	}
	        	else if(locator.endsWith("xpath"))
	        	{
	        		driver.findElement(By.xpath(or.getProperty(locator))).click();
	        	}
	        	
	        }
	        public void enterData(String locator, String value)
	        {
	        	if(locator.endsWith("css"))
	        	{
	        		driver.findElement(By.cssSelector(or.getProperty(locator))).sendKeys(value);
	        	}
	        	else if(locator.endsWith("id"))
	        	{
	        		driver.findElement(By.id(or.getProperty(locator))).sendKeys(value);
	        	}
	        	else if(locator.endsWith("name"))
	        	{
	        		driver.findElement(By.name(or.getProperty(locator))).sendKeys(value);
	        	}
	        	
	        	
	        }
	        
	        public static void quit()
	        {
	        	driver.quit();
	        }
	        
	       
	        
	        	}
	        



