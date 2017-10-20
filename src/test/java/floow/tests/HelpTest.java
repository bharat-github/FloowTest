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

public class HelpTest {
	User user;
	WebDriver driver;
	private static final Logger logger = Logger.getLogger(HelpTest.class);

	/**
	 * @throws Exception
	 */
	@BeforeClass
	public void init() throws Exception {

		user = new User(OldUserDetails.getUsername(), OldUserDetails.getPassword());
		driver = user.getDriver();
		logFileSetup();
		user.agree();
		user.validLogin();

	}

	/**
	 * @throws Exception
	 */
	@AfterClass
	public void cleanUp() throws Exception {
		driver.quit();
	}

	@Test(enabled = true, timeOut = 100000)
	public void pauseApp() {
		Assert.assertTrue(user.pauseApp());
	}
	
	private void logFileSetup(){
		String log4jConfigFile = System.getProperty("user.dir") + File.separator + "log4j.properties";
		PropertyConfigurator.configure(log4jConfigFile);
	}
}
