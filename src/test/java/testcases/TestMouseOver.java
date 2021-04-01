package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMouseOver {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");
		driver.manage().window().maximize();
		implicitlyWait(5);
		
		//google search space element is "q"
		driver.findElement(By.name("q")).sendKeys("way2automation");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		//google search button xpath
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\'tsf\']/div[2]/div[1]/div[2]/div[2]/div[2]/center/input[1]"))).click();
        //way2automation link xpath
		driver.findElement(By.xpath("/html/body/div[7]/div[2]/div[10]/div[1]/div[2]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div[1]/a/h3")).click();
 
        //xpath of resources button in website.
        WebElement menu = driver.findElement(By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[8]/a"));
        
        // Actions class
        Actions action = new Actions(driver);
        action.moveToElement(menu).perform();
       
        driver.findElement(By.linkText("Practice site 1")).click();
               
             
	}

	private static void implicitlyWait(int i) {
		
	}

}
