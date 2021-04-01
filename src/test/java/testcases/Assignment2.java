package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
		driver.get("http://way2automation.com/way2auto_jquery/index.php");		
		driver.manage().window().maximize();	
	
			
		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("Surya prakash");
				 
		 WebElement submit = driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/form/div/div[2]/input"));
			submit.click();			
			//fluent wait
			Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
					.withMessage("user defined timed out after 5 seconds").ignoring(NoSuchElementException.class);
	}	
	
	}


