package com.tmb.constant;

import com.tmb.enums.ConfigProperties;
import com.tmb.utils.PropertyUtils;

public class FrameworkConstants {
	
	private FrameworkConstants() {
		
	}
	private static final String RESOURSEPATH = System.getProperty("user.dir")+ "/src/test/resources";
	private static final String CHROMEDRIVERPATH = System.getProperty("user.dir")+ "";
	private static final String CONFIGFILEPATH = RESOURSEPATH+"/config/config.properties";
	private static final String EXTENTREPORTFOLDERPATH=System.getProperty("user.dir")+"/entent-test-output/index.html";
	private static String ententReportFilePath="";
	
	
	public static String getEntentreportfilepath() throws Exception {
		if(ententReportFilePath.isEmpty()) {
			ententReportFilePath=createReportPath();
		}
		return ententReportFilePath;
	}
	private static String createReportPath() throws Exception {
		if(PropertyUtils.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
			return EXTENTREPORTFOLDERPATH + System.currentTimeMillis()+"/index.html";
		}else {
			return EXTENTREPORTFOLDERPATH +"/index.html";
		}
		
	}
	private static final int EXPLICITWAIT = 10;
	
	
	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}



	public static String getChromedriverpath() {
		return CHROMEDRIVERPATH;
	}

	
	
	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}

}
