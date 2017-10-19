package floow.util;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Optional;

import floow.constants.CLogin;
import floow.pages.AcceptPage;
import floow.scenarios.AndroidSetup;
import io.appium.java_client.android.AndroidDeviceActionShortcuts;

public class User extends AndroidSetup implements ILogin {
	private Accounts account;
	private static final Logger logger=Logger.getLogger(User.class);

	public User() {
		super();
		try {
			super.prepareAndroidForAppium();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		account = new Accounts(driver, PasswordTest.NONE);
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
	 * @return test scenario when user is not registerd and tries to login
	 */
	public String notRegisteredLogin() {
		// fail test if text doesnt match
		String message="matching message received on alert";
		logger.info(message);
		Assert.assertEquals(driver.findElement(messageText).getText(), CLogin.messageNotRegistered, CLogin.alertError);
		String result=driver.findElement(messageText).getText();
		driver.findElement(button).click();
		logger.info("verified message");
		return result;
	}

	public void validLogin() {
		logger.info("starting a valid login process");
		account.waitForVisibilityOf(emailId);
		driver.findElement(emailId).clear();
		driver.findElement(emailId).sendKeys(account.getUsername());
		driver.findElement(password).sendKeys(account.getPassword());
		driver.findElement(login_Button).click();
		logger.info("login button clicked");
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

	public void registerNewAccount(){
		account.waitForVisibilityOf(firstName);
		driver.findElement(firstName).sendKeys(account.getFirstName());
		((AndroidDeviceActionShortcuts) driver).pressKeyCode(66);
		driver.findElement(surname).sendKeys(account.getSecondName());
		driver.findElement(dateofbirth).click();
		/*
		 * trying to go as far as 20
		 */
		for(int iterator=0;iterator<20;iterator++){
			driver.findElement(prev).click();
		}
		driver.findElement(okButton).click();
		((AndroidDeviceActionShortcuts) driver).pressKeyCode(66);
		driver.findElement(email).sendKeys(account.getUsername());
		driver.findElement(postcode).sendKeys(account.getPostcode());
		((AndroidDeviceActionShortcuts) driver).pressKeyCode(66);
		driver.findElement(companyName).sendKeys(account.getCompanyName());
		((AndroidDeviceActionShortcuts) driver).pressKeyCode(66);
		driver.findElement(password).sendKeys(account.getPassword());
		((AndroidDeviceActionShortcuts) driver).pressKeyCode(66);
		driver.findElement(comfirmPassword).sendKeys(account.getPassword());
		((AndroidDeviceActionShortcuts) driver).pressKeyCode(66);
		driver.findElement(submitButton).click();
		
	}
	public boolean agree(){
		account.waitForVisibilityOf(userId);
		driver.findElement(userId).click();
		return false;
		
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
}
