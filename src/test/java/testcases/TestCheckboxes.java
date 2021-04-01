package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

// worked on the website tizag.com of drop boxes concept
public class TestCheckboxes {
	public static WebDriver driver;
	
	  
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");		
		driver.manage().window().maximize();		
		implicitlyWait(5);
		//WebDriverWait wait = new WebDriverWait(driver, 5);
		
	 	//method for clicking and finding total no of check boxes in a block	
		WebElement block = driver.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]"));
		List<WebElement> checkboxes = block.findElements(By.name("sports"));
		
		System.out.println("Total checkboxes are: "+checkboxes.size());
		
		for(WebElement checkbox: checkboxes)
		{
			checkbox.click();
		}
	
	}

	private static void implicitlyWait(int i) {
		
		
	}

}


