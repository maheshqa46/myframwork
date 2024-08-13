package com.tmb.test;

import java.util.List;
import java.util.Objects;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tmb.driver.Driver;
import com.tmb.driver.DriverManager;

public final class HomePageTest extends BaseTest{

	private HomePageTest() {
		
	}
	@Test
	public void test3() {
		  
	      
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing mini byte - Youtube",Keys.ENTER);
		String title = DriverManager.getDriver().getTitle();
		
		Assertions.assertThat(title)
		.as("Object is actually null").isNotNull()
		.as("It does not contains expected text").containsIgnoringCase("google search")
		.matches("//. *"+"google -search");
		
		/*Assert.assertTrue(Objects.nonNull(title),"Title is null");
		Assert.assertTrue(title.contains("Google Search"));
		Assert.assertTrue(title.length()>15);
		Assert.assertTrue(title.length()<100);*/
		List<WebElement> elements=DriverManager.getDriver().findElements(By.xpath("//*[contains(text(),'Testing mini byte - Youtube - Google Search')]"));
		
		Assertions.assertThat(title)
		.hasSize(50)
		.contains("Testing Mini Bytes - Youtube");
		boolean isElementPresent = false;
		for(WebElement element : elements) {
			if(element.getText().equalsIgnoreCase("Testing mini byte - Youtube - Google Search")) {
				isElementPresent=true;
				break;
			}
		}
		//Assert.assertTrue(isElementPresent ,"Testing mini byte not found");
	}
}
