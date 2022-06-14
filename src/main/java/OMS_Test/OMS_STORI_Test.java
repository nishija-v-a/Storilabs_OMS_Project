package OMS_Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import OMS_Basetest.OMS_Testbase;
import OMS_Pages.OMS_CreateordersPage;
import OMS_Pages.OMS_Findorderpage;
import OMS_Pages.OMS_Loginpage;
import OMS_Pages.OMS_SalesOrdersPage;

public class OMS_STORI_Test extends OMS_Testbase {
	OMS_Loginpage loginPage;
	OMS_Findorderpage findorder;
	OMS_CreateordersPage createorder;
	OMS_SalesOrdersPage salesOrdersPage;
	WebDriverWait wait;

	private static final Logger log = LogManager.getLogger(OMS_STORI_Test.class);

	@Test(priority = 1)
	public void loginTest() {

		loginPage = new OMS_Loginpage(driver);
		log.info("Verifying successful login.");
		loginPage.show_password();
	}

	@DataProvider(name = "loginCredentials")
	public Object[][] getData() {
		return new Object[][] {

				{ "vt@testvox.com", "  ", "Please fill out the field" },
				{ " ", "vt@testvox.com", "Please fill out the field" }, { "  ", "  ", "Please fill out the field" },
				{ "vt@testvox.com", "abc", "*Incorrect Credentials! Try again" },
				{ "abc", "vt@testvox.com", "*Incorrect Credentials! Try again" },
				{ "abc", "def", "*Incorrect Credentials! Try again" }, { "vt@testvox.com", "vt@testvox.com", " " }, };
	};

	@Test(dataProvider = "loginCredentials")
	public void loginfunction(String UserName, String Password, String Errormessage) {
		wait = new WebDriverWait(driver, 20);

		WebElement username = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"emailaddress\"]")));
		username.sendKeys(Keys.CONTROL + "t");
		username.clear();
		username.sendKeys(UserName);

		WebElement password = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]")));
		password.sendKeys(Keys.CONTROL + "t");
		password.clear();
		password.sendKeys(Password);

		WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/app-root/div/app-sign-in/div/div/div/div/div/div[2]/form/div[4]/button")));
		loginButton.sendKeys(Keys.CONTROL + "t");
		loginButton.sendKeys(Keys.ENTER);
	}

	@Test(priority = 2)
	public void Manageorder_Test() {
		findorder = new OMS_Findorderpage(driver);
		findorder.manageordermenu();
	}

	@Test(priority = 3)
	public void Createorder_Test() {
		createorder = new OMS_CreateordersPage(driver);
		findorder = new OMS_Findorderpage(driver);
		createorder.customer_details();
		createorder.order_shipping_details();
		createorder.line_items();
		createorder.payment_details();
		createorder.order_summery();
		createorder.order_status();
		createorder.search_order();
		findorder.manageordermenu();
		createorder.existing_customer();

	}

	@Test(priority = 4)
	public void OMSFindOrdersDisplayTest() {
		findorder = new OMS_Findorderpage(driver);
		findorder.manageOrdersTabDisplay();
		findorder.findOrdersTabDisplay();
		findorder.filtersDisplay();
	}

	@Test(priority = 5)
	public void CustomerReferenceTest() {

		findorder.CustomerReferenceField();
		findorder.search();
		findorder.clear_name();
		findorder.search_button();

	}

	@Test(priority = 6)
	public void OrderTypeTest() {
		findorder.OrderTypeDropdown();
		findorder.search();
		findorder.clear_type();
		findorder.search_button();
	}

	@Test(priority = 7)
	public void OrderStatusTest() {
		findorder.OrderStatusDropdown();
		findorder.search();
	}

	@Test(priority = 8)
	public void OrderGroupsTest() {
		findorder.OrderGroupsDropdown();
		findorder.search_button();
		findorder.clear_group();
		findorder.search_button();
	}

	@Test(priority = 9)
	public void OrderlabelTest() {
		findorder.OrderLabelsDropdown();
		findorder.search_button();
		findorder.clear_label();
		findorder.search_button();
	}

	@Test(priority = 10)
	public void SalesChannelTest() {
		findorder.SalesChannelDropdown();
		findorder.search();
		findorder.clear_sales();
		findorder.search_button();
	}

	@Test(priority = 11)
	public void DeliveryChannelTest() {
		findorder.DeliveryChannelDropdown();
		findorder.search();
		findorder.clear_delivery();
		findorder.search_button();
	}

	@Test(priority = 12)
	public void DispatchDateTest() {
		findorder.DispacthDatePicker();
		findorder.search();
		findorder.clear_dispatchdate();
		findorder.search_button();
	}

	@Test(priority = 13)
	public void DeliveryDateTest() {
		findorder.DeliveryDatePicker();
		findorder.search();
		findorder.clear_deliverydate();
		findorder.search_button();
	}

	@Test(priority = 14)
	public void OrderEntityAssigneeNamesTest() {
		findorder.OrderEntityAssigneeNamesDropdown();
		findorder.search();
		findorder.clear_assignee();
		findorder.search_button();
	}

	@Test(priority = 15)
	public void OrderPaymentStatusTest() {
		findorder.OrderPaymentStatusDropdown();
		findorder.search();
		findorder.clear_payment();
		findorder.search_button();
	}

	@Test(priority = 16)
	public void OrderTagTest() {
		findorder.OrderTagField();
		findorder.search();
		findorder.clear_tag();
		findorder.search_button();
	}

	@Test(priority = 17)
	public void OrderFulfillmentCenterTest() {
		findorder.OrderFulfillmentCenterDropdown();
		findorder.search();
		findorder.clear_fullfilment();
		findorder.search_button();
	}

	@Test(priority = 18)
	public void OrderDisplayNameTest() {
		findorder.CustomerReferenceField();
		findorder.search();
	}

	@Test(priority = 19)
	public void ExcelTest() {
		findorder.excel();
	}

	@Test(priority = 20)
	public void OrderEditTest() {
		findorder.orderEditAction();
	}

	@Test(priority = 21)
	public void OrderCancelAndRejectTest() {

		findorder.orderCancelAction();
		findorder.orderRejectAction();
	}

	@Test(priority = 22)
	public void NavigateToSalesOrdersTest() {
		findorder.navigatetoSalesOrdersPage();
	}

	@Test(priority = 23)
	public void OMSSalesOrdersTest() {
		salesOrdersPage = new OMS_SalesOrdersPage(driver);
		salesOrdersPage.salesOrdersTabDisplay();
		salesOrdersPage.filterDisplay();
		salesOrdersPage.findOrders();
		findorder.logout();
	}

}
