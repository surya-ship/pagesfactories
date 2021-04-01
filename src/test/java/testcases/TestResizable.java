package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestResizable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		implicitlyWait(5);
		//WebDriverWait wait = new WebDriverWait(driver, 5);
		
		WebElement resizable = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));
		
		Actions action = new Actions(driver);
		action.dragAndDropBy(resizable, 400, 400).perform();
		
		//fluent wait
				Wait<WebDriver> wait1 = new FluentWait<WebDriver>(driver)
						.withMessage("user defined timed out after 5 seconds").ignoring(NoSuchElementException.class);


	}

	private static void implicitlyWait(int i) {
		
		
	}

}
