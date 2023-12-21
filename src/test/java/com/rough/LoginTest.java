package com.rough;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.base.Pages;
import com.pages.AccountPage;
import com.pages.CreateAccountPage;
import com.pages.HomePage;
import com.pages.ZohoAppPage;

public class LoginTest {

public static void main(String[] args) {
	

		HomePage hp = new HomePage();
		ZohoAppPage zp =  hp.goToCRMSignIn("jaiswalsurabhi@yahoo.com", "Seleniumpractice@1234");
		AccountPage account = zp.goToAccount();
		CreateAccountPage pg = account.goToCreateAccount();
        pg.selectAccountName("Surabhi");
        Pages.quit();
	}

}
