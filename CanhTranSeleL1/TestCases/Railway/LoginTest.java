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
		Utilities.openBrowser();
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Post-condition");
		Utilities.closesAllBrowserWindows();
	}

	@Test(description = "User can log into Railway with valid username and password")
	public void TC01() {

		homePage.open();

		LoginPage loginPage = homePage.gotoLoginPage();

		loginPage.login(Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		Utilities.checkTextDisplays(loginPage.getWelcomeMessage(), Constant.welcomeMessage);
	}

	@Test(description = "User can't login with blank \"Username\" textbox")
	public void TC02() {

		homePage.open();

		LoginPage loginPage = homePage.gotoLoginPage();

		loginPage.login(Constant.BLANK_USERNAME, Constant.VALID_PASSWORD);

		Utilities.checkTextDisplays(loginPage.getErrorLoginMessage(), Constant.errorLoginMessageBlankUsername);
	}

	@Test(description = "User cannot log into Railway with invalid password ")
	public void TC03() {

		homePage.open();

		LoginPage loginPage = homePage.gotoLoginPage();

		loginPage.login(Constant.VALID_USERNAME, Constant.INVALID_PASSWORD);

		Utilities.checkTextDisplays(loginPage.getErrorLoginMessage(), Constant.errorLoginMessageInvalidPassword);
	}

	@Test(description = "Login page displays when un-logged User clicks on \"Book ticket\" tab")
	public void TC04() {

		LoginPage loginPage = new LoginPage();
		homePage.open();

		homePage.gotoRegisterPage();
		Utilities.checkPageHeader(homePage.getPageHeader(), loginPage.loginPageHeader().getText());
	}

	@Test(description = "System shows message when user enters wrong password several times")
	public void TC05() {

		homePage.open();

		LoginPage loginPage = homePage.gotoLoginPage();

		loginPage.loginFailServeralTimes(Constant.VALID_USERNAME, Constant.INVALID_PASSWORD,
				Constant.serveralTimeLoginFail);

		Utilities.checkTextDisplays(loginPage.getErrorLoginMessage(), Constant.errorLoginMessageForServeralTimes);
	}

	@Test(description = "Additional pages display once user logged in")

	public void TC06() {

		MyTicketPage myTicketPage = new MyTicketPage();
		ChangePasswordPage changePasswordPage = new ChangePasswordPage();

		homePage.open();

		LoginPage loginPage = homePage.gotoLoginPage();

		loginPage.login(Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		// "My ticket", "Change password" and "Logout" tabs are displayed.
		// Implementing...

		homePage.gotoMyTicKetPage();
		Utilities.checkPageHeader(homePage.getPageHeader(), myTicketPage.myTicketPageHeader().getText());

		homePage.gotoChangePasswordPage();
		Utilities.checkPageHeader(homePage.getPageHeader(), changePasswordPage.changePasswordPageHeader().getText());

	}

}
