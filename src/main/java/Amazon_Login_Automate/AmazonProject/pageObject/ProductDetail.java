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

	public void verifyProductDetailsVisibility() {
		waitForElementToAppear(By.cssSelector("span#productTitle"), 10);
		Assert.assertTrue(labelProductTitle.isDisplayed());
		System.out.println(labelProductTitle.getText());
	}

}
