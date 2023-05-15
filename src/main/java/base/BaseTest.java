package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import utility.BaseClass;
import utility.Browser;
import utility.WebEventListener;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventlistener;

	public BaseTest() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "./src/main/java/properties/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeSuite
	public static void InitTest1() {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		Browser.initialization(prop.getProperty("BROWSER_NAME"), prop.getProperty("APP_URL"), driver);

	}

	@AfterSuite
	public static void quit_Browser1() {
		BaseClass.quitbrowser();
	}

}
