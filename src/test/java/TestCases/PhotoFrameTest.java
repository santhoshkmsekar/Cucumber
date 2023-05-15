package TestCases;

import java.io.IOException;

import Pages.PhotoFramePage;
import base.BaseTest;
import utility.BaseClass;

public class PhotoFrameTest extends BaseTest {
	public PhotoFrameTest() {
		super();
	}

	@org.junit.Test
	void Photo_Frame_Module() throws IOException {
		try {

			PhotoFramePage frame = new PhotoFramePage(driver);
			frame.PhotoFrame();
			frame.Payment_Online();
			frame.Order_Page();
		} catch (Exception e) {
			e.printStackTrace();
			BaseClass.takeScreenshotAtEndOfTest();

		}
	}
}
