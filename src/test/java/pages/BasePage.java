package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;

/**
 * @author bharat anand. 
 * 		   Basic class that provides actions utilised on various
 *         pages of the test app
 */
public class BasePage {

	protected WebDriver driver;

	/**
	 * @param driver
	 */
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * @param locator
	 */
	protected void waitForVisibilityOf(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/**
	 * @param locator
	 */
	protected void waitForClickabilityOf(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	/**
	 * scroll functionality if needed
	 */
	public void scrollPageUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, Double> swipeObject = new HashMap<String, Double>();
		swipeObject.put("startX", 0.50);
		swipeObject.put("startY", 0.95);
		swipeObject.put("endX", 0.50);
		swipeObject.put("endY", 0.01);
		swipeObject.put("duration", 3.0);
		js.executeScript("mobile: swipe", swipeObject);
	}
}
