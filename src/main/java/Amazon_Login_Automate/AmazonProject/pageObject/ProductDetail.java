package Amazon_Login_Automate.AmazonProject.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import AbstractComponent.AbstractComponent;

public class ProductDetail extends AbstractComponent {
	public WebDriver driver;

	public ProductDetail(WebDriver Driver) {
		super(Driver);
		this.driver = Driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "span#productTitle")
	WebElement labelProductTitle;

	@FindBy(css = "#nav-cart-count")
	WebElement iconBeforeCartCount;

	@FindBy(css = "#add-to-cart-button")
	WebElement btnProductAddToCart;

	@FindBy(css = ".attach-close-button")
	WebElement iconCross;

	@FindBy(css = "#nav-cart-count")
	WebElement iconAfterCartCount;

	@FindBy(css = "#buy-now-button")
	WebElement btnBuyNow;

	@FindBy(css = "#deliver-to-customer-text")
	WebElement txtLabel;

	public void verifyProductDetailsVisibility() {
		waitForElementToAppear(By.cssSelector("span#productTitle"), 10);
		Assert.assertTrue(labelProductTitle.isDisplayed());
		boolean visibility = labelProductTitle.isDisplayed();
		System.out.println(visibility);
		System.out.println(labelProductTitle.getText());
	}

	public void productAddToCartOperation() {
		String beforeCartCount = iconBeforeCartCount.getText().trim();
		int beforeCartCountInteger = Integer.parseInt(beforeCartCount);

		btnProductAddToCart.click();
		iconCross.click();

		String afterCartCount = iconAfterCartCount.getText().trim();
		int afterCartCountInteger = Integer.parseInt(afterCartCount);
		System.out.println(afterCartCountInteger);
		Assert.assertEquals(afterCartCountInteger, beforeCartCountInteger + 1);
	}

	public void productBuyNowOperation() {
		btnBuyNow.click();
	}

	public void verifyTextAfterChooseBuyNow() {
		String expectedText = txtLabel.getText();
		System.out.println(expectedText);
		Assert.assertEquals("Delivering to Robin Bhardwaj", expectedText);

	}

}
