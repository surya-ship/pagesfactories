package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.way2automation.com/");
		driver.manage().window().maximize();
		implicitlyWait(5);
		
       List<WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println("--------printing links---------");
		System.out.println("Total links are :"+links.size());
		
		for(WebElement link:links)
		{
			System.out.println(link.getText() +"-----URL IS----"+ link.getAttribute("href"));
		}
		
		
	}

	private static void implicitlyWait(int i) {
		
		
	}

}
