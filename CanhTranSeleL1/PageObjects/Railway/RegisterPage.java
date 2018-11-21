package Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Constant.Constant;

public class RegisterPage extends GeneralPage {
	
		//Locators	
		private final By txtEmail = By.xpath("//input[@name='email']");
		private final By txtPassword = By.xpath("//input[@name='password']");
		private final By txtConfirmPassword = By.xpath("//input[@name='confirmPassword']");
		private final By txtpid = By.xpath("//input[@name='pid']");
		private final By buttonRegister=By.xpath("//input[@value='Register']");
		private final By lblThanksRegisteringMessage=By.xpath("//div[@id='content']/h1");
		
		
		//Elements	
		public WebElement email() 
		{
			return Constant.WEBDRIVER.findElement(txtEmail);
		}
		
		public WebElement password() 
		{
			return Constant.WEBDRIVER.findElement(txtPassword);
		}
		
		public WebElement confirmPassword() 
		{
			return Constant.WEBDRIVER.findElement(txtConfirmPassword);
		}

		public WebElement pid() 
		{
			return Constant.WEBDRIVER.findElement(txtpid);
		}
		
		public WebElement register() 
		{
			return Constant.WEBDRIVER.findElement(buttonRegister);
		}
		
		public WebElement thanksRegisteringMessage() 
		{
			return Constant.WEBDRIVER.findElement(lblThanksRegisteringMessage);
		}
		
		
		
		//Methods
		public void registerAccount(String email, String password, String confirmPassword, String pid) 
		{
			this.email().clear();
			this.email().sendKeys(email);
			
			this.password().clear();
			this.password().sendKeys(password);
			
			this.confirmPassword().clear();
			this.confirmPassword().sendKeys(confirmPassword);
			
			this.pid().clear();
			this.pid().sendKeys(pid);
			
			this.register().click();
		}
		
		public String getThanksRegisteringMessage()
		{
			return this.thanksRegisteringMessage().getText();
		}
}


