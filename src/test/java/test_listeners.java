import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import Webdriverlisteners.Weblisteners;
import io.github.bonigarcia.wdm.WebDriverManager;

public class test_listeners {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver webdriver = new FirefoxDriver();
		EventFiringWebDriver driver = new EventFiringWebDriver(webdriver);
		
		Weblisteners listener = new Weblisteners();
		
		driver.register(listener);
		driver.navigate().to("https://www.google.com/");
		//click on business
		driver.findElement(By.xpath("//*[@id=\'fsl\']/a[2]")).click();		
		Thread.sleep(2000);
		
		driver.navigate().back();
		//click on advertising
		driver.findElement(By.xpath("//*[@id=\'fsl\']/a[1]")).click();
		Thread.sleep(1000);
		
		driver.navigate().back();
		Thread.sleep(1000);
		//moving forward method
		driver.navigate().back();
		

	}

}
