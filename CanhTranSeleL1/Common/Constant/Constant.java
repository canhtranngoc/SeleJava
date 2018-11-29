package Constant;

import java.sql.Date;
import Common.Utilities;
import java.util.Calendar;
import java.time.ZonedDateTime;


import org.openqa.selenium.WebDriver;

public class Constant {
	public static WebDriver WEBDRIVER;
	public static final String RAILWAY_URL = "https://dbdeec00.ngrok.io/Page/HomePage.cshtml";
	public static final String VALID_USERNAME = "canh.tran@logigear.com";
	public static final String INVALID_USERNAME = "canh.tran.ngoc@logigear.com";
	public static final String BLANK_USERNAME = "";
	public static final String VALID_PASSWORD = "12345678";
	public static final String INVALID_PASSWORD = "11111111";
	public static final String BLANK_PASSWORD = "";
	public static final String NEW_PASSWORD = "12345678";
	public static final String RANDOM_EMAIL = "canh+"+ Utilities.randomString()+"@logigear.com";	
	public static final String VALID_PID = "123456789";
	public static final int SERVERAL_TIME_LOGIN_FAIL = 4;

	public class Message {
		public static final String WELLCOME_MESSAGE = "Welcome " + VALID_USERNAME;
		public static final String LOGIN_BLANK_USERNAME_ERROR_MESSAGE = "There was a problem with your login and/or errors exist in your form.";
		public static final String LOGIN_FOR_SERVERAL_TIMES_ERROR_MESSAGE = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
		public static final String LOGIN_INVALID_PASSWORD_ERROR_MESSAGE = "There was a problem with your login and/or errors exist in your form.";
		public static final String INACTIVE_ACCOUNT_LOGIN_ERROR_MESSAGE = "Invalid username or password. Please try again.";
		public static final String REGISTER_ERROR_MESSAGE = "There're errors in the form. Please correct the errors and try again.";
		public static final String REGISTER_SUCCESS_MESSAGE = "Thank you for registering your account";
		public static final String CHANGE_PASSWORD_SUCCESS_MESSAGE = "Your password has been updated";	
		public static final String INVALID_PASSWORD_MESSAGE="Invalid password length.";
		public static final String INVALID_ID_MESSAGE="Invalid ID length.";
	}
	
	public class PageHeader {
		public static final String HOME_PAGE = "Welcome to QA Railway";
		public static final String FAQ_PAGE = "Frequently Asked Questions";
		public static final String CONTACT_PAGE = "Contact information";
		public static final String TIMETABLE_PAGE = "Train Timetable";
		public static final String TICKET_PRICE_PAGE = "Train ticket price list";
		public static final String BOOK_TICKET_PAGE = "Book ticket";
		public static final String MY_TICKET_PAGE = "Manage ticket";
		public static final String CHANGE_PASSWORD_PAGE = "Change password";
		public static final String LOGIN_PAGE = "Login page";
	}

	public static enum TAB_NAME {
		HOME("Home"), 
		FAQ("FAQ"),
		CONTACT("Contact"),
		TIMETABLE("Timetable"),
		TICKET_PRICE("Ticket price"),
		BOOK_TICKET("Book ticket"),
		REGISTER("Register"),
		LOGIN("Login"), 
		LOGOUT("Log out"), 		 
		MYTICKET("My ticket"), 
		CHANGE_PASSWORD("Change password");
		
		private String tabName;

		private TAB_NAME(String tabName) {
			this.tabName = tabName;
		}

		public String getValue() {
			return tabName;
		}
	}
	
	public static enum DEPART_STATION {
		SAI_GON("Sài Gòn"), 
		PHAN_THIET("Phan Thiết"),
		NHA_TRANG("Nha Trang"),
		DA_NANG("Đà Nẵng"),
		HUE("Huế"),
		QUANG_NGAI("Quảng Ngãi");
		
		private String departStation;

		private DEPART_STATION(String departStation) {
			this.departStation = departStation;
		}

		public String getValue() {
			return this.departStation;
		}
	}
	
	public static enum ARRIVE_STATION {
		SAI_GON("Sài Gòn"), 
		PHAN_THIET("Phan Thiết"),
		NHA_TRANG("Nha Trang"),
		DA_NANG("Đà Nẵng"),
		HUE("Huế"),
		QUANG_NGAI("Quảng Ngãi");
		
		private String arriveStation;

		private ARRIVE_STATION(String arriveStation) {
			this.arriveStation = arriveStation;
		}

		public String getValue() {
			return this.arriveStation;
		}
	}
	
	public static enum SEAT_TYPE {
		HARD_SEAT("Hard seat"), 
		SORT_SEAT("Soft seat"),
		SORT_SEAT_WITH_AIR_CONDITINER("Soft seat with air conditioner"),
		HARD_BED("Hard bed"),
		SORT_BED("Soft bed"),
		SORT_BED_WITH_AIR_CONDITINER("Soft bed with air conditioner");
		
		private String seatType;

		private SEAT_TYPE(String seatType) {
			this.seatType = seatType;
		}

		public String getValue() {
			return this.seatType;
		}
	}
	
}
