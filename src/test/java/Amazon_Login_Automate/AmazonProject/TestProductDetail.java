package Amazon_Login_Automate.AmazonProject;

import org.testng.annotations.Test;

import Amazon_Login_Automate.AmazonProject.pageObject.ProductDetail;

public class TestProductDetail extends BaseTest {
// Jab testng start hua to testng ne automatic test object bnane start kr dye, and variables ko initialize krna start kia to use driver null mila
	// isilye hmne driver ko method me rkha, qk variable initialize ke baad hi
	// beforeTest run hota hai jisme browser wla driver run hoga and then fir
	// method p baat aygi

	ProductDetail detail;

	@Test
	public void prodDetail() {
		detail = new ProductDetail(driver);
		detail.productOPerations();
		logger.info("Filter Applied and Products are showing");
	}

}
