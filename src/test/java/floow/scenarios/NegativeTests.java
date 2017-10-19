package floow.scenarios;

import java.io.File;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import floow.constants.CLogin;
import floow.util.User;

public class NegativeTests {
	User user;
	WebDriver driver;
	private static final Logger logger = LoggerFactory.getLogger(NegativeTests.class);
	

	/**
	 * @throws Exception
	 */
	@BeforeTest
	public void setUp() throws Exception, InterruptedException {
		user = new User();
		user.agree();
		driver = user.getDriver();
		String log4jConfigFile = System.getProperty("user.dir")
	              + File.separator + "log4j.properties";
	    PropertyConfigurator.configure(log4jConfigFile);
	}

	/**
	 * @throws Exception
	 */
	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}

	/**
	 * @throws InterruptedException
	 *             TestEP2
	 */
	@Test(enabled = true, timeOut = 100000)
	void notRegisteredtest() throws InterruptedException {
		logger.info("starting test");
		user.invalidLogin();
		Assert.assertEquals(user.notRegisteredLogin(), CLogin.messageNotRegistered, CLogin.alertError);
		logger.info("finished");
	}
}
