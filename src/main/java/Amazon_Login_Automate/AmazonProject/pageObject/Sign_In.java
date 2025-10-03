package Amazon_Login_Automate.AmazonProject.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.AbstractComponent;

public class Sign_In extends AbstractComponent {
	public WebDriver driver;

	public Sign_In(WebDriver Driver) {
		super(Driver); // calls AbstractComponent’s constructor
		this.driver = Driver;
		PageFactory.initElements(driver, this);
	}

	public void loggingIn() {
		String signInEmail = "bhardwajrobin771@gmail.com";
		String signInPassword = "Welcome@#123";
		String searchForProduct = "Boat ear buds";

		if (driver.findElements(By.xpath("//span[contains(text(),'Delivering to Faridabad 121004')]")).size() > 0) {
			// Hover on Hello SignIn and click on SignIn button
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.id("nav-link-accountList")))
					.click(driver.findElement(By.cssSelector(".nav-action-inner"))).build().perform();

			// Enter Email and Password to SignIn
			driver.findElement(By.cssSelector("input[name=\"email\"]")).sendKeys(signInEmail);
			driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();

			driver.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys(signInPassword);
			driver.findElement(By.cssSelector("input[id=\"signInSubmit\"]")).click();

		}

		// Search for Brands
		driver.findElement(By.cssSelector("input[id=\"twotabsearchtextbox\"]")).sendKeys(searchForProduct + Keys.ENTER);

	}
}
