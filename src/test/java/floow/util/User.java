package floow.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Optional;

import floow.constants.CHomeTab;
import floow.constants.CLogin;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDeviceActionShortcuts;
import io.appium.java_client.android.AndroidKeyCode;
/**
 * contains all functions for different tabs in the app
 * implements the various interfaces corresponding to the tabs
 *
 */
public class User extends AndroidSetup implements ILogin, ISelect, IJourney, IScore, ISocial, IHelp {
	private Accounts account;
	private static final Logger logger = Logger.getLogger(User.class);
	private final int messageLength = 100;
	private final int indexOfGmail = 2;
	private final int enterKey = 66;

	public User() {
		super();
		super.driverInit();
		account = new Accounts(driver, PasswordTestType.NONE);
	}

	public User(String username, String password) {
		super();
		super.driverInit();
		account = new Accounts(driver, username, password);
	}

	public void invalidLogin() {
		logger.info("starting invalid login process");
		boolean finished = false;
		account.waitForVisibilityOf(emailId);
		driver.findElement(emailId).clear();
		driver.findElement(emailId).sendKeys(account.getUsername());
		driver.findElement(password).sendKeys(account.getPassword());
		driver.findElement(login_Button).click();
		driver.findElement(alertTitle).click();
		logger.info("clicked alertitle");
	}

	/**
	 * @return test scenario when user is not registered and tries to login
	 */
	public String notRegisteredLogin() {
		// fail test if text doesnt match
		String message = "matching message received on alert";
		logger.info(message);
		Assert.assertEquals(driver.findElement(messageText).getText(), CLogin.messageNotRegistered, CLogin.alertError);
		String result = driver.findElement(messageText).getText();
		driver.findElement(button).click();
		logger.info("verified message");
		return result;
	}

	public boolean validLogin() {
		logger.info("starting a valid login process");
		account.waitForVisibilityOf(emailId);
		driver.findElement(emailId).clear();
		driver.findElement(emailId).sendKeys(account.getUsername());
		driver.findElement(password).sendKeys(account.getPassword());
		driver.findElement(login_Button).click();
		logger.info("login button clicked");
		account.waitForVisibilityAndClick(closeButton);
		return true;
	}

	public void validLoginAfterRegistering() {
		logger.info("starting a valid login process after new registeration");
		account.waitForVisibilityOf(loginAfterRegister);
		driver.findElement(loginAfterRegister).click();
		account.waitForVisibilityOf(closeButton);
		driver.findElement(closeButton).click();
		logger.info("close button clicked");
	}

	/**
	 * click on create new account
	 */
	public void createAccount() {
		account.waitForVisibilityOf(createAccount);
		driver.findElement(createAccount).click();
	}

	public void registerNewAccount() {
		logger.info("registering a new user with");
		// wait for view to load
		account.waitForVisibilityOf(firstName);
		// finds element by id and sends text
		driver.findElement(firstName).sendKeys(account.getFirstName());
		logger.info("FirstName" + account.getFirstName());
		// typecasting driver to send enter key on native android
		((AndroidDeviceActionShortcuts) driver).pressKeyCode(enterKey);
		driver.findElement(surname).sendKeys(account.getSecondName());
		logger.info("SecondName" + account.getSecondName());
		driver.findElement(dateofbirth).click();
		/*
		 * trying to go as far as 20
		 */
		for (int iterator = 0; iterator < 20; iterator++) {
			driver.findElement(prev).click();
		}
		driver.findElement(okButton).click();
		((AndroidDeviceActionShortcuts) driver).pressKeyCode(enterKey);
		driver.findElement(email).sendKeys(account.getUsername());
		driver.findElement(postcode).sendKeys(account.getPostcode());
		((AndroidDeviceActionShortcuts) driver).pressKeyCode(enterKey);
		driver.findElement(companyName).sendKeys(account.getCompanyName());
		((AndroidDeviceActionShortcuts) driver).pressKeyCode(enterKey);
		driver.findElement(password).sendKeys(account.getPassword());
		((AndroidDeviceActionShortcuts) driver).pressKeyCode(enterKey);
		driver.findElement(comfirmPassword).sendKeys(account.getPassword());
		((AndroidDeviceActionShortcuts) driver).pressKeyCode(enterKey);
		driver.findElement(submitButton).click();

	}

	public boolean agree() {
		logger.info("clicking on agree terms and conditions");
		account.waitForVisibilityOf(userId);
		driver.findElement(userId).click();
		return false;

	}

	public boolean startJourney() {
		logger.info("starting journey");
		account.waitForVisibilityOf(startButton);
		driver.findElement(startButton).click();
		return account.waitForVisibilityOf(stopButton);
	}

	public boolean stopJourney() {
		logger.info("stopping journey");
		account.waitForVisibilityOf(stopButton);
		driver.findElement(stopButton).click();
		account.waitForVisibilityOf(okButton);
		driver.findElement(okButton).click();
		return account.waitForVisibilityOf(startButton);

	}

	public boolean sendfeedback() {
		logger.info("start of feedback messaging");
		account.waitForVisibilityOf(feedbackBtn);
		driver.findElement(feedbackBtn).click();
		account.waitForVisibilityOf(dropDownList);
		driver.findElement(dropDownList).click();
		List<WebElement> choices = driver.findElements(selectType);
		WebElement Scoring = choices.get(indexOfGmail);
		Scoring.click();
		account.waitForClickabilityOf(editBox);
		driver.findElement(editBox).sendKeys(generateRandomMessage());
		account.waitForClickabilityOf(sendBtn);
		driver.findElement(sendBtn).click();
		WebElement Options = driver.findElement(sendOptions);
		List<WebElement> list = Options.findElements(typeOptions);
		WebElement gmailButtton = list.get(indexOfGmail);
		gmailButtton.click();
		// need to change context to native here.
		// account.waitForVisibilityOf(sendEmail);
		try {
			driver.findElement(sendEmail).click();
		} catch (Exception e) {
			// need to figure out a way to change context
		}
		return true;
	}

