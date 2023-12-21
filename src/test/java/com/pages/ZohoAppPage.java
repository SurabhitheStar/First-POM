package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.base.Pages;

public class ZohoAppPage extends Pages {

	
		public void goToBooks()
		{
			driver.findElement(By.xpath("//div[text()=\"Books\"]/parent::a")).click();
		}
		
		public void goToCalender()
		{
			driver.findElement(By.xpath("//div[text()=\"Calendar\"]/parent::a")).click();
		}
		public void goToCampaigns()
		{
			driver.findElement(By.xpath("//div[text()=\"Campaigns\"]/parent::a")).click();
		}
	public AccountPage goToAccount()
	{
		click("AccountOption_id");
		return new AccountPage();
	}

}
