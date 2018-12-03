package PageObjects.Railway;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import Common.Common.ElementKeywords;
import Common.Constant.Constant;
import Common.Constant.Constant.TabName;

public class GeneralPage {
	// Locators
	//private final By tabLogout = By.xpath("//a[@href='/Account/Logout']");
	private final By welcomeMessage = By.xpath("//div[@class='account']");
	private final By pageHeader = By.xpath("//div[@id='content']/h1");

	// Methods

	public String getWelcomeMessage() {
		return ElementKeywords.getText(welcomeMessage);
	}

	public String getPageHeader() {
		return ElementKeywords.getText(pageHeader);
	}

	public boolean isTabDisplayed(String tabName) {
		try {
			String str = String.format("//span[.='%s']", tabName);
			return Constant.WEBDRIVER.findElement(By.xpath(str)).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void gotoPage(TabName tabName) {
		String str = String.format("//div[@id='menu']//span[.='%s']", tabName.getValue());
		Constant.WEBDRIVER.findElement(By.xpath(str)).click();

	}

	public void logOut() {
		// If tab logout displays, then
		{
			// this.tabLogout().click();
		}
	}

}
