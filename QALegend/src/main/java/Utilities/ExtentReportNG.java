package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	static ExtentReports extent;
	
	public static ExtentReports getReportObject()
	{
		String path = System.getProperty("user.dir")+"\\test-output\\report.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path); //configuration of created reports done by extendSparkReporter
		reporter.config().setReportName("Web Automation Report");
		reporter.config().setDocumentTitle("TestResults");
		extent = new ExtentReports(); 
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Deenu");
		return extent;
	}

}


