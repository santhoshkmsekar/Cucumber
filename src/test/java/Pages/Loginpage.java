package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;
import utility.BaseClass;

public class Loginpage extends BaseTest {
	@FindBy(xpath = "//i[@class='fa fa-user-circle']")
	private WebElement Login;

	@FindBy(name = "userEmail")
	private WebElement emailfield;

	@FindBy(name = "userPassword")
	private WebElement password;

	@FindBy(xpath = "//button[text()='Login']")
	private WebElement login;

	@FindBy(xpath = "//div[@role='alertdialog']")
	private WebElement ToastMessage;

	@FindBy(xpath = "(//input[@class='input-radio__input'])[2]")
	private WebElement Online_Button;

	@FindBy(xpath = "//button[text()='Pay Now']")
	private WebElement Pay_Now_Button;

	@FindBy(xpath = "//p[text()='Net Banking']")
	private WebElement Net_Banking_Button;

	@FindBy(xpath = "(//img[@class='ptm-pos-a'])[3]")
	private WebElement Bank_Name_button;

	@FindBy(xpath = "//div[@id='checkout-button']//button[1]")
	private WebElement Pay_Amount_Button;

	@FindBy(xpath = "//button[@class='btn btnd']//span[1]")
	private WebElement Successfull_Button;

	@FindBy(xpath = "//div[@class='col-md-12']//a[1]")
	private WebElement forgot;

	@FindBy(xpath = "//label[text()='Email']/following::input")
	private WebElement forgotmail;

	@FindBy(xpath = "(//button[@type='submit'])[3]")
	private WebElement submit;

	@FindBy(xpath = "//button[text()='Login With OTP']")
	private WebElement loginwithotp;

	@FindBy(name = "mobileNo")
	private WebElement mobilenumberfield;

	@FindBy(xpath = "//button[text()='Send OTP']")
	private WebElement OTP;

	@FindBy(xpath = "(//button[@type='submit'])[3]")
	private WebElement mobileotp;

	@FindBy(xpath = "//div[@id='toast-container']//div")
	private WebElement toastmessage;

	public Loginpage(WebDriver driver) {
		BaseTest.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Login() throws IOException {

		BaseClass.clickelement(Login);

		BaseClass.sendkeys(emailfield, "santhosh.s@technogenesis.in");

		BaseClass.sendkeys(password, "12345678");

		BaseClass.clickelement(login);

		BaseClass.Assertion(toastmessage, "Login successfully");

	}

	/*
	 * public void Payment_Online() {
	 *
	 * BaseClass.clickelement(Online_Button);
	 *
	 * BaseClass.clickelement(Pay_Now_Button);
	 *
	 * BaseClass.clickelement(Net_Banking_Button);
	 *
	 * BaseClass.clickelement(Bank_Name_button);
	 *
	 * BaseClass.clickelement(Pay_Amount_Button);
	 *
	 * BaseClass.multiple_window(driver);
	 *
	 * BaseClass.clickelement(Successfull_Button); BaseClass.waittime(10); }
	 */
	/*
	 * public void clickforgotpassword() { BaseClass.waittime(2000);
	 * BaseClass.clickelement(Login); BaseClass.waittime(2000);
	 * BaseClass.clickelement(forgot); BaseClass.waittime(2000);
	 * BaseClass.sendkeys(forgotmail, "gowtham.k@technogenesis.in");
	 * BaseClass.waittime(2000); BaseClass.clickelement(submit);
	 * BaseClass.waittime(2000); String forgottoast = forgot.getText(); if
	 * (forgottoast.equals("Reset password link has been sent to your email id!")) ;
	 * System.out.println("Both are same");
	 *
	 * }
	 *
	 * public void loginwithotp() { BaseClass.waittime(2000);
	 * BaseClass.clickelement(Login); BaseClass.waittime(2000);
	 * BaseClass.clickelement(loginwithotp); BaseClass.waittime(2000);
	 * BaseClass.sendkeys(mobilenumberfield, "6383251412");
	 * BaseClass.waittime(1000); BaseClass.sendkeys(OTP, "");
	 * BaseClass.waittime(1000); BaseClass.clickelement(mobileotp);
	 *
	 * }
	 */

}
