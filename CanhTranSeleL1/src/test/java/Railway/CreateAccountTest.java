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
import PageObjects.Railway.RegisterPage;

public class CreateAccountTest {

	HomePage homePage = new HomePage();
	RegisterPage registerPage=new RegisterPage();

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

	@Test(description = "User can create new account")
	public void TC07() {
		homePage.open();
		homePage.gotoPage(TabName.REGISTER);
		registerPage.registerAccount(Constant.RANDOM_EMAIL, Constant.VALID_PASSWORD, Constant.VALID_PASSWORD,
				Constant.VALID_PID);
		assertEquals(registerPage.getRegisterSuccessMessage(), Constant.Message.REGISTER_SUCCESS_MESSAGE);
	}

	@Test (description = "User can't create account with \"Confirm password\" is not the same with \"Password\"")
	public void TC10() {
		homePage.open();
		homePage.gotoPage(TabName.REGISTER);
		registerPage.registerAccount(Constant.RANDOM_EMAIL, Constant.VALID_PASSWORD, Constant.INVALID_PASSWORD, Constant.VALID_PID);
		assertEquals(registerPage.getRegisterErrorMessage(), Constant.Message.REGISTER_ERROR_MESSAGE);
	}
	
	@Test (description = "User can't create account while password and PID fields are empty")
	public void TC11() {
		homePage.open();
		homePage.gotoPage(TabName.REGISTER);
		registerPage.registerAccount(Constant.RANDOM_EMAIL, Constant.EMPTY, Constant.EMPTY, Constant.EMPTY);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(registerPage.getRegisterErrorMessage(), Constant.Message.REGISTER_ERROR_MESSAGE);
		softAssert.assertEquals(registerPage.getInvalidPasswordError(),Constant.Message.INVALID_PASSWORD_MESSAGE);
		softAssert.assertEquals(registerPage.getIDError(),Constant.Message.INVALID_ID_MESSAGE);
		softAssert.assertAll();
	}
	
	
}
