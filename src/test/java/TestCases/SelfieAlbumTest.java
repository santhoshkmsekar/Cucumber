package TestCases;

import java.io.IOException;

import Pages.SelfieAlbumPage;
import base.BaseTest;
import utility.BaseClass;

public class SelfieAlbumTest extends BaseTest {
	public SelfieAlbumTest() {
		// TODO Auto-generated constructor stub
		super();
	}

	@org.junit.Test
	public void Selfie() throws IOException {
		try {

			SelfieAlbumPage se = new SelfieAlbumPage(driver);
			se.clickSelfie();
			se.Payment_Online();
			se.Order_Page();

		} catch (Exception e) {
			e.printStackTrace();
			BaseClass.takeScreenshotAtEndOfTest();
		}

	}
}