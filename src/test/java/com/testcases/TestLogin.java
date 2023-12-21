package com.testcases;

import org.testng.annotations.Test;

import com.base.Pages;
import com.base.Quit_class;
import com.pages.AccountPage;
import com.pages.CreateAccountPage;
import com.pages.HomePage;
import com.pages.ZohoAppPage;

public class TestLogin extends Quit_class{
//New message
	
	@Test(dataProviderClass=Quit_class.class,dataProvider="TestLogin dp")
	public void testlogin(String username, String password)
	{
		HomePage hp = new HomePage();
		ZohoAppPage zp =  hp.goToCRMSignIn(username, password);
		AccountPage account = zp.goToAccount();
		CreateAccountPage pg = account.goToCreateAccount();
        pg.selectAccountName("Surabhi");
        
	}
}
