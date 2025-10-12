package Amazon_Login_Automate.AmazonProject;

import org.testng.annotations.Test;

import Amazon_Login_Automate.AmazonProject.pageObject.ProductDetail;

public class TestProductDetail extends BaseTest {

	ProductDetail productInfo;

	@Test
	public void productDetail() {
		productInfo = new ProductDetail(driver);
		productInfo.verifyProductDetailsVisibility();
		logger.info("product displayed verified and title verified");

	}

}
