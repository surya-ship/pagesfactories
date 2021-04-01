package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFindingElements {

	
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://gmail.com");
		//to maximize the window
		driver.manage().window().maximize();
		
		//implicity wait
		implicitlyWait(10);
		

		String title = driver.getTitle();
		
		System.out.println(driver.getTitle().length());
		

		// using locator id
		WebElement username = driver.findElement(By.cssSelector("#identifierId"));
		
        driver.findElement(By.xpath("//*[@id=\'identifierId\']"));
		
		driver.findElement(By.name("identifier")).sendKeys("leverage.surya@gmail.com");
		
		WebElement nextBtn = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/div[2]"));
		nextBtn.click();
		
		driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("12345"); 
        	
		//explicit wait for visibility condition
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='identifierId']")));
		sendKeys("leverage.surya@gmail.com"); 
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"))).getText();
		sendKeys("12345"); 
		
		//fluent wait
		Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
				.withMessage("user defined timed out after 5 seconds").ignoring(NoSuchElementException.class);

	}
	private static void implicitlyWait(int i) {
				
	}
	private static void sendKeys(String string) {

	}
	
}

