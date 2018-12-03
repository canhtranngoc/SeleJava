package Railway;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Common.Common.Utilities;
import Common.Constant.Constant;
import Common.Constant.Constant.TabName;
import PageObjects.Railway.ChangePasswordPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;

public class ChangePasswordTest {
	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	ChangePasswordPage changePasswordPage = new ChangePasswordPage();

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

	@Test(description = "User can change password")
	public void TC09() {
		homePage.open();
		homePage.gotoPage(TabName.LOGIN);
		loginPage.login(Constant.VALID_USERNAME, Constant.VALID_PASSWORD);		
		homePage.gotoPage(TabName.CHANGE_PASSWORD);
		changePasswordPage.changePassword(Constant.VALID_PASSWORD, Constant.NEW_PASSWORD, Constant.NEW_PASSWORD);
		assertEquals(changePasswordPage.getSuccessMessage(), Constant.Message.CHANGE_PASSWORD_SUCCESS_MESSAGE);
	}
}
