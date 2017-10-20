package floow.util;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import floow.constants.CLogin;
/**
 * contains utility functions and details about an account in the app
 * 
 *
 */
public class Accounts extends ActionUtil implements IAccounts {

	private String accountUserID;
	private String accountPassword;
	private String firstName;
	private String secondName;
	private String companyName = "The Floow Ltd.";
	private String postcode = "SK83ZB";
	private int userNameBound = 1000;
	private int passwordMaxLength = 100;
	private int averageLength = 8;

	private static final Logger logger = Logger.getLogger(Accounts.class);

	By emailId = By.id(CLogin.emailId);
	By password = By.id(CLogin.password);
	By login_Button = By.id(CLogin.login_Button);
	By existingUser_login = By.id(CLogin.existingUser_login);
	By alertTitle = By.id(CLogin.alertTitle);
	By messageText = By.id(CLogin.messageText);
	By button = By.id(CLogin.button);
	By createAccount = By.id(CLogin.createAccount);

	protected Accounts(WebDriver driver, PasswordTestType testType) {
		super(driver);
		Random randomGenerator = new Random();
		accountUserID = createNewUsername(randomGenerator);
		this.accountPassword = createPassword(randomGenerator, averageLength, testType);
		this.firstName = "FName" + RandomStringUtils.randomAlphabetic(randomGenerator.nextInt(averageLength));
		this.secondName = "SName" + RandomStringUtils.randomAlphabetic(randomGenerator.nextInt(averageLength));
	}

	protected Accounts(WebDriver driver, String username, String password) {
		super(driver);
		this.accountUserID = username;
		this.accountPassword = password;
	}

	public String createNewUsername(Random randomGenerator) {
		String username = "FloowUser" + String.valueOf(randomGenerator.nextInt(userNameBound)) + "@gmail.com";
		logger.info("creating account user with email " + username);
		return username;
	}

	public String createPassword(Random randomGenerator, int length, PasswordTestType testType) {
		String password = "";
		switch (testType) {
		case MINLENGTH:
			break;
		case MAXLENGTH:
			password = RandomStringUtils.randomAlphanumeric(passwordMaxLength);
			break;
		case NOALPHABET:
			password = RandomStringUtils.randomNumeric(randomGenerator.nextInt(passwordMaxLength));
			break;
		case ALPHABET:
			password = RandomStringUtils.randomAlphabetic(randomGenerator.nextInt(passwordMaxLength));
			break;
		case SPECIALCHARACTER:
			password = RandomStringUtils.random(5, "*%$#@&!,<>~+");
			break;
		default:
			// some length that represents average password size
			password = RandomStringUtils.randomAlphabetic(length) + RandomStringUtils.randomNumeric(1);
		}
		logger.info("creating account user with password " + password);
		return password;
	}
	public String createRandomFirstName(Random randomGenerator){
		String firstName = "FName" + RandomStringUtils.randomAlphabetic(randomGenerator.nextInt(averageLength));
		return firstName;
	}
	public String createRandomSurName(Random randomGenerator){
		String surName = "SName" + RandomStringUtils.randomAlphabetic(randomGenerator.nextInt(averageLength));
		return surName;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return accountUserID;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.accountUserID = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return accountPassword;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.accountPassword = password;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the secondName
	 */
	public String getSecondName() {
		return secondName;
	}

	/**
	 * @param secondName
	 *            the secondName to set
	 */
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName
	 *            the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the postcode
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * @param postcode
	 *            the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

}
