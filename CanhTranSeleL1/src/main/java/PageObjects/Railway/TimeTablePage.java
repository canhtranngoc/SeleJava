package PageObjects.Railway;

import org.openqa.selenium.By;

import Common.Common.ElementKeywords;

public class TimeTablePage {
	public void SelectTicketFromTimetable(String departStation, String arriveStation) {
		
		//String depart = String.format("//span[.='%s']", tabName);
		
		By linkBookTicket = By.xpath("//tr/td[2][.='" + departStation + "']/../td[3][.='" + arriveStation + "']/../td[.='book ticket']");
		ElementKeywords.click(linkBookTicket);
		
		//IWebElement linkBookTicket = Constant.Webdriver.FindElement(By.XPath("//tr/td[2][.='" + departStation + "']/../td[3][.='" + arriveStation + "']/../td[.='book ticket']"));
        
       // linkBookTicket.Click();
	}

}
