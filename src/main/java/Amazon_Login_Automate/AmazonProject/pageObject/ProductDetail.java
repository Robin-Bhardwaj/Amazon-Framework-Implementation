package Amazon_Login_Automate.AmazonProject.pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.AbstractComponent;

public class ProductDetail extends AbstractComponent {
	public WebDriver driver;

	public ProductDetail(WebDriver Driver) {
		super(Driver);
		this.driver = Driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[aria-label='Go - Submit price range']")
	WebElement btnSubmitPriceRangeFilter;

	// Set lower bound slider (index 14 → ₹200)
	@FindBy(id = "p_36/range-slider_slider-item_lower-bound-slider")
	WebElement lowerBoundSlider;

	// Set upper bound slider (index 14 → ₹200)
	@FindBy(id = "p_36/range-slider_slider-item_upper-bound-slider")
	WebElement upperBoundSlider;

	// Also update hidden inputs explicitly
	@FindBy(name = "low-price")
	WebElement lowerBoundSliderExplicitlyUpdate;

	@FindBy(name = "high-price")
	WebElement upperBoundSliderExplicitlyUpdate;

	public void productOPerations() {
		// Price Range Slider
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Set lower bound slider (index 14 → ₹200)
		WebElement minSlider = lowerBoundSlider;
		js.executeScript("arguments[0].value=14; arguments[0].dispatchEvent(new Event('input'));", minSlider);

		// Set upper bound slider (index 68 → ₹1250)
		WebElement maxSlider = upperBoundSlider;
		js.executeScript("arguments[0].value=68; arguments[0].dispatchEvent(new Event('input'));", maxSlider);

		// Also update hidden inputs explicitly
		WebElement lowHidden = lowerBoundSliderExplicitlyUpdate;
		WebElement highHidden = upperBoundSliderExplicitlyUpdate;

		js.executeScript("arguments[0].setAttribute('value','200');", lowHidden);
		js.executeScript("arguments[0].setAttribute('value','1250');", highHidden);

		// Submit filter
		btnSubmitPriceRangeFilter.click();

	}

}
