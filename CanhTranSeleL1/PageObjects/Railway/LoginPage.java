package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Constant.Constant;

public class LoginPage extends GeneralPage {
	
	//Locators	
	private final By txtUsername = By.xpath("//input[@id='username']");
	private final By txtPassword = By.xpath("//input[@id='password']");
	private final By btnLogin = By.xpath("//input[@value='login']");
	private final By lblLoginErrorMsg = By.xpath("//p[@class='message error LoginForm']");

	//Elements	
	public WebElement username() {
		return Constant.WEBDRIVER.findElement(txtUsername);
	}
	
	public WebElement password() {
		return Constant.WEBDRIVER.findElement(txtPassword);
	}
	
	public WebElement login() {
		return Constant.WEBDRIVER.findElement(btnLogin);
	}
	
	public WebElement errorLoginMessage() {
		return Constant.WEBDRIVER.findElement(lblLoginErrorMsg);
	}
	
	//Methods
	public HomePage login(String username, String password)
	{
		//Submit login credentials
		this.username().sendKeys(username);
		this.password().sendKeys(password);
		this.login().click();

		//Land on homepage
		return new HomePage();
	}
	
	public HomePage logout()
	{
		this.tabLogout().click();
		return new HomePage();
	}

	
	public String getErrorLoginMessage()
	{
		return this.errorLoginMessage().getText();
	}
		
	public void loginFailServeralTimes(String username, String password, int time)
    {
        for (int i = 0; i < time; i++)
        {
            this.username().clear();
        	this.username().sendKeys(username);
        	
        	this.password().clear();
        	this.password().sendKeys(password);
        	
        	this.login().click();
                	
        }
    }
	
	
	
	
}
