package AbstractComponent;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	WebDriver driver;
	public String parentWindow;
	public String childWindow;

	public JavascriptExecutor js;

	public AbstractComponent(WebDriver Driver) {
		this.driver = Driver;
		PageFactory.initElements(driver, this);
	}

	public void waitForElementToAppear(By locator, int timeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	public void jsExecutor() {
		js = (JavascriptExecutor) driver;
	}

	public void handles() {
		Set<String> allHandles = driver.getWindowHandles();
		Iterator<String> it = allHandles.iterator();
		parentWindow = it.next();
		childWindow = it.next();
	}

}
