package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

	
	
public class GeneralPage {
	//Locators
		private final By tabLogin=By.xpath("//a[@href='/Account/Login.cshtml']");
		private final By tabRegister=By.xpath("//span[.='Register']");
		
		private final By tabBookTicket=By.xpath("//a[@href='/Page/BookTicketPage.cshtml']");
		private final By tabLogout=By.xpath("//a[@href='/Account/Logout']");
		
		private final By welcomeMessage=By.xpath("//div[@class='account']");
		
				
		//Elements
			protected WebElement tabLogin() {
				return Constant.WEBDRIVER.findElement(tabLogin);
			}
			
			protected WebElement tabRegister() {
				return Constant.WEBDRIVER.findElement(tabRegister);
			}
											
			protected WebElement tabLogout() {
				return Constant.WEBDRIVER.findElement(tabLogout);
			}
			
			protected WebElement tabBookTicket() {
				return Constant.WEBDRIVER.findElement(tabBookTicket);
			}
			
			protected WebElement welcomeMessage() {
				return Constant.WEBDRIVER.findElement(welcomeMessage);
			}
					
			
			//Methods
			
			public String getWelcomeMessage()
			{
				return this.welcomeMessage().getText();
			}
						
			public LoginPage gotoLoginPage()
			{
				this.tabLogin().click();
				return new LoginPage();
			}
						
			public 	RegisterPage gotoRegisterPage() 
			{
				this.tabRegister().click();
				return new RegisterPage();
			}
}
