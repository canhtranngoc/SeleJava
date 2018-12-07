package Railway;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Common.Utilities;
import Common.Constant.Constant.TabName;
import PageObjects.Mailinator.InboxPage;
import PageObjects.Railway.ForgotPasswordPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;

public class ResetPasswordTest {
	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
	PageObjects.Mailinator.InboxPage inboxPage = new InboxPage();
	
	
	
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
	
	@Test(description = "Errors display when password reset token is blank")
	public void TC12() {
		homePage.open();
		homePage.gotoPage(TabName.LOGIN);
		loginPage.gotoForgotPasswordPage();
		forgotPasswordPage.sendInstruction("canh.tran+123456@mailinator.com");
		inboxPage.openMailinator("canh.tran+123456@mailinator.com");
		inboxPage.openResetPasswordLink();
		
	}

}
