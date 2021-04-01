package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestKeyboardEvents {

	public static void main(String[] args) {
		WebDriverManager.operadriver().setup();
		WebDriver driver = new OperaDriver();
		driver.get("https://gmail.com");
		driver.manage().window().maximize();
		implicitlyWait(5);
		
		driver.findElement(By.id("identifierId")).sendKeys("leverage.surya@gmail.com");
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]")).click();
		//driver.findElement(By.id("identifierId")).sendKeys(Keys.ENTER);
		
		//main method using actions
		Actions action = new Actions(driver);
		//action.sendKeys(Keys.ENTER).perform();
		
		//using build() to combine methods
		action.sendKeys(Keys.chord(Keys.CONTROL+"a")).sendKeys(Keys.chord(Keys.CONTROL+"c")).build().perform();
		
	
		driver.findElement(By.id("identifierId")).click();
		action.sendKeys(Keys.chord(Keys.CONTROL+"v")).perform();
		
	}

	private static void implicitlyWait(int i) {
		
		
	}

}
