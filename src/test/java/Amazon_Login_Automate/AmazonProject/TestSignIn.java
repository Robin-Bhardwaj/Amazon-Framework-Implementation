package Amazon_Login_Automate.AmazonProject;

import java.io.IOException;

import org.testng.annotations.Test;

import Amazon_Login_Automate.AmazonProject.pageObject.SignIn;

public class TestSignIn extends BaseTest {
	SignIn sign;

	@Test
	public void signIn() throws IOException {
		sign = new SignIn(driver);

		sign.login();
		logger.info("Sign Successful");
	}

}
