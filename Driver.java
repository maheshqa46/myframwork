package com.tmb.driver;

import java.time.Duration;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class Driver {
	
	private Driver() {
		
	}
	
	

	
	public static void initDriver() throws Exception {
		
		
		if(Objects.isNull(DriverManager.getDriver())) {
			WebDriverManager.chromedriver().setup();
		       DriverManager.setDriver(new ChromeDriver());
		       DriverManager.getDriver().get(PropertyUtils.get(ConfigProperties.URL));
		       DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		       
		}
	}
	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
