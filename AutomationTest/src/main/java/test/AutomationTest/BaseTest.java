package test.AutomationTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.HomePage;

public class BaseTest {
	public static WebDriver driver;
	public String sURL = "";
	public HomePage homePage;
	
	

	public WebDriver getDriver() {
		return driver;
	}

	@BeforeMethod
	public void methodLevelSetup() {
	
		homePage = new HomePage(driver);
	}
	

	@BeforeClass
	public void classLevelSetup() throws IOException {
		System.out.println(1);
		Properties pProperty = new Properties();
		String sPropertyFile = System.getProperty("user.dir") + "\\src\\test\\resources\\data.properties";
		FileInputStream fisProperty = new FileInputStream(sPropertyFile);
		pProperty.load(fisProperty);
		String sBrowserName = pProperty.getProperty("browser");
		sURL = pProperty.getProperty("url");

		if (sBrowserName.toLowerCase().equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (sBrowserName.toLowerCase().equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (sBrowserName.toLowerCase().equals("ie")) {
			WebDriverManager.iedriver().setup();
			// driver = new driver;
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(60));
		// driver.get(sURL);
		System.out.println(2);
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
