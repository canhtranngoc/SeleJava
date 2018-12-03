
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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Common.Constant.Constant;
import Common.Constant.Constant.TabName;
import PageObjects.Railway.HomePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;

public class zForTest {

	HomePage homePage = new HomePage();
	LoginPage loginPage = new LoginPage();
	RegisterPage registerPage = new RegisterPage();

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Pre-conditions");
		System.setProperty("webdriver.chrome.driver", "Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();
	}

	// @AfterMethod
	// public void afterMethod() {
	// System.out.println("Post-condition");
	// Constant.WEBDRIVER.quit();
	// }

	@Test(description = "User can log into Railway with valid username and password")
	public void TC01() {
		homePage.open();
		homePage.gotoPage(TabName.LOGIN);
		loginPage.login(Constant.VALID_USERNAME, Constant.VALID_PASSWORD);

		// Constant.WEBDRIVER.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL
		// +"t");

		// Constant.WEBDRIVER.get("http://www.google.co.uk/");

		//((JavascriptExecutor) Constant.WEBDRIVER).executeScript("window.open()");
		//ArrayList<String> tabs = new ArrayList<String>(Constant.WEBDRIVER.getWindowHandles());
		//Constant.WEBDRIVER.switchTo().window(tabs.get(1)); // switches to new tab
		Constant.WEBDRIVER.get("https://www.mailinator.com/v3/index.jsp?zone=public&query=canh+tran#/#inboxpane");
		
		
		//final By txtMailBox = By.id("InboxCtrl");
		//final By btnGo = By.xpath("//button[.='Go!']");
		
		Common.Common.ElementKeywords.enter(By.xpath("//input[@id='inbox_field']"), "canh+1987");
		Common.Common.ElementKeywords.click(By.xpath("//button[.='Go!']"));
		
		Constant.WEBDRIVER.findElement(By.xpath("//td[contains(.,'Canh Tran Ngoc')]")).click();
		WebElement iframe = Constant.WEBDRIVER.findElement(By.tagName("iframe"));
		Constant.WEBDRIVER.switchTo().frame(iframe);
		
		Constant.WEBDRIVER.findElement(By.partialLinkText("Account/Confirm")).click();

		//Constant.WEBDRIVER.switchTo().window(tabs.get(0)); // switch back to main screen

		// String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
		// Constant.WEBDRIVER.findElement(By.linkText("www.facebook.com")).sendKeys(selectLinkOpeninNewTab);

		// WebElement iframe = driver.findElement(By.tagName("iframe"));
		// driver.switchTo().frame(iframe);
		// driver.findElement(By.partialLinkText("account/activate?userguid")).click();

	}

}
