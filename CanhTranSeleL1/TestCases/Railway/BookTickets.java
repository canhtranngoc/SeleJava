package Railway;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Constant.Constant.TAB_NAME;
import Common.Utilities;
import Constant.Constant;
import Constant.Constant.ARRIVE_STATION;
import Constant.Constant.DEPART_STATION;
import Constant.Constant.SEAT_TYPE;

public class BookTickets {

	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	BookTicketPage bookTicketPage = new BookTicketPage();

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Pre-conditions");
		Utilities.openChromeBrowser();
	}

	// @AfterMethod
	// public void afterMethod() {
	// System.out.println("Post-condition");
	// Utilities.closesAllChromeBrowserWindows();
	// }

	@Test(description = "User can log into Railway with valid username and password")
	public void TC01() {
		homePage.open();
		homePage.gotoPage(TAB_NAME.LOGIN);
		loginPage.login(Constant.VALID_USERNAME, Constant.VALID_PASSWORD);
		homePage.gotoPage(TAB_NAME.BOOK_TICKET);
		bookTicketPage.BookTickets("12/13/2018", DEPART_STATION.DA_NANG.getValue(), ARRIVE_STATION.NHA_TRANG.getValue(),
				SEAT_TYPE.HARD_BED.getValue(), "4");
		// Move Date to Constant
		// Move Amount to Constant
		// Delete Ticket after booking
		// LogOut
		
		
	}
}
