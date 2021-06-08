package sceanrio.mediaocean;

import java.lang.reflect.Method;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Media_Ocean_Scenario {

	static ExtentTest test;
	static ExtentReports report;
	@BeforeMethod
	public static void startTest(ITestContext  context, Method method)
	{
		
		Global_Parameters global = new Global_Parameters();
		
		Extent_Reports_Log.update_Extent_Report_Summary();
		
		System.setProperty("webdriver.chrome.driver", Global_Parameters.chrome_driver_path);
		global.set_WebDriver(new ChromeDriver());
		global.get_WebDriver().get(Global_Parameters.stackoverlof_url);
		global.get_WebDriver().manage().window().maximize();
		Thread.currentThread().setName(method.getName());
		Global_Variable.glbMap.put(Thread.currentThread().getName(), global);
	}
	
	
	
	@Test
	public void media_Ocean_Test_Demo()
	{		
		Extent_Reports_Log.test = Extent_Reports_Log.extentReport.createTest(Global_Parameters.test_case_name);
		
		Media_Ocean_Locators page_class = new Media_Ocean_Locators();
		
		Extent_Reports_Log.test.pass("Test Case Started");
		
		
		Extent_Reports_Log.test.info("<b>Search on Stack Overflow</b>");
		page_class.enter_Text_To_Search("[Selenium]");
		page_class.press_Enter_In_Search();
		
		
		Extent_Reports_Log.test.info("<b>Verify Search loaded successfully</b>");
		page_class.verify_Questions_Searched();
		
		
		Extent_Reports_Log.test.info("<b>Navigate to More->Votes and verify Sorting as per answers voted</b>");
		page_class.click_More_Button();
		page_class.click_Votes_Link();
		page_class.verify_Sorting_Votes();
		
		
		Extent_Reports_Log.test.info("<b>Verify Tiles of Questions which were answered with respective Votes</b>");
		page_class.verify_Questions_Title_With_Votes_Answered();
		
		
		Extent_Reports_Log.test.info("<b>Get all Other tags</b>");
		page_class.get_Other_Tags();
		
		
		Extent_Reports_Log.test.info("<b>Verify Tiles of Questions which were accepteted answered with respective Votes</b>");
		page_class.get_Ques_Votes_Accepted_Answers();
		
				
		Extent_Reports_Log.test.pass("Test Case Completed");
		
		
	}
	@AfterMethod
	public static void endTest()
	{
		
		Extent_Reports_Log.close_Extent_Report();
	}
}