package testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestAlert {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.manage().window().maximize();
		implicitlyWait(5);
		
		driver.findElement(By.name("proceed")).click();
		//using alert method
		/*Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();*/
		
		//alternate method using explicit wait
		WebDriverWait wait = new WebDriverWait(driver,5);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert.getText());
		alert.accept();

	}
		
	private static void implicitlyWait(int i) {
		
		
	}

}
