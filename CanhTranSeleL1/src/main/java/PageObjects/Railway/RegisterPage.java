package PageObjects.Railway;
import org.openqa.selenium.By;
import Common.Common.ElementKeywords;

public class RegisterPage extends GeneralPage {

	// Locators
	private final By txtEmail = By.name("email");
	private final By txtPassword = By.name("password");
	private final By txtConfirmPassword = By.name("confirmPassword");
	private final By txtpid = By.name("pid");
	private final By buttonRegister = By.xpath("//input[@value='Register']");
	private final By lblSuccessRegisterMessage = By.xpath("//div[@id='content']/h1");
	private final By lblErrorMessage = By.xpath("//p[@class='message error']");
	private final By lblInvalidpassword = By.xpath("//label[.='Invalid password length']");
	private final By lblInvalidID = By.xpath("//label[.='Invalid ID length']");

	// Methods
	public void registerAccount(String email, String password, String confirmPassword, String pid) {
		ElementKeywords.enter(txtEmail, email);
		ElementKeywords.enter(txtPassword, password);
		ElementKeywords.enter(txtConfirmPassword, confirmPassword);
		ElementKeywords.enter(txtpid, pid);
		ElementKeywords.click(buttonRegister);
	}

	public String getRegisterSuccessMessage() {
		return ElementKeywords.getText(lblErrorMessage);
	}
	
	public String getRegisterErrorMessage() {
		return ElementKeywords.getText(lblSuccessRegisterMessage);
	}
	
	public String getInvalidPasswordError() {
		return ElementKeywords.getText(lblInvalidpassword);
	}
	
	public String getIDError() {
		return ElementKeywords.getText(lblInvalidID);
	}
	
}
