package com.ws.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ws.base.DriverScript;

public class HomePage extends DriverScript 

//****************Page element********************************

{
	@FindBy(linkText = "Log in") WebElement loginLink;
	@FindBy(linkText = "Log out") WebElement logoutLink;

//************page initialization********************************
	 
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//************page Actions********************************
	
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	
	public void clickLogin() {
		loginLink.click();
	}
	
	public void clickLogout() {
		logoutLink.click();
	}
	
}
