package Amazon_Login_Automate.AmazonProject;

import org.testng.annotations.Test;

import Amazon_Login_Automate.AmazonProject.pageObject.ProductList;

public class TestProductList extends BaseTest {
	ProductList listOperations;

	@Test
	public void productListOperations() {
		listOperations = new ProductList(driver);
		listOperations.scrollThroughProducts();
		logger.info("Scroll on Product page succesfully completed");
		listOperations.selectProduct();
		logger.info("Product Selected");

	}

}
