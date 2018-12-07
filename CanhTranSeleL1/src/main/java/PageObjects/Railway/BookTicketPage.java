package PageObjects.Railway;

import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import Common.Common.ElementKeywords;
import Common.Constant.Constant.TabName;

public class BookTicketPage extends GeneralPage {
	// Locators
	private final By dropdownDepartDate = By.name("Date");
	private final By dropdownDepartStation = By.name("DepartStation");
	private final By dropdownArriveStation = By.name("ArriveStation");
	private final By dropdownSeatType = By.name("SeatType");
	private final By dropdownTicketAmount = By.name("TicketAmount");
	private final By btnBookTicket = By.xpath("//input[@value='Book ticket']");
	private final By selectedDepartSation = By.xpath("//select[@name='DepartStation']//option[@selected='selected']");
	private final By selectedArriveStation = By.xpath("//select[@name='ArriveStation']//option[@selected='selected']");
	private final By lblSuccessMessage = By.xpath("//h1");

	private final By cellBookTicketDepartStation = By
			.xpath("//td[(count(//tr/th[.='Depart Station']/preceding-sibling::th)+1)]");
	private final By cellBookTicketArriveStation = By
			.xpath("//td[(count(//tr/th[.='Arrive Station']/preceding-sibling::th)+1)]");
	private final By cellBookTicketSeatType = By.xpath("//td[(count(//tr/th[.='Seat Type']/preceding-sibling::th)+1)]");
	private final By cellBookTicketAmount = By.xpath("//td[(count(//tr/th[.='Amount']/preceding-sibling::th)+1)]");

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

	public void BookTickets(int numberOfTicket) {

		String departDate;

		for (int i = 1; i <= numberOfTicket; i++) {
			departDate = ElementKeywords.getText(By.xpath("//select[@name='Date']/option[@value='" + (i + 2) + "']"));
			ElementKeywords.select(dropdownDepartDate, departDate);
			ElementKeywords.click(btnBookTicket);
			this.gotoPage(TabName.BOOK_TICKET);
		}
	}

	public void checkBookTicketValue(String departStation, String arriveStation, String seatType, String ticketAmount) {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(ElementKeywords.getText(cellBookTicketDepartStation), departStation);
		softAssert.assertEquals(ElementKeywords.getText(cellBookTicketArriveStation), arriveStation);
		softAssert.assertEquals(ElementKeywords.getText(cellBookTicketSeatType), seatType);
		softAssert.assertEquals(ElementKeywords.getText(cellBookTicketAmount), ticketAmount);
		softAssert.assertAll();
	}

	public String getSuccessMessage() {
		return ElementKeywords.getText(lblSuccessMessage);
	}

	public String getDepartStationValue() {
		return ElementKeywords.getText(selectedDepartSation);
	}

	public String getArriveStationValue() {
		return ElementKeywords.getText(selectedArriveStation);
	}

}
