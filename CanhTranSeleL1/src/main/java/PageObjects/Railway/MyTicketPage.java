package PageObjects.Railway;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Common.Common.ElementKeywords;
import Common.Constant.Constant;

public class MyTicketPage extends GeneralPage {

	// Locators
	public final By lblMyTicketPageHeader = By.xpath("//div[@id='content']/h1");
	public final By txtDepartDate = By.name("FilterDpDate");
	public final By buttonApplyFilter = By.xpath("//input[@type='submit' and @value='Apply filter']");

	// Methods

	public WebElement getCancelButton(String departStation, String arriveStation, String departDate) {
		return Constant.WEBDRIVER.findElement(By.xpath(String.format(
				"//td[normalize-space()='%s']/following-sibling::td[normalize-space()='%s']/following-sibling::td[normalize-space()='%s']/following-sibling::td//input[@value = 'Cancel']",
				departStation, arriveStation, departDate)));
	}

	public void CancelaTicKet(String departStation, String arriveStation, String departDate) {
		By buttonCancel = By.xpath(String.format(
				"//td[normalize-space()='%s']/following-sibling::td[normalize-space()='%s']/following-sibling::td[normalize-space()='%s']/following-sibling::td//input[@value = 'Cancel']",
				departStation, arriveStation, departDate));
		ElementKeywords.click(buttonCancel);
		Alert alert = Constant.WEBDRIVER.switchTo().alert();
		alert.accept();
	}

	public void filterTictketWithDepartDate(String departDate) {
		ElementKeywords.enter(txtDepartDate, departDate);
		ElementKeywords.click(buttonApplyFilter);
	}

    public Boolean checkTicketWithDepartDate(String departDate)
    {
		return null;

    }
    
   
    
}
