package floow.tests;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.DependsOn;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import floow.util.OldUserDetails;
import floow.util.User;

public class JourneyTest {
	User user;
	WebDriver driver;
	private static final Logger logger = Logger.getLogger(JourneyTest.class);

	/**
	 * @throws Exception
	 */
	@BeforeClass
	public void init() throws Exception {

		user = new User(OldUserDetails.getUsername(), OldUserDetails.getPassword());
		driver = user.getDriver();
		user.agree();
		String log4jConfigFile = System.getProperty("user.dir") + File.separator + "log4j.properties";
		PropertyConfigurator.configure(log4jConfigFile);

	}

	/**
	 * @throws Exception
	 */
	@AfterClass
	public void cleanUp() throws Exception {
		driver.quit();
	}

	/**
	 * @throws InterruptedException
	 *             TestEP1
	 */
	@Test(enabled = true, timeOut = 100000)
	public void startJourney() throws InterruptedException {
		logger.info(
				"using " + OldUserDetails.getUsername() + " and " + OldUserDetails.getPassword() + " for logging in");
		Assert.assertTrue(user.validLogin());
		Assert.assertTrue(user.startJourney());
	}
	@Test(enabled = true,dependsOnMethods={"startJourney"},timeOut = 100000)
	public void stopJourney() throws InterruptedException {
		Assert.assertTrue(user.stopJourney());
	}
	@Test(enabled= true, dependsOnMethods={"stopJourney"},timeOut=100000)
	public void modifyJourneyType(){
		//hardcode to pick up the second from top
		Assert.assertTrue(user.modifyJourney(2));
	}
	@Test
	public void changeMapView(){
		//hardcode to pick up the second from top
		Assert.assertTrue(user.changeMapView(2));
	}
}
