package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestIsElementPresent {
	
	public static WebDriver driver;
						
	 /*isElementPresent own method using only xpath.
	  *  public static boolean isElementPresent(String locator) {
	  * try{
		driver.findElement(By.xpath(locator));
		return true;
	} catch (Throwable t) {
		return false;
	}
	}*/
		//2) alternate method using every locator
	public static boolean isElementPresent(By by) {
		int size = driver.findElements(by).size();
		if(size==0) {
			return false;
		}
		else {
			return true;
		}
	}	  
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");		
		driver.manage().window().maximize();		
		implicitlyWait(5);
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		
		//isDisplayed() method, checking the visibility of an element not the presence of element
		System.out.println(driver.findElement(By.xpath("//*[@id=\"js-link-box-en\"]/strong")).isDisplayed());	
				
		//isElementPresent() method
		System.out.println(isElementPresent(By.id("searchLanguage")));
	}

	private static void implicitlyWait(int i) {
				
	}

}
