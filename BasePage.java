package com.tmb.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.constant.FrameworkConstants;
import com.tmb.driver.DriverManager;
import com.tmb.enums.WaitStrategy;
import com.tmb.factories.ExplicitWaitFactory;
import com.tmb.reports.ExtentLogger;

public class BasePage {

	protected void click(By by,WaitStrategy waitStrategy,String elementName) {
		ExplicitWaitFactory.performExplicitWait(waitStrategy, by).click();
		try {
			ExtentLogger.pass(elementName + " is clicked ",true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	protected void sendKeys(By by ,String value,WaitStrategy waitStrategy,String elementName) {
		ExplicitWaitFactory.performExplicitWait(waitStrategy, by).sendKeys(value);
		try {
			ExtentLogger.pass(value +  "  is succesfully entered in " + elementName,true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}
	


}
