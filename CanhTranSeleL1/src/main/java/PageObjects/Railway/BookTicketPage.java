package PageObjects.Railway;
import org.openqa.selenium.By;
import Common.Common.ElementKeywords;

public class BookTicketPage extends GeneralPage {
	// Locators
	private final By dropdownDepartDate = By.name("Date");
	private final By dropdownDepartStation = By.name("DepartStation");
	private final By dropdownArriveStation = By.name("ArriveStation");
	private final By dropdownSeatType = By.name("SeatType");
	private final By dropdownTicketAmount = By.name("TicketAmount");
	private final By btnBookTicket = By.xpath("//input[@value='Book ticket']");
	//private final By lblSuccessMessage = By.xpath("//h1[.='Ticket booked successfully!']");

	// Methods
	public void BookTickets(String departDate, String departStation, String arriveStation, String seatType,
			String ticketAmount) {
		ElementKeywords.select(dropdownDepartDate, departDate);
		ElementKeywords.select(dropdownDepartStation, departStation);
		ElementKeywords.select(dropdownArriveStation, arriveStation);
		ElementKeywords.select(dropdownSeatType, seatType);
		ElementKeywords.select(dropdownTicketAmount, ticketAmount);
		ElementKeywords.click(btnBookTicket);
	}

}
