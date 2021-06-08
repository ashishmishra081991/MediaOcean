package sceanrio.mediaocean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Media_Ocean_Locators extends Global_Parameters{

	public By txt_search = By.xpath("//input[@aria-label='Search']");
	public void enter_Text_To_Search(String value_to_search) {
		put_Static_Wait(3);
		get_Current_Driver().findElement(txt_search).sendKeys(value_to_search);
		Extent_Reports_Log.test.pass("Enter Search as: " + value_to_search);

	}

	public void press_Enter_In_Search() {
		get_Current_Driver().findElement(txt_search).sendKeys(Keys.ENTER);
	}



	public By ele_all_ques_section = By.xpath("//div[@class='question-summary']");
	public void verify_Questions_Searched() {
		
		put_Static_Wait(3);
		List<WebElement> all_ques = get_Current_Driver().findElements(ele_all_ques_section);

		String all_ques_val="";
		for(int id=0;id<all_ques.size();id++) {
			all_ques_val = all_ques_val + "<br>Question: "+(id+1) + " -> "+all_ques.get(id).findElement(By.xpath(".//h3")).getText();
		}

		Extent_Reports_Log.test.pass("Searched successfully done: " + all_ques_val);

	}



	public By btn_more = By.xpath("//button[contains(text(),'More')]");
	public void click_More_Button() {
		JavascriptExecutor executor = (JavascriptExecutor)get_Current_Driver();				
		executor.executeScript("arguments[0].click();", get_Current_Driver().findElement(btn_more));
		Extent_Reports_Log.test.pass("Click on: More");
	}


	public By lnk_votes = By.xpath("//a[contains(text(),'Votes')]");
	public void click_Votes_Link() {
		JavascriptExecutor executor = (JavascriptExecutor)get_Current_Driver();				
		executor.executeScript("arguments[0].click();", get_Current_Driver().findElement(lnk_votes));
		Extent_Reports_Log.test.pass("Click on: Votes");
	}




	public By ele_votes_nbrs = By.xpath("//div[text()='votes']/preceding-sibling::span//*");
	public void verify_Sorting_Votes() {

		put_Static_Wait(3);
		List<WebElement> all_ques = get_Current_Driver().findElements(ele_votes_nbrs);
		ArrayList<String> all_votes_numbers = new ArrayList<String>();
		//List<Integer> all_votes_numbers_sorted = new ArrayList<Integer>();

		for(int id=0;id<all_ques.size();id++) {
			all_votes_numbers.add(all_ques.get(id).getText().trim());
		}

		
		if(verifySortingForAll("N","D", all_votes_numbers))
			Extent_Reports_Log.test.pass("Votes Number showing sorted: " + all_votes_numbers.toString());
		else
			Extent_Reports_Log.test.fail("Votes Number not showing sorted: " + all_votes_numbers.toString());

	}


	public void verify_Questions_Title_With_Votes_Answered() {

		put_Static_Wait(3);
		
		List<WebElement> all_ques = get_Current_Driver().findElements(ele_all_ques_section);

		String all_ques_val="";
		for(int id=0;id<all_ques.size();id++) {
			all_ques_val="";
			all_ques_val = all_ques_val + "<br>Question: "+(id+1)+ " -> " + all_ques.get(id).findElement(By.xpath(".//h3")).getText();
			all_ques_val = all_ques_val + "<br>Vote Counts: "+(id+1)+ " -> " + all_ques.get(id).findElement(By.xpath(".//span[@class='vote-count-post ']")).getText();
			all_ques_val = all_ques_val + "<br>Answers: "+(id+1) + " -> "+ all_ques.get(id).findElement(By.xpath(".//div[starts-with(@class,'status answered')]")).getText();
			Extent_Reports_Log.test.pass(all_ques_val);
		}

	}
	
	
	public By non_sele_or_other_tags = By.xpath("//a[@class='post-tag' and not(text()='selenium')]");
	public void get_Other_Tags() {
		List<WebElement> all_other_tags = get_Current_Driver().findElements(non_sele_or_other_tags);
		
		String all_tags="";
		for(int id=0;id<all_other_tags.size();id++) {
			all_tags = all_tags + "<br>" + all_other_tags.get(id).getText();
		}
		Extent_Reports_Log.test.pass("All Other tags displayed: "+all_tags);
	}


	public By accepted_ans = By.xpath("//div[@class='question-summary']//div[@class='status answered-accepted']");
	public void get_Ques_Votes_Accepted_Answers() {
		
		put_Static_Wait(3);
		List<WebElement> all_ques = get_Current_Driver().findElements(accepted_ans);

		String all_ques_val="";
		for(int id=0;id<all_ques.size();id++) {
			all_ques_val="";
			all_ques_val = all_ques_val + "<br>Question: "+(id+1) + " -> "+ all_ques.get(id).findElement(By.xpath("./ancestor::div[@class='question-summary']//h3")).getText();
			all_ques_val = all_ques_val + "<br>Vote Counts: "+(id+1) + " -> "+ all_ques.get(id).findElement(By.xpath("./..//span[@class='vote-count-post ']")).getText();
			Extent_Reports_Log.test.pass(all_ques_val);
		}
	}

	
	
	
	
	
	public boolean verifySortingForAll(String sortType, String sortOrder, ArrayList<String> arrayData) {

		boolean bolSuccessFlag=true;
		double num1 = 0.00d, num2=0.00d;

		if (arrayData.size()<1) {

		}else if(sortType.isEmpty() && sortOrder.isEmpty()) {

		}else {
			if((sortType+ "-" + sortOrder).equalsIgnoreCase("S-A")){
				for (int i=0;i<arrayData.size()-1;i++) {
					if (arrayData.get(i+1).compareTo(arrayData.get(i))<0) {
						bolSuccessFlag=false;
						break;
					}
				}

			}else if((sortType+ "-" + sortOrder).equalsIgnoreCase("S-D")){
				for (int i=0;i<arrayData.size()-1;i++) {
					if (arrayData.get(i+1).compareTo(arrayData.get(i))>0) {
						bolSuccessFlag=false;
						break;
					}
				}

			}else if((sortType+ "-" + sortOrder).equalsIgnoreCase("N-A")){

				for (int i=0;i<arrayData.size()-1;i++) {
					num1 = Double.parseDouble(arrayData.get(i));
					num2= Double.parseDouble(arrayData.get(i+1));

					if (num1>num2) {
						bolSuccessFlag=false;
						break;
					}
				}
			}else if((sortType+ "-" + sortOrder).equalsIgnoreCase("N-D")){
				for (int i=0;i<arrayData.size()-1;i++) {
					num1 = Double.parseDouble(arrayData.get(i));
					num2= Double.parseDouble(arrayData.get(i+1));

					if (num1<num2) {
						bolSuccessFlag=false;
						break;
					}
				}
			}	//closing of if else condition

		}	//closed for loop

		if (bolSuccessFlag)
			return true;
		else 
			return false;
	}

}
