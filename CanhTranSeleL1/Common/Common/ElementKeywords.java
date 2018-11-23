package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class ElementKeywords {

	public static void enter(By by, String value) {
		WebElement element = Constant.WEBDRIVER.findElement(by);
		element.clear();
		element.sendKeys(value);
	}
}