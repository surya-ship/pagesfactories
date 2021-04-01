package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSliders {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/slider/");
		driver.manage().window().maximize();
		implicitlyWait(5);
		
		WebElement mainSlider = driver.findElement(By.id("slider"));
		//WebElement mainSlider = driver.findElement(By.xpath("//*[@id=\'slider\']"));
		int width = mainSlider.getSize().width/2;
		
		//slider xpath
		
		WebElement slider = driver.findElement(By.xpath("//*[@id=\'slider\']/span"));
		//*[@id="slider"]/span
		Actions action = new Actions(driver);		
		action.dragAndDropBy(slider, width, 0).build().perform();;
		
		//fluent wait
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withMessage("user defined timed out after 5 seconds").ignoring(NoSuchElementException.class);
			  		
				
	}	
	

	private static void implicitlyWait(int i) {
				
	}

}
