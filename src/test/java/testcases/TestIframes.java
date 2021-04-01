package testcases;


import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestIframes {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_intro_inner_html");
		driver.manage().window().maximize();
		implicitlyWait(5);
		
		
		// main method
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("/html/body/button")).click();
		//switch back to main window, handling element within the frames
		driver.switchTo().defaultContent();
				
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());

		for (WebElement frame : frames) {
			
			System.out.println(frame.getAttribute("id"));
		}

		
	}

	private static void implicitlyWait(int i) {

	}

}
