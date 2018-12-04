package Railway;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Common.Common.Utilities;
import Common.Constant.Constant;
import Common.Constant.Constant.ARRIVE_STATION;
import Common.Constant.Constant.DEPART_STATION;
import Common.Constant.Constant.SEAT_TYPE;
import Common.Constant.Constant.TabName;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.MyTicketPage;
import PageObjects.Railway.TimeTablePage;

public class CancelTicketTest {
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

	// @AfterMethod
	// public void afterMethod() {
	// System.out.println("Post-condition");
	// Utilities.closesAllChromeBrowserWindows();
	// }

	@Test(description = "User can cancel a ticket")
	public void TC16() {
		homePage.open();
		homePage.gotoPage(TabName.LOGIN);
		loginPage.login(Constant.VALID_USERNAME, Constant.VALID_PASSWORD);
		homePage.gotoPage(TabName.BOOK_TICKET);
		bookTicketPage.BookTickets("12/13/2018", DEPART_STATION.DA_NANG.getValue(), ARRIVE_STATION.NHA_TRANG.getValue(),
				SEAT_TYPE.HARD_BED.getValue(), "1");
		bookTicketPage.gotoPage(TabName.MY_TICKET);
		myTicketPage.CancelaTicKet(DEPART_STATION.DA_NANG.getValue(), ARRIVE_STATION.NHA_TRANG.getValue(), "12/13/2018");


	}
}
