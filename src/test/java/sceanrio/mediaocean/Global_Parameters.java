package sceanrio.mediaocean;

import java.io.File;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Global_Parameters {

	static String project_name = "Media_Ocean";
	static String test_case_name = "TC01_Dummy_Scenario_By_Media_Ocean";
	static String current_project_home_dir_results = System.getProperty("user.dir") + "\\results\\";
	static String chrome_driver_path = System.getProperty("user.dir") + "\\resources\\drivers\\chromedriver_win.exe";
	static String stackoverlof_url = "https://stackoverflow.com/";

	public String today_folder = "";
	public void set_today_folder(String today_folder) {
		this.today_folder = today_folder;
	}

	public String get_today_folder() {
		return this.today_folder;
	}


	public String current_result="";
	public void set_current_result(String current_result) {
		this.current_result = current_result;
	}

	public String get_current_result() {
		return this.current_result;
	}

	public void create_File_Each_Date() {
		LocalDateTime dt_tm = LocalDateTime.now();

		String fol_nm = current_project_home_dir_results + dt_tm.getDayOfMonth() + "_"+ dt_tm.getMonth() + "_"+ dt_tm.getYear();
		create_Folder(fol_nm);
		set_today_folder(fol_nm);

		String file_nm = get_today_folder() + "\\"+dt_tm.getDayOfMonth() + "_"+ dt_tm.getMonth() + "_"+ dt_tm.getYear() + "_" + dt_tm.getHour() + "_" + dt_tm.getMinute() + "_"+ dt_tm.getSecond() + ".html";
		create_File(file_nm);
		set_current_result(file_nm);


	}


	public void create_Folder(String fol_nm) {
		File file = new File(fol_nm);
		if(!file.exists())	file.mkdir();
	}



	public void create_File(String file_nm) {
		File file = new File(file_nm);
		try {

			if(!file.exists())	file.createNewFile();

		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}



	public WebDriver driv;
	public void set_WebDriver(WebDriver driv) {
		this.driv=driv;
	}

	public WebDriver get_WebDriver() {
		return this.driv;
	}


	public WebDriver get_Current_Driver() {
		Global_Parameters reportObj = Global_Variable.glbMap.get(Thread.currentThread().getName());
		return reportObj.get_WebDriver();
	}


	
	public void put_Static_Wait(int seconds) {
		
		try {
			Thread.sleep(seconds*1000);
		}catch(Exception ex) {
			
		}
	}

}
