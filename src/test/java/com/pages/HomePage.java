package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.base.Pages;

public class HomePage extends Pages {

	
 
	public void goToSignUp(String username, String password)
	{
		driver.findElement(By.xpath("//div[@class=\"signupcontainer\"]/a[2]")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox'][@id='tos']"));
		Actions action = new Actions(driver);
		action.click(checkbox).perform();
		driver.findElement(By.xpath("//input[@id='signupbtn']")).click();
	}
	public void goToSignIn(String username, String password)
	{
		driver.get("https://accounts.zoho.com.au/signin?servicename=ZohoHome&signupurl=https://www.zoho.com/signup.html");
		//driver.findElement(By.xpath("//div[@class=\"signupcontainer\"]/a[1]")).click();
		driver.findElement(By.name("LOGIN_ID")).sendKeys(username);
		driver.findElement(By.id("nextbtn")).click();
		driver.findElement(By.name("PASSWORD")).sendKeys(password);
		driver.findElement(By.id("nextbtn")).click();
	}
	public ZohoAppPage goToCRMSignIn(String username, String password)
	{
		click("CRMPagefromHome_xpath");
		click("SignIn_xpath");
		enterData("SignInEmail_name",username);
		click("SignInNext_id");
		enterData("SignInPassword_name",password);
		click("SignInNext_id");
		return new ZohoAppPage();
	}
public void firstLoginotpConfirmation(String username, String password)
{
	driver.get("https://accounts.zoho.com.au/signin?servicename=ZohoHome&signupurl=https://www.zoho.com/signup.html");
	driver.findElement(By.name("LOGIN_ID")).sendKeys(username);
	driver.findElement(By.id("nextbtn")).click();
	driver.findElement(By.name("PASSWORD")).sendKeys(password);
	driver.findElement(By.id("nextbtn")).click();
	driver.findElement(By.xpath("//button[@class='send_otp_btn']")).click();
}
	public void changeLanguage()
	{

	}
}
