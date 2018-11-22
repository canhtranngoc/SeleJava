package Constant;

import java.sql.Date;
import Common.Utilities;

import org.openqa.selenium.WebDriver;


public class Constant {
	public static WebDriver WEBDRIVER;
	public static final String RAILWAY_URL = "https://1c5fcd6f.ngrok.io";
	public static final String VALID_USERNAME = "canh.tran@logigear.com";
	public static final String INVALID_USERNAME = "canh.tran.ngoc@logigear.com";
	public static final String BLANK_USERNAME = "";
	
	public static final String VALID_PASSWORD = "12345678";
	public static final String INVALID_PASSWORD = "11111111";
	public static final String BLANK_PASSWORD = "";
	public static final String NEW_PASSWORD = "123456789";
	
	public static final String RANDOM_EMAIL=Utilities.randomEmail();
	public static final String VALIDPID="123456789";
	
	public static final String welcomeMessage = "Welcome " + VALID_USERNAME;
		
	public static final String errorLoginMessageBlankUsername = "There was a problem with your login and/or errors exist in your form.";
	public static final String errorLoginMessageForServeralTimes = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
    public static final String errorLoginMessageInvalidPassword = "There was a problem with your login and/or errors exist in your form.";
	
    public static final String thanksRegisteringMessage = "Thank you for registering your account";
    
    public static final int serveralTimeLoginFail = 4;
}
