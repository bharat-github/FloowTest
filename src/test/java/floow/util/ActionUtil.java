package floow.util;

import java.util.HashMap;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import floow.tests.NegativeTests;
/**
 * contains helper functions that help in identification of webelements
 * 
 *
 */
public class ActionUtil {
	protected WebDriver driver;
	private static final Logger logger = LoggerFactory.getLogger(ActionUtil.class);
	protected ActionUtil(WebDriver driver){
		this.driver=driver;
	}

	/**
	 * @param locator
	 */
	protected boolean waitForVisibilityOf(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}
		catch (Exception e){
			logger.error("exception");
			Assert.fail();
		}
		
		return true;
	}
	protected boolean waitForVisibilityAndClick(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			driver.findElement(locator).click();
		}
		catch (Exception e){
			logger.error("exception");
			Assert.fail();
		}
		
		return true;
	}


	/**
	 * @param locator
	 */
	protected boolean waitForClickabilityOf(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		return true;
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
