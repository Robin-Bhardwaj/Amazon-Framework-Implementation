package Amazon_Login_Automate.AmazonProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;

	@BeforeTest
	public void initializeDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=C:/Selenium/Profile1");
		options.addArguments("profile-directory=default");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/ref=nav_logo");

	}

}
