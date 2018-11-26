package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Common.ElementKeywords;

import Common.ElementKeywords;
import Constant.Constant;

public class ChangePasswordPage extends GeneralPage {

	// Locators
	public final By lblChangePasswordPageHeader = By.xpath("//div[@id='content']/h1");
	private final By txtCurrentPassword = By.id("currentPassword");
	private final By txtNewPassword = By.id("newPassword");
	private final By txtConfirmPassword = By.id("confirmPassword");
	private final By buttonChangePassword = By.xpath("//input[@value='Change Password']");
	private final By lblSuccessMessage = By.xpath("//p[@class='message success']");

	// Methods
	public String getSuccessMessage() {
		return ElementKeywords.getText(lblSuccessMessage);
	}

	public void changePassword(String currentPassword, String newPassword, String confirmPassword) {
		ElementKeywords.enter(txtCurrentPassword, currentPassword);
		ElementKeywords.enter(txtNewPassword, newPassword);
		ElementKeywords.enter(txtConfirmPassword, confirmPassword);
		ElementKeywords.click(buttonChangePassword);
	}
}
