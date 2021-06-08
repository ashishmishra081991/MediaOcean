package sceanrio.mediaocean;

import java.net.InetAddress;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Extent_Reports_Log {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extentReport;
	public static ExtentTest test;


	public static void update_Extent_Report_Summary() {

		Global_Parameters global = new Global_Parameters();


		global.create_File_Each_Date();

		Extent_Reports_Log.htmlReporter = new ExtentHtmlReporter(global.get_current_result());

		Extent_Reports_Log.htmlReporter.config().setDocumentTitle(Global_Parameters.project_name);
		Extent_Reports_Log.htmlReporter.config().setReportName(Global_Parameters.project_name);

		Extent_Reports_Log.extentReport = new ExtentReports();
		try {
			Extent_Reports_Log.extentReport.setSystemInfo("System Name: ", InetAddress.getLocalHost().getHostName());
		}catch(Exception ex) {}

		extentReport.setSystemInfo("Project Name: ", Global_Parameters.project_name);

		Extent_Reports_Log.extentReport.attachReporter(Extent_Reports_Log.htmlReporter);

	}

	public static void close_Extent_Report() {

		Global_Parameters global = new Global_Parameters();
		
		Extent_Reports_Log.extentReport.flush();
		
		System.out.println("Results: " + global.get_current_result());
	}

}
