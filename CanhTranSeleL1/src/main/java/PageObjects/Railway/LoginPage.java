package PageObjects.Railway;
import org.openqa.selenium.By;
import Common.Common.ElementKeywords;

public class LoginPage extends GeneralPage {

	// Locators
	private final By txtUsername = By.id("username");
	private final By txtPassword = By.id("password");
	private final By btnLogin = By.xpath("//input[@value='login']");
	private final By lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");
	private final By linkForgotPassword = By.xpath("//a[.='Forgot Password page']");

	// Methods

	public void login(String username, String password) {
		ElementKeywords.enter(txtUsername, username);
		ElementKeywords.enter(txtPassword, password);
		ElementKeywords.click(btnLogin);
	}

	public void login(String username, String password, int time) {
		for (int i = 0; i < time; i++) {
			this.login(username, password);
		}
	}
		
	public String getErrorLoginMessage() {
		return ElementKeywords.getText(lblLoginErrorMsg);
	}

	public void gotoForgotPasswordPage() {
		ElementKeywords.click(linkForgotPassword);
	}

}
