package com.tmb.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tmb.constant.FrameworkConstants;

public final class ExtentReport {
	private static 	ExtentReports extent;

	private ExtentReport() {
		
	}
	
	public static void initReports() throws Exception {
		if(Objects.isNull(extent)) {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getEntentreportfilepath());
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Mahesh_Report");
		spark.config().setReportName("mahesh");
		}
	}
	public static void flushReport() throws IOException {
		if(Objects.nonNull(extent)) {
		extent.flush();
		}
		try {
			Desktop.getDesktop().browse(new File(FrameworkConstants.getEntentreportfilepath()).toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void createTest(String testcaseName) {
		ExtentTest test=extent.createTest(testcaseName);
		ExtentManager.setExtentTest(test);
	}

}
