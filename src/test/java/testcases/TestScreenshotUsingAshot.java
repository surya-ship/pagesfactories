package testcases;

import java.io.File;
import java.io.IOException;
//import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;



public class TestScreenshotUsingAshot  {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.way2automation.com/");
		driver.manage().window().maximize();
		implicitlywait(5);

		WebElement ele = driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div/div/div[1]/div/div[2]/div[2]"));
		
		//object of a class for full screen shot
		//Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		//ImageIO.write(screenshot.getImage(), "jpg", new File(".\\screenshot\\ashotimg.jpg"));
		
		//element screen shot
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver,ele);
		ImageIO.write(screenshot.getImage(), "png", new File(".\\screenshot\\ashotimgelement.png"));
		

	}

	private static void implicitlywait(int i) {
		
		
	}

}
