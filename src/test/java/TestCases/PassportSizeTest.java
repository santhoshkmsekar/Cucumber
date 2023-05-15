package TestCases;

import java.io.IOException;

import Pages.PassportSizePage;
import base.BaseTest;
import utility.BaseClass;

public class PassportSizeTest extends BaseTest {
	public PassportSizeTest() {
		super();
	}

	@org.junit.Test
	public void Passport_Size_Module() throws IOException {
		try {

			PassportSizePage pass = new PassportSizePage(driver);
			pass.PassPort_Size_Order();
			pass.Payment_Online();
			pass.Order_Page();
		} catch (Exception e) {
			e.printStackTrace();
			BaseClass.takeScreenshotAtEndOfTest();
		}
	}
}
