package Railway;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Common.Common.Utilities;
import Common.Constant.Constant;
import Common.Constant.Constant.ARRIVE_STATION;
import Common.Constant.Constant.DEPART_STATION;
import Common.Constant.Constant.SEAT_TYPE;
import Common.Constant.Constant.TabName;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;

public class BookTicketsTest {

	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	BookTicketPage bookTicketPage = new BookTicketPage();

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

	@Test(description = "User can log into Railway with valid username and password")
	public void TC01() {
		homePage.open();
		homePage.gotoPage(TabName.LOGIN);
		loginPage.login(Constant.VALID_USERNAME, Constant.VALID_PASSWORD);
		homePage.gotoPage(TabName.BOOK_TICKET);
		bookTicketPage.BookTickets("12/13/2018", DEPART_STATION.DA_NANG.getValue(), ARRIVE_STATION.NHA_TRANG.getValue(),
				SEAT_TYPE.HARD_BED.getValue(), "4");
		// Move Date to Constant
		// Move Amount to Constant
		// Delete Ticket after booking
		// LogOut
		
		
	}
}
