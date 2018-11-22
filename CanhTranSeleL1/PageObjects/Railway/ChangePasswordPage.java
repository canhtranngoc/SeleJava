package Railway;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Constant.Constant;

public class ChangePasswordPage extends GeneralPage {

	// Locators
		public final By lblChangePasswordPageHeader = By.xpath("//div[@id='content']/h1");
		
		// Elements
		public WebElement changePasswordPageHeader() {
			return Constant.WEBDRIVER.findElement(lblChangePasswordPageHeader);
		}
	
}
