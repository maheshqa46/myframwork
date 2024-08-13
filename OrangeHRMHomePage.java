package com.tmb.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.util.concurrent.Uninterruptibles;
import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.reports.ExtentLogger;
import com.tmb.reports.ExtentManager;
import com.tmb.reports.ExtentReport;

public class OrangeHRMHomePage extends BasePage{
	
	private final By link_logout = By.xpath("//*[contains(text(),'Logout')]");
	
	private final By link_welcome = By.xpath("//*[@class='oxd-userdropdown-img']");
	
	public OrangeHRMHomePage clickWelcome() {
		click(link_welcome,WaitStrategy.PERSENCE,"Welcome Link");
		
		return this;
	}

	public OrangeHRMLoginPage clickLogout() {
		//DriverManager.getDriver().findElement(link_logout).click();
		//Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
		//new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(link_logout));
		
		//wait.until(d->d.findElement(link_logout)).isEnabled();
		click(link_logout,WaitStrategy.CLICKABLE,"Logout button");
		ExtentLogger.pass("clicked logout");
		return new OrangeHRMLoginPage();
	}
}
