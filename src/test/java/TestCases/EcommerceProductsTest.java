package TestCases;

import java.io.IOException;

import Pages.EcommerceProductsPage;
import Pages.Loginpage;
import base.BaseTest;
import utility.BaseClass;

public class EcommerceProductsTest extends BaseTest {
	public EcommerceProductsTest() {
		super();
	}

	@org.testng.annotations.Test
	public void Ecommercepage() throws IOException {
		try {
			Loginpage log = new Loginpage(driver);
			log.Login();

			EcommerceProductsPage com = new EcommerceProductsPage(driver);
			com.Ecommerceproducts();
			com.Payment_Online();
			com.Order_Page();

		} catch (Exception e) {
			e.printStackTrace();
			BaseClass.takeScreenshotAtEndOfTest();
		}

	}
}
