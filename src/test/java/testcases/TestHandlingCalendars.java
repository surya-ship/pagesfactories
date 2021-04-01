package testcases;

import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestHandlingCalendars {
	
	static int targetDay = 0,
			targetMonth = 0,
			targetYear = 0;
	
	static int currentDay = 0,
			currentMonth = 0,
			currentYear = 0;
	
	static int jumpMonthsBy=0;
	
	//true for increment and false for decrement
	static boolean increment = true;

	public static void main(String[] args) throws InterruptedException {
		/*
		 * target day, month, year
		 * current day, month, year
		 * jump to the month
		 * increment or decrement
		 */
	
		String dateToSet= "20/08/2021";
		
		//get current date	
		getCurrentDateMonthAndYear();
		System.out.println(currentDay+"    "+currentMonth+"    "+currentYear);
		
		//get target date
		GetTargetDateMonthAndYear(dateToSet);
		System.out.println(targetDay+"    "+targetMonth+"    "+targetYear);
		
		//Get Jump month
		CalculateHowManyMonthsToJump();
		System.out.println(jumpMonthsBy);
		System.out.println(increment);
		
		WebDriverManager.operadriver().setup();
		WebDriver driver = new OperaDriver();
		driver.get("https://fengyuanchen.github.io/datepicker/");		
		driver.manage().window().maximize();
		implicitylyWait(5);
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[1]/input")).click();
		
		for(int i=0; i<jumpMonthsBy;i++) {
			
			if(increment) {
				
				driver.findElement(By.xpath("/html/body/div[3]/div[3]/ul[1]/li[3]")).click();
			}
			else {
				driver.findElement(By.xpath("/html/body/div[3]/div[3]/ul[1]/li[1]")).click();
			}
			
			Thread.sleep(1000);
		}
		//selecting link path to automate target date 
		//driver.findElement(By.linkText(Integer.toString(targetDay))).click();
		
		//xpath of total calendar bcoz no link path for this website
		driver.findElement(By.xpath("/html/body/div[3]/div[3]/ul[3]")).click();
		
		//alternate method for selecting date xpath individually per month
		//driver.findElement(By.xpath("/html/body/div[3]/div[3]/ul[3]/li[10]")).click();
		
		}
	
	private static void implicitylyWait(int i) {
		
		
	}

	public static void getCurrentDateMonthAndYear() {
		
		Calendar cal = Calendar.getInstance();
		
		currentDay = cal.get(Calendar.DAY_OF_MONTH);
		currentMonth = cal.get(Calendar.MONTH)+1;
		currentYear = cal.get(Calendar.YEAR);

	}
	
	public static void GetTargetDateMonthAndYear(String dateString) 
	{
		int firstIndex = dateString.indexOf("/");
		int lastIndex = dateString.lastIndexOf("/");
		
		//target day,month and year
		String day = dateString.substring(0, firstIndex);
		targetDay = Integer.parseInt(day);
		
		String month = dateString.substring(firstIndex+1, lastIndex);
		targetMonth = Integer.parseInt(month);
		
		String year = dateString.substring( lastIndex+1, dateString.length());
		targetYear = Integer.parseInt(year);
				
	}
	
	public static void CalculateHowManyMonthsToJump() 
	{
		if((targetMonth-currentMonth)>0){
			
			jumpMonthsBy = (targetMonth-currentMonth);			
		}else 
		{
			jumpMonthsBy = (currentMonth-targetMonth);
			increment = false;
			
		}
		
		
	}

}
