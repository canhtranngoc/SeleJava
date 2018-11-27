
// Một số phần cần làm:

// Lay milisecond đưa vào random email

// Nghien cuu cach dung Sort Asert

// Trong Page thi nen viet isElementDisplay, khong nen viet CheckElementDisplays NEN VIET HAM NAY DE DUNG

// Trong page thi nen tra ve TRUE or F, khong nen dung Asert trong Page

// Dung Enum va viet Ham goToPage() Enum giong voi Dataset trong TA, xo ra dropdown de nguoi dung chon



// Trong TC khong nen co .getText(), may cai nay nen dua vao ham getAbcXyz trong Page

// Nhom cac group trong Constant (Viet Public Class Message ()...., Sau nay dung thi goi như sau:  constant.message.ABC_MESSAGE

// Dua BeforeMothod, BeforCalsss vào BASE TEST, Page nao cung Extent BASE TEST, lam nhu vay de TC duoc gon va dep hon



// Check page titel thi lay page header, exxpected: constant.LoginPage Header






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

public class zForTest {
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

	

	@Test(description = "Additional pages display once user logged in")

	public void TC06() {
		HomePage homePage = new HomePage();
		homePage.open();

		
		LoginPage loginPage = homePage.gotoLoginPage();

		loginPage.login(Constant.PAGE_NAME.HOME, Constant.VALID_PASSWORD);
		
		
		homePage.isTabDisplayed("Homes");
		
		
		

	}

}
