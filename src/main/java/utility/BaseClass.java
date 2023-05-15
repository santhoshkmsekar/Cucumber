package utility;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class BaseClass extends BaseTest {
	public static WebDriver driver;
	public static String value;
	// public static JavascriptExecutor js;

	public BaseClass() {
		BaseClass.driver = BaseTest.driver;
	}

	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static String ParentWindow;

	public static String getdata(Integer SHEET, Integer ROW, Integer CELL) throws IOException {
		String value = null;
		try {

			FileInputStream fis = new FileInputStream("./TestData/Data.xlsx");
			XSSFWorkbook Bookmark = new XSSFWorkbook(fis);
			XSSFSheet sheet = Bookmark.getSheetAt(SHEET);
			Row row = sheet.getRow(ROW);
			Cell cell = row.getCell(CELL);
			value = cell.getStringCellValue();

			return value;
		} catch (FileNotFoundException e) {
			System.out.println("No file found" + " " + e.getMessage());
		} catch (IOException e) {
			System.out.println("No input found" + " " + e.getMessage());
		}
		return value;
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	public static void clickelement(WebElement element) {
		try {

			explicitwait(20, element);
			element.click();

		} catch (Exception e) {

			System.out.println("No element found So Quiting the browser");
			e.printStackTrace();
			quitbrowser();
		}
	}

	public static void sendkeys(WebElement element, String value) {
		try {
			explicitwait(10, element);
			element.sendKeys(value);
		} catch (Exception e) {

			System.out.println("No element found. So Quiting the browser");
			e.printStackTrace();
		}
	}

	public static void implicitwait(int seconds) {
		try {
			BaseTest.driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static void explicitwait(int seconds, WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static void waittime(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void upload_file(String filepath) {
		try {
			StringSelection ss = new StringSelection(filepath);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			Robot robot = new Robot();
			robot.delay(250);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.delay(90);
			robot.keyRelease(KeyEvent.VK_ENTER);
			System.out.println("Uploaded the document" + " " + filepath);
			// waittime(5);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public static void move_to_element(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.clickAndHold();

	}

	public static String gettext(WebElement element) {
		try {
			explicitwait(10, element);
			value = element.getText();
		} catch (Exception e) {
			System.out.println("Enable to get the text");
			e.printStackTrace();
		}
		return value;
	}

	public static void scroll_down() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 4500)");
	}

	public static void Assertion(WebElement element, String Expectedtext) {
		try {
			explicitwait(10, element);
			value = element.getText();
			assertEquals(value, Expectedtext);
			System.out.println("Assertion Passed for the element" + " " + Expectedtext);
		} catch (AssertionError e) {
			System.out.println("Assertion failed" + " " + "Actual text is" + " " + value);
			e.printStackTrace();
		}
	}

	public static void Assertion_Text(String ActualText, String ExpectedString) {
		try {
			assertTrue(ActualText.equalsIgnoreCase(ExpectedString));
			System.out.println("Assertion Passed for the string" + ExpectedString);
		} catch (AssertionError e) {
			// TODO: handle exception

			System.out.println(
					"Assertion failed, Actual Text is " + ActualText + " and Expected String is " + ExpectedString);
		}

	}

	public static void multiple_window(WebDriver driver) {
		ParentWindow = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		Iterator<String> iterator = allWindowHandles.iterator();

		while (iterator.hasNext()) {
			String ChildWindow = iterator.next();
			if (!ParentWindow.equalsIgnoreCase(ChildWindow)) {
				driver.switchTo().window(ChildWindow);
			}

		}

	}

	public static void quitbrowser() {
		try {
			BaseTest.driver.quit();
		} catch (Exception e) {
			System.out.println("Unable to quit the browser");
		}
	}

	public static boolean isclicked(WebElement element) {
		try {
			element.isEnabled();
			System.out.println("Element is clicked");
		} catch (Exception e) {
			// TODO: handle exception

			System.out.println("Element is failed");
		}
		return true;
	}
}
