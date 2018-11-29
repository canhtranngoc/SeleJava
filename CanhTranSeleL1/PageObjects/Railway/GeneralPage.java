package Railway;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Common.ElementKeywords;
import Common.ElementHelper;

import Constant.Constant;
import Constant.Constant.TAB_NAME;

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

	// Methods

	public String getWelcomeMessage() {
		return ElementKeywords.getText(welcomeMessage);
	}

	public String getPageHeader() {
		return ElementKeywords.getText(pageHeader);
	}

	public void gotoLoginPage() {
		ElementKeywords.click(tabLogin);
	}

	public void gotoRegisterPage() {
		ElementKeywords.click(tabRegister);
	}

	public void gotoMyTicKetPage() {
		ElementKeywords.click(tabMyTicket);
	}

	public void gotoChangePasswordPage() {
		ElementKeywords.click(tabChangePassword);
	}

	public void gotoBookTicketPage() {
		ElementKeywords.click(tabBookTicket);
	}

	public boolean isTabDisplayed(String tabName) {
		try {
			String str = String.format("//span[.='%s']", tabName);
			return Constant.WEBDRIVER.findElement(By.xpath(str)).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void gotoPage(TAB_NAME tabName) {
		String str = String.format("//span[.='%s']", tabName.getValue());
		Constant.WEBDRIVER.findElement(By.xpath(str)).click();

	}

	public void logOut() {
		// If tab logout displays, then
		{
			// this.tabLogout().click();
		}
	}

}
