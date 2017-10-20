package floow.tests;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import floow.util.OldUserDetails;
import floow.util.User;

public class ScoreTest {
	User user;
	WebDriver driver;
	private static final Logger logger = Logger.getLogger(ScoreTest.class);

	/**
	 * @throws Exception
	 */
	@BeforeClass
	private void init() throws Exception {

		user = new User(OldUserDetails.getUsername(), OldUserDetails.getPassword());
		driver = user.getDriver();
		user.agree();
		String log4jConfigFile = System.getProperty("user.dir") + File.separator + "log4j.properties";
		PropertyConfigurator.configure(log4jConfigFile);
		user.validLogin();

	}

	/**
	 * @throws Exception
	 */
	@AfterClass
	public void cleanUp() throws Exception {
		// driver.quit();
	}

	@Test
	public void changeScoreToMonthly() {
		Assert.assertTrue(user.changeScoreToMonthly());
	}
	@Test
	private void openScoreDetails() {
		Assert.assertTrue(user.openScoreDetails());
	}
}
