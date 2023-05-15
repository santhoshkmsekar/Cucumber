package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import base.BaseTest;

public class Browser extends BaseTest {

	
	public static WebDriver initialization(String browserName, String app_url, WebDriver driver) {

		if (browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "./drivers/firefoxdriver.exe");
			driver = new FirefoxDriver();
		}

		e_driver = new EventFiringWebDriver(driver);
		eventlistener = new WebEventListener();
		e_driver.register(eventlistener);
		BaseTest.driver = driver;
		// BaseTest.driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		/*
		 * driver.manage().timeouts().pageLoadTimeout(BaseClass.PAGE_LOAD_TIMEOUT,
		 * TimeUnit.SECONDS);
		 * driver.manage().timeouts().implicitlyWait(BaseClass.IMPLICIT_WAIT,
		 * TimeUnit.SECONDS);
		 */
		System.out.println("check the");
		driver.get(app_url);
			BaseClass.waittime(20);
		return driver;
	}

}
