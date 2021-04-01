package testcases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementScreenshot {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver  = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		implicitlyWait(5);
		
		WebElement ele = driver.findElement(By.id("hplogo"));
		
		//screenshot
		File Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(Screenshot);
        //getting location, height and weight
        Point point = ele.getLocation();
        int eleWidth = ele.getSize().getWidth();
        int eleHeight = ele.getSize().getHeight();
		
        BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);        
        ImageIO.write(eleScreenshot, "jpg", Screenshot);
        
        File screenshotLocation = new File(".\\screenshot\\googlelogo.jpg");
        FileUtils.copyFile(Screenshot, screenshotLocation);
        
	}

	private static void implicitlyWait(int i) {
		
		
	}

}
