package Railway;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Utilities;
import Constant.Constant;

public class LoginTest {

	HomePage homePage = new HomePage();
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Pre-conditions");
		Utilities.openChromeBrowser();
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Post-condition");
		Utilities.closesAllChromeBrowserWindows();
	}

	@Test(description = "User can log into Railway with valid username and password")
	public void TC01() {

		homePage.open();
		
		LoginPage loginPage = homePage.gotoLoginPage();
		

		loginPage.login(Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Utilities.checkTextDisplays(loginPage.getWelcomeMessage(), Constant.WELLCOME_MESSAGE);
	}

	@Test(description = "User can't login with blank \"Username\" textbox")
	public void TC02() {

		homePage.open();

		LoginPage loginPage = homePage.gotoLoginPage();

		loginPage.login(Constant.BLANK_USERNAME, Constant.VALID_PASSWORD);

		Utilities.checkTextDisplays(loginPage.getErrorLoginMessage(), Constant.ERROR_LOGIN_MESSAGE_BLANK_USERNAME);
	}

	@Test(description = "User cannot log into Railway with invalid password ")
	public void TC03() {

		homePage.open();

		LoginPage loginPage = homePage.gotoLoginPage();

		loginPage.login(Constant.VALID_USERNAME, Constant.INVALID_PASSWORD);

		Utilities.checkTextDisplays(loginPage.getErrorLoginMessage(), Constant.ERROR_LOGIN_MESSAGE_INVALID_PASSWORD);
	}

	@Test(description = "Login page displays when un-logged User clicks on \"Book ticket\" tab")
	public void TC04() {

		LoginPage loginPage = new LoginPage();
		homePage.open();

		homePage.gotoRegisterPage();
		Utilities.checkPageHeader(homePage.getPageHeader(), loginPage.getLoginPageHeader());
	}

	@Test(description = "System shows message when user enters wrong password several times")
	public void TC05() {

		homePage.open();

		LoginPage loginPage = homePage.gotoLoginPage();

		loginPage.loginFailServeralTimes(Constant.VALID_USERNAME, Constant.INVALID_PASSWORD,
				Constant.SERVERAL_TIME_LOGIN_FAIL);

		Utilities.checkTextDisplays(loginPage.getErrorLoginMessage(), Constant.ERROR_LOGIN_MESSAGE_FOR_SERVERAL_TIMES);
	}

	@Test(description = "Additional pages display once user logged in")

	public void TC06() {

		MyTicketPage myTicketPage = new MyTicketPage();
		ChangePasswordPage changePasswordPage = new ChangePasswordPage();

		homePage.open();

		LoginPage loginPage = homePage.gotoLoginPage();

		loginPage.login(Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		homePage.isTabdisplay("My ticket");
		homePage.isTabdisplay("Change password");
		homePage.isTabdisplay("Logout");

		homePage.gotoMyTicKetPage();
		Utilities.checkPageHeader(homePage.getPageHeader(), myTicketPage.getMyTicketPageHeader());

		homePage.gotoChangePasswordPage();
		Utilities.checkPageHeader(homePage.getPageHeader(), changePasswordPage.getChangePasswordPageHeader());

	}

}
