import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Coordinates;
//it should be internal.locatable
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.internal.EventFiringMouse;

import Webdriverlisteners.Weblisteners;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Mouse_movement {

	public static void main(String[] args, EventFiringMouse EventFiringMouse) throws InterruptedException 
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver webdriver = new FirefoxDriver();
		
		
		//event firing listener
		EventFiringWebDriver driver = new EventFiringWebDriver(webdriver);
		Weblisteners listener = new Weblisteners();		
		driver.register(listener);
		
		//using mouse method
		EventFiringMouse = new EventFiringMouse(driver,listener);
		driver.navigate().to("https://www.google.com/");
		Thread.sleep(2000);
		
		Locatable hoverItem = (Locatable) driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div/div[1]/div[1]/a"));		
		Coordinates cord = hoverItem.getCoordinates();
		
			      
			
		try 
		{
		   mouseMove(cord);
		}
		catch(Throwable t) 
		{
			
		}	
		Thread.sleep(2000);

	}

	private static void mouseMove(Coordinates cord) {
		
		
	}

}
