package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {

	public WebDriver driver;
	public WebDriverWait wait;

	// Constructor
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	}

	// Wait
	public WebElement waitVisibility(By by) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	// List WebElement
	public List<WebElement> listVisibility1(By by1) {
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by1));
	}

	// Click Method
	public void click(By by) {
		waitVisibility(by).click();

	}

	// Write Text
	public void writeText(By by, String text) {
		waitVisibility(by).sendKeys(text);
	}

	// Read Text
	public String readText(By by) {
		return waitVisibility(by).getText();
	}

	// clear textbox
	public void clearTextBox(By by) {
		waitVisibility(by).clear();
	}

	public void handleDropDown(By by1, String text) throws Exception {
		String expexctedResult = text;
		Thread.sleep(1000);

		List<WebElement> list = listVisibility1(by1);

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().equalsIgnoreCase(expexctedResult)) {
				list.get(i).click();
				// System.out.println("clicked perform " + expexctedResult);
				break;
			}
		}
	}

	// handle dropdown and select 1 available value
	public void handleDropDown1(By by1) throws Exception {

		Thread.sleep(1000);
		List<WebElement> list = listVisibility1(by1);
		for (int i = 0; i < list.size(); i++)
		{
			list.get(0).click();
			break;
		}
	}

	// assert
	public void assertVerify(Object actual, Object expecetd) {
		Assert.assertEquals(actual, expecetd);
	}

}
