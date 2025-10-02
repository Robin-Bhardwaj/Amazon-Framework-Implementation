package Amazon_Login_Automate.AmazonProject.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductDetail {
	public WebDriver driver;

	public ProductDetail(WebDriver Driver) {
		this.driver = Driver;
		PageFactory.initElements(driver, this);
	}

	public void productOPerations() {
		// Price Range Slider
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Set lower bound slider (index 14 → ₹200)
		WebElement minSlider = driver.findElement(By.id("p_36/range-slider_slider-item_lower-bound-slider"));
		js.executeScript("arguments[0].value=14; arguments[0].dispatchEvent(new Event('input'));", minSlider);

		// Set upper bound slider (index 68 → ₹1250)
		WebElement maxSlider = driver.findElement(By.id("p_36/range-slider_slider-item_upper-bound-slider"));
		js.executeScript("arguments[0].value=68; arguments[0].dispatchEvent(new Event('input'));", maxSlider);

		// Also update hidden inputs explicitly
		WebElement lowHidden = driver.findElement(By.name("low-price"));
		WebElement highHidden = driver.findElement(By.name("high-price"));

		js.executeScript("arguments[0].setAttribute('value','200');", lowHidden);
		js.executeScript("arguments[0].setAttribute('value','1250');", highHidden);

		// Submit filter
		driver.findElement(By.cssSelector("input[aria-label='Go - Submit price range']")).click();

	}

}
