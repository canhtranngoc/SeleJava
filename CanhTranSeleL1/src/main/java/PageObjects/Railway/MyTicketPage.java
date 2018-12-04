package PageObjects.Railway;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Common.ElementKeywords;
import Common.Constant.Constant;

public class MyTicketPage extends GeneralPage {
	
	// Locators
	public final By lblMyTicketPageHeader = By.xpath("//div[@id='content']/h1");
	
	
	// Methods
	public void CancelaTicKet(String departStation, String arriveStation, String departDate) {
		By buttonCancel = By.xpath("//tr/td[.='" + departStation + "']/../td[.='" + arriveStation + "']/../td[.='" + departDate + "']/../td/input[@value='Cancel']");
		//ElementKeywords.click(buttonCancel);
		ElementKeywords.click(By.xpath("//input[@value='Cancel']"));
		Alert alert = Constant.WEBDRIVER.switchTo().alert();
		alert.accept();
	
}
	
}
