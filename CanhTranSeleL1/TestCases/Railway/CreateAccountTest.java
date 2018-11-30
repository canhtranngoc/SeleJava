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

public class CreateAccountTest {

	HomePage homePage = new HomePage();
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

	@Test(description = "User can create new account")
	public void TC07() {

		homePage.open();
		homePage.gotoPage(TAB_NAME.REGISTER);
		registerPage.registerAccount(Constant.RANDOM_EMAIL, Constant.VALID_PASSWORD, Constant.VALID_PASSWORD,
				Constant.VALID_PID);
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), Constant.Message.REGISTER_SUCCESS_MESSAGE);
	}

	@Test (description = "User can't create account with \"Confirm password\" is not the same with \"Password\"")
	public void TC10() {
		homePage.open();
		homePage.gotoPage(TAB_NAME.REGISTER);
		registerPage.registerAccount(Constant.RANDOM_EMAIL, Constant.VALID_PASSWORD, Constant.INVALID_PASSWORD, Constant.VALID_PID);
		Assert.assertEquals(registerPage.getRegisterErrorMessage(), Constant.Message.REGISTER_ERROR_MESSAGE);
	}
	
	@Test (description = "User can't create account while password and PID fields are empty")
	public void TC11() {
		homePage.open();
		homePage.gotoPage(TAB_NAME.REGISTER);
		registerPage.registerAccount(Constant.RANDOM_EMAIL, "", "", "");
		Assert.assertEquals(registerPage.getRegisterErrorMessage(), Constant.Message.REGISTER_ERROR_MESSAGE);
		Assert.assertEquals(registerPage.getInvalidPasswordError(),Constant.Message.INVALID_PASSWORD_MESSAGE);
		Assert.assertEquals(registerPage.getIDError(),Constant.Message.INVALID_ID_MESSAGE);
	}
	
	
}
