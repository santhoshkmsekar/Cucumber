package TestCases;

import java.io.IOException;

import Pages.PhotoPrintPage;
import base.BaseTest;
import utility.BaseClass;

public class PhotoPrintTest extends BaseTest {
	public PhotoPrintTest() {
		super();
	}

	@org.junit.Test
	public void Photo_Print_Module() throws IOException {
		try {
			PhotoPrintPage photoprint = new Pages.PhotoPrintPage(driver);
			photoprint.Photoprintproducts();
			photoprint.Payment_Online();
			photoprint.Order_Page();
		} catch (Exception e) {
			e.printStackTrace();
			BaseClass.takeScreenshotAtEndOfTest();
		}
	}
}
