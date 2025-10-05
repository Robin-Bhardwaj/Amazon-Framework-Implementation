package Amazon_Login_Automate.AmazonProject.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.AbstractComponent;

public class ProductList extends AbstractComponent {
	public WebDriver driver;

	public ProductList(WebDriver Driver) {
		super(Driver);
		this.driver = Driver;
		PageFactory.initElements(driver, this);
	}

	public void scrollThroughProducts() {
		jsExecutor();
		js.executeScript("window.scrollBy(0,800)");
	}

}
