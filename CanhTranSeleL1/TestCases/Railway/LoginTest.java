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


public class LoginTest{
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Pre-conditions");
		System.setProperty("webdriver.chrome.driver", "D:\\CanhBongMieu_CamXoa\\SeleJavaL1\\SeleJava\\CanhTranSeleL1\\Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Post-condition");
		Constant.WEBDRIVER.quit();
	}
	
	@Test(description = "User can log into Railway with valid username and password")
	public void TC01() {
		
		HomePage homePage = new HomePage();
		homePage.open();
		
		LoginPage loginPage = homePage.gotoLoginPage();
	
		loginPage.login(Constant.VALID_USERNAME, Constant.VALID_PASSWORD);
		
		Utilities.checkTextDisplays(loginPage.getWelcomeMessage(), Constant.welcomeMessage);
					
	}
	
	@Test(description= "User can't login with blank \"Username\" textbox")
	public void TC02() {
		HomePage homePage = new HomePage();
		homePage.open();
		
		LoginPage loginPage = homePage.gotoLoginPage();
		
		loginPage.login(Constant.BLANK_USERNAME, Constant.VALID_PASSWORD);
		
		Utilities.checkTextDisplays(loginPage.getErrorLoginMessage(), Constant.errorLoginMessageBlankUsername);
		
	}
	
	
	@Test(description= "User cannot log into Railway with invalid password ")
	public void TC03() {
		HomePage homePage = new HomePage();
		homePage.open();
		
		LoginPage loginPage = homePage.gotoLoginPage();
		
		loginPage.login(Constant.VALID_USERNAME, Constant.INVALID_PASSWORD);
		
		Utilities.checkTextDisplays(loginPage.getErrorLoginMessage(), Constant.errorLoginMessageInvalidPassword);
		
	}
		
	@Test(description= "Login page displays when un-logged User clicks on \"Book ticket\" tab")
	public void TC04() {
		
	}
	
	
	@Test(description= "System shows message when user enters wrong password several times")
	public void TC05() {
		HomePage homePage = new HomePage();
		homePage.open();
		
		LoginPage loginPage = homePage.gotoLoginPage();
		
		loginPage.loginFailServeralTimes(Constant.VALID_USERNAME, Constant.INVALID_PASSWORD, Constant.serveralTimeLoginFail);
		
		Utilities.checkTextDisplays(loginPage.getErrorLoginMessage(), Constant.errorLoginMessageForServeralTimes);
	}
	
	
	
	
	
	
	
}
