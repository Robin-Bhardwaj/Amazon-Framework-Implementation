package Amazon_Login_Automate.AmazonProject;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	public static org.apache.logging.log4j.Logger logger;

	@BeforeTest
	public void initializeDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("user-data-dir=C:/Selenium/Profile1");
		options.addArguments("profile-directory=default");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/ref=nav_logo");
		logger = LogManager.getLogger(this.getClass());

	}

}
