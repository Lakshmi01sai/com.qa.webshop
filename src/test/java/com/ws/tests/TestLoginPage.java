package com.ws.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ws.base.DriverScript;
import com.ws.page.HomePage;
import com.ws.page.LoginPage;

public class TestLoginPage extends DriverScript {

	@Test
	public void testHomePageTitle() {
		initApplication();
		HomePage homePage = new HomePage();
		String title = homePage.getHomePageTitle();
        Assert.assertTrue(title.contains("Demo Web Shop"));
        driver.quit();
	}
	
	@Test
	public void testLoginPageTitle() 
	{
		initApplication();
		HomePage homePage = new HomePage();
		homePage.clickLogin();
		LoginPage loginPage = new LoginPage();
		String loginPageTitle = loginPage.getLoginPageTitle();
		Assert.assertTrue(loginPageTitle.contains("Login"));
		loginPage.enterEmail("selenium@test.com");
		loginPage.enterPassword("selenium@123");
		loginPage.ClickloginButton();
		String title = homePage.getHomePageTitle();
        Assert.assertTrue(title.contains("Demo Web Shop"));
        homePage.clickLogout();
        driver.quit();
        
	}
	@Test
	
	public void isForgotpasswordLinkPresent() 
	{
      initApplication();
      HomePage homePage = new HomePage();
     LoginPage loginPage = new LoginPage();
     String loginPageTitle = loginPage.getLoginPageTitle();
     Assert.assertTrue(loginPageTitle.contains("Login"));
     boolean flag = loginPage.isForgotpasswordLInkPresent();
     Assert.assertTrue(flag);
     homePage.clickLogout();
     driver.quit();
     
     
      
	}

	
	
}

