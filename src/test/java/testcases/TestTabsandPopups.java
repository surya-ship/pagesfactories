package testcases;

import java.util.Iterator;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestTabsandPopups {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://hdfcbank.com");
		driver.manage().window().maximize();
		implicitlyWait(5);
		
		System.out.println("------Generating window ids from first window-------");
		Set<String> Winids= driver.getWindowHandles();
		Iterator<String> iterate = Winids.iterator();
		
		String first_window = iterate.next();
		System.out.println(first_window);
		
		driver.findElement(By.id("custom-button")).click();
		//2nd window
		
		System.out.println("------Generating window ids from second window-------");
		 Winids= driver.getWindowHandles();
		 iterate = Winids.iterator();
		
		System.out.println(iterate.next());
		
			
		driver.findElement(By.xpath("//*[@id=\'main\']/div[2]/div[12]/div[3]/div/div/div/div/div[2]/div[2]/div[2]/div[3]/a[1]")).click();
		 driver.findElement(By.xpath("/html/body/div[4]/div[2]/div[4]/div/div/div[4]/div/a")).click();
		
				
		//3rd window
		
		System.out.println("------Generating window ids from third window-------");
		 Winids= driver.getWindowHandles();
		 iterate = Winids.iterator();
		 
		 System.out.println( iterate.next()); 
				 
		 String third_window = iterate.next(); //3rd window
		 
		 //main iterate method for all the windows instead of writing program for every single window.
		 while(iterate.hasNext()) {
			 iterate.next();
		 }
		 
		 
		 System.out.println(third_window);
		 driver.switchTo().window(third_window);
		 
		System.out.println(driver.getTitle().contains("JetPrivilege HDFC Bank Signature"));
		
		driver.close(); //3rd window
		//driver.switchTo().window(first_window);
		//driver.close();
		
		//driver.quit();

	}

	private static void implicitlyWait(int i) {
		
		
	}

}
