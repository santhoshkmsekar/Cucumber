package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseTest;
import utility.BaseClass;

public class PhotoFramePage extends BaseTest {
	@FindBy(linkText = "Photo Frame")
	private WebElement Photo_Frame;
	@FindBy(xpath = "(//div[@class='products-list__item ng-star-inserted'])[2]//img")
	private WebElement Photo_Frame_Card;
	@FindBy(xpath = "//div[@class='function-a editedCss change-a ng-star-inserted']")
	private WebElement Color_Card_Elemet;
	@FindBy(xpath = "(//tr[@class='ng-star-inserted'])[1]//i")
	private WebElement First_Upload_Button;
	@FindBy(xpath = "(//tr[@class='ng-star-inserted'])[2]//i")
	private WebElement Second_Upload_Button;
	@FindBy(xpath = "//button[@class='over-change icon-w-a']")
	private WebElement Buy_Now_Button;
	@FindBy(xpath = "//div[@id='toast-container']//div")
	private WebElement toastmessage;
	@FindBy(xpath = "//div[@class='d-flex product_view_details_new_price']/h3[1]")
	private WebElement Price_Card;
	@FindBy(xpath = "//div[@class='event-a d-flex align-items-baseline my-3 align-items-center']//h3")
	private WebElement SubTotal;
	@FindBy(xpath = "//div[@class='event-b d-flex align-items-baseline align-items-center my-3']//h3")
	private WebElement ShippingCharge;
	@FindBy(xpath = "//div[@class='event-c d-flex align-items-baseline align-items-center']//h3")
	private WebElement Total;
	@FindBy(xpath = "(//input[@class='input-radio__input'])[2]")
	private WebElement Online_Button;
	@FindBy(xpath = "//h3[@class='mt-4']")
	private WebElement Order_Id_Text;
	@FindBy(xpath = "//h3[@class='mt-3']")
	private WebElement Order_Date;
	@FindBy(xpath = "(//h3[@class='mt-3'])[2]")
	private WebElement Order_Item;
	@FindBy(xpath = "(//h3[@class='mt-3'])[3]")
	private WebElement Order_Quantity;
	@FindBy(xpath = "//h4[@class='mt-4']")
	private WebElement Order_Amount;
	@FindBy(xpath = "(//h3[@class='mt-3'])[7]")
	private WebElement Payment_Method;
	@FindBy(xpath = "//h3[@class='mt-3 ng-star-inserted']")
	private WebElement Transaction_Id;
	@FindBy(xpath = "//h1[@class='mb-3']")
	private WebElement Product_Name_Order;
	@FindBy(xpath = "//div[@class='d-flex align-items-center mb-2 order_mt_0']//h3[1]")
	private WebElement Order_Amount_Price;
	@FindBy(xpath = "//div[@class='d-flex align-items-center delivery_section']//h4[1]")
	private WebElement Expected_Delivery;
	@FindBy(xpath = "//button[text()='Pay Now']")
	private WebElement Pay_Now_Button;
	@FindBy(xpath = "//p[text()='Net Banking']")
	private WebElement Net_Banking_Button;
	@FindBy(xpath = "(//img[@class='ptm-pos-a'])[3]")
	private WebElement Bank_Name_Button;

	@FindBy(xpath = "//div[@id='checkout-button']//button[1]")
	private WebElement Pay_Amount_Button;

	@FindBy(xpath = "//button[@class='btn btnd']//span[1]")
	private WebElement Successfull_Button;
	@FindBy(xpath = "//h1[text()='Customer Info']/following-sibling::h6")
	List<WebElement> customer;
	@FindBy(xpath = "//h1[text()='Delivery Address ']/following::h6")
	List<WebElement> delivery_address;
	@FindBy(xpath = "//a[@class='btn btn-header-link']")
	private WebElement more_details;
	@FindBy(xpath = "//span[@class='cod_style ng-star-inserted']/ancestor::h1")
	private WebElement Product_Name;
	@FindBy(xpath = "//h3[@class='chip_bg']")
	private WebElement framename;
	@FindBy(xpath = "//td[@class='ng-star-inserted']//div//h3")
	private WebElement color;
	@FindBy(xpath = "//div[@class='product_view_details_new product-change-content list-show']//div[1]//h1")
	private WebElement Product_Name_Card_Element;
	@FindBy(xpath = "//button[text()='Go to My Orders']")
	private WebElement Go_To_My_Orders;
	@FindBy(xpath = "//th[text()='Order ID']//following::tr[1]//td[2]")
	private WebElement Order_id;
	// (//div[@class='products-list__item ng-star-inserted'])[1]//img[1]
	String price;
	String Color_Card;
	String Product_Name_Card;
	String Frame_Name;
	String Product_Name_Cart;

