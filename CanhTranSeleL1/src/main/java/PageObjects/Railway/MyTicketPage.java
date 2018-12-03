package PageObjects.Railway;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Constant.Constant;

public class MyTicketPage extends GeneralPage {
	
	// Locators
	public final By lblMyTicketPageHeader = By.xpath("//div[@id='content']/h1");
	
	// Elements
	public WebElement myTicketPageHeader() {
		return Constant.WEBDRIVER.findElement(lblMyTicketPageHeader);
	}
	
	// Methods
	public String getMyTicketPageHeader() {
		return this.myTicketPageHeader().getText();
	}
	
}
