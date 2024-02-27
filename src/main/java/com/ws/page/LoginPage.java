package com.ws.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ws.base.DriverScript;

public class LoginPage extends DriverScript {

	// ****************Page element********************************

	@FindBy(id = "Email")	WebElement emailTextField;
	@FindBy(name = "Password")	WebElement passwordTextBox;
	@FindBy(xpath = "//input[@class = 'button - 1 login - button']")	WebElement loginButton; 
	@FindBy(linkText = "Forgot password?")	WebElement forgotPasswordLink;

	// ************page initialization********************************

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// ************page Actions********************************

	public void enterEmail(String email) 
	{
		emailTextField.clear();
		emailTextField.sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		passwordTextBox.sendKeys(password);
	}
	
	public void ClickloginButton() 
	{
		loginButton.click();
		
	}
	
	public boolean isForgotpasswordLInkPresent() 
	{
		return forgotPasswordLink.isDisplayed();
	}
	
	public String getLoginPageTitle() {
		return  driver.getTitle();
	}
	
}
