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

public class LoginTest {

	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	RegisterPage registerPage=new RegisterPage();

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
		homePage.gotoLoginPage();
		//homePage.goToPage(TAB_NAME.LOGIN);
		loginPage.login(Constant.VALID_USERNAME, Constant.VALID_PASSWORD);
		Assert.assertEquals(loginPage.getWelcomeMessage(), Constant.Message.WELLCOME_MESSAGE);
	}

	@Test(description = "User can't login with blank \"Username\" textbox")
	public void TC02() {
		homePage.open();
		homePage.gotoLoginPage();
		//homePage.goToPage(TAB_NAME.LOGIN);
		loginPage.login(Constant.BLANK_USERNAME, Constant.VALID_PASSWORD);
		Assert.assertEquals(loginPage.getErrorLoginMessage(), Constant.Message.LOGIN_BLANK_USERNAME_ERROR_MESSAGE);
			}

	@Test(description = "User cannot log into Railway with invalid password ")
	public void TC03() {
		homePage.open();
		homePage.gotoLoginPage();
		//homePage.goToPage(TAB_NAME.LOGIN);
		loginPage.login(Constant.VALID_USERNAME, Constant.INVALID_PASSWORD);
		Assert.assertEquals(loginPage.getErrorLoginMessage(), Constant.Message.LOGIN_INVALID_PASSWORD_ERROR_MESSAGE);
	}

	@Test(description = "Login page displays when un-logged User clicks on \"Book ticket\" tab")
	public void TC04() {

		homePage.open();
		homePage.gotoBookTicketPage();
		Assert.assertEquals(homePage.getPageHeader(), Constant.PageHeader.LOGIN_PAGE);
	}

	@Test(description = "System shows message when user enters wrong password several times")
	public void TC05() {
		homePage.open();
		homePage.gotoLoginPage();
		//homePage.goToPage(TAB_NAME.LOGIN);
		loginPage.loginFailServeralTimes(Constant.VALID_USERNAME, Constant.INVALID_PASSWORD,
				Constant.SERVERAL_TIME_LOGIN_FAIL);
		Assert.assertEquals(loginPage.getErrorLoginMessage(), Constant.Message.LOGIN_FOR_SERVERAL_TIMES_ERROR_MESSAGE);
	}

	@Test(description = "Additional pages display once user logged in")
	public void TC06() {
		homePage.open();
		homePage.gotoLoginPage();
		//homePage.goToPage(TAB_NAME.LOGIN);
		loginPage.login(Constant.VALID_USERNAME, Constant.VALID_PASSWORD);
		homePage.isTabDisplayed("My ticket");
		homePage.isTabDisplayed("Change password");
		homePage.isTabDisplayed("Logout");
		
		homePage.gotoMyTicKetPage();
		Assert.assertEquals(homePage.getPageHeader(), Constant.PageHeader.MY_TICKET_PAGE);

		homePage.gotoChangePasswordPage();
		Assert.assertEquals(homePage.getPageHeader(), Constant.PageHeader.CHANGE_PASSWORD_PAGE);
	}

	@Test(description = "User can't login with an account hasn't been activated")
	public void TC08() {
		homePage.open();
		homePage.gotoRegisterPage();
		registerPage.registerAccount(Constant.RANDOM_EMAIL, Constant.VALID_PASSWORD, Constant.VALID_PASSWORD, Constant.VALID_PID);
		
		homePage.gotoLoginPage();
		loginPage.login(Constant.RANDOM_EMAIL, Constant.VALID_PASSWORD);
		Assert.assertEquals(loginPage.getErrorLoginMessage(), Constant.Message.INACTIVE_ACCOUNT_LOGIN_ERROR_MESSAGE);
		
	}
	
}
