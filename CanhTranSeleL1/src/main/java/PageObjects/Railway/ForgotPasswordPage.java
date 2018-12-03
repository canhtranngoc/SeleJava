package PageObjects.Railway;

import org.openqa.selenium.By;
import Common.Common.ElementKeywords;

public class ForgotPasswordPage extends GeneralPage {
	// Locators
	private final By txtEmail = By.id("email");
	private final By buttonSendInstructions = By.xpath("//input[@value='Send Instructions']");

	// Methods
	public void sendInstruction(String email) {
		ElementKeywords.enter(txtEmail, email);
		ElementKeywords.click(buttonSendInstructions);
	}
}
