package TestCases;

import java.awt.AWTException;
import java.io.IOException;

import Pages.PersonalizedProductsPage;
import base.BaseTest;
import utility.BaseClass;

public class PersonalizedProductsTest extends BaseTest {
	public PersonalizedProductsTest() {
		super();

	}

	@org.junit.Test
	public void PersoanlizedProductsModule() throws IOException, AWTException {
		try {

			PersonalizedProductsPage p = new PersonalizedProductsPage(driver);
			p.persoanlizedpage();
			p.Payment_Online();
			p.Order_Page();
		} catch (Exception e) {
			e.printStackTrace();
			BaseClass.takeScreenshotAtEndOfTest();
		}
	}
}
