package Common.Common;

import Common.Constant.Constant;

import java.awt.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Message;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Utilities {
	public static EmailUtils emailUtils;

	public static String getProjectPath() {
		return System.getProperty("user.dir");
	}

	public static void openBrowser() {
		System.setProperty("webdriver.chrome.driver",
				Utilities.getProjectPath() + "\\src\\main\\java\\Executables\\chromedriver.exe");
		Constant.WEBDRIVER = new ChromeDriver();
		Constant.WEBDRIVER.manage().window().maximize();
	}

	public static void closesAllBrowsers() {
		Constant.WEBDRIVER.quit();
	}

	public void connectToMail() {
		try {
			emailUtils = new EmailUtils("canhtn92@gmail.com", "canh6789", "smtp.gmail.com",
					EmailUtils.EmailFolder.INBOX);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void openResetPasswordlink() {
		Constant.WEBDRIVER.get(EmailUtils.getLinkWithinMail().replace(":8888", ""));
	}
	





}