	public boolean declareEmergency() {
		logger.info("start of declare emergency block");
		// press back three times to reach the home view
		driver.pressKeyCode(AndroidKeyCode.BACK);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		// wait for emergency button
		account.waitForVisibilityOf(emergency);
		driver.findElement(emergency).click();
		account.waitForVisibilityOf(breakDown);
		// click on breakdown
		driver.findElement(breakDown).click();
		account.waitForVisibilityOf(callNow);
		driver.findElement(callNow).click();
		return true;
	}

	public boolean modifyJourney(int journeyNumber) {
		logger.info("Start of journey modification ");
		reachAndSelectJourney(journeyNumber);
		modifyModeOfTransport();
		return true;
	}

	private void reachAndSelectJourney(int journeyNumber) {
		logger.info("selecting journey number " + journeyNumber + "from the top");
		account.waitForVisibilityOf(journeyTabBtn);
		driver.findElement(journeyTabBtn).click();
		account.waitForVisibilityOf(rowElement);
		List<WebElement> journeys = driver.findElements(rowElement);
		logger.info(journeys.size());
		// getting the second journey
		WebElement journeyOne = journeys.get(journeyNumber);
		journeyOne.click();
	}

	private void modifyModeOfTransport() {
		logger.info("updating mode of transport for a given journey");
		account.waitForVisibilityOf(modifyJourneyBtn);
		driver.findElement(modifyJourneyBtn).click();
		account.waitForVisibilityOf(car);
		driver.findElement(train).click();
		account.waitForVisibilityOf(alertOK);
		driver.findElement(alertOK).click();
		account.waitForVisibilityOf(save);
		driver.findElement(save);
	}

	public boolean changeMapView(int journeyNumber) {
		logger.info("changing map view to satellite");
		reachAndSelectJourney(journeyNumber);
		account.waitForVisibilityOf(showMapBtn);
		driver.findElement(showMapBtn).click();
		account.waitForVisibilityOf(satelliteView);
		driver.findElement(satelliteView).click();
		return true;
	}

	public boolean changeScoreToMonthly() {
		logger.info("changing score details to monthly");
		account.waitForVisibilityOf(scoreTabBtn);
		driver.findElement(scoreTabBtn).click();
		account.waitForVisibilityOf(monthlyBtn);
		driver.findElement(monthlyBtn).click();
		return true;
	}

	public boolean openScoreDetails() {
		logger.info("opening score details");
		account.waitForVisibilityOf(scoreTabBtn);
		driver.findElement(scoreTabBtn).click();
		account.waitForVisibilityOf(scoreDetailBtn);
		driver.findElement(scoreDetailBtn).click();
		return true;
	}

	public boolean addFriendByEmail(String email) {
		logger.info("adding friend with email : " + email);
		account.waitForVisibilityAndClick(socialTab);
		account.waitForVisibilityAndClick(friendsBtn);
		account.waitForVisibilityAndClick(addFriendBtn);
		account.waitForVisibilityAndClick(addFriendWithEmail);
		account.waitForVisibilityAndClick(emailTextBox);
		driver.findElement(emailTextBox).sendKeys(email);
		((AndroidDeviceActionShortcuts) driver).pressKeyCode(enterKey);
		account.waitForVisibilityAndClick(nextBtn);
		account.waitForVisibilityAndClick(finishBtn);
		return true;
	}

	public boolean editProfileName(String newName) {
		logger.info("updating profile name with new name : " + newName);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		account.waitForVisibilityAndClick(profileBtn);
		account.waitForVisibilityAndClick(editProfileBtn);
		account.waitForVisibilityAndClick(updateNameBox);
		WebElement name = driver.findElement(updateNameBox);
		name.clear();
		name.sendKeys(newName);
		account.waitForVisibilityAndClick(saveName);
		return true;
	}

	public boolean pauseApp() {
		account.waitForVisibilityAndClick(helpTab);
		List<WebElement> list = driver.findElements(preferencesButton);
		WebElement preferences = list.get(1);
		preferences.click();
		try {
			Dimension screenDim = driver.manage().window().getSize();
			int startPoint = (int) (screenDim.getHeight() * 0.5);
			int scrollPoint = (int) (screenDim.getHeight() * 0.2);
			driver.swipe(0, startPoint, 0, scrollPoint, 1000);
		} catch (Exception e) {
			//Assert.fail("test ran into problem while scrolling");
		}
		account.waitForVisibilityOf(pauseSlider);
		WebElement slider = driver.findElement(pauseSlider);
		driver.tap(1, slider, 10);
		account.waitForVisibilityAndClick(pauseBtn);
		return true;
	}

	/* unit test to check the functionality of the user utility class */
	public static void main(String[] argv) {
		User usr = new User();
		System.out.println("username: " + usr.getAccount().getUsername() + "\n password:"
				+ usr.getAccount().getPassword() + "\n" + usr.getAccount().getPassword().length());
	}

	/**
	 * @return the account
	 */
	public Accounts getAccount() {
		return account;
	}

	/**
	 * @param account
	 *            the account to set
	 */
	public void setAccount(Accounts account) {
		this.account = account;
	}

	/**
	 * @return the driver
	 */
	public WebDriver getDriver() {
		return super.driver;
	}

	private String generateRandomMessage() {
		Random rdm = new Random();
		return RandomStringUtils.randomAlphabetic(messageLength);
	}

}
