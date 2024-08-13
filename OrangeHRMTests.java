package com.tmb.test;

import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tmb.pages.OrangeHRMLoginPage;
import com.tmb.reports.ExtentReport;

public class OrangeHRMTests extends BaseTest{
	
	private OrangeHRMTests() {
		
	}
	
	
	@Test(dataProvider = "LoginTestDataProvider")
	public void loginLogoutTest(String username,String password) throws InterruptedException {
		
		String title=new OrangeHRMLoginPage().enterUsername(username).
		enterPassword(password).clickOnlogin()
		.clickWelcome().clickLogout().getTitle();
		
		Assertions.assertThat(title)
		.isEqualTo("OrangeHRM");
		
	
		
	}
	
	@DataProvider(name="LoginTestDataProvider",parallel=true)
	public Object[][] getData(){
		
		return new Object[][] {
			
			{"Admin","admin123"},
			{"Admin","admin123"},
			{"Admin","admin231"}
		};
		
	}
	

}
