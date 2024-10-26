package com.store.utilities;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.store.base.baseclass;
/**
 * @author Poornimadevi: ExtentManager class is used for Extent Report
 *  
 */
public class ExtentManager extends baseclass{
	
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	
	public static void setExtent() throws IOException {
		
		String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		//String repName = "EcommerceStoreReport_"+timeStamp+".html";
		String repName = "MyReport.html";
		htmlReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+repName);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/ExtentReportConfigfile/extent-config.xml");
	
		 
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);		
		extent.setSystemInfo("HostName", "MyHost");
		extent.setSystemInfo("ProjectName", "E-commerce Store Project");
		extent.setSystemInfo("Tester", "PoornimaDeviN");
		extent.setSystemInfo("OS", "Win10");
		extent.setSystemInfo("Browser", "Chrome");
	}
	

	public static void endReport() {
		extent.flush();
	}
}
