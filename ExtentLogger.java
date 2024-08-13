package com.tmb.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.tmb.driver.DriverManager;
import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtils;
import com.tmb.utils.ScreenshotUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ExtentLogger {
	
	private ExtentLogger() {
		
	}
	public static void pass(String massage) {
		ExtentManager.getExtentTest().pass(massage);
	}
	
    public static void fail(String massage) {
    	ExtentManager.getExtentTest().fail(massage);
	}
    public static void skip(String massage) {
    	ExtentManager.getExtentTest().skip(massage);
    }
   
   public static void pass(String massage,boolean screanshotNeeded) throws Exception {
	   
	   if(PropertyUtils.get(ConfigProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
		   && screanshotNeeded){
		   ExtentManager.getExtentTest().pass(massage, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getbase64Image()).build());
		   }else {
			   pass(massage);
		   }
	   
   }
   public static void fail(String massage,boolean screanshotNeeded) throws Exception {
	   
	   if(PropertyUtils.get(ConfigProperties.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
		   && screanshotNeeded){
		   ExtentManager.getExtentTest().fail(massage, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getbase64Image()).build());
		   }else {
			   fail(massage);
		   }
	   
   }
   public static void skip(String massage,boolean screanshotNeeded) throws Exception {
	   
	   if(PropertyUtils.get(ConfigProperties.SKIPPEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
		   && screanshotNeeded){
		   ExtentManager.getExtentTest().skip(massage, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getbase64Image()).build());
		   }else {
			   skip(massage);
		   }
	   
   }
  
}
