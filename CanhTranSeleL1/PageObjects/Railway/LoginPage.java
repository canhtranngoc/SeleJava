package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.ElementKeywords;
import Constant.Constant;

public class LoginPage extends GeneralPage {

	// Locators
	private final By txtUsername = By.id("username");
	private final By txtPassword = By.id("password");
	private final By btnLogin = By.xpath("//input[@value='login']");
	private final By lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");

	// Methods

	public void login(String username, String password) {
		ElementKeywords.enter(txtUsername, username);
		ElementKeywords.enter(txtPassword, password);
		ElementKeywords.click(btnLogin);
	}

	public String getErrorLoginMessage() {
		return ElementKeywords.getText(lblLoginErrorMsg);
	}

	public void loginFailServeralTimes(String username, String password, int time) {
		for (int i = 0; i < time; i++) {
			ElementKeywords.enter(txtUsername, username);
			ElementKeywords.enter(txtPassword, password);
			ElementKeywords.click(btnLogin);
		}
	}

}
