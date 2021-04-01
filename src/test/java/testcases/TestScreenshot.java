package testcases;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScreenshot {
	
	public static void captureScreenshot() throws IOException {
		//time stamp
		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace("  ", "_")+".jpg";
		
		//screenshot
		File Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile( Screenshot, new File(".//screenshot//"+fileName));
			
		
	}
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws IOException {
								
		WebDriverManager.firefoxdriver().setup();
		driver  = new FirefoxDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_form_submit");
		driver.manage().window().maximize();
		implicitlyWait(5);
		
		driver.switchTo().frame("iframeResult");
		
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());

		for (WebElement frame : frames) {
			
			System.out.println(frame.getAttribute("id"));
		}
		captureScreenshot();

	}
		
	private static void implicitlyWait(int i) {
		
		
	}

}
