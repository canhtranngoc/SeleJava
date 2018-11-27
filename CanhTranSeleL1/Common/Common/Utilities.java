package Common;

import org.testng.Assert;

import Constant.Constant;

import static org.apache.commons.lang3.RandomStringUtils.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.chrome.ChromeDriver;

public class Utilities {

	public static void openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();
	}

	public static void closesAllChromeBrowserWindows() {
		Constant.WEBDRIVER.quit();
	}

	public static void checkTextDisplays(String actualText, String expectedText) {
		Assert.assertEquals(actualText, expectedText, "The text should be: " + expectedText);
	}

	public static String randomString() {
		LocalDateTime currentDateTime = LocalDateTime.now();
		String current = DateTimeFormatter.ofPattern("MMddhhmmssSSS").format(currentDateTime);
		return current;
	}

	public static void checkPageHeader(String actualText, String expectedText) {
		Assert.assertEquals(actualText, expectedText, "The page header should be: " + expectedText);
	}

}
