package components;

import org.testng.annotations.AfterMethod;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import org.testng.annotations.BeforeMethod;


import pageObjects.HomePage;

public class Components{

	public WebDriver driver;
	public HomePage homePage;
	public WebDriver initializeDriver() throws IOException {
		FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\GlobalProperties.properties");
		Properties prop =  new Properties();
		prop.load(fileInputStream);
		String browserName =prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(co);
			return driver;

		}
		else if(browserName=="firefox") {	
			driver = new FirefoxDriver();
			return driver;
		}
		else if(browserName=="edge") {
			driver = new EdgeDriver();
			return driver;
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	
	@BeforeMethod(alwaysRun = true)
	public HomePage launchAppliaction() throws IOException {
		driver= initializeDriver();
		homePage = new HomePage(driver);
		homePage.goTo();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return homePage;
	}

	
	
	  @AfterMethod(alwaysRun = true) 
	  public void tearDown() { 
		  driver.close(); 
		  }
	 
	
	
	
	
	
	
}
