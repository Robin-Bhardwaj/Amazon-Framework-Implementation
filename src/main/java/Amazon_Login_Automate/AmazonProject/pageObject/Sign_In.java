package Amazon_Login_Automate.AmazonProject.pageObject;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.AbstractComponent;

public class Sign_In extends AbstractComponent {
	public WebDriver driver;
	public Properties p;

	public Sign_In(WebDriver Driver) {
		super(Driver); // calls AbstractComponent’s constructor
		this.driver = Driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[contains(text(),'Delivering to Faridabad 121004')]")
	List<WebElement> checkLoggedInOrNot;

	@FindBy(css = "input[name=\"email\"]")
	WebElement txtEnterEmail;

	@FindBy(css = "input[type=\"submit\"]")
	WebElement btnSubmitEmail;

	@FindBy(css = "input[type=\"password\"]")
	WebElement txtEnterPass;

	@FindBy(css = "input[id=\"signInSubmit\"]")
	WebElement btnSubmitPass;

	@FindBy(css = "input[id=\"twotabsearchtextbox\"]")
	WebElement txtsearchBrand;

	public void loggingIn() throws IOException {
		FileReader file = new FileReader("./src/test/resources/config.properties");
		p = new Properties();
		p.load(file);

		if (checkLoggedInOrNot.size() > 0) {
			// Hover on Hello SignIn and click on SignIn button
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.id("nav-link-accountList")))
					.click(driver.findElement(By.cssSelector(".nav-action-inner"))).build().perform();

			// Enter Email and Password to SignIn
			txtEnterEmail.sendKeys(p.getProperty("signInEmail"));
			btnSubmitEmail.click();

			txtEnterPass.sendKeys(p.getProperty("signInPassword"));
			btnSubmitPass.click();

		}

		// Search for Brands
		txtsearchBrand.sendKeys(p.getProperty("searchForProduct") + Keys.ENTER);

	}
}
