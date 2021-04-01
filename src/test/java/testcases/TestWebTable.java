package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWebTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://money.rediff.com/gainers");
		driver.manage().window().maximize();
		implicitlyWait(5);
		//Explicit wait
		//WebDriverWait wait = new WebDriverWait(driver, 5);
		
		//finding total rows
		List<WebElement> rowNum = driver.findElements(By.xpath("//table[@class ='dataTable']/tbody/tr"));
		System.out.println("Total rows are:"+rowNum.size());
		//finding total columns
		List<WebElement> colNum = driver.findElements(By.xpath("//table[@class ='dataTable']/tbody/tr[1]/td"));
		System.out.println("Total cols are:"+colNum.size());
		
		for(int rows=1; rows<=rowNum.size(); rows++)
		{
			for(int cols=1; cols<=colNum.size(); cols++)
			{
								
				System.out.print(driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr["+rows+"]/td["+cols+"]")).getText()+"   ");
			}
			
			System.out.println();
		}
	}

	private static void implicitlyWait(int i) {
		
		
	}

}
