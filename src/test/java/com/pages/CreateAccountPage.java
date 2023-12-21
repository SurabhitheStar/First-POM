package com.pages;

import org.openqa.selenium.By;

import com.base.Pages;

public class CreateAccountPage extends Pages {
	
	public void selectAccountName(String accountName)
	{
		enterData("AccountName_id",accountName);
	}

}
