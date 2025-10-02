package Amazon_Login_Automate.AmazonProject;

import org.testng.annotations.Test;

import Amazon_Login_Automate.AmazonProject.pageObject.Sign_In;

public class TestSignIn extends BaseTest {
	Sign_In sign;

	@Test
	public void signIn() {
		sign = new Sign_In(driver);

		sign.loggingIn();
	}

}
