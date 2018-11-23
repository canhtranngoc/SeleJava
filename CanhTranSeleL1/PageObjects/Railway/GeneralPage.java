package Railway;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class GeneralPage {
	// Locators
	private final By tabLogin = By.xpath("//a[@href='/Account/Login.cshtml']");
	private final By tabRegister = By.xpath("//div[@id='menu']//span[.='Register']");
	private final By tabChangePassword = By.xpath("//div[@id='menu']//span[.='Change password']");
	private final By tabMyTicket = By.xpath("//div[@id='menu']//span[.='My ticket']");

	private final By tabBookTicket = By.xpath("//a[@href='/Page/BookTicketPage.cshtml']");
	private final By tabLogout = By.xpath("//a[@href='/Account/Logout']");

	private final By welcomeMessage = By.xpath("//div[@class='account']");

	private final By pageHeader = By.xpath("//div[@id='content']/h1");

	// Elements
	protected WebElement tabLogin() {
		return Constant.WEBDRIVER.findElement(tabLogin);
	}

	protected WebElement tabRegister() {
		return Constant.WEBDRIVER.findElement(tabRegister);
	}

	protected WebElement tabChangePassword() {
		return Constant.WEBDRIVER.findElement(tabChangePassword);
	}

	protected WebElement tabMyTicket() {
		return Constant.WEBDRIVER.findElement(tabMyTicket);
	}

	protected WebElement tabLogout() {
		return Constant.WEBDRIVER.findElement(tabLogout);
	}

	protected WebElement tabBookTicket() {
		return Constant.WEBDRIVER.findElement(tabBookTicket);
	}

	protected WebElement welcomeMessage() {
		return Constant.WEBDRIVER.findElement(welcomeMessage);
	}

	protected WebElement pageHeader() {
		return Constant.WEBDRIVER.findElement(pageHeader);
	}

	// Methods

	public String getWelcomeMessage() {
		return this.welcomeMessage().getText();
	}

	public String getPageHeader() {
		return this.pageHeader().getText();
	}

	public void gotoLoginPage() {
		this.tabLogin().click();
		
	}

	public RegisterPage gotoRegisterPage() {
		this.tabRegister().click();
		return new RegisterPage();
	}

	public void gotoMyTicKetPage() {
		this.tabMyTicket().click();
	}

	public void gotoChangePasswordPage() {
		this.tabChangePassword().click();
	}

	public boolean isTabdisplay(String tabName) {
		try {

			String str = String.format("//span[.='%s']", tabName);
			Constant.WEBDRIVER.findElement(By.xpath(str));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void logOut() {
		// If tab logout displays, then
		{
			this.tabLogout().click();
		}
	}

}
