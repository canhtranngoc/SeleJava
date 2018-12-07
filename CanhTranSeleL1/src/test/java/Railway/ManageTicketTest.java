package Railway;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Common.Common.Utilities;
import Common.Constant.Constant;
import Common.Constant.Constant.TabName;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.MyTicketPage;

public class ManageTicketTest {
	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	BookTicketPage bookTicketPage = new BookTicketPage();
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
	 
	 @Test(description = "User can filter Manage ticket table with Depart Date")
		public void FTTC01() {
			homePage.open();
			homePage.gotoPage(TabName.LOGIN);
			loginPage.login(Constant.VALID_USERNAME, Constant.VALID_PASSWORD);
			homePage.gotoPage(TabName.BOOK_TICKET);
			bookTicketPage.BookTickets(8);
			homePage.gotoPage(TabName.MY_TICKET);
			myTicketPage.filterTictketWithDepartDate("12/10/2018");
			myTicketPage.checkTicketWithDepartDate("12/10/2018");
		}
	 
	 
}
