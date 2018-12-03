package PageObjects.Railway;

import org.openqa.selenium.By;

import Common.Common.ElementKeywords;

public class ResetPasswordPage extends GeneralPage {
	// Locators
	private final By txtNewPassword = By.id("newPassword");
	private final By txtConfirmPassword = By.id("confirmPassword");
	private final By txtResetToken = By.id("resetToken");
	private final By buttonResetPassword = By.xpath("//input[@value='Reset Password']");
	
	// Methods
	public void resetPassword(String newPassword, String confirmPassword, String token) {
		ElementKeywords.enter(txtNewPassword, newPassword);
		ElementKeywords.enter(txtConfirmPassword, confirmPassword);
		ElementKeywords.enter(txtResetToken, token);
		ElementKeywords.click(buttonResetPassword);
	}
	
	public void resetPassword(String newPassword, String confirmPassword) {
		ElementKeywords.enter(txtNewPassword, newPassword);
		ElementKeywords.enter(txtConfirmPassword, confirmPassword);
		ElementKeywords.click(buttonResetPassword);
	}
	
}
