package Railway;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Common.Common.Utilities;
import Common.Constant.Constant;
import Common.Constant.Constant.TabName;
import PageObjects.Railway.ForgotPasswordPage;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;

public class ResetPasswordTest {
	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
	
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
		forgotPasswordPage.sendInstruction("canhtn92+112@gmail.com");
		Utilities.openResetPasswordlink();
		
	}

}
