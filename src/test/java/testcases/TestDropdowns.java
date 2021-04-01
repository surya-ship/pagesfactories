package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDropdowns {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		//1) to maximize the window
		driver.manage().window().maximize();
		
		//2) implicitly wait
		implicitlyWait(5);
		//explicit wait
		//WebDriverWait wait = new WebDriverWait(driver, 5);
		
		//3) using select method
		WebElement dropdown = driver.findElement(By.id("searchLanguage"));
		Select select = new Select(dropdown);
		
		// 4)language changing method
		//select.selectByVisibleText("Eesti");
		
		// 5) Alternate language changing method
		select.selectByValue("he");
		
		
		// 6) Finding total no of languages and value of it as output
		List<WebElement> values = dropdown.findElements(By.tagName("option"));
		System.out.println("Total values are :"+values.size());
		
		// 7) to get entire web element of single value the below method is used
		System.out.println(values.get(7).getText());
		
		// 8) printing all the values
		for(int i=0; i<values.size(); i++)
		{
			System.out.println(values.get(i).getAttribute("lang"));
		}
		// 9) finding particular block of elements
		WebElement block = driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[7]/div[3]"));
		List<WebElement> links = block.findElements(By.tagName("a"));
		
		// 10) to print all the links from the webpage
		//List<WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println("--------printing links---------");
		System.out.println("Total links are :"+links.size());
		
		for(WebElement link:links)
		{
			System.out.println(link.getText() +"-----URL IS----"+ link.getAttribute("href"));
		}
		//11) Syntax of getting unique locator having multiple elements with similar names
		WebElement secondBlock = driver.findElement(By.id("blockid"));
		secondBlock.findElements(By.xpath("abc")).get(2).click();

	}

	private static void implicitlyWait(int i) {
		
		
	}

}