	public PhotoFramePage(WebDriver driver) {
		BaseTest.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void PhotoFrame() {
		BaseClass.clickelement(Photo_Frame);
		BaseClass.clickelement(Photo_Frame_Card);
		price = BaseClass.gettext(Price_Card);
		Product_Name_Card = BaseClass.gettext(Product_Name_Card_Element);
		Color_Card = BaseClass.gettext(Color_Card_Elemet);
		BaseClass.clickelement(Product_Name_Card_Element);
		BaseClass.clickelement(First_Upload_Button);
		BaseClass.upload_file("C:\\Users\\Techno Genesis\\Desktop\\OLD\\File.jpg");
		BaseClass.Assertion(toastmessage, "File has uploaded.");
		BaseClass.clickelement(Second_Upload_Button);
		BaseClass.waittime(10);
		BaseClass.upload_file("C:\\Users\\Techno Genesis\\Desktop\\OLD\\File.jpg");
		BaseClass.Assertion(toastmessage, "File has uploaded.");
		BaseClass.waittime(10);
		BaseClass.clickelement(Buy_Now_Button);
		BaseClass.Assertion(toastmessage, "Product added to cart and moved to checkout successfully!");
		BaseClass.waittime(10);
	}

	public void Payment_Online() {
		BaseClass.clickelement(more_details);
		Frame_Name = (BaseClass.gettext(framename));
		String Colour = (BaseClass.gettext(color));
		if (Colour.equals(Color_Card)) {
			System.out.println("Colour is " + Colour);
		} else {
			System.out.println("Colour is not equal to " + Colour);
		}
		String Subtotal = (BaseClass.gettext(SubTotal));
		BaseClass.gettext(ShippingCharge);
		BaseClass.gettext(Total);
		if (Subtotal.equals(price)) {
			System.out.println("Price is " + Subtotal);
		} else {
			System.out.println("Home price" + " " + price + " " + "is not equal to" + " order price " + Subtotal);
		}
		for (WebElement webElement : customer) {
			String Customer_Details_1 = BaseClass.gettext(webElement);
			System.out.println(Customer_Details_1);
		}
		for (WebElement webElement : delivery_address) {
			String Delivery_Address = BaseClass.gettext(webElement);
			System.out.println(Delivery_Address);
		}
		BaseClass.clickelement(Online_Button);
		BaseClass.clickelement(Pay_Now_Button);
		BaseClass.Assertion(toastmessage, "Payment initiated!");
		BaseClass.clickelement(Net_Banking_Button);
		BaseClass.clickelement(Bank_Name_Button);
		BaseClass.clickelement(Pay_Amount_Button);
		BaseClass.multiple_window(driver);
		BaseClass.clickelement(Successfull_Button);
		// BaseClass.multiple_window(driver);
		BaseTest.driver.switchTo().window(BaseClass.ParentWindow);
		BaseClass.gettext(toastmessage);
		BaseClass.Assertion(toastmessage, "Order placed successfully");
		BaseClass.clickelement(Go_To_My_Orders);
		BaseClass.clickelement(Order_id);

		BaseClass.waittime(10);
	}

	public void Order_Page() {
		String Order_Id_String = (BaseClass.gettext(Order_Id_Text));
		System.out.println(Order_Id_String);
		String Order_Date_String = (BaseClass.gettext(Order_Date));
		System.out.println(Order_Date_String);
		String Order_Item_String = (BaseClass.gettext(Order_Item));
		System.out.println(Order_Item_String);
		String Order_Quantity_String = (BaseClass.gettext(Order_Quantity));
		System.out.println(Order_Quantity_String);
		String Payment_Method_String = (BaseClass.gettext(Payment_Method));
		System.out.println(Payment_Method_String);
		String Transaction_Id_String = (BaseClass.gettext(Transaction_Id));
		System.out.println(Transaction_Id_String);
		String Product_Name_Order_String = (BaseClass.gettext(Product_Name_Order));
		System.out.println(Product_Name_Order_String);
		if (Product_Name_Order_String.equals(Product_Name_Card)) {
			System.out.println("ProductName is " + Product_Name_Card);
		} else {
			System.out.println("ProductName" + " " + "is not equal to " + Product_Name_Card);
		}
		String Order_Amount_Price_String = (BaseClass.gettext(Order_Amount_Price));
		System.out.println(Order_Amount_Price_String);
		String Expected_Delivery_String = (BaseClass.gettext(Expected_Delivery));
		System.out.println(Expected_Delivery_String);
	}
}
