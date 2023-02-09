package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.logs.Log;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	By searchField = By.xpath("//input[@placeholder='Search for your city']");
	By allSearchList = By.xpath("//div[@class='sc-koErNt kRWuDd']/div/ul/li/span/strong");
	String searchResult = "Surat";
	By allMovies = By.xpath("//div[@class='sc-lnhrs7-2 eQezya']/div/a/div/div[3]/div[1]/div");
	String movieName = "Avatar: The Way of Water";

	By bookTicketButton = By.xpath("//div[@class='sc-qswwm9-8 jayiEd']/div/button");
	By selectLanguage = By.xpath("//div[@class='sc-1k6uqqy-0 gZyDCA']/ul/li[1]/section[2]/div/span");
	By selectDate = By.xpath("//div[contains(@class,'slick-list draggable')]/div/li[2]");
	By selectMall = By.xpath("//ul[@id='venuelist']/li/child::div[1]/div[2]/div/div[1]/a");
	By selectMall1 = By.xpath("//ul[@id='venuelist']/li/child::div[2]/div[@class='showtime-pill-wrapper']/div/a");
	String mallName = "Cinepolis: Imperial Square Mall, Surat";
	By selectMovie = By.xpath("//ul[@id='showEvents']/ul/li/div[2]/div[1]/a");
	By time = By.xpath("//ul[@id='showEvents']/ul/li[2]/div[2]/div");
	By acceptButton = By.id("btnPopupAccept");
	By selectSeat = By.xpath("//ul[@id='popQty']/li");
	String expectedSeat = "4";
	By selectNotNowButton = By.xpath("//div[@class='wzrk-button-container']/button[1]");
	By proceed = By.xpath("//div[@id='proceed-Qty']");
	By readMovieName = By.xpath("//a[@id='strEvtName']");
	By readMallName = By.xpath("//span[@id='strVenName']");
	By readDate = By.xpath("//span[@id='strDate']");
	String actualMovieName = null;
	String actualMallName = null;
	String actualDate = null;
	By bookSeat = By.xpath("//table[@class='setmain']/tbody/tr/td[2]/div[@class='seatI']/a[@class='_available']");
	By payforproceed = By.xpath("//div[@Class='__seat-action btn-bar _centered _spaced']/a[1]");
	By getBookingDeatils = By.xpath("//span[@id='TickCat']");
	String actualBooking = null;
	String mallName1 = null;

	public HomePage goToWebsite(String sURL) {
		Log.info("Opening N11 Website.");
		driver.get(sURL);
		return this;
	}

	public HomePage searchBar(String data) throws Exception {
		writeText(searchField, data);
		handleDropDown(allSearchList, searchResult);
		return this;
	}

	public HomePage selectMovie() throws Exception {
		handleDropDown(allMovies, movieName);
		return this;
	}

	public HomePage bookTicket() {
		click(bookTicketButton);
		return this;
	}

	public HomePage language() throws Exception {
		Thread.sleep(3000);
		click(selectLanguage);
		return this;
	}

	public HomePage selectionDate() throws Exception {
		Thread.sleep(2000);
		click(selectDate);
		return this;
	}

	public HomePage selectionMall() throws Exception {
		mallName1 = readText(selectMall);
		System.out.println("Mall Name " + mallName1);
		handleDropDown1(selectMall1);
		return this;

	}

	

	public HomePage selectTime() {
		click(time);
		return this;
	}

	public HomePage clickAcceptButton() {
		click(acceptButton);
		return this;
	}

	public HomePage handleAlert() {
		click(selectNotNowButton);
		return this;
	}

	public HomePage selectionSeat() throws Exception {
		handleDropDown(selectSeat, expectedSeat);
		return this;
	}

	public HomePage selectProceed() {
		click(proceed);
		return this;
	}

	public HomePage getInfo() {
		actualMovieName = readText(readMovieName);
		System.out.println("Movie Name" + actualMovieName);
		assertVerify(actualMovieName, movieName);
		actualMallName = readText(readMallName);
		System.out.println("actualMallName Name" + actualMallName);
		assertVerify(actualMallName, mallName1);
		actualDate = readText(readDate);
		System.out.println("actualDate" + actualDate);
		return this;

	}

	public HomePage booking() throws Exception {
		handleDropDown1(bookSeat);
		List<WebElement> bookSeats = driver.findElements(By.xpath("//table[@class='setmain']/tbody/tr/td[2]/div[@class='seatI']/a[@class='_available _selected']"));
		if(bookSeats.size()!=4)
		{
			handleDropDown1(bookSeat);
		}
		return this;
	}

	public HomePage payProceed() throws Exception {
		Thread.sleep(2000);
		click(payforproceed);

		System.out.println("Test2");
		return this;
	}

	public HomePage verifyBookingInfo() {
		actualBooking = readText(getBookingDeatils);
		System.out.println("actualBooking" + actualBooking);
		return this;
	}
}
