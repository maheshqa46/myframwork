package com.tmb.pages;



import org.openqa.selenium.By;

import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;

public final class OrangeHRMLoginPage extends BasePage{
	
	
	private final By textboxusername= By.xpath("//*[@name='username']");
	private final By textboxpassword= By.xpath("//*[@name='password']");
	private final By buttonlogin = By.xpath("//*[@type='submit']");
	
	
	public OrangeHRMLoginPage enterUsername(String username) {
		sendKeys(textboxusername ,username,WaitStrategy.PERSENCE,"Username");
		return this;
	}

	public OrangeHRMLoginPage enterPassword(String password) {
		sendKeys(textboxpassword ,password,WaitStrategy.PERSENCE,"Password");
		return this;
	}
	
	public OrangeHRMHomePage clickOnlogin() {
		click(buttonlogin,WaitStrategy.PERSENCE,"clicked");
		return new OrangeHRMHomePage();
	}
	
	public String getTitle() {
		return getPageTitle();
	}
}
