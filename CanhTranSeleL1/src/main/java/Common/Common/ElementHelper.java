package Common.Common;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Constant.Constant;

public class ElementHelper {

	public boolean isElementDisplayed(By by) {
		try {
			WebElement element = Constant.WEBDRIVER.findElement(by);
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
