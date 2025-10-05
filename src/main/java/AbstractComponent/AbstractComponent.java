package AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	WebDriver driver;

	public JavascriptExecutor js;

	public AbstractComponent(WebDriver Driver) {
		this.driver = Driver;
		PageFactory.initElements(driver, this);
	}

	public void waitForElementToAppear(WebElement element, int timeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void jsExecutor() {
		js = (JavascriptExecutor) driver;
	}

}
