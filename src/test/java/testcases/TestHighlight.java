package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestHighlight {

	public static void main(String[] args, Object elem) {
		WebDriverManager.operadriver().setup();
		WebDriver driver = new OperaDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		implicitlyWait(5);
		
		
		WebElement username = driver.findElement(By.id("email"));
		TestHighlight.highlightElement(driver, username);
		
		//highlighting the element
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("email");
		//js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');\", element", driver.findElement(By.id("email")));
		((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);

	}

	private static void highlightElement(WebDriver driver, WebElement username) {
		
		
	}

	private static void implicitlyWait(int i) {
		
		
	}

}
