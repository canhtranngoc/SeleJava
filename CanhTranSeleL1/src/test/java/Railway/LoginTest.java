package Railway;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Common.Common.Utilities;
import Common.Constant.Constant;
import Common.Constant.Constant.TabName;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;

public class LoginTest {
	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	RegisterPage registerPage = new RegisterPage();

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

	@Test(description = "User can log into Railway with valid username and password")
	public void TC01() {
		homePage.open();
		homePage.gotoPage(TabName.LOGIN);
		loginPage.login(Constant.VALID_USERNAME, Constant.VALID_PASSWORD);
		assertEquals(loginPage.getWelcomeMessage(), Constant.Message.WELLCOME_MESSAGE);
	}

	@Test(description = "User can't login with blank \"Username\" textbox")
	public void TC02() {
		homePage.open();
		homePage.gotoPage(TabName.LOGIN);
		loginPage.login(Constant.EMPTY, Constant.VALID_PASSWORD);
		assertEquals(loginPage.getErrorLoginMessage(), Constant.Message.LOGIN_BLANK_USERNAME_ERROR_MESSAGE);
	}

	@Test(description = "User cannot log into Railway with invalid password ")
	public void TC03() {
		homePage.open();
		homePage.gotoPage(TabName.LOGIN);
		loginPage.login(Constant.VALID_USERNAME, Constant.INVALID_PASSWORD);
		assertEquals(loginPage.getErrorLoginMessage(), Constant.Message.LOGIN_INVALID_PASSWORD_ERROR_MESSAGE);
	}

	@Test(description = "Login page displays when un-logged User clicks on \"Book ticket\" tab")
	public void TC04() {
		homePage.open();
		homePage.gotoPage(TabName.BOOK_TICKET);
		assertEquals(homePage.getPageHeader(), Constant.PageHeader.LOGIN_PAGE);
	}

	@Test(description = "System shows message when user enters wrong password several times")
	public void TC05() {
		homePage.open();
		homePage.gotoPage(TabName.LOGIN);
		loginPage.login(Constant.VALID_USERNAME, Constant.INVALID_PASSWORD, Constant.SERVERAL_TIME_LOGIN_FAIL);
		assertEquals(loginPage.getErrorLoginMessage(), Constant.Message.LOGIN_FOR_SERVERAL_TIMES_ERROR_MESSAGE);
	}

	@Test(description = "Additional pages display once user logged in")
	public void TC06() {
		homePage.open();
		homePage.gotoPage(TabName.LOGIN);
		loginPage.login(Constant.VALID_USERNAME, Constant.VALID_PASSWORD);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(homePage.isTabDisplayed(TabName.MY_TICKET.getValue()));
		softAssert.assertTrue(homePage.isTabDisplayed(TabName.CHANGE_PASSWORD.getValue()));
		softAssert.assertTrue(homePage.isTabDisplayed(TabName.LOGOUT.getValue()));
		homePage.gotoPage(TabName.MY_TICKET);
		softAssert.assertEquals(homePage.getPageHeader(), Constant.PageHeader.MY_TICKET_PAGE);
		homePage.gotoPage(TabName.CHANGE_PASSWORD);
		softAssert.assertEquals(homePage.getPageHeader(), Constant.PageHeader.CHANGE_PASSWORD_PAGE);
		softAssert.assertAll();
	}

	@Test(description = "User can't login with an account hasn't been activated")
	public void TC08() {
		homePage.open();
		homePage.gotoPage(TabName.REGISTER);
		registerPage.registerAccount(Constant.RANDOM_EMAIL, Constant.VALID_PASSWORD, Constant.VALID_PASSWORD,
				Constant.VALID_PID);
		homePage.gotoPage(TabName.LOGIN);
		loginPage.login(Constant.RANDOM_EMAIL, Constant.VALID_PASSWORD);
		assertEquals(loginPage.getErrorLoginMessage(), Constant.Message.INACTIVE_ACCOUNT_LOGIN_ERROR_MESSAGE);

	}

}
