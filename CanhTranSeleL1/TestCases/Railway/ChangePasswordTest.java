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
import Constant.Constant.TAB_NAME;

public class ChangePasswordTest {
	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	ChangePasswordPage changePasswordPage = new ChangePasswordPage();

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

	@Test(description = "User can change password")
	public void TC09() {

		homePage.open();
		homePage.gotoPage(TAB_NAME.LOGIN);
		loginPage.login(Constant.VALID_USERNAME, Constant.VALID_PASSWORD);
		
		homePage.gotoPage(TAB_NAME.CHANGE_PASSWORD);
		changePasswordPage.changePassword(Constant.VALID_PASSWORD, Constant.NEW_PASSWORD, Constant.NEW_PASSWORD);
		Assert.assertEquals(changePasswordPage.getSuccessMessage(), Constant.Message.CHANGE_PASSWORD_SUCCESS_MESSAGE);
	}
}
