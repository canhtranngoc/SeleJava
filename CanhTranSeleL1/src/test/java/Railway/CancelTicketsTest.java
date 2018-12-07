package Railway;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Common.Common.ElementHelper;
import Common.Common.Utilities;
import Common.Constant.Constant;
import Common.Constant.Constant.TabName;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.MyTicketPage;
import PageObjects.Railway.TimeTablePage;

public class CancelTicketsTest {
	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	BookTicketPage bookTicketPage = new BookTicketPage();
	TimeTablePage timeTablePage = new TimeTablePage();
	MyTicketPage myTicketPage = new MyTicketPage();

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Pre-conditions");
		Utilities.openBrowser();
	}

	 @AfterMethod
	 public void afterMethod() {
	 System.out.println("Post-condition");
	 Utilities.closesAllBrowsers();
	 }

	@Test(description = "User can cancel a ticket")
	public void TC16() {
		homePage.open();
		homePage.gotoPage(TabName.LOGIN);
		loginPage.login(Constant.VALID_USERNAME, Constant.VALID_PASSWORD);
		homePage.gotoPage(TabName.BOOK_TICKET);
		bookTicketPage.BookTickets("12/13/2018", "Đà Nẵng", "Nha Trang","Hard bed", "1");
		bookTicketPage.gotoPage(TabName.MY_TICKET);
		myTicketPage.CancelaTicKet("Đà Nẵng", "Nha Trang", "12/13/2018");
		ElementHelper.isElementDisplayed(myTicketPage.getCancelButton("Đà Nẵng", "Nha Trang", "12/13/2018"));
	}
}
