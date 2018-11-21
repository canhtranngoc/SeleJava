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

public class CreateAccountTest {
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Pre-conditions");
		System.setProperty("webdriver.chrome.driver", "Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Post-condition");
		Constant.WEBDRIVER.quit();
	}
	
	@Test(description = "User can create new account")
	public void TC07() {
		
		HomePage homePage = new HomePage();
		homePage.open();
		
		RegisterPage registerPage = homePage.gotoRegisterPage();
		registerPage.registerAccount(Constant.RANDOM_EMAIL, Constant.VALID_PASSWORD, Constant.VALID_PASSWORD, Constant.VALID_PASSWORD);
		
		

					
	}
	
}
