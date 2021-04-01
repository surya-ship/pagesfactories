package testcases;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Iframes {

	public static void main(String[] args) throws IOException {
		WebDriverManager.operadriver().setup();
		WebDriver driver = new OperaDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_form_submit");
		driver.manage().window().maximize();
		implicitlyWait(5);
		
		driver.switchTo().frame("iframeResult");
		
		
		
		//alternate method, write onclick of inspect element
		//js.executeScript("myFunction()");
		
		//to highlight the element with color	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');\", element", driver.findElement(By.id("myForm")));
		
		driver.switchTo().defaultContent();
		
		
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());

		for (WebElement frame : frames) {
			
			System.out.println(frame.getAttribute("id"));
		}
		
		
		//taking screenshots
		File Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile( Screenshot, new File(".//screenshot//error.jpg"));
	  
	    
	}

	private static void implicitlyWait(int i) {

	}

}
