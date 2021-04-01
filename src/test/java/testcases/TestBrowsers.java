package testcases;

import org.openqa.selenium.WebDriver;

//import org.openqa.selenium.opera.OperaDriver;

//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBrowsers {
	public static String browser ="chrome";//excel sheet
	public static WebDriver driver;

	public static void main(String[] args) {
		
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			 driver.manage().window().maximize();
			 
		}
		else if(browser.equals("firefox"))
		{
			 WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}
		
				
		System.setProperty("webdriver.Chrome.driver","D:\\gecko firefox driver\\Chromedriver.exe");
						
				driver.get("http://gmail.com");
				
				//to get title of web page as the output
				
				String title = driver.getTitle();
				System.out.println(title.length());
				System.out.println(title);	
				
				//driver.close(); //current browser window
				// driver.quit(); //current browser window + all related browsers session
	}
	}


