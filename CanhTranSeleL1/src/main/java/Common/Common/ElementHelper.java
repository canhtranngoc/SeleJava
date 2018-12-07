package Common.Common;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Common.Constant.Constant;

public class ElementHelper {

	public static boolean isElementDisplayed(WebElement webElement) {
		try {
			WebElement element = Constant.WEBDRIVER.findElement((By) webElement);
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public static void waitElementVisible(By locator, int seconds) {
		(new WebDriverWait(Constant.WEBDRIVER, seconds)).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
}
