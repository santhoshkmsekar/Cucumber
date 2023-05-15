package TestCases;

import java.io.IOException;

import org.junit.Test;

import Pages.Loginpage;
import base.BaseTest;
import utility.BaseClass;

public class LoginPageTest extends BaseTest {
	public LoginPageTest() {
		super();
	}

	@Test
	public void Login() throws IOException {
		try {
			Loginpage login = new Loginpage(driver);
			login.Login();
		} catch (Exception e) {
			e.printStackTrace();
			BaseClass.takeScreenshotAtEndOfTest();
		}
	}

}
