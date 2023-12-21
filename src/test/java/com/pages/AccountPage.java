package com.pages;

import org.openqa.selenium.By;

import com.base.Pages;

public class AccountPage extends Pages {

	public CreateAccountPage goToCreateAccount()
	{
		click("CreateAccountOption_xpath");
		return new CreateAccountPage();
	}
	
	public void goToActions()
	{
		
	}
}
