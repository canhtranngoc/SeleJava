package PageObjects.Mailinator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Common.Common.ElementHelper;
import Common.Common.ElementKeywords;
import Common.Constant.Constant;
import PageObjects.Railway.GeneralPage;

public class InboxPage extends GeneralPage {

	// Locators
	public final By txtemail = By.xpath("//input[@id='inbox_field']");
	public final By buttonGo = By.xpath("//button[.='Go!']");
	// private final By iframeMessageBody = By.id("msg_body");

	public void openMailinator(String email) {
		Constant.WEBDRIVER.navigate().to(Constant.MAILINATOR_URL);
		ElementKeywords.enter(txtemail, email);
		ElementKeywords.click(buttonGo);
	}

	public void openResetPasswordLink() {
		// (//td[contains(.,'Please reset your password')])[1]
		
		
		final By email = By.xpath(
				"(//tbody//tr[contains(normalize-space(),'logigearapps') and contains(normalize-space(),'Please reset your password')])[1]");
		ElementHelper.waitElementVisible(email, 10);
		ElementKeywords.click(email);
		Constant.WEBDRIVER.switchTo().frame("msg_body");
		ElementKeywords.click(By.partialLinkText("Account/PasswordReset"));
	}



}
