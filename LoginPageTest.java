package com.tmb.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.tmb.driver.Driver;
import com.tmb.driver.DriverManager;


public final class LoginPageTest extends BaseTest{
	

	private LoginPageTest() {
		
	}
	
	
	@Test
	public void test1() {
		   
	    
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Automation",Keys.ENTER);
	}

	

  @Test 
  public void test2() {
  
  DriverManager.getDriver().findElement(By.name("q")).sendKeys("Modi",Keys.ENTER); 
  } 
  }
 