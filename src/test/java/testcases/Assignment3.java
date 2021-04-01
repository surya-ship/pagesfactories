package testcases;



import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
		driver.get("https://timesofindia.indiatimes.com/poll.cms");		
		driver.manage().window().maximize();
		
				
		WebElement add = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/div/table/tbody/tr/td/form/table/tbody/tr[3]/td/div/table/tbody/tr[2]/td[1]/span"));
		Math.addExact(6, 1);
		
		WebElement input = driver.findElement(By.xpath("/html/body/table/tbody/tr/td/div/table/tbody/tr/td/form/table/tbody/tr[3]/td/div/table/tbody/tr[2]/td[2]/input"));
		input.click();
		
								
    }
	
	private WebDriver driver;
		//fluent wait
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withMessage("user defined timed out after 5 seconds").ignoring(NoSuchElementException.class);

	}


