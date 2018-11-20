package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

	
	
public class GeneralPage {
	//Locators
		private final By tabLogin=By.xpath("//a[@href='/Account/Login.cshtml']");
		private final By tabLogout=By.xpath("//a[@href='/Account/Logout']");
		private final By tabBookTicket=By.xpath("//a[@href='/Page/BookTicketPage.cshtml']");
		private final By lblWelcomeMessage=By.xpath("//div[@class='account']");
		private final By lblErrorMessage=By.xpath("//p[@class='message error LoginForm']");
		
		//Elements
			protected WebElement getTabLogin() {
				return Constant.WEBDRIVER.findElement(tabLogin);
			}
			
			protected WebElement getTabLogout() {
				return Constant.WEBDRIVER.findElement(tabLogout);
			}
			
			protected WebElement getTabBookTicket() {
				return Constant.WEBDRIVER.findElement(tabBookTicket);
			}
			
			protected WebElement getLblWelcomeMessage() {
				return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
			}
			
			protected WebElement getLblLoginErrorMsg() {
				return Constant.WEBDRIVER.findElement(lblErrorMessage);
			}
			
			//Methods
			
			public String getWelcomeMessage()
			{
				return this.getLblWelcomeMessage().getText();
			}
			
			public String getErrorMessage()
			{
				return this.getLblLoginErrorMsg().getText();
			}
			
			public LoginPage gotoLoginPage()
			{
				this.getTabLogin().click();
				return new LoginPage();
			}
						
				
}
