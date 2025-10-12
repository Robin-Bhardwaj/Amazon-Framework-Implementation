package Amazon_Login_Automate.AmazonProject.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.AbstractComponent;

public class ProductList extends AbstractComponent {
	public WebDriver driver;

	public ProductList(WebDriver Driver) {
		super(Driver);
		this.driver = Driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[contains(@aria-label,'Airdopes 311 Pro')]")
	WebElement h2productclick;

	public void scrollThroughProducts() {
		waitForElementToAppear(By.cssSelector(".addToCartShoppingPortalCSRFToken"), 20);
		jsExecutor();
		js.executeScript("window.scrollBy(0,900)");
	}

	public void selectProduct() {
		h2productclick.click();
		handles();
		driver.switchTo().window(childWindow);
	}

}
