package floow.tests;

import java.io.File;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import floow.util.OldUserDetails;
import floow.util.User;

public class SocialTest {
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
	public void addFriendByEmail() throws InterruptedException {
		Random randomGenerator=new Random();
		String email=user.getAccount().createNewUsername(randomGenerator);
		Assert.assertTrue(user.addFriendByEmail(email));
	}
	@Test(enabled = true, timeOut = 100000)
	public void changeProfileName(){
		Random randomGenerator=new Random();
		String newName=user.getAccount().createRandomFirstName(randomGenerator);
		Assert.assertTrue(user.editProfileName(newName));
	}
}
