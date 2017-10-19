package floow.scenarios;

import java.io.File;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import floow.constants.CLogin;
import floow.pages.AcceptPage;
import floow.util.User;

/**
 * @author bharat anand The test class with scenarios implemented
 */
public class NewRegistrationTests {
	User user;
	WebDriver driver;
	Logger logger= Logger.getLogger(NewRegistrationTests.class);
	/**
	 * @throws Exception
	 */
	@BeforeTest
	public void setUp() throws Exception {
		user = new User();
		driver = user.getDriver();
		user.agree();
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
	 *             TestEP1
	 */
	@Test(dependsOnMethods = { "registerNew" }, enabled = true,timeOut=100000)
	public void registeredLoginAfterResgistering() throws InterruptedException {
		user.validLoginAfterRegistering();
	}

	/**
	 * @throws InterruptedException
	 *             TestAcc1
	 */
	@Test( enabled = true,timeOut=100000)
	void registerNew() throws InterruptedException {
		user.createAccount();
		user.registerNewAccount();
	}
}
