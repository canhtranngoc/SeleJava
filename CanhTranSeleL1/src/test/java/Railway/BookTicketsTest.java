package Railway;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Common.Common.Utilities;
import Common.Constant.Constant;
import Common.Constant.Constant.TabName;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.TimeTablePage;

public class BookTicketsTest {

	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	BookTicketPage bookTicketPage = new BookTicketPage();
	TimeTablePage timeTablePage = new TimeTablePage();

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

	@Test(description = "User can book 1 ticket at a time")
	public void TC14() {
		homePage.open();
		homePage.gotoPage(TabName.LOGIN);
		loginPage.login(Constant.VALID_USERNAME, Constant.VALID_PASSWORD);
		homePage.gotoPage(TabName.BOOK_TICKET);
		bookTicketPage.BookTickets("12/13/2018", "Đà Nẵng", "Nha Trang", "abc", "1");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(bookTicketPage.getSuccessMessage(), Constant.Message.BOOK_TICKETS_SUCCESS_MESSAGE);
		bookTicketPage.checkBookTicketValue("Đà Nẵng", "Nha Trang", "abc", "1");
		softAssert.assertAll();
	}

	@Test(description = "User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page")
	public void TC15() {
		homePage.open();
		homePage.gotoPage(TabName.LOGIN);
		loginPage.login(Constant.VALID_USERNAME, Constant.VALID_PASSWORD);
		homePage.gotoPage(TabName.TIMETABLE);
		timeTablePage.SelectTicketFromTimetable("Đà Nẵng", "Quảng Ngãi");
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(bookTicketPage.getDepartStationValue(), "Đà Nẵng");
		softAssert.assertEquals(bookTicketPage.getArriveStationValue(), "Quảng Ngãi");
		softAssert.assertAll();
	}
}
